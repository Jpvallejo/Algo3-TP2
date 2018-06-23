/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import modelo.*;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

/**
 *
 * @author mramundo
 */
public class TableroTest {

    @Test
    public void testCrearZonaGeneraZonaConCasilleroDisponible(){
          
        ZonaMonstruo zonaMounstruo = new ZonaMonstruo();

        assertTrue(zonaMounstruo.casilleroDisponible());
        
    }
    
    @Test
    public void testCasilleroDisponibleEnZonaMagicaEnTablero(){
        Tablero tablero = new Tablero();
        Monstruo carta = new MonstruoGenerico ("test",500,2000, 4);

        assertTrue(tablero.tirarCarta(carta));
        
        
        Monstruo carta2 = new MonstruoGenerico("test",500,2000, 4);


        assertTrue(tablero.tirarCarta(carta2));
    
    }
    
    @Test
    public void testTirarCartaEnZonaMonstruoYAtacar(){
        
        Tablero tableroAtacante = new Tablero();
        Monstruo cartaAtaque = new MonstruoGenerico("test",500,2000, 4);
        
        tableroAtacante.tirarCarta(cartaAtaque);
        
        
        Tablero tableroDefensor = new Tablero();
        Monstruo cartaDefensor = new MonstruoGenerico("test",1000,100, 4);
        
        tableroDefensor.tirarCarta(cartaDefensor);
        
        //tableroAtacante.atacarPosicion(posicionMia,posicionDelOtro);
        
        
    }
    
    
    

    
}
