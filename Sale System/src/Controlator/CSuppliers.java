package Controlator;

import Interface.ISuppliers;

import Model.Products;
import Model.Suppliers;

import java.awt.CardLayout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
  @version 2.3
  @author Miguel Fernandez
 */

public class CSuppliers implements ISuppliers{
    @Override
    
    /* 
        Between this method we can show the panel for checking a new supplier in 
    */
    public void changeSupplierAdd(CardLayout crdCard, JPanel pnlPanel, JLabel lblTitle, JButton btnRegister) {
        crdCard.show(pnlPanel, "pnlSupplierAdd");        
        lblTitle.setText("REGISTRO DE NUEVO PROVEEDOR");
        btnRegister.setText("Registrar");
    }
    
    @Override
    public void changeSupplierSearch(CardLayout crdCard, JPanel pnlPanel) {
        crdCard.show(pnlPanel, "pnlSupplierSearch");
    }
    
    @Override
    public void changeSupplierShow(CardLayout crdCard, JPanel pnlPanel, JTable tblTable) {
        crdCard.show(pnlPanel, "pnlSupplierShow");
        
        List <Suppliers> arySuppliers = new ArrayList <Suppliers> ();
        arySuppliers = (new Suppliers()).getList(0, null, null);        
        DefaultTableModel cModel = (DefaultTableModel) tblTable.getModel();
        cModel.getDataVector().removeAllElements();
        
        arySuppliers.stream().forEach((cSupplier) -> {
            cModel.addRow(new Object[]{cSupplier.getCode(), cSupplier.getName(), cSupplier.getTr(), cSupplier.getPhone(), cSupplier.getAddress()});
        });
    }
    
    @Override
    public List <String> changeSupplierLink(CardLayout crdCard, JPanel pnlPanel, JTable tblTable) {
        crdCard.show(pnlPanel, "pnlSupplierLink");
                
        List <Products> aryProducts = new ArrayList <Products> ();
        aryProducts = (new Products()).getList(3, null, null);
        List <String> aryProductsIndexes = new ArrayList <String>();
        
        DefaultTableModel cModel = (DefaultTableModel) tblTable.getModel();
        cModel.getDataVector().removeAllElements();
        
        aryProducts.stream().map((cProduct) -> {
            cModel.addRow(new Object[]{false, cProduct.getName() + " "+ cProduct.getBrand() + " " + cProduct.getPresentation()});
            return cProduct;
        }).forEach((cProduct) -> {
            aryProductsIndexes.add(cProduct.getCode());
        });
                
        return aryProductsIndexes;
    }
    
    @Override
    public void linkedProducts(String strSupplier, JList lstList, JLabel lblLabel) {
        List <String> aryProducts = new ArrayList <String> ();
        aryProducts = (new Products()).getProducts(strSupplier);
        DefaultListModel cModel = new DefaultListModel();
        
        if(!aryProducts.isEmpty()){
            aryProducts.stream().forEach((aryProduct) -> {
                cModel.addElement(aryProduct);
            });
            
            lstList.setEnabled(true);
            lblLabel.setEnabled(true);
        }
        
        lstList.setModel(cModel);
    }
    
    @Override
    public void actSupplier(int iOption, String strCode, JTextField txtName, JTextField txtTr, JTextField txtPhone, JTextField txtAddress) {
        Suppliers cSupplier = new Suppliers();
        
        cSupplier.setCode(strCode);
        cSupplier.setName(txtName.getText());
        cSupplier.setTr(txtTr.getText());
        cSupplier.setPhone(txtPhone.getText());
        cSupplier.setAddress(txtAddress.getText());
        
        String strError = "";
        
        switch(iOption){
            case 0: cSupplier.setState("1");
                    strError = cSupplier.insert();
                    if(strError.length() == 0) {
                        JOptionPane.showMessageDialog(  null, 
                                                        "Los datos han sido ingresados correctamente.", 
                                                        "Nuevo Proveedor",
                                                        JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(  null, 
                                                        strError, 
                                                        "Nuevo Proveedor", 
                                                        JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                
            case 1: strError = cSupplier.update();
                    if(strError.length() == 0) {
                        JOptionPane.showMessageDialog(  null, 
                                                        "Los datos han sido modificados correctamente.", 
                                                        "Modificar Proveedor", 
                                                        JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(  null, 
                                                        strError, 
                                                        "Nuevo Proveedor", 
                                                        JOptionPane.WARNING_MESSAGE);
                    }
                    break;
                
            default:    JOptionPane.showMessageDialog(null, "Default Option");
                        break;
        }
    }   
    
    @Override
    public List <String> searchSupplier(JTextField txtName, JTable tblTable) {
        String strName = txtName.getText();
        
        if("Ingrese Nombre de Proveedor".equals(txtName.getText())) {
            strName = "";
        }
        
        List <Suppliers> arySuppliers = new ArrayList <Suppliers> ();
        arySuppliers = (new Suppliers()).getList(2, null, strName);
        List <String> arySuppliersIndexes = new ArrayList <String>();
        
        if(!arySuppliers.isEmpty()) {            
            DefaultTableModel cModel = (DefaultTableModel) tblTable.getModel();
            cModel.getDataVector().removeAllElements();
            
            arySuppliers.stream().map((cSupplier) -> {
                cModel.addRow(new Object[]{cSupplier.getName(), cSupplier.getPhone()});
                return cSupplier;
            }).forEach((cSupplier) -> {
                arySuppliersIndexes.add(cSupplier.getCode());
            });
        } else {
            JOptionPane.showMessageDialog(  null,
                                            "No hay proveedores para mostrar.", 
                                            "Resultado Vacío", 
                                            JOptionPane.INFORMATION_MESSAGE);
        }
        
        return arySuppliersIndexes;
    }
    
    @Override
    public String send(CardLayout crdCard, JPanel pnlPanel, String strCode, JLabel lblTitle, JTextField txtName, JTextField txtTr, 
            JTextField txtPhone, JTextField txtAddress, JButton btnModify) {
        crdCard.show(pnlPanel, "pnlSupplierAdd");
        lblTitle.setText("MODIFICACIÓN DE PROVEEDOR");
        btnModify.setText("Actualizar");
        
        List <Suppliers> arySupplier = new ArrayList <Suppliers> ();
        arySupplier = (new Suppliers()).getList(1, strCode, null);
        
        txtName.setText(arySupplier.get(0).getName());
        txtTr.setText(arySupplier.get(0).getTr());
        txtPhone.setText(arySupplier.get(0).getPhone());
        txtAddress.setText(arySupplier.get(0).getAddress());
        
        return arySupplier.get(0).getCode();
    }
    
    @Override
    public List <String> searchSupplierLink(JTextField txtName, JList lstList){
        String strName = txtName.getText();
        
        if("Ingrese Nombre de Proveedor".equals(txtName.getText())) {
            strName = "";
        }
        
        List <Suppliers> arySuppliers = new ArrayList <Suppliers> ();
        arySuppliers = (new Suppliers()).getList(2, null, strName);
        List <String> arySuppliersIndexes = new ArrayList <String>();
        
        if(!arySuppliers.isEmpty()) {        
            DefaultListModel cModel = new DefaultListModel();

            arySuppliers.stream().map((cSupplier) -> {
                cModel.addElement(cSupplier.getName());
                return cSupplier;
            }).forEach((cSupplier) -> {
                arySuppliersIndexes.add(cSupplier.getCode());
            });
            lstList.setModel(cModel);
        } else {
            JOptionPane.showMessageDialog(  null,
                                            "No hay proveedores para mostrar.", 
                                            "Resultado Vacío", 
                                            JOptionPane.INFORMATION_MESSAGE);
        }
        
        return arySuppliersIndexes;
    }
    
    @Override
    public void link(boolean []aState, List <String> aryProducts, String strSupplier){
        String strError = (new Suppliers()).link(aState, (ArrayList<String>) aryProducts, strSupplier);
        if(strError.isEmpty()) {
            JOptionPane.showMessageDialog(  null,
                                            "La vinculación ha sido exitosa.", 
                                            "Vinculación", 
                                            JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(  null,
                                            "Item previamente vinculado.", 
                                            "Vinculación", 
                                            JOptionPane.INFORMATION_MESSAGE);
        }
    }
}