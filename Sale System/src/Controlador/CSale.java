package Controlador;

import Modelo.Products;
import Modelo.ProofOfPayment;
import Modelo.Users;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CSale implements ISale{
    @Override    
    public ArrayList <Products> search(JComboBox comboBox, JTextField text, JTable table){
        ArrayList <Products> products = null;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.getDataVector().removeAllElements();
        
        switch(comboBox.getSelectedIndex()){
            case 0: products = (new Products()).getList(2, null, text.getText()); //Nombre
                    model.setColumnIdentifiers(new Object[]{"Nombre","Presentación","Marca","Precio"});
                    for (Products product : products) {
                        model.addRow(new Object[]{product.getName(), product.getPresentation(), product.getBrand(), product.getPrice()});
                    }
                    System.out.println("SALE ESTO");
                    break;
                
            case 1: products = (new Products()).getList(4, null, text.getText()); //Marca
                    model.setColumnIdentifiers(new Object[]{"Nombre","Presentación","Precio","Categoría"});
                    for (Products product : products) {
                        model.addRow(new Object[]{product.getName(), product.getPresentation(), product.getPrice(), product.getCategory()});
                    }
                    break;
                
            case 2: products = (new Products()).getList(5, null, text.getText()); //Categoria
                    model.setColumnIdentifiers(new Object[]{"Nombre","Presentación","Precio","Marca"});
                    for (Products product : products) {
                        model.addRow(new Object[]{product.getName(), product.getPresentation(), product.getPrice(), product.getBrand()});
                    }
                    break;
        }
        
        return products;
    }
    
    @Override
    public double addProduct(JTable table, int index, ArrayList <Products> products, double total){
       
        for(int i = 0;i < table.getRowCount();i++){ 
           if(table.getValueAt(i,0).equals(products.get(index).getCode()))
            {
                table.setRowSelectionInterval(i,i);
                return total;
            }
        }
        
        if(Integer.parseInt(products.get(index).getStock()) >= 1) {
            DefaultTableModel model = (DefaultTableModel) table.getModel();    
            model.addRow(new Object[]{  products.get(index).getCode(),
                                        1,
                                        products.get(index).getName() + " " + products.get(index).getPresentation() + " " + products.get(index).getBrand(),
                                        Double.parseDouble(products.get(index).getPrice()),
                                        Double.parseDouble(products.get(index).getPrice())
                                        });
            total += Double.parseDouble(products.get(index).getPrice());
        } else {
            JOptionPane.showMessageDialog(  null,
                                                "La cantidad supera el stock del producto.",
                                                "Stock Superado",
                                                JOptionPane.WARNING_MESSAGE);
        }
        
        return total;
    }
    
    @Override
    public boolean verifyQuantity(String code, String quantity){
        ArrayList <Products> product = (new Products()).getList(0, code, null);
        return (Integer.parseInt(quantity) <= Integer.parseInt(product.get(0).getStock()));
    }
    
    @Override
    public void safeSale(Users user, JTextField client, JLabel mount, JLabel date, JTable products){
        ProofOfPayment payment = new ProofOfPayment();
        payment.setClientName(client.getText());
        payment.setAmount(mount.getText().substring(3).replace(',', '.'));
        payment.setDate(date.getText().replace('/', '-'));
        payment.setUser(user.getCode());
        
        String error = "";
        error = payment.insertCab();
        
        if(error.equals(""))
            JOptionPane.showMessageDialog(  null, 
                                            "Se ha registrado correctamente la venta.", 
                                            "Venta exitosa", 
                                            JOptionPane.INFORMATION_MESSAGE);
        else
            JOptionPane.showMessageDialog(  null, 
                                            error, 
                                            "Error en la Venta", 
                                            JOptionPane.WARNING_MESSAGE);
    }
}
