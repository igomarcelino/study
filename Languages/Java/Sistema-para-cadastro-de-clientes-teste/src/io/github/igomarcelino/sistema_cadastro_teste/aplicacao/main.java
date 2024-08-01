package io.github.igomarcelino.sistema_cadastro_teste.aplicacao;

import io.github.igomarcelino.sistema_cadastro_teste.apresentacao.TelaAtualizar;
import io.github.igomarcelino.sistema_cadastro_teste.apresentacao.TelaDeletarCliente;
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


        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);


    }
}
