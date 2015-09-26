package salesystem.presentacion.products;

import javax.swing.JSpinner;
import javax.swing.JTextField;

public interface ICategory_Add_Update
{
    public void cancel();
    public void done(JTextField description, JSpinner vat);
    public void cargar(JTextField description, JSpinner vat);
}
