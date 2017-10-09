/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.chat.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author playc
 */
public class TelaChatController implements Initializable {

    @FXML
    private AnchorPane scrollPaneSalas;
    @FXML
    private AnchorPane scrollPaneUsuarios;
    @FXML
    private TextArea caixaMensagens;
    @FXML
    private TextField caixaMensagem;
    @FXML
    private Button botaoRemoverUsuario;
    @FXML
    private Button botaoCriarSala;
    @FXML
    private Button botaoEnviar;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
