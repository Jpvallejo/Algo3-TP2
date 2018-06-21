package modelo.creadorDeCartas;


import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class RandomizadorParaCartas {
    private static final int CRITERIODEREPETICION = 10;
    public String randomizar(List<String> cartas, Hashtable<String, Integer> repeticiones) {
        int numeroRandom = new Random().nextInt(cartas.size());
        String carta = cartas.get(numeroRandom);
        Integer repeticion = repeticiones.get(carta);
        if (repeticion == null){
            Integer repeticionCarta = 1;
            repeticiones.put(carta, repeticionCarta);
            return carta;
        }
        while (repeticion > CRITERIODEREPETICION) {
            numeroRandom = new  Random().nextInt(cartas.size());
            carta = cartas.get(numeroRandom);
            repeticion = repeticiones.get(carta);
            if (repeticion < CRITERIODEREPETICION) repeticion++;
        }
        return carta;
    }
}
