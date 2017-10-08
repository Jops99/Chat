package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Sala {

    private final IntegerProperty idSala;
    private final StringProperty desSala; //descrição

    public Sala() {
        this(null, null);
    }

    public Sala(Integer idSala, String desSala) {
        this.idSala = new SimpleIntegerProperty(idSala);
        this.desSala = new SimpleStringProperty(desSala);
    }

    public Integer getIdSala() {
        return idSala.get();
    }
    
    public void setIdSala(Integer idSala) {
        this.idSala.set(idSala);
    }
    
    public IntegerProperty idSalaProperty() {
        return idSala;
    }

    public String getDesSala() {
        return desSala.get();
    }
    
    public void setDesSala(String desSala) {
        this.desSala.set(desSala);
    }
    
    public StringProperty desSalaProperty() {
        return desSala;
    }
}