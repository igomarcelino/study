package io.github.igomarcelino.interfaces;

public class Autenticador {



    String[] usuarios = {"igo", "joao", "kucas"};
    String senhas [] = {"123", "1234","12345"};

    public boolean autenticar(Autenticacao tipoAutenticacao){

        String identificacao = tipoAutenticacao.tipoAutenticacao();
        boolean isAutenticado = false;


        if (identificacao.equals("email")){

            if (tipoAutenticacao.usaSenha()){
                String senha= tipoAutenticacao.senha();
                for (String s: senhas){
                    if (s.equals(senha)){
                        isAutenticado = true;
                        break;
                    }
                }
            }

        } else if (identificacao.equals("usuario")) {
            //todo
            AutenticacaoUsuario usuario = new AutenticacaoUsuario();
            for( String u : usuarios){
                if (u.equals(usuario.getUsuario())){
                    isAutenticado = true;
                    break;
                }
            }


        }

        return isAutenticado;
    }
}
