package modelo;

public class Monstruo extends Carta {

    private int estrellas;

    private int puntosAtaque;

    private int puntosDefensa;

    private int nivel;

    private Posicion posicion;

    public Posicion getPosicion(){
        return this.posicion;
    }

    public Monstruo(int puntosAtaque, int puntosDefensa){
        super();
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.posicion = Posicion.DEFENSA;
    }

    public Monstruo(int puntosAtaque, int puntosDefensa, Posicion posicion, int estrellas){
        super();
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.posicion = posicion;
        this.estrellas = estrellas;
    }
/*
    public void atacarMonstruo(Monstruo objetivo)
    {
        Jugador atacante = Juego.getJuego().getJugadorActivo();
        Jugador defensor = Juego.getJuego().getJugadorOponente();
        int puntosAtacante = this.getPuntosAtaque();
        int puntosObjetivo;
        if(objetivo.getPosicion() == Posicion.ATAQUE) {
            puntosObjetivo = objetivo.getPuntosAtaque();

            if (puntosAtacante > puntosObjetivo) {
                defensor.obtenerCampo().matarMounstro(objetivo);
                defensor.setPuntosDeVida(defensor.getPuntosDeVida() - (puntosAtacante- puntosObjetivo));

            }
            else if(puntosAtacante == puntosObjetivo) {
                atacante.obtenerCampo().matarMounstro(this);
                defensor.obtenerCampo().matarMounstro(objetivo);
            }
            else{
                atacante.obtenerCampo().matarMounstro(this);
                atacante.setPuntosDeVida(atacante.getPuntosDeVida() - (puntosObjetivo - puntosAtacante));
            }

        }
        else{
            puntosObjetivo = objetivo.getPuntosDefensa();
            if (puntosAtacante > puntosObjetivo) {
                defensor.obtenerCampo().matarMounstro(objetivo);
            } else if (puntosAtacante == puntosObjetivo) {

            } else {
                atacante.setPuntosDeVida(atacante.getPuntosDeVida()- (puntosObjetivo - puntosAtacante));
            }
        }

    }
    */

    public void atacarMonstruo(Jugador atacante,Jugador defensor, Monstruo objetivo)
    {
        atacante.restarPuntosDeVida(this.danioAlAtacante(objetivo));
        defensor.restarPuntosDeVida(this.danioAlDefensor(objetivo));

        int puntosAtacante = this.getPuntosAtaque();
        int puntosObjetivo;
        if(objetivo.getPosicion() == Posicion.ATAQUE) {
            puntosObjetivo = objetivo.getPuntosAtaque();
            if (puntosAtacante > puntosObjetivo) {
                defensor.obtenerCampo().matarMounstro(objetivo);
            }
            else if(puntosAtacante == puntosObjetivo) {
                atacante.obtenerCampo().matarMounstro(this);
                defensor.obtenerCampo().matarMounstro(objetivo);
            }
            else{
                atacante.obtenerCampo().matarMounstro(this);
            }
        }
        else{
            puntosObjetivo = objetivo.getPuntosDefensa();
            if (puntosAtacante > puntosObjetivo) {
                defensor.obtenerCampo().matarMounstro(objetivo);
            }
        }

    }


    public void atacarPuntosDeVida(){
        Jugador oponente = Juego.getJuego().getJugadorOponente();
        int puntosDeVida = oponente.getPuntosDeVida();
        oponente.setPuntosDeVida(puntosDeVida - this.puntosAtaque);
    }

    private int getPuntosAtaque() {
        return this.puntosAtaque;
    }
    private void setPuntosAtaque(int _puntosAtaque){
        this.puntosAtaque = _puntosAtaque;
    }
    private int getPuntosDefensa(){
        return this.puntosDefensa;
    }
    private void setPuntosDefensa(int _puntosDefensa){
        this.puntosDefensa = _puntosDefensa;
    }

    private int getEstrellas(){
        return this.estrellas;
    }

    public boolean requiereSacrificio(){
        return this.getEstrellas() > 4;
    }

    public int cantidadASacrificar(){
        if(this.getEstrellas() > 6){
            return 2;
        }
        else if(this.getEstrellas() > 4){
            return 1;
        }

        return 0;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    @Override
    public void activarEfecto() {
    }

    public int danioAlAtacante(Monstruo objetivo) {
        int puntosAtacante = this.getPuntosAtaque();
        int puntosObjetivo;

        if(objetivo.getPosicion() == Posicion.ATAQUE) {
            puntosObjetivo = objetivo.getPuntosAtaque();
        }
        else {
            puntosObjetivo = objetivo.getPuntosDefensa();
        }

        // Si los puntos del defensor son mayores que los del atacante, devuelve la resta como danio al atacante, caso contrario devuelve 0
        return (puntosObjetivo > puntosAtacante) ? (puntosObjetivo - puntosAtacante) : 0;

    }

    public int danioAlDefensor(Monstruo objetivo) {
        int puntosAtacante = this.getPuntosAtaque();
        int puntosObjetivo;

        if(objetivo.getPosicion() == Posicion.ATAQUE) {
            puntosObjetivo = objetivo.getPuntosAtaque();

            // Si los puntos del atacante son mayores que los del defensor, devuelve la resta como daño al defensor, caso contrario devuelve 0
            return (puntosAtacante > puntosObjetivo) ? (puntosAtacante - puntosObjetivo) : 0;
        }
        else {
            // Si el objetivo esta en posicion de defensa no hay danio
            return 0;
        }

    }
}
