package repositorio;

import modelo.Objeto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ObjetoDAO {

    public Objeto findObjetoByComandoCorreto(String comandoCorreto) throws SQLException {
        Connection conecaoBanco = BancoDados.getConnection();
        String comandoBanco = "SELECT * FROM objetos WHERE comandoCorreto = ?";
        PreparedStatement comandoEnviado = conecaoBanco.prepareStatement(comandoBanco);
        comandoEnviado.setString(1, comandoCorreto);
        ResultSet rs = comandoEnviado.executeQuery();

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
        comandoEnviado.close();
        conecaoBanco.close();
        return objeto;
    }
}

