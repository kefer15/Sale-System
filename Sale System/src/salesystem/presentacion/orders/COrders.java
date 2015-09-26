package salesystem.presentacion.orders;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import salesystem.negocio.Customers;
import salesystem.negocio.Order_Items;
import salesystem.negocio.Orders;

public class COrders
{
    public COrders(JTable orders, JTable tblOrderDetails, JList l)
    {
        //actualizar orders
        DefaultTableModel model = (DefaultTableModel) orders.getModel();
        ArrayList<Orders> list = new Orders().getLista();
        model.setRowCount(0);
               
        for(int i = 0; i < list.size(); i++)
        {
            model.addRow(new Object[]{
                list.get(i).getOrder_id(),
                list.get(i).getDate_order_placed(),
                list.get(i).getTotal_amount(),
                list.get(i).getOrder_details(),
                list.get(i).getRegister_state()
            });
        }
        //actualizar orderDetails
        if(orders.getRowCount()>0)
        {
            String order_id = (String)orders.getValueAt(0, 0);
            
            DefaultTableModel model2 = (DefaultTableModel) tblOrderDetails.getModel();
            ArrayList<Order_Items> details = new Order_Items().getList(order_id);
            model2.setRowCount(0);

            for(int i = 0; i < details.size(); i++)
            {
                model2.addRow(new Object[]{
                    details.get(i).getOrder_item_id(),
                    details.get(i).getProduct_id(),
                    details.get(i).getProduct_quantity(),
                    details.get(i).getOrder_item_cost(),
                    details.get(i).getOther_order_item_details(),
                    details.get(i).getRegister_state()
                });
            }
        }
        
        //actualizar l
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
        
    public void addOrders()
    {
        COrders_Add_Update add = new COrders_Add_Update(true, "");
    }  
    
    public void displayDetails(JTable registros, JTable invoice_details)
    {
        if(registros.getSelectedRow()>0)
        {
            String order_id = (String)registros.getValueAt(registros.getSelectedRow(), 0);
            DefaultTableModel model = (DefaultTableModel) invoice_details.getModel();
            ArrayList<Order_Items> details = new Order_Items().getList(order_id);
            model.setRowCount(0);

            for(int i = 0; i < details.size(); i++)
            {
                model.addRow(new Object[]{
                    details.get(i).getOrder_item_id(),
                    details.get(i).getProduct_id(),
                    details.get(i).getProduct_quantity(),
                    details.get(i).getOrder_item_cost(),
                    details.get(i).getOther_order_item_details(),
                    details.get(i).getRegister_state()
                });
            } 
        }else
        {
            DefaultTableModel model = (DefaultTableModel) invoice_details.getModel();
            model.setRowCount(0);
        }
    }
    public void search(JTable registros, JTextField tranSearch)
    {
        String code = (String) tranSearch.getText();
        DefaultTableModel model = (DefaultTableModel) registros.getModel();
        ArrayList<Orders> orders = new Orders().getLista();
        model.setRowCount(0);
        
        for(int i = 0; i < orders.size(); i++)
        {
            
            if(orders.get(i).getOrder_id().equals(code))
            {
                model.addRow(new Object[]{
                orders.get(i).getOrder_id(),
                orders.get(i).getDate_order_placed(),
                orders.get(i).getTotal_amount(),
                orders.get(i).getOrder_details(),
                orders.get(i).getRegister_state()
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
    
    public void autoComplete(JTable tblOrders,JTextField txtSearchOrders)
    {      
        int h = tblOrders.getRowCount();
        
        DefaultTableModel model = (DefaultTableModel) tblOrders.getModel();
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter( txtSearchOrders );
        textAutoAcompleter.setMode(0); // infijo
        textAutoAcompleter.setCaseSensitive(false);

        for(int i = 0; i < h; i++)
            textAutoAcompleter.addItem((String)model.getValueAt(i,0));
    }
}
