package exercices;

import java.util.Scanner;

public class AutenticaBoolean {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean autenticado = false;

        System.out.println("Informe o usuario: ");
        String usuario = teclado.nextLine();
        System.out.println("Informe a senha: ");
        int senha = teclado.nextInt();
        if (usuario.equals("admin") && senha == 1234){
            autenticado = true;
        }
        if ( autenticado){
            System.out.println("Bem vindo ao sistema "+ usuario);
        }else {
            System.out.println("Nome de usuario ou senha incorreto!");
        }
    }
}
