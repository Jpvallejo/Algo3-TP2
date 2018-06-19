/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.CartasMagicas;

import modelo.*;

/**
 *
 * @author mramundo
 */
public class Sogen extends CartaCampo  {
    
    
    //Aumenta la defensa en 500 del jugador que activa la carta y el ataque en 200 del oponente
    @Override
    public void activarEfecto() {
        
        Juego juego = Juego.getJuego();
        Jugador jugadorOponente = juego.getJugadorOponente();
        Jugador jugadorActivo = juego.getJugadorActivo();
        
        jugadorActivo.obtenerCampo().aplicarCartaCampo(500, false);
        jugadorOponente.obtenerCampo().aplicarCartaCampo(200,true);  
        
        
    }
        
}
