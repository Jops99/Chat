package br.cefetmg.inf.chat.model.domain;

import java.sql.Timestamp;

/**
 *
 * @author Luana
 */
public class Mensagem {
    
    private Long idMsg;
    private Sala destinoSala;
    private Usuario remetente;
    private Usuario destinatario;
    private Timestamp horaEnvio;
    private String conteudoMsg;

    public Mensagem() {
    }

    public Mensagem(Usuario remetente, Usuario destinatario, Timestamp horaEnvio, String conteudoMsg) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.horaEnvio = horaEnvio;
        this.conteudoMsg = conteudoMsg;
    }

    public Long getIdMsg() {
        return idMsg;
    }

    public void setIdMsg(Long idMsg) {
        this.idMsg = idMsg;
    }

    public Sala getDestinoSala() {
        return destinoSala;
    }

    public void setDestinoSala(Sala destinoSala) {
        this.destinoSala = destinoSala;
    }

    public Usuario getRemetente() {
        return remetente;
    }

    public void setRemetente(Usuario remetente) {
        this.remetente = remetente;
    }

    public Usuario getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Usuario destinatario) {
        this.destinatario = destinatario;
    }

    public Timestamp getHoraEnvio() {
        return horaEnvio;
    }

    public void setHoraEnvio(Timestamp horaEnvio) {
        this.horaEnvio = horaEnvio;
    }

    public String getConteudoMsg() {
        return conteudoMsg;
    }

    public void setConteudoMsg(String conteudoMsg) {
        this.conteudoMsg = conteudoMsg;
    }
}
