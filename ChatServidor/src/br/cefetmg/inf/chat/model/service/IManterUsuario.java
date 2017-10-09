package br.cefetmg.inf.chat.model.service;

import br.cefetmg.inf.chat.model.domain.Usuario;
import br.cefetmg.inf.chat.util.db.exception.NegocioException;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Alice
 */
public interface IManterUsuario {
    Long cadastrar(Usuario usuario) throws PersistenciaException, NegocioException;
    boolean alterar(Usuario usuario) throws PersistenciaException, NegocioException;
    boolean excluir(Usuario usuario) throws PersistenciaException, NegocioException;
    List<Usuario> pesquisarTodos() throws PersistenciaException;
    Usuario pesquisarPorId(Long idUsuario) throws PersistenciaException; 
}