package Heranca;

public class Pessoa {
    private String nome;
    private int codigo;
    private String cargo;

    public Pessoa(){

    }

    public Pessoa(String nome, int codigo, String cargo){
        this.nome = nome;
        this.codigo = codigo;
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setNome(String nome){
        this.nome = nome;
  }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
