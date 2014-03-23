/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniminuto.mundo;

/**
 *
 * @author david
 */
public class Punto {
    
    /**
     * Coordenada x en el plano
     */
    private int x;
    
    /**
     * Coordenada y en el plano
     */
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Constructor de la clase Punto
     */
    public Punto(){
        
    }
    
    /**
     * Constructor de la clase Punto
     * @param x Coordenada x en el plano
     * @param y Coordenada y en el plano
     */
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }
    
}
