package SistemaAcademia.aplicacao.Service;

import SistemaAcademia.aplicacao.database.model.AlunoEntity;
import SistemaAcademia.aplicacao.database.model.AvaliacaoFisicaEntity;
import SistemaAcademia.aplicacao.database.model.TreinosEntity;
import SistemaAcademia.aplicacao.database.repository.IAlunosRepository;
import SistemaAcademia.aplicacao.database.repository.IAvaliacaoFisica;
import SistemaAcademia.aplicacao.database.repository.ITreinosRepository;
import SistemaAcademia.aplicacao.dto.AlunoDto;
import SistemaAcademia.aplicacao.exception.BadRequestException;
import SistemaAcademia.aplicacao.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final IAlunosRepository alunosRepository;
    private final ITreinosRepository treinosRepository;
    private final IAvaliacaoFisica avaliacaoFisica;


   public void criarAluno(AlunoDto alunoDto) throws BadRequestException{
       AlunoEntity aluno = alunosRepository.findByEmail(alunoDto.getEmail())
               .orElse(null);
       if (aluno != null){
           throw new BadRequestException("Aluno já está cadastrado");
       }

       alunosRepository.save(AlunoEntity.builder()
               .nome(alunoDto.getNome())
               .email(alunoDto.getEmail())
               .build());
    }

    public AvaliacaoFisicaEntity getAvaliacao(Integer alunoId) throws NotFoundException{
        AlunoEntity buscarAlunoPorId = alunosRepository.findById(alunoId)
               .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacaoFisicaEntity avaliacao = buscarAlunoPorId.getAvaliacaoFisica();

        if(avaliacao == null){
            throw new NotFoundException("Esse aluno não tem avaliacao");
        }

        return avaliacao;

    }

    @Transactional(rollbackFor = Exception.class)
    public void deletarAluno(Integer alunoId) throws Exception{
       AlunoEntity aluno = alunosRepository.findById(alunoId)
               .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        List<Integer> treinoAlunosIds = aluno.getTreinos()
                .stream().map(TreinosEntity::getId).toList();

        treinosRepository.deleteAllById(treinoAlunosIds);

        alunosRepository.deleteById(alunoId);

        avaliacaoFisica.deleteById(aluno.getAvaliacaoFisica().getId());
    }


}
