package io.github.igomarcelino.interfaces;

public class Main {
    public static void main(String[] args) {
        Autenticador autenticador = new Autenticador();

        autenticacaoEmail email = new autenticacaoEmail("user@email.com","123488");

        if(autenticador.autenticar(email)){
            System.out.println("Usuario autenticado");
        }else {
            System.out.println("Usuario nao encontrado");
        }





    }
}
