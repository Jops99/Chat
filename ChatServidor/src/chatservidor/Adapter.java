/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatservidor;

import br.cefetmg.inf.chat.model.service.IManterSala;
import java.io.ObjectInputStream;
import java.net.Socket;
import br.cefetmg.inf.chat.controller.Proxy;
import br.cefetmg.inf.chat.model.dao.impl.SalaDAO;
import br.cefetmg.inf.chat.model.domain.Mensagem;
import br.cefetmg.inf.chat.model.domain.Sala;
import br.cefetmg.inf.chat.model.domain.Usuario;
import br.cefetmg.inf.chat.model.service.impl.ManterMensagem;
import br.cefetmg.inf.chat.model.service.impl.ManterSala;
import br.cefetmg.inf.chat.model.service.impl.ManterUsuario;
/**
 *
 * @author jaops
 */
public class Adapter implements Runnable {

    private final Socket p;

    public Adapter(Socket p) {
        this.p = p;
    }
    
    @Override
    public void run() {
        try {
            int op;
            ObjectInputStream entrada = new ObjectInputStream(p.getInputStream());
            op = entrada.readInt();
            switch(op){
                case 1: 
                    Sala s = (Sala) entrada.readObject();
                    ManterSala manterSala = new ManterSala();
                    manterSala.cadastrar(s);
                break;
                
                case 2:
                     Usuario u = (Usuario) entrada.readObject();
                     ManterUsuario manterUsuario =  new ManterUsuario();
                     manterUsuario.cadastrar(u);
                break;
                
                case 5: 
                    Mensagem m = (Mensagem) entrada.readObject();
                    ManterMensagem manterMensagem = new ManterMensagem();
                    manterMensagem.cadastrar(m);
                break;
            }
            
            
            
        } catch (Exception e) {
        }
    }
    
}
