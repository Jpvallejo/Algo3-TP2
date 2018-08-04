/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import vista.Botones.BotonCarta;
import vista.Botones.BotonCartaCampo;

/**
 *
 * @author mramundo
 */
public abstract class CartaCampo extends Carta{
    
    public CartaCampo(){
        super();
    }

    public BotonCarta crearBoton(){
        return new BotonCartaCampo(this);
    }
 
}
