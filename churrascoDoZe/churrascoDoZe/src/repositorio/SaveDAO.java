package repositorio;

import modelo.Save;

import java.sql.*;

public class SaveDAO {

    public static Save novoJogo() throws SQLException {
        Connection conn = BancoDados.getConnection();
        String sql = "INSERT INTO jogos_salvos(idCenaAtual) VALUES (1)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet generatedKeys = stmt.getGeneratedKeys();
        Save save = new Save();

        if (generatedKeys.next()){
            save.setIdJogo(generatedKeys.getInt(1));
            save.setCenaAtual(CenaDAO.findCenaById(1));
        }
        return save;
    }
}