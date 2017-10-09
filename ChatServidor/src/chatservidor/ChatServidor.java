/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatservidor;

import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author jaops
 */
public class ChatServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ServerSocket s = new ServerSocket(2230);
            while (true){
                Socket p = s.accept();
                Adapter m = new Adapter(p);
                new Thread(m).start();
            }
        } catch (Exception e) {
        }
    }
    
}
