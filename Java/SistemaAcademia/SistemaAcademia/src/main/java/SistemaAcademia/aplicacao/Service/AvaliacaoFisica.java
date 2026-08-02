package SistemaAcademia.aplicacao.Service;

import SistemaAcademia.aplicacao.database.model.AlunoEntity;
import SistemaAcademia.aplicacao.database.model.AvaliacaoFisicaEntity;
import SistemaAcademia.aplicacao.database.repository.IAlunosRepository;
import SistemaAcademia.aplicacao.database.repository.IAvaliacaoFisica;
import SistemaAcademia.aplicacao.dto.AvaliacaoFisicaDto;
import SistemaAcademia.aplicacao.exception.BadRequestException;
import SistemaAcademia.aplicacao.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AvaliacaoFisica {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacaoFisica avaliacaoFisicaRepository;

    public void criarAvalicao(AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException
        , BadRequestException{
        AlunoEntity aluno = alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

                AvaliacaoFisicaEntity avaliacao = aluno.getAvaliacaoFisica();
                if(avaliacao != null){
                    throw new BadRequestException("Essa avaliacao ja esta cadastrada");
                }

                avaliacao = AvaliacaoFisicaEntity.builder()
                        .altura(avaliacaoFisicaDto.getAltura())
                        .percentualGorduraCorporal(avaliacaoFisicaDto.getPorcentagemGorduraCorporal())
                        .peso(avaliacaoFisicaDto.getPeso())
                        .build();

                aluno.setAvaliacaoFisica(avaliacao);
                alunosRepository.save(aluno);

    }

    public List<AvaliacaoFisicaEntity> listaAvaliacoes(){
        return avaliacaoFisicaRepository.findAll();
    }
}
