package modelo;

public abstract class Carta{
    protected Colocacion estado;
    protected String tipo;
    protected String nombre;
    protected Tablero tableroCarta;

    public Carta(){
        estado = Colocacion.BOCAARRIBA;
    }

    public void activarEfecto(){}

    public boolean activarEfectoEnAtaque(Jugador atacante, Jugador defensor, Monstruo monstruoAtacante) {
        return false;
    }

    public boolean estaBocaAbajo(){
        return estado == Colocacion.BOCAABAJO;
    }

    public String getNombre(){
        return this.nombre;
    };

    public Colocacion getEstado(){
        return estado;
    };

    public void setEstado(Colocacion colocacion) {
        estado = colocacion;
    }

    public void asociarTablero(Tablero tablero) {
        tableroCarta = tablero;
    }

    public void asociarJugador(Jugador jugador) {
        tableroCarta = jugador.obtenerCampo();
    }



    public void destruir(){
        tableroCarta.destruirCarta(this);
    }
}