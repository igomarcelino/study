package io.github.igomarcelino.interfaces;

public class AutenticacaoUsuario implements Autenticacao {

    String usuario;
    String senha;
    String tipoAutenticacao = "usuario";

    public String getTipoAutenticacao() {
        return tipoAutenticacao;
    }

    public AutenticacaoUsuario() {
        this.usuario = usuario;
        this.senha = senha;
    }

    public AutenticacaoUsuario(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String getAutenticacao() {
        return this.getUsuario();
    }

    @Override    public String senha() {
        return this.getSenha();
    }

    @Override
    public String tipoAutenticacao() {
        return this.getTipoAutenticacao();
    }

    @Override
    public boolean usaSenha() {
        return false;
    }
}
