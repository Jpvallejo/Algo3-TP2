package vista.Botones;

import modelo.CartaMagica;

public class BotonCartaMagica extends BotonCarta{
    private CartaMagica hechizo;

    public CartaMagica getHechizo() {
        return hechizo;
    }

    private void setHechizo(CartaMagica hechizo) {
        this.hechizo = hechizo;
    }


    public BotonCartaMagica() {
        super();
        this.setVisible(true);

    }
    public BotonCartaMagica(CartaMagica hechizo){
        this.setVisible(true);
        this.setHechizo(hechizo);
        this.setName(hechizo.getNombre());
        this.setOpaque(false);
    }
}
