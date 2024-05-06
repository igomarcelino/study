package io.github.igomarcelino.interfaces;

public class autenticacaoEmail implements Autenticacao {

    String email;
    String senha;

    public autenticacaoEmail(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }


    @Override
    public String getAutenticacao() {
        return  this.email;
    }

    @Override
    public String senha() {
        return this.senha;
    }

    @Override
    public boolean usaSenha() {
        return true;
    }
}
