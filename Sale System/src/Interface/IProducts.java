package Interface;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

public interface IProducts {
    /** Changes to submenu 'Agregar Producto'
     * @param crdCard
     * @param pnlPanel
     * @param cbxCategory
     * @param lblTitle
     * @param btnRegister */
    void changeProductAdd(CardLayout crdCard, JPanel pnlPanel, JComboBox cbxCategory, JLabel lblTitle, JButton btnRegister);
    
    /** Changes to submenu 'Productos Registrados'
     * @param crdCard
     * @param pnlPanel
     * @param tblProducts */
    void changeProductShow(CardLayout crdCard, JPanel pnlPanel, JTable tblProducts);
    
    /** Adds a new product to the data base
     * @param txtName
     * @param txtBrand
     * @param txtPresentation
     * @param txtPrice
     * @param txtStock
     * @param cbxCategory */
    void actProduct(JTextField txtName, JTextField txtBrand, JTextField txtPresentation, JTextField txtPrice, JTextField txtStock, JComboBox cbxCategory);
}
