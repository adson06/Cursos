package SistemaAcademia.aplicacao.database.model;


import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name = "alunos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AlunoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(name = "data_aniversario", nullable = false)
    private Date dataAniversario;

    @OneToOne
    @JoinColumn(name = "avalicao_id")
    private AvaliacaoFisicaEntity avaliacaoFisica;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    Set<TreinosEntity> treinos = new HashSet<>();
}
