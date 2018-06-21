package modelo.creadorDeCartas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LeerArchivo {

    public void unArchivoDesdeAYLanzarException(String ruta, List<String> cartas, RuntimeException b) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(ruta).getFile());
            FileReader fr = new FileReader(file);
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
