package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class Reader {

    public void Read(TreeMap<String, ArrayList<String>> englishMap, TreeMap<String, ArrayList<String>> spanishMap, TreeMap<String, ArrayList<String>> frenchMap) throws Exception {
        
        String archivo = "src/diccionario.txt";
        ArrayList<String> elementos = new ArrayList<String>();

        try {
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");

                ArrayList<String> englishArrayList = new ArrayList<>();
                ArrayList<String> spanishArrayList = new ArrayList<>();
                ArrayList<String> frenchArrayList = new ArrayList<>();

                englishArrayList.add(partes[1]);
                englishArrayList.add(partes[2]);

                spanishArrayList.add(partes[0]);
                spanishArrayList.add(partes[2]);

                frenchArrayList.add(partes[0]);
                frenchArrayList.add(partes[1]);

                Trees addList = new Trees();

                addList.add(englishMap, partes[0], englishArrayList); //Cambiar
                addList.add(spanishMap, partes[1], spanishArrayList);
                addList.add(frenchMap, partes[2], frenchArrayList);

                addList.showMap(englishMap);
                addList.showMap(spanishMap);
                addList.showMap(frenchMap);
            }

            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
