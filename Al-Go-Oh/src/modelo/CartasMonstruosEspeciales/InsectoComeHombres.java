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
        this.nombre = "Insecto Come Hombres";
        this.descripcion = "destruye un monstruo en el campo.\n" +
                "Este efecto únicamente puede activarse cuando esta carta pasa de estar boca abajo a boca arriba." +
                " (tanto si es atacada estando volteada abajo, o si la volteo yo mismo en un turno diferente al de la" +
                " invocación).";
    }

    @Override
    public void activarEfectoDeVolteo(Monstruo atacante) {
        atacante.comparararConDefensa(this);
        atacante.destruir();
        throw new DetenerAtaqueException();
    }


}
