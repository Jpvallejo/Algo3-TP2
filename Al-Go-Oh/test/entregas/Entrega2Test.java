package entregas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import modelo.cartasMagicas.*;
import modelo.cartasTrampa.CartaTrampaTest;
import modelo.ManoTest;
import modelo.MazoTest;
import modelo.cartasTrampa.CilindroMagicoTest;
import modelo.cartasTrampa.ReinforcementTest;
import modelo.monstruos.DragonDeOjosAzulesDefinitivoTest;
import modelo.monstruos.InsectoComeHombresTest;
import modelo.monstruos.JinzoTest;
import org.junit.Test;

public class Entrega2Test {

    @Test
    public void test01SegundaEntrega(){
        /*Colocar un monstruo de cada lado del campo. Activo la carta mágica Wasteland y verificar que de un lado del campo, el ataque del monstruo aumenta en 200 puntos y del otro lado del campo, se aumenta la defensa del monstruo en 300 puntos.*/


        new WastelandTest().testColocarWastelandEnElCampoAumentaElAtaqueDelJugadorActivosEn200YLaDefensaDelJugadorOponenteEn300();
    }
    
    @Test
    public void test02SegundaEntrega(){
        /*Activar la carta mágica Olla de la codicia, y verificar que tomo 2 cartas del mazo.*/

        new OllaDeLaCodiciaTest().testInvocarOllaDeLaCodiciaPermiteTomarDosCartasDelMazo();
    }
    
    @Test
    public void test03SegundaEntrega(){
        /*Colocar un monstruo de cada lado del campo. activo la carta mágica Sogen y verificar que de un lado del campo, la defensa del monstruo aumenta en 500 puntos y del otro lado del campo, se aumenta el ataque del monstruo en 200 puntos.*/

        new SogenTest().testAplicarCartaSogenEnMonstruosYAtacar();

    }
    
    @Test
    public void test04SegundaEntrega(){
        /*Colocar 2 monstruos en el campo enemigo, con diferente ataque. Activo la carta mágica Fisura, y verificar que el de menor ataque es destruido.*/

        new FisuraTest().testInvocar2MonstruosYActivarLaCartaMagicaFisuraDestruyeElMonstruoDeMenorAtaque();
    }
    
    @Test
    public void test05SegundaEntrega(){
        /*Colocar un monstruo en el campo enemigo. invoco a Jinzo #7 en mi lado del campo. Verificar que puedo atacar a los puntos de vida directamente.*/

        new JinzoTest().testColocarJinzoEnPosicionDeAtaqueAtacaALosPuntosDeVidaDelOponenteDirectamenteSinImportarElMonstruoDelLadoOponente();
    }
    
    @Test
    public void test06SegundaEntrega(){
        /*Invocar 3 dragones blancos de ojos azules, al Dragón definitivo de ojos azules sacrificando los 3 dragones el lado del campo del jugador que los invocó.*/

        new DragonDeOjosAzulesDefinitivoTest().testInvocarAlDragonDeOjosAzulesDefinitivoDestruye3DragonesBlancosDeOjosAzules();
    }
    
    @Test
    public void test07SegundaEntrega(){
        /*Colocar al Insecto come-hombres, en posición de defensa boca abajo. Invocar un monstruo enemigo y atacar al insecto. activo el efecto de volteo, señalando al atacante como objetivo, verificar que este se destruye, y que mi monstruo sigue en el campo. Verificar que nadie sufre daño a los puntos de vida.*/

        new InsectoComeHombresTest().testAlAtacarAlInsectoComeHombresBocaAbajoEnPosicionDeDefensaSeDestruyeElMonstruoAtacante();
    }
    
    @Test
    public void test08SegundaEntrega(){
        /*Colocar un monstruo del lado enemigo, luego coloco la carta trampa Cilindro mágico de mi lado del campo. Atacar con el monstruo y verificar que se activa la carta trampa, se niega el ataque y el oponente recibe el daño directamente en sus puntos de vida.*/

        new CilindroMagicoTest().testCilindroMagicoNiegaElAtaqueDeUnMonstruoALosPuntosDeVidaYRestaLosPuntosDeAtaqueDelMonstruoAtacanteALosPuntosDeVidaDelJugadorAtacante();
    }
    
    @Test
    public void test09SegundaEntrega(){
        /*Coloco un monstruo en posición de ataque y la carta trampa Reinforcements de mi lado del campo, coloco un monstruo en el campo enemigo (con 400 puntos mas de ataque que el primero) y atacar al primer monstruo. Verificar que se activa la carta trampa, y el monstruo enemigo es destruido y se infligió 100 puntos de daño a la vida del otro jugador.*/

        new ReinforcementTest().testActivarReinforcementAumentaElAtaqueDelMonstruoDefensorEn500SoloDuranteElAtaque();


    }
    
    @Test
    public void test10SegundaEntrega(){
        /*Extraer todas las cartas del mazo, y verificar que la partida terminó y el jugador perdió.*/

        new MazoTest().testAlExtraerTodasLasCartasDelMazoGeneraUnGanadorEnElJuegoYElGanadorEsElOponente();
    }
    
    @Test
    public void test11SegundaEntrega(){
        /*Colocar las 5 partes de exodia en la mano de un jugador, verificar que la partida termina y que ese jugador resultó ganador.*/

        new ManoTest().testManoContener5PartesExodiaEnLaManoGanaLaPartida();

    }

}
