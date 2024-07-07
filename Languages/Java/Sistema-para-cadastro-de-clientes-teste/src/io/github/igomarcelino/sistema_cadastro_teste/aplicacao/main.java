package io.github.igomarcelino.sistema_cadastro_teste.aplicacao;

import io.github.igomarcelino.sistema_cadastro_teste.apresentacao.TelaPrincipal;
import io.github.igomarcelino.sistema_cadastro_teste.dados.ClienteDAO;
import io.github.igomarcelino.sistema_cadastro_teste.dados.Conexao;
import io.github.igomarcelino.sistema_cadastro_teste.dominio.ListarCliente;
import io.github.igomarcelino.sistema_cadastro_teste.logica.LogicaBancoDeDados;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class main {
    public static void main(String[] args) {

//        TelaCadastro telaCadastro = new TelaCadastro();
//        telaCadastro.setVisible(true);

       /* TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);*/


        LogicaBancoDeDados logicaBancoDeDados = new LogicaBancoDeDados(new ClienteDAO(Conexao.criarConexao()));
        String cpf = "99899900989";
        Optional<ListarCliente> cliente =  logicaBancoDeDados.pesquisarCliente(cpf);

        if (cliente.isPresent()){
            JOptionPane.showMessageDialog(null,String.format("Nome: %s\nSexo: %s\nData Nascimento: %s",
                                                                            cliente.get().getNome(),
                                                                            cliente.get().getSexo(),
                                                                            cliente.get().getDataNascimento()),
                                                                            "Cliente Localizado",
                                                                            JOptionPane.INFORMATION_MESSAGE);
        }else {
            JOptionPane.showMessageDialog(null,"Cliente Nao encontrado",
                                                                        "Cliente Nao Localizado",
                                                                                JOptionPane.ERROR_MESSAGE);
        }

    }
}
