/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
    
    public boolean tirarCarta(Magica carta) {
        return this.zonaMagica.tirarCarta(carta);
    }
    

    public void matarMounstro(Monstruo monstruo) {
    /** ACA SE TIENE QUE HACER QUE ELIMINE EL MOUNSTRO DE LA ZONA DE CAMPO Y LO AGREGUE AL CEMENTERIO **/
        cementerio.enviarCarta(monstruo);
    }

    public int cantidadCartasCementerio() {
        return cementerio.cantidadCartas();
    }
}
