package loja;

public class Vendas {
    private Credito creditoService = new Credito();
    private Expedicao expedicao = new Expedicao();
    private Financeiro financeiro = new Financeiro();

    public void processarPedido(Pedido pedido) {
        if (creditoService.verificarCredito(pedido.getCliente())) {
            expedicao.Produtos(pedido);
            if (financeiro.Cobranca(pedido)) {
                pedido.finalizar();
            } else {
                pedido.cancelar();
            }
        } else {
            pedido.cancelar();
            System.out.println("Vendas: Pedido cancelado por crédito recusado ou cliente inadimplente");
        }
    }
}