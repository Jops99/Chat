package Model;

import java.sql.Timestamp;

public class Mensagem {
    private Sala idSala;
    private Usuario remetente;  
    private Usuario destinatario;
    private Timestamp horaEnvio;
    private Long idMsg;
    private String conteudoMsg;

    
    public Mensagem () {}
            
            
    public Mensagem(Usuario remetente, Usuario destinatario, Timestamp horaEnvio, String conteudoMsg) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.horaEnvio = horaEnvio;
        this.conteudoMsg = conteudoMsg;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
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

    public Long getIdMsg() {
        return idMsg;
    }

    public void setIdMsg(Long idMsg) {
        this.idMsg = idMsg;
    }

    public String getConteudoMsg() {
        return conteudoMsg;
    }

    public void setConteudoMsg(String conteudoMsg) {
        this.conteudoMsg = conteudoMsg;
    }
}