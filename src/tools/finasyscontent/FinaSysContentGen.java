/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.finasyscontent;

import finasys.enities.Addresses;
import finasys.enities.FinaSysEntity;
import finasys.enities.Staff;
import finasys.enities.Tincomes;
import finasys.managers.DatabaseManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Entity;

/**
 *
 * @author giddyc
 */
public class FinaSysContentGen {

    private FinaSysContentGen() {

        seed = new Random().nextLong();
        gen = new Random(seed);

    }

    private static FinaSysContentGen instance;
    private long seed;
    Random gen;

    private static String[] streets = {"St Davids Road", "St Thomas Road", "St Patricks Road", "Long Street", "Hospital Street",
        "Shorter Main Road", "Upper Main Road", "Main Road", "Cook Street", "Ave. de Mist", "Cavendish Circle"};
    private static String[] suburbs = {"Claremont", "Newlands", "Rondebosch", "City of Cape Town", "Summerset West"};

    private static int counter = 0;

    private static DatabaseManager dm;
    public static void main(String[] args) {
//        try {
        //        for(int i = 0;i<100;i++){
//            int code = getInstance().getRandomInt(16)+71;
//            System.out.println("0"+code+" "+(getInstance().getRandomInt(900_000_0)+100_000_0));
//        }
        
        dm = DatabaseManager.getInstance();
        dm.connect();
//        for (int i = 0; i < 300; i++) {
//            FinaSysContentGen.getInstance().run(300, "Addresses");
//            dm.flush();
//            FinaSysContentGen.getInstance().run(300, "Staff");
            FinaSysContentGen.getInstance().run(30000, "Tax");
//        }
        
        dm.shutdown();
//            System.out.println(new java.sql.Date(FinaSysContentGen.getInstance().getRandomDate(2014, 2).getTime()));

    }

    public static FinaSysContentGen getInstance() {
        if (FinaSysContentGen.instance == null) {
            instance = new FinaSysContentGen();
        }
        return instance;
    }

    private void run(int interations, String entityName) {
        
        switch (entityName) {
            case "Addresses":
                for (int i = 0; i < interations; i++) {
                    Addresses obj = new Addresses();
                    String posCode = "" + (getRandomInt(3000) + 1000);
                    String streetName = getRandomStreetName();
                    obj.setAddressid(getRandomInt(9000) + 1000);
                    obj.setPostalCode(posCode);
                    obj.setStreetName(streetName);
                    obj.setStreetNumber(getRandomInt(50) + 1);
                    obj.setSuburb(getRandomSuburb());
                    dm.insert(obj);
                    
                }   break;
            case "Staff":
                for (int i = 0; i < interations; i++) {
                    Staff obj = new Staff();
                    String name = getRandomName();
                    String fname = name.substring(0, name.indexOf(" ")),
                            sname = name.substring(name.indexOf(" "), name.length());
                    obj.setFname(fname);
                    obj.setSname(sname);
                    int code = getInstance().getRandomInt(16) + 71;
                    obj.setContact("0" + code + (getRandomInt(900_000_0) + 100_000_0));
                    obj.setContractStart(new java.sql.Date(getRandomDate(2014, 2).getTime()));
                    obj.setContractExpiry(new java.sql.Date(getRandomDate(2016, 3).getTime()));
                    List<Addresses> addresses = DatabaseManager.getInstance().getAddressRows();
                    obj.setHomeAddress(addresses.get(i));
                    obj.setSalary((getRandomInt(500_000) + 50_000));
                    dm.insert(obj);
//                System.out.println(dm.getAddressRows());
//im a loser ! :0 <==8
            }   break;
            case "Tax":
//                List<Tincome> objects = new ArrayList<>();
                for (int i = 0; i < interations; i++) {
                    Tincomes obj = new Tincomes();
                    obj.setAmount(getRandomInt(100_000_000)+500_000);
                    obj.setTdate(new java.sql.Date(getRandomDate(1990, 24).getTime()));
                    dm.insert(obj);
                }
            
        }
        System.out.println("Generated " + interations + " new records");
    }

    public int getRandomInt(int max) {
        return gen.nextInt(max);
    }

    public Date getRandomDate(int yearMin, int yearMod) {
        // A quick and dirty random date getter. 
        int year = gen.nextInt(yearMod) + yearMin;
        int month = gen.nextInt(13);
        int day;
        do {
            day = gen.nextInt(31); // never going to be 31.
        } while (year % 4 == 0 && month == 2 && day > 28);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);

        return cal.getTime();
    }

    public float getRandomFloat(float min, float max) {
        return (gen.nextFloat() * max) + min;
    }

    public void generate(Object[] rows, Class entity) {

    }

    private String getRandomStreetName() {
        if (streets.length != 0) {
            return streets[getRandomInt(streets.length)];
        } else {
            return null;
        }
    }

    private String getRandomSuburb() {
        if (suburbs.length != 0) {
            return suburbs[getRandomInt(suburbs.length)];
        } else {
            return null;
        }
    }

    private String getRandomName() {
        List<String> names = readLines(new File("names.txt"));
        return names.get(getRandomInt(names.size()));
    }

    private List<String> readLines(File f) {
        List<String> lines = new ArrayList<>();
        try (Scanner s = new Scanner(f)) {
            while (s.hasNextLine()) {
                lines.add(s.nextLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FinaSysContentGen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lines;
    }

}
