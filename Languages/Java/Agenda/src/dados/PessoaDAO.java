package dados;

import dominio.Pessoa;

import java.sql.*;

public class PessoaDAO {
    private Connection conexaoSQL;

    public PessoaDAO(Connection connection) {
        this.conexaoSQL = connection;
    }
    private String inserirPessoa = """
                INSERT INTO pessoa(nome,sobrenome)
                    VALUES(?, ?);
            """;
    private String inserirContato = """
                INSERT INTO contato(tipo, valor, pessoa_fk)
                    VALUES(?, ?,?);
            """;
    public void inserirPessoa(Pessoa pessoa){
        int generatedID = 0;
        try {
            PreparedStatement conexao = conexaoSQL.prepareStatement(inserirPessoa, Statement.RETURN_GENERATED_KEYS);
            conexao.setString(1,pessoa.getNome());
            conexao.setString(2,pessoa.getSobrenome());
            conexao.execute();
            ResultSet resultSet = conexao.getGeneratedKeys();
            if (resultSet.next()){
                generatedID = resultSet.getInt(1);
            }
            conexao = conexaoSQL.prepareStatement("INSERT INTO contato(tipo, valor, pessoa_fk)VALUES(?, ?,?);");
            conexao.setString(1,pessoa.getTipo());
            conexao.setString(2,pessoa.getValor());
            conexao.setInt(3,generatedID);
            conexao.execute();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
