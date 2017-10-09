package br.cefetmg.inf.chat.model.service;

import br.cefetmg.inf.chat.model.domain.Mensagem;
import br.cefetmg.inf.chat.util.db.exception.NegocioException;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Alice
 */
public interface IManterMensagem {
    Long cadastrar(Mensagem mensagem) throws PersistenciaException, NegocioException;
    boolean alterar(Mensagem mensagem) throws PersistenciaException, NegocioException;
    boolean excluir(Mensagem mensagem) throws PersistenciaException, NegocioException;
    List<Mensagem> pesquisarTodos() throws PersistenciaException;
    Mensagem pesquisarPorId(Long idMsg) throws PersistenciaException;   
}