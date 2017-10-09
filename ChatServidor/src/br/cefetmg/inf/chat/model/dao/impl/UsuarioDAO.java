package br.cefetmg.inf.chat.model.dao.impl;

import br.cefetmg.inf.chat.model.dao.IUsuarioDAO;
import br.cefetmg.inf.chat.model.domain.Usuario;
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
public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public Long inserir(Usuario usuario) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Usuario(nomUsuario, tipoUsuario) VALUES(?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, usuario.getNomUsuario());
            pstmt.setBoolean(2, usuario.getTipoUsuario());
            ResultSet rs = pstmt.executeQuery();

            Long idUsuario = null;
            if (rs.next()) {
                idUsuario = new Long(rs.getLong("idUsuario"));
                usuario.setIdUsuario(idUsuario);
            }

            rs.close();
            pstmt.close();
            connection.close();

            return idUsuario;

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean atualizar(Usuario usuario) throws PersistenciaException {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Usuario "
                    + " SET nomeUsuario = ?, "
                    + " SET tipoUsuario = ? "
                    + " WHERE idUsuario = ? ";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, usuario.getNomUsuario());
            pstmt.setBoolean(2, usuario.getTipoUsuario());
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
    public boolean remover(Usuario usuario) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM Usuario WHERE idUsuario = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, usuario.getIdUsuario());
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
    public ArrayList<Usuario> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Usuario ORDER BY idUsuario";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Usuario> listAll = null;

            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(rs.getLong("idUsuario"));
                    usuario.setNomUsuario(rs.getString("nomUsuario"));
                    usuario.setTipoUsuario(rs.getBoolean("tipoUsuario"));
                    listAll.add(usuario);
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
    public Usuario consultarPorId(Long idUsuario) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Usuario WHERE idUsuario = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, idUsuario);
            ResultSet rs = pstmt.executeQuery();

            Usuario usuario = null;

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(rs.getLong("idUsuario"));
                usuario.setNomUsuario(rs.getString("nomUsuario"));
                usuario.setTipoUsuario(rs.getBoolean("tipoUsuario"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return usuario;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}
