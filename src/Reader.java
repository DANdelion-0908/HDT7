package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Reader {

    public ArrayList<String> Read(String fileToRead) throws Exception {
        
        ArrayList<String> wordsAndSentence = new ArrayList<>();
        String fileString = fileToRead;

        try {
            FileReader fileReader = new FileReader("src/" + fileString + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String linea;

            while ((linea = bufferedReader.readLine()) != null) {
                wordsAndSentence.add(linea);

            }

            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return wordsAndSentence;
    }

}
