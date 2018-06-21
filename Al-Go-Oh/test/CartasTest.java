
import modelo.*;
import org.junit.Assert;
import org.junit.Test;


public class CartasTest {

    @Test
    public void testCrearCartas() {
        Assert.assertNotNull(new Cartas());
    }
    @Test
    public void testCartasObtenerUnaCatraRetornaUnaCarta() {
        Cartas cartas = new Cartas();
        Assert.assertNotNull(cartas.obtenerUnaCartaAleatoria());
    }

    @Test
    public void testCartasObtenerUnaCatraObtengoMuchasCartas() throws ClassNotFoundException {
        Cartas cartas = new Cartas();
        boolean todoTrue = true;
        for (int i = 0; i < 200; i++){
            if (cartas.obtenerUnaCartaAleatoria() == null) todoTrue = false;
        }
        Assert.assertTrue(todoTrue);
    }
}
