package Controlator;

import Interface.ITicket;

import View.UITicket;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

public class CTicket implements ITicket{
     private final UITicket wdWindow;
    
    public CTicket(String strCode, int iOption) {        
        wdWindow = new UITicket(this, strCode, iOption);
    }
    
    @Override
    /** Between this method we close the UITicket  */
    public void close() {
        wdWindow.dispose();
    }
}