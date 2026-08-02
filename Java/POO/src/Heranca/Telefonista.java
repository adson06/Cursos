package Heranca;

public class Telefonista extends Funcionario{

    public Telefonista(String nome, int codigo, String cargo){
        super(nome, codigo, cargo);

    }

    @Override
    public double getSalario(){
        double salarioAtual = super.getSalario();
        salarioAtual = salarioAtual + (salarioAtual * 0.10);
        return salarioAtual;
    }

}


