package modelo;

import modelo.CartasMagicas.AgujeroNegro;
import modelo.CartasMagicas.CilindroMagico;
import modelo.CartasMagicas.Sogen;
import modelo.CartasMagicas.Wasteland;
import modelo.CartasMonstruosEspeciales.InsectoComeHombres;
import modelo.CartasMonstruosEspeciales.JinzoNro7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import static java.util.Collections.shuffle;

public class Mazo {

    private Stack<Carta> cartas;

    private ArrayList<Carta> monstruos = obtenerMonstruosDeArchivo();


    private ArrayList<Carta> hechizos = obtenerHechizosDeArchivo();



    public Mazo() throws IOException {
        this.cartas = new Stack<Carta>();
        try {
            construirMazo(this.monstruos, this.hechizos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Carta extaerCarta() {
        return this.cartas.pop();
    }


    public void agregarCarta(Carta carta) {
        this.cartas.push(carta);
    }

    public void mezclar() {
        shuffle(this.cartas);
    }

    public int getTamanio() {
        return this.getCartas().size();
    }

    private Stack<Carta> getCartas() {
        return this.cartas;
    }

    private void construirMazo(ArrayList<Carta> monstruos, ArrayList<Carta> hechizos) throws Exception {

        int cantidadMonstruos = 30;
        int cantidadHechizos = 10;

        Random r = new Random();

        for (; cantidadMonstruos > 0; cantidadMonstruos--) {

            Monstruo monstruo = (Monstruo) monstruos.get(r.nextInt(monstruos.size()));

            String nombre = monstruo.getNombre();
            Monstruo clon;
            switch (nombre) {
                case "Agujero Negro":
                    clon = new InsectoComeHombres(Posicion.ATAQUE);
                    break;
                case "Jinzo Nro7":
                    clon = new JinzoNro7(Posicion.ATAQUE);
                    break;
                default:
                    clon = new Monstruo(monstruo.getNombre(), monstruo.getPuntosAtaque(), monstruo.getPuntosDefensa(),
                            Posicion.ATAQUE, monstruo.getEstrellas());
                    break;

            }

            cartas.add(clon);

        }

        for (; cantidadHechizos > 0; cantidadHechizos--) {

            Carta hechizo = hechizos.get(r.nextInt(hechizos.size()));
            Carta clon;

            if(hechizo instanceof AgujeroNegro){
                clon = new AgujeroNegro();
            }
            else if(hechizo instanceof CilindroMagico){
                clon = new CilindroMagico();
            }
            else if(hechizo instanceof Sogen){
                clon = new Sogen();
            }
            else if(hechizo instanceof Wasteland){
                clon = new Wasteland();
            }
            else{
                throw new Exception("Error en Archivo");
            }
            cartas.push(clon);
        }
        this.mezclar();
    }



    private ArrayList<Carta> obtenerMonstruosDeArchivo() throws IOException {
        ArrayList<Carta> temp = new ArrayList<Carta>();

        String linea;

        ClassLoader classLoader = getClass().getClassLoader();
        BufferedReader br = new BufferedReader(new FileReader(classLoader.getResource("Monstruos.csv").getFile()));

        int lineaNumero = 0;

        while ((linea = br.readLine()) != null) {

            lineaNumero++;
            String[] infoCarta = linea.split(";");
            switch (infoCarta[0]) {
                case "Insecto Come Hombres":
                    temp.add(new InsectoComeHombres(Posicion.ATAQUE));
                    break;
                case "Jinzo Nro7":
                    temp.add(new JinzoNro7(Posicion.ATAQUE));
                    break;
                default:
                    temp.add(new Monstruo(infoCarta[0], Integer.parseInt(infoCarta[1]), Integer.parseInt(infoCarta[2]),
                            Posicion.ATAQUE, Integer.parseInt(infoCarta[3])));
            }
        }
        br.close();
        return temp;
    }

    private ArrayList<Carta> obtenerHechizosDeArchivo() throws IOException {
        ArrayList<Carta> temp = new ArrayList<Carta>();

        String linea;

        ClassLoader classLoader = getClass().getClassLoader();
        BufferedReader br = new BufferedReader(new FileReader(classLoader.getResource("Hechizos.csv").getFile()));

        int lineaNumero = 0;

        while ((linea = br.readLine()) != null) {

            lineaNumero++;
            String[] infoCarta = linea.split(",");
            switch (infoCarta[0]) {
                case "Agujero Negro":
                    temp.add(new AgujeroNegro());
                    break;
                case "Cilindro Magico":
                    temp.add(new CilindroMagico());
                    break;
                case "Sogen":
                    temp.add(new Sogen());
                    break;
                case "Wasteland":
                    temp.add(new Wasteland());
                    break;
            }
        }
        br.close();
        return temp;
    }
}
