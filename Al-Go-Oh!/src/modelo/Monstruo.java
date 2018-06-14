package modelo;

public class Monstruo extends Carta {

    private int puntosAtaque;

    private int puntosDefensa;

    private int nivel;

    private Efecto efecto;

    private Posicion posicion;

    private Posicion getPosicion(){
        return this.posicion;
    }

    public Monstruo(int puntosAtaque, int puntosDefensa){
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.posicion = Posicion.DEFENSA;
    }

    public Monstruo(int puntosAtaque, int puntosDefensa, Posicion posicion){
        this.puntosAtaque = puntosAtaque;
        this.puntosDefensa = puntosDefensa;
        this.posicion = posicion;
    }

    public void atacarMounstro(Monstruo objetivo, Jugador atacante, Jugador defensor)
    {
        int puntosAtacante = this.getPuntosAtaque();
        int puntosObjetivo;
        if(this.getPosicion() == Posicion.ATAQUE) {
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

    public void atacarPuntosDeVida(Jugador oponente){
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


}
