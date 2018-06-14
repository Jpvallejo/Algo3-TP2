/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author mramundo
 */
public abstract class Zona {
    ArrayList<Casillero> casilleros; 

    public void agregarCasillero(Casillero casillero) {
        casilleros.add(casillero);
        
    }

    public boolean casilleroDisponible() {
         for(Casillero casillero : this.casilleros){
            if(casillero.estaVacio())return true; 
        }  
        return false;
    }   
    
    public boolean tirarCarta() {
        for(Casillero casillero : this.casilleros){
            if(casillero.estaVacio()){
                return casillero.agregarCarta();
                
            }
        }  
        return false;   
        
     
     }
    
    
}
