package salesystem.presentacion.invoices;

import com.mxrck.autocompleter.TextAutoCompleter;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import salesystem.negocio.Invoice_Line_Items;
import salesystem.negocio.Invoices;
import salesystem.negocio.Order_Items;
import salesystem.negocio.Orders;
import salesystem.negocio.Products;
import salesystem.presentacion.CMain;

public class CInvoices_Add_Update implements IInvoices_Add_Update {
    
    private UIInvoices_Add_Update ventana;
    private boolean add_update; // TRUE Add, FALSE Update
    private String inv_num;

    public CInvoices_Add_Update(boolean add_update, String inv_num)
    {
        this.add_update = add_update;
        this.inv_num = inv_num;
        ventana = new UIInvoices_Add_Update(this);
    }
    
    @Override
    public void cancel()
    {
        CMain principal = new CMain(5);
        ventana.dispose();
    }

    @Override
    public void cargar(JTextField txtNumber, JList lstOrders, JDateChooser dcDate, JTextField txtOrderId, JTable tblInvoiceDetails, JTextField txtTotal, JTextArea txtOther)
    {
        if(add_update)
            cargarAdd(txtNumber, lstOrders, dcDate);
        else
            cargarUpdate(txtNumber, lstOrders, dcDate, txtOrderId, tblInvoiceDetails, txtTotal, txtOther);
    }

    private void cargarAdd(JTextField txtNumber, JList lstOrders, JDateChooser dcDate)
    {
        txtNumber.setText(new Invoices().getNextNumber());
        
        DefaultListModel modelList = new DefaultListModel();
        ArrayList<Orders> orders = new Orders().getLista();
        modelList.setSize(0);
        
        for(int i = 0; i < orders.size(); i++)
        {
            String order_name = orders.get(i).getOrder_id() + " - " + orders.get(i).getCustomer_id() + " - " + orders.get(i).getDate_order_placed();
            modelList.addElement(order_name);
        }
        lstOrders.setModel(modelList);
        dcDate.setDate(Calendar.getInstance().getTime());
    }

    private void cargarUpdate(JTextField txtNumber, JList lstOrders, JDateChooser dcDate, JTextField txtOrderId, JTable tblInvoiceDetails, JTextField txtTotal, JTextArea txtOther)
    {
        txtNumber.setText(inv_num);
    }
    
    public void autoComplete(JList registros, JTextField txtSearch)
    {   
        DefaultListModel model = (DefaultListModel) registros.getModel();
        TextAutoCompleter textAutoAcompleter = new TextAutoCompleter(txtSearch);
        textAutoAcompleter.setMode(0); // infijo
        textAutoAcompleter.setCaseSensitive(false);
        
        for(int i = 0; i < registros.getModel().getSize(); i++)
            textAutoAcompleter.addItem(registros.getModel().getElementAt(i));
    }
    
    public void search(JList registros, JTextField txtSearch)
    {
        try
        {
            DefaultListModel model = (DefaultListModel) registros.getModel();
            for(int i = 0; i < registros.getModel().getSize(); i++)
                if(txtSearch.getText().equals(registros.getModel().getElementAt(i)))
                    registros.setSelectedValue(txtSearch.getText(), true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Order not found", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void fillOrder(JTextField txtOrderId, JList lstOrders, JTable tblInvoiceDetails)
    {
        txtOrderId.setText(String.valueOf(lstOrders.getSelectedValue()).substring(0, 7));
        ArrayList<Invoice_Line_Items> items = new Order_Items().getInvoices(txtOrderId.getText());
        
        DefaultTableModel model = (DefaultTableModel) tblInvoiceDetails.getModel();
        model.setRowCount(0);
        
        for(int i = 0; i < items.size(); i++)
        {
            String cost = String.valueOf(Double.parseDouble(items.get(i).getProduct_price()) * Double.parseDouble(items.get(i).getProduct_quantity()));
            String vat  = String.valueOf(Double.parseDouble(cost) * Double.parseDouble(new Products().getVAT(items.get(i).getProduct_id())));
            String total = String.valueOf(Double.parseDouble(cost) + Double.parseDouble(vat));
            
            items.get(i).setDerived_product_cost(cost);
            items.get(i).setDerived_vat_payable(vat);
            items.get(i).setDerived_total_cost(total);
            
            model.addRow(new Object[]{  items.get(i).getProduct_title(),
                                        items.get(i).getProduct_quantity(),
                                        items.get(i).getProduct_price(),
                                        items.get(i).getDerived_product_cost(),
                                        items.get(i).getDerived_vat_payable(),
                                        items.get(i).getDerived_total_cost(),
                                        items.get(i).getOther_line_item_details()
                                        });
        }
        
    }
}
