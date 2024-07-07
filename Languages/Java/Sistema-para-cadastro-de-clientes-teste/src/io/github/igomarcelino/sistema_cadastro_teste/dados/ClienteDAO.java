package io.github.igomarcelino.sistema_cadastro_teste.dados;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.ListarCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAO {

    // conexao que chamara a conexao com o banco
    private Connection conexaoSQL;

    // comando sql para inserir clientes
    private static String inserirCliente = """
                insert into clientes ( cod_cliente ,nome, cpf, sexo, d_nascimento, rua , numero, bairro, cidade, estado, telefone)
                        values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);
            """;
    private static String selecionarClientes = "select *from clientes";

    private static String procurarClientes = "select *from clientes where cpf = ?";
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
        }finally {
            try {
                if (!conexaoSQL.isClosed()){
                    conexaoSQL.close();
                }
            } catch (SQLException e) {
                System.out.println("Fechando conexao");
            }
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

    public List<ListarCliente> listarClientes()  {
        List<ListarCliente> clienteList = new ArrayList<>();
        try
        {
            PreparedStatement conexao = conexaoSQL.prepareStatement(selecionarClientes);
            ResultSet resultadoBusca = conexao.executeQuery();
            while (resultadoBusca.next()){
                int codigo = resultadoBusca.getInt("cod_cliente");
                String nome = resultadoBusca.getString("nome");
                String sexo = resultadoBusca.getString("sexo");
                String dataNascimento = resultadoBusca.getString("d_nascimento");
                ListarCliente listarCliente = new ListarCliente();
                listarCliente.setCodigo(codigo);
                listarCliente.setNome(nome);
                listarCliente.setSexo(sexo.charAt(0));
                listarCliente.setDataNascimento(dataNascimento);
                clienteList.add(listarCliente);
                conexaoSQL.close();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        System.out.println(clienteList);
        return clienteList;
    }

    public Optional<ListarCliente> procurarCliente(String cpf){
        try {
            PreparedStatement conexao = conexaoSQL.prepareStatement(procurarClientes);
            conexao.setString(1,cpf);
            ResultSet resultSet = conexao.executeQuery();
            if (resultSet.next()){
                 int codigo = resultSet.getInt("cod_cliente");
                 String nome = resultSet.getString("nome");
                 String sexo = resultSet.getString("sexo");
                 String dataNascimento = resultSet.getString("d_nascimento");
                 ListarCliente  clienteEncontrado = new ListarCliente(codigo,nome,sexo.charAt(0),dataNascimento);
                 return Optional.of(clienteEncontrado);
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

}
