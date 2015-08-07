/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.finasyscontent;

import finasys.managers.DatabaseManager;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giddyc
 */
public class Testing {
    public static void main(String[] args) {
        FinaSysContentGen randGen = FinaSysContentGen.getInstance();
        DatabaseManager.getInstance().connect();
//        try {
//            System.out.println("Date: " + randGen.getRandomDate(55));
//        } catch (ParseException ex) {
//            Logger.getLogger(Testing.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println("Float: " + randGen.getRandomFloat(50, 50000));
        System.out.println("Integer: " + randGen.getRandomInt(500));
    }
}
