package loja;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTeste {

    @Test
    public void Finalizar() {
        Cliente cliente = new Cliente("João", false);
        Pedido pedido = new Pedido(cliente);
        Vendas vendas = new Vendas();

        for (int i = 0; i < 7; i++) {
            pedido = new Pedido(cliente);
            vendas.processarPedido(pedido);
            if (pedido.isFinalizado()) {
                assertTrue(pedido.isFinalizado());
                return;
            }
        }
        fail("Pedido não foi finalizado em nenhuma tentativa");
    }

    @Test
    public void ClienteInadimplente() {
        Cliente cliente = new Cliente("Maria", true);
        Pedido pedido = new Pedido(cliente);
        Vendas vendas = new Vendas();

        vendas.processarPedido(pedido);

        assertTrue(pedido.isCancelado());
    }

    @Test
    public void CreditoRejeitado() {
        Cliente cliente = new Cliente("Carlos", false);
        Pedido pedido = new Pedido(cliente);
        Vendas vendas = new Vendas();

        for (int i = 0; i < 6; i++) {
            pedido = new Pedido(cliente);
            vendas.processarPedido(pedido);
            if (pedido.isCancelado()) {
                assertTrue(pedido.isCancelado());
                return;
            }
        }
        fail("Pedido não foi cancelado em nenhuma tentativa");
    }
}