/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UTIL;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Ateliê do Software Sistemas sobre Medida
 */
public class Alerta {
 
    public Alerta(int tipo, String titulo,String mensagem){
        Alert alert;
        switch(tipo){
            case 1:
                alert = new Alert(AlertType.CONFIRMATION);
                break;
            case 2:
                alert = new Alert(AlertType.ERROR);
                break;
            case 3:
                alert = new Alert(AlertType.INFORMATION);
                break;
            case 4:
                alert = new Alert(AlertType.NONE);
                break;
            default:
                alert = new Alert(AlertType.WARNING);
                break;
        }
        alert.setContentText(mensagem);
        alert.setHeaderText(titulo);
        alert.show();
    }        
}
