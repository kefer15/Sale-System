package Modelo;

import javax.swing.UIManager;
import Controlador.CMain;
import javax.swing.UnsupportedLookAndFeelException;

public class Main
{
    private CMain inicio;
    public static final Conexion conexion = new Conexion("BD_SALE_SYSTEM", "root", "123456");
    
    public Main() {
        inicio = new CMain(0);
    }
    
    public static void main(String [] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        
        Main main = new Main();
    }
}
