package SistemaAcademia.aplicacao.Service;

import SistemaAcademia.aplicacao.database.model.ExercíciosEntity;
import SistemaAcademia.aplicacao.database.repository.IExerciciosRepository;
import SistemaAcademia.aplicacao.dto.ExercicioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExercicioService {

    private final IExerciciosRepository exerciciosRepository;

    public List<ExercíciosEntity> buscarTodos(){
        return exerciciosRepository.findAll();
    }

    public ExercíciosEntity criarExercicio(ExercicioDTO exercicioDTO){
        ExercíciosEntity exercícios = ExercíciosEntity.builder()
                .nome(exercicioDTO.getNome())
                .grupoMuscular(exercicioDTO.getGrupoMuscular())
                .build();

        return exerciciosRepository.save(exercícios);
    }

    public List<ExercíciosEntity> listarPorGrupoMuscular(String grupoMuscular){
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);

    }


}
