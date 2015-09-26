package salesystem.presentacion.invoices;

import com.toedter.calendar.JDateChooser;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface IInvoices_Add_Update {
    
    /*public void cancel();
    public void done(JTextField first_name, JTextField middle_name, JTextField last_name, JTextField e_mail,
            JTextField phone, JTextField address, JTextArea other, String gender);
    public void cargar(JTextField codigo, JTextField first_name, JTextField middle_name, JTextField last_name, JTextField e_mail,
            JTextField phone, JTextField address, JTextArea other, JCheckBox Male, JCheckBox Female);*/
    /*DESDE AQUI HICE**/
    public void cancel();
    
    //public void addInvoice(JTable tblInvoiceDetails);

    public void cargar(JTextField txtNumber, JList lstOrders, JDateChooser dcDate, JTextField txtOrderId, JTable tblInvoiceDetails, JTextField txtTotal, JTextArea txtOther);
    public void autoComplete(JList registros, JTextField txtSearch);
    public void search(JList registros, JTextField txtSearch);

    public void fillOrder(JTextField txtOrderId, JList lstOrders, JTable tblInvoiceDetails);
    
}
