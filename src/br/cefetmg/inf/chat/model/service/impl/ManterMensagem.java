package br.cefetmg.inf.chat.model.service.impl;

import br.cefetmg.inf.chat.model.dao.IMensagemDAO;
import br.cefetmg.inf.chat.model.dao.impl.MensagemDAO;
import br.cefetmg.inf.chat.model.domain.Mensagem;
import br.cefetmg.inf.chat.model.service.IManterMensagem;
import br.cefetmg.inf.chat.util.db.exception.NegocioException;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Alice
 */
public class ManterMensagem implements IManterMensagem {

    private IMensagemDAO mensagemDAO;

    public ManterMensagem() {
        mensagemDAO = new MensagemDAO();
    }

    @Override
    public Long cadastrar(Mensagem mensagem) throws PersistenciaException, NegocioException {
        if (mensagem.getIdMsg() == null) {
            throw new NegocioException("É obrigatório informar o id da mensagem.");
        }

        if (mensagem.getDestinoSala() == null) {
            throw new NegocioException("É obrigatório informar a sala de destino da mensagem.");
        }

        if (mensagem.getRemetente() == null) {
            throw new NegocioException("É obrigatório informar o remetente.");
        }

        if (mensagem.getDestinatario() == null) {
            throw new NegocioException("É obrigatório informar o destinatário.");
        }

        if (mensagem.getHoraEnvio() == null) {
            throw new NegocioException("É obrigatório informar a hora de envio da mensagem.");
        }

        if ((mensagem.getConteudoMsg() == null) || (mensagem.getConteudoMsg().isEmpty())) {
            throw new NegocioException("É obrigatório escrever a mensagem.");
        }

        Long result = mensagemDAO.inserir(mensagem);
        return result;
    }

    @Override
    public boolean alterar(Mensagem mensagem) throws PersistenciaException, NegocioException {
        if (mensagem.getIdMsg() == null) {
            throw new NegocioException("É obrigatório informar o id da mensagem.");
        }

        if (mensagem.getDestinoSala() == null) {
            throw new NegocioException("É obrigatório informar a sala de destino da mensagem.");
        }

        if (mensagem.getRemetente() == null) {
            throw new NegocioException("É obrigatório informar o remetente.");
        }

        if (mensagem.getDestinatario() == null) {
            throw new NegocioException("É obrigatório informar o destinatário.");
        }

        if (mensagem.getHoraEnvio() == null) {
            throw new NegocioException("É obrigatório informar a hora de envio da mensagem.");
        }

        if ((mensagem.getConteudoMsg() == null) || (mensagem.getConteudoMsg().isEmpty())) {
            throw new NegocioException("É obrigatório escrever a mensagem.");
        }

        boolean result = mensagemDAO.atualizar(mensagem);
        return result;
    }

    @Override
    public boolean excluir(Mensagem mensagem) throws PersistenciaException, NegocioException {
        boolean result = mensagemDAO.remover(mensagem);
        return result;
    }

    @Override
    public List<Mensagem> pesquisarTodos() throws PersistenciaException {
        List<Mensagem> result = mensagemDAO.listarTodos();
        return result;
    }

    @Override
    public Mensagem pesquisarPorId(Long idMsg) throws PersistenciaException {
        Mensagem result = mensagemDAO.consultarPorId(idMsg);
        return result;
    }
}
