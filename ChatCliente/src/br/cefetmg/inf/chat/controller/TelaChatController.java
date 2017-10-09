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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author playc
 */
public class TelaChatController implements Initializable {

    @FXML
    private TextField caixaMensagem;
    @FXML
    private Button botaoEnviar;
    @FXML
    private Button botaoPrivado;
    @FXML
    private AnchorPane painelUsuarios;
    @FXML
    private AnchorPane painelSalas;
    @FXML
    private Label labelLogadoComo;
    @FXML
    private Label labelUser;
    @FXML
    private AnchorPane painelMensagens;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
