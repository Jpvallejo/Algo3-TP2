package modelo;

public class Juego {
        private static Juego instancia = new Juego();

        public static Juego getJuego() {
            return instancia;
        }

        private Juego(){

        }

    private Jugador jugadorActivo;

    private Jugador jugadorOponente;

    private void cambiarTurno(){
        Jugador temp = this.jugadorActivo;
        this.jugadorActivo = this.jugadorOponente;
        this.jugadorOponente = temp;
    }

    public Jugador getJugadorOponente()
    {
        return jugadorOponente;
    }

    public Jugador getJugadorActivo() {
        return jugadorActivo;
    }
}
