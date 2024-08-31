package repositorio;

import modelo.Objeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjetoDAO {

    // Método para encontrar um objeto pelo ID
    public Objeto findObjetoById(Integer id) throws SQLException {
        Connection conn = BancoDados.getConnection();
        String sql = "SELECT * FROM objetos WHERE idObjeto = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        Objeto objeto = null;
        if (rs.next()) {
            objeto = new Objeto();
            objeto.setIdObjeto(rs.getInt("idObjeto"));
            objeto.setIdCena(rs.getInt("idCena"));
            objeto.setNomeObjeto(rs.getString("nomeObjeto"));
            objeto.setDescricaoObjeto(rs.getString("descricaoObjeto"));
            objeto.setResultadoPositivo(rs.getString("resultadoPositivo"));
            objeto.setResultadoNegativo(rs.getString("resultadoNegativo"));
            objeto.setComandoCorreto(rs.getString("comandoCorreto"));
            objeto.setProximaCena(rs.getInt("proximaCena"));
            objeto.setPodeCarregar(rs.getBoolean("podeCarregar"));
        }

        rs.close();
        stmt.close();
        conn.close();
        return objeto;
    }

    // Método para listar todos os objetos de uma cena
    public List<Objeto> findObjetosByCena(Integer idCena) throws SQLException {
        Connection conn = BancoDados.getConnection();
        String sql = "SELECT * FROM objetos WHERE idCena = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idCena);
        ResultSet rs = stmt.executeQuery();

        List<Objeto> objetos = new ArrayList<>();
        while (rs.next()) {
            Objeto objeto = new Objeto();
            objeto.setIdObjeto(rs.getInt("idObjeto"));
            objeto.setIdCena(rs.getInt("idCena"));
            objeto.setNomeObjeto(rs.getString("nomeObjeto"));
            objeto.setDescricaoObjeto(rs.getString("descricaoObjeto"));
            objeto.setResultadoPositivo(rs.getString("resultadoPositivo"));
            objeto.setResultadoNegativo(rs.getString("resultadoNegativo"));
            objeto.setComandoCorreto(rs.getString("comandoCorreto"));
            objeto.setProximaCena(rs.getInt("proximaCena"));
            objeto.setPodeCarregar(rs.getBoolean("podeCarregar"));
            objetos.add(objeto);
        }

        rs.close();
        stmt.close();
        conn.close();
        return objetos;
    }
}
