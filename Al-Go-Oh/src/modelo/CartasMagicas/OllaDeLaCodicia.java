package modelo.CartasMagicas;

import modelo.CartaMagica;
import modelo.Estados.Estado;
import modelo.Juego;

public class OllaDeLaCodicia extends CartaMagica {

    public OllaDeLaCodicia(){
        nombre = "Olla de La Codicia";
        descripcion = "Efecto: toma 2 cartas del mazo";
    }

    @Override
    public void activarEfecto(){
        Juego.getJuego().getJugadorActivo().extraerCartaDelMazo();
        Juego.getJuego().getJugadorActivo().extraerCartaDelMazo();
        this.destruir();
    }
}
