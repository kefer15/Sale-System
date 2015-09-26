
package salesystem.presentacion.orders;

import com.toedter.calendar.JDateChooser;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface IOrders_Add_Update {
    
    public void cancel();
    public void complete(JList l);
    public void search(JList registros, JTextField custSearch);
    public void search(JList custSearch, JTextField txtNumber, JDateChooser txtDate, JTextArea jTextArea2);
    public void autoComplete(JList lisCustomer,JTextField txtCustomer);
}
