package salesystem.presentacion;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CMain implements IMain
{
    private UIMain ventana;
    
    public CMain(int num_ventana)
    {
        ventana = new UIMain(this, num_ventana);
    }
    
    public void cambiarHome(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlHome");
    }
    
    public void cambiarCustomers(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlCustomers");
    }
    
    public void cambiarProducts(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlProducts");
    }
    
    public void cambiarTransacts(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlTransacts");
    }
    
    public void cambiarOrders(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlOrders");
    }
    
    public void cambiarInvoices(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlInvoices");
    }
    
    public void cambiarHelp(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlHelp");
    }
    
    public void cambiarCatMeasure(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlCatMeasure");
    }
    
    public void cambiarTypeAccount(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlTypeAccount");
    }
    
    public void colorear(int num, ArrayList<JButton> menu)
    {
        for (JButton btn : menu)
        {
            btn.setBackground(new Color(224, 224, 224));
            btn.setForeground(new Color(0, 0, 0));
        }
        
        menu.get(num).setBackground(new Color(170, 170, 170));
        menu.get(num).setForeground(new Color(255, 255, 255));
    }
}
