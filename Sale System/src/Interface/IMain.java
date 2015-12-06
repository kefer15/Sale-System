package Interface;

import java.awt.CardLayout;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

public interface IMain {
    /** Changes the panel at 'Home'
     * @param crdCard
     * @param pnlPanel */
    void changeHome(CardLayout crdCard, JPanel pnlPanel);
    
    /** Changes the panel at 'Users'
     * @param crdCard
     * @param pnlPanel */
    void changeUsers(CardLayout crdCard, JPanel pnlPanel);
    
    /** Changes the panel at 'Suppliers'
     * @param crdCard
     * @param pnlPanel */
    void changeSuppliers(CardLayout crdCard, JPanel pnlPanel);
    
    /** Changes the panel at 'Products'
     * @param crdCard
     * @param pnlPanel */
    void changeProducts(CardLayout crdCard, JPanel pnlPanel);
    
    /** Changes the panel at 'Store'
     * @param crdCard
     * @param pnlPanel */
    void changeStore(CardLayout crdCard, JPanel pnlPanel);
    
    /** Changes the panel at 'Sale'
     * @param crdCard
     * @param pnlPanel */
    void changeSale(CardLayout crdCard, JPanel pnlPanel);
    
    /** Logs the user out */
    void logOut();
    
    /** Opens the menu for forgotten password
     * @param txtUser */
    void forgottenPass(JTextField txtUser);
    
    /** Puts the number of Tickets in 'Sale' menu
     * @param lblNumber */
    void setOrderNumber(JLabel lblNumber);
}