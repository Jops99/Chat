package br.cefetmg.inf.chat.controller;

import br.cefetmg.inf.chat.model.domain.Sala;
import br.cefetmg.inf.chat.util.db.exception.NegocioException;
import br.cefetmg.inf.chat.util.db.exception.PersistenciaException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
    @FXML
    private Label labelSenha;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        radioPublico.setSelected(true);
        
        labelSenha.setVisible(false);
        caixaSenha.setVisible(false);
    }

    public TextField getCaixaNomeSala() {
        return caixaNomeSala;
    }

    public RadioButton getRadioPublico() {
        return radioPublico;
    }

    public RadioButton getRadioPrivado() {
        return radioPrivado;
    }

    public TextField getCaixaSenha() {
        return caixaSenha;
    }

    public Button getBotaoOk() {
        return botaoOk;
    }

    public Button getBotaoCancelar() {
        return botaoCancelar;
    }

    public Label getLabelSenha() {
        return labelSenha;
    }
    
    @FXML
    private void clickPublico(ActionEvent event) {
        radioPublico.setSelected(true);
        radioPrivado.setSelected(false);
        
        labelSenha.setVisible(false);
        caixaSenha.setVisible(false);
    }

    @FXML
    private void clickPrivado(ActionEvent event) {
        radioPublico.setSelected(false);
        radioPrivado.setSelected(true);
        
        labelSenha.setVisible(true);
        caixaSenha.setVisible(true);
    }

    @FXML
    private void inserir(ActionEvent event) throws PersistenciaException, NegocioException {
        if(!validacao()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Criar sala");
            alert.setHeaderText("Erro ao criar sala");
            alert.setContentText("Insira os campos corretamente!!!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Criar sala");
            alert.setHeaderText("Sucesso!");
            alert.setContentText("A sala foi criada com sucesso!!!");
            alert.showAndWait();
            
            Proxy proxy = new Proxy(this);
            String desSala = getCaixaNomeSala().getText();
            Sala sala = new Sala();
            sala.setDesSala(desSala);
            sala.setIdSala((long)1);
            proxy.cadastrarSala(sala);
            
            Stage stage = (Stage)botaoOk.getScene().getWindow(); //Obtendo a janela atual
            stage.close(); //Fechando o Stage
        }
    }

    @FXML
    private void cancelar(ActionEvent event) {
        Stage stage = (Stage)botaoCancelar.getScene().getWindow(); //Obtendo a janela atual
        stage.close(); //Fechando o Stage
    }
    
    private boolean validacao() {
        boolean validacao = true;
        
        if(caixaNomeSala.getText().isEmpty()) {
            validacao = false;
        }
        
        if(radioPrivado.isSelected() && caixaSenha.getText().isEmpty()) {
            validacao = false;
        }
        
        return validacao;
    }
}