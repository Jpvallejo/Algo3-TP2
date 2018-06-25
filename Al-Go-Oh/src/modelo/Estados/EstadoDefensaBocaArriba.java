package modelo.Estados;

import modelo.Monstruo;

public class EstadoDefensaBocaArriba extends Estado {

    @Override
    public void recibirDanio(Monstruo atacante, Monstruo defensor) {
        atacante.comparararConDefensa(defensor);
    }

}
