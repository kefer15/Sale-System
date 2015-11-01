package Controlator;

import Interface.ITicket;

import View.UITicket;

public class CTicket implements ITicket{
     private final UITicket wdWindow;
    
    public CTicket(String strCode, int iOption) {        
        wdWindow = new UITicket(this, strCode, iOption);
    }
    
    @Override
    public void close() {
        wdWindow.dispose();
    }
}