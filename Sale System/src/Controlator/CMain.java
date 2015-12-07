package Controlator;

import Interface.IMain;

import Model.ProofOfPayment;

import View.UIMain;

import java.awt.CardLayout;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
  @version 2.3
  @author Miguel Fernández
 */

public class CMain implements IMain {
    private final UIMain WDWINDOW;
    
    /*
        Constructor that recieves the number of the widow to active in UIMain
        @param  iWindowNumber    Indicates the number of the window
    */
    public CMain(int iWindowNumber) {
        WDWINDOW = new UIMain(this, iWindowNumber);
    }
    
    @Override
    
    /** 
        Between this method we can move for all windows, basically Home Window 
    */
    public void changeHome(CardLayout crdCard, JPanel pnlPanel) {
        crdCard.show(pnlPanel, "pnlHome");
    }
    
    @Override
    public void changeUsers(CardLayout crdCard, JPanel pnlPanel) {
        crdCard.show(pnlPanel, "pnlUsers");
    }
    
    @Override
    public void changeSuppliers(CardLayout crdCard, JPanel pnlPanel) {
        crdCard.show(pnlPanel, "pnlSuppliers");
    }
    
    @Override
    public void changeProducts(CardLayout crdCard, JPanel pnlPanel) {
        crdCard.show(pnlPanel, "pnlProducts");
    }
    
    @Override
    public void changeStore(CardLayout crdCard, JPanel pnlPanel) {
        crdCard.show(pnlPanel, "pnlStore");
    }
    
    @Override
    public void changeSale(CardLayout crdCard, JPanel pnlPanel) {
        crdCard.show(pnlPanel, "pnlSale");
    }
   
    @Override
    public void logOut() {
        WDWINDOW.dispose();
        new CMain(0);
    }
    
    @Override
    public void forgottenPass(JTextField txtUser) {
        WDWINDOW.dispose();
        new CForgottenPass(txtUser.getText());    
    }    
    
    @Override
    public void setOrderNumber(JLabel lblNumber) {
        String strCode = (new ProofOfPayment()).getNextCode();
        DecimalFormat cFormat = new DecimalFormat("00000000000");            
        StringBuilder strValue = new StringBuilder();
        strValue.append("N° ");
        strValue.append(String.valueOf(cFormat.format(Integer.parseInt(strCode)+1)));
        
        lblNumber.setText(String.valueOf(strValue));
    }
}