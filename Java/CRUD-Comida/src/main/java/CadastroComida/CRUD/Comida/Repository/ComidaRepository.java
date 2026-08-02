package CadastroComida.CRUD.Comida.Repository;

import CadastroComida.CRUD.Comida.model.Comida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComidaRepository extends JpaRepository<Comida, Long>{



}
