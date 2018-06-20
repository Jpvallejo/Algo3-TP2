package vista.Botones;

import modelo.CartaTrampa;

public class BotonCartaTrampa extends BotonCarta{
    private CartaTrampa hechizo;

    public CartaTrampa getHechizo() {
        return hechizo;
    }

    private void setHechizo(CartaTrampa hechizo) {
        this.hechizo = hechizo;
    }


    public BotonCartaTrampa() {
        super();
        this.setVisible(true);

    }

    public BotonCartaTrampa(CartaTrampa hechizo){
        this.setVisible(true);
        this.setHechizo(hechizo);
    }
}
