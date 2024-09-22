package repositorio;

import java.sql.*;

public class InventarioDAO {

    public static void salvarInventario(int idObjeto) throws SQLException {
        Connection conecaoBanco = BancoDados.getConnection();
        PreparedStatement comandoEnviado = null;

            String comandoBanco = "INSERT INTO inventario(idObjeto) VALUES (?)";
            comandoEnviado = conecaoBanco.prepareStatement(comandoBanco);
            comandoEnviado.setInt(1, idObjeto);
            comandoEnviado.execute();
    }


    public static boolean inventarioVazio() throws SQLException {
        Connection conecaoBanco = BancoDados.getConnection();
        String comandoBanco = "SELECT COUNT(*) FROM inventario";
        PreparedStatement comandoEnviado = conecaoBanco.prepareStatement(comandoBanco);
        ResultSet rs = comandoEnviado.executeQuery();

        if (rs.next()) {
            return rs.getInt(1) == 0;  // Retorna true se o inventário estiver vazio
        }
        return true;  // Se houver algum problema, assume-se que está vazio
    }


    public static void limparInventario() throws SQLException {
        Connection conecaoBanco = BancoDados.getConnection();
        PreparedStatement comandoEnviado = null;

        String comandoBanco = "DELETE FROM inventario";
        comandoEnviado = conecaoBanco.prepareStatement(comandoBanco);
        comandoEnviado.execute();
    }
}
