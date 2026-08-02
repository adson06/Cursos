package POO.Encapsulamento;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("Henrique", "123");

        pessoa.setAltura(1.77);
        pessoa.setIdade(18);

        System.out.println(pessoa);


        }
    }
