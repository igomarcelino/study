package io.github.igomarcelino.sistema_cadastro_teste.dados;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    // conexao que chamara a conexao com o banco
    private Connection conexaoSQL;

    // comando sql para inserir clientes
    private static String inserirCliente = """
                insert into clientes ( cod_cliente ,nome, cpf, sexo, d_nascimento, rua , numero, bairro, cidade, estado, telefone)
                        values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
            """;
    private static String selecionarClientes = "select *from clientes";

    // metodo construtor que recebe uma connection
    public ClienteDAO(Connection connection) {
        this.conexaoSQL = connection;
    }

    public void inserirCLiente(Cliente cliente){
        try{
            PreparedStatement conexao = conexaoSQL.prepareStatement(inserirCliente);
            conexao.setInt(1,cliente.getCodigo());
            conexao.setString(2,cliente.getNome());
            conexao.setString(3, cliente.getCPF());
            conexao.setString(4,cliente.getTipoSexo().name());
            conexao.setString(5,cliente.getDataNascimento());
            conexao.setString(6,cliente.getRua());
            conexao.setString(7,cliente.getNumero());
            conexao.setString(8, cliente.getBairro());
            conexao.setString(9,cliente.getCidade());
            conexao.setString(10,cliente.getEstado().name());
            conexao.setString(11,cliente.getTelefone());
            conexao.execute();

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int contarRegistros(){
        int quantidadeRegistros = 0;
        try{
            PreparedStatement conexao = conexaoSQL.prepareStatement(selecionarClientes);
            ResultSet resultado = conexao.executeQuery();
            while (resultado.next()){
                quantidadeRegistros++;
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return quantidadeRegistros;
    }

}
