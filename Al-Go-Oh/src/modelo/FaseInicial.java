package modelo;

public class FaseInicial extends Fase {

    public Fase siguienteFase(){
        return new FasePreparacion();
    }

    public void iniciarFase() {
        Juego.getJuego().getJugadorActivo().extraerCartaDelMazo();
    }


}
