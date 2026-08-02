package ExercicioBanco;

public class Conta {
    private int numeroConta;
    private String nome;
    private double saldo;

    public void informaNumeroConta(int numeroConta){
        this.numeroConta = numeroConta;
    }

    public void informarNome(String nome){
        this.nome = nome;
    }

    public double retornaSaldoAtual(){
        return this.saldo = saldo;
    }

    public void Deposito(double valorDeposito){
        this.saldo += valorDeposito;
    }

    public void sacar(double valorSaque){
        if(this.saldo - valorSaque < 0){
            System.out.println("Saldo Insuficiente: ");
        }

        this.saldo -= valorSaque;
    }




}

