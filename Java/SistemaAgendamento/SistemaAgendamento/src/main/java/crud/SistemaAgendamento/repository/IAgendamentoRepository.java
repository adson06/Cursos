package crud.SistemaAgendamento.repository;

import crud.SistemaAgendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
