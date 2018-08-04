package modelo.monstruos;

import modelo.CartasMonstruosEspeciales.DragonBlancoDeOjosAzules;
import modelo.CartasMonstruosEspeciales.DragonDeOjosAzulesDefinitivo;
import modelo.Excepciones.RequiereSacrificioEspecialException;
import modelo.Excepciones.RequiereSacrificioException;
import modelo.Juego;
import modelo.Jugador;
import modelo.Monstruo;
import modelo.Monstruos.MonstruoGenerico;
import modelo.Sacrificios;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DragonDeOjosAzulesDefinitivoTest {

    @Test
    public void testInvocarAlDragonDeOjosAzulesDefinitivoDevuleveErrorSiSeInvocaDeFormaNormal(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
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

        Sacrificios unSacrificio = new Sacrificios();
        Sacrificios dosSacrificios = new Sacrificios();
        Sacrificios tresSacrificios = new Sacrificios();

        unSacrificio.agregar(aSacrificar1);

        dosSacrificios.agregar(aSacrificar1);
        dosSacrificios.agregar(aSacrificar2);

        tresSacrificios.agregar(aSacrificar1);
        tresSacrificios.agregar(aSacrificar2);
        tresSacrificios.agregar(aSacrificar3);

        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(dragonDeOjosAzulesDefinitivo); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(RequiereSacrificioEspecialException.class , () -> { jugador.invocar(dragonDeOjosAzulesDefinitivo,unSacrificio); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(RequiereSacrificioEspecialException.class , () -> { jugador.invocar(dragonDeOjosAzulesDefinitivo,dosSacrificios); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(RequiereSacrificioEspecialException.class , () -> { jugador.invocar(dragonDeOjosAzulesDefinitivo,tresSacrificios); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(RequiereSacrificioException.class , () -> { jugador.colocar(dragonDeOjosAzulesDefinitivo); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(RequiereSacrificioEspecialException.class , () -> { jugador.colocar(dragonDeOjosAzulesDefinitivo,unSacrificio); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(RequiereSacrificioEspecialException.class , () -> { jugador.colocar(dragonDeOjosAzulesDefinitivo,dosSacrificios); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(RequiereSacrificioEspecialException.class , () -> { jugador.colocar(dragonDeOjosAzulesDefinitivo,tresSacrificios); });
    }

    @Test
    public void testInvocarAlDragonDeOjosAzulesDefinitivoDestruye3DragonesBlancosDeOjosAzules(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
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

        DragonDeOjosAzulesDefinitivo dragonDeOjosAzulesDefinitivo = new DragonDeOjosAzulesDefinitivo();

        jugador.colocar(aSacrificar1);
        jugador.resetearInvocacionesPosibles();
        jugador.colocar(aSacrificar2);
        jugador.resetearInvocacionesPosibles();
        Sacrificios sacrificiosDragon1 = new Sacrificios();
        sacrificiosDragon1.agregar(aSacrificar1);
        sacrificiosDragon1.agregar(aSacrificar2);
        jugador.colocar(dragon1,sacrificiosDragon1);
        jugador.resetearInvocacionesPosibles();

        jugador.colocar(aSacrificar3);
        jugador.resetearInvocacionesPosibles();
        jugador.colocar(aSacrificar4);
        jugador.resetearInvocacionesPosibles();
        Sacrificios sacrificiosDragon2 = new Sacrificios();
        sacrificiosDragon2.agregar(aSacrificar3);
        sacrificiosDragon2.agregar(aSacrificar4);
        jugador.colocar(dragon2,sacrificiosDragon2);
        jugador.resetearInvocacionesPosibles();

        jugador.colocar(aSacrificar5);
        jugador.resetearInvocacionesPosibles();
        jugador.colocar(aSacrificar6);
        jugador.resetearInvocacionesPosibles();
        Sacrificios sacrificiosDragon3 = new Sacrificios();
        sacrificiosDragon3.agregar(aSacrificar5);
        sacrificiosDragon3.agregar(aSacrificar6);
        jugador.colocar(dragon3,sacrificiosDragon3);
        jugador.resetearInvocacionesPosibles();

        Sacrificios dragonesASacrificar = new Sacrificios();
        dragonesASacrificar.agregar(dragon1);
        dragonesASacrificar.agregar(dragon2);
        dragonesASacrificar.agregar(dragon3);

        jugador.invocar(dragonDeOjosAzulesDefinitivo, dragonesASacrificar);

        assertEquals(9,jugador.cantidadCartasCementerio());
    }

}
