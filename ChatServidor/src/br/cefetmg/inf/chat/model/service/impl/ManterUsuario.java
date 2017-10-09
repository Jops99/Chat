package br.cefetmg.inf.chat.model.service.impl;

import br.cefetmg.inf.chat.model.dao.IUsuarioDAO;
import br.cefetmg.inf.chat.model.dao.impl.UsuarioDAO;
import br.cefetmg.inf.chat.model.domain.Usuario;
import br.cefetmg.inf.chat.model.service.IManterUsuario;
import br.cefetmg.inf.chat.util.db.exception.NegocioException;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Alice
 */
public class ManterUsuario implements IManterUsuario {

    private IUsuarioDAO usuarioDAO;

    public ManterUsuario() {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    public Long cadastrar(Usuario usuario) throws PersistenciaException, NegocioException {
        if (usuario.getIdUsuario() == null) {
            throw new NegocioException("É obrigatório informar o id do usuário.");
        }

        if ((usuario.getNomUsuario() == null) || (usuario.getNomUsuario().isEmpty())) {
            throw new NegocioException("É obrigatório informar o nome do usuário.");
        }

        if (usuario.getTipoUsuario() == null) {
            throw new NegocioException("É obrigatório informar o tipo de usuário (administrador ou comum).");
        }

        Long result = usuarioDAO.inserir(usuario);
        return result;
    }

    @Override
    public boolean alterar(Usuario usuario) throws PersistenciaException, NegocioException {
        if (usuario.getIdUsuario() == null) {
            throw new NegocioException("É obrigatório informar o id do usuário.");
        }

        if ((usuario.getNomUsuario() == null) || (usuario.getNomUsuario().isEmpty())) {
            throw new NegocioException("É obrigatório informar o nome do usuário.");
        }

        if (usuario.getTipoUsuario() == null) {
            throw new NegocioException("É obrigatório informar o tipo de usuário (administrador ou comum).");
        }

        boolean result = usuarioDAO.atualizar(usuario);
        return result;
    }

    @Override
    public boolean excluir(Usuario usuario) throws PersistenciaException, NegocioException {
        boolean result = usuarioDAO.remover(usuario);
        return result;
    }

    @Override
    public List<Usuario> pesquisarTodos() throws PersistenciaException {
        List<Usuario> result = usuarioDAO.listarTodos();
        return result;
    }

    @Override
    public Usuario pesquisarPorId(Long idUsuario) throws PersistenciaException {
        Usuario result = usuarioDAO.consultarPorId(idUsuario);
        return result;
    }
}
