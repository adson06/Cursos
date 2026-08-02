package com.example.demo.Service;

import com.example.demo.Model.Projeto;
import com.example.demo.Repository.TabelaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabelaService {

    private final TabelaRepository tabelaRepository;

    public TabelaService(TabelaRepository tabelaRepository){
        this.tabelaRepository = tabelaRepository;
    }

    public Projeto criarProjeto(Projeto projeto){
        return tabelaRepository.save(projeto);

    }

    public List<Projeto> ListarProjeto(){
        return tabelaRepository.findAll();
    }

    public void deletarProjeto(Long id){
        tabelaRepository.deleteById(id);
    }

    public Projeto alterarProjeto(Projeto projeto, Long id){
        Projeto projetoexistente = tabelaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

          projetoexistente.setNome(projeto.getNome());
          projetoexistente.setDescricao(projeto.getDescricao());
          projetoexistente.setData_fim(projeto.getData_fim());
          projetoexistente.setStatus(projeto.getStatus());
          projetoexistente.setData_inicio(projeto.getData_inicio());

          return tabelaRepository.save(projetoexistente);

    }


}
