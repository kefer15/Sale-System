package salesystem.presentacion.customers;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import salesystem.negocio.Customers;
import salesystem.presentacion.CMain;

public class CCustomers_Add_Update implements ICustomers_Add_Update
{
    private UICustomer_Add_Update ventana;
    private boolean add_update; // TRUE Add, FALSE Update
    private String id;

    public CCustomers_Add_Update(boolean add_update, String id) {
        this.add_update = add_update;
        this.id = id;
        ventana = new UICustomer_Add_Update(this);
    }
    
    public void cancel()
    {
        CMain principal = new CMain(1);
        ventana.dispose();
    }
    
    public void verifica(JTextField cod, JLabel codText)
    {
        if(add_update)
        {
            cod.setVisible(false);
            codText.setVisible(false);
        }
        else
        {
            cod.setVisible(true);
            codText.setVisible(true);
        }
    }
    
    public void done(JTextField first_name, JTextField middle_name, JTextField last_name, JTextField e_mail,
            JTextField phone, JTextField address, JTextArea other, String gender)
    {
        if(add_update)
            insertar(first_name, middle_name, last_name, e_mail, phone, address, other, gender);
        else
            modificar(first_name, middle_name, last_name, e_mail, phone, address, other, gender);
    }
    
    private void insertar(JTextField first_name, JTextField middle_name, JTextField last_name, JTextField e_mail,
            JTextField phone, JTextField address, JTextArea other, String gender)
    {
        Customers c = new Customers("", first_name.getText(), middle_name.getText(), last_name.getText(), 
                gender, e_mail.getText(), phone.getText(), address.getText(), other.getText(), "A");
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
    
    private void modificar(JTextField first_name, JTextField middle_name, JTextField last_name, JTextField e_mail,
            JTextField phone, JTextField address, JTextArea other, String gender)
    {
        Customers c = new Customers("",first_name.getText(), middle_name.getText(), last_name.getText(), gender,
                e_mail.getText(), phone.getText(), address.getText(), other.getText(), "A");
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
        
    public void cargar(JTextField codigo, JTextField first_name, JTextField middle_name, JTextField last_name, JTextField e_mail,
            JTextField phone, JTextField address, JTextArea other, JCheckBox Male, JCheckBox Female)
    {
        if(!add_update)
        {
            Customers c = new Customers();
            c.buscar(id);
            
            //CODIGO CUSTOMER
            codigo.setText(id);
            codigo.setEditable(false);
            
            //DATOS CUSTOMER
            first_name.setText(c.getFirst_name());
            middle_name.setText(c.getMiddle_name());
            last_name.setText(c.getLast_name());
            e_mail.setText(c.getEmail());
            phone.setText(c.getPhone());
            address.setText(c.getAddress());
            other.setText(c.getOther());
            
            //JCHECKBOX GENDER CUSTOMER
            if(c.getGender().equals("M"))
            {
                Male.setSelected(true);
                Female.setSelected(false);
            }
            if(c.getGender().equals("F"))
            {
                Male.setSelected(false);
                Female.setSelected(true);
            }
        }
    }

}
