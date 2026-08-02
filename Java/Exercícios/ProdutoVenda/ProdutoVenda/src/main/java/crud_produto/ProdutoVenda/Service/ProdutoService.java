package crud_produto.ProdutoVenda.Service;

import crud_produto.ProdutoVenda.Exception.NotFoundException;
import crud_produto.ProdutoVenda.Repository.ProdutoRepository;
import crud_produto.ProdutoVenda.dto.ProdutoDTO;
import crud_produto.ProdutoVenda.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Optional<Produto> buscarPorId(Long id) throws NotFoundException {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
    }

    public List<Produto> buscarProduto(){
        return produtoRepository.findAll();
    }

    public Produto alterarProduto(ProdutoDTO produtoDTO, Long id) throws NotFoundException {
        Produto produtoexistente = produtoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        produtoexistente.setNome(produtoDTO.getNome());
        produtoexistente.setQuantidade(produtoDTO.getQuantidade());
        produtoexistente.setPreco(produtoDTO.getPreco());

        return produtoRepository.save(produtoexistente);

    }

    public void deletarProduto(Long id){

        produtoRepository.deleteById(id);
    }



}
