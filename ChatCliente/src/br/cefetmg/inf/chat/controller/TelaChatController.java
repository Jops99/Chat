/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.chat.controller;

import br.cefetmg.inf.chat.model.domain.Mensagem;
import br.cefetmg.inf.chat.model.domain.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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

    public AnchorPane getScrollPaneSalas() {
        return scrollPaneSalas;
    }

    public void setScrollPaneSalas(AnchorPane scrollPaneSalas) {
        this.scrollPaneSalas = scrollPaneSalas;
    }

    public AnchorPane getScrollPaneUsuarios() {
        return scrollPaneUsuarios;
    }

    public void setScrollPaneUsuarios(AnchorPane scrollPaneUsuarios) {
        this.scrollPaneUsuarios = scrollPaneUsuarios;
    }

    public TextArea getCaixaMensagens() {
        return caixaMensagens;
    }

    public void setCaixaMensagens(TextArea caixaMensagens) {
        this.caixaMensagens = caixaMensagens;
    }

    public TextField getCaixaMensagem() {
        return caixaMensagem;
    }

    public void setCaixaMensagem(TextField caixaMensagem) {
        this.caixaMensagem = caixaMensagem;
    }

    public Button getBotaoRemoverUsuario() {
        return botaoRemoverUsuario;
    }

    public void setBotaoRemoverUsuario(Button botaoRemoverUsuario) {
        this.botaoRemoverUsuario = botaoRemoverUsuario;
    }

    public Button getBotaoCriarSala() {
        return botaoCriarSala;
    }

    public void setBotaoCriarSala(Button botaoCriarSala) {
        this.botaoCriarSala = botaoCriarSala;
    }

    public Button getBotaoEnviar() {
        return botaoEnviar;
    }

    public void setBotaoEnviar(Button botaoEnviar) {
        this.botaoEnviar = botaoEnviar;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void invocaCriarSala(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TelaCriarSala.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    private void mandarMensagem() {
        Proxy proxy = new Proxy(this);
       // Usuario usr = new Usuario(Long.MIN_VALUE, nomUsuario, Boolean.TRUE);
       // Mensagem msg = new Mensagem(remetente, destinatario, horaEnvio, conteudoMsg);
       //  msg.setConteudoMsg(getCaixaMensagem().getText());
       // proxy.enviarMensagem(msg);
    }
}
