package modelo.Mazo;

import modelo.CartasMagicas.*;
import modelo.CartasMonstruosEspeciales.*;
import modelo.Estados.EstadoSinEstado;
import modelo.Monstruos.*;

import java.util.Stack;
import modelo.Carta;

public class FabricaDeCartas {

    public static Stack fabricarMazo(){
        Stack cartas = new Stack<Carta>();

        /****** COLOCAR 40 CARTAS AQUI *********/

        cartas.add(new AgujeroNegro());
        cartas.add(new CilindroMagico());
        cartas.add(new Fisura());
        cartas.add(new OllaDeLaCodicia());
        cartas.add(new Reinforcement());
        cartas.add(new Sogen());
        cartas.add(new Wasteland());
        cartas.add(new BrazoDerechoExodia());
        cartas.add(new BrazoIzquierdoExodia());
        cartas.add(new CabezaExodia());
        cartas.add(new DragonBlancoDeOjosAzules());
        cartas.add(new DragonDeOjosAzulesDefinitivo());
        cartas.add(new InsectoComeHombres());
        cartas.add(new JinzoNro7(new EstadoSinEstado()));
        cartas.add(new PiernaDerechaExodia());
        cartas.add(new PiernaIzquierdaExodia());
        cartas.add(new AgresorOscuro());
        cartas.add(new Aitsu());
        cartas.add(new AlcanzadorDeGarra());
        cartas.add(new AlasDeLaLlamaPerversa());
        cartas.add(new AgujaAsesina());
        cartas.add(new AbismoReluciente());
        cartas.add(new AlfaElGuerreroMagnetico());
        cartas.add(new AligatorDeLaEspada());
        cartas.add(new AligatorCibertech());
        cartas.add(new AlmaDeHimotama());
        cartas.add(new AmateFeliz());
        cartas.add(new AmazonaDeLosMares());
        cartas.add(new AmistadBrillante());
        cartas.add(new AmoDeLosSellosMeisei());
        cartas.add(new AngelTrompetista());
        cartas.add(new Ansatsu());
        cartas.add(new Anthrosaurio());
        cartas.add(new AntiguoDeLasProfundidades());
        cartas.add(new AraniaLanzadora());
        cartas.add(new AraniaCazadora());
        cartas.add(new AsechadorDelCraneo());
        cartas.add(new AvaDeFe());
        cartas.add(new BaronDeLaEspadaDemoniaca());
        cartas.add(new BebeDragon());
        cartas.add(new BetaElGuerreroMagnetico());
        cartas.add(new OllaDeLaCodicia());
        cartas.add(new Wasteland());
        cartas.add(new CilindroMagico());
        //cartas.add(new AgujaAsesina());

        /**************************************/

        return cartas;
    }

}
