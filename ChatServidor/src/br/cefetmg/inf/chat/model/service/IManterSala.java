package br.cefetmg.inf.chat.model.service;

import br.cefetmg.inf.chat.model.domain.Sala;
import br.cefetmg.inf.chat.util.db.exception.NegocioException;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Alice
 */
public interface IManterSala {
    Long cadastrar(Sala sala) throws PersistenciaException, NegocioException;
    boolean alterar(Sala sala) throws PersistenciaException, NegocioException;
    boolean excluir(Sala sala) throws PersistenciaException, NegocioException;
    List<Sala> pesquisarTodos() throws PersistenciaException;
    Sala pesquisarPorId(Long idSala) throws PersistenciaException;
}