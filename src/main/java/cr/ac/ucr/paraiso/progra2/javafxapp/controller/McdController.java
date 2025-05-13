/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.ucr.paraiso.progra2.javafxapp.controller;

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


public class McdController implements Initializable {

    @FXML
    private TextField tfNumero1;
    @FXML
    private TextField tfNumero2;

    private Socket socket;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       this.socket = MainApp.getSocket();
    }
    public void onClickedBtnCalcular(ActionEvent event) throws IOException {
        int p = Integer.parseInt(tfNumero1.getText());
        int q = Integer.parseInt(tfNumero2.getText());
        new Alert(Alert.AlertType.INFORMATION, "El mcd de " + tfNumero1.getText() +
                " y " + tfNumero2.getText() + " es " + calcularMcd(p, q) ).showAndWait();
        
        
    }
    public int calcularMcd(int p, int q){
       int maximoDivisor = 1;
       if (p==0 || q == 0)
           return maximoDivisor;
       else{
           int i = 2;
           while(i<=p && i<=q){
               if(p%i==0 && q%i==0)
                   maximoDivisor=i;
               i++;
           }
           return maximoDivisor;
       }//else
    }
    
}
