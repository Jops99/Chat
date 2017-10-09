package br.cefetmg.inf.chat.model.dao;

import br.cefetmg.inf.chat.model.domain.Sala;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import java.util.ArrayList;

/**
 *
 * @author Alice
 */
public interface ISalaDAO {
    Long inserir(Sala sala) throws PersistenciaException; 
    boolean atualizar(Sala sala) throws PersistenciaException;
    boolean remover(Sala sala) throws PersistenciaException;
    ArrayList<Sala> listarTodos() throws PersistenciaException;
    Sala consultarPorId(Long idSala) throws PersistenciaException;
}
