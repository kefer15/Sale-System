package Controlador;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface IProducts {
    public void changeProductAdd(CardLayout card, JPanel panel, JComboBox category, JLabel title, JButton register);
    public void changeProductShow(CardLayout card, JPanel panel, JTable table);
    
    public void actProduct(JTextField name, JTextField brand, JTextField presentation, JTextField price, JTextField stock, 
            JComboBox category);
}
