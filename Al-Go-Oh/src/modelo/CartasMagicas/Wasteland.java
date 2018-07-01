package modelo.CartasMagicas;

import modelo.*;


public class Wasteland extends CartaCampo{

    public Wasteland(){
        nombre = "Wasteland";
        descripcion = "Efecto: aumenta en 200 puntos el ataque de tus monstruos, y 300 puntos la " +
                "defensa de los monstruos de tu oponente";
    }

    @Override
    public void activarEfecto() {
        
        Juego juego = Juego.getJuego();
        Jugador jugadorOponente = juego.getJugadorOponente();
        Jugador jugadorActivo = juego.getJugadorActivo();
        
        jugadorActivo.getZonaMonstruo().aplicarCartaCampo(200, true);
        jugadorOponente.getZonaMonstruo().aplicarCartaCampo(300,false);
    }
        
}
