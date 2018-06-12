/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuba.algo3.tp2;

/**
 *
 * @author mramundo
 */
public class Tablero {
    
    boolean noHayZona;
    ZonaMagica zonaMagica;
    
    
    public Tablero (){
    
        this.noHayZona = true;
        this.zonaMagica = new ZonaMagica ();
        this.agregarCasilleros(zonaMagica);
    }
    
    private void agregarCasilleros(Zona zona){
        Casillero casillero = new Casillero();
        zona.agregarCasillero(casillero);
    }
    
    
    boolean estaVacio() {
        return noHayZona;
    }

    
    boolean tirarCartaEnZonaMagica() {
        return this.zonaMagica.tirarCarta();
    }
    
}
