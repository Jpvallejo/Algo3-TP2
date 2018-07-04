package modelo.monstruos;

import modelo.CartasMonstruosEspeciales.DragonBlancoDeOjosAzules;
import modelo.CartasMonstruosEspeciales.DragonDeOjosAzulesDefinitivo;
import modelo.Excepciones.MonstruoDeFusionException;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DragonDeOjosAzulesDefinitivoTest {

    @Test
    public void testInvocarAlDragonDeOjosAzulesDefinitivoDevuleveErrorSiSeInvocaDeFormaNormal(){
        Jugador jugador = new Jugador();
        Monstruo aSacrificar1= new MonstruoGenerico("test1",0,0,3);
        Monstruo aSacrificar2= new MonstruoGenerico("test2",0,0,3);
        Monstruo aSacrificar3= new MonstruoGenerico("test2",0,0,3);
        Monstruo dragonDeOjosAzulesDefinitivo = new DragonDeOjosAzulesDefinitivo();
        jugador.colocar(aSacrificar1);
        jugador.resetearInvocacionesPosibles();
        jugador.colocar(aSacrificar2);
        jugador.resetearInvocacionesPosibles();
        jugador.colocar(aSacrificar3);
        jugador.resetearInvocacionesPosibles();

        assertThrows(MonstruoDeFusionException.class , () -> { jugador.invocar(dragonDeOjosAzulesDefinitivo); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(MonstruoDeFusionException.class , () -> { jugador.invocar(dragonDeOjosAzulesDefinitivo,aSacrificar1); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(MonstruoDeFusionException.class , () -> { jugador.invocar(dragonDeOjosAzulesDefinitivo,aSacrificar1,aSacrificar2); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(MonstruoDeFusionException.class , () -> { jugador.invocar(dragonDeOjosAzulesDefinitivo,aSacrificar1,aSacrificar2,aSacrificar3); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(MonstruoDeFusionException.class , () -> { jugador.colocar(dragonDeOjosAzulesDefinitivo); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(MonstruoDeFusionException.class , () -> { jugador.colocar(dragonDeOjosAzulesDefinitivo,aSacrificar1); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(MonstruoDeFusionException.class , () -> { jugador.colocar(dragonDeOjosAzulesDefinitivo,aSacrificar1,aSacrificar2); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(MonstruoDeFusionException.class , () -> { jugador.colocar(dragonDeOjosAzulesDefinitivo,aSacrificar1,aSacrificar2,aSacrificar3); });
    }

    @Test
    public void testInvocarAlDragonDeOjosAzulesDefinitivoDestruye3DragonesBlancosDeOjosAzules(){
        Jugador jugador = new Jugador();
        Monstruo aSacrificar1= new MonstruoGenerico("test1",0,0,3);
        Monstruo aSacrificar2= new MonstruoGenerico("test2",0,0,3);
        Monstruo dragon1= new DragonBlancoDeOjosAzules();

        Monstruo aSacrificar3= new MonstruoGenerico("test3",0,0,3);
        Monstruo aSacrificar4= new MonstruoGenerico("test4",0,0,3);
        Monstruo dragon2= new DragonBlancoDeOjosAzules();

        Monstruo aSacrificar5= new MonstruoGenerico("test5",0,0,3);
        Monstruo aSacrificar6= new MonstruoGenerico("test6",0,0,3);
        Monstruo dragon3= new DragonBlancoDeOjosAzules();

        Monstruo dragonDeOjosAzulesDefinitivo = new DragonDeOjosAzulesDefinitivo();

        jugador.colocar(aSacrificar1);
        jugador.resetearInvocacionesPosibles();
        jugador.colocar(aSacrificar2);
        jugador.resetearInvocacionesPosibles();
        jugador.colocar(dragon1,aSacrificar1,aSacrificar2);
        jugador.resetearInvocacionesPosibles();

        jugador.colocar(aSacrificar3);
        jugador.resetearInvocacionesPosibles();
        jugador.colocar(aSacrificar4);
        jugador.resetearInvocacionesPosibles();
        jugador.colocar(dragon2,aSacrificar3,aSacrificar4);
        jugador.resetearInvocacionesPosibles();

        jugador.colocar(aSacrificar5);
        jugador.resetearInvocacionesPosibles();
        jugador.colocar(aSacrificar6);
        jugador.resetearInvocacionesPosibles();
        jugador.colocar(dragon3,aSacrificar5,aSacrificar6);
        jugador.resetearInvocacionesPosibles();

        jugador.invocar(dragonDeOjosAzulesDefinitivo, dragon1, dragon2, dragon3);

        assertEquals(9,jugador.cantidadCartasCementerio());
    }

}
