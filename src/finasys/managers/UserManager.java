/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.managers;

import finasys.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giddyc
 */
public class UserManager {


    private static UserManager instance;

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    ArrayList<User> users;

    private UserManager() {
        this.users = new ArrayList(Arrays.asList(loadUsers()));
    }
    
    /**
     * Return an ArrayList of users able to log into FinaSys.
     * @return Users able to log in.
     */
    public ArrayList<User> getUsers() {
        if (users == null) {
            users = new ArrayList<>(Arrays.asList(loadUsers()));
            return users;
        } else {
            return users;
        }
    }
    /**
     * Read the serialized object and load it into an array of Users.
     * @return Array of users.
     */
    public final User[] loadUsers() {

        User[] userArray;
        try {
            try (FileInputStream fileIn = new FileInputStream("users.dat")) {
                ObjectInputStream in = new ObjectInputStream(fileIn);
                Object[] objectArray = (Object[]) in.readObject();
                userArray = Arrays.copyOfRange(objectArray, 0, objectArray.length, User[].class);
                in.close();
            }
        } catch (IOException | ClassNotFoundException i) {
            System.err.println("File access error! Maybe the file doesn't exist?");
            userArray = new User[0];
            setUpAdmin();
        }
//        for (User u : userArray) {
//            if (u != null) {
//                System.out.printf("Username: " + u.getUsername() + " Password: " + new BigInteger(1, u.getPassword()).toString(16) + "\n");
//            }
//        }
        return userArray;
    }
    /**
     * Serialize the array of users. 
     */
    public void saveUsers() {

        Object[] userArray = users.toArray();
        FileOutputStream fileOut
                = null;
        try {
            fileOut = new FileOutputStream("users.dat");
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(userArray);
            } catch (IOException ex) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (fileOut != null) {
                    fileOut.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Add a user to the array of user able to access FinaSys, and save to file.
     * @param user User to add 
     * @throws finasys.managers.UserAlreadyExistsException Thrown if the user already exists.
     */
    public void addUser(User user) throws UserAlreadyExistsException {
        for(User u : users) {
            if(u.getUsername().equals(user.getUsername())){
                throw new UserAlreadyExistsException();
            }
        }
        users.add(user);
        saveUsers();
    }
    
    /**
     * Refresh a user's details.
     * @param user User to update
     */
    public void refreshUser(User user) {
        for(User u : users) {
            if(u.getUsername().equals(user.getUsername())){
                users.remove(u);
                users.add(user);
                return;
            }
        }
        // If the program gets here the user doesn't exist.
    }

    /**
     * Remove an user from the array, and save to file.
     * @param index
     */
    public void removeUser(int index) {
        users.remove(index);
        saveUsers();
    }

    /**
     * Set up a default account if the user file is not found.
     * Then save to file.
     */
    private void setUpAdmin() {
        User user = new User();
        user.setAccessLevel(AccessManager.Level.ADMIN);
        user.setUsername("admin");
        byte[] salt = PasswordUtils.getSalt();
        try {
            byte[] hash = PasswordUtils.hash(salt, "admin");
            user.setSalt(salt);
            user.setPassword(hash);
        } catch (InvalidKeySpecException | NoSuchAlgorithmException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        users = new ArrayList<>();
        users.add(user);
        this.saveUsers();
    }
}
