/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.CartasMagicas;

import modelo.CartaMagica;
import modelo.Colocacion;
import modelo.Juego;
import modelo.Jugador;

/**
 *
 * @author mramundo
 */
public class Fisura extends CartaMagica {
    
    
    public Fisura(Colocacion colocacion) {
        this.estado =  colocacion;
    }
     
    @Override
    public void activarEfecto(){
        Juego juego = Juego.getJuego();
        Jugador jugadorOponente = juego.getJugadorOponente();
        
        jugadorOponente.obtenerCampo().destruirMonstruoConMenorAtaque();
       
        this.destruir();
    }
    
    
    
}
