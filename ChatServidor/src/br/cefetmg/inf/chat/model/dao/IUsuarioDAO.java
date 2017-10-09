package br.cefetmg.inf.chat.model.dao;

import br.cefetmg.inf.chat.model.domain.Usuario;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import java.util.ArrayList;

/**
 *
 * @author Alice
 */
public interface IUsuarioDAO {
    Long inserir(Usuario usuario) throws PersistenciaException; 
    boolean atualizar(Usuario usuario) throws PersistenciaException;
    boolean remover(Usuario usuario) throws PersistenciaException;
    ArrayList<Usuario> listarTodos() throws PersistenciaException;
    Usuario consultarPorId(Long idUsuario) throws PersistenciaException;
}