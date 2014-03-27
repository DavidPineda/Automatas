/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.clases;

import co.edu.uniminuto.mundo.Grafo;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author david
 */
public class CargarDatos {

    /**
     * Grafo en el cual se cargan los datos
     */
    private Grafo grafo;

    /**
     * El lector del archivo plano
     */
    private Scanner lector;

    /**
     * Archivo que se lee
     */
    private File archivo;

    public File getRutaArchivo() {
        return archivo;
    }

    public void setRutaArchivo(File archivo) {
        this.archivo = archivo;
    }

    /**
     * Constructor de la clase para cargar el archivo de datos
     *
     * @param grafo El grafo en el cual se va a cargar el automata
     * @param archivo Archivo con los datos parametrizados
     * @throws FileNotFoundException Si no se encuentra el archivo especificado
     */
    public CargarDatos(Grafo grafo, File archivo) throws FileNotFoundException {
        this.grafo = grafo;
        lector = new Scanner(archivo);
    }

    public void cargarMatriz() throws Exception {
        if (lector == null) {
            throw new Exception("EL lector esta nulo");
        }

        try {
            
            //La matriz de transiciones
            String[][] matrizTran = generarMatriz();
            //Se agrega la matriz a la clase grafo
            grafo.setTablaTransiciones(matrizTran);

        } catch (Exception ex) {
            throw new Exception("Se genero un error al armar la matriz de transiciones");
        }
    }

    private String[][] generarMatriz() {
 
        try {
            // Se toma el número de estados del automata
            int cantEstados = Integer.parseInt(lector.nextLine());
            // Se dividen cada caracter separados por ,
            String[] CarAlfabeto = lector.nextLine().split(",");
            //Se arma la matriz que representa el grafo
            String[][] matrizGrafo = new String[++cantEstados][CarAlfabeto.length+1];

            for(int i = 1; i <= CarAlfabeto.length; i++){
                matrizGrafo[0][i] = CarAlfabeto[i - 1];
            }
            
            int fila = 1;
            while(lector.hasNext()){
                CarAlfabeto = lector.nextLine().split(",");
                if(CarAlfabeto.length == matrizGrafo[0].length){
                    matrizGrafo[fila++] = CarAlfabeto;
                }
            }
            lector.close();
            return matrizGrafo;
            
        } catch (Exception ex) {
            throw ex;
        }
    }
}