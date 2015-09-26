
package salesystem.presentacion.orders;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import salesystem.negocio.Customers;
import salesystem.negocio.Orders;
import salesystem.presentacion.CMain;

public class COrders_Add_Update implements IOrders_Add_Update
{
    private UIOrders_Add_Update ventana;
    private boolean add_update; // TRUE Add, FALSE Update
    private String id;

    public COrders_Add_Update(boolean add_update, String id) {
        this.add_update = add_update;
        this.id = id;
        ventana = new UIOrders_Add_Update(this);
    }
    
     
    public void done(JTextField Number, JTextField Date, JTextArea Details, JTextArea TotalAmount)
    {
        if(add_update)
            insertar(Number, Date, Details, TotalAmount);
        else
            modificar(Number, Date, Details, TotalAmount);
    }
    
    
    private void insertar(JTextField Number, JTextField Date, JTextArea Details, JTextArea TotalAmount)
    {
        Orders c = new Orders(Number.getText(), "", Date.getText(), TotalAmount.getText(), Details.getText(),  "A");
        String err = c.insertar();
        if(err.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Record has been added successfully", "ADD", JOptionPane.INFORMATION_MESSAGE);
            CMain principal = new CMain(1);
            ventana.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, err, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    private void modificar(JTextField Number, JTextField Date, JTextArea Details, JTextArea TotalAmount)
    {
        Orders c = new Orders(Number.getText(), "", Date.getText(), TotalAmount.getText(), Details.getText(),  "A");
        String err = c.modificar(id);
        if(err.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Record has been updated successfully", "UPDATE", JOptionPane.INFORMATION_MESSAGE);
            CMain principal = new CMain(1);
            ventana.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, err, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public void cancel()
    {
        ventana.dispose();
        CMain principal = new CMain(1); 
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
        ArrayList<Orders>  ftrans = new Orders().getLista();
        ArrayList<Orders>  trans = new ArrayList();
        ArrayList<Orders>  accounts = new Orders().getLista();
        
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
                        for(int k = 0; k < ftrans.size();k++)
                        {
                            Orders ft = ftrans.get(k);
                            if(ft.getOrder_id().equals(a.getOrder_id()))
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
            trans.get(h).getOrder_id(),
            trans.get(h).getDate_order_placed(),
            trans.get(h).getTotal_amount(),
            trans.get(h).getOrder_details(),
            trans.get(h).getRegister_state()
            });
        }
    }
    public void search(JList custSearch, JTextField txtNumber, JDateChooser txtDate, JTextArea jTextArea2)
    {
        //Limpiar
        txtNumber.setText("");
        txtDate.setDate(new Date());
        jTextArea2.setText("");
        //
        String name = (String) custSearch.getSelectedValue();
        String last_name = name.substring(0, name.indexOf(","));
        String first_name = name.substring(name.indexOf(",")+1, name.length());
        
        ArrayList<Customers> customers = new Customers().getLista();
        ArrayList<Orders>  ftrans = new Orders().getLista();
        ArrayList<Orders>  trans = new ArrayList();
        ArrayList<Orders>  accounts = new Orders().getLista();
        
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
                        for(int k = 0; k < ftrans.size();k++)
                        {
                            Orders ft = ftrans.get(k);
                            if(ft.getOrder_id().equals(a.getOrder_id()))
                            {
                                trans.add(ft);
                            }           
                        }
                    }
                }
                break;
            }
        }
        
        for(int h = 0; h < trans.size(); h++)
        {
            txtNumber.setText(trans.get(h).getOrder_id());
            jTextArea2.setText(trans.get(h).getOrder_details());
            
            final String OLD_FORMAT = "yyyy-MM-dd";
            final String NEW_FORMAT = "dd/MM/yyyy";


            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
            Date d;
            try {
                d = sdf.parse(trans.get(h).getDate_order_placed());
                sdf.applyPattern(NEW_FORMAT);
                String newDateString = sdf.format(d);

                txtDate.setDate(new Date(newDateString));
            } catch (ParseException ex) {
                Logger.getLogger(COrders_Add_Update.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void complete(JList l)
    {
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
}
