import modelo.CartasMagicas.AgujeroNegro;
import modelo.CartasMagicas.CilindroMagico;
import modelo.CartasMagicas.Sogen;
import modelo.CartasMagicas.Wasteland;
import modelo.CartasMonstruosEspeciales.InsectoComeHombres;
import modelo.CartasMonstruosEspeciales.JinzoNro7;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import static java.util.Collections.shuffle;

public class Mazo {

    private static final Cartas cartas = new Cartas();
    private int cantidadCartas = 40;
    public Mazo(){ }

    public Carta extaerCarta() {
        if(cantidadCartas <= 0) throw new MazoVacioException();
        cantidadCartas--;
        return cartas.obtenerUnaCartaAleatoria();
    }

    public int getTamanio() {
        return cantidadCartas;
    }
}
