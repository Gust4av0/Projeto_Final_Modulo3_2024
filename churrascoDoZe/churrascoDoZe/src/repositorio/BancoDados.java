package repositorio; //Declaração do pacote

import java.sql.Connection; //Representa uma conexão com o banco de dados
import java.sql.DriverManager; //Gera a conexão com o banco de dados
import java.sql.SQLException; //Uma exceção que é lançada quando ocorre um erro durante uma operação de SQL

public class BancoDados {

    private static final String URL = "jdbc:mysql://localhost:3306/churrasco_do_ze";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado", e);
        }
    }

    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            if (connection != null) {
                System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Problema ao conectar: " + e);
        }
    }
}
