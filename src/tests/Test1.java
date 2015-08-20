/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;


import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tools.PasswordUtils;

/**
 *
 * @author giddyc
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            //chiken
//            Base64.Encoder enc = Base64.getEncoder();
            byte[] salt = PasswordUtils.getSalt();
            byte[] hash = PasswordUtils.hash(salt, "mans0n");
            
            System.out.println("salt: " + new BigInteger(1, salt).toString(16));
            System.out.println("hash: " + new BigInteger(1, hash).toString(16));

        } catch (InvalidKeySpecException | NoSuchAlgorithmException ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
