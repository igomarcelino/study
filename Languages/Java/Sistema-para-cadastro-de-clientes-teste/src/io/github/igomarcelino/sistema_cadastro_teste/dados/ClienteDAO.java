package io.github.igomarcelino.sistema_cadastro_teste.dados;

import io.github.igomarcelino.sistema_cadastro_teste.dominio.BuscaCliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.EstadosBrasileiros;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Enuns.TipoSexo;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.ListarCliente;

import javax.swing.*;
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

    private static String deletarCliente = "DELETE FROM clientes WHERE cpf = ?";

    private static String atualizarClientes = """
            UPDATE clientes
                SET nome = ?,
                    d_nascimento = ?,
                    rua = ?,
                    numero = ?,
                    bairro = ?,
                    cidade = ?,
                    estado = ?,
                    telefone = ?
                    WHERE cpf = ?;
            """;

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

    public Optional<BuscaCliente> procurarCliente(String cpf_cliente){
        try {
            PreparedStatement conexao = conexaoSQL.prepareStatement(procurarClientes);
            conexao.setString(1,cpf_cliente);
            ResultSet resultSet = conexao.executeQuery();
            if (resultSet.next()){
                 String nome = resultSet.getString("nome");
                 String cpf = resultSet.getString("cpf");
                 String d_nascimento = resultSet.getString("d_nascimento");
                 String rua = resultSet.getString("rua");
                 String numero = resultSet.getString("numero");
                 String bairro = resultSet.getString("bairro");
                 String cidade = resultSet.getString("cidade");
                 String estado = resultSet.getString("estado");
                 String telefone = resultSet.getString("telefone");

                 BuscaCliente buscaCliente = new BuscaCliente();
                 buscaCliente.setNome(nome);
                 buscaCliente.setCPF(cpf);
                 buscaCliente.setDataNascimento(d_nascimento);
                 buscaCliente.setRua(rua);
                 buscaCliente.setNumero(numero);
                 buscaCliente.setBairro(bairro);
                 buscaCliente.setCidade(cidade);
                 buscaCliente.setEstado(EstadosBrasileiros.valueOf(estado));
                 buscaCliente.setTelefone(telefone);

                 Optional<BuscaCliente> optionalBuscaCliente = Optional.of(buscaCliente);
                 return optionalBuscaCliente;
            }

        }catch (SQLException e){
            throw new RuntimeException(e);
        }

        return Optional.empty();

    }

    public void atualizarClientes(BuscaCliente cliente){
        try{
            PreparedStatement conexao = conexaoSQL.prepareStatement(atualizarClientes);
            conexao.setString(1,cliente.getNome());
            conexao.setString(2,cliente.getDataNascimento());
            conexao.setString(3,cliente.getRua());
            conexao.setString(4,cliente.getNumero());
            conexao.setString(5,cliente.getBairro());
            conexao.setString(6,cliente.getCidade());
            conexao.setString(7,cliente.getEstado().name());
            conexao.setString(8,cliente.getTelefone());
            conexao.setString(9,cliente.getCPF());
            conexao.execute();


        }catch (SQLException e){
            throw new RuntimeException("Atualizar cliente, dados incorretos");
        }
    }

    public void deletarCliente(String cpf){
            try{
                PreparedStatement conexao = conexaoSQL.prepareStatement(deletarCliente);
                conexao.setString(1,cpf);
                conexao.execute();
                conexao.close();
            }catch (SQLException e ){
                throw new RuntimeException(e);
            }
    }

}
