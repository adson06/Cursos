package SistemaAcademia.aplicacao.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ExercicioDTO {

    @NotBlank
    private String nome;
    @NotBlank
    private String grupoMuscular;
}
