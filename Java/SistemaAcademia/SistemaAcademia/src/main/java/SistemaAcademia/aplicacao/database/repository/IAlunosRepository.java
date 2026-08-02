package SistemaAcademia.aplicacao.database.repository;

import SistemaAcademia.aplicacao.database.model.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IAlunosRepository extends JpaRepository<AlunoEntity, Integer> {
    Optional<AlunoEntity> findByEmail(String email);

    @Query("""
        SELECT a FROM AlunoEntity a JOIN FETCH a.avaliacaoFisica
""")
    Optional<AlunoEntity> findByIdandFetch(Integer alunoId);
}
