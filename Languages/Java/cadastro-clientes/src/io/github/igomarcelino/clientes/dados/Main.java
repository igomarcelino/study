package io.github.igomarcelino.clientes.dados;

import io.github.igomarcelino.clientes.dominio.Cliente;
import io.github.igomarcelino.clientes.dominio.enums.TipoSexo;

import java.sql.SQLException;

public class Main{
    public static void main(String[] args) throws SQLException {

        var  conexao = FabricaConexoes.criarConexao();

        ClienteDAO daoCLiente = new ClienteDAO(conexao);

        Cliente cliente = new Cliente("Juca", "12333322211", TipoSexo.M,new byte[]{},43);
        daoCLiente.inserirCliente(cliente);
        conexao.close();
        System.out.println(cliente);
    }
}
