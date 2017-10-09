/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.chat.controller;

import br.cefetmg.inf.chat.model.domain.Mensagem;
import br.cefetmg.inf.chat.model.domain.Sala;
import br.cefetmg.inf.chat.model.domain.Usuario;
import br.cefetmg.inf.chat.model.service.IManterSala;
import br.cefetmg.inf.chat.model.service.impl.*;
import br.cefetmg.inf.chat.util.db.exception.NegocioException;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaops
 */
public class Proxy{

    String IPServidor = "localhost";
    int PortaServidor = 2223;
    ManterSala manterSala;
    TelaCriarSalaController atributos;
    TelaChatController controller;
    int op;
    
    public Proxy(TelaChatController controller) {
        this.controller = controller;
    }
    
    
 
    public void cadastrarSala(Sala sala) throws PersistenciaException, NegocioException {
       Long result = null;
        try {
            op = 1;
            Socket c = new Socket(IPServidor, PortaServidor);
            ObjectOutputStream saida = new ObjectOutputStream(c.getOutputStream());
            saida.writeInt(op);
            saida.writeObject(sala);
            saida.flush();
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cadastrarUsuario(Usuario usuario) {
          try {
            op = 2;
            Socket c = new Socket(IPServidor, PortaServidor);
            ObjectOutputStream saida = new ObjectOutputStream(c.getOutputStream());
            saida.writeInt(op);
            saida.writeObject(usuario);
            saida.flush();
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMensagem(Mensagem msg) {
            try {
            op = 3;
            Socket c = new Socket(IPServidor, PortaServidor);
            ObjectOutputStream saida = new ObjectOutputStream(c.getOutputStream());
            saida.writeInt(op);
            saida.writeObject(msg);
            saida.flush();
        } catch (IOException ex) {
            Logger.getLogger(Proxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  

}
