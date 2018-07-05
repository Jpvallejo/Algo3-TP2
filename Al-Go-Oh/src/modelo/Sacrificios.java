package modelo;

import modelo.Excepciones.RequiereSacrificioException;

import java.util.ArrayList;

public class Sacrificios {

    public ArrayList<Monstruo> sacrificios;

    public Sacrificios(){
        sacrificios = new ArrayList<>();
    }


    public void sacrificarMonstruos(Monstruo monstruo) {

        if (monstruo.cantidadASacrificar() != this.getCantidad()){
            throw new RequiereSacrificioException();
        }

        for (Monstruo carta : sacrificios){
            carta.destruir();
        }
    }

    public void agregar(Monstruo monstruo){
        sacrificios.add(monstruo);
    }

    public int getCantidad() {
        return sacrificios.size();
    }
}
