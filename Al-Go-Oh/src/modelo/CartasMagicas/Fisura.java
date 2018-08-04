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
public class Fisura extends CartaMagica {

    public Fisura(){
        nombre = "Fisura";
        descripcion = "Efecto: destruye el monstruo boca arriba con menor ataque en el campo del oponente" +
                " (si hay empate elige al azar)";
    }
    @Override
    public void activarEfecto(){
        Juego juego = Juego.getJuego();
        Jugador jugadorOponente = juego.getJugadorOponente();
        
        jugadorOponente.destruirMonstruoConMenorAtaque();
       
        this.destruir();
    }
    
    
    
}
