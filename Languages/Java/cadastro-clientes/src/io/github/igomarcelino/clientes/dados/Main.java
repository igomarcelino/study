package io.github.igomarcelino.clientes.dados;

import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.enums.TipoSexo;

import java.sql.SQLException;
import java.util.UUID;

public class Main{
    public static void main(String[] args) throws SQLException {

        mostrarClientes();
    }

    private static void atualizarCliente(String nome, TipoSexo tipoSexo,Integer idade, String cpf) throws SQLException {
        var conexao = FabricaConexoes.criarConexao();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        // criando um novo cliente baseado em um que ja exista para ser atualizado
        Cliente clienteParaAtualizar = new Cliente();
        clienteParaAtualizar.setNome(nome);
        clienteParaAtualizar.setSexo(tipoSexo);
        clienteParaAtualizar.setIdade(idade);
        clienteParaAtualizar.setCpf(cpf);

        clienteDAO.atualizarCliente(clienteParaAtualizar);

        conexao.close();
    }

    private static void inserirCliente() throws SQLException {
        var  conexao = FabricaConexoes.criarConexao();

        ClienteDAO daoCLiente = new ClienteDAO(conexao); // abre conexao com o banco

        Cliente cliente = new Cliente();
        cliente.setNome("Igo");
        cliente.setCpf("32333411121");
        cliente.setSexo(TipoSexo.M);
        cliente.setFoto(new byte[]{});
        cliente.setIdade(22);
        daoCLiente.inserirCliente(cliente); // utiliza o metodo inserir para inserir o cliente
        conexao.close(); // fecha conexao com o banco
        System.out.println(cliente);
    }

    private static void deletarCLiente() throws SQLException {

        var conexao = FabricaConexoes.criarConexao();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);

        clienteDAO.deletarCliente(UUID.fromString("94cf6319-435b-4995-ae9c-6b976ddcc125"));
        conexao.close();
    }

    private static void mostrarClientes(){
        var conexao = FabricaConexoes.criarConexao();
        ClienteDAO clienteDAO = new ClienteDAO(conexao);

        clienteDAO.buscarClientes();
    }

}
