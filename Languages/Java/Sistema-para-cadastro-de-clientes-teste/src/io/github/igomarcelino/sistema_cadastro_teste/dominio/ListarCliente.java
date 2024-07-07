package io.github.igomarcelino.sistema_cadastro_teste.dominio;

public class ListarCliente {
    private int codigo;
    private String nome;
    private char sexo;
    private String dataNascimento;

    public ListarCliente() {

    }

    public ListarCliente(int codigo, String nome, char sexo, String dataNascimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "ListarCliente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", sexo=" + sexo +
                ", dataNascimento='" + dataNascimento + '\'' +
                '}';
    }
}
