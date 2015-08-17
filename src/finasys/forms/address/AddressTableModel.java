/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finasys.forms.address;

import finasys.enities.Addresses;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author stjohn
 */
public class AddressTableModel extends DefaultTableModel {

    private final String[] columnNames = {"Street Name", "Suburb", "Zip Code" };
    private final Object[][] data;

    public AddressTableModel(List<Addresses> addresses) {
        if (addresses == null || addresses.isEmpty()) { // NULL CHECK 
            data = new Object[][]{};
            return;
        }
        data = new Object[addresses.size()][3];
        for (int i = 0; i < addresses.size(); i++) {
            data[i][0] = addresses.get(i).getStreetName();
            data[i][1] = addresses.get(i).getSuburb();
            data[i][2] = addresses.get(i).getPostalCode();
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
