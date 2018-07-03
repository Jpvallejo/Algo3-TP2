package modelo.Estados;

import javafx.scene.image.ImageView;
import modelo.Monstruo;

public interface EstadoMonstruo {
    public void recibirDanio(Monstruo atacante, Monstruo defensor);

    ImageView obtenerImagen(Monstruo monstruo);

    void verificarAtaque();

    void permitirAtaque();
}
