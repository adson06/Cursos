package CadastroComida.CRUD.Comida.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "Tabela_Comida")
@Getter
@Setter
public class Comida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String categoria;
    private float preco;

    public Comida(){

    }

    public Comida(String nome, String categoria, float preco){
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }



}
