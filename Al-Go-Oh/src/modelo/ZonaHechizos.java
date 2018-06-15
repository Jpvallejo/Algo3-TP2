/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author mramundo
 */
public class ZonaHechizos extends Zona {
    
     public ZonaHechizos(){
    
       this.casilleros = new ArrayList<Casillero>(); 
       this.crearCasilleros();
    }

}
