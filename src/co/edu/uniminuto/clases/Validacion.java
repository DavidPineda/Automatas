/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniminuto.clases;

import co.edu.uniminuto.mundo.Grafo;
import co.edu.uniminuto.mundo.Nodo;
import co.edu.uniminuto.mundo.Transicion;
import co.edu.uniminuto.vista.PanelDibujo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import sun.swing.BakedArrayList;

/**
 *
 * @author david
 */
public class Validacion {

    private Grafo grafo;
    private char[] expresion;
    private PanelDibujo p;
    private ArrayList frontera;

    public Validacion(Grafo grafo, String expresion, PanelDibujo p) {
        this.grafo = grafo;
        this.expresion = new char[expresion.length()];
        this.p = p;
        for (int i = 0; i < expresion.length(); i++) {
            this.expresion[i] = expresion.charAt(i);
        }
        frontera = new ArrayList();
    }

    public boolean backtracking(char[] solucion, int pos, Nodo nodo) throws InterruptedException {
        boolean exito = false;
        Iterator<Transicion> i = nodo.getTransiciones().iterator();
        do {
            if (i.hasNext()) {
                Transicion t = i.next();
                solucion[pos] = t.getValor().toCharArray()[0];
                if (valido(solucion, pos)) {
                    //frontera.add(nodo);
                    pintarNodo(t.getNodo());
                    if (pos != expresion.length - 1) {
                        exito = backtracking(solucion, pos + 1, t.getNodo());
                    } else {
                        p.rellenarNodo(p.getGraphics(), t.getNodo(), Color.RED);
                        p.pintarEstado(p.getGraphics(), t.getNodo());
                        if (t.getNodo().isEstadoFin()) {
                            exito = true;
                        }/*else{
                         if(frontera.size() > 0 && !frontera.get(frontera.size() - 1).equals(nodo)){
                         exito = backtracking(solucion, pos, (Nodo)frontera.remove(frontera.size() - 1));
                         }
                         }*/

                    }
                }
            }
        } while (!exito && i.hasNext());
        return exito;
    }

    private boolean valido(char[] solucion, int k) {
        for (int i = 0; i <= k; i++) {
            if (solucion[i] != expresion[i]) {
                return false;
            }
        }
        return true;
    }

    private void pintarNodo(Nodo nodo) {
        for (int i = 0; i < 2; i++) {
            try {
                // SI el numero es par se pinta el nodo de rojo
                if (i % 2 == 0) {
                    p.rellenarNodo(p.getGraphics(), nodo, Color.RED);
                } else {
                    p.rellenarNodo(p.getGraphics(), nodo, Color.WHITE);
                    p.pintarEstado(p.getGraphics(), nodo);
                }
                Thread.sleep(500);
            } catch (InterruptedException ex) {

            }
        }
    }
}
