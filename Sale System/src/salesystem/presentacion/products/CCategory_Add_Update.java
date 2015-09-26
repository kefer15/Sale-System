package salesystem.presentacion.products;

import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import salesystem.negocio.Product_Categories;
import salesystem.presentacion.CMain;

public class CCategory_Add_Update implements ICategory_Add_Update
{
    private UICategory_Add_Update ventana;
    private boolean add_update; // TRUE Add, FALSE Update
    private String id;
    
    public CCategory_Add_Update(boolean add_update, String id)
    {
        this.add_update = add_update;
        this.id = id;
        ventana = new UICategory_Add_Update(this);
    }
    
    public void cancel()
    {
        CMain principal = new CMain(8);
        ventana.dispose();
    }
    
    public void done(JTextField description, JSpinner vat)
    {
        if(add_update)
            insertar(description, vat);
        else
            modificar(description, vat);
    }
    
    private void insertar(JTextField description, JSpinner vat)
    {
        Product_Categories c = new Product_Categories("", description.getText(), String.valueOf((Double.parseDouble(vat.getValue().toString())/100.0)), "A");
        String err = c.insertar();
        if(err.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Record has been added successfully", "ADD", JOptionPane.INFORMATION_MESSAGE);
            CMain principal = new CMain(8);
            ventana.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, err, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    private void modificar(JTextField description, JSpinner vat)
    {
        Product_Categories c = new Product_Categories("", description.getText(), String.valueOf((Double.parseDouble(vat.getValue().toString())/100.0)), "A");
        String err = c.modificar(id);
        if(err.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Record has been updated successfully", "UPDATE", JOptionPane.INFORMATION_MESSAGE);
            CMain principal = new CMain(8);
            ventana.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, err, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public void cargar(JTextField description, JSpinner vat)
    {
        if(!add_update)
        {
            Product_Categories c = new Product_Categories();
            c.buscar(id);
            description.setText(c.getProduct_type_description());
            vat.setValue(Double.parseDouble(c.getVat_rating())*100.0);
        }
    }
}
