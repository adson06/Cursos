package LoginUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteUsuario {
    public static void main(String[] args) {
        try {
            List<Usuario> usuarios = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);

            usuarios.add(new Usuario("Henrique", "123"));
            usuarios.add(new Usuario("Julia", "456"));
            usuarios.add(new Usuario("Marcia", "789"));

            System.out.printf("Digite seu login: ");
            String login_recebido = scanner.nextLine();

            System.out.printf("Digite sua senha: ");
            String senha_recebida = scanner.nextLine();

            boolean autenticado = false;

            for (Usuario u : usuarios){
                if (u.autenticar(login_recebido, senha_recebida)){
                    autenticado = true;
                    break;
                }
            }

            if (autenticado){
                System.out.printf("Sucesso");
            }else{
                System.out.printf("Login Inválido");
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
