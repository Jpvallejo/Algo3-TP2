/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import modelo.CartasMagicas.AgujeroNegro;

/**
 *
 * @author mramundo
 */
public class Tablero {
  
    private ZonaMagica zonaMagica;
    private ZonaMonstruo zonaMonstruo;
    private Cementerio cementerio;
      
    public Tablero (){
    
        this.zonaMagica = new ZonaMagica ();
        this.zonaMonstruo = new ZonaMonstruo();
        this.cementerio = new Cementerio();
    }
    
    
    public boolean tirarCarta(Monstruo carta) {
        return this.zonaMonstruo.tirarCarta(carta);
    }
    
    public boolean tirarCarta(CartaMagica carta) {
        if ( this.zonaMagica.tirarCarta(carta) ){
            if (carta.getColocacion() == Colocacion.BOCAARRIBA ){
                carta.activarEfecto();
            }
            return true;
        }
        return false;

    }
    

    public void matarMounstro(Monstruo monstruo) {
        this.zonaMonstruo.eliminar(monstruo);
        this.cementerio.enviarCarta(monstruo);
    }

    public int cantidadCartasCementerio() {
        return cementerio.cantidadCartas();
    }

    public int cantidadCartasZonaMonstruos() {
        return this.zonaMonstruo.cantidadCartas();
    }

    public int cantidadCartasZonaMagicas() {
        return this.zonaMagica.cantidadCartas();
    }
    public ZonaMonstruo getZonaMonstruo(){
        return this.zonaMonstruo;
    }

    public ZonaMagica getZonaMagica() {
        return this.zonaMagica;
    }

    public void destruirZonaMonstruos(){
        zonaMonstruo.destruirZona(cementerio);
    }

    public void destruirCarta(Carta carta) {
        this.zonaMagica.eliminar(carta);
        this.cementerio.enviarCarta(carta);
    }
}
