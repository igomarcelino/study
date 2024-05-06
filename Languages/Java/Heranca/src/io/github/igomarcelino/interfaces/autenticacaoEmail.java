package io.github.igomarcelino.interfaces;

public class autenticacaoEmail implements Autenticacao {

    String email;
    String senha;
    String tipoAutenticacao = "email";

    public autenticacaoEmail(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getTipoAutenticacao() {
        return tipoAutenticacao;
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
    public String tipoAutenticacao() {
        return this.getTipoAutenticacao() ;
    }

    @Override
    public boolean usaSenha() {
        return true;
    }
}
