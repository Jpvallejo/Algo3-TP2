/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.CartasMagicas.CartaCampoSinEfecto;

/**
 *
 * @author mramundo
 */
public class Tablero {
  
    private ZonaHechizos zonaHechizos;
    private ZonaMonstruo zonaMonstruo;
    private Cementerio cementerio;
    private CartaCampo cartaCampo;
      
    public Tablero (){
    
        this.zonaHechizos = new ZonaHechizos();
        this.zonaMonstruo = new ZonaMonstruo();
        this.cementerio = new Cementerio();
        this.cartaCampo = new CartaCampoSinEfecto();
    }
    
    public boolean tirarCarta(CartaTrampa carta){
        return this.zonaHechizos.colocarCarta(carta);
    }

    public boolean tirarCarta(Monstruo carta) {
        carta.asociarTablero(this);
        return this.zonaMonstruo.colocarCarta(carta);
    }
    
    public void tirarCarta(CartaCampo carta) {
        carta.asociarTablero(this);
        this.cartaCampo = carta;
    }
    
    public boolean tirarCarta(CartaMagica carta) {
        carta.asociarTablero(this);
        if ( this.zonaHechizos.colocarCarta(carta) ){
            if (carta.getEstado() == Colocacion.BOCAARRIBA ){
                carta.activarEfecto();
            }
            return true;
        }
        return false;

    }

    public int cantidadCartasCementerio() {
        return cementerio.cantidadCartas();
    }

    public int cantidadCartasZonaMonstruos() {
        return this.zonaMonstruo.cantidadCartas();
    }

    public int cantidadCartasZonaMagicas() {
        return this.zonaHechizos.cantidadCartas();
    }

    public ZonaMonstruo getZonaMonstruo(){
        return this.zonaMonstruo;
    }

    public ZonaHechizos getZonaHechizos() {
        return this.zonaHechizos;
    }

    public void destruirZonaMonstruos(){
        //zonaMonstruo.destruirZona(cementerio);
        zonaMonstruo.destruirZona();
    }

    public void destruirCarta(Carta carta) {
        this.zonaHechizos.eliminar(carta);
        this.cementerio.enviarCarta(carta);
    }


    public void matarMonstruo(Monstruo monstruo) {
        this.zonaMonstruo.eliminar(monstruo);
        this.cementerio.enviarCarta(monstruo);
    }



    public void sacrificarMonstruos(int cantidad) {
        this.zonaMonstruo.sacrificarMonstruos(cementerio, cantidad);
    }
    
    public Monstruo obtenerMonstruoEnCasillero(Casillero casillero) {
        return (Monstruo) zonaMonstruo.obtenerCartaPosicion(casillero);
    }
    
    
    public void aplicarCartaCampo(int adicional, boolean ataque){
        this.zonaMonstruo.aplicarCartaCampo(adicional, ataque);    
    }
    
    
    
    public void activarCartaCampo (){
        this.cartaCampo.activarEfecto();
    }
    
    
     public void revertirCartaCampo (){
        this.getZonaMonstruo().revertirCartaCampo();
    }
    

    public boolean activarEfectoCartaTrampa(Jugador atacante, Jugador defensor, Monstruo monstruoAtacante) {

        return zonaHechizos.activarEfectoPrimerCartaTrampa(atacante,defensor,monstruoAtacante);
    }
}
