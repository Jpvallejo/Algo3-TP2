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
public class ZonaHechizos extends Zona {
    
     public ZonaHechizos(){
    
       super();
    }

    public boolean activarEfectoPrimerCartaTrampa(Ataque ataque) {
        for (Casillero key :casilleros.keySet()){
            if (casilleros.get(key) instanceof CartaTrampa) {
                return casilleros.get(key).activarEfectoEnAtaque(ataque);
            }
        }
         return false;
    }
}
