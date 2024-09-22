package repositorio;

import modelo.Cena;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CenaDAO {

    // Método estático para buscar a cena pelo ID
    public static Cena findCenaById(Integer id) throws SQLException {
        Connection conecaoBanco = BancoDados.getConnection();
        String comandoBanco = "SELECT * FROM cenas WHERE idCena = ?";
        PreparedStatement comandoEnviado = conecaoBanco.prepareStatement(comandoBanco);
        comandoEnviado.setInt(1, id);
        ResultSet resultSet = comandoEnviado.executeQuery();

        Cena cena = null;
        if (resultSet.next()) {
            cena = new Cena();
            cena.setIdCena(resultSet.getInt("idCena"));
            cena.setDescricao(resultSet.getString("descricaoCena"));
        }

        resultSet.close();
        comandoEnviado.close();
        conecaoBanco.close();
        return cena;
    }
}
