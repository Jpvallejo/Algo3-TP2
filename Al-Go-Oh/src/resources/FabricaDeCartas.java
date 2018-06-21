package resources;

import modelo.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FabricaDeCartas {

    public static final String SEPARATOR=";";

    public Carta fabricarMonstruoComun(String carta) {
        String [] lineaSeparado = carta.split(SEPARATOR);
        Constructor<? > monstruoCont = null;
        try {
            monstruoCont = new Monstruo().getClass().forName("modelo.Monstruo").getConstructor(String.class, int.class, int.class, Posicion.class, int.class);
            return  (Monstruo) monstruoCont.newInstance(lineaSeparado[0], Integer.parseInt(lineaSeparado[1]), Integer.parseInt(lineaSeparado[2]), Posicion.DEFENSA,Integer.parseInt(lineaSeparado[3]));
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |InvocationTargetException | NoSuchMethodException e) {
            throw new FabricaDeCartasNoPudoFabricarMonstruoComun();
        }
    }

    public Carta fabricarMonstruoEspecial(String carta) {
        try {
            Class<? extends Monstruo> carta1 = (Class<? extends Monstruo>) Class.forName(carta);
            return carta1.getConstructor(Posicion.class).newInstance(Posicion.DEFENSA);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |InvocationTargetException | NoSuchMethodException e) {
            throw new FabricaDeCartasNoPudoFabricarMonstruoEspecial();
        }
    }

    public Carta fabricarCartaDeHechizo(String carta) {
        try {
            Class<? extends Carta> carta1 = (Class<? extends Carta>) Class.forName(carta);
            return carta1.getConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |InvocationTargetException | NoSuchMethodException e) {
            throw new FabricaDeCartasNoPudoFabricarCartaDeHechizos();
        }
    }
}

