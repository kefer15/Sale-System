package Controlador;

import Modelo.Category;
import Modelo.Products;
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

public class CProducts implements IProducts{
    private ArrayList <Category> categories;
    private ArrayList <String> categoriesInd;
    
    public CProducts(){
        categories = (new Category()).getList();
        categoriesInd = new ArrayList <> ();
    }
    
    private void fill(JComboBox category){
        for (Category genderAux : categories) {
            category.addItem(genderAux.getDescription());
            categoriesInd.add(genderAux.getCode());
        }
    }
    
    @Override
    public void changeProductAdd(CardLayout card, JPanel panel, JComboBox category, JLabel title, JButton register){
        card.show(panel, "pnlProductAdd");
        
        title.setText("REGISTRO DE NUEVO PRODUCTO");
        register.setText("Registrar");
        
        category.removeAllItems();
       
        fill(category);        
    }
    
    @Override
    public void changeProductShow(CardLayout card, JPanel panel, JTable table){
        card.show(panel, "pnlProductShow");
        
        ArrayList <Products> products = (new Products()).getList(1, null, null);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.getDataVector().removeAllElements();
        
        for (Products product : products) {
            model.addRow(new Object[]{product.getName(), product.getBrand(), product.getPresentation(), product.getCategory()});
        }
    }
    
    @Override
    public void actProduct(JTextField name, JTextField brand, JTextField presentation, JTextField price, JTextField stock, JComboBox category){
        Products product = new Products();
        
        product.setName(name.getText());
        product.setBrand(brand.getText());
        product.setPresentation(presentation.getText());
        product.setPrice(price.getText());
        product.setCategory(categoriesInd.get(category.getSelectedIndex()));
        product.setState("1");
        
        String error = "";
        
        product.insert();
        if(error.equals(""))
            JOptionPane.showMessageDialog(  null, 
                                            "Los datos han sido ingresados correctamente.", 
                                            "Nuevo Producto", 
                                            JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(  null, 
                                            error, 
                                            "Nuevo Producto", 
                                            JOptionPane.WARNING_MESSAGE);
    }
}
