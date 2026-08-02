package SistemaAcademia.aplicacao.Controller;

import SistemaAcademia.aplicacao.Service.ExercicioService;
import SistemaAcademia.aplicacao.database.model.ExercíciosEntity;
import SistemaAcademia.aplicacao.dto.ExercicioDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
@RequiredArgsConstructor
@Validated
public class ExercicioController {

    private final ExercicioService exercicioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarExercicio(@Valid @RequestBody ExercicioDTO exercicioDTO){
        exercicioService.criarExercicio(exercicioDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ExercíciosEntity> listarExercicios(){
        return exercicioService.buscarTodos();
    }
}
