/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comando190.control.cadastro;

import br.com.comando190.util.salvarDados;
import br.eti.diegofonseca.MaskFieldUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import com.jfoenix.validation.ValidationFacade;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Fernado Luiz
 */
public class ClienteController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private JFXTextField txtRazao;
    @FXML
    private JFXTextField txtFantasia;
    @FXML
    private JFXTextField txtInscEstadual;
    @FXML
    private JFXTextField txtCnpj;
    @FXML
    private JFXTextField txtRua;
    @FXML
    private JFXTextField txtBairro;
    @FXML
    private JFXTextField txtNumero;
    @FXML
    private JFXTextField txtComplemento;
    @FXML
    private JFXTextField txtCep;
    @FXML
    private JFXTextField txtContato;
    @FXML
    private JFXTextField txtTelefone;
    @FXML
    private JFXTextField txtEmail;
    @FXML
    private JFXTextArea txtObs;
    @FXML
    private JFXButton btnCancelar;
    @FXML
    private Pane paneSalvando;
    @FXML
    private Pane paneErro;
    @FXML
    private Pane paneSucesso;
    @FXML
    private Label lblTextoErro;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        mascaras();
    }    
    @FXML
    private void okErro(){
        paneErro.setVisible(false);
    }
    @FXML
    private void okSucesso(){
        paneSucesso.setVisible(false);
    }
    @FXML
    private void cancelar(){
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    private void mascaras(){
        MaskFieldUtil.cnpjField(txtCnpj);
        MaskFieldUtil.foneField(txtTelefone);
        MaskFieldUtil.cepField(txtCep);
        MaskFieldUtil.numericField(txtNumero);
    }
    
    @FXML
    private void salvar() {
        paneSalvando.setVisible(true);
        Thread thread = new Thread(){
            public void run(){
                salvarDados sd = new salvarDados();
                String resultado = sd.Cliente(txtRazao.getText(), txtFantasia.getText(), txtInscEstadual.getText(), txtCnpj.getText(), txtRua.getText(), txtBairro.getText(), txtNumero.getText(), txtComplemento.getText(), txtCep.getText(), txtContato.getText(), txtNumero.getText(), txtEmail.getText(), txtComplemento.getText());
                System.out.print(resultado);
                if (resultado == "true"){
                    paneSalvando.setVisible(false);
                    paneSucesso.setVisible(true);
                    Thread.currentThread().stop();
                }
                if (resultado == "false"){
                    paneSalvando.setVisible(false);
                    lblTextoErro.setText("Falha na conexão com o servidor.");
                    paneErro.setVisible(true);
                    Thread.currentThread().stop();
                } 
            }
        };
        thread.start();

           
            
        
        

    }
    
}
