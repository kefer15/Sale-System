package Interface;

import Model.Products;
import Model.Users;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface ISale {
    /* Returns all coincidences from a search of a product */
    ArrayList <Products> search(JComboBox cbxCombo, JTextField txtText, JTable tblTable);
    
    /* Returns the new cost from the ticket when a product is added */
    double addProduct(JTable tblTable, int iIndex, ArrayList <Products> aryProducts, double dTotal);
    
    /* Returns true if there's more than an avaliable product in stock */
    String verifyQuantity(String srtCode, String strQuantity);
    
    /* Makes a ticket to print and saves it */
    void safeSale(Users cUser, JTextField txtClient, JLabel lblMount, JLabel lblDate, JTable tblProducts);
}
