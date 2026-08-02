package CadastroComida.CRUD.Comida.Service;


import CadastroComida.CRUD.Comida.Repository.ComidaRepository;
import CadastroComida.CRUD.Comida.model.Comida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.spi.LocaleNameProvider;


@Service
public class ComidaService {

    //Injeção de Dependências
    @Autowired
    private ComidaRepository comidaRepository;

    //ou
//    public ComidaService(ComidaRepository comidaRepository){
//        this.comidaRepository = comidaRepository;
//    }

    //1 metodo criar um alimento então precisamos retornar um alimento e
    //precisamos do objeto comida(onde vão ter o nome, descricao e preco

    public Comida criarComida(Comida comida){
        if(comida.getNome().isBlank() && comida.getPreco() < 0){
            System.out.println("Digite uma comida e um preco");
        }
        return comidaRepository.save(comida);
    }

    //2 metodo o de listar os alimentos, para isso precisamos de uma lista
    // mas como é só para listar não precisamos de nenhum parametro
    //mas precisamos retornar algo.

    public List <Comida> listarAlimento(){
        return comidaRepository.findAll();
    }

    // 3 metodo é o de atualizar para atualizar precisamos de uma comida já
    //existente para poder alterar, e precisamos do objeto comida também.
    //Vamos buscar esse alimento pelo o id e altera-lo.

    public Comida AlterarComida(Long id, Comida comida){
      Comida  comidaexistente =  comidaRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Comida não existe"));

       comidaexistente.setPreco(comida.getPreco());
       comidaexistente.setNome(comida.getNome());
       comidaexistente.setCategoria(comida.getCategoria());

       return comidaRepository.save(comidaexistente);
    }

    //O ultimo metodo é o de deletar como não vamos retornar nada ele é void e para isso precisamos do id do alimento para deletar
    public void deletar(Long id){
        comidaRepository.deleteById(id);
    }

}





















//se tiver uma comida dentro devolve ela normalmente, se estiver vazia lança a exceção
//interrompendo o metodo imediatamente


//Igual ao deletar: usa o Optional pra checar se aquele id existe,
        // e já para tudo com uma exceção se não existir.


    //As mesmas regras que fazem sentido pra criar também fazem sentido pra atualizar
        // não faz sentido permitir um nome vazio na criação, mas aceitar isso na hora de atualizar.


        // Os setters "copiam" os dados novos pro objeto que já existe no banco


        //comidaExistente é o objeto que já tem o id certo, vindo do banco. A gente não troca o objeto inteiro
        // — só atualiza os campos dele, um por um, com os valores que vieram em novaComida. Isso é literalmente
        // o que os setters servem pra fazer (lembra da explicação de getter/setter: "pedir
        // pra guardar algo no quarto").




        //Como comidaExistente já tem um id preenchido (porque veio do findById), o Spring Data
        // JPA entende "ah, essa linha já existe, então isso é um UPDATE", em vez de criar uma linha nova.


