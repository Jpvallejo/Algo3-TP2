package modelo.CartasMagicas;

import modelo.CartaMagica;
import modelo.Estados.Estado;
import modelo.Juego;

public class OllaDeLaCodicia extends CartaMagica {

    @Override
    public void activarEfecto(){
        Juego.getJuego().getJugadorActivo().extraerCartaDelMazo();
        Juego.getJuego().getJugadorActivo().extraerCartaDelMazo();
    }
}
