package modelo.Estados;

import modelo.Monstruo;

public class EstadoDefensaBocaArriba implements Estado,EstadoMonstruo{

    public void recibirDanio(Monstruo atacante, Monstruo defensor) {
        atacante.comparararConDefensa(defensor);
    }

}
