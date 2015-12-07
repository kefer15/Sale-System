package Model;

import Controlator.CMain;

import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;

/**
  @version 2.3
  @author Miguel Fernandez
 */

public class Principal {
    
    /**
        Here starts running the application
    */
    public static final Conexion CONECCTION = new Conexion("BD_SALE_SYSTEM", "root", "123456");
    
    private Principal() {
        new CMain(0);
    }
    
    /** Between this method starts the application
     * @param strArgs */
    public static void main(String [] strArgs) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(null, "There's a mistake. Be sure you have the correct JTatoo Library");
        }
        
        new Principal();
    }
}