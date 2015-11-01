package Interface;

import java.awt.CardLayout;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public interface IMain {
    /* Changes the panel at 'Home' */
    void changeHome(CardLayout crdCard, JPanel pnlPanel);
    
    /* Changes the panel at 'Users' */
    void changeUsers(CardLayout crdCard, JPanel pnlPanel);
    
    /* Changes the panel at 'Suppliers' */
    void changeSuppliers(CardLayout crdCard, JPanel pnlPanel);
    
    /* Changes the panel at 'Products' */
    void changeProducts(CardLayout crdCard, JPanel pnlPanel);
    
    /* Changes the panel at 'Store' */
    void changeStore(CardLayout crdCard, JPanel pnlPanel);
    
    /* Changes the panel at 'Sale' */
    void changeSale(CardLayout crdCard, JPanel pnlPanel);
    
    /* Paints all buttons to color gray */
    void paint(int iNumber, ArrayList <JButton> aryMenu); 
    
    /* Logs the user out */
    void logOut();
    
    /* Opens the menu for forgotten password */
    void forgottenPass(JTextField txtUser);
    
    /* Puts the number of Tickets in 'Sale' menu */
    void setOrderNumber(JLabel lblNumber);
}