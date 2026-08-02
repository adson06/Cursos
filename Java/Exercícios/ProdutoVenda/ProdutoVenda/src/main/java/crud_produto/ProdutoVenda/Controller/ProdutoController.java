package crud_produto.ProdutoVenda.Controller;


import crud_produto.ProdutoVenda.Exception.NotFoundException;
import crud_produto.ProdutoVenda.Service.ProdutoService;
import crud_produto.ProdutoVenda.dto.ProdutoDTO;
import crud_produto.ProdutoVenda.model.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return produtoService.criarProduto(produto);
    }

    @GetMapping
    public List <Produto> listarProdutos(){
        return produtoService.buscarProduto();
    }

    @GetMapping("/{id}")
    public Optional<Produto> listarProdutoPorId(@PathVariable Long id) throws NotFoundException {
        return produtoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Produto alterarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produtoDTO) throws NotFoundException {
        return produtoService.alterarProduto(produtoDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
    }





}
