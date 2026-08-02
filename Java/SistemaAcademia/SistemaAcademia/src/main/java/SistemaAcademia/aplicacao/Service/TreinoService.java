package SistemaAcademia.aplicacao.Service;


import SistemaAcademia.aplicacao.database.model.AlunoEntity;
import SistemaAcademia.aplicacao.database.model.ExercíciosEntity;
import SistemaAcademia.aplicacao.database.model.TreinosEntity;
import SistemaAcademia.aplicacao.database.repository.IAlunosRepository;
import SistemaAcademia.aplicacao.database.repository.IExerciciosRepository;
import SistemaAcademia.aplicacao.database.repository.ITreinosRepository;
import SistemaAcademia.aplicacao.dto.ExercicioDTO;
import SistemaAcademia.aplicacao.dto.TreinoDto;
import SistemaAcademia.aplicacao.exception.BadRequestException;
import SistemaAcademia.aplicacao.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {
        private final ITreinosRepository treinosRepository;
        private final IAlunosRepository alunosRepository;
        private IExerciciosRepository exerciciosRepository;

        public void criarTreino(TreinoDto treinoDto) throws NotFoundException, BadRequestException {
            Set<ExercíciosEntity> exercicios = new HashSet<>();

            AlunoEntity aluno = alunosRepository.findById(treinoDto.getAlunoId())
                    .orElseThrow(() -> new NotFoundException("Aluno não Encontrado"));

            TreinosEntity treino = treinosRepository.findByNomeAndAlunoId(treinoDto.getNome(),
                    treinoDto.getAlunoId())
                            .orElse(null);
            if (treino != null){
                throw new BadRequestException("Esse treino já foi cadastrado");
            }
            for (Integer exercicioId : treinoDto.getExerciciosIds()) {
                ExercíciosEntity exercicio = exerciciosRepository.findById(exercicioId)
                        .orElseThrow(() -> new NotFoundException
                                (String.format("Exercício %s não encontrado", exercicioId)));

                exercicios.add(exercicio);
            }
                treino = TreinosEntity.builder()
                        .nome(treinoDto.getNome())
                        .aluno(aluno)
                        .exercicio(exercicios)
                        .build();

                treinosRepository.save(treino);
            }
}
