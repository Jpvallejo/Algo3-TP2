/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.CartasMagicas;

import modelo.CartaCampo;

/**
 *
 * @author mramundo
 */
public class CartaCampoSinEfecto extends CartaCampo {

    public CartaCampoSinEfecto(){
        super();
        UrlImagen = "/vista/imagenes/NoImage.png";
    }
    
    @Override
    public void activarEfecto() {        
    }
    
}
