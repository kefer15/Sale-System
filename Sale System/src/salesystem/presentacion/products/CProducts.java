package salesystem.presentacion.products;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import salesystem.negocio.Product_Categories;
import salesystem.negocio.Products;

public class CProducts implements IProducts{
    ArrayList <Products> products;
    ArrayList <Products> proIndexes;
    ArrayList <Product_Categories> categories;
    ArrayList <String> catIndexes;
    
    public CProducts() {
        products = new ArrayList <> ();
        proIndexes = new ArrayList <> ();
        categories = new ArrayList <> ();
        catIndexes = new ArrayList <> ();
    }
    
    private void head(DefaultTableModel model) {
        model.setRowCount(0);
        model.setColumnCount(0);
        model.addColumn("Id");
        model.addColumn("Parent Id");
        model.addColumn("Name");
        model.addColumn("Price");
        model.addColumn("Color");
        model.addColumn("Size");
        model.addColumn("State");        
    }
    
    @Override
    public void searchCategory(JTextField category, JList catList) {
        categories.clear();
        catIndexes.clear();
        categories = (new Product_Categories ()).getList(0, category.getText(), "NULL");
        
        if(!categories.isEmpty()) {
            DefaultListModel model = new DefaultListModel();
            
            for (Product_Categories categorie : categories) {
                model.addElement(categorie.getProduct_type_description());
                catIndexes.add(categorie.getProduct_type_code());
            }
            
            catList.setModel(model);
        } else
            JOptionPane.showMessageDialog(null,"There is not any coincidence.", "Products", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void searchCategory(JList catList) {
        categories.clear();
        catIndexes.clear();
        categories = (new Product_Categories ()).getList(1, "NULL", "NULL");
        
        if(!categories.isEmpty()) {
            DefaultListModel model = new DefaultListModel();
            
            for (Product_Categories categorie : categories) {
                model.addElement(categorie.getProduct_type_description());
                catIndexes.add(categorie.getProduct_type_code());
            }
            
            catList.setModel(model);
        } else
            JOptionPane.showMessageDialog(null,"There is not data to show.", "Products", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void selectCategory(int indexCategory, JTable proTable) {        
        products.clear();
        proIndexes.clear();
        String category_id = catIndexes.get(indexCategory);
        products = (new Products()).getList(0, category_id, "NULL", "NULL");
        
        if(!products.isEmpty()) {            
            DefaultTableModel model = (DefaultTableModel) proTable.getModel();
            head(model);
            
            for (Products product : products) {
                model.addRow(new Object[]{product.getProduct_id(), product.getParent_product_id(), product.getProduct_name(), product.getProduct_price(), product.getProduct_color(), product.getProduct_size(), product.getRegister_state()});
            }
            
        } else
            JOptionPane.showMessageDialog(null,"There is not any product to show.", "Products", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void searchProduct(JTextField product, JTable proTable) {
        products.clear();
        proIndexes.clear();
        products = (new Products()).getList(1, "NULL", product.getText(), "NULL");
        
        if(!products.isEmpty()) {            
            DefaultTableModel model = (DefaultTableModel) proTable.getModel();
            head(model);
            
            for (Products proSearch : products) {
                model.addRow(new Object[]{proSearch.getProduct_id(), proSearch.getParent_product_id(), proSearch.getProduct_name(), proSearch.getProduct_price(), proSearch.getProduct_color(), proSearch.getProduct_size(), proSearch.getRegister_state()});
            }
            
        } else
            JOptionPane.showMessageDialog(null,"There is not any product to show.", "Products", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void searchProduct(JTable proTable) {
        products.clear();
        proIndexes.clear();
        products = (new Products()).getList(2, "NULL", "NULL", "NULL");
        
        if(!products.isEmpty()) {            
            DefaultTableModel model = (DefaultTableModel) proTable.getModel();
            head(model);
            
            for (Products proSearch : products) {
                model.addRow(new Object[]{proSearch.getProduct_id(), proSearch.getParent_product_id(), proSearch.getProduct_name(), proSearch.getProduct_price(), proSearch.getProduct_color(), proSearch.getProduct_size(), proSearch.getRegister_state()});
            }
            
        } else
            JOptionPane.showMessageDialog(null,"There is not any product to show.", "Products", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void add() {
        CProducts_Add_Update add = new CProducts_Add_Update();
    }
    
    @Override
    public void update(String product_id) {
        CProducts_Add_Update update = new CProducts_Add_Update(product_id);
    }
    
    @Override
    public void remove(int index, JTable proTable) {
        if(String.valueOf(proTable.getValueAt(index, 6)).equals("A")) {
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove the selected record?", "Remove Action", JOptionPane.WARNING_MESSAGE);
        
            if(option == 0) {
                String product_id = String.valueOf(proTable.getValueAt(index, 0));
                (new Products()).remove(product_id);
                proTable.setValueAt("*", index, 6);
            }
        } else
            JOptionPane.showMessageDialog(null, "You can not remove the selected record, because it is deleted already.", "Remove Action", JOptionPane.ERROR_MESSAGE);
    }
}
