package br.cefetmg.inf.chat.model.dao;

import br.cefetmg.inf.chat.model.domain.Mensagem;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import java.util.ArrayList;

/**
 *
 * @author Alice
 */
public interface IMensagemDAO {
    Long inserir(Mensagem mensagem) throws PersistenciaException; 
    boolean atualizar(Mensagem mensagem) throws PersistenciaException;
    boolean remover(Mensagem mensagem) throws PersistenciaException;
    ArrayList<Mensagem> listarTodos() throws PersistenciaException;
    Mensagem consultarPorId(Long idMsg) throws PersistenciaException;
}