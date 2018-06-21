package modelo.Fases;

public class FaseAtaque extends Fase {

    @Override
    public Fase siguienteFase(){
       // Juego.getJuego().getJugadorActivo().obtenerCampo().revertirCartaCampo();
        return new FaseFinal();
    }
    
    public void iniciarFase() {
    //    Juego.getJuego().getJugadorActivo().activarCartaCampo();
    }
    
    
    
    
}
