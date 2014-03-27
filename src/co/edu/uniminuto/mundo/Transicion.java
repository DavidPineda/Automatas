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
public class Transicion {

    /**
     * El nodo al cual hace referencia
     */
    private Nodo nodo;

    /**
     * El valor con el cual hace la transicion
     */
    private String valor;

    /**
     * todos los puntos con las coordenadas por donde se pintara la transicion
     */
    private Collection<Punto> puntos;

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Collection<Punto> getPuntos() {
        return puntos;
    }

    /**
     * Constructor de la clase Transicion
     *
     * @param nodo El nodo hacia el cual apunta la transicion
     * @param valor El valor que lleva la transicion
     */
    public Transicion(Nodo nodo, String valor) {
        this.nodo = nodo;
        this.valor = valor;
        
    }

    /**
     * Permite agregar un punto a la transicion
     * @param punto El punto a agregar a la coleccion
     */
    public void addPunto(Punto punto) {
        try {
            puntos.add(punto);
        } catch (Exception ex) {
            throw ex;
        }
    }

}
