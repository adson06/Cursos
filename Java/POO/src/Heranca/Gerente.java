package Heranca;

public class Gerente extends Funcionario{

    public Gerente(int codigo, String nome, String cargo){
        //O super chama o construtor do funcionario que é a superclassse
         super(nome, codigo, cargo);
    }

    @Override
    // e estou sobrescrevendo o metodo da classe funcionario
    public double getSalario(){
        double salarioAtual = super.getSalario();
        salarioAtual = salarioAtual + (salarioAtual * 0.45);
        return salarioAtual;
    }


}
