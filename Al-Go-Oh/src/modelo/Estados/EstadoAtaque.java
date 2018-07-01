package modelo.Estados;

import modelo.Monstruo;

public class EstadoAtaque implements EstadoMonstruo, Estado {

    public void recibirDanio(Monstruo atacante, Monstruo defensor) {
        atacante.comparararConAtaque(defensor);
    }
}
