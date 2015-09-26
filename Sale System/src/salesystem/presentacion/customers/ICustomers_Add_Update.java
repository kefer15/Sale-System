package salesystem.presentacion.customers;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface ICustomers_Add_Update {
    public void cancel();
    public void done(JTextField first_name, JTextField middle_name, JTextField last_name, JTextField e_mail,
            JTextField phone, JTextField address, JTextArea other, String gender);
    public void cargar(JTextField codigo, JTextField first_name, JTextField middle_name, JTextField last_name, JTextField e_mail,
            JTextField phone, JTextField address, JTextArea other, JCheckBox Male, JCheckBox Female);
    public void verifica(JTextField cod, JLabel codText);
}
