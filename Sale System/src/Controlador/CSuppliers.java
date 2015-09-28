package Controlador;

import Modelo.Products;
import Modelo.Suppliers;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CSuppliers implements ISuppliers{
    @Override
    public void changeSupplierAdd(CardLayout card, JPanel panel, JLabel title, JButton register){
        card.show(panel, "pnlSupplierAdd");
        
        title.setText("REGISTRO DE NUEVO PROVEEDOR");
        register.setText("Registrar");
    }
    
    @Override
    public void changeSupplierSearch(CardLayout card, JPanel panel){
        card.show(panel, "pnlSupplierSearch");
    }
    
    @Override
    public void changeSupplierShow(CardLayout card, JPanel panel, JTable table){
        card.show(panel, "pnlSupplierShow");
        
        ArrayList <Suppliers> suppliers = (new Suppliers()).getList(0, null, null);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.getDataVector().removeAllElements();
        
        for (Suppliers supplier : suppliers) {
            model.addRow(new Object[]{supplier.getCode(), supplier.getName(), supplier.getTr(), supplier.getPhone(), supplier.getAddress()});
        }
    }
    
    @Override
    public ArrayList <String> changeSupplierLink(CardLayout card, JPanel panel, JTable table){
        card.show(panel, "pnlSupplierLink");
        
        ArrayList <String> productsInd = new ArrayList <>();
        ArrayList <Products> products = (new Products()).getList(3, null, null);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.getDataVector().removeAllElements();
        
        for (Products product : products) {
            model.addRow(new Object[]{false, product.getName() + " "+ product.getBrand()});
            productsInd.add(product.getCode());
        }
        
        return productsInd;
    }
    
    @Override
    public void actSupplier(int option, String code, JTextField name, JTextField tr, JTextField phone, JTextField address){
        Suppliers supplier = new Suppliers();
        
        supplier.setCode(code);
        supplier.setName(name.getText());
        supplier.setTr(tr.getText());
        supplier.setPhone(phone.getText());
        supplier.setAddress(address.getText());
                
        String error = "";
        
        switch(option){
            case 0: supplier.setState("1");
                    supplier.insert();
                    if(error.equals(""))
                        JOptionPane.showMessageDialog(  null, 
                                                        "Los datos han sido ingresados correctamente.", 
                                                        "Nuevo Proveedor",
                                                        JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(  null, 
                                                        error, 
                                                        "Nuevo Proveedor", 
                                                        JOptionPane.WARNING_MESSAGE);
                    break;
            case 1: supplier.update();
                    if(error.equals(""))
                        JOptionPane.showMessageDialog(  null, 
                                                        "Los datos han sido modificados correctamente.", 
                                                        "Modificar Proveedor", 
                                                        JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(  null, 
                                                        error, 
                                                        "Nuevo Proveedor", 
                                                        JOptionPane.WARNING_MESSAGE);
                    break;
        }
    }   
    
    @Override
    public ArrayList <String> searchSupplier(JTextField name, JTable table){
        ArrayList <String> suppliersInd = new ArrayList <>();
        ArrayList <Suppliers> suppliers = (new Suppliers()).getList(2, null, name.getText());
        
        if(!suppliers.isEmpty()) {            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.getDataVector().removeAllElements();
            for (Suppliers supplier : suppliers) {
                model.addRow(new Object[]{supplier.getName(), supplier.getPhone()});
                suppliersInd.add(supplier.getCode());
            }
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No hay proveedores para mostrar.", 
                                            "Resultado Vacío", 
                                            JOptionPane.INFORMATION_MESSAGE);
        
        return suppliersInd;
    }
    
    @Override
    public String sent(CardLayout card, JPanel panel, String code, JLabel title, JTextField name, JTextField tr, 
            JTextField phone, JTextField address, JButton modify){
        card.show(panel, "pnlSupplierAdd");
        ArrayList <Suppliers> supplier = (new Suppliers()).getList(1, code, null);
        
        title.setText("MODIFICACIÓN DE PROVEEDOR");
        modify.setText("Actualizar");
        name.setText(supplier.get(0).getName());
        tr.setText(supplier.get(0).getTr());
        phone.setText(supplier.get(0).getPhone());
        address.setText(supplier.get(0).getAddress());
        
        return supplier.get(0).getCode();
    }
    
    @Override
    public ArrayList <String> searchSupplierLink(JTextField name, JList list){
        ArrayList <String> suppliersInd = new ArrayList <>();
        ArrayList <Suppliers> suppliers = (new Suppliers()).getList(2, null, name.getText());
        
        
        
        if(!suppliers.isEmpty()) {        
            DefaultListModel model = new DefaultListModel();

            for (Suppliers supplier : suppliers) {
                model.addElement(supplier.getName());
                suppliersInd.add(supplier.getCode());
            }
            list.setModel(model);
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No hay proveedores para mostrar.", 
                                            "Resultado Vacío", 
                                            JOptionPane.INFORMATION_MESSAGE);
        
        return suppliersInd;
    }
    
    @Override
    public void link(boolean []state, ArrayList <String> products, String supplier){
        (new Suppliers()).link(state, products, supplier);
        JOptionPane.showMessageDialog(  null,
                                            "La vinculación ha sido exitosa.", 
                                            "Vinculación", 
                                            JOptionPane.INFORMATION_MESSAGE);
    }
}
