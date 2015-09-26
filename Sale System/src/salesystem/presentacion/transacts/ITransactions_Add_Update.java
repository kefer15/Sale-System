package salesystem.presentacion.transacts;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;

public interface ITransactions_Add_Update {
    public void cerrar();
    public void agregarModificarTransacts(String code, String account, String invoice,String typeTrans,String dateOpened, String amount, String other);
    public void cargar(JTextField txtTransaction_id, JTextField txtAccount,JTextField txtInvoice,JTextField txtTraTyp, JDateChooser dcDateOpened, JTextField txtAmount, JTextField txtOther);
    public void autoComplete(JTextField txtSearch,int ch);
}