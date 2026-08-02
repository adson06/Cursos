package com.example.demo.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "crud_projeto")
@Getter
@Setter
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private String status;
    private LocalDate data_inicio;
    private LocalDate data_fim;

    public Projeto(){

    }

    public Projeto(String nome, String descricao, String status, LocalDate data_inicio, LocalDate data_fim){
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.data_fim = data_fim;
        this.data_inicio = data_inicio;
    }



}
