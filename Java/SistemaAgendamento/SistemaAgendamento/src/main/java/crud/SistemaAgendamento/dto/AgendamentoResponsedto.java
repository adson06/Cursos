package crud.SistemaAgendamento.dto;

import crud.SistemaAgendamento.enums.StatusAgendamento;
import crud.SistemaAgendamento.enums.TipoComunicacao;

import java.time.LocalDateTime;

public record AgendamentoResponsedto(
        Long id,
        String destinario,
        String mensagem,
        LocalDateTime dataHoraEnvio,
        TipoComunicacao tipoComunicacao,
        StatusAgendamento statusAgendamento
) {
}
