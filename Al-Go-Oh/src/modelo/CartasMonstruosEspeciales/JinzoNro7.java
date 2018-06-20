package modelo.CartasMonstruosEspeciales;

import modelo.Jugador;
import modelo.Monstruo;
import modelo.Posicion;

public class JinzoNro7 extends Monstruo {

    public JinzoNro7(Posicion posicion){
        super();
        this.puntosAtaque = 500;
        this.puntosDefensa = 400;
        this.adicionalesDeAtaque = 0;
        this.adicionalesDeDefensa = 0;
        this.posicion = posicion;
        this.estrellas = 2;
    }


    @Override
    public void atacarMonstruo(Jugador atacante, Jugador defensor, Monstruo objetivo)
    {
        int puntosAtaque = this.getPuntosAtaque();
        defensor.restarPuntosDeVida(puntosAtaque);
    }



}
