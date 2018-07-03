package modelo.CartasMonstruosEspeciales;

import modelo.Excepciones.MonstruoDeFusionException;
import modelo.Monstruo;

public class DragonDeOjosAzulesDefinitivo extends Monstruo {

    public DragonDeOjosAzulesDefinitivo(){
        this.nombre = "Dragon De Ojos Azules Definitivo";
        this.descripcion = "Invocación: puede ser invocado sacrificando 3 dragones azules, del campo.";
    }

    @Override
    public void requiereSacrificios(){
        throw new MonstruoDeFusionException();
    }

    @Override
    public void requiereSacrificios(Monstruo sacrificio1){
        throw new MonstruoDeFusionException();
    }

    @Override
    public void requiereSacrificios(Monstruo sacrificio1, Monstruo sacrificio2){
        throw new MonstruoDeFusionException();
    }

    @Override
    public void requiereSacrificios(Monstruo sacrificio1, Monstruo sacrificio2, Monstruo sacrificio3){

      /*  if ((sacrificio1 instanceof DragonBlancoDeOjosAzules) && (sacrificio2 instanceof DragonBlancoDeOjosAzules) && (sacrificio3 instanceof DragonBlancoDeOjosAzules) ) {
            sacrificio1.destruir();
            sacrificio2.destruir();
            sacrificio3.destruir();
        }
        else{
            throw new MonstruoDeFusionException();
        }*/
        // Buscar otra forma de sacrificar...
        try {
            sacrificioEspecial((DragonBlancoDeOjosAzules) sacrificio1, (DragonBlancoDeOjosAzules) sacrificio2, (DragonBlancoDeOjosAzules) sacrificio3);
        }
        catch(Exception e){
            throw new MonstruoDeFusionException();
        }

    }


    public void sacrificioEspecial(DragonBlancoDeOjosAzules d1, DragonBlancoDeOjosAzules d2, DragonBlancoDeOjosAzules d3){
        d1.destruir();
        d2.destruir();
        d3.destruir();
    }


}
