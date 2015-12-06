package Interface;

import Model.Products;
import Model.Users;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

public interface ISale {
    /** Returns all coincidences from a search of a product
     * @param cbxCombo
     * @param txtText
     * @param tblTable
     * @return  */
    ArrayList <Products> search(JComboBox cbxCombo, JTextField txtText, JTable tblTable);
    
    /** Returns the new cost from the ticket when a product is added
     * @param tblTable
     * @param iIndex
     * @param aryProducts
     * @param dTotal
     * @return  */
    double addProduct(JTable tblTable, int iIndex, ArrayList <Products> aryProducts, double dTotal);
    
    /** Returns true if there's more than an avaliable product in stock
     * @param srtCode
     * @param strQuantity
     * @return  */
    String verifyQuantity(String srtCode, String strQuantity);
    
    /** Makes a ticket to print and saves it
     * @param cUser
     * @param txtClient
     * @param lblMount
     * @param lblDate
     * @param tblProducts */
    void safeSale(Users cUser, JTextField txtClient, JLabel lblMount, JLabel lblDate, JTable tblProducts);
}
