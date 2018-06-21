package resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class LeerArchivo {

    public void unArchivoDesdeAYLanzarException(String ruta, List<String> cartas, RuntimeException b) {
        try {
            FileReader fr = new FileReader(ruta);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while((linea = br.readLine()) != null)
                cartas.add(linea);
            fr.close();
        }  catch(Exception e) {
            throw b;
        }
    }
}
