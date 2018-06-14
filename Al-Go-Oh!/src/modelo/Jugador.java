package modelo;

public class Jugador {
    private Tablero tablero;
    private int puntosDeVida;

    public Jugador(){
        tablero = new Tablero();
        puntosDeVida = 8000;
    }

    public Tablero obtenerCampo(){
        return this.tablero;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

    public void setPuntosDeVida(int puntosDeVida) {
        this.puntosDeVida = puntosDeVida;
    }

    public int cantidadCartasCementerio() {

        return tablero.cantidadCartasCementerio();
    }

    public void colocarCarta(Monstruo carta) {


    }

    public void colocarCarta(CartaMagica carta) {


    }
}
