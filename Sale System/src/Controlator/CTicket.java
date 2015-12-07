package Controlator;

import Interface.ITicket;

import View.UITicket;

/**
  @version 2.3
  @author Miguel Fernandez
 */

public class CTicket implements ITicket{
     private final UITicket window;
    
    public CTicket(String strCode, int iOption) {        
        window = new UITicket(this, strCode, iOption);
    }
    
    @Override
    
    /* 
        Between this method we close the UITicket  
    */
    public void close() {
        window.dispose();
    }
}