package src;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.util.Map;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Reader {
    String valuesString;
    String line;
    
    public String Read() {
        String MyFile = "src/diccionario.txt";

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(MyFile), "UTF-8"));
            while((line = bufferedReader.readLine()) != null) {
                
            }
        } catch (Exception e) {
        }
        
        
        
        
        return valuesString; 
    }
}
