/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.forms;

import finasys.User;
import finasys.enities.Tincomes;
import finasys.forms.administration.AdministrationForm;
import finasys.managers.DatabaseManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author stjohn
 */
public final class ViewTaxIncomesForm extends javax.swing.JInternalFrame {

    private static ViewTaxIncomesForm instance;

    public static ViewTaxIncomesForm getInstance() {
        if (instance == null) {
            instance = new ViewTaxIncomesForm();
        }
        return instance;
    }
    List<Tincomes> taxes;
    private int min = 0, max, pageCounter = 1;

    /**
     * Creates new form ViewTaxIncomesForm
     */
    public ViewTaxIncomesForm() {
        initComponents();
        updateTable();
    }

    public void updateTable() {
        max = Integer.parseInt(rowsPerScreenTxt.getText()) * pageCounter;
        min = Integer.parseInt(rowsPerScreenTxt.getText()) * (pageCounter - 1);
        taxes = DatabaseManager.getInstance().getTaxRows();
        final TaxTableModel tm = new TaxTableModel(taxes.subList(min, max));
//        tm.newDataAvailable(new TableModelEvent(tm));
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                taxTable.setModel(tm);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taxTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rowsPerScreenTxt = new javax.swing.JTextField();
        nextPage = new javax.swing.JButton();
        prevPage = new javax.swing.JButton();
        lastPage = new javax.swing.JButton();
        firstPage = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        taxTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(taxTable);

        jLabel1.setText("Rows per screen:");

        rowsPerScreenTxt.setText("20");

        nextPage.setText(">");
        nextPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextPageActionPerformed(evt);
            }
        });

        prevPage.setText("<");
        prevPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevPageActionPerformed(evt);
            }
        });

        lastPage.setText(">>");

        firstPage.setText("<<");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                        .addGap(28, 28, 28))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rowsPerScreenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(firstPage, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(prevPage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextPage, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastPage, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rowsPerScreenTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextPage)
                    .addComponent(prevPage)
                    .addComponent(lastPage)
                    .addComponent(firstPage))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextPageActionPerformed
        pageCounter++;
        updateTable();
    }//GEN-LAST:event_nextPageActionPerformed

    private void prevPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevPageActionPerformed
        pageCounter--;
        updateTable();
    }//GEN-LAST:event_prevPageActionPerformed

    private static class TaxTableModel extends DefaultTableModel {

        private final String[] columnNames = {"Tax ID", "Amount", "Date"};
        private final Object[][] data;

        public TaxTableModel(List<Tincomes> taxes) {
            if (taxes == null || taxes.isEmpty()) { // NULL CHECK 
                data = new Object[][]{};
                return;
            }
            data = new Object[taxes.size()][3];
            for (int i = 0; i < taxes.size(); i++) {
                data[i][0] = taxes.get(i).getTaxid();
                data[i][1] = taxes.get(i).getAmount();
                data[i][2] = taxes.get(i).getTdate();
            }
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton firstPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton lastPage;
    private javax.swing.JButton nextPage;
    private javax.swing.JButton prevPage;
    private javax.swing.JTextField rowsPerScreenTxt;
    private javax.swing.JTable taxTable;
    // End of variables declaration//GEN-END:variables
}
