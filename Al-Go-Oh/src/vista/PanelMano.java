package vista;

import modelo.*;
import vista.Botones.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelMano  extends JPanel {
        private ArrayList<BotonCarta> botonesMano;
        public PanelMano(Jugador jugador) {
            actualizarMano(jugador);



        }
        public ArrayList<BotonCarta> getBotonesMano(){
            return this.botonesMano;
        }
        public void setBotonesMano(ArrayList<BotonCarta> botones){
            this.botonesMano = botones;
        }

        public void actualizarMano(Jugador jugador){
            this.removeAll();
            this.revalidate();
            botonesMano = new ArrayList<BotonCarta>();
            Mano mano = jugador.getMano();
            for (Carta carta: mano.getCartas()) {
                if(carta instanceof Monstruo){
                    BotonMonstruo botonMonstruo = new BotonMonstruo((Monstruo)carta);
                    this.add(botonMonstruo);
                    botonesMano.add(botonMonstruo);
                    /**
                    ImageIcon img = new ImageIcon("Cards Images Database/Monsters/"+carta.getName()+".png");
                    Image img2 = img.getImage();
                    Image newimg = img2.getScaledInstance(100, 146,  java.awt.Image.SCALE_SMOOTH);
                    ImageIcon newIcon = new ImageIcon(newimg);
                     */
                    botonMonstruo.setIcon(new ImageIcon());
                    botonMonstruo.setPreferredSize(new Dimension(100,146));
                    botonMonstruo.revalidate();
                    botonMonstruo.setOpaque(false);
                    botonMonstruo.repaint();
                }
                else if(carta instanceof CartaMagica){
                    BotonCartaMagica botonCartaMagica = new BotonCartaMagica((CartaMagica)carta);
                    this.add(botonCartaMagica);
                    botonesMano.add(botonCartaMagica);
                    /**FOTO*/
                    botonCartaMagica.setIcon(new ImageIcon());
                    botonCartaMagica.setPreferredSize(new Dimension(100,146));
                    botonCartaMagica.revalidate();
                    botonCartaMagica.setOpaque(false);
                    botonCartaMagica.repaint();
                }
                else {
                    BotonCartaTrampa botonCartaTrampa = new BotonCartaTrampa((CartaTrampa)carta);
                    botonCartaTrampa.setVisible(true);
                    this.add(botonCartaTrampa);
                    botonesMano.add(botonCartaTrampa);
                    /**FOTO*/
                    botonCartaTrampa.setIcon(new ImageIcon());
                    botonCartaTrampa.setPreferredSize(new Dimension(100,146));
                    botonCartaTrampa.revalidate();
                    botonCartaTrampa.setOpaque(false);
                    botonCartaTrampa.repaint();

                }

            }
        }

}
