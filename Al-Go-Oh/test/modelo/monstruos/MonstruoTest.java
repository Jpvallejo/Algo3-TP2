package modelo.monstruos;

import modelo.Estados.EstadoDefensaBocaAbajo;
import modelo.Estados.EstadoAtaque;
import modelo.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import modelo.Excepciones.NoDisponibleParaAtacarException;
import modelo.Excepciones.RequiereSacrificioException;
import modelo.Monstruos.AgresorOscuro;
import modelo.Monstruos.AgujaAsesina;
import modelo.Monstruos.AsechadorDelCraneo;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;


public class MonstruoTest {

    @Test
    public void testColocarMonstruoEnPosicionDeAtaqueGeneraMonstruoEnPosicionDeAtaque(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion


        Monstruo monstruo = new MonstruoGenerico("test",100,100,4);
        Jugador jugador = new Jugador();

        jugador.invocar(monstruo);

        assertTrue(monstruo.getEstado() instanceof EstadoAtaque);
    }

    @Test
    public void testColocarMonstruoEnPosicionDeDefensaGeneraMonstruoEnPosicionDeDefensa(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Monstruo monstruo = new MonstruoGenerico("test",100,100,4);
        Jugador jugador = new Jugador();

        jugador.colocar(monstruo);

        assertTrue(monstruo.getEstado() instanceof EstadoDefensaBocaAbajo);
    }


    // Ataques entre Monstruos sin invocar
    @Test
    public void testAtacarMounstroEnPocisionAtaqueConIgualesPuntosDestruyeAmbosMounstros() {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AgujaAsesina monstruoAtacante = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        AgujaAsesina monstruoDefensor = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        monstruoAtacante.setEstado(new EstadoAtaque());
        monstruoDefensor.setEstado(new EstadoAtaque());

        monstruoAtacante.asociarJugador(atacante);
        monstruoDefensor.asociarJugador(defensor);

        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(1, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
    }

    @Test
    public void testAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMayorDestruyeDefensorYRestaDiferenciaEnPuntosJugadorQueDefiende() {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AgujaAsesina monstruoAtacante = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        AsechadorDelCraneo monstruoDefensor = new AsechadorDelCraneo(); //ATK = 900 DEF = 800
        monstruoAtacante.setEstado(new EstadoAtaque());
        monstruoDefensor.setEstado(new EstadoAtaque());
        monstruoAtacante.asociarJugador(atacante);
        monstruoDefensor.asociarJugador(defensor);

        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 8000);
        assertEquals(defensor.getPuntosDeVida(), 7700);
    }

    @Test
    public void testAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMenorDestruyeAtacanteYRestaDiferenciaEnPuntosJugadorQueAtaca()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AsechadorDelCraneo monstruoAtacante = new AsechadorDelCraneo(); //ATK = 900 DEF = 800
        AgujaAsesina monstruoDefensor = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        monstruoAtacante.setEstado(new EstadoAtaque());
        monstruoDefensor.setEstado(new EstadoAtaque());
        monstruoAtacante.asociarJugador(atacante);
        monstruoDefensor.asociarJugador(defensor);

        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(1, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 7700);
        assertEquals(defensor.getPuntosDeVida(), 8000);
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConMenoresPuntosDestruyeMounstroDefensor()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AgujaAsesina monstruoAtacante = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        AsechadorDelCraneo monstruoDefensor = new AsechadorDelCraneo(); //ATK = 900 DEF = 800
        monstruoAtacante.setEstado(new EstadoAtaque());
        monstruoDefensor.setEstado(new EstadoDefensaBocaAbajo());
        monstruoAtacante.asociarJugador(atacante);
        monstruoDefensor.asociarJugador(defensor);

        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 8000);
        assertEquals(defensor.getPuntosDeVida(), 8000);
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConIgualesPuntosNoProduceCambios()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AgresorOscuro monstruoAtacante = new AgresorOscuro(); //ATK = 1200 DEF = 1200
        AgresorOscuro monstruoDefensor = new AgresorOscuro(); //ATK = 1200 DEF = 1200
        monstruoAtacante.setEstado(new EstadoAtaque());
        monstruoDefensor.setEstado(new EstadoDefensaBocaAbajo());
        monstruoAtacante.asociarJugador(atacante);
        monstruoDefensor.asociarJugador(defensor);

        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 8000);
        assertEquals(defensor.getPuntosDeVida(), 8000);
    }

    @Test
    public void testAtacarMounstroEnPocisionDefensaConMayoresPuntosNoDestruyeMounstroAtacanteYRestaDiferenciaEnPuntosAlJugadorQueAtaca()
    {
        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        AsechadorDelCraneo monstruoAtacante = new AsechadorDelCraneo(); //ATK = 900 DEF = 800
        AgujaAsesina monstruoDefensor = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        monstruoAtacante.setEstado(new EstadoAtaque());
        monstruoDefensor.setEstado(new EstadoDefensaBocaAbajo());
        monstruoAtacante.asociarJugador(atacante);
        monstruoDefensor.asociarJugador(defensor);

        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 7900);
        assertEquals(defensor.getPuntosDeVida(), 8000);

    }


    // Ataques entre Monstruos invocados
    @Test
    public void testInvocarYAtacarMounstroEnPocisionAtaqueConIgualesPuntosDestruyeAmbosMounstros() {
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AgujaAsesina monstruoAtacante = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        AgujaAsesina monstruoDefensor = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        atacante.invocar(monstruoAtacante);
        defensor.invocar(monstruoDefensor);
        Juego.getJuego().avanzarFase(); //avanza a fase de Ataque
        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(1, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
    }

    @Test
    public void testInvocarYAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMayorDestruyeDefensorYRestaDiferenciaEnPuntosJugadorQueDefiende() {
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AgujaAsesina monstruoAtacante = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        AsechadorDelCraneo monstruoDefensor = new AsechadorDelCraneo(); //ATK = 900 DEF = 800
        atacante.invocar(monstruoAtacante);
        defensor.invocar(monstruoDefensor);
        Juego.getJuego().avanzarFase(); //avanza a fase de Ataque
        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 8000);
        assertEquals(defensor.getPuntosDeVida(), 7700);
    }

    @Test
    public void testInvocarYAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMenorDestruyeAtacanteYRestaDiferenciaEnPuntosJugadorQueAtaca()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AsechadorDelCraneo monstruoAtacante = new AsechadorDelCraneo(); //ATK = 900 DEF = 800
        AgujaAsesina monstruoDefensor = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        atacante.invocar(monstruoAtacante);
        defensor.invocar(monstruoDefensor);

        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(1, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 7700);
        assertEquals(defensor.getPuntosDeVida(), 8000);
    }

    @Test
    public void testInvocarYAtacarMounstroEnPocisionDefensaConMenoresPuntosDestruyeMounstroDefensor()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AgujaAsesina monstruoAtacante = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        AsechadorDelCraneo monstruoDefensor = new AsechadorDelCraneo(); //ATK = 900 DEF = 800
        atacante.invocar(monstruoAtacante);
        defensor.colocar(monstruoDefensor);

        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 8000);
        assertEquals(defensor.getPuntosDeVida(), 8000);
    }

    @Test
    public void testInvocarYAtacarMounstroEnPocisionDefensaConIgualesPuntosNoProduceCambios()
    {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AgresorOscuro monstruoAtacante = new AgresorOscuro(); //ATK = 1200 DEF = 1200
        AgresorOscuro monstruoDefensor = new AgresorOscuro(); //ATK = 1200 DEF = 1200
        atacante.invocar(monstruoAtacante);
        defensor.colocar(monstruoDefensor);

        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 8000);
        assertEquals(defensor.getPuntosDeVida(), 8000);
    }

    @Test
    public void testInvocarYAtacarMounstroEnPocisionDefensaConMayoresPuntosNoDestruyeMounstroAtacanteYRestaDiferenciaEnPuntosAlJugadorQueAtaca()
    {
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        AsechadorDelCraneo monstruoAtacante = new AsechadorDelCraneo(); //ATK = 900 DEF = 800
        AgujaAsesina monstruoDefensor = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        atacante.invocar(monstruoAtacante);
        defensor.colocar(monstruoDefensor);

        Juego.getJuego().avanzarFase(); //avanza a fase de Ataque
        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 7900);
        assertEquals(defensor.getPuntosDeVida(), 8000);

    }



    @Test
    public void testMonstruoConMenosDeCuatroEstrellasNoRequiereSacrificio(){
        Monstruo monstruo = new MonstruoGenerico("test",0,0,3);
        assertEquals(0,monstruo.cantidadASacrificar());
    }

    @Test
    public void testMonstruoConMasDeCuatroEstrellasRequiereSacrificio(){
        Monstruo monstruo = new MonstruoGenerico("test2",0,0,6);
        assertNotEquals(0,monstruo.cantidadASacrificar());
    }

    @Test
    public void testMonstruoConMasDeCuatroEstrellasRequiereSacrificarUnMonstruo(){
        Monstruo monstruo = new MonstruoGenerico("test",0,0,5);
        assertEquals(monstruo.cantidadASacrificar(),1);
    }

    @Test
    public void testMonstruoConMasDeSeisEstrellasRequiereSacrificarDosMonstruos(){
        Monstruo monstruo = new MonstruoGenerico("test",0,0,7);
        assertEquals(monstruo.cantidadASacrificar(),2);
    }


    @Test
    public void testInvocarMonstruoCon5EstrellasSacrificaUnMonstruo(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Monstruo aSacrificar= new MonstruoGenerico("test1",0,0,3);
        Monstruo sacrificador = new MonstruoGenerico("test2",0,0,5);
        Jugador jugador = new Jugador();

        jugador.invocar(aSacrificar);
        jugador.resetearInvocacionesPosibles();
        Sacrificios sacrificios = new Sacrificios();
        sacrificios.agregar(aSacrificar);

        jugador.invocar(sacrificador, sacrificios);
        assertEquals(1,jugador.cantidadCartasCementerio());
    }


    @Test
    public void testInvocarMonstruoCon7EstrellasSacrificaDosMonstruos(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador jugador = new Jugador();
        Monstruo aSacrificar1= new MonstruoGenerico("test1",0,0,3);
        Monstruo aSacrificar2= new MonstruoGenerico("test2",0,0,3);
        Monstruo sacrificador = new MonstruoGenerico("test3",0,0,7);
        jugador.invocar(aSacrificar1);
        jugador.resetearInvocacionesPosibles();
        jugador.invocar(aSacrificar2);
        jugador.resetearInvocacionesPosibles();
        Sacrificios sacrificios = new Sacrificios();
        sacrificios.agregar(aSacrificar1);
        sacrificios.agregar(aSacrificar2);

        jugador.invocar(sacrificador,sacrificios);
        assertEquals(2,jugador.cantidadCartasCementerio());
    }

    @Test
    public void testColocarMonstruoCon5EstrellasSacrificaUnMonstruo(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Monstruo aSacrificar= new MonstruoGenerico("test1",0,0,3);
        Monstruo sacrificador = new MonstruoGenerico("test2",0,0,5);
        Jugador jugador = new Jugador();

        jugador.colocar(aSacrificar);
        jugador.resetearInvocacionesPosibles();
        Sacrificios sacrificios = new Sacrificios();
        sacrificios.agregar(aSacrificar);

        jugador.colocar(sacrificador, sacrificios);
        assertEquals(1,jugador.cantidadCartasCementerio());
    }


    @Test
    public void testColocarMonstruoCon7EstrellasSacrificaDosMonstruos(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador jugador = new Jugador();
        Monstruo aSacrificar1= new MonstruoGenerico("test1",0,0,3);
        Monstruo aSacrificar2= new MonstruoGenerico("test2",0,0,3);
        Monstruo sacrificador = new MonstruoGenerico("test3",0,0,7);
        jugador.colocar(aSacrificar1);
        jugador.resetearInvocacionesPosibles();
        jugador.colocar(aSacrificar2);
        jugador.resetearInvocacionesPosibles();

        Sacrificios sacrificios = new Sacrificios();
        sacrificios.agregar(aSacrificar1);
        sacrificios.agregar(aSacrificar2);

        jugador.colocar(sacrificador,sacrificios);
        assertEquals(2,jugador.cantidadCartasCementerio());
    }


    @Test
    public void testColocarMonstruoCon5o6EstrellasRetornaErrorSiNoSePasa1Sacrificio(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador jugador = new Jugador();
        Monstruo sacrificador1 = new MonstruoGenerico("test1",0,0,5);
        Monstruo sacrificador2 = new MonstruoGenerico("test2",0,0,6);

        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(sacrificador1); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(sacrificador2); });
    }


    @Test
    public void testColocarMonstruoCon7u8EstrellasRetornaErrorSiNoSePasan2Sacrificios(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador jugador = new Jugador();
        Monstruo aSacrificar1= new MonstruoGenerico("test1",0,0,3);
        Monstruo sacrificador1 = new MonstruoGenerico("test1",0,0,7);
        Monstruo sacrificador2 = new MonstruoGenerico("test2",0,0,8);
        jugador.invocar(aSacrificar1);
        jugador.resetearInvocacionesPosibles();
        Sacrificios unSacrificio = new Sacrificios();

        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(sacrificador1); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(sacrificador2); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(sacrificador1,unSacrificio); });
        jugador.resetearInvocacionesPosibles();
        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(sacrificador2,unSacrificio); });
    }


    @Test
    public void testInvocarMonstruoEnPosicionDeAtaqueYAtacaAlOponenteSinMonstruosRestaLosPuntosDeAtaqueALosPuntosDeVidaDelJugadorQueDefiende() {
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AgujaAsesina monstruoAtacante = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        atacante.invocar(monstruoAtacante);
        monstruoAtacante.atacar(defensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(6800, defensor.getPuntosDeVida());
        assertEquals(8000, atacante.getPuntosDeVida());

    }


    @Test
    public void testAlInvocarUnMonstruoYDestruirloElMonstruoDesapareceDelCampo(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador jugador = new Jugador();
        Monstruo monstruo = new MonstruoGenerico("test1",0,0,3);

        jugador.invocar(monstruo);

        monstruo.destruir();

        assertFalse(jugador.getZonaMonstruo().contains(monstruo));
    }

    @Test
    public void testAlInvocarUnMonstruoYDestruirloNoSeEncuentraEnElCampoAunqueHayaMonstruosDelMismoTipo(){
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador jugador = new Jugador();
        Monstruo agresor1 = new AgresorOscuro();
        Monstruo agresor2 = new AgresorOscuro();
        Monstruo agresor3 = new AgresorOscuro();

        jugador.invocar(agresor1);
        jugador.resetearInvocacionesPosibles();
        jugador.invocar(agresor2);
        jugador.resetearInvocacionesPosibles();
        jugador.invocar(agresor3);

        agresor3.destruir();

        assertFalse(jugador.getZonaMonstruo().contains(agresor3));
    }

    @Test
    public void testMonstruoNoPuedeAtacarMasDeDosVeces() {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new MonstruoGenerico("test1",1000,0,3);
        Monstruo monstruoDefensor1 = new MonstruoGenerico("test1",0,0,3);
        Monstruo monstruoDefensor2 = new MonstruoGenerico("test1",0,0,3);
        atacante.invocar(monstruoAtacante);
        defensor.colocar(monstruoDefensor1);
        defensor.resetearInvocacionesPosibles();
        defensor.colocar(monstruoDefensor2);

        monstruoAtacante.atacarMonstruo(monstruoDefensor1);

        assertThrows(NoDisponibleParaAtacarException.class , () -> { monstruoAtacante.atacarMonstruo(monstruoDefensor2); });
    }

    @Test
    public void testMonstruoColocadoNoPuedeAtacar() {
        Juego.reiniciarJuego();
        Juego.getJuego().avanzarFase(); //avanza a fase de Preparacion
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        Monstruo monstruoAtacante = new MonstruoGenerico("test1",1000,0,3);
        Monstruo monstruoDefensor = new MonstruoGenerico("test1",0,0,3);
        atacante.colocar(monstruoAtacante);
        defensor.colocar(monstruoDefensor);

        assertThrows(NoDisponibleParaAtacarException.class , () -> { monstruoAtacante.atacarMonstruo(monstruoDefensor); });
    }

}
