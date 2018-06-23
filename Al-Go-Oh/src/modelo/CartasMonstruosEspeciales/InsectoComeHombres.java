package modelo.CartasMonstruosEspeciales;

import modelo.*;
import modelo.Excepciones.DetenerAtaqueException;

public class InsectoComeHombres extends Monstruo{


    public InsectoComeHombres(){
        super();
        this.puntosAtaque = 450;
        this.puntosDefensa = 600;
        this.adicionalesDeAtaque = 0;
        this.adicionalesDeDefensa = 0;
        this.estrellas = 2;
    }

    @Override
    public void activarEfectoDeVolteo(Monstruo atacante) {
        atacante.comparararConDefensa(this);
        atacante.destruir();
        throw new DetenerAtaqueException();
    }


}
