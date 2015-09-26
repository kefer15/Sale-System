package salesystem.presentacion.customers;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import salesystem.negocio.Customers;

public class CCustomers
{
    public CCustomers(JTable c)
    {
        DefaultTableModel model = (DefaultTableModel) c.getModel();
        ArrayList<Customers> customer = new Customers().getLista();
        model.setRowCount(0);
        
        for(int i = 0; i < customer.size(); i++)
        {
            model.addRow(new Object[]{
                customer.get(i).getCustomer_id(),
                customer.get(i).getFirst_name(),
                customer.get(i).getMiddle_name(),
                customer.get(i).getLast_name(),
                customer.get(i).getGender(),
                customer.get(i).getEmail(),
                customer.get(i).getPhone(),
                customer.get(i).getAddress(),
                customer.get(i).getOther(),
                customer.get(i).getState()
            });
        }
    }
    
    public void addCustomers()
    {
        CCustomers_Add_Update agregar = new CCustomers_Add_Update(true, "");
    }
    public boolean updateCustomers(JTable registros)
    {
        int i = registros.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) registros.getModel();
        
        if(i != -1)
        {
            CCustomers_Add_Update update;
            if(model.getValueAt(i, 9).equals("A"))
            {
                update = new CCustomers_Add_Update(false, model.getValueAt(i, 0).toString());
                return true;
            }
            else
                JOptionPane.showMessageDialog(null, "Record has been removed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Choose one record to update", "ERROR", JOptionPane.ERROR_MESSAGE);
        
        return false;
    }
    public void removeCustomers(JTable registros)
    {
        int i = registros.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) registros.getModel();
        
        if(i != -1)
        {
            if(!model.getValueAt(i, 9).equals("*"))
            {
                (new Customers()).eliminar(model.getValueAt(i, 0).toString());
                model.setValueAt("*", i, 9);
                JOptionPane.showMessageDialog(null, "Record has been removed successfully", "REMOVE", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "Record has already been removed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Choose one record to remove", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public void autoComplete(JTable registros, JTextField txtCustomer)
    {      
        int h = registros.getRowCount();
        
        DefaultTableModel model = (DefaultTableModel) registros.getModel();
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter( txtCustomer );
        textAutoAcompleter.setMode(0); // infijo
        textAutoAcompleter.setCaseSensitive(false);
        
        for(int i = 0; i < h; i++)
            textAutoAcompleter.addItem((String)model.getValueAt(i,3) + "," + (String)model.getValueAt(i,1));
    }
    public void search(JTable registros, JTextField custSearch)
    {
        try
        {
            String name = custSearch.getText();
            String last_name = name.substring(0, name.indexOf(","));
            String first_name = name.substring(name.indexOf(",")+1, name.length());

            int h = registros.getRowCount();
            DefaultTableModel model = (DefaultTableModel) registros.getModel();
            for(int i = 0; i < h; i++)
            {
                String aux = (String)model.getValueAt(i,3);
                if(aux.equals(last_name))
                {
                    String aux2 = (String)model.getValueAt(i,1);
                    if(aux2.equals(first_name))
                        registros.changeSelection(i, 0, false, false);
                }  
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Customer not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
