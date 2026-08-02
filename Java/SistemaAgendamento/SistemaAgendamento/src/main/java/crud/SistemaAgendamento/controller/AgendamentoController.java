package crud.SistemaAgendamento.controller;


import crud.SistemaAgendamento.dto.AgendamentoResponsedto;
import crud.SistemaAgendamento.dto.Agendamentodto;
import crud.SistemaAgendamento.model.Agendamento;
import crud.SistemaAgendamento.service.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamento")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoResponsedto> criarAgendamento(Agendamentodto agendamentodto){

        AgendamentoResponsedto agendamento = agendamentoService.criarAgendamento(agendamentodto);
        return ResponseEntity.status(HttpStatus.OK).body(agendamento);
    }

    @GetMapping("{/id}")
    public ResponseEntity<AgendamentoResponsedto> buscarPorId( @PathVariable  Long id){
        AgendamentoResponsedto agendamento = agendamentoService.buscarPorId(id);
        return ResponseEntity.ok(agendamento);
    }

    @DeleteMapping("{/id}")
    public void deletar(@PathVariable Long id){
        agendamentoService.deletar(id);
    }

}
