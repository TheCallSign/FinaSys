/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.contentgenerator.old;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author stjohn
 */
class SQLLine {

    /**
     * The template is like this INSERT INTO {SCHEMA}.{TABLE_NAME} ({ROWS})
     * VALUES ({VALUES}) Example: INSERT INTO ADMINISTRATOR.EXPENSES (VENDORID,
     * EXPENSE_NAME, AMOUNT, "REPEAT", REPEAT_EXPIRY) VALUES (123, '123', 123.0,
     * true, '2015-07-25')
     */
    private static final String template = "INSERT INTO {0}.{1} ({2}) \n"
            + "	VALUES ({3})";

    // Row-name, value 
    private Map<String, String> data;
    // value, type
    private Map<String, Integer> dataTypes;
    private String tableName;
    private String schemaName;

    public void addValue(String rowName, int dataType, String value){
        data.put(rowName, value);
        dataTypes.put(value, dataType);
    }
    
    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    @Override
    public String toString() {
        List<String> formattedRowNames = new ArrayList<>();
        List<String> formattedValues = new ArrayList<>();
        StringBuilder rowNamesSB = new StringBuilder();
        StringBuilder valuesSB = new StringBuilder();

        for (String rowName : dataTypes.keySet()) {
            if (!(rowName.startsWith("\"") && rowName.endsWith("\""))) {
                formattedRowNames.add("\"" + rowName + "\"");
            }
        }

        for (String value : data.values()) {
            if (dataTypes.get(value) == SQLTypes.VARCHAR || dataTypes.get(value) == SQLTypes.DATE) {
                formattedValues.add("\"" + value + "\"");
            } else {
                formattedValues.add(value);
            }
        }

        for (Iterator<String> iterator = formattedRowNames.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            rowNamesSB.append(next);
            if (iterator.hasNext()) { // is not the last item
                rowNamesSB.append(", ");
            }
        }
        
        for (Iterator<String> iterator = formattedValues.iterator(); iterator.hasNext();) {
            String next = iterator.next();
            valuesSB.append(next);
            if (iterator.hasNext()) { // is not the last item
                valuesSB.append(", ");
            }
        }

        return MessageFormat.format(template, schemaName, tableName, rowNamesSB.toString(), valuesSB.toString());
    }
}
