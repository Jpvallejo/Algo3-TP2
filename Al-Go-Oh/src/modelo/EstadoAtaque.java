package modelo;

public class EstadoAtaque extends Estado {

    public void recibirDanio(Monstruo atacante, Monstruo defensor) {
        atacante.comparararConAtaque(defensor);
    }
}
