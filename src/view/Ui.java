
package view;

import javax.swing.JOptionPane;

public class Ui {

    public static String read(String message) {
        return JOptionPane.showInputDialog(message);
    }

    public static int readNum(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(message));
    }
    
    public static double readNum2(String message) {
        return Double.parseDouble(JOptionPane.showInputDialog(message));
    }

    public static void write(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}
