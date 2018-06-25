package modelo.Mazo;

import modelo.CartasMagicas.*;

import java.util.Stack;
import modelo.Carta;

public class FabricaDeCartas {

    public static Stack fabricarMazo(){
        Stack cartas = new Stack<Carta>();

        /****** COLOCAR 40 CARTAS AQUI *********/

        for ( int i=0 ; i<40; i++){
            cartas.add(new AgujeroNegro());
        }

        /**************************************/

        return cartas;
    }

}
