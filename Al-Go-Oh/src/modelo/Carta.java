package modelo;

public abstract class Carta{
    protected Estado estado;
    protected String tipo;
    protected String nombre;
    protected Jugador jugador;

    public Carta(){
        estado = new EstadoSinEstado();
    }

    public void activarEfecto(){}

    public void activarEfectoEnAtaque(Monstruo atacante, Monstruo defensor) {}

    public boolean estaBocaAbajo(){
        return estado instanceof EstadoBocaAbajo;
    }

    public String getNombre(){
        return this.nombre;
    };

    public Estado getEstado(){
        return estado;
    };

    public void setEstado(Estado _estado) {
        estado = _estado;
    }

    public void asociarJugador(Jugador _jugador) {
        jugador = _jugador;
    }

    public void destruir(){
        jugador.obtenerCampo().destruirCarta(this);
    }


}