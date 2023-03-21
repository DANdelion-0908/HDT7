package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Reader {

    public ArrayList<String> Read() throws Exception {
        String archivo = "src/diccionario.txt";
        ArrayList<String> elementos = new ArrayList<String>();
        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                for (String parte : partes) {
                    elementos.add(parte);
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(elementos);

        return elementos;
    }
}


