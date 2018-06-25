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

    public void invocar(Monstruo monstruo) {
        monstruo.requiereSacrificios(0);

        Tablero campo = this.obtenerCampo();
        monstruo.setEstado(new EstadoAtaque());
        monstruo.asociarJugador(this);
        campo.tirarCarta(monstruo);
    }

    public void invocar(Monstruo monstruo, Monstruo sacrificio1) {
        monstruo.requiereSacrificios(1);
        sacrificio1.destruir();

        Tablero campo = this.obtenerCampo();
        monstruo.setEstado(new EstadoAtaque());
        monstruo.asociarJugador(this);
        campo.tirarCarta(monstruo);
    }

    public void invocar(Monstruo monstruo, Monstruo sacrificio1, Monstruo sacrificio2) {
        monstruo.requiereSacrificios(2);
        sacrificio1.destruir();
        sacrificio2.destruir();

        Tablero campo = this.obtenerCampo();
        monstruo.setEstado(new EstadoAtaque());
        monstruo.asociarJugador(this);
        campo.tirarCarta(monstruo);
    }

    public void colocar(Monstruo monstruo){
        Tablero campo = this.obtenerCampo();
        monstruo.setEstado(new EstadoAtaque());
        monstruo.setEstado(new EstadoDefensaBocaAbajo());
        monstruo.asociarJugador(this);
        campo.tirarCarta(monstruo);
    }

    public void colocar(Monstruo monstruo, Monstruo sacrificio1){
        sacrificio1.destruir();
        Tablero campo = this.obtenerCampo();
        monstruo.setEstado(new EstadoAtaque());
        monstruo.setEstado(new EstadoDefensaBocaAbajo());
        monstruo.asociarJugador(this);
        campo.tirarCarta(monstruo);
    }

    public void colocar(Monstruo monstruo, Monstruo sacrificio1, Monstruo sacrificio2){

        sacrificio1.destruir();
        sacrificio2.destruir();
        Tablero campo = this.obtenerCampo();
        monstruo.setEstado(new EstadoAtaque());
        monstruo.setEstado(new EstadoDefensaBocaAbajo());
        monstruo.asociarJugador(this);
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

    public void activarCartaTrampa(Monstruo atacante, Monstruo defensor) {
        tablero.activarEfectoCartaTrampa(atacante,defensor);
    }

    public boolean contieneExodia(){
        return this.mano.contieneExodia();
    }
}
