package io.github.igomarcelino.clientes.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {

    private static String url ="jdbc:postgresql://localhost:5432/clientes";
    private static String userName = "postgres";
    private static String password = "postgres";

    public static Connection criarConexao(){
        try{
            try {
                Class.forName("org.postgresql.Driver"); // busca a classe Driver para conexao com o banco
                return DriverManager.getConnection(url,userName,password); // retorna a conexao com o banco utilizando os atributos informados
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            }catch (SQLException e){
                throw new RuntimeException()
;           }
    }

}
