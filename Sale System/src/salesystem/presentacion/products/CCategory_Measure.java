package salesystem.presentacion.products;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import salesystem.negocio.Measures;
import salesystem.negocio.Product_Categories;
import salesystem.presentacion.products.CCategory_Add_Update;

public class CCategory_Measure
{
    public CCategory_Measure(JTable c, JTable m)
    {
        DefaultTableModel model = (DefaultTableModel) c.getModel();
        ArrayList<Product_Categories> categorias = new Product_Categories().getLista();
        model.setRowCount(0);
        
        for(int i = 0; i < categorias.size(); i++)
        {
            model.addRow(new Object[]{  categorias.get(i).getProduct_type_code(),
                                        categorias.get(i).getProduct_type_description(),
                                        categorias.get(i).getVat_rating(),
                                        categorias.get(i).getRegister_state()});
        }
        
        DefaultTableModel model2 = (DefaultTableModel) m.getModel();
        ArrayList<Measures> unidades = new Measures().getLista();
        model2.setRowCount(0);
        
        for(int i = 0; i < unidades.size(); i++)
        {
            model2.addRow(new Object[]{ unidades.get(i).getMeasure_id(),
                                        unidades.get(i).getMeasure_description(),
                                        unidades.get(i).getRegister_state()});
        }
    }
    
    public void agregarCategories()
    {
        CCategory_Add_Update agregar = new CCategory_Add_Update(true, "");
    }
    
    public boolean modificarCategories(JTable registros)
    {
        int i = registros.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) registros.getModel();
        
        if(i != -1)
        {
            CCategory_Add_Update modificar;
            if(model.getValueAt(i, 3).equals("A"))
            {
                modificar = new CCategory_Add_Update(false, model.getValueAt(i, 0).toString());
                return true;
            }
            else
                JOptionPane.showMessageDialog(null, "Record has been removed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Choose one record to update", "ERROR", JOptionPane.ERROR_MESSAGE);
        
        return false;
    }
    
    public void eliminarCategories(JTable registros)
    {
        int i = registros.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) registros.getModel();
        
        if(i != -1)
        {
            if(!model.getValueAt(i, 3).equals("*"))
            {
                (new Product_Categories()).eliminar(model.getValueAt(i, 0).toString());
                model.setValueAt("*", i, 3);
                JOptionPane.showMessageDialog(null, "Record has been removed successfully", "REMOVE", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "Record has already been removed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Choose one record to remove", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public void agregarMeasures()
    {
        CMeasure_Add_Update agregar = new CMeasure_Add_Update(true, "");
    }
    
    public boolean modificarMeasures(JTable registros)
    {
        int i = registros.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) registros.getModel();
        
        if(i != -1)
        {
            CMeasure_Add_Update modificar;
            if(model.getValueAt(i, 2).equals("A"))
            {
                modificar = new CMeasure_Add_Update(false, model.getValueAt(i, 0).toString());
                return true;
            }
            else
                JOptionPane.showMessageDialog(null, "Record has been removed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Choose one record to update", "ERROR", JOptionPane.ERROR_MESSAGE);
        
        return false;
    }
    
    public void eliminarMeasures(JTable registros)
    {
        int i = registros.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) registros.getModel();
        
        if(i != -1)
        {
            if(!model.getValueAt(i, 2).equals("*"))
            {
                (new Measures()).eliminar(model.getValueAt(i, 0).toString());
                model.setValueAt("*", i, 2);
                JOptionPane.showMessageDialog(null, "Record has been removed successfully", "REMOVE", JOptionPane.INFORMATION_MESSAGE);
            }
            else
                JOptionPane.showMessageDialog(null, "Record has already been removed", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else
            JOptionPane.showMessageDialog(null, "Choose one record to remove", "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
