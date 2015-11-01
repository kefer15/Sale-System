package Interface;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface IProducts {
    /* Changes to submenu 'Agregar Producto' */
    void changeProductAdd(CardLayout crdCard, JPanel pnlPanel, JComboBox cbxCategory, JLabel lblTitle, JButton btnRegister);
    
    /* Changes to submenu 'Productos Registrados' */
    void changeProductShow(CardLayout crdCard, JPanel pnlPanel, JTable tblProducts);
    
    /* Adds a new product to the data base */
    void actProduct(JTextField txtName, JTextField txtBrand, JTextField txtPresentation, JTextField txtPrice, JTextField txtStock, JComboBox cbxCategory);
}
