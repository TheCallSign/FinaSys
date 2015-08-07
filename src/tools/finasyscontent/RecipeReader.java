/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.finasyscontent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cawl
 */
public class RecipeReader {

    public static void main(String[] args) {
        try {
            RecipeReader rr = new RecipeReader(new File("test_recipe.recipe"));
            rr.read();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(RecipeReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private final String version = "1";
    
    private List<String> lines;
    private final File file;

    private Scanner fin;
    
    String[] syntax = {"entity", "GenRecipe", "{", "}", ":", "(", ")"};
    
    public RecipeReader(File f) throws FileNotFoundException {
        file = f;
        fin = new Scanner(file);
    }

    public Instruction read() {
        fin.useDelimiter(";");
        while(fin.hasNext()){
            String line = fin.next().trim();
            String words[] = line.split(" ");
            if(words[0].equals(syntax[0])){
                String entityClass = words[1].replaceAll("(|)", "");
                
            }
        }
        return null; // just for now
    }

}
