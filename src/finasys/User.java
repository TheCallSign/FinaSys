/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys;

import finasys.managers.AccessManager.Level;
import java.util.UUID;

/**
 *
 * @author giddyc
 */
public class User implements java.io.Serializable{


    private byte[] password;
    private String username;
    private Level accessLevel;
    private byte[] salt;
    private final UUID uuid;

    public User(Level accessLevel) {
        this.accessLevel = accessLevel;
        uuid = UUID.randomUUID();
    }

    public User() {
        uuid = UUID.randomUUID();
    }
    
    public User(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
    
    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
    
    public void setPassword(byte[] password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccessLevel(Level accessLevel) {
        this.accessLevel = accessLevel;
    }

    public byte[] getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Level getAccessLevel() {
        return accessLevel;
    }
    
    public Object getByID(int i) {
        switch (i) {
            case 0: return username;
            case 1: return accessLevel;
        }
        return null;
    }
}
