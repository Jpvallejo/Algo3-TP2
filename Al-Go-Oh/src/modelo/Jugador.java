package modelo;

import modelo.Monstruos.AgujaAsesina;

import java.awt.*;
import java.io.IOException;

public class Jugador {
    private Tablero tablero;
    private int puntosDeVida;
    private Mano mano;
    private Mazo mazo;



    public Jugador(){
        tablero = new Tablero();
        puntosDeVida = 8000;
        this.mazo  = new Mazo();
        this.mano = new Mano();
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

    public void restarPuntosDeVida(int puntosDeVidaMenos){
        puntosDeVida -= puntosDeVidaMenos;
    }

    public int cantidadCartasCementerio() {

        return tablero.cantidadCartasCementerio();
    }
/*
    public void colocarEnAtaque(Monstruo monstruo){
        Tablero  campo = this.obtenerCampo();
        monstruo.asociarTablero(campo);
        if(monstruo.requiereSacrificio())
        {
            this.sacrificarMonstruos(monstruo.cantidadASacrificar());
        }
        monstruo.setPosicion(Posicion.ATAQUE);
        monstruo.setEstado(Colocacion.BOCAARRIBA);
        campo.tirarCarta(monstruo);
    }
*/
    private void sacrificarMonstruos(int cantidad) {
        this.tablero.sacrificarMonstruos(cantidad);
    }


    public void colocar(Monstruo monstruo){
        Tablero campo = this.obtenerCampo();
        monstruo.setEstado(new EstadoAtaque());
        if(monstruo.requiereSacrificio())
        {
            this.sacrificarMonstruos(monstruo.cantidadASacrificar());
        }
        monstruo.setEstado(new EstadoDefensaBocaAbajo());
        monstruo.asociarJugador(this);
        //monstruo.asociarTablero(campo);
        campo.tirarCarta(monstruo);
    }

    public void colocarCarta(CartaMagica carta){
        carta.setEstado(new EstadoBocaAbajo());
        carta.asociarJugador(this);
        this.obtenerCampo().tirarCarta(carta);
    }

    public void activarCarta(CartaMagica carta){
        carta.setEstado(new EstadoBocaArriba());
        carta.asociarJugador(this);
        this.obtenerCampo().activarCarta(carta);
    }


    public void colocarCarta(CartaTrampa carta) {
        carta.setEstado(new EstadoBocaAbajo());
        carta.asociarJugador(this);
        this.obtenerCampo().tirarCarta(carta);
    }
    
    public void colocarCarta(CartaCampo carta) {
        this.obtenerCampo().tirarCarta(carta);
    }
        
    
    public void declararAtaqueDePosicionAPosicion(Jugador defensor, Casillero casilleroAtacante, Casillero casilleroDefensor) {
        
        Monstruo monstruoAtacante = tablero.obtenerMonstruoEnCasillero(casilleroAtacante);
        
        if (casilleroDefensor != Casillero.PUNTOSVIDA) {
            Monstruo monstruoDefensor = defensor.obtenerCampo().obtenerMonstruoEnCasillero(casilleroDefensor);

            monstruoAtacante.atacarMonstruo(monstruoDefensor);

        }
        else{
            monstruoAtacante.atacar(defensor);
        }

    }

    public Mano getMano() {
        return mano;
    }

    public void extraerCartaDelMazo() {
        Carta carta = mazo.extaerCarta();
        mano.agregarCarta(carta);
    }

    public void activarCartaCampo() {
        this.obtenerCampo().activarCartaCampo();
    }
       


    public int obtenerTamanioMazo() {
        return this.getMazo().getTamanio();
    }

    private Mazo getMazo() {
        return this.mazo;
    }

    public void invocar(Monstruo monstruo) {
        Tablero campo = this.obtenerCampo();
        monstruo.setEstado(new EstadoAtaque());
        if(monstruo.requiereSacrificio())
        {
            this.sacrificarMonstruos(monstruo.cantidadASacrificar());
        }
        monstruo.asociarJugador(this);
        campo.tirarCarta(monstruo);
    }

    public void activarCartaTrampa(Monstruo atacante, Monstruo defensor) {
        tablero.activarEfectoCartaTrampa(atacante,defensor);
    }
}
