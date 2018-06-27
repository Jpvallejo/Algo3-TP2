import modelo.Estados.EstadoDefensaBocaAbajo;
import modelo.Estados.EstadoAtaque;
import modelo.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import modelo.Excepciones.RequiereSacrificioException;
import modelo.Monstruos.AgresorOscuro;
import modelo.Monstruos.AgujaAsesina;
import modelo.Monstruos.AsechadorDelCraneo;
import modelo.Monstruos.MonstruoGenerico;
import org.junit.Test;


public class MonstruoTest {

    @Test
    public void testColocarMonstruoEnPosicionDeAtaqueGeneraMonstruoEnPosicionDeAtaque(){
        Monstruo monstruo = new MonstruoGenerico("test",100,100,4);
        Jugador jugador = new Jugador();

        jugador.invocar(monstruo);

        assertTrue(monstruo.getEstado() instanceof EstadoAtaque);
    }

    @Test
    public void testColocarMonstruoEnPosicionDeDefensaGeneraMonstruoEnPosicionDeDefensa(){
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
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AgujaAsesina monstruoAtacante = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        AgujaAsesina monstruoDefensor = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        atacante.invocar(monstruoAtacante);
        defensor.invocar(monstruoDefensor);

        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(1, atacante.cantidadCartasCementerio());
        assertEquals(1, defensor.cantidadCartasCementerio());
    }

    @Test
    public void testInvocarYAtacarMounstroEnPocisionAtaqueConPuntosAtacanteMayorDestruyeDefensorYRestaDiferenciaEnPuntosJugadorQueDefiende() {
        Jugador atacante = new Jugador();
        Jugador defensor = new Jugador();
        AgujaAsesina monstruoAtacante = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        AsechadorDelCraneo monstruoDefensor = new AsechadorDelCraneo(); //ATK = 900 DEF = 800
        atacante.invocar(monstruoAtacante);
        defensor.invocar(monstruoDefensor);

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
        Jugador atacante = new Jugador(); //Juego.getJuego().getJugadorActivo();
        Jugador defensor = new Jugador(); //Juego.getJuego().getJugadorOponente();
        AsechadorDelCraneo monstruoAtacante = new AsechadorDelCraneo(); //ATK = 900 DEF = 800
        AgujaAsesina monstruoDefensor = new AgujaAsesina(); //ATK = 1200 DEF = 1000
        atacante.invocar(monstruoAtacante);
        defensor.colocar(monstruoDefensor);

        monstruoAtacante.atacarMonstruo(monstruoDefensor);

        assertEquals(0, atacante.cantidadCartasCementerio());
        assertEquals(0, defensor.cantidadCartasCementerio());
        assertEquals(atacante.getPuntosDeVida(), 7900);
        assertEquals(defensor.getPuntosDeVida(), 8000);

    }



    @Test
    public void testMonstruoConMenosDeCuatroEstrellasNoRequiereSacrificio(){
        Monstruo monstruo = new MonstruoGenerico("test",0,0,3);
        assertFalse(monstruo.requiereSacrificio());
    }

    @Test
    public void testMonstruoConMasDeCuatroEstrellasRequiereSacrificio(){
        Monstruo monstruo = new MonstruoGenerico("test2",0,0,6);
        assertTrue(monstruo.requiereSacrificio());
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
        Monstruo aSacrificar= new MonstruoGenerico("test1",0,0,3);
        Monstruo sacrificador = new MonstruoGenerico("test2",0,0,5);
        Jugador jugador = new Jugador();

        jugador.invocar(aSacrificar);
        jugador.invocar(sacrificador, aSacrificar);
        assertEquals(1,jugador.cantidadCartasCementerio());
    }


    @Test
    public void testInvocarMonstruoCon7EstrellasSacrificaDosMonstruos(){
        Jugador jugador = new Jugador();
        Monstruo aSacrificar1= new MonstruoGenerico("test1",0,0,3);
        Monstruo aSacrificar2= new MonstruoGenerico("test2",0,0,3);
        Monstruo sacrificador = new MonstruoGenerico("test3",0,0,7);
        jugador.invocar(aSacrificar1);
        jugador.invocar(aSacrificar2);
        jugador.invocar(sacrificador,aSacrificar1,aSacrificar2);
        assertEquals(2,jugador.cantidadCartasCementerio());
    }

    @Test
    public void testColocarMonstruoCon5EstrellasSacrificaUnMonstruo(){
        Monstruo aSacrificar= new MonstruoGenerico("test1",0,0,3);
        Monstruo sacrificador = new MonstruoGenerico("test2",0,0,5);
        Jugador jugador = new Jugador();

        jugador.colocar(aSacrificar);
        jugador.colocar(sacrificador, aSacrificar);
        assertEquals(1,jugador.cantidadCartasCementerio());
    }


    @Test
    public void testColocarMonstruoCon7EstrellasSacrificaDosMonstruos(){
        Jugador jugador = new Jugador();
        Monstruo aSacrificar1= new MonstruoGenerico("test1",0,0,3);
        Monstruo aSacrificar2= new MonstruoGenerico("test2",0,0,3);
        Monstruo sacrificador = new MonstruoGenerico("test3",0,0,7);
        jugador.colocar(aSacrificar1);
        jugador.colocar(aSacrificar2);
        jugador.colocar(sacrificador,aSacrificar1,aSacrificar2);
        assertEquals(2,jugador.cantidadCartasCementerio());
    }


    @Test
    public void testColocarMonstruoCon5o6EstrellasRetornaErrorSiNoSePasa1Sacrificio(){
        Jugador jugador = new Jugador();
        Monstruo sacrificador1 = new MonstruoGenerico("test1",0,0,5);
        Monstruo sacrificador2 = new MonstruoGenerico("test2",0,0,6);

        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(sacrificador1); });
        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(sacrificador2); });
    }


    @Test
    public void testColocarMonstruoCon7u8EstrellasRetornaErrorSiNoSePasan2Sacrificios(){
        Jugador jugador = new Jugador();
        Monstruo aSacrificar1= new MonstruoGenerico("test1",0,0,3);
        Monstruo sacrificador1 = new MonstruoGenerico("test1",0,0,7);
        Monstruo sacrificador2 = new MonstruoGenerico("test2",0,0,8);
        jugador.invocar(aSacrificar1);

        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(sacrificador1); });
        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(sacrificador2); });
        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(sacrificador1,aSacrificar1); });
        assertThrows(RequiereSacrificioException.class , () -> { jugador.invocar(sacrificador2,aSacrificar1); });
    }


    @Test
    public void testInvocarMonstruoEnPosicionDeAtaqueYAtacaAlOponenteSinMonstruosRestaLosPuntosDeAtaqueALosPuntosDeVidaDelJugadorQueDefiende() {
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
        Jugador jugador = new Jugador();
        Monstruo monstruo = new MonstruoGenerico("test1",0,0,3);

        jugador.invocar(monstruo);

        monstruo.destruir();

        assertFalse(jugador.getZonaMonstruo().contains(monstruo));
    }

    @Test
    public void testAlInvocarUnMonstruoYDestruirloNoSeEncuentraEnElCampoAunqueHayaMonstruosDelMismoTipo(){
        Jugador jugador = new Jugador();
        Monstruo agresor1 = new AgresorOscuro();
        Monstruo agresor2 = new AgresorOscuro();
        Monstruo agresor3 = new AgresorOscuro();

        jugador.invocar(agresor1);
        jugador.invocar(agresor2);
        jugador.invocar(agresor3);

        agresor3.destruir();

        assertFalse(jugador.getZonaMonstruo().contains(agresor3));
    }

}
