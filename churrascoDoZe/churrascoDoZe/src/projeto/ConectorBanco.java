package projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConectorBanco {

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

                // Criação de um Statement
                Statement statement = connection.createStatement();

                // Consulta SQL
                String sql = "SELECT * FROM cenas";

                // Execução da consulta
                ResultSet resultSet = statement.executeQuery(sql);

                // Processamento dos resultados
                while (resultSet.next()) {
                    int idCena = resultSet.getInt("idCena");
                    String descricaoCena = resultSet.getString("descricaoCena");
                    System.out.println("ID Cena: " + idCena + ", Descrição: " + descricaoCena);
                }

                // Fechando o ResultSet e o Statement
                resultSet.close();
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
