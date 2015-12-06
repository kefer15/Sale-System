package Controlator;

import Interface.IProducts;

import Model.Category;
import Model.Products;

import java.awt.CardLayout;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

public class CProducts implements IProducts {
    private ArrayList <Category> aryCategories = new ArrayList <Category> ();
    private ArrayList <String> aryCategoriesIndexes = new ArrayList <String> ();
    
    /*
        The constructor fills aryCategories with all Categorigies available.
        Initializes aryCategoriesIndexes.
    */
    public CProducts() {
        aryCategories = (new Category()).getList();
        aryCategoriesIndexes = new ArrayList <> ();
    }
    
    /*
        Fills all Categories into cbxCategory and links the information of each register with 
        each index of aryCategoriesIndexes.
    */
    private void fill(JComboBox cbxCategory) {
        aryCategories.stream().map((cGender) -> {
            cbxCategory.addItem(cGender.getDescription());
            return cGender;
        }).forEach((cGender) -> {
            aryCategoriesIndexes.add(cGender.getCode());
        });
    }
    
    @Override
    /** Between this method we can show the panel that receives products information */
    public void changeProductAdd(CardLayout crdCard, JPanel pnlPanel, JComboBox cbxCategory, JLabel lblTitle, JButton btnRegister) {
        crdCard.show(pnlPanel, "pnlProductAdd");
        
        lblTitle.setText("REGISTRO DE NUEVO PRODUCTO");
        btnRegister.setText("Registrar");
        
        cbxCategory.removeAllItems();       
        fill(cbxCategory);        
    }
    
    @Override
    public void changeProductShow(CardLayout crdCard, JPanel pnlPanel, JTable tblProducts) {
        crdCard.show(pnlPanel, "pnlProductShow");
        
        ArrayList <Products> aryProducts = new ArrayList <Products> ();
        aryProducts = (new Products()).getList(1, null, null);        
        DefaultTableModel cModel = (DefaultTableModel) tblProducts.getModel();
        cModel.getDataVector().removeAllElements();
        
        aryProducts.stream().forEach((cProduct) -> {
            cModel.addRow(new Object[]{cProduct.getName(), cProduct.getBrand(), cProduct.getPresentation(), cProduct.getCategory()});
        });
    }
    
    @Override
    public void actProduct(JTextField txtName, JTextField txtBrand, JTextField txtPresentation, JTextField txtPrice, JTextField txtStock, JComboBox cbxCategory) {
        Products cProduct = new Products();
        
        cProduct.setName(txtName.getText());
        cProduct.setBrand(txtBrand.getText());
        cProduct.setPresentation(txtPresentation.getText());
        cProduct.setPrice(txtPrice.getText());
        cProduct.setStock(txtStock.getText());
        cProduct.setCategory(aryCategoriesIndexes.get(cbxCategory.getSelectedIndex()));
        cProduct.setState("1");
        
        String srtError = cProduct.insert();
        
        if("".equals(srtError)) {
            JOptionPane.showMessageDialog(  null, 
                                            "Los datos han sido ingresados correctamente.", 
                                            "Nuevo Producto", 
                                            JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(  null, 
                                            srtError, 
                                            "Nuevo Producto", 
                                            JOptionPane.WARNING_MESSAGE);
        }
    }
}