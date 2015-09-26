package salesystem.presentacion.products;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import salesystem.negocio.Measures;
import salesystem.negocio.Product_Categories;
import salesystem.negocio.Products;
import salesystem.presentacion.CMain;

public class CProducts_Add_Update implements IProducts_Add_Update {
    private boolean window; 
    private UIProducts_Add_Update UIProducts;    
    private ArrayList <Product_Categories> categories;
    private ArrayList <String> catIndexes;
    private ArrayList <Products> parents;
    private ArrayList <String> parIndexes;
    private ArrayList <Measures> measures;
    private ArrayList <String> meaIndexes;
    
    public CProducts_Add_Update() {
        this.UIProducts = new UIProducts_Add_Update(this);
        inicializate();
        this.window = true;
    }
    
    public CProducts_Add_Update(String product_id) {
        this.UIProducts = new UIProducts_Add_Update(this, product_id);
        inicializate();
        this.window = false;
    }
    
    private void inicializate() {
        categories = new ArrayList <> ();
        catIndexes = new ArrayList <> ();
        parents = new ArrayList <> ();
        parIndexes = new ArrayList <> ();
        measures = new ArrayList <> ();
        meaIndexes = new ArrayList <> ();
    }
    
    @Override
    public void inicializateMeasures(JComboBox cbxMeasure) {
        measures = (new Measures()).getList(0, "NULL");
        
        if(!measures.isEmpty()) {
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            
             for(int i = 0;i < measures.size(); i++){
                model.addElement(measures.get(i).getMeasure_description());
                meaIndexes.add(measures.get(i).getMeasure_id());
            }
            
            cbxMeasure.setModel(model);
        } else
            JOptionPane.showMessageDialog(null,"There is not Measure data to show.", "Products", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void searchCategory(JTextField category, JList catList) {
        categories.clear();
        catIndexes.clear();
        categories = (new Product_Categories()).getList(0, category.getText(), "NULL");
        
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
        categories = (new Product_Categories()).getList(1, "NULL", "NULL");
        
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
    public void searchParent(JTextField parent, JList catList) {
        parents.clear();
        parIndexes.clear();
        parents = (new Products()).getList(1, "NULL", parent.getText(), "NULL");
        
        if(!parents.isEmpty()) {
            DefaultListModel model = new DefaultListModel();
            
            for (Products product : parents) {
                model.addElement(product.getProduct_name());
                parIndexes.add(product.getProduct_id());
            }
            
            catList.setModel(model);
        } else
            JOptionPane.showMessageDialog(null,"There is not any coincidence.", "Products", JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public void searchParent(JList catList) {
        parents.clear();
        parIndexes.clear();
        parents = (new Products()).getList(2, "NULL", "NULL", "NULL");
        
        if(!parents.isEmpty()) {
            DefaultListModel model = new DefaultListModel();
            
            for (Products product : parents) {
                model.addElement(product.getProduct_name());
                parIndexes.add(product.getProduct_id());
            }
            
            catList.setModel(model);
        } else
            JOptionPane.showMessageDialog(null,"There is not data to show.", "Products", JOptionPane.INFORMATION_MESSAGE);
    }
       
    @Override
    public void fill(String product_id, JList lisParent, JTextField txtParent, JList lisCategory, 
            JTextField txtCategory, JTextField txtName, JTextField txtPrice, JTextField txtColor, 
            JTextField txtSize, JComboBox cbxMeasure, JTextArea txtDescription, JTextArea txtOther) {
        
        Products product = (new Products()).getList(3, "NULL", "NULL", product_id).get(0);
        Products parent = (new Products()).getList(3, "NULL", "NULL", product.getParent_product_id()).get(0);
        Product_Categories category = (new Product_Categories()).getList(2, "NULL", product.getProduct_type_code()).get(0);
        Measures measure = (new Measures()).getList(1, product.getMeasure_id()).get(0);
        
        parents = (new Products()).getList(2, "NULL", "NULL", "NULL");
        categories = (new Product_Categories()).getList(1, "NULL", "NULL");
        measures = (new Measures()).getList(0, "NULL");
        
        if(!parent.getRegister_state().equals("A")) 
            JOptionPane.showMessageDialog(null, "You have to change the Parent Product Value.", "Products", JOptionPane.WARNING_MESSAGE);

        if(!category.getRegister_state().equals("A")) 
            JOptionPane.showMessageDialog(null, "You have to change the Category Value.", "Products", JOptionPane.WARNING_MESSAGE);
                
        if(!measure.getRegister_state().equals("A")) 
            JOptionPane.showMessageDialog(null, "You have to change the Unit Measure Value.", "Products", JOptionPane.WARNING_MESSAGE);
        
        DefaultListModel modelParent = new DefaultListModel();
        for (Products parent1 : parents) {
            modelParent.addElement(parent1.getProduct_name());
            parIndexes.add(parent1.getProduct_id());
        }
        lisParent.setModel(modelParent);
        lisParent.setSelectedIndex(parIndexes.indexOf(parent.getProduct_id()));
        
        
        DefaultListModel modelCategory = new DefaultListModel();
        for (Product_Categories categorie : categories) {
            modelCategory.addElement(categorie.getProduct_type_description());
            catIndexes.add(categorie.getProduct_type_code());
        }
        lisCategory.setModel(modelCategory);
        lisCategory.setSelectedIndex(catIndexes.indexOf(category.getProduct_type_code()));
        
        DefaultComboBoxModel modelMeasure = new DefaultComboBoxModel();
        for (Measures measure1 : measures) {
            modelMeasure.addElement(measure1.getMeasure_description());
            meaIndexes.add(measure1.getMeasure_id());
        }
        cbxMeasure.setModel(modelMeasure);
        cbxMeasure.setSelectedIndex(meaIndexes.indexOf(measure.getMeasure_id()));
        
        txtName.setText(product.getProduct_name());
        txtParent.setText(parent.getProduct_name());
        txtCategory.setText(category.getProduct_type_description());
        txtPrice.setText(product.getProduct_price());
        txtColor.setText(product.getProduct_color());
        txtSize.setText(product.getProduct_size());
        txtDescription.setText(product.getProduct_description());
        txtOther.setText(product.getOther_product_details());
    }
    
    @Override
    public void done(String product_id, int indexParent, int indexCategory, JTextField txtName, JTextField txtPrice, JTextField txtColor,
                JTextField txtSize, int indexMeasure, JTextArea txtDescription, JTextArea txtOther) {
        Products product = new Products();
        product.setParent_product_id(parIndexes.get(indexParent));
        product.setProduct_type_code(catIndexes.get(indexCategory));
        product.setProduct_name(txtName.getText());
        product.setProduct_price(txtPrice.getText());
        product.setProduct_color(txtColor.getText());
        product.setProduct_size(txtSize.getText());
        product.setMeasure_id(meaIndexes.get(indexMeasure));
        product.setProduct_description(txtDescription.getText());
        product.setOther_product_details(txtOther.getText());
        
        if(window) {
            String err = product.insert();
            
            if(err.equals(""))
                JOptionPane.showMessageDialog(null, "Data has been inserted correctly.", "Products", JOptionPane.INFORMATION_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, err, "Products", JOptionPane.WARNING_MESSAGE);
        } else {
            product.setProduct_id(product_id);
            String err = product.update();
            
            if(err.equals("")) {
                JOptionPane.showMessageDialog(null, "Data has been modified correctly.", "Products", JOptionPane.INFORMATION_MESSAGE);
                CMain main = new CMain(0);
                UIProducts.dispose();
            }
            else
                JOptionPane.showMessageDialog(null, err, "Products", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    @Override
    public void cancel() {
        CMain main = new CMain(0);
        UIProducts.dispose();
    }
}
