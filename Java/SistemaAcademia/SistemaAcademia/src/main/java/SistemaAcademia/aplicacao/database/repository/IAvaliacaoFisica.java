package SistemaAcademia.aplicacao.database.repository;

import SistemaAcademia.aplicacao.database.model.AvaliacaoFisicaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAvaliacaoFisica extends JpaRepository<AvaliacaoFisicaEntity, Integer> {
}
