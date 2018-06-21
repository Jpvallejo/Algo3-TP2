package modelo.CartasMagicas;

import modelo.CartaMagica;
import modelo.Colocacion;
import modelo.Juego;

public class OllaDeLaCodicia extends CartaMagica {
    public OllaDeLaCodicia(Colocacion tipoColocacion) {
    }
    public OllaDeLaCodicia(){}
    @Override
    public void activarEfecto(){
        Juego.getJuego().getJugadorActivo().extraerCartaDelMazo();
        Juego.getJuego().getJugadorActivo().extraerCartaDelMazo();
    }
}
