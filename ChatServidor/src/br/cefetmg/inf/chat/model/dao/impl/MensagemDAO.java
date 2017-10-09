package br.cefetmg.inf.chat.model.dao.impl;

import br.cefetmg.inf.chat.model.dao.IMensagemDAO;
import br.cefetmg.inf.chat.model.domain.Mensagem;
import br.cefetmg.inf.chat.model.domain.Sala;
import br.cefetmg.inf.chat.model.domain.Usuario;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import br.cefetmg.inf.chat.util.db.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alice
 */
public class MensagemDAO implements IMensagemDAO {

    @Override
    public Long inserir(Mensagem mensagem) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "INSERT INTO Mensagem(destinoSala, remetente, destinatario, horaEnvio, conteudoMsg) VALUES(?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setObject(1, mensagem.getDestinoSala());
            pstmt.setObject(2, mensagem.getRemetente());
            pstmt.setObject(3, mensagem.getDestinatario());
            pstmt.setTimestamp(4, mensagem.getHoraEnvio());
            pstmt.setString(5, mensagem.getConteudoMsg());
            ResultSet rs = pstmt.executeQuery();

            Long idMsg = null;
            if (rs.next()) {
                idMsg = new Long(rs.getLong("idMsg"));
                mensagem.setIdMsg(idMsg);
            }

            rs.close();
            pstmt.close();
            connection.close();

            return idMsg;

        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }

    @Override
    public boolean atualizar(Mensagem mensagem) throws PersistenciaException {
        try {

            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "UPDATE Mensagem "
                    + " SET destinoSala = ?, "
                    + "     remetente = ?, "
                    + "     destinatario = ?, "
                    + "     horaEnvio = ?, "
                    + "     conteudoMsg = ? "
                    + " WHERE idMsg = ? ";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setObject(1, mensagem.getDestinoSala());
            pstmt.setObject(2, mensagem.getRemetente());
            pstmt.setObject(3, mensagem.getDestinatario());
            pstmt.setTimestamp(4, mensagem.getHoraEnvio());
            pstmt.setString(5, mensagem.getConteudoMsg());
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
    public boolean remover(Mensagem mensagem) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "DELETE FROM Mensagem WHERE idMsg = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, mensagem.getIdMsg());
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
    public ArrayList<Mensagem> listarTodos() throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Mensagem ORDER BY idMsg";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Mensagem> listAll = null;

            if (rs.next()) {
                listAll = new ArrayList<>();
                do {
                    Mensagem mensagem = new Mensagem();
                    mensagem.setIdMsg(rs.getLong("idMsg"));
                    mensagem.setDestinoSala((Sala) rs.getObject("destinoSala"));
                    mensagem.setRemetente((Usuario) rs.getObject("remetente"));
                    mensagem.setDestinatario((Usuario) rs.getObject("destinario"));
                    mensagem.setHoraEnvio(rs.getTimestamp("horaEnvio"));
                    mensagem.setConteudoMsg(rs.getString("conteudoMsg"));
                    listAll.add(mensagem);
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
    public Mensagem consultarPorId(Long idMsg) throws PersistenciaException {
        try {
            Connection connection = ConnectionManager.getInstance().getConnection();

            String sql = "SELECT * FROM Mensagem WHERE idMsg = ?";

            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, idMsg);
            ResultSet rs = pstmt.executeQuery();

            Mensagem mensagem = null;

            if (rs.next()) {
                mensagem = new Mensagem();
                mensagem.setIdMsg(rs.getLong("idMsg"));
                mensagem.setDestinoSala((Sala) rs.getObject("destinoSala"));
                mensagem.setRemetente((Usuario) rs.getObject("remetente"));
                mensagem.setDestinatario((Usuario) rs.getObject("destinario"));
                mensagem.setHoraEnvio(rs.getTimestamp("horaEnvio"));
                mensagem.setConteudoMsg(rs.getString("conteudoMsg"));
            }

            rs.close();
            pstmt.close();
            connection.close();

            return mensagem;
        } catch (Exception e) {
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage(), e);
        }
    }
}
