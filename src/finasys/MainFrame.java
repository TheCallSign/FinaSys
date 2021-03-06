/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys;

import finasys.forms.LoadingForm;
import finasys.forms.administration.AdministrationForm;
import finasys.forms.report.GraphForm;
import finasys.forms.ViewTaxIncomesForm;
import finasys.forms.staff.AddStaffForm;
import finasys.forms.staff.ListStaffForm;
import finasys.forms.staff.StaffSearchForm;
import finasys.managers.AccessManager;
import finasys.managers.DatabaseManager;
import java.awt.Color;
import java.awt.Component;
import java.beans.PropertyVetoException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import tests.Graph;
import tests.GraphSettings;
import tests.GraphTest;

/**
 *
 * @author giddyc
 */
public class MainFrame extends javax.swing.JFrame {

    public static JDesktopPane getDesktop() {
        return desktop;
    }

    private final DateFormat dateFormat;
    private LoadingForm loadingForm;

    /**
     * Creates new form FinacSysMain
     */
    public MainFrame() {
        this.dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM);
        initComponents();
        setLocationRelativeTo(null);
        setContentPane(desktop);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // Pull up progress bar
        doLoadingBar();
//        Access check
        doAccessCheck();
        // Update Status bar
        statusUpdate();
        // start the status bar update thread
        startStatusThread();
        // If it gets laggy uncomment this.
//        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
    }

    private void doLoadingBar() {
        loadingForm = new LoadingForm();
        loadingForm.getProgressBar().setIndeterminate(true);
        FinaSys.addToDesktop(loadingForm);
    }

    public final synchronized void statusUpdate() {
        userLbl.setText(FinaSys.getUser().getUsername());
        userLbl.setForeground(Color.green);
        if (DatabaseManager.getInstance().isConnected()) {
            databaseStatusLbl.setText("Online");
            databaseStatusLbl.setForeground(Color.green);
            connectBtn.setText("Connected");
            connectBtn.setEnabled(false);
            if (!loadingForm.isClosed()) {
                loadingForm.getProgressBar().setIndeterminate(false);
                loadingForm.getProgressBar().setValue(100);
                loadingForm.setTitle("Connected");
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                       
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        loadingForm.dispose();
                    }
                });

            }
        } else {
            databaseStatusLbl.setText("Offline");
            databaseStatusLbl.setForeground(Color.red);
            connectBtn.setText("Connect");
            connectBtn.setEnabled(true);
        }
        switch (FinaSys.getUser().getAccessLevel()) {
            case ADMIN:
                accessLvlLbl.setText("Administrator");
                accessLvlLbl.setForeground(Color.red);
                break;
            case MOD:
                accessLvlLbl.setText("Manager");
                accessLvlLbl.setForeground(Color.blue);
                break;
            case USER:
                accessLvlLbl.setText("User");
                accessLvlLbl.setForeground(Color.green);
        }
        Date d = Calendar.getInstance().getTime();
        dateLbl.setText(dateFormat.format(d));
    }

    private void startStatusThread() {
        Thread statusBarThread = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (this) {
                    while (!FinaSys.isStopped()) {
                        statusUpdate();
                        try {
                            this.wait(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

        });
        statusBarThread.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        desktop = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        controlToolBar = new javax.swing.JToolBar();
        addStaffBtn = new javax.swing.JButton();
        listStaffMembersBtn = new javax.swing.JButton();
        jToolBar1 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        listTaxIncomeBtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton3 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JToolBar.Separator();
        adminBtn = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel2 = new javax.swing.JPanel();
        controlToolBar1 = new javax.swing.JToolBar();
        jToolBar2 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        userLbl = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JToolBar.Separator();
        jLabel2 = new javax.swing.JLabel();
        databaseStatusLbl = new javax.swing.JLabel();
        connectBtn = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JToolBar.Separator();
        jLabel3 = new javax.swing.JLabel();
        accessLvlLbl = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JToolBar.Separator();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        dateLbl = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        searchStaffMnuBtn = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        logoutMenuBtn = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FinaSys - Advanced City Financal Management System");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        setResizable(false);

        desktop.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        controlToolBar.setFloatable(false);
        controlToolBar.setRollover(true);

        addStaffBtn.setText("Add Staff Member");
        addStaffBtn.setToolTipText("Add a Staff Member to the database");
        addStaffBtn.setFocusable(false);
        addStaffBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addStaffBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addStaffBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStaffBtnActionPerformed(evt);
            }
        });
        controlToolBar.add(addStaffBtn);

        listStaffMembersBtn.setText("List Staff Members");
        listStaffMembersBtn.setFocusable(false);
        listStaffMembersBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        listStaffMembersBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        listStaffMembersBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listStaffMembersBtnActionPerformed(evt);
            }
        });
        controlToolBar.add(listStaffMembersBtn);

        jToolBar1.setRollover(true);
        controlToolBar.add(jToolBar1);
        controlToolBar.add(jSeparator2);

        listTaxIncomeBtn.setText("List Tax");
        listTaxIncomeBtn.setFocusable(false);
        listTaxIncomeBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        listTaxIncomeBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        listTaxIncomeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listTaxIncomeBtnActionPerformed(evt);
            }
        });
        controlToolBar.add(listTaxIncomeBtn);
        controlToolBar.add(jSeparator1);

        jButton3.setText("Report");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        controlToolBar.add(jButton3);
        controlToolBar.add(jSeparator6);

        adminBtn.setText("Administration");
        adminBtn.setFocusable(false);
        adminBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        adminBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        adminBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminBtnActionPerformed(evt);
            }
        });
        controlToolBar.add(adminBtn);
        controlToolBar.add(filler2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(controlToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        controlToolBar1.setFloatable(false);
        controlToolBar1.setRollover(true);

        jToolBar2.setRollover(true);
        controlToolBar1.add(jToolBar2);

        jLabel1.setText("Logged in as:");
        controlToolBar1.add(jLabel1);

        userLbl.setText("USER");
        controlToolBar1.add(userLbl);
        controlToolBar1.add(jSeparator7);

        jLabel2.setText("Database Status: ");
        controlToolBar1.add(jLabel2);

        databaseStatusLbl.setText("D-Status");
        controlToolBar1.add(databaseStatusLbl);

        connectBtn.setText("Connect");
        connectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBtnActionPerformed(evt);
            }
        });
        controlToolBar1.add(connectBtn);
        controlToolBar1.add(jSeparator8);

        jLabel3.setText("Access Level: ");
        controlToolBar1.add(jLabel3);

        accessLvlLbl.setText("ACCESS");
        controlToolBar1.add(accessLvlLbl);
        controlToolBar1.add(jSeparator9);
        controlToolBar1.add(filler3);

        dateLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dateLbl.setText("TIME");
        controlToolBar1.add(dateLbl);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(controlToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(controlToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        desktop.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        fileMenu.setText("File");

        searchStaffMnuBtn.setText("Search Staff");
        searchStaffMnuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStaffMnuBtnActionPerformed(evt);
            }
        });
        fileMenu.add(searchStaffMnuBtn);
        fileMenu.add(jSeparator3);

        logoutMenuBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        logoutMenuBtn.setText("Logout");
        logoutMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuBtnActionPerformed(evt);
            }
        });
        fileMenu.add(logoutMenuBtn);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Quit FinaSys");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        fileMenu.add(jMenuItem1);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");
        jMenuBar1.add(editMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(desktop)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adminBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminBtnActionPerformed
        FinaSys.addToDesktop(AdministrationForm.getInstance());

    }//GEN-LAST:event_adminBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tests.Graph gf = new Graph();
        GraphSettings graphSettings = new GraphSettings();
        desktop.add(graphSettings);
        graphSettings.setVisible(true);
        desktop.add(gf);
        gf.setLocation(FinaSys.centreFrame(gf));
        gf.setVisible(true);
        try {
            gf.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void listTaxIncomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listTaxIncomeBtnActionPerformed
        FinaSys.addToDesktop(ViewTaxIncomesForm.getInstance());

    }//GEN-LAST:event_listTaxIncomeBtnActionPerformed

    private void logoutMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuBtnActionPerformed
        FinaSys.logout();
    }//GEN-LAST:event_logoutMenuBtnActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FinaSys.shutdown();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void listStaffMembersBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listStaffMembersBtnActionPerformed
        FinaSys.addToDesktop(new ListStaffForm());

    }//GEN-LAST:event_listStaffMembersBtnActionPerformed

    private void connectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBtnActionPerformed
        connectBtn.setText("Connecting");

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if (!DatabaseManager.getInstance().isConnected()) {

                    if (DatabaseManager.getInstance().connect()) {
                        connectBtn.setText("Connected");
                        connectBtn.setEnabled(false);
                        connectBtn.setSelected(false);
                    }
                }
            }
        });

    }//GEN-LAST:event_connectBtnActionPerformed

    private void addStaffBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStaffBtnActionPerformed
        FinaSys.addToDesktop(new AddStaffForm());

    }//GEN-LAST:event_addStaffBtnActionPerformed

    private void searchStaffMnuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchStaffMnuBtnActionPerformed
        FinaSys.addToDesktop(new StaffSearchForm());
    }//GEN-LAST:event_searchStaffMnuBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accessLvlLbl;
    private javax.swing.JButton addStaffBtn;
    private javax.swing.JButton adminBtn;
    private volatile javax.swing.JButton connectBtn;
    private javax.swing.JToolBar controlToolBar;
    private javax.swing.JToolBar controlToolBar1;
    private javax.swing.JLabel databaseStatusLbl;
    private javax.swing.JLabel dateLbl;
    private static javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator6;
    private javax.swing.JToolBar.Separator jSeparator7;
    private javax.swing.JToolBar.Separator jSeparator8;
    private javax.swing.JToolBar.Separator jSeparator9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton listStaffMembersBtn;
    private javax.swing.JButton listTaxIncomeBtn;
    private javax.swing.JMenuItem logoutMenuBtn;
    private javax.swing.JMenuItem searchStaffMnuBtn;
    private javax.swing.JLabel userLbl;
    // End of variables declaration//GEN-END:variables

    private void doAccessCheck() {
        switch (FinaSys.getUser().getAccessLevel()) {
            case NONE:
                for (Component c : this.getComponents()) {
                    c.setEnabled(false);
                }
            case USER:
                controlToolBar.remove(addStaffBtn);
            case MOD:
                controlToolBar.remove(adminBtn);

        }
    }

}
