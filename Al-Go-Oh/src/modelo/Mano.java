package modelo;

import java.util.ArrayList;

public class Mano {

    private ArrayList<Carta> cartas;


    public Mano(){
        cartas = new ArrayList<Carta>();
    }

    public boolean estaVacia() {
        return cartas.isEmpty();
    }

    public int cantidadCartas() {
        return cartas.size();
    }


    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public boolean contieneExodia() {
        ArrayList<Carta> exodia = Juego.getJuego().getExodia();
        return this.cartas.containsAll(exodia);
    }
}
