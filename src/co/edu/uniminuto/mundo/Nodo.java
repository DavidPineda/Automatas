/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniminuto.mundo;

import java.util.Collection;

/**
 *
 * @author david
 */
public class Nodo {
    
    /**
     * Estado del Nodo, Indica si es de finalización o no
     */
    private boolean estadoFin;

    /**
     * Array con todos los hijos del 
     */
    private Collection<Transicion> transiciones;
    
    /**
     * Nombre del Nodo
     */
    private String nombre;
    
    /**
     * Centro del circulo para graficar el nodo
     */
    private Punto centro;
    
    /**
     * Radio del circulo del Nodo
     */
    private int radio;
    
    public boolean isEstadoFin() {
        return estadoFin;
    }

    public void setEstadoFin(boolean estadoFin) {
        this.estadoFin = estadoFin;
    }
    
    public Collection<Transicion> getTransiciones(){
        return transiciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }
    
    /**
     * Constructor vacio de Nodo
     * @param nombre Nombre del nodo
     */
    public Nodo(String nombre){
        this.nombre = nombre;
        estadoFin = false;
    }
    
    /**
     * Constructor Con estado Inicial
     * @param nombre Nombre del Nodo
     * @param estadoFIn Estado Inicial del Nodo
     */
    public Nodo(String nombre, boolean estadoFIn){
        this.nombre = nombre;
        this.estadoFin = estadoFIn;
    }
    
    /**
     * Permite agregar Transiciones al Nodo
     * @param transicion Transicion que se agrega al nodo
     */
    public void addTransicion(Transicion transicion){
        try{
            transiciones.add(transicion);
        }catch(Exception ex){
            throw ex;
        }
    }
    
}
