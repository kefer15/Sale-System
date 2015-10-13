package Controlator;

import Interface.ISale;
import Model.Products;
import Model.ProofOfPayment;
import Model.Users;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CSale implements ISale {
    @Override    
    public ArrayList <Products> search(JComboBox cbxCombo, JTextField txtText, JTable tblTable) {
        ArrayList <Products> aryProducts = null;
        
        DefaultTableModel cModel = (DefaultTableModel) tblTable.getModel();
        cModel.getDataVector().removeAllElements();
        
        switch(cbxCombo.getSelectedIndex()) {
            case 0: aryProducts = (new Products()).getList(2, null, txtText.getText());
                    cModel.setColumnIdentifiers(new Object[]{"Nombre","Presentación","Marca","Precio"});
                    
                    for (Products product : aryProducts) {
                        cModel.addRow(new Object[]{product.getName(), product.getPresentation(), product.getBrand(), product.getPrice()});
                    }
                    
                    break;
                
            case 1: aryProducts = (new Products()).getList(4, null, txtText.getText());
                    cModel.setColumnIdentifiers(new Object[]{"Nombre","Presentación","Precio","Categoría"});
                    
                    for (Products product : aryProducts) {
                        cModel.addRow(new Object[]{product.getName(), product.getPresentation(), product.getPrice(), product.getCategory()});
                    }
                    
                    break;
                
            case 2: aryProducts = (new Products()).getList(5, null, txtText.getText());
                    cModel.setColumnIdentifiers(new Object[]{"Nombre","Presentación","Precio","Marca"});
                    
                    for (Products product : aryProducts) {
                        cModel.addRow(new Object[]{product.getName(), product.getPresentation(), product.getPrice(), product.getBrand()});
                    }
                    
                    break;
        }
        
        return aryProducts;
    }
    
    @Override
    public double addProduct(JTable tblTable, int iIndex, ArrayList <Products> aryProducts, double dTotal) {
       
        for(int i = 0;i < tblTable.getRowCount();i++) { 
           if(tblTable.getValueAt(i,0).equals(aryProducts.get(iIndex).getCode())) {
                tblTable.setRowSelectionInterval(i,i);
                return dTotal;
            }
        }
        
        if(Integer.parseInt(aryProducts.get(iIndex).getStock()) >= 1) {
            DefaultTableModel cModel = (DefaultTableModel) tblTable.getModel();
            
            cModel.addRow(new Object[]{  aryProducts.get(iIndex).getCode(),
                                        1,
                                        aryProducts.get(iIndex).getName() + " " + aryProducts.get(iIndex).getPresentation() + " " + aryProducts.get(iIndex).getBrand(),
                                        Double.parseDouble(aryProducts.get(iIndex).getPrice()),
                                        Double.parseDouble(aryProducts.get(iIndex).getPrice())
                                        });
            
            dTotal += Double.parseDouble(aryProducts.get(iIndex).getPrice());
        } else {
            JOptionPane.showMessageDialog(  null,
                                            "La cantidad supera el stock del producto.",
                                            "Stock Superado",
                                            JOptionPane.WARNING_MESSAGE);
        }
        
        return dTotal;
    }
    
    @Override
    public boolean verifyQuantity(String srtCode, String strQuantity) {
        ArrayList <Products> aryProduct = (new Products()).getList(0, srtCode, null);
        
        return (Integer.parseInt(strQuantity) <= Integer.parseInt(aryProduct.get(0).getStock()));
    }
    
    @Override
    public void safeSale(Users cUser, JTextField txtClient, JLabel lblMount, JLabel lblDate, JTable tblProducts) {
        ProofOfPayment payment = new ProofOfPayment();
        
        payment.setClientName(txtClient.getText());
        payment.setAmount(lblMount.getText().substring(3).replace(',', '.'));
        payment.setDate(lblDate.getText().replace('/', '-'));
        payment.setUser(cUser.getCode());
        
        String error = payment.insertCab();
        
        if(error.equals("")) {            
            /* Here has to be payment.insertDet */ 
            
            JOptionPane.showMessageDialog(  null, 
                                            "Se ha registrado correctamente la venta.", 
                                            "Venta exitosa", 
                                            JOptionPane.INFORMATION_MESSAGE);
            
        } else
            JOptionPane.showMessageDialog(  null, 
                                            error, 
                                            "Error en la Venta", 
                                            JOptionPane.WARNING_MESSAGE);
    }
}