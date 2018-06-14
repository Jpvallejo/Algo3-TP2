/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.assertEquals;

import modelo.Casillero;
import modelo.Tablero;
import modelo.ZonaMonstruo;
import org.junit.Test;

/**
 *
 * @author mramundo
 */
public class TableroTest {

    
    @Test
    public void test01CrearCasillero(){
        Casillero casillero = new Casillero();
        
        assertEquals(true, casillero.estaVacio());
        
    }

    @Test
    public void test02CrearZona(){
          
        ZonaMonstruo zonaMounstruo = new ZonaMonstruo();
        
        assertEquals(true, zonaMounstruo.casilleroDisponible());
        
    }
    
    @Test
    public void test03CasilleroDisponibleEnZonaMagicaEnTablero(){
        Tablero tablero = new Tablero();
        Monstruo carta = new Monstruo(500,2000, Posicion.ATAQUE);
        
        assertEquals(true, tablero.tirarCarta(carta));
        
        
        Monstruo carta2 = new Monstruo(500,2000, Posicion.ATAQUE);
        
        
         assertEquals(true, tablero.tirarCarta(carta));
    
    }
    
       @Test
    public void test04TirarCartaEnZonaMonstruoYAtacar(){
        
        Tablero tableroAtacante = new Tablero();
        Monstruo cartaAtaque = new Monstruo(500,2000, Posicion.ATAQUE);
        
        tableroAtacante.tirarCarta(cartaAtaque);
        
        
        Tablero tableroDefensor = new Tablero();
        Monstruo cartaDefensor = new Monstruo(1000,100, Posicion.ATAQUE);
        
        tableroDefensor.tirarCarta(cartaDefensor);
        
        //tableroAtacante.atacarPosicion(posicionMia,posicionDelOtro);
        
        
    }
    
    
    

    
}
