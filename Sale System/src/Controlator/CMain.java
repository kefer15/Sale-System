package Controlator;

import Interface.IMain;

import Model.ProofOfPayment;

import View.UIMain;

import java.awt.CardLayout;
import java.text.DecimalFormat;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CMain implements IMain {
    private final UIMain wdWindow;
    
    /*
        Constructor that recieves the number of the widow to active in UIMain
        @param  iWindowNumber    Indicates the number of the window
    */
    public CMain(int iWindowNumber) {
        wdWindow = new UIMain(this, iWindowNumber);
    }
    
    @Override
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
    public void paint(int iNumber, ArrayList <JButton> aryMenu) {
        // Depends if client likes or not 
        /*
            for (JButton cButton : aryMenu)
            {
                cButton.setBackground(new Color(224, 224, 224));
                cButton.setForeground(new Color(0, 0, 0));
            }

            aryMenu.get(iNumber).setBackground(new Color(170, 170, 170));
            aryMenu.get(iNumber).setForeground(new Color(255, 255, 255));
        */
    }
    
    @Override
    public void logOut() {
        wdWindow.dispose();
        CMain cMain = new CMain(0);
    }
    
    @Override
    public void forgottenPass(JTextField txtUser) {
        wdWindow.dispose();
        CForgottenPass cPass = new CForgottenPass(txtUser.getText());    
    }    
    
    @Override
    public void setOrderNumber(JLabel lblNumber) {
        String strCode = (new ProofOfPayment()).getNextCode();
        DecimalFormat cFormat = new DecimalFormat("00000000000");            
        lblNumber.setText("N° " + String.valueOf(cFormat.format(Integer.parseInt(strCode)+1)));
    }
}