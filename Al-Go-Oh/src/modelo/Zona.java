/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author mramundo
 */
public abstract class Zona {

    protected final ArrayList<Carta> cartas;

    protected Zona() {
       cartas = new ArrayList<Carta>(5);
    }
    
    
    public boolean colocarCarta(Carta carta) {
        if (this.cartas.size() <= 5 ){
            cartas.add(carta);
            return true;
        }
        return false;   
     }

    public boolean contains(Carta carta) {
       return cartas.contains(carta);
    }

    public int cantidadCartas(){

       return cartas.size();
    }

    public void eliminar(Carta cartaEliminar) {
        
        cartas.remove(cartaEliminar);
        
    }
   
    public boolean zonaVacia(){
    
        return cartas.isEmpty();
    
    }
    
    
    public Carta obtenerCartaPosicion(int indice) {
        return this.cartas.get(indice);
    }
    
}
