package Model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario {

    private final IntegerProperty idUsuario;
    private final StringProperty nomUsuario;
    private final BooleanProperty tipoUsuario; //administrador ou usuário comum

    public Usuario() {
        this(null, null, null);
    }

    public Usuario(Integer idUsuario, String nomUsuario, Boolean tipoUsuario) {
        this.idUsuario = new SimpleIntegerProperty(idUsuario);
        this.nomUsuario = new SimpleStringProperty(nomUsuario);
        this.tipoUsuario = new SimpleBooleanProperty(tipoUsuario);
    }

    public Integer getIdUsuario() {
        return idUsuario.get();
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario.set(idUsuario);
    }

    public IntegerProperty idUsuarioProperty() {
        return idUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario.get();
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario.set(nomUsuario);
    }

    public StringProperty nomUsuarioProperty() {
        return nomUsuario;
    }

    public Boolean getTipoUsuario() {
        return tipoUsuario.get();
    }

    public void setTipoUsuario(Boolean tipoUsuario) {
        this.tipoUsuario.set(tipoUsuario);
    }

    public BooleanProperty tipoUsuarioProperty() {
        return tipoUsuario;
    }
}