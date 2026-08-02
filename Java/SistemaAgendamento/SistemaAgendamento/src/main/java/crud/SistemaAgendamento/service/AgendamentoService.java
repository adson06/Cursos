package crud.SistemaAgendamento.service;

import crud.SistemaAgendamento.dto.AgendamentoResponsedto;
import crud.SistemaAgendamento.dto.Agendamentodto;
import crud.SistemaAgendamento.enums.StatusAgendamento;
import crud.SistemaAgendamento.model.Agendamento;
import crud.SistemaAgendamento.repository.IAgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final IAgendamentoRepository agendamentoRepository;

    public AgendamentoResponsedto criarAgendamento(Agendamentodto agendamentodto){
        Agendamento agendamento = Agendamento.builder()
                .statusAgendamento(StatusAgendamento.AGENDADO)
                .dataHoraEnvio(agendamentodto.dataHoraEnvio())
                .destinatario(agendamentodto.destinatario())
                .mensagem(agendamentodto.mensagem())
                .tipoComunicacao(agendamentodto.tipoComunicacao())
                .build();

        return toResponse(agendamentoRepository.save(agendamento));
    }


    // "Dos dados da entidade, eu só vou devolver esses.Escolhe apenas o que será enviado."

    public AgendamentoResponsedto toResponse(Agendamento agendamento){
        return new AgendamentoResponsedto(
                agendamento.getId(),
                agendamento.getDestinatario(),
                agendamento.getMensagem(),
                agendamento.getDataHoraEnvio(),
                agendamento.getTipoComunicacao(),
                agendamento.getStatusAgendamento()
        );
    }


    public AgendamentoResponsedto buscarPorId(Long id){
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        return toResponse(agendamento);

    }

    public void deletar(Long id){
        agendamentoRepository.deleteById(id);
    }


}
