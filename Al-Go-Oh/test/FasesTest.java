
import modelo.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;





public class FasesTest {
    
     @Test
    public void test01SegundaEntrega(){
        /*Colocar un monstruo de cada lado del campo. Activo la carta mágica Wasteland y verificar que de un lado del campo, el ataque del monstruo aumenta en 200 puntos y del otro lado del campo, se aumenta la defensa del monstruo en 300 puntos.*/


        new CartaMagicaTest().testAplicarCartaWastelandEnMonstruosYAtacar();
    }
    
    
    
    
    
    
    
}
