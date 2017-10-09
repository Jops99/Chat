package br.cefetmg.inf.chat.model.domain;

/**
 *
 * @author Alice
 */
public class Usuario {

    private Long idUsuario;
    private String nomUsuario;
    private Boolean tipoUsuario; //administrador ou usuário comum

    public Usuario() {
    }

    public Usuario(Long idUsuario, String nomUsuario, Boolean tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nomUsuario = nomUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public Boolean getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Boolean tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}
