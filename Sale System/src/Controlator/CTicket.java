package Controlator;

import Interface.ITicket;
import View.UITicket;

public class CTicket implements ITicket{
     private final UITicket wdWindow;
    
    public CTicket(String strCode) {        
        wdWindow = new UITicket(this, strCode);
    }
    
    @Override
    public void close() {
        wdWindow.dispose();
    }
}