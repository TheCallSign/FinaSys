/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.managers;

import static java.lang.StrictMath.random;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 *
 * @author giddyc
 */
public class PasswordUtils {

    public static byte[] hash(byte[] salt, String clearText) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return hash(salt, clearText.toCharArray());
        
    }
    public static byte[] hash(byte[] salt, char[] clearText) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeySpec spec = new PBEKeySpec(clearText, salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = f.generateSecret(spec).getEncoded();
        return hash;
    }
    
    public static byte[] getSalt(){
        byte[] salt = new byte[16];
        new Random().nextBytes(salt);
        return salt;
    }
}
