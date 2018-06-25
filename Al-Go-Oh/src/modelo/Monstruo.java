package modelo;

import modelo.Excepciones.DetenerAtaqueException;
import modelo.Excepciones.RequiereSacrificioException;

public abstract class Monstruo extends Carta {

    protected int estrellas;

    protected int puntosAtaque;
    protected int puntosDefensa;
    protected int adicionalesDeAtaque ;
    protected int adicionalesDeDefensa;

    protected int nivel;


    public Monstruo(){
        super();
        this.puntosAtaque = 0;
        this.puntosDefensa = 0;
        this.adicionalesDeAtaque = 0;
        this.adicionalesDeDefensa = 0;
        this.estado = new EstadoSinEstado();
        this.estrellas = 0;
    }

    @Override
    public void destruir(){
        jugador.obtenerCampo().matarMonstruo(this);
    }


    public void atacarMonstruo(Monstruo defensor){
        try {
            defensor.recibirDanio(this);
        }
        catch (DetenerAtaqueException e) {

        }
    }

    // Metodos que utiliza el atacante el defensor
    public void atacar(Jugador defensor) {
        try {
            defensor.activarCartaTrampa(this, null);
            defensor.restarPuntosDeVida(this.getPuntosAtaque());
        }
        catch(DetenerAtaqueException e){

        }
    }

    public void comparararConDefensa(Monstruo defensor) {
        if(this.getPuntosAtaque() > defensor.getPuntosDefensa()){
            defensor.destruir();
        }
        else{
            this.daniarJugador(defensor.getPuntosDefensa() - this.getPuntosAtaque());
        }
    }

    public void comparararConAtaque(Monstruo defensor) {
        if(this.getPuntosAtaque() >= defensor.getPuntosAtaque()){
            defensor.destruir();
            defensor.daniarJugador(this.getPuntosAtaque() - defensor.getPuntosAtaque());
        }

        if(this.getPuntosAtaque() <= defensor.getPuntosAtaque()){
            this.destruir();
            this.daniarJugador(defensor.getPuntosAtaque() - this.getPuntosAtaque());
        }
    }

    // Metodo que utiliza el defensor
    private void recibirDanio(Monstruo atacante) {
        jugador.activarCartaTrampa(atacante,this);
        estado.recibirDanio(atacante, this);

    }

    public void daniarJugador(int puntos){
        jugador.restarPuntosDeVida(puntos);
    }


    public void requiereSacrificios(int cantidad){

        // Si la cantidad de estrellas es de 0 a 4 es 0
        // Si la cantidad de estrellas es de 5 o 6 es 1
        // Si la cantidad de estrellas es de 6 o mas es 2
        int sacrificios = Math.min(Math.max((this.getEstrellas() - 3) / 2, 0 ) ,2);

        if (sacrificios != cantidad ){
            throw new RequiereSacrificioException();
        }
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


    public void sumarAdicionalAlataque(int adicional) {
        this.adicionalesDeAtaque += adicional;

    }

    public void sumarAdicionalAlaDefensa(int adicional) {
        this.adicionalesDeDefensa += adicional;
    }

    public void ponerAdicionalesEnCero(){
        this.adicionalesDeAtaque = 0;
        this.adicionalesDeDefensa = 0;
    }


    boolean esMenorElAtaque(Monstruo monstruo){
        return this.getPuntosAtaque() > monstruo.getPuntosAtaque();
    }

    public void activarEfectoDeVolteo(Monstruo atacante) {}



    /* ***** Getter y Setters ****** */
    public int getPuntosAtaque() {
        return this.puntosAtaque + this.adicionalesDeAtaque;
    }
    protected void setPuntosAtaque(int _puntosAtaque){
        this.puntosAtaque = _puntosAtaque;
    }

    protected int getPuntosDefensa(){
        return this.puntosDefensa + this.adicionalesDeDefensa;
    }
    protected void setPuntosDefensa(int _puntosDefensa){
        this.puntosDefensa = _puntosDefensa;
    }

    protected int getEstrellas(){
        return this.estrellas;
    }


}
