package io.github.igomarcelino.interfaces;

public class Autenticador {

    String senhas [] = {"123", "1234","12345"};

    public boolean autenticar(Autenticacao tipoAutenticacao){

        String identificacao = tipoAutenticacao.getAutenticacao();
        boolean isAutenticado = false;


        if (tipoAutenticacao.usaSenha()){
            String senha= tipoAutenticacao.senha();
            for (String s: senhas){
                if (s.equals(senha)){
                    isAutenticado = true;
                    break;
                }
            }
        }

        return isAutenticado;
    }
}
