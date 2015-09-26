package salesystem.presentacion.products;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import salesystem.negocio.Measures;
import salesystem.presentacion.CMain;

public class CMeasure_Add_Update implements IMeasure_Add_Update
{
    private UIMeasure_Add_Update ventana;
    private boolean add_update; // TRUE Add, FALSE Update
    private String id;
    
    public CMeasure_Add_Update(boolean add_update, String id)
    {
        this.add_update = add_update;
        this.id = id;
        ventana = new UIMeasure_Add_Update(this);
    }
    
    public void cancel()
    {
        CMain principal = new CMain(8);
        ventana.dispose();
    }
    
    public void done(JTextField description)
    {
        if(add_update)
            insertar(description);
        else
            modificar(description);
    }
    
    private void insertar(JTextField description)
    {
        Measures m = new Measures("", description.getText(), "A");
        String err = m.insertar();
        if(err.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Record has been added successfully", "ADD", JOptionPane.INFORMATION_MESSAGE);
            CMain principal = new CMain(8);
            ventana.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, err, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    private void modificar(JTextField description)
    {
        Measures m = new Measures("", description.getText(), "A");
        String err = m.modificar(id);
        if(err.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Record has been updated successfully", "UPDATE", JOptionPane.INFORMATION_MESSAGE);
            CMain principal = new CMain(8);
            ventana.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, err, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public void cargar(JTextField description)
    {
        if(!add_update)
        {
            Measures m = new Measures();
            m.buscar(id);
            description.setText(m.getMeasure_description());
        }
    }
}
