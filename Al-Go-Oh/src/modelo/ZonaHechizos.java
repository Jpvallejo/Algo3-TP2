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

    public void activarEfectoPrimerCartaTrampa(Monstruo atacante, Monstruo defensor) {
        for (int i = 0; i < this.cantidadCartas(); i++){
            if (this.cartas.get(i) instanceof CartaTrampa) {
                CartaTrampa cartaTrampa = (CartaTrampa) this.cartas.get(i);
                cartaTrampa.activarEfectoEnAtaque(atacante,defensor);
                
            }
        }
    }

    
}
