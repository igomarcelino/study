package io.github.igomarcelino.sistema_cadastro_teste.logica;

import io.github.igomarcelino.sistema_cadastro_teste.dados.ClienteDAO;
import io.github.igomarcelino.sistema_cadastro_teste.dados.Conexao;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Cliente;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Exceptions.CpfValidoException;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.Exceptions.DadosObrigatoriosException;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.ListarCliente;

public class ValidaCliente {

    public static LogicaBancoDeDados logicaBancoDeDados = new LogicaBancoDeDados(new ClienteDAO(Conexao.criarConexao()));

    public static void validarCliente(Cliente cliente) throws CpfValidoException{

        if(cliente.getCPF().length() != 11 ){
            throw new CpfValidoException("CPF invalido");
        } else if (!logicaBancoDeDados.pesquisarCliente(cliente.getCPF()).isEmpty()) {
            throw new CpfValidoException("CPF ja cadastrado");
        } else {
            validarNome(cliente);
            validarTipoSexo(cliente);
            validarDataNascimento(cliente);
            validarRua(cliente);
            validarNumeroCasa(cliente);
            validarBairro(cliente);
            validarCidade(cliente);
            validarTelefone(cliente);
        }


    }

    private static void validarNome(Cliente cliente){
        if (cliente.getNome().equals(null) || cliente.getNome().isBlank()){
            throw new DadosObrigatoriosException("Nome obrigatorio!");
        }
    }

    private static void validarTipoSexo(Cliente cliente){
        if(cliente.getTipoSexo() == null){
            throw new DadosObrigatoriosException("Sexo invalido! : informar sexo");
        }
    }

    private static void validarDataNascimento(Cliente cliente){
        if(cliente.getDataNascimento().length() < 10 || cliente.getDataNascimento().isBlank()){
            throw new DadosObrigatoriosException("Data de nascimento obrigatorio!");
        }
    }

    private static void validarRua(Cliente cliente){
        if (cliente.getRua().equals(null) || cliente.getRua().isBlank()){
            throw new DadosObrigatoriosException("Rua obrigatorio!");
        }
    }

    private static void validarNumeroCasa(Cliente cliente){
        if(cliente.getNumero().equals(null) || cliente.getNumero().isBlank()){
            throw new DadosObrigatoriosException("Numero nao informado!");
        }
    }

    private static void validarBairro(Cliente cliente){
        if(cliente.getBairro().equals(null) || cliente.getBairro().isBlank()){
            throw new DadosObrigatoriosException("Bairro nao informado!");
        }
    }

    private static void validarCidade(Cliente cliente){
        if(cliente.getCidade().equals(null) || cliente.getCidade().isBlank()){
            throw new DadosObrigatoriosException("Cidade nao informada!");
        }
    }

    private static void validarTelefone(Cliente cliete){
        if(cliete.getTelefone().equals(null) || cliete.getTelefone().isBlank()){
            throw new DadosObrigatoriosException("Telefone obrigatorio!");
        }
    }


}
