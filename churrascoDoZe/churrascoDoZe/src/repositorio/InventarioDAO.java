package repositorio;

import modelo.Inventario;
import modelo.Save;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO {

    public static Inventario salvarInventario(int idObjeto) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet generatedKeys = null;
        Inventario inventario = new Inventario();

            conn = BancoDados.getConnection();
            String sql = "INSERT INTO inventario(idObjeto) VALUES (?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, idObjeto);

            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    inventario.setIdInventario(generatedKeys.getInt(1));
                    inventario.setIdObjeto(idObjeto);
                }
            } else {
                throw new SQLException("Creating inventario failed, no rows affected.");
            }

        return inventario;
    }


    public static boolean inventarioVazio() throws SQLException {
        Connection conn = BancoDados.getConnection();
        String sql = "SELECT COUNT(*) FROM inventario";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt(1) == 0;  // Retorna true se o inventário estiver vazio
        }
        return true;  // Se houver algum problema, assume-se que está vazio
    }


    public static int contarItensInventario() throws SQLException {
        int quantidadeItens = 0;
        String query = "SELECT COUNT(*) FROM Inventario";

        try (Connection conn = BancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                quantidadeItens = rs.getInt(1);  // Recupera a quantidade de itens
            }
        }
        return quantidadeItens;
    }


    public static boolean itemJaNoInventario(int idObjeto) throws SQLException {
        String query = "SELECT COUNT(*) FROM Inventario WHERE idObjeto = ?";
        boolean jaExiste = false;

        try (Connection conn = BancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, idObjeto);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    jaExiste = rs.getInt(1) > 0;
                }
            }
        }
        return jaExiste;
    }


    public static void limparInventario() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet generatedKeys = null;
        Inventario inventario = new Inventario();

        conn = BancoDados.getConnection();
        String sql = "DELETE FROM inventario";
        stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            generatedKeys = stmt.getGeneratedKeys();
        } else {
            throw new SQLException("Creating inventario failed, no rows affected.");
        }
    }
}