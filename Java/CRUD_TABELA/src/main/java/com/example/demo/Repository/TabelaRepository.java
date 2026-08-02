package com.example.demo.Repository;

import com.example.demo.Model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TabelaRepository extends JpaRepository<Projeto, Long> {
}
