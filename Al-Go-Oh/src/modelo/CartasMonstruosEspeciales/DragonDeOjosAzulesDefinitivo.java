package modelo.CartasMonstruosEspeciales;

import modelo.Excepciones.RequiereSacrificioException;
import modelo.Monstruo;
import modelo.Sacrificios;

public class DragonDeOjosAzulesDefinitivo extends Monstruo {

    public DragonDeOjosAzulesDefinitivo(){
        super();
        puntosAtaque = 4500;
        puntosDefensa = 3800;
        estrellas = 12;
        this.nombre = "Dragon De Ojos Azules Definitivo";
        this.descripcion = "Invocación: puede ser invocado sacrificando 3 dragones azules, del campo.";
    }

    @Override
    public int cantidadASacrificar(){
        return 3;
    }

    @Override
    public void verificarSacrificios(Sacrificios sacrificios) {
        sacrificios.verificarSacrificioEspecial(this);
    }

    @Override
    public void verificarSacrificios(){
        throw new RequiereSacrificioException();
    }

    /*

    @Override
    public void verificarSacrificios(Monstruo sacrificio1, Monstruo sacrificio2, Monstruo sacrificio3){

      /*  if ((sacrificio1 instanceof DragonBlancoDeOjosAzules) && (sacrificio2 instanceof DragonBlancoDeOjosAzules) && (sacrificio3 instanceof DragonBlancoDeOjosAzules) ) {
            sacrificio1.destruir();
            sacrificio2.destruir();
            sacrificio3.destruir();
        }
        else{
            throw new RequiereSacrificioEspecialException();
        }*/
        // Buscar otra forma de sacrificar...
        /*try {
            sacrificioEspecial((DragonBlancoDeOjosAzules) sacrificio1, (DragonBlancoDeOjosAzules) sacrificio2, (DragonBlancoDeOjosAzules) sacrificio3);
        }
        catch(Exception e){
            throw new RequiereSacrificioEspecialException();
        }

    }*/

    public void sacrificioEspecial(DragonBlancoDeOjosAzules d1, DragonBlancoDeOjosAzules d2, DragonBlancoDeOjosAzules d3){
    }


}
