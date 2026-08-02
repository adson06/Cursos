package ExercicioBanco;

public class ContaPoupanca extends Conta{

    public void AplicarDesconto(double valorPercentual){
        double saldo = retornaSaldoAtual();
        double rendimento = saldo * (valorPercentual / 100);
    }

    }

