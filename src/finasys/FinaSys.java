/*
 * *** TODO *** 
 * 1. AccessManager, do enable disable buttons depending on
 * user level. 
 * 1.1 DatabaseManager, set up a database manager to handle the
 * entities from the db. - working on it 80% done. 
 * 2. AddStaff form. [Button -
 * done, Access, DB Link] 
 * 4.1. Graph Tax incomes form [Button, Access, DB Link]
 * 4.2. Export Tax incomes - CSV. [Button, Access, DB Link] 
 * 5. View expenses,
 * able to sort by vendor ID. [Button, Access, DB Link] 
 * 5.1. View upcoming
 * expenses and contract renewals 
 * 6.1 View vendors 7.1 ADD CONTENT TO THE
 * DATABASE. 
 * 8. Add user edit form (FinaSys user, not database) change password
 * and user access level.
 *
 *
 * COMPLETED (features available so far):
 *
 * 1. Login. 
 * 1.1 Multi-user login, ability to add users, remove them. 
 * 1.2 Passwords are hashed and salted, good luck brute-forcing! 
 * 1.3 If the users.dat file is not found, create an admin user, with default password
 *      "admin". 
 * 1.4 Added login by pressing ENTER key 
 * 2 Database. 
 * 2.1 Table auto-generate IDs. 3 User experience. 3.1 ListStaff form. (includes remove
 * staff) [Button, Access, DB Link] 3.2 List Tax incomes form. [Button, Access,
 * DB Link]
 *
 * *** IMPORTANT: PLEASE NOTE ***
 * 
 * This program starts the Java Derby server internally, so do not start the
 * server in Netbeans (or the port will be taken and the program will complain).
 * 
 * *** 
 * This project uses the following libraries and frameworks: 
 * -> JFreeChart:
 *      http://www.jfree.org/jfreechart/ API:
 *      http://www.jfree.org/jfreechart/api/javadoc/index.html
 *
 * -> JCommon (used by JFreeChart): http://www.jfree.org/jcommon/
 *
 * -> Google Guava: https://github.com/google/guava
 *
 * This project (The source-code, and any binaries built from it) is protected
 * by the GPL (GNU Public License) Version 3 License. If you are unaware of the
 * terms of the license please find it here:
 * http://www.gnu.org/licenses/gpl-3.0.en.html
 *
 * Made with love by St John Giddy, Matric '15, Abbotts College Claremont.
 */
package finasys;

import finasys.forms.LoginWindow;
import finasys.managers.AccessManager;
import finasys.managers.AccessManager.Level;
import finasys.managers.DatabaseManager;
import finasys.managers.UserManager;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;

/**
 *
 * @author Cawl
 */
public class FinaSys {

    /**
     * Main container
     */
    private static MainFrame mainFrame;
    /**
     * Centre of the screen
     */
    public final static Point centre
            = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    /**
     * Server thread
     */
    private static ServerThread server;

    /**
     * Login window
     */
    private static LoginWindow loginWindow;

    /**
     * Current Logged in user
     */
    private static User currentUser;

    /**
     * Boolean to keep the state of the program.
     */
    private static volatile boolean stopped = false;

    /**
     * Get Desktop pane instance
     *
     * @return
     */
    public static JDesktopPane getDesktop() {
        return MainFrame.getDesktop();
    }

    /**
     * Add an internal frame to the desktop pane. Centre it, make it visible and
     * then finally select it. If it is already visible, select it and return
     * the form.
     *
     * @param form JInternalFrame to add to the desktop pane.
     * @return Form added or selected.
     */
    public static JInternalFrame addToDesktop(JInternalFrame form) {
        if (form.isVisible()) {
            try {
                form.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
            return form;
        }
        getDesktop().add(form);
        form.setLocation(centreFrame(form));
        form.setVisible(true);
        try {
            form.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
        return form;
    }

    /**
     * Get Point at which is the center if the given frame compared to the
     * desktop pane.
     *
     * @param frame JInternalFrame to centre.
     * @return Centre point.
     */
    public static Point centreFrame(JInternalFrame frame) {
        return new Point(centre.x - frame.getWidth() / 2,
                centre.y - frame.getHeight() / 2);
    }

    /**
     * Get the current logged in user
     *
     * @return Current logged in user.
     */
    public static User getUser() {
        // If logging in as a guest.
        if (currentUser == null) {
            currentUser = new User(Level.NONE);
        }
        return currentUser;
    }

    /**
     * Run when a user logs in.
     *
     * @param user User to log in as.
     * @return True if login was successful. False otherwise.
     */
    public static boolean login(User user) {
        currentUser = user;

        loginWindow.setVisible(false);
        loginWindow.dispose();

        mainFrame = new MainFrame();
        mainFrame.setVisible(true);
        mainFrame.toFront();
        return true;
    }

    /**
     * Run when a user logs out.
     */
    public static void logout() {
        mainFrame.setVisible(false);
        if (DatabaseManager.getInstance().isConnected()) {
            DatabaseManager.getInstance().shutdown();
        }
        mainFrame.dispose();

        currentUser = null;
        AccessManager.getInstance().setUserLevel(Level.NONE);
        loginWindow = new LoginWindow();
        loginWindow.setVisible(true);
        loginWindow.toFront();
    }

    /**
     * Shutdown everything safely.
     */
    public static void shutdown() {
        stopped = true;
        // Make sure we have logged out the database
        try {
            DatabaseManager.getInstance().shutdown();
            //then shutdown the database server
            server.shutdown();
        } catch (Exception ex) {
            Logger.getLogger(FinaSys.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
            System.exit(0);
        }
    }

    /**
     * Returns a boolean representing the state of the program.
     *
     * @return True if the program is shutting down, false otherwise.
     */
    public static boolean isStopped() {
        return stopped;
    }

    /**
     * Start the Java Derby server on a new thread.
     */
    private static void startDerbyServer() {
        if (server == null) {
            server = new ServerThread();
            server.start();
        }
    }

    /**
     * Set the font of the program.
     *
     * @param f Font.
     */
    private static void setUIFont(javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
                UIManager.put(key, f);
            }
        }
    }

    /**
     * Entry Method. Start the derby server, initialize managers, initialize the
     * login window, set userlevel to NONE (ie: no user logged in).
     *
     * @param args
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc="Look and Feel and Font code">
        /* Set the Windows look and feel */
        // I am using a windows L&F, becuase this program won't (probably)
        // get run on a non-windows installation.
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    // Set font
                    setUIFont(new javax.swing.plaf.FontUIResource("Trebuchet MS", Font.PLAIN, 12));
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Start server
                startDerbyServer();
                // init managers
                UserManager.getInstance();
                DatabaseManager.getInstance();
                AccessManager.getInstance().setUserLevel(Level.NONE);
                //Set up login window
                loginWindow = new LoginWindow();
                loginWindow.setVisible(true);
                loginWindow.toFront();
            }

        });
    }
}
