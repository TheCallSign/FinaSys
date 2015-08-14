/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.forms.staff;

import finasys.enities.Staff;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author stjohn
 */
public class StaffTableModel extends DefaultTableModel {

    private final String[] columnNames = {"Staff ID", "Full Name", "Contact Number"};
    private final Object[][] data;

    public StaffTableModel(List<Staff> staff) {
        if (staff == null || staff.isEmpty()) { // NULL CHECK 
            data = new Object[][]{};
            return;
        }
        data = new Object[staff.size()][3];
        for (int i = 0; i < staff.size(); i++) {
            data[i][0] = staff.get(i).getStaffid();
            data[i][1] = staff.get(i).getFname() + staff.get(i).getSname();
            data[i][2] = staff.get(i).getContact();
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

    public int getSize() {
        return data.length;
    }
}
