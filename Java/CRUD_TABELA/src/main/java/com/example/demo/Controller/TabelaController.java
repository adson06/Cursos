package com.example.demo.Controller;

import com.example.demo.Model.Projeto;
import com.example.demo.Service.TabelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projeto")
public class TabelaController {

    @Autowired
    private TabelaService tabelaService;

    // REQUEST BPDY para o spring sabe que deve pegar o JSON do corpo da requisição e converter
    // para objeto Projeto
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Projeto criarProjeto(@RequestBody Projeto projeto){
        return tabelaService.criarProjeto(projeto);
    }

    @GetMapping
    public ResponseEntity <List<Projeto>> listarProjeto(){
        return new ResponseEntity<>(tabelaService.ListarProjeto(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity <Projeto> alterarProjeto(@PathVariable Long id, @RequestBody Projeto projeto){
        return ResponseEntity.ok(tabelaService.alterarProjeto(projeto, id));
    }

    @DeleteMapping("/{id}")
    public void deletarProjeto(@PathVariable Long id){
        tabelaService.deletarProjeto(id);
    }

}
