package loja;

public class Expedicao {
    public void Produtos(Pedido pedido) {
        System.out.println("Expedição: Produtos separados para " + pedido.getCliente().getNome());
    }
}