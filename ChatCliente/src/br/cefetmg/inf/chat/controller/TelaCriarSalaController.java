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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author playc
 */
public class TelaCriarSalaController implements Initializable {

    @FXML
    private TextField caixaNomeSala;
    @FXML
    private RadioButton radioPublico;
    @FXML
    private RadioButton radioPrivado;
    @FXML
    private TextField caixaSenha;
    @FXML
    private Button botaoOk;
    @FXML
    private Button botaoCancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
