package crud.SistemaAgendamento.dto;

import crud.SistemaAgendamento.enums.StatusAgendamento;
import crud.SistemaAgendamento.enums.TipoComunicacao;

import java.time.LocalDateTime;

public record Agendamentodto(
        String mensagem,
        String destinatario,
        StatusAgendamento statusAgendamento,
        TipoComunicacao tipoComunicacao,
        LocalDateTime dataHoraEnvio
) {
}
