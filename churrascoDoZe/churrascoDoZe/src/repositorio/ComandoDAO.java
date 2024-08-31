package repositorio;

import modelo.Comando;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComandoDAO {

    public Comando findComandoByNome(String nome) throws SQLException {
        String sql = "SELECT * FROM comandos WHERE comando = ?";
        try (Connection connection = BancoDados.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, nome);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Comando comando = new Comando();
                    comando.setIdComando(resultSet.getInt("idComando"));
                    comando.setComando(resultSet.getString("comando"));
                    comando.setDescricao(resultSet.getString("descricao"));
                    return comando;
                } else {
                    return null;
                }
            }
        }
    }
}
