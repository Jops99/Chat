package br.cefetmg.inf.chat.model.domain;

/**
 *
 * @author Alice
 */
public class Sala {

    private Long idSala;
    private String desSala; //descrição

    public Sala() {
    }

    public Sala(Long idSala, String desSala) {
        this.idSala = idSala;
        this.desSala = desSala;
    }

    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
    }

    public String getDesSala() {
        return desSala;
    }

    public void setDesSala(String desSala) {
        this.desSala = desSala;
    }
}
