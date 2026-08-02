package LoginUsuario;

public class Usuario {
    private String nome;
    private String password;

    public Usuario(){

    }

    public Usuario(String nome, String password){
        this.nome = nome;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getNome(){
        return nome;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean autenticar(String nome, String password){
           return this.nome == nome && this.password == password;

    }
}
