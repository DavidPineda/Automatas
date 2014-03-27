/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.control;

import co.edu.uniminuto.mundo.Grafo;
import co.edu.uniminuto.clases.CargarDatos;
import co.edu.uniminuto.mundo.Nodo;
import co.edu.uniminuto.mundo.Transicion;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 *
 * @author david
 */
public class Automatas extends JFrame {

    public File abrirVentana() {
        File archivo = null;
        JFileChooser fileChooser = new JFileChooser();
        int respuesta = fileChooser.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            archivo = fileChooser.getSelectedFile();
        }
        return archivo;
    }

    public void armarGrafo(Grafo g) {
        String[][] matriz = g.getTablaTransiciones();
        String[] array = matriz[0];
        Nodo nuevo = null, EstadoSalida = null;

        // Se crean todos los nodos principales de los estados
        for (int i = 1; i < matriz.length - 1; i++) {
            nuevo = new Nodo(matriz[i][0], matriz[i][0].contains("*"));
            // Se toma como un nuevo estado
            if (!g.existNodo(nuevo)) {
                g.addNodo(nuevo);
            }
        }
        // Se crean las transiciones
        for (int i = 1; i < matriz.length - 1; i++) {
            EstadoSalida = g.returnNodo(new Nodo(matriz[i][0]));
            for (int x = 1; x < matriz[0].length - 1; x++) {
                nuevo = new Nodo(matriz[i][x]);
                if(g.existNodo(nuevo)){
                    Transicion t = new Transicion(nuevo, array[x]);
                    EstadoSalida.addTransicion(t);
                }
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Automatas a = new Automatas();
        Grafo grafo = new Grafo();
        File archivo = a.abrirVentana();
        try {
            CargarDatos cd = new CargarDatos(grafo, archivo);
            cd.cargarMatriz();
            a.armarGrafo(grafo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
