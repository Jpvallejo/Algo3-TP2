/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.util.Iterator;
import java.util.Set;

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

        int i = 0;
        // Esto se debe mejorar para permitir la seleccion de monstruos para sacrificar
        // Ademas, en este caso. Si no se cumple el sacrificio, el monstruo se invoca igual.
        for (Casillero key : Casillero.values()) {
            if (i < cantidad && casilleros.containsKey(key)){
                cementerio.enviarCarta(casilleros.get(key));
                casilleros.remove(key);
                i++;
            }
        }
    }

    public void destruirZona(Cementerio cementerio){
        for (Casillero key :casilleros.keySet()){
            cementerio.enviarCarta(casilleros.get(key));
            casilleros.remove(key);
        }
    }
 
    
    public void aplicarCartaCampo(int adicional, boolean ataque){
        for (Casillero casillero: Casillero.values()) {
            if (casilleros.containsKey(casillero)) {
                Monstruo monstruo = (Monstruo) casilleros.get(casillero); //Obtengo la carta monstruo
                if(ataque == true)monstruo.sumarAdicionalAlataque(adicional);       //Le sumo los adicionales que viene de la cartaCampo
                else monstruo.sumarAdicionalAlaDefensa(adicional);
            }
        }
    }

    
    
}
