/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniminuto.mundo;

import java.util.ArrayList;
import java.util.Collection;

/**
 * clase contenedora de todos los nodos del sistema
 * @author david
 */
public class Grafo {
    
    /**
     * Lista que contiene todos los nodos del sistema
     */
    private Collection<Nodo> nodos;
    
    /**
     * Tabla de transicios del automata
     */
    private String[][] tablaTransiciones;
    
    public Collection<Nodo> getNodos(){
        return nodos;
    }

    public String[][] getTablaTransiciones() {
        return tablaTransiciones;
    }

    public void setTablaTransiciones(String[][] tablaTransiciones) {
        this.tablaTransiciones = tablaTransiciones;
    }
    
    /**
     * Constructor de incio del Grafo
     */
    public Grafo(){
        nodos = new ArrayList<>();
        tablaTransiciones = null;
    }
    
    /**
     * Permite adicionar Nodos al Grafo
     * @param nodo  
     */
    public void addNodo(Nodo nodo){
        try{
            nodos.add(nodo);
        }catch(Exception ex){
            throw ex;
        }
    }
    
    public void addEstadoTabla(String estado, int fila, int columna){
        try{
            tablaTransiciones[fila][columna] = estado;
        }catch(Exception ex){
            throw ex;
        }
    }
}
