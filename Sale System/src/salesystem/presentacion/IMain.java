package salesystem.presentacion;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public interface IMain
{
    public void cambiarHome(CardLayout card, JPanel panel);
    public void cambiarCustomers(CardLayout card, JPanel panel);
    public void cambiarProducts(CardLayout card, JPanel panel);
    public void cambiarTransacts(CardLayout card, JPanel panel);
    public void cambiarOrders(CardLayout card, JPanel panel);
    public void cambiarInvoices(CardLayout card, JPanel panel);
    public void cambiarHelp(CardLayout card, JPanel panel);
    public void cambiarCatMeasure(CardLayout card, JPanel panel);
    public void cambiarTypeAccount(CardLayout card, JPanel panel);
    
    public void colorear(int num, ArrayList<JButton> menu);
}
