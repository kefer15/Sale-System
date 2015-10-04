package Controlador;

import Vista.UITicket;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CTicket implements ITicket{
    UITicket window;
    
    public CTicket(String code){        
        window = new UITicket(this, code);
    }
    
    @Override
    public void close(){
        window.dispose();
    }
}
