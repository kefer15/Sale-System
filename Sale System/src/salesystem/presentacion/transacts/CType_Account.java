package salesystem.presentacion.transacts;

import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import salesystem.negocio.Accounts;
import salesystem.negocio.Customers;
import salesystem.negocio.Transaction_Types;

public class CType_Account
{
    //Accounts
    private String Customer_id;
    public void setCustomer_id(String customer, JList custSearch){
        this.Customer_id = search(custSearch);
    }
    public String search(JList custSearch)
    {
        if(custSearch.isSelectionEmpty())
            custSearch.setSelectedIndex(0);
        
        String name = (String) custSearch.getSelectedValue();
        String last_name = name.substring(0, name.indexOf(","));
        String first_name = name.substring(name.indexOf(",")+1, name.length());
        
        ArrayList<Customers> customers = new Customers().getLista();
        
        for(int i = 0;i< customers.size();i++)
        {
            if(customers.get(i).getFirst_name().equals(first_name) && customers.get(i).getLast_name().equals(last_name))
            {
                return customers.get(i).getCustomer_id();
            }
        }
        return "null";
    }
    public void addAccounts(int type, JTable tbAccounts)
    {
        CAccounts_Add_Update accounts = new CAccounts_Add_Update(type, Customer_id);
    }
    public void updateAccounts(int type, JTable tbAccounts) 
    {
        try{
            int i = -1;
            if(tbAccounts.getSelectedRow() > -1)
                i = tbAccounts.getSelectedRow();
            else if(tbAccounts.getRowCount()>0)
                i = 0;
            else JOptionPane.showMessageDialog (null, "No data found. De sure to enter data", "Warning", JOptionPane.WARNING_MESSAGE);
            
            if(tbAccounts.getRowCount()>0)
            {
                String account_id = (String)tbAccounts.getValueAt(i,0);
                String account_name =(String)tbAccounts.getValueAt(i,1);
                String date =(String)tbAccounts.getValueAt(i,2);

                Accounts auxAc = new Accounts();
                auxAc.search(account_id);
                String other = auxAc.getOther_account_details();

                CAccounts_Add_Update accounts = new CAccounts_Add_Update(type, account_id, Customer_id, date, account_name, other);
            }

        } catch (ParseException ex) {  
        }
    }
    
    public void removeAccounts(JTable tbAccounts)
    {
        int i = -1;
        if(tbAccounts.getSelectedRow() > -1)
            i = tbAccounts.getSelectedRow();
        else if(tbAccounts.getRowCount()>0)
            i = 0;
        else JOptionPane.showMessageDialog (null, "No data found. De sure to enter data", "Warning", JOptionPane.WARNING_MESSAGE);
            
        if(tbAccounts.getRowCount()>0)
        {
            String code = (String)tbAccounts.getValueAt(i,0);
            String nombre =(String)tbAccounts.getValueAt(i,1);
            String fecha =(String)tbAccounts.getValueAt(i,2);

            int retour = JOptionPane.showConfirmDialog (null, "¿Would you like to remove\nCode: " + code + "\nName: " + nombre + "\nDate: " + fecha + "   ?", "Message Confirmation", JOptionPane.YES_NO_OPTION);
            if(retour==0)
            {
                Accounts nuevo = new Accounts(code, Customer_id, "", nombre, "", "A");
                nuevo.remove(code);
                updateTableAccounts(tbAccounts);
            }
        }
    }
    
    public void updateTableAccounts(JTable tbAccounts)
    {
        Accounts auxAc = new Accounts();
        ArrayList<Accounts> dTransaction_Types = new ArrayList<Accounts>();
        
        dTransaction_Types = auxAc.getList();
            
        DefaultTableModel model = (DefaultTableModel) tbAccounts.getModel();
        model.setRowCount(0);

        for(int i = 0; i < dTransaction_Types.size(); i++)
        {
            model.addRow(new Object[]{ dTransaction_Types.get(i).getAccount_id(),
                                        dTransaction_Types.get(i).getAccount_name(),
                                        dTransaction_Types.get(i).getDate_account_opened(),
                                        dTransaction_Types.get(i).getRegister_state()
                                    }  
            );
        }
    }
    
    
    
    // TransactionTypes
    
    public void addTransactionTypes(int type, JTable tbTrasactionTypes)
    {
        CTransactionTypes_Add_Update transactionTypes = new CTransactionTypes_Add_Update(type);
    }
    public void updateTransactionTypes(int type, JTable tbTrasactionTypes)
    {
        int i = -1;
        if(tbTrasactionTypes.getSelectedRow() > -1)
            i = tbTrasactionTypes.getSelectedRow();
        else if(tbTrasactionTypes.getRowCount()>0)
            i = 0;
        else JOptionPane.showMessageDialog (null, "No data found. De sure to enter data", "Warning", JOptionPane.WARNING_MESSAGE);
        
        if(tbTrasactionTypes.getRowCount()>0)
        {
            String codigo = (String)tbTrasactionTypes.getValueAt(i,0);
            String description =(String)tbTrasactionTypes.getValueAt(i,1);

            CTransactionTypes_Add_Update transactionTypes = new CTransactionTypes_Add_Update(type, codigo, description);   
        }
        
    }
    public void removeTransactionTypes(JTable tbTrasactionTypes)
    {
        int i = -1;
        if(tbTrasactionTypes.getSelectedRow() > -1)
            i = tbTrasactionTypes.getSelectedRow();
        else if(tbTrasactionTypes.getRowCount()>0)
            i = 0;
        else JOptionPane.showMessageDialog (null, "No data found. De sure to enter data", "Warning", JOptionPane.WARNING_MESSAGE);
        
        
        if(tbTrasactionTypes.getRowCount() > 0)
        {
            String code = (String)tbTrasactionTypes.getValueAt(i,0);
            String description =(String)tbTrasactionTypes.getValueAt(i,1);

            int retour = JOptionPane.showConfirmDialog (null, "¿Would you like to remove\nCode: " + code + "\nDescription: " + description + "  ?", "Message Confirmation", JOptionPane.YES_NO_OPTION);
            if(retour==0)
            {
                Transaction_Types nuevo = new Transaction_Types(code, description, "A");
                nuevo.remove(code);
                updateTableTrasactionTypes(tbTrasactionTypes);
            }
        }
    }
    public void updateTableTrasactionTypes(JTable tbTrasactionTypes)
    {
        Transaction_Types auxTT = new Transaction_Types();
        ArrayList<Transaction_Types> dTransaction_Types = new ArrayList<Transaction_Types>();
        
        dTransaction_Types = auxTT.getList();
            
        DefaultTableModel model = (DefaultTableModel) tbTrasactionTypes.getModel();
        model.setRowCount(0);

        for(int i = 0; i < dTransaction_Types.size(); i++)
        {
            model.addRow(new Object[]{ dTransaction_Types.get(i).getTransaction_type_code(),
                                        dTransaction_Types.get(i).getTransaction_type_description(),
                                        dTransaction_Types.get(i).getTransaction_types_register_state()
                                    }  
            );
        }
    }
}
