/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys;

import finasys.forms.administration.AdministrationForm;
import finasys.forms.GraphForm;
import finasys.forms.ViewTaxIncomesForm;
import finasys.forms.staff.StaffRegistrationForm;
import java.awt.Component;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
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

    /**
     * Creates new form FinacSysMain
     */
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setContentPane(desktop);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        Access check
        doAccessCheck();
        // If it gets laggy uncomment this.
//        desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
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
        jButton3 = new javax.swing.JButton();
        listTaxIncomeBtn = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jSeparator1 = new javax.swing.JToolBar.Separator();
        adminBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        logoutMenuBtn = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FinaSys - Advanced City Financal Management System");
        setAlwaysOnTop(true);
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
        controlToolBar.add(addStaffBtn);

        listStaffMembersBtn.setText("List Staff Members");
        listStaffMembersBtn.setFocusable(false);
        listStaffMembersBtn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        listStaffMembersBtn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        controlToolBar.add(listStaffMembersBtn);

        jToolBar1.setRollover(true);
        controlToolBar.add(jToolBar1);

        jButton3.setText("Example Graph");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        controlToolBar.add(jButton3);

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
        controlToolBar.add(filler2);
        controlToolBar.add(jSeparator1);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(controlToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(controlToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktopLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 233, Short.MAX_VALUE))
        );
        desktop.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        fileMenu.setText("File");

        logoutMenuBtn.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        logoutMenuBtn.setText("Logout");
        logoutMenuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutMenuBtnActionPerformed(evt);
            }
        });
        fileMenu.add(logoutMenuBtn);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Logout & Quit FinaSys");
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
        AdministrationForm af = AdministrationForm.getInstance();
        if (af.isVisible()) {
            try {
                af.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
            return;
        }
        desktop.add(af);
        af.setLocation(FinaSys.getCenteredFrame(af));
        af.setVisible(true);
        try {
            af.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_adminBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        tests.Graph gf = new Graph();
        GraphSettings graphSettings = new GraphSettings();
        desktop.add(graphSettings);
        graphSettings.setVisible(true);
        desktop.add(gf);
        gf.setLocation(FinaSys.getCenteredFrame(gf));
        gf.setVisible(true);
        try {
            gf.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void listTaxIncomeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listTaxIncomeBtnActionPerformed
        ViewTaxIncomesForm form =  ViewTaxIncomesForm.getInstance();
        if (form.isVisible()) {
            try {
                form.setSelected(true);
            } catch (java.beans.PropertyVetoException e) {
            }
//            af.toFront();
            return;
        }
        desktop.add(form);
        form.setLocation(FinaSys.getCenteredFrame(form));
        form.setVisible(true);
        try {
            form.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_listTaxIncomeBtnActionPerformed

    private void logoutMenuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutMenuBtnActionPerformed
        FinaSys.logout();
    }//GEN-LAST:event_logoutMenuBtnActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        FinaSys.logout();
        FinaSys.shutdown();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStaffBtn;
    private javax.swing.JButton adminBtn;
    private javax.swing.JToolBar controlToolBar;
    private static javax.swing.JDesktopPane desktop;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton listStaffMembersBtn;
    private javax.swing.JButton listTaxIncomeBtn;
    private javax.swing.JMenuItem logoutMenuBtn;
    // End of variables declaration//GEN-END:variables

    private void doStuff() {
        StaffRegistrationForm frame = new StaffRegistrationForm();
        frame.setVisible(true); //necessary as of 1.3
        frame.setLocation(FinaSys.centre);
        desktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    void exitAllForms() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
