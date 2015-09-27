package Controlador;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface IUsers {
    public void changeUserAdd(CardLayout card, JPanel panel, JComboBox gender, JComboBox position, JLabel title, JButton register);
    public void changeUserSearch(CardLayout card, JPanel panel);
    public void changeUserShow(CardLayout card, JPanel panel, JTable table);
    
    public void actUser(int option, String code, JTextField name, JTextField fatherLastName, JTextField motherLastName, JTextField ni, 
            JComboBox gender, JTextField address, JComboBox position, JTextField cellphone, JTextField eMail,
            JTextField emergencyNumber, JTextArea others);
    
    public ArrayList <String> searchUser(JTextField name, JTable table);
    
    public String sent(CardLayout card, JPanel panel, String code, JLabel title, JTextField name, JTextField fatherLastName, JTextField motherLastName, JTextField ni, 
            JComboBox gender, JTextField address, JComboBox position, JTextField cellphone, JTextField eMail,
            JTextField emergencyNumber, JTextArea others, JButton modify);
}
