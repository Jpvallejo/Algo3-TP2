package modelo.CartasMonstruosEspeciales;


import modelo.Estados.Estado;
import modelo.Estados.EstadoMonstruo;
import modelo.Monstruo;

public class JinzoNro7 extends Monstruo {

    public JinzoNro7(Estado estado){
        super();
        this.puntosAtaque = 500;
        this.puntosDefensa = 400;
        this.adicionalesDeAtaque = 0;
        this.adicionalesDeDefensa = 0;
        this.estado = estado;
        this.estrellas = 2;
        this.nombre = "Jinzo Nro 7.";
        this.descripcion = "ataca directamente a los puntos de vida del oponente";
    }


    @Override
    public void atacarMonstruo(Monstruo defensor)
    {
        int puntosAtaque = this.getPuntosAtaque();
        ((EstadoMonstruo) estado).verificarAtaque();
        defensor.daniarJugador(puntosAtaque);
    }

}
