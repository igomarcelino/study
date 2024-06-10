package io.github.igomarcelino.clientes.dados;

import io.github.igomarcelino.clientes.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {

    private  Connection conexaoSql;

    public ClienteDAO(Connection connection) {
        this.conexaoSql = connection;
    }

    private String inserirCliente = """
                insert into clientes ( codigo, nome, sexo, cpf, idade) 
                values (?, ?, ?, ?, ?)
            """; // ( string, string , enum, string,integer

    public void inserirCliente (Cliente cliente){

        try{
            PreparedStatement conexao = conexaoSql.prepareStatement(inserirCliente);
            conexao.setString(1,cliente.getCodigo().toString());
            conexao.setString(2,cliente.getNome());
            conexao.setString(3,cliente.getSexo().name());
            conexao.setString(4,cliente.getCpf());
            conexao.setInt(5,cliente.getIdade());
            conexao.execute();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
