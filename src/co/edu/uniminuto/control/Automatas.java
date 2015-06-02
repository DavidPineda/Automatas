/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.control;

import co.edu.uniminuto.vista.VentanaInicio;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class Automatas {

    public void init() {
        String alfabeto = JOptionPane.showInputDialog("Ingrese el alfabeto");
        VentanaInicio v = new VentanaInicio(alfabeto);
        v.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Automatas a = new Automatas();
            a.init();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
