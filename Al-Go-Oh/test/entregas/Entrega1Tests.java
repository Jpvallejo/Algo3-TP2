package entregas;

import modelo.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import modelo.cartasMagicas.AgujeroNegroTest;
import modelo.cartasMagicas.CartaMagicaTest;
import modelo.cartasTrampa.CartaTrampaTest;
import modelo.monstruos.MonstruoTest;
import org.junit.Test;

public class Entrega1Tests {



    @Test
    public void test01PrimerEntrega(){
        /*Colocar una carta de monstruo en posición de ataque.*/

        new MonstruoTest().testColocarMonstruoEnPosicionDeAtaqueGeneraMonstruoEnPosicionDeAtaque();

    }

    @Test
    public void test02PrimerEntrega() {
        /*Colocar un monstruo en posición de defensa*/

        new MonstruoTest().testColocarMonstruoEnPosicionDeDefensaGeneraMonstruoEnPosicionDeDefensa();


    }

    @Test
    public void test03PrimerEntrega() {
        /*Colocar una carta mágica en el campo boca abajo (no activa ningún efecto)*/

        new CartaMagicaTest().testColocarCartaMagicaColocaLaCartaBocaAbajo();
    }


    @Test
    public void test04PrimerEntrega() {
        /*Colocar una carta trampa en el campo boca abajo*/

        new CartaTrampaTest().testColocarCartaTrampaColocaLaCartaBocaAbajo();
    }


    @Test
    public void test05PrimerEntrega() {
        /*Mandar una carta al cementerio (sinónimo de destruir) y verificar que estén ahí.*/

        new CementerioTest().testEnviarUnaCartaAlCementerioAumentaCantidadDeCartasDelCementerioEn1();

    }

    @Test
    public void test06PrimerEntrega() {
        /*Colocar una carta de monstruo en posición de ataque, el oponente coloca otra carta de monstruo en posición de ataque (con mayor ataque). Atacar al primer monstruo y verificar que este se destruyó, y sufro daño a los puntos de vida igual a la diferencia de los puntos de ataque de los monstruos*/

        new MonstruoTest().testInvocarYAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMayorDestruyeDefensorYRestaDiferenciaEnPuntosJugadorQueDefiende();
    }

    @Test
    public void test07PrimerEntrega() {
        /*Colocar una carta de monstruo en posición de ataque, el oponente coloca otra carta de monstruo en posición de ataque (con menor ataque), atacar al primer monstruo, verificar que el monstruo atacante es destruido y el atacante recibe daño a los puntos de vida igual a la diferencia de ataques.*/

        new MonstruoTest().testInvocarYAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMenorDestruyeAtacanteYRestaDiferenciaEnPuntosJugadorQueAtaca();
    }

    @Test
    public void test08PrimerEntrega() {
        /*Colocar una carta de monstruo en posición de ataque, el oponente coloca otra carta de monstruo en posición de ataque (con igual ataque), atacar al primer monstruo, verificar que ambos monstruos son destruidos y nadie recibe daño a los puntos de vida.*/

        new MonstruoTest().testInvocarYAtacarMounstroEnPocisionAtaqueConIgualesPuntosDestruyeAmbosMounstros();

    }

    @Test
    public void test09PrimerEntrega() {
        /*Colocar una carta de monstruo en posición de defensa, el oponente coloca otra carta de monstruo en posición de ataque (con mayor ataque que la defensa del primer monstruo), atacar al primer monstruo y verificar que este se destruyó y no sufrió ningún daño vital.*/

        new MonstruoTest().testInvocarYAtacarMounstroEnPocisionDefensaConMenoresPuntosDestruyeMounstroDefensor();
    }

    @Test
    public void test10PrimerEntrega() {
        /*Colocar una carta de monstruo en posición de defensa, el oponente coloca otra carta de monstruo en posición de ataque (con menor ataque que la defensa del primer monstruo), atacar al primer monstruo y verificar que este no se destruyó y no sufrió ningún daño vital.*/

        new MonstruoTest().testInvocarYAtacarMounstroEnPocisionDefensaConMayoresPuntosNoDestruyeMounstroAtacanteYRestaDiferenciaEnPuntosAlJugadorQueAtaca();
    }

    @Test
    public void test11PrimerEntrega() {
        /*Colocar monstruos en ambos lados del campo. Colocar “Agujero negro” boca arriba (es decir, se activa el efecto). Verificar que se destruyeron todos los monstruos de ambos lados del campo, y que nadie recibió daño alguno.*/

        new AgujeroNegroTest().testInvocarAgujeroNegroEnTableroDestruyeTodosLosMonstruosDelTableroDelInvocadorYDelOponente();
    }

    @Test
    public void test12PrimerEntrega() {
        /*Se coloca un monstruo en el campo, se quiere colocar un monstruo de 5 o 6 estrellas que requiere sacrificio. se verifica que se convocó al monstruo y se destruyó el primero.*/

        new MonstruoTest().testColocarMonstruoCon5EstrellasSacrificaUnMonstruo();
    }

    @Test
    public void test13PrimerEntrega() {
        /*Se colocan 2 monstruos en el campo, se quiere colocar un monstruo de 7 o más estrellas que requiere 2 sacrificios. se verifica que se convocó al monstruo y se destruyeron los demás.*/

        new MonstruoTest().testColocarMonstruoCon7EstrellasSacrificaDosMonstruos();
    }


 }
