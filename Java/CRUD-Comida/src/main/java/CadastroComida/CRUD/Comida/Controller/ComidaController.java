package CadastroComida.CRUD.Comida.Controller;

import CadastroComida.CRUD.Comida.Service.ComidaService;
import CadastroComida.CRUD.Comida.model.Comida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public class ComidaController {

    @Autowired
    private ComidaService comidaService;

    @PostMapping
    public Comida criarComida(@RequestBody Comida comida){
        return comidaService.criarComida(comida);
    }

    @GetMapping
    public List<Comida> comida(){
        return comidaService.listarAlimento();
    }

    @PutMapping("/{id}")
    //O path variable captura os valores presentes na URL e o requestboy para capturar o JSON e transformar em objeto JAVA.
    public Comida alterarComida(@PathVariable Long id, @RequestBody Comida comida){
        return comidaService.AlterarComida(id, comida);
    }

    @DeleteMapping("/{id}")
    public void Deletar(@PathVariable Long id){
        comidaService.deletar(id);
    }
    }




// porque o identificador vem dentro da própria URL
// (não é um objeto inteiro no corpo, como no criar), então usamos @PathVariable pra "puxar" esse valor.
    //chama comidaService.listarComida() → que chama comidaRepository.findAll()
    // → devolve a lista inteira, subindo camada por camada até virar a resposta JSON pro cliente, algo como:


    //Comida comida significa: "um objeto do tipo Comida, que eu vou chamar de comida dentro do método" —
    // o tipo garante que o Jackson saiba pra que classe converter o JSON recebido, e o nome da variável
    // é só uma escolha de clareza pra quem lê o código.






