package loja;

public class Financeiro {
    public boolean Cobranca(Pedido pedido) {
        boolean pagamentoRecebido = new Banco().pagamentoRecebido();
        System.out.println("Financeiro: Pagamento " + (pagamentoRecebido ? "recebido" : "não recebido") + " para " + pedido.getCliente().getNome());
        return pagamentoRecebido;
    }
}