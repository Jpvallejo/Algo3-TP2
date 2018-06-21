package modelo;

import modelo.creadorDeCartas.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

public class Cartas {
    private static final int AZAR = 5;
    private int MAXCARTASHECHIZO = 7;
    private static Hashtable <String, Integer> repeticiones = new Hashtable <String, Integer>();
    private final List <String> cartasMonstruosEspeciales = new ArrayList<String>();
    private final List <String> cartasHechizos = new ArrayList<String>();
    private final List <String> cartasMonstruosComunes = new ArrayList<String>();

    public Cartas() {
        LeerArchivo leer = new LeerArchivo();
        leer.unArchivoDesdeAYLanzarException("Hechizos.csv", cartasHechizos, new CartasMagicasAchivoNoSePudoAbrirException());
        leer.unArchivoDesdeAYLanzarException("MonstruosEspeciales.csv", cartasMonstruosEspeciales, new CartasMonstruosEspecialesAchivoNoSePudoAbrirException());
        leer.unArchivoDesdeAYLanzarException("Monstruos.csv", cartasMonstruosComunes, new CartasMonstruosComunesAchivoNoSePudoAbrirException());
    }

    public Carta obtenerUnaCartaAleatoria() {
        int azar = new  Random().nextInt(AZAR);
        String carta = null;
        RandomizadorParaCartas randomizador = new RandomizadorParaCartas();
        FabricaDeCartas fabrica = new FabricaDeCartas();
        if ((azar == 1) && (MAXCARTASHECHIZO > 0)){
            carta = randomizador.randomizar(cartasMonstruosEspeciales, repeticiones);
            MAXCARTASHECHIZO--;
            return fabrica.fabricarMonstruoEspecial(carta);
        } else if (azar == 3){
            carta = randomizador.randomizar(cartasHechizos, repeticiones);
            return fabrica.fabricarCartaDeHechizo(carta);
        }
        carta = randomizador.randomizar(cartasMonstruosComunes, repeticiones);
        return fabrica.fabricarMonstruoComun(carta);
    }
}
