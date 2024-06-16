package io.github.igomarcelino.clientes.dados;

import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.enums.TipoSexo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClienteDAO {

    private  Connection conexaoSql;

    // construtor para inicializar a conexao
    public ClienteDAO(Connection connection) {
        this.conexaoSql = connection;
    }

    // comando SQL para inserir clientes no banco de dados
    private String inserirCliente = """
                insert into clientes ( codigo, nome, sexo, cpf, idade) 
                values (?, ?, ?, ?, ?)
            """; // ( string, string , enum, string,integer
    private String atualizarCliente = """
                UPDATE clientes
                    set nome = ?,
                        sexo = ?,
                        idade = ?
                        
                    where cpf = ?
            """;

    private String buscarClientes = "select *from clientes";

    private String deletarCliente = "DELETE from clientes where codigo = ?";

    public void inserirCliente (Cliente cliente){

        // Como o PreparedStatement recebe uma conexaoSql ele ira pedir para tratar as SQLException
        try{
            PreparedStatement conexao = conexaoSql.prepareStatement(inserirCliente);
            conexao.setString(1,cliente.getCodigo().toString());
            conexao.setString(2,cliente.getNome());
            conexao.setString(3,cliente.getSexo().name());
            conexao.setString(4,cliente.getCpf());
            conexao.setInt(5,18);
            conexao.execute(); // executa o comando de insercao do cliente no banco

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void atualizarCliente(Cliente cliente){


        try{
            PreparedStatement conexao = conexaoSql.prepareStatement(atualizarCliente);
            conexao.setString(1,cliente.getNome());
            conexao.setString(2,cliente.getSexo().name());
            conexao.setInt(3,cliente.getIdade());
            conexao.setString(4,cliente.getCpf());
            conexao.execute();

        }catch (SQLException e) {
            throw  new RuntimeException("Cliente nao encontrado");
        }
    }

    public void deletarCliente(UUID uuid){
        try {
            PreparedStatement conexao = conexaoSql.prepareStatement(deletarCliente);
            conexao.setString(1,uuid.toString());
            conexao.execute();
        }catch (SQLException e ){
            throw new RuntimeException(e);
        }
    }
    public void buscarClientes(){
        List<Cliente> exibeClientes = new ArrayList<>();
        try{
            PreparedStatement conexao = conexaoSql.prepareStatement(buscarClientes);
            ResultSet resultado = conexao.executeQuery();
            while (resultado.next()){

                Cliente cliente = new Cliente();
                cliente.setCodigo(UUID.fromString(resultado.getString("codigo")));
                cliente.setNome(resultado.getString("nome"));
                cliente.setSexo(TipoSexo.valueOf(resultado.getString("sexo")));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setIdade(resultado.getInt("idade"));

                exibeClientes.add(cliente);
            }

            System.out.println(exibeClientes);

        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
