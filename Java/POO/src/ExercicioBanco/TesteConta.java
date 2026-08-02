package ExercicioBanco;

public class TesteConta {
    public static void main(String[] args) {
//        ContaCorrente contacorrente = new ContaCorrente();
//
//        contacorrente.setNumeroConta(123);
//        contacorrente.setNomeCliente("Henrique");
//        contacorrente.Depositar(500);
//        System.out.println("Valor da conta atual: " + contacorrente.retornaSaldoAtual());
//
//        contacorrente.sacar(100);
//        System.out.println("Valor apos o saque: " + contacorrente.retornaSaldoAtual());
//    }
        ContaPoupanca contaPoupanca = new ContaPoupanca();

        contaPoupanca.informaNumeroConta(123);
        contaPoupanca.informarNome("Henrique");
        contaPoupanca.Deposito(500);
        System.out.println("Valor da conta atual: " + contaPoupanca.retornaSaldoAtual());
        contaPoupanca.AplicarDesconto(5);
        System.out.println("Valor apos o rendimento: " + contaPoupanca.retornaSaldoAtual());


    }
}
