package Interface;

import java.awt.CardLayout;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface ISuppliers {
    /* Changes to submenu 'Agregar Proveedor' */
    void changeSupplierAdd(CardLayout crdCard, JPanel pnlPanel, JLabel lblTitle, JButton btnRegister);
    
    /* Changes to submenu 'Buscar Proveedor' */
    void changeSupplierSearch(CardLayout crdCard, JPanel pnlPanel);
    
    /* Changes to submenu 'Proveedores Registrados' */
    void changeSupplierShow(CardLayout crdCard, JPanel pnlPanel, JTable tblTable);
    
    /* Changes to submenu 'Vincular Productos' */
    ArrayList <String> changeSupplierLink(CardLayout crdCard, JPanel pnlPanel, JTable tblTable);
    
    /* Adds or modifies a new supplier to the data base */
    void actSupplier(int iOption, String strCode, JTextField txtName, JTextField txtTr, JTextField txtPhone, JTextField txtAddress);    
    
    /* Returns all coincidences from a search of a supplier */
    ArrayList <String> searchSupplier(JTextField txtName, JTable tblTable);
    
    /* Fills all courts the window needs from a specif supplier */
    String send(CardLayout crdCard, JPanel pnlPanel, String strCode, JLabel lblTitle, JTextField txtName, JTextField txtTr, 
            JTextField txtPhone, JTextField txtAddress, JButton btnModify);
    
    /* Returns all coincidences from a search of a supplier for linking his products */
    ArrayList <String> searchSupplierLink(JTextField txtName, JList lstList);
    
    /* Links supplier with his products */
    void link(boolean []aState, ArrayList <String> aryProducts, String strSupplier);
    
    /* Show all products linked yet */
    void linkedProducts(String strSupplier, JList lstListv, JLabel lblLabel);
}
