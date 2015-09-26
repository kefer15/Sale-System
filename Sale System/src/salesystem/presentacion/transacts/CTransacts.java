package salesystem.presentacion.transacts;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import salesystem.negocio.Accounts;
import salesystem.negocio.Customers;
import salesystem.negocio.Financial_Transactions;

public class CTransacts
{
    public CTransacts(JTable t,JList l)
    {
        DefaultTableModel model = (DefaultTableModel) t.getModel();
        ArrayList<Financial_Transactions> financial_transactions = new Financial_Transactions().getLista();
        model.setRowCount(0);
        
        for(int i = 0; i < financial_transactions.size(); i++)
        {
            model.addRow(new Object[]{
                financial_transactions.get(i).getTransaction_id(),
                financial_transactions.get(i).getAccount_id(),
                financial_transactions.get(i).getInvoice_number(),
                financial_transactions.get(i).getTransaction_type_code(),
                financial_transactions.get(i).getTransaction_date(),
                financial_transactions.get(i).getTransaction_amount(),
                financial_transactions.get(i).getOther_transaction_details(),
                financial_transactions.get(i).getRegister_state()
            });
        }
        
        DefaultListModel modelList = new DefaultListModel();
        ArrayList<Customers>  cust = new Customers().getLista();
        modelList.setSize(0);
        
        for(int j = 0;j < cust.size();j++)
        {
            String name = cust.get(j).getLast_name()+","+cust.get(j).getFirst_name();
            modelList.addElement(name);
            l.setModel(modelList);
        }
    }
    
    public void agregarTransacts()
    {
        CTransacts_Add_Update transacts = new CTransacts_Add_Update(false);
    }
    
    public boolean modificarTransacts(JTable tblTransacts)
    {
        int i = tblTransacts.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblTransacts.getModel();
        
        if(i != -1)
        {
            CTransacts_Add_Update modificar;
            if(model.getValueAt(i,7).equals("A"))
            {
                modificar = new CTransacts_Add_Update(true, model.getValueAt(i, 0).toString());
                
                return true;
            }
            else
                JOptionPane.showMessageDialog(null, "Record has been removed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Choose one record to update", "ERROR", JOptionPane.ERROR_MESSAGE);
        
        return false;
    }
    
    public void eliminarTransacts(JTable tblTransacts)
    {
        int i = tblTransacts.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) tblTransacts.getModel();
        
        if(i != -1)
        {
            if(!model.getValueAt(i, 7).equals("*"))
            {
                (new Financial_Transactions()).eliminar(model.getValueAt(i, 0).toString());
                model.setValueAt("*", i, 7);
                JOptionPane.showMessageDialog(null, "Record has been removed successfully", "REMOVE", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "Record has already been removed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Choose one record to remove", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public void search(JTable registros, JTextField tranSearch)
    {
        String code = (String) tranSearch.getText();
        DefaultTableModel model = (DefaultTableModel) registros.getModel();
        ArrayList<Financial_Transactions> financial_transactions = new Financial_Transactions().getLista();
        model.setRowCount(0);
        
        for(int i = 0; i < financial_transactions.size(); i++)
        {
            
            if(financial_transactions.get(i).getTransaction_id().equals(code))
            {
                model.addRow(new Object[]{
                financial_transactions.get(i).getTransaction_id(),
                financial_transactions.get(i).getAccount_id(),
                financial_transactions.get(i).getInvoice_number(),
                financial_transactions.get(i).getTransaction_type_code(),
                financial_transactions.get(i).getTransaction_date(),
                financial_transactions.get(i).getTransaction_amount(),
                financial_transactions.get(i).getOther_transaction_details(),
                financial_transactions.get(i).getRegister_state()
            });
                registros.setModel(model);
            break;
            }
        }
         
    }
    public void search(JList registros, JTextField custSearch)
    {
        String name = custSearch.getText();
        String last_name = name.substring(0, name.indexOf(","));
        String first_name = name.substring(name.indexOf(",")+1, name.length());
        
        ArrayList<Customers> customers = new Customers().getLista();
                
        for(int i = 0; i< customers.size();i++)
        {
            if(customers.get(i).getFirst_name().equals(first_name) || customers.get(i).getLast_name().equals(last_name))
            {
                registros.setSelectedValue(name, true);
            }
        }
    }
    public void search(JList custSearch, JTable registros)
    {
        String name = (String) custSearch.getSelectedValue();
        String last_name = name.substring(0, name.indexOf(","));
        String first_name = name.substring(name.indexOf(",")+1, name.length());
        
        ArrayList<Customers> customers = new Customers().getLista();
        ArrayList<Financial_Transactions>  ftrans = new Financial_Transactions().getLista();
        ArrayList<Financial_Transactions>  trans = new ArrayList();
        ArrayList<Accounts> accounts = new Accounts().getList();
        
        for(int i = 0;i< customers.size();i++)
        {
            if(customers.get(i).getFirst_name().equals(first_name) && customers.get(i).getLast_name().equals(last_name))
            {
                String customer_id = customers.get(i).getCustomer_id();
                                
                for(int j = 0; j < accounts.size();j++)
                {
                    Accounts a = accounts.get(j);
                    if(a.getCustomer_id().equals(customer_id))
                    {
                        for(int k = 0; k < ftrans.size();k++)
                        {
                            Financial_Transactions ft = ftrans.get(k);
                            if(ft.getAccount_id().equals(a.getAccount_id()))
                            {
                                trans.add(ft);
                            }           
                        }
                    }
                }
                break;
            }
        }
        DefaultTableModel model =  (DefaultTableModel) registros.getModel();
        model.setRowCount(0);
        for(int h = 0; h < trans.size(); h++)
        {
            model.addRow(new Object[]{
            trans.get(h).getTransaction_id(),
            trans.get(h).getAccount_id(),
            trans.get(h).getInvoice_number(),
            trans.get(h).getTransaction_type_code(),
            trans.get(h).getTransaction_date(),
            trans.get(h).getTransaction_amount(),
            trans.get(h).getOther_transaction_details(),
            trans.get(h).getRegister_state()
            });
        }
    }
    public void autoComplete(JList lisCustomer,JTextField txtCustomer)
    {      
        int h = lisCustomer.getModel().getSize();
        
        DefaultListModel modelList = (DefaultListModel) lisCustomer.getModel();
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter( txtCustomer );
        textAutoAcompleter.setMode(0); // infijo
        textAutoAcompleter.setCaseSensitive(false);
        
        for(int i = 0; i < h; i++)
            textAutoAcompleter.addItem((String)modelList.get(i));
    }
    
    public void autoComplete(JTable tblTransacts,JTextField txtTransact)
    {      
        int h = tblTransacts.getRowCount();
        
        DefaultTableModel model = (DefaultTableModel) tblTransacts.getModel();
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter( txtTransact );
        textAutoAcompleter.setMode(0); // infijo
        textAutoAcompleter.setCaseSensitive(false);
        
        for(int i = 0; i < h; i++)
            textAutoAcompleter.addItem((String)model.getValueAt(i,0));
    }
}
