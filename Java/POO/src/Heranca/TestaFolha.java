package Heranca;

public class TestaFolha {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Henrique", 123, "Funcionario");
        Gerente gerente = new Gerente(123, "Henrique", "Gerente");
        Vendedor vendedor = new Vendedor("Marcio", 456, "Vendendor");
        Telefonista telefonista = new Telefonista("Julia", 789, "Telefonista");


        System.out.println(funcionario.imprimirFolhaPagamento());
        System.out.println(gerente.imprimirFolhaPagamento());
        System.out.println(vendedor.imprimirFolhaPagamento());
        System.out.println(telefonista.imprimirFolhaPagamento());
    }
}
