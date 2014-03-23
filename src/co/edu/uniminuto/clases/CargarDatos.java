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
     * Ruta del archivo con las entradas
     */
    private String rutaArchivo;

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
   
    /**
     * Constructor de la clase para cargar el archivo de datos
     * @param grafo El grafo en el cual se va a cargar el automata
     * @param rutaArchivo Ruta del archivo con los datos
     * @throws FileNotFoundException Si no se encuentra el archivo especificado
     */
    public CargarDatos(Grafo grafo, String rutaArchivo) throws FileNotFoundException{
        this.grafo = grafo;
        this.rutaArchivo = rutaArchivo;
        
        try{
            File archivo = new File(rutaArchivo);
            lector = new Scanner(archivo);
        }catch(FileNotFoundException ex){
            throw new FileNotFoundException("No se encuentra el archivo de datos");
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void cargarGrafo() throws Exception{
        if(lector == null){
            throw new Exception("EL lector esta nulo");
        }
        
        try{
            int cantEstados = lector.nextInt();
        }catch(Exception ex){
            
        }
        
    }
    
}
