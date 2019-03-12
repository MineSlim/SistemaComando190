/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comando190.control.cadastro;

import br.com.comando190.model.Clientes;
import br.com.comando190.util.DAO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void cancelar(){
        Stage stage = (Stage) btnCancelar.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void salvar() {
        paneSalvando.setVisible(true);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Comando190");
        EntityManager em = emf.createEntityManager();

        Clientes cc = new Clientes();
        cc.setRazao(txtRazao.getText());
        cc.setFantasia(txtFantasia.getText());
        cc.setInscEstadual(txtInscEstadual.getText());
        cc.setCnpj(txtCnpj.getText());
        
        cc.setRua(txtRua.getText());
        cc.setBairro(txtBairro.getText());
        cc.setNumero(Integer.parseInt(txtNumero.getText()));
        cc.setComplemento(txtComplemento.getText());
        cc.setCep(txtCep.getText());
        
        cc.setContato(txtContato.getText());
        cc.setTelefone(txtTelefone.getText());
        cc.setEmail(txtEmail.getText());
        
        cc.setObs(txtObs.getText());
        
        em.getTransaction().begin();
        em.persist(cc);
        em.getTransaction().commit();
        paneSalvando.setVisible(false);
    }
    
}
