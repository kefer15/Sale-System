package Interface;

import Model.Users;

import com.toedter.calendar.JCalendar;

import java.awt.CardLayout;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

public interface IStore {
    /** Changes to submenu 'Buscar Producto'
     * @param crdCard
     * @param pnlPanel */
    void changeProductSearch(CardLayout crdCard, JPanel pnlPanel);
    
    /** Changes to submenu 'Buscar Boleta'
     * @param crdCard
     * @param pnlPanel */
    void changeTicketSearch(CardLayout crdCard, JPanel pnlPanel);
    
    /** Changes to submenu 'Reporte de Ventas'
     * @param crdCard
     * @param pnlPanel */
    void changeReportSale(CardLayout crdCard, JPanel pnlPanel);
    
    /** Changes to submenu 'Reporte de Inventario'
     * @param crdCard
     * @param pnlPanle
     * @param tblTable */
    void changeInventStore(CardLayout crdCard, JPanel pnlPanle, JTable tblTable);
    
    /** Changes to submenu 'Moficar Producto'
     * @param crdCard
     * @param pnlPanel */
    void changeModify(CardLayout crdCard, JPanel pnlPanel);
            
    /** Returns all coincidences from a search of a product
     * @param txtName
     * @param tblTable
     * @return  */
    ArrayList <String> searchProduct(JTextField txtName, JTable tblTable);
    
    /** Fills all courts the window needs from a specif product
     * @param strCode
     * @param txtName
     * @param txtBrand
     * @param txtPresentation
     * @param txtStock
     * @param cbxCategory
     * @param txtPrice
     * @return  */
    String send(String strCode, JTextField txtName, JTextField txtBrand, JTextField txtPresentation, JTextField txtStock, 
            JComboBox cbxCategory, JTextField txtPrice);
    
    /** Modifies features of a specic product
     * @param strCode
     * @param txtName
     * @param txtBrand
     * @param txtPresentation
     * @param txtStock
     * @param cbxCategory
     * @param txtPrice */
    void actProduct(String strCode, JTextField txtName, JTextField txtBrand, JTextField txtPresentation, JTextField txtStock, 
            JComboBox cbxCategory, JTextField txtPrice);
    
    /** Charges all available products in a table
     * @param tblTable
     * @param cbxCombo */
    void chargeProduct(JTable tblTable, JComboBox cbxCombo);
    
    /** Returns all coincidences from a search of a ticket
     * @param txtNumber
     * @param tblTable
     * @return  */
    ArrayList <String> searchTicket(JTextField txtNumber, JTable tblTable);
    
    /** Makes a product report
     * @param cUser
     * @return  */
    boolean productReport(Users cUser);
    
    /** Comunicates the dates for making the sale report
     * @param cUser
     * @param cldStart
     * @param cldEnd
     * @return  */
    boolean saleReport(Users cUser ,JCalendar cldStart, JCalendar cldEnd);
}
