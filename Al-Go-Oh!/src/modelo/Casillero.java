/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author mramundo
 */
public class Casillero {

    private boolean disponible;
    private Carta carta;

    public Casillero (){
        disponible = true;
    }
    
    public boolean estaVacio() {
       return this.disponible;
    }

    boolean agregarCarta(Carta carta) {
        this.carta = carta;
        this.disponible = false;
        return true;
    }

    public boolean contiene(Carta carta) {
        return this.carta == carta;
    }

    public Carta obtenerCarta() {
        return this.carta;
    }

    public void vaciar() {
        this.disponible = true;
        this.carta = null;
    }

    public Carta getCarta() {
        return carta;
    }
}
