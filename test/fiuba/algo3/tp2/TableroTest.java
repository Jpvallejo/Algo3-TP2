/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fiuba.algo3.tp2;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author mramundo
 */
public class TableroTest {


    @Test
    public void test01CrearTableroVacio(){
        Tablero tablero = new Tablero();
        
        assertEquals(true, tablero.estaVacio());
    
    }
    
    
    @Test
    public void test02CrearCasillero(){
        Casillero casillero = new Casillero();
        
        assertEquals(true, casillero.estaVacio());
        
    }

    @Test
    public void test03CrearZonayAgregarleCasillero(){
    
        Casillero casillero = new Casillero();
        
        ZonaMounstruo zonaMounstruo = new ZonaMounstruo();
        
        zonaMounstruo.agregarCasillero(casillero);
 
        assertEquals(true, zonaMounstruo.casilleroDisponible());
        
    }
    
    @Test
    public void test04CasilleroDisponibleEnZonaMagicaEnTablero(){
        Tablero tablero = new Tablero();
        
        assertEquals(true, tablero.tirarCartaEnZonaMagica());
        
    }

    
}
