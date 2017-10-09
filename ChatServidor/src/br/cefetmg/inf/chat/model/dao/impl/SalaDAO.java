package br.cefetmg.inf.chat.model.dao.impl;

import br.cefetmg.inf.chat.model.dao.ISalaDAO;
import br.cefetmg.inf.chat.model.domain.Sala;
import br.cefetmg.inf.chat.util.db.ConnectionManager;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alice
 */
public class SalaDAO implements ISalaDAO {

    @Override
    public Long inserir(Sala sala) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Sala(desSala) VALUES(?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, sala.getDesSala());
            ResultSet rs = pstmt.executeQuery();

            Long idSala = null;
            if (rs.next()) {
                idSala = new Long(rs.getLong("idSala"));
                sala.setIdSala(idSala);
            }

            rs.close();
            pstmt.close();
            connection.close();

            return idSala;

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean atualizar(Sala sala) throws PersistenciaException {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Sala "
                    + " SET desSala = ? "
                    + " WHERE idMsg = ? ";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, sala.getDesSala());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean remover(Sala sala) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM Sala WHERE idSala = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, sala.getIdSala());
            pstmt.executeUpdate();

            pstmt.close();
            connection.close();

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<Sala> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Sala ORDER BY idSala";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Sala> listAll = null;

            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Sala sala = new Sala();
                    sala.setIdSala(rs.getLong("idSala"));
                    sala.setDesSala(rs.getString("desSala"));
                    listAll.add(sala);
                } while (rs.next());
            }

            rs.close();
            pstmt.close();
            connection.close();

            return listAll;

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public Sala consultarPorId(Long idSala) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Sala WHERE idSala = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, idSala);
            ResultSet rs = pstmt.executeQuery();

            Sala sala = null;

            if (rs.next()) {
                sala = new Sala();
                sala.setIdSala(rs.getLong("idSala"));
                sala.setDesSala(rs.getString("desSala"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return sala;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}
