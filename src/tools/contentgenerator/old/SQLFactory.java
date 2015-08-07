/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.contentgenerator.old;

/**
 *
 * @author stjohn
 */
public class SQLFactory {

    public static String getLines(String[] rowNames, int[] types, String[][] values) throws ArrayLengthsNotEqual {
        StringBuilder lines = new StringBuilder();
        for (String[] valueArray : values) {
            SQLLine line = new SQLLine();
            for (int c = 0; c < valueArray.length; c++) {
                if (!validateEntry(rowNames, types, valueArray)) {
                    throw new ArrayLengthsNotEqual();
                }
                line.addValue(rowNames[c], types[c], valueArray[c]);
            }
            lines.append(line.toString()).append("; ");
        }
        return lines.toString();
    }

    public static String getLine(String[] rowNames, int[] types, String[] values) throws ArrayLengthsNotEqual {
        StringBuilder finalLine = new StringBuilder();
        SQLLine line = new SQLLine();
        for (int c = 0; c < values.length; c++) {
            if (!validateEntry(rowNames, types, values)) {
                throw new ArrayLengthsNotEqual();
            }
            line.addValue(rowNames[c], types[c], values[c]);
        }
        finalLine.append(line.toString()).append("; ");
        return finalLine.toString();
    }

    private static boolean validateEntry(String[] rowNames, int[] types, String[] values) {
        return rowNames.length == types.length && types.length == values.length;
    }
}
