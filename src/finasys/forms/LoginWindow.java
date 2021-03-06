/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.forms;

import finasys.FinaSys;
import finasys.User;
import finasys.managers.AccessManager;
import finasys.managers.DatabaseManager;
import tools.PasswordUtils;
import finasys.managers.UserManager;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author giddyc
 */
public class LoginWindow extends javax.swing.JFrame {

    /**
     * Creates new form LoginWindow
     */
    public LoginWindow() {
        initComponents();
        setTitle("Login");
        //centre window
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        usernameFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        passwordFld = new javax.swing.JPasswordField();
        statusLbl = new javax.swing.JLabel();
        quitBtn = new javax.swing.JButton();
        titlePanel = new javax.swing.JPanel();
        titleLbl = new javax.swing.JLabel();
        subTitleLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        loginPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        loginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameFld.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        loginPanel.add(usernameFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 72, 254, -1));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Username");
        loginPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 52, 254, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Password");
        loginPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 103, 254, -1));

        loginBtn.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        loginBtn.setText("Login");
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });
        loginPanel.add(loginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 74, -1));

        passwordFld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        loginPanel.add(passwordFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 123, 254, -1));

        statusLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        statusLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLbl.setText(" ");
        loginPanel.add(statusLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 149, 232, 30));

        quitBtn.setText("Quit");
        quitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitBtnActionPerformed(evt);
            }
        });
        loginPanel.add(quitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 70, -1));

        titlePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        titleLbl.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLbl.setText("FinaSys");

        subTitleLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        subTitleLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        subTitleLbl.setText("Advanced City Financal Management System");

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(subTitleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(titleLbl, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subTitleLbl)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loginPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed

        // For debugging purposes. Uncomment to quickly log in with the password 123
//        if (Arrays.equals(passwordFld.getPassword(), new char[]{'1', '2', '3'})) {
//            User user = new User(AccessManager.Level.ADMIN);
//            login(user);
//            return;
//        }

        // Run the checking asynchronisly, as password hashing can be quite cpu-intensive.
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                boolean passwordAccepted = false;
                for (User user : UserManager.getInstance().getUsers().values()) {
                    if (user.getUsername().toLowerCase().equals(usernameFld.getText().toLowerCase())) {
                        byte[] hash = null;
                        try {
                            hash = PasswordUtils.hash(user.getSalt(), passwordFld.getPassword());
                        } catch (InvalidKeySpecException | NoSuchAlgorithmException ex) {
                            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (Arrays.equals(user.getPassword(), hash)) {
                            login(user);
                            passwordAccepted = true;
                        }
                    }
                    if (!passwordAccepted) {
                        statusLbl.setForeground(Color.red);
                        statusLbl.setText("Incorrect username or password.");
                    }
                }
            }
        });

    }//GEN-LAST:event_loginBtnActionPerformed

    private void login(User user) {
        final User u = user;
        statusLbl.setForeground(Color.blue);
        statusLbl.setText("Password accepted, logging in...");
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                DatabaseManager.getInstance().connect();
            }
        });
        t.start();
        AccessManager.getInstance().setUserLevel(u.getAccessLevel());
        FinaSys.login(user);
    }

    

    private void quitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitBtnActionPerformed
        // Make sure everything is shutdown correctly
        FinaSys.shutdown();
        System.exit(0);
    }//GEN-LAST:event_quitBtnActionPerformed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            loginBtnActionPerformed(null);
        }
    }//GEN-LAST:event_formKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPasswordField passwordFld;
    private javax.swing.JButton quitBtn;
    private static javax.swing.JLabel statusLbl;
    private javax.swing.JLabel subTitleLbl;
    private javax.swing.JLabel titleLbl;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JTextField usernameFld;
    // End of variables declaration//GEN-END:variables
}
