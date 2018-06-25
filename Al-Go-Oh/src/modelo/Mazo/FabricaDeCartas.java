package modelo.Mazo;

import modelo.CartasMagicas.*;
import modelo.Monstruos.*;

import java.util.Stack;
import modelo.Carta;

public class FabricaDeCartas {

    public static Stack fabricarMazo(){
        Stack cartas = new Stack<Carta>();

        /****** COLOCAR 40 CARTAS AQUI *********/

        for ( int i=0 ; i<35; i++){
            cartas.add(new AsechadorDelCraneo());
        }
        cartas.add(new AgresorOscuro());
        cartas.add(new AgresorOscuro());
        cartas.add(new AgresorOscuro());
        cartas.add(new AgresorOscuro());
        cartas.add(new AgresorOscuro());
        //cartas.add(new AsechadorDelCraneo());
        //cartas.add(new AsechadorDelCraneo());
        //cartas.add(new AlasDeLaLlamaPerversa());
        //cartas.add(new AgujaAsesina());

        /**************************************/

        return cartas;
    }

}
