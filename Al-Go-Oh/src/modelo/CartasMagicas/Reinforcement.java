package modelo.CartasMagicas;


import modelo.CartaTrampa;
import modelo.Jugador;
import modelo.Monstruo;

public class Reinforcement extends CartaTrampa {

    public Reinforcement(){
        nombre = "Reinforcements";
        descripcion = "Efecto: tu monstruo atacado, gana 500 puntos de ataque hasta el final del turno.";
    }

    @Override
    public void activarEfectoEnAtaque(Monstruo atacante, Monstruo defensor) {
        //ataque.getMonstruoDefensor().sumarAdicionalAlataque(500);
        defensor.sumarAdicionalAlataque(500);
        this.destruir();
    }
}
