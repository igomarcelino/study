package io.github.igomarcelino.clientes.dominio;

import io.github.igomarcelino.clientes.dominio.enums.TipoSexo;

import java.util.Arrays;
import java.util.UUID;

public class Cliente implements Comparable<Cliente> {
    private UUID codigo;
    private String nome;
    private String cpf;
    private TipoSexo sexo;
    private byte[] foto;

    public Cliente() {
        this.codigo = UUID.randomUUID();
        System.out.println("Codigo cliente: " + this.codigo.toString());
    }

    public Cliente(String nome, String cpf, TipoSexo sexo, byte[] foto) {
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.foto = foto;
        this.codigo = UUID.randomUUID();
    }

    public UUID getCodigo() {
        return codigo;
    }

    public void setCodigo(UUID codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public TipoSexo getSexo() {
        return this.sexo;
    }

    public void setSexo(TipoSexo sexo) {
        this.sexo = sexo;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", sexo=" + sexo +
                ", foto=" + Arrays.toString(foto) +
                '}';
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;

        if (!getNome().equals(cliente.getNome())) return false;
        return getCpf().equals(cliente.getCpf());
    }

    @Override
    public int hashCode() {
        int result = getNome().hashCode();
        result = 31 * result + getCpf().hashCode();
        return result;
    }

    @Override
    public int compareTo(Cliente o) {
        return this.nome.compareTo(o.getNome());
    }
}

