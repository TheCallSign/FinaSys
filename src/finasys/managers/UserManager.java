/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.managers;

import tools.PasswordUtils;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import finasys.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * File Specification. :-)
 * <p>
 * Current version Version 2 of users.dat. users.dat contains 2 objects
 * serialized. The first object (well sort of, it is actually a primitive) is a
 * byte dictating the version of file we are dealing with, so for version 2 the
 * byte is 0x02. <br/>
 * The second object is a Map<UUID, User> with the users in.
 * <br/>
 * History of the spec. <br/>
 * Version 1 simply serialized an array of Users to the file. Clunky and slow it
 * suited early development of this project. The array was then loaded into a
 * list for adding and removing of users.
 * </p>
 *
 * @author giddyc
 */
public class UserManager {

    private static UserManager instance;
    private static final byte version = 0x02;
    private static final String fileName = "users.dat";

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    Map<UUID, User> users;

    private UserManager() {
        this.users = Maps.newHashMap();
    }

    /**
     * Return an ArrayList of users able to log into FinaSys.
     *
     * @return Users able to log in.
     */
    public Map<UUID, User> getUsers() {
        if (users.isEmpty()) {
            users = loadUsers();
            return users;
        } else {
            return users;
        }
    }

    /**
     * Read the serialized object and load it into an array of Users.
     *
     * @return Array of users.
     */
    public final Map<UUID, User> loadUsers() {

        Map<UUID, User> userArray = Maps.newHashMap();
        try {
            try (FileInputStream fileIn = new FileInputStream(fileName);
                    ObjectInputStream in = new ObjectInputStream(fileIn)) {
                byte readVersion = in.readByte();
                if (!Objects.equal(readVersion, version)) {
                    throw new VersionIncorrectException(); // Make sure version is correct
                }
                userArray = (Map) in.readObject();
            } catch (VersionIncorrectException ex) {
                Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null,
                        "File is of a different version. Overwriting");
                // Note, in production, usually we would try to preserve the contents of the
                // old file. But for now we can disregard that.
                setUpDefaultUser();
            }
        } catch (IOException | ClassNotFoundException i) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null,
                    "File access error! Maybe the file doesn't exist?");
            setUpDefaultUser();
        }
        return userArray;
    }

    /**
     * Serialize the array of users.
     */
    public void saveUsers() {
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeByte(version); // Save our version number
            out.writeObject(users); // then the map of users
            
        } catch (IOException ex) {
            Logger.getLogger(UserManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Add a user to the array of user able to access FinaSys, and save to file.
     *
     * @param user User to add.
     * @throws finasys.managers.UsernameAlreadyExistsException Thrown if the user
     * already exists.
     */
    public void addUser(User user) throws UsernameAlreadyExistsException {
        for (User u : users.values()) {
            if (Objects.equal(u.getUsername(), user.getUsername())) {
                throw new UsernameAlreadyExistsException();
            }
        }
        users.put(user.getUuid(), user);
        saveUsers();
    }

    /**
     * Refresh a user's details.
     *
     * @param user User to update
     * @throws finasys.managers.UserDoesNotExistException If the user that was
     * attempted to be updated doesn't exist.
     */
    public void refreshUser(User user) throws UserDoesNotExistException {
        for (UUID uuid : users.keySet()) {
            if (user.getUuid().equals(uuid)) {
                users.put(uuid, user);
                return;
            }
        }
        throw new UserDoesNotExistException();
        // If the program gets here the user doesn't exist.
    }

    /**
     * Remove an user from the array, and save to file.
     *
     * @param uuid User UUID.
     */
    public void removeUser(UUID uuid) {
        users.remove(uuid);
        saveUsers();
    }

    /**
     * Set up a default account if the user file is not found. Then save to
     * file.
     */
    private void setUpDefaultUser() {
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
        users.put(user.getUuid(), user);
        this.saveUsers();
    }
}
