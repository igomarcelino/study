package io.github.igomarcelino.sistema_cadastro_teste.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
// Classe responsavel pela conexao ao banco de dados
public class Conexao {
    // endereco em que o servico esta rodando na maquina
    private static String url = "jdbc.postgresql://localhost:5432/clientes-teste";
    // usuario de acesso ao banco
    private static String userName="postgres";
    // senha de acesso ao banco
    private static String password="postgres";

    // inicializando o driver de conexao ao banco ,
    public static Connection criarConexao(){
        try{
            // procura a classe Driver dentro do pacote org.postgresql
            Class.forName("org.postgresql.Driver");
            // retorna o Driver que tentara uma conexao com o banco utilizando o caminho, usuario e senha
            return DriverManager.getConnection(url,userName,password);
            // caso nao encontre a classe Driver lancara uma exception
        }catch (ClassNotFoundException c){
            throw new RuntimeException(c);
            // caso tenha uma falha de conexao lancara uma exception
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }


}
