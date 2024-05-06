package io.github.igomarcelino.clientes.dominio;

import io.github.igomarcelino.clientes.dominio.enums.TipoSexo;

import java.util.UUID;

public class Cliente {
    private UUID codigo;
    private String nome;
    private String cpf;
    private TipoSexo sexo;
    private Byte[] foto;

    public Cliente() {
        this.codigo = UUID.randomUUID();
    }

    public Cliente(String nome, String cpf, TipoSexo sexo, Byte[] foto) {
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

    public Byte[] getFoto() {
        return foto;
    }

    public void setFoto(Byte[] foto) {
        this.foto = foto;
    }
}

