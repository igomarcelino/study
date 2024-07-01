package io.github.igomarcelino.sistema_cadastro_teste.dominio;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.EstadosBrasileiros;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.TipoSexo;


public class Cliente {

   private Integer  codigo = 1;
    private String nome;
    private String CPF;
    private TipoSexo tipoSexo;
    private String dataNascimento;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private EstadosBrasileiros estado;
    private String telefone;
    private byte[] fotoArray;

    public byte[] getFotoArray() {
        return fotoArray;
    }

    public void setFotoArray(byte[] fotoArray) {
        this.fotoArray = fotoArray;
    }

    public Cliente() {

    }

    public Cliente(String nome, String CPF, TipoSexo tipoSexo, String dataNascimento, String rua, String numero, String bairro, String cidade, EstadosBrasileiros estado, String telefone, byte[] fotoArray) {
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
        this.fotoArray = fotoArray;

    }

    public Integer getCodigo(){
        return codigo;
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

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
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

    public EstadosBrasileiros getEstado() {
        return estado;
    }

    public void setEstado(EstadosBrasileiros estado) {
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
