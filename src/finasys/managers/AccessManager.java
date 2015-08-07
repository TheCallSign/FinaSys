/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.managers;

/**
 *
 * @author giddyc
 */
public class AccessManager {

    private static AccessManager instance;

    private AccessManager() {
    }

    private Level userLevel;

    public void setUserLevel(Level userLevel) {
        this.userLevel = userLevel;
    }

    public static AccessManager getInstance() {
        if (instance == null) {
            return new AccessManager(Level.USER);
        } else {
            return instance;
        }
    }

    public static enum Level {
        ADMIN,
        MOD,
        USER,
        NONE
    }

    public static Level getLevelFromString(String s) {
        Level level = null;
        switch (s) {
            case "ADMIN":
                level = Level.ADMIN;
                break;
            case "MOD":
                level = Level.MOD;
                break;
            case "USER":
                level = Level.USER;
                break;
        }
        return level;
    }

    public AccessManager(Level userLevel) {
        this.userLevel = userLevel;
    }

    public Level getUserLevel() {
        return userLevel;
    }

    /**
     * Attempt to increase the access level of the user, if it fails, throw a
     * security exception
     *
     * @param level
     * @return
     */
    public Level increaseLevel(Level level) {
        // do this
        return null;
    }

}
