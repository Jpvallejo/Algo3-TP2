package modelo.CartasMagicas;

import modelo.*;


public class Wasteland extends CartaCampo{

    //Aumenta el ataque en 200 del jugador que activa la carta y la defensa en 300 del oponente
    @Override
    public void activarEfecto() {
        
        Juego juego = Juego.getJuego();
        Jugador jugadorOponente = juego.getJugadorOponente();
        Jugador jugadorActivo = juego.getJugadorActivo();
        
        jugadorActivo.obtenerCampo().aplicarCartaCampo(200, true);
        jugadorOponente.obtenerCampo().aplicarCartaCampo(300,false);   
    }
        
}
