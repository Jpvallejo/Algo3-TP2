package modelo;

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
