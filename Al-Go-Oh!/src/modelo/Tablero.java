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
    
    private boolean noHayZona;
    private ZonaMagica zonaMagica;
    private Cementerio cementerio;

    
    
    public Tablero (){
    
        this.noHayZona = true;
        this.zonaMagica = new ZonaMagica ();
        this.cementerio = new Cementerio();
        this.agregarCasilleros(zonaMagica);
    }
    
    private void agregarCasilleros(Zona zona){
        Casillero casillero = new Casillero();
        zona.agregarCasillero(casillero);
    }
    
    
    public boolean estaVacio() {
        return noHayZona;
    }

    
    public boolean tirarCartaEnZonaMagica() {
        return this.zonaMagica.tirarCarta();
    }

    public void matarMounstro(Monstruo monstruo) {
    /** ACA SE TIENE QUE HACER QUE ELIMINE EL MOUNSTRO DE LA ZONA DE CAMPO Y LO AGREGUE AL CEMENTERIO **/
        cementerio.enviarCarta(monstruo);
    }

    public int cantidadCartasCementerio() {
        return cementerio.cantidadCartas();
    }
}
