package modelo;

public class Ataque {


    private Jugador jugadorAtacante;
    private Jugador jugadorDefensor;
    private Monstruo monstruoAtacante;
    private Monstruo monstruoDefensor;

    public Ataque(Jugador _atacante, Jugador _defensor, Monstruo _monstruoAtacante, Monstruo _monstruoDefensor){
        jugadorAtacante = _atacante;
        jugadorDefensor = _defensor;
        monstruoAtacante = _monstruoAtacante;
        monstruoDefensor = _monstruoDefensor;
    }

    public Ataque(Jugador _atacante, Jugador _defensor, Monstruo _monstruoAtacante) {
        jugadorAtacante = _atacante;
        jugadorDefensor = _defensor;
        monstruoAtacante = _monstruoAtacante;
    }

    public void realizarAtaque(){

        // Si no se activa el efecto de carta trampa o el efecto de los monstruos, se ejecuta el ataque
        if ( !jugadorDefensor.obtenerCampo().activarEfectoCartaTrampa(this) &&
                !monstruoDefensor.activarEfectoEnAtaque(this) &&
                !monstruoAtacante.activarEfectoEnAtaque(this)
                ) {

            if (monstruoDefensor.getPosicion() == Posicion.ATAQUE) {
                if (monstruoDefensor.noDefiendeEnAtaque(monstruoAtacante)) {
                    //defensor.obtenerCampo().matarMonstruo(objetivo);
                    monstruoDefensor.destruir();
                    jugadorDefensor.restarPuntosDeVida(monstruoAtacante.getPuntosAtaque() - monstruoDefensor.getPuntosAtaque());
                }
                if (monstruoAtacante.noDefiendeEnAtaque(monstruoDefensor)) {
                    //atacante.obtenerCampo().matarMonstruo(this);
                    monstruoAtacante.destruir();
                    jugadorAtacante.restarPuntosDeVida(monstruoDefensor.getPuntosAtaque() - monstruoAtacante.getPuntosAtaque());
                }
            } else {
                if (monstruoDefensor.noDefiendeEnDefensa(monstruoAtacante)) {
                    //defensor.obtenerCampo().matarMonstruo(objetivo);
                    monstruoDefensor.destruir();
                }
                if (monstruoDefensor.daniaEnDefensa(monstruoAtacante)) {
                    jugadorAtacante.restarPuntosDeVida(monstruoDefensor.getPuntosDefensa() - monstruoAtacante.getPuntosAtaque());
                }


            }

        }

        monstruoDefensor.setEstado(Colocacion.BOCAARRIBA);
    }

    public void atacarPuntosDeVida() {
        if ( !jugadorDefensor.obtenerCampo().activarEfectoCartaTrampa(this) ) {
            jugadorDefensor.restarPuntosDeVida(monstruoAtacante.getPuntosAtaque());
        }
    }

    public Monstruo getMonstruoAtacante() {
        return monstruoAtacante;
    }

    public Monstruo getMonstruoDefensor() {
        return monstruoDefensor;
    }

    public Jugador getJugadorAtacante() {
        return jugadorAtacante;
    }

    public Jugador getJugadorDefensor() {
        return jugadorDefensor;
    }
}
