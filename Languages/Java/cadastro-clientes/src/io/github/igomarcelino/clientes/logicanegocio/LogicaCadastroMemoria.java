package io.github.igomarcelino.clientes.logicanegocio;

import io.github.igomarcelino.clientes.apresentacao.TelaCadastro;
import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.exceptions.CpfInvalidoException;
import io.github.igomarcelino.clientes.utilitarios.PersistirFoto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class LogicaCadastroMemoria implements Cadastro<Cliente> {


    private List<Cliente> clienteList; // Declara a list

    public LogicaCadastroMemoria() {
        this.clienteList = new ArrayList<>(); // construtor vazio inicializa a lista
    }

    @Override
    public void salvar(Cliente cliente) throws CpfInvalidoException {

        ValidarCliente.validarCliente(cliente); // validador que contem as exceptions a serem lancadas
        this.clienteList.add(cliente); // metodo salvar recebe um cliente e o metodo add(cliente) adiciona esse cliente na lista .
        PersistirFoto.salvarFotos(cliente.getNome()+".jpg", cliente.getFoto());
        JOptionPane.showMessageDialog(null,"Cadastro realizado com sucesso.");

    }

    @Override
    public Optional<Cliente> buscar(UUID codigo) {
        Cliente clienteEncontrado = null;
        if(!clienteList.isEmpty()){
            for(Cliente cliente : clienteList){
                if(cliente.getCodigo().equals(codigo)){
                    clienteEncontrado = cliente;
                    break;
                }
            }
        }
        return Optional.ofNullable(clienteEncontrado);
    }

    @Override
    public void deletar(UUID codigo) {

      // this.buscar(codigo).ifPresent(cliente -> clienteList.remove(cliente));
        this.buscar(codigo).ifPresentOrElse(cliente -> clienteList.remove(cliente),()-> System.out.println("Cliente nao encontrado"));
    }

    @Override
    public void atualizar(Cliente cliente) {

        //Faz sentido em banco de dados
    }

    public void imprimirCliente(){

        System.out.println(this.clienteList);
    }
}
