/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import modelo.Monstruos.MonstruoGenerico;

import java.util.ArrayList;
import java.util.Hashtable;
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
    public void destruirZona(){
        
        if (!this.zonaVacia()){
            for (Carta carta : this.cartas){
                carta.destruir();
            }
        }
        
    }
*/
    public void destruirZona(){
        Iterator<Carta> itr = cartas.iterator();

        while(itr.hasNext()){
            Carta carta = itr.next();
            itr.remove();
            carta.destruir();
        }
    }

    
    public void aplicarCartaCampo(int adicional, boolean ataque){
        for (Carta carta : this.cartas){
            Monstruo monstruo = (Monstruo) carta; //Obtengo la carta monstruo
            if(ataque == true)monstruo.sumarAdicionalAlataque(adicional);       //Le sumo los adicionales que viene de la cartaCampo
            else monstruo.sumarAdicionalAlaDefensa(adicional);
            }
    }

    public void revertirCartaCampo(){
        for (Carta carta : this.cartas){
                Monstruo monstruo = (Monstruo) carta; //Obtengo la carta monstruo
                monstruo.ponerAdicionalesEnCero();
            }
    }

    
    public Monstruo destruirMonstruoConMenorAtaque() {
        Monstruo monstruoConMenorAtaque = new MonstruoGenerico("mayorAtaque",8000,0,0);
         for (Carta carta : this.cartas){
                Monstruo monstruo = (Monstruo) carta; //Obtengo la carta monstruo
                if(monstruoConMenorAtaque.esMenorElAtaque(monstruo)){ //Comparo los ataques de los dos Monstruos
                    monstruoConMenorAtaque = monstruo;
                } 
            }
          
       return monstruoConMenorAtaque;
       
    }
       
   
    
   
    
    
}
