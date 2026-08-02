package POO.Encapsulamento;

public class Pessoa {
    private String nome;
    private String cpf;
    private int idade;
    private double altura;

    public Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getIdade(){
        return idade;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setAltura(double altura){
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Pessoa" +
                "nome='" + nome +
                ", cpf='" + cpf;
    }
}
