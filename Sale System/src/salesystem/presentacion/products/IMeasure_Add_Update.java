package salesystem.presentacion.products;

import javax.swing.JTextField;

public interface IMeasure_Add_Update
{
    public void cancel();
    public void done(JTextField description);
    public void cargar(JTextField description);
}
