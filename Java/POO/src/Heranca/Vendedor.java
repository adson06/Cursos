package Heranca;

public class Vendedor extends Funcionario{

    public Vendedor(String nome, int codigo, String cargo){
        super(nome, codigo, cargo);
    }

    @Override
    public double getSalario() {
       double salarioAtual = super.getSalario();
       salarioAtual = salarioAtual + (salarioAtual * 0.25);
       return salarioAtual;
    }
}
