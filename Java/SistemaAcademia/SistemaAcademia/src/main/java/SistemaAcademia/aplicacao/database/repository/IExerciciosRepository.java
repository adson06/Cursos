package SistemaAcademia.aplicacao.database.repository;

import SistemaAcademia.aplicacao.database.model.ExercíciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IExerciciosRepository extends JpaRepository<ExercíciosEntity, Integer> {

    List<ExercíciosEntity> findAllByGrupoMuscular(String grupoMuscular);
}
