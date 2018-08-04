package modelo;

import modelo.CartasMonstruosEspeciales.DragonDeOjosAzulesDefinitivo;
import modelo.Excepciones.RequiereSacrificioEspecialException;

import java.util.ArrayList;

public class Sacrificios {

    public ArrayList<Monstruo> sacrificios;

    public Sacrificios(){
        sacrificios = new ArrayList<>();
    }


    public void sacrificarMonstruos(Monstruo monstruo) {
        monstruo.verificarSacrificios(this);
        this.destruirSacrificios();
    }

    public void destruirSacrificios(){
        for (Monstruo carta : sacrificios) {
            carta.destruir();
        }
    }

    public void agregar(Monstruo monstruo){
        sacrificios.add(monstruo);
    }

    public int getCantidad() {
        return sacrificios.size();
    }

    public void verificarSacrificioEspecial(DragonDeOjosAzulesDefinitivo dragonDeOjosAzulesDefinitivo) {
        if (this.getCantidad() == 0){
            throw new RequiereSacrificioEspecialException();
        }
        for (Monstruo carta : sacrificios) {
            if(!carta.esDragonBlancoDeOjosAzules()){
                throw new RequiereSacrificioEspecialException();
            }
        }
    }
}
