package modelo;

import modelo.CartasMagicas.AgujeroNegro;

import java.util.Stack;

import static java.util.Collections.shuffle;

public class Mazo {

    private Stack<Carta> cartas;

    public Mazo(){

        
        cartas = FabricaDeCartas.fabricarMazo();

        shuffle(this.cartas);

    }

    public Carta extaerCarta() {
        return cartas.pop();
    }

    public int getTamanio() {
        return cartas.size();
    }
}
