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

    public Sogen(){
        nombre = "Sogen";
        descripcion = "Efecto: aumenta en 500 los puntos de defensa de tus monstruos, y 200 los puntos de " +
                "ataque de los monstruos de tu oponente";
    }
    
    //Aumenta la defensa en 500 del jugador que activa la carta y el ataque en 200 del oponente
    @Override
    public void activarEfecto() {
        
        Juego juego = Juego.getJuego();
        Jugador jugadorOponente = juego.getJugadorOponente();
        Jugador jugadorActivo = juego.getJugadorActivo();
        
        jugadorActivo.getZonaMonstruo().aplicarCartaCampo(500, false);
        jugadorOponente.getZonaMonstruo().aplicarCartaCampo(200,true);
        
    }
        
}
