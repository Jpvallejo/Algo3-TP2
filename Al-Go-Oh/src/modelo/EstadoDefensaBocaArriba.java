package modelo;

public class EstadoDefensaBocaArriba extends Estado {

    @Override
    public void recibirDanio(Monstruo atacante, Monstruo defensor) {
        atacante.comparararConDefensa(defensor);
    }

}
