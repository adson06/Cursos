package Heranca;

public class Funcionario extends Pessoa{

   public Funcionario(){
       super();
   }

    public Funcionario(String nome, int codigo, String cargo) {
        super(nome, codigo, cargo);
    }

    public double getSalario(){
       return 2000.00;

    }

    public String imprimirFolhaPagamento(){

   return "Código: " + getCodigo() + " Nome: " + getNome()  + " Cargo: " + getCargo()
           + " Salario: " + getSalario();
    }




}
