package br.cefetmg.inf.chat.util.db.exception;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alice
 */
public class NegocioException extends Exception {

    private List<String> msgs;

    public NegocioException() {
        this.msgs = new ArrayList();
    }

    public NegocioException(String msg, Exception exception) {
        super(msg, exception);
    }

    public NegocioException(String msg) {
        super(msg);
    }

    public NegocioException(List<String> msgs) {
        this.msgs = msgs;
    }

    public List<String> getMessages() {
        return this.msgs;
    }
}
