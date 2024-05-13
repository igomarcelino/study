package io.github.igomarcelino.sistema_cadastro_teste.dominio;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.TipoSexo;

import java.util.Date;


public class Cliente {

    private String nome;
    private String CPF;
    private TipoSexo tipoSexo;
    private Date dataNascimento;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;

    public Cliente() {
    }

    public Cliente(String nome, String CPF, TipoSexo tipoSexo, Date dataNascimento, String rua, String numero, String bairro, String cidade, String estado, String telefone) {
        this.nome = nome;
        this.CPF = CPF;
        this.tipoSexo = tipoSexo;
        this.dataNascimento = dataNascimento;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public TipoSexo getTipoSexo() {
        return tipoSexo;
    }

    public void setTipoSexo(TipoSexo tipoSexo) {
        this.tipoSexo = tipoSexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;

        if (!getNome().equals(cliente.getNome())) return false;
        if (!getCPF().equals(cliente.getCPF())) return false;
        return getDataNascimento().equals(cliente.getDataNascimento());
    }

    @Override
    public int hashCode() {
        int result = getNome().hashCode();
        result = 31 * result + getCPF().hashCode();
        result = 31 * result + getDataNascimento().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", CPF='" + CPF + '\'' +
                ", tipoSexo=" + tipoSexo +
                ", dataNascimento=" + dataNascimento +
                ", rua='" + rua + '\'' +
                ", numero='" + numero + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
