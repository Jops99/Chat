package br.cefetmg.inf.chat.model.service.impl;

import br.cefetmg.inf.chat.model.dao.ISalaDAO;
import br.cefetmg.inf.chat.model.dao.impl.SalaDAO;
import br.cefetmg.inf.chat.model.domain.Sala;
import br.cefetmg.inf.chat.model.service.IManterSala;
import br.cefetmg.inf.chat.util.db.exception.NegocioException;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Alice
 */
public class ManterSala implements IManterSala {

    private ISalaDAO salaDAO;

    public ManterSala() {
        salaDAO = new SalaDAO();
    }

    @Override
    public Long cadastrar(Sala sala) throws PersistenciaException, NegocioException {
        if (sala.getIdSala() == null) {
            throw new NegocioException("É obrigatório informar o id da sala.");
        }

        if ((sala.getDesSala() == null) || (sala.getDesSala().isEmpty())) {
            throw new NegocioException("É obrigatório adicionar uma descrição para a sala.");
        }

        Long result = salaDAO.inserir(sala);
        return result;
    }

    @Override
    public boolean alterar(Sala sala) throws PersistenciaException, NegocioException {
        if (sala.getIdSala() == null) {
            throw new NegocioException("É obrigatório informar o id da sala.");
        }

        if ((sala.getDesSala() == null) || (sala.getDesSala().isEmpty())) {
            throw new NegocioException("É obrigatório adicionar uma descrição para a sala.");
        }

        boolean result = salaDAO.atualizar(sala);
        return result;
    }

    @Override
    public boolean excluir(Sala sala) throws PersistenciaException, NegocioException {
        boolean result = salaDAO.remover(sala);
        return result;
    }

    @Override
    public List<Sala> pesquisarTodos() throws PersistenciaException {
        List<Sala> result = salaDAO.listarTodos();
        return result;
    }

    @Override
    public Sala pesquisarPorId(Long idSala) throws PersistenciaException {
        Sala result = salaDAO.consultarPorId(idSala);
        return result;
    }
}
