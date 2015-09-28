package Controlador;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface ISuppliers {
    public void changeSupplierAdd(CardLayout card, JPanel panel, JLabel title, JButton register);
    public void changeSupplierSearch(CardLayout card, JPanel panel);
    public void changeSupplierShow(CardLayout card, JPanel panel, JTable table);
    public ArrayList <String> changeSupplierLink(CardLayout card, JPanel panel, JTable table);
    
    public void actSupplier(int option, String code, JTextField name, JTextField tr, JTextField phone, JTextField address);    
    public ArrayList <String> searchSupplier(JTextField name, JTable table);
    
    public String sent(CardLayout card, JPanel panel, String code, JLabel title, JTextField name, JTextField tr, 
            JTextField phone, JTextField address, JButton modify);
    
    public ArrayList <String> searchSupplierLink(JTextField name, JList list);
    public void link(boolean []state, ArrayList <String> products, String supplier);
}
