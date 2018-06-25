package modelo;

import modelo.Monstruos.*;

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

    public void quitarCarta(Carta cartaAQuitar){
        /* Si no se quita el override, se debe usar esto
        int i = 0;
        for( Carta carta : cartas){
            if ( carta == cartaAQuitar ){
                cartas.remove(i);
            }
            i++;
        }
        */

        // Si se quita el override, se puede usar esto
        cartas.remove(cartaAQuitar);
    }



    public boolean contieneExodia() {
        /* Si no se quita el override, se debe usar esto
        ArrayList<Carta> exodia = Juego.getJuego().getExodia();
        return this.cartas.containsAll(exodia);*/

        /* Si se quita el override, esta es una posibilidad */
        if (buscarInstancia(new BrazoIzquierdoExodia())
            && buscarInstancia(new BrazoDerechoExodia())
            && buscarInstancia(new PiernaDerechaExodia())
            && buscarInstancia(new PiernaIzquierdaExodia())
            && buscarInstancia(new CabezaExodia()) ){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean buscarInstancia(Carta cartaABuscar){
        for( Carta carta : cartas){
            if ( carta.getNombre() == cartaABuscar.getNombre() ) {
                return true;
            }
        }
        return false;
    }
}
