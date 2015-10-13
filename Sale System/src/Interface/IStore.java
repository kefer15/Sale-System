package Interface;

import Model.Users;
import com.toedter.calendar.JCalendar;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface IStore {
    /* Changes to submenu 'Buscar Producto' */
    void changeProductSearch(CardLayout crdCard, JPanel pnlPanel);
    
    /* Changes to submenu 'Buscar Boleta' */
    void changeTicketSearch(CardLayout crdCard, JPanel pnlPanel);
    
    /* Changes to submenu 'Reporte de Ventas' */
    void changeReportSale(CardLayout crdCard, JPanel pnlPanel);
    
    /* Changes to submenu 'Reporte de Inventario' */
    void changeInventStore(CardLayout crdCard, JPanel pnlPanle, JTable tblTable);
    
    /* Changes to submenu 'Moficar Producto' */
    void changeModify(CardLayout crdCard, JPanel pnlPanel);
            
    /* Returns all coincidences from a search of a product */
    ArrayList <String> searchProduct(JTextField txtName, JTable tblTable);
    
    /* Fills all courts the window needs from a specif product */
    String send(String strCode, JTextField txtName, JTextField txtBrand, JTextField txtPresentation, JTextField txtStock, 
            JComboBox cbxCategory, JTextField txtPrice);
    
    /* Modifies features of a specic product */
    void actProduct(String strCode, JTextField txtName, JTextField txtBrand, JTextField txtPresentation, JTextField txtStock, 
            JComboBox cbxCategory, JTextField txtPrice);
    
    /* Charges all available products in a table */
    void chargeProduct(JTable tblTable, JComboBox cbxCombo);
    
    /* Returns all coincidences from a search of a ticket */
    ArrayList <String> searchTicket(JTextField txtNumber, JTable tblTable);
    
    /* Makes a product report */
    boolean productReport(Users cUser);
    
    /* Comunicates the dates for making the sale report */
    boolean saleReport(Users cUser ,JCalendar cldStart, JCalendar cldEnd);
}
