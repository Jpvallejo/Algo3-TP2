/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Hashtable;

/**
 *
 * @author mramundo
 */
public abstract class Zona {

    protected final Hashtable<Casillero, Carta> casilleros;

    protected Zona() {
        casilleros = new Hashtable<>();
    }
    
    public boolean casilleroDisponible() {
       return casilleros.isEmpty();
    }   
    
    public boolean colocarCarta(Carta carta) {
        for (Casillero pos : Casillero.values()) {
            if (!casilleros.containsKey(pos)) {
                casilleros.putIfAbsent(pos,carta);
                return true;
            }
        }

        return false;   
     }

    protected boolean contains(Carta carta) {
       return casilleros.contains(carta);
    }

    public int cantidadCartas(){

       return casilleros.size();
    }

    public void eliminar(Carta carta) {
        for (Casillero key :casilleros.keySet()){
            if (casilleros.get(key).equals(carta)) {
                casilleros.remove(key);
            }
        }
    }

    public Carta obtenerCartaPosicion(Casillero casillero){
        return casilleros.get(casillero);
    }
}
