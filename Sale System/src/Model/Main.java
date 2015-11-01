package Model;

import Controlator.CMain;

import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager;


public class Main
{
    private final CMain cInicio;
    public static final Conexion cConexion = new Conexion("BD_SALE_SYSTEM", "root", "123456");
    
    public Main() {
        cInicio = new CMain(0);
    }
    
    public static void main(String [] strArgs) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        
        Main cMain = new Main();
    }
}