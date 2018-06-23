package modelo;

public class EstadoDefensaBocaAbajo extends Estado {

    public void recibirDanio(Monstruo atacante, Monstruo defensor) {
        defensor.activarEfectoDeVolteo(atacante);
        atacante.comparararConDefensa(defensor);
    }
}
