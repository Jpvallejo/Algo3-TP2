package modelo;

import java.util.ArrayList;

public class Mano {

    private ArrayList<Carta> cartas;


    public Mano(){
        cartas = new ArrayList<>();
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
}
