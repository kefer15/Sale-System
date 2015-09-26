package salesystem.presentacion.invoices;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import salesystem.negocio.Customers;
import salesystem.negocio.Invoice_Line_Items;
import salesystem.negocio.Invoices;
import salesystem.negocio.Orders;

public class CInvoices
{
    
    public CInvoices(JTable registros, JTable orders , JTable order_details, JList customers)
    {        
        DefaultTableModel model = (DefaultTableModel) registros.getModel();
        ArrayList<Invoices> invoice = new Invoices().getList();
        model.setRowCount(0);
        
        for(int i = 0; i < invoice.size(); i++)
        {
            model.addRow(new Object[]{
                invoice.get(i).getInvoice_number(),
                invoice.get(i).getOrder_id(),
                invoice.get(i).getInvoice_date(),
                invoice.get(i).getInvoice_details(),
                invoice.get(i).getRegister_state()
            });
        }
        
        DefaultListModel modelList = new DefaultListModel();
        ArrayList<Customers>  cust = new Customers().getLista();
        modelList.setSize(0);
        
        for(int j = 0; j < cust.size(); j++)
        {
            String name = cust.get(j).getLast_name()+","+cust.get(j).getFirst_name();
            modelList.addElement(name);
            customers.setModel(modelList);
        }
    }
    
    public void addInvoices()
    {
       CInvoices_Add_Update agregar = new CInvoices_Add_Update(true, "");
    }
    
    public void displayDetails(JTable registros, JTable invoice_details)
    {
        try
        {
            String invoice_num = (String)registros.getValueAt(registros.getSelectedRow(), 0);
            DefaultTableModel model = (DefaultTableModel) invoice_details.getModel();
            ArrayList<Invoice_Line_Items> details = new Invoice_Line_Items().getList(invoice_num);
            model.setRowCount(0);

            for(int i = 0; i < details.size(); i++)
            {
                model.addRow(new Object[]{
                    details.get(i).getProduct_title(),
                    details.get(i).getProduct_quantity(),
                    details.get(i).getProduct_price(),
                    details.get(i).getDerived_product_cost(),
                    details.get(i).getDerived_vat_payable(),
                    details.get(i).getDerived_total_cost(),
                    details.get(i).getOther_line_item_details(),
                    details.get(i).getRegister_state()
                });
            }
        }
        catch(ArrayIndexOutOfBoundsException ex)
        { }
        
    }
    
    public void removeInvoices(JTable registros)
    {
        int i = registros.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) registros.getModel();
        
        if(i != -1)
        {
            if(!model.getValueAt(i, 7).equals("*"))
            {
                (new Invoices()).remove(model.getValueAt(i, 0).toString());
                model.setValueAt("*", i, 7);
                JOptionPane.showMessageDialog(null, "Record has been removed successfully", "REMOVE", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "Record has already been removed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Choose one record to remove", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public void autoComplete(JList listCustomer,JTextField txtCustomer)
    {      
        int large = listCustomer.getModel().getSize();
        
        DefaultListModel modelList = (DefaultListModel) listCustomer.getModel();
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter(txtCustomer);
        textAutoAcompleter.setMode(0); // infijo
        textAutoAcompleter.setCaseSensitive(false);
        
        for(int i = 0; i < large; i++)
            textAutoAcompleter.addItem((String)modelList.get(i));
    }
    
    public void autoComplete(JTable tblInvoices,JTextField txtSeaInv)
    {      
        int h = tblInvoices.getRowCount();
        
        DefaultTableModel model = (DefaultTableModel) tblInvoices.getModel();
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter(txtSeaInv);
        textAutoAcompleter.setMode(0); // infijo
        textAutoAcompleter.setCaseSensitive(false);
        
        for(int i = 0; i < h; i++)
            textAutoAcompleter.addItem((String)model.getValueAt(i,0));
    }
    
    public void search(JTable registros, JTextField seaInv)
    {
        String code = (String) seaInv.getText();
        DefaultTableModel model = (DefaultTableModel) registros.getModel();
        ArrayList<Invoices> invoice = new Invoices().getList();
        model.setRowCount(0);
        
        for(int i = 0; i < invoice.size(); i++)
        {
            
            if(invoice.get(i).getInvoice_number().equals(code))
            {
                model.addRow(new Object[]{                     
                invoice.get(i).getInvoice_number(),
                invoice.get(i).getOrder_id(),
                invoice.get(i).getInvoice_date(),
                invoice.get(i).getInvoice_details(),
                invoice.get(i).getRegister_state()
            });
                registros.setModel(model);
            break;
            }
        }
         
    }
    public void search(JList cusLis, JTextField seaCus)
    {
        String name = seaCus.getText();
        String last_name = name.substring(0, name.indexOf(","));
        String first_name = name.substring(name.indexOf(",")+1, name.length());
        
        ArrayList<Customers> customers = new Customers().getLista();
                
        for(int i = 0; i< customers.size();i++)
        {
            if(customers.get(i).getFirst_name().equals(first_name) || customers.get(i).getLast_name().equals(last_name))
            {
                cusLis.setSelectedValue(name, true);
            }
        }
    }
    
    public void search(JList lisCus, JTable invoices)
    {
        String name = (String) lisCus.getSelectedValue();
        String last_name = name.substring(0, name.indexOf(","));
        String first_name = name.substring(name.indexOf(",")+1, name.length());
        
        ArrayList<Customers> customers = new Customers().getLista();
        ArrayList<Invoices>  finv = new Invoices().getList();
        ArrayList<Invoices>  inv = new ArrayList();
        ArrayList<Orders> accounts = new Orders().getLista();
        
        for(int i = 0;i< customers.size();i++)
        {
            if(customers.get(i).getFirst_name().equals(first_name) && customers.get(i).getLast_name().equals(last_name))
            {
                String customer_id = customers.get(i).getCustomer_id();
                                
                for(int j = 0; j < accounts.size();j++)
                {
                    Orders a = accounts.get(j);
                    if(a.getCustomer_id().equals(customer_id))
                    {
                        for(int k = 0; k < finv.size();k++)
                        {
                            Invoices ft = finv.get(k);
                            if(ft.getOrder_id().equals(a.getOrder_id()))
                            {
                                inv.add(ft);
                            }           
                        }
                    }
                }
                break;
            }
        }
        DefaultTableModel model =  (DefaultTableModel) invoices.getModel();
        model.setRowCount(0);
        for(int h = 0; h < inv.size(); h++)
        {
            model.addRow(new Object[]{
            inv.get(h).getInvoice_number(),
            inv.get(h).getOrder_id(),
            inv.get(h).getInvoice_date(),
            inv.get(h).getInvoice_details(),
            inv.get(h).getRegister_state()
            });
        }
    }
}
