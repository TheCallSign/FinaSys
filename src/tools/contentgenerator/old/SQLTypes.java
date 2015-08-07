/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.contentgenerator.old;

/**
 *
 * @author stjohn
 */
public class SQLTypes {
    public static final int INTEGER = 0;
    public static final int DATE = 1;
    public static final int VARCHAR = 2;
    public static final int DOUBLE = 2;
    public static final int BOOLEAN = 3;
    
    private static String[] types = {
        "INTERGER",
        "DATE",
        "VARCHAR",
        "DOUBLE",
        "BOOLEAN"
    };
    
    public static String[] getTypes(){
        return types;
    }
    
    public static String getType(int i){
        return types[i];
    }
    
}
