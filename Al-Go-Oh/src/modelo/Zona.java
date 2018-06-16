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
    //ArrayList<Casillero> casilleros;
    protected final Hashtable<Casillero, Carta> casilleros;

    protected Zona() {
        casilleros = new Hashtable<>();
    }
/*
    protected void crearCasilleros(){  
        for (int i= 0; i< 5; i++){
            Casillero casillero = new Casillero (); 
            casilleros.add(casillero);
        }
    }
  */
    
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

        /*for(Casillero casillero : this.casilleros){
            if(casillero.estaVacio()){
                return casillero.agregarCarta(carta);
            }
        }  */
        return false;   
     }

    protected boolean contains(Carta carta) {
       return casilleros.contains(carta);
    }

    public int cantidadCartas(){
       /* int count = 0;
        for (Casillero casillero: casilleros) {
            if (!casillero.estaVacio()){
                count++;
            }

        }
        return count;*/
       return casilleros.size();
    };

    /*
    public int cartasBocaAbajo(){
        ArrayList<Carta> cartas = new ArrayList<Carta>();
        for (Casillero casillero: casilleros){
            Carta carta = casillero.obtenerCarta();
            if(carta != null && carta.estaBocaAbajo())
                cartas.add(carta);
        }
        return cartas;
    }*/


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
