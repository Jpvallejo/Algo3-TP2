/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.Iterator;

/**
 *
 * @author mramundo
 */
public class ZonaMonstruo extends Zona{
    
    public ZonaMonstruo(){
    
        super();
    }

/*
    public boolean declararAtaque(Monstruo atacante, Monstruo defensor) {
        ZonaMonstruo zonaOponente = Juego.getJuego().getJugadorOponente().obtenerCampo().getZonaMonstruo();
        if (defensor == null && zonaOponente.cantidadCartas() == 0)
            atacante.atacarPuntosDeVida();
        else if (defensor != null && zonaOponente.contains(defensor))
            atacante.atacarMonstruo(defensor);
        else
            return false;
        return true;
    }
*/
    public void sacrificarMonstruos(Cementerio cementerio, int cantidad) {
        //Juego.getJuego().getJugadorActivo().obtenerCampo().matarMounstro((Monstruo)this.casilleros.get(Casillero.UNO));
        Iterator<Casillero> itr = casilleros.keySet().iterator();
        Casillero key;
        for (int i=0; i<cantidad; i++){
            key = itr.next();
            cementerio.enviarCarta(casilleros.get(key));
            casilleros.remove(key);
        }
    }

    public void destruirZona(Cementerio cementerio){
        for (Casillero key :casilleros.keySet()){
            cementerio.enviarCarta(casilleros.get(key));
            casilleros.remove(key);
        }
    }

}
