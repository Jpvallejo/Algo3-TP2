package fiuba.algo3.tp2;

import java.util.ArrayList;

public class ZonaCementerio extends Zona {

    // Esta bien hacer que casilleros
    private ArrayList<Carta> cartas;

    public ZonaCementerio(){

        this.cartas = new ArrayList<Carta>();
    }


    public void enviarCarta(Carta carta) {
        cartas.add(carta);
    }

    public Carta buscarCarta(Carta carta) {
        return carta;
    }


    public boolean estaVacio(){
        return cartas.isEmpty();
    };
}
