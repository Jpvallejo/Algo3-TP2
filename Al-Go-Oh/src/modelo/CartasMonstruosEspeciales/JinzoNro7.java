package modelo.CartasMonstruosEspeciales;


import modelo.Estados.Estado;
import modelo.Jugador;
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
    }


    @Override
    public void atacarMonstruo(Monstruo defensor)
    {
        int puntosAtaque = this.getPuntosAtaque();
        defensor.daniarJugador(puntosAtaque);
    }



    @Override
    public void activarEfectoEnAtaque(Monstruo atacante, Monstruo defensor) {
      /*  if ( ataque.getMonstruoAtacante().equals(this) ){
            int puntosAtaque = this.getPuntosAtaque();
            ataque.getJugadorDefensor().restarPuntosDeVida(puntosAtaque);
        }*/
        //return true;
    }




}
