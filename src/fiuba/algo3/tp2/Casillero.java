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
public class Casillero {

    boolean disponible;
    //Carta carta;

    public Casillero (){
        disponible = true;
    }
    
    public boolean estaVacio() {
       return this.disponible;
    }

    boolean agregarCarta() { 
        //tiene que recibir una carta y colocarse en el atributo carta
        //poner disponible en false
        return this.disponible;
    }
}
