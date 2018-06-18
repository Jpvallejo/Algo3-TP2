package modelo;

import java.util.ArrayList;
import static java.util.Collections.shuffle;

public class Mazo {
    
    private ArrayList<Carta>  cartas;
    
    public Mazo(){
        this.cartas = new ArrayList<Carta>();    
    }
    
    public Carta extaerCarta() {
        return this.cartas.remove(0);
    }
    
    
    public void agregarCarta(Carta carta){
        this.cartas.add(carta);    
    }
    
    public void mezclar (){
        shuffle(this.cartas);       
    } 

}