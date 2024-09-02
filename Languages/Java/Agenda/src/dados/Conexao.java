package dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static String url ="jdbc:postgresql://localhost:5432/agenda";
    private static String user="postgres";
    private static String password="postgres";

    public static Connection conexao(){
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Classe nao encontrada");
        } catch (SQLException e) {
            throw new RuntimeException("Verificar conexao com o banco");
        }
    }
}
