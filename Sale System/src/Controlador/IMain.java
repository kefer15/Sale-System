package Controlador;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public interface IMain
{
    public void changeHome(CardLayout card, JPanel panel);
    public void changeUsers(CardLayout card, JPanel panel);
    public void changeSuppliers(CardLayout card, JPanel panel);
    public void changeProducts(CardLayout card, JPanel panel);
    public void changeStore(CardLayout card, JPanel panel);
    public void changeSale(CardLayout card, JPanel panel);
    
    public void paint(int num, ArrayList<JButton> menu);
    
    public void logOut();
    public void forgottenPass(JTextField user);
    public void setOrderNumber(JLabel number);
}
