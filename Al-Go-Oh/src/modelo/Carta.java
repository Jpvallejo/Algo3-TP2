package modelo;

import modelo.Estados.Estado;
import modelo.Estados.EstadoBocaAbajo;
import modelo.Estados.EstadoSinEstado;

public abstract class Carta{
    protected Estado estado;
    protected String tipo;
    protected String nombre;
    protected Jugador jugador;
    protected String UrlImagen;

    public Carta(){
        estado = new EstadoSinEstado();
        UrlImagen = "vista/imagenes/"+this.getClass().getSimpleName()+".jpg";
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
        jugador.destruirCarta(this);
    }


    @Override
    public boolean equals(Object carta){
        return this.nombre == ((Carta)carta).nombre;
    }

    public String getUrlImagen(){
        return UrlImagen;
    }
}