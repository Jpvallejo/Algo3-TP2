package modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modelo.Estados.Estado;
import modelo.Estados.EstadoBocaAbajo;
import modelo.Estados.EstadoSinEstado;
import vista.Botones.BotonCarta;
import vista.ParametrosBoton;

public abstract class Carta{
    protected Estado estado;
    protected String tipo;
    protected String nombre;
    protected Jugador jugador;
    protected String UrlImagen;
    protected String descripcion;

    public Carta(){
        estado = new EstadoSinEstado();
        UrlImagen = "vista/imagenes/"+this.getClass().getSimpleName()+".jpg";
    }

    public void activarEfecto(){}

    public boolean activarEfectoEnAtaque(Monstruo atacante, Monstruo defensor) {
        return false;
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
        estado = new EstadoSinEstado();
        jugador.destruirCarta(this);
    }

/*

    @Override
    public boolean equals(Object carta){
        return this.nombre == ((Carta)carta).nombre;
    }
*/
/*
    @Override
    public boolean equals(Object carta){
        return (this.hashCode() == ((Carta) carta).hashCode());
    }
*/

    public String getUrlImagen(){
        return UrlImagen;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public abstract BotonCarta crearBoton();
}