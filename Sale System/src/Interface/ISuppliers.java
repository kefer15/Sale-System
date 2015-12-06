package Interface;

import java.awt.CardLayout;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

public interface ISuppliers {
    /** Changes to submenu 'Agregar Proveedor'
     * @param crdCard
     * @param pnlPanel
     * @param lblTitle
     * @param btnRegister */
    void changeSupplierAdd(CardLayout crdCard, JPanel pnlPanel, JLabel lblTitle, JButton btnRegister);
    
    /** Changes to submenu 'Buscar Proveedor'
     * @param crdCard
     * @param pnlPanel */
    void changeSupplierSearch(CardLayout crdCard, JPanel pnlPanel);
    
    /** Changes to submenu 'Proveedores Registrados'
     * @param crdCard
     * @param pnlPanel
     * @param tblTable */
    void changeSupplierShow(CardLayout crdCard, JPanel pnlPanel, JTable tblTable);
    
    /** Changes to submenu 'Vincular Productos'
     * @param crdCard
     * @param pnlPanel
     * @param tblTable
     * @return  */
    ArrayList <String> changeSupplierLink(CardLayout crdCard, JPanel pnlPanel, JTable tblTable);
    
    /** Adds or modifies a new supplier to the data base
     * @param iOption
     * @param strCode
     * @param txtName
     * @param txtTr
     * @param txtPhone
     * @param txtAddress */
    void actSupplier(int iOption, String strCode, JTextField txtName, JTextField txtTr, JTextField txtPhone, JTextField txtAddress);    
    
    /** Returns all coincidences from a search of a supplier
     * @param txtName
     * @param tblTable
     * @return  */
    ArrayList <String> searchSupplier(JTextField txtName, JTable tblTable);
    
    /** Fills all courts the window needs from a specif supplier
     * @param crdCard
     * @param pnlPanel
     * @param strCode
     * @param lblTitle
     * @param txtName
     * @param txtTr
     * @param txtPhone
     * @param txtAddress
     * @param btnModify
     * @return  */
    String send(CardLayout crdCard, JPanel pnlPanel, String strCode, JLabel lblTitle, JTextField txtName, JTextField txtTr, 
            JTextField txtPhone, JTextField txtAddress, JButton btnModify);
    
    /** Returns all coincidences from a search of a supplier for linking his products
     * @param txtName
     * @param lstList
     * @return  */
    ArrayList <String> searchSupplierLink(JTextField txtName, JList lstList);
    
    /** Links supplier with his products
     * @param aState
     * @param aryProducts
     * @param strSupplier */
    void link(boolean []aState, ArrayList <String> aryProducts, String strSupplier);
    
    /** Show all products linked yet
     * @param strSupplier
     * @param lstListv
     * @param lblLabel */
    void linkedProducts(String strSupplier, JList lstListv, JLabel lblLabel);
}
