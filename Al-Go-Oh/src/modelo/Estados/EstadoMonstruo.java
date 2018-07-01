package modelo.Estados;

import modelo.Monstruo;

public interface EstadoMonstruo {
    public void recibirDanio(Monstruo atacante, Monstruo defensor);
}
