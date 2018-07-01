package modelo.Fases;

import vista.PantallaBatalla;

public interface Fase {

    Fase siguienteFase();

    void iniciarFase();

    String getNombre();

    void activarHandles(PantallaBatalla pantallaBatalla);
}
