package Controlador;

import Vista.UIMain;
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
    
    @Override
    public void changeHome(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlHome");
    }
    
    @Override
    public void changeUsers(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlUsers");
    }
    
    @Override
    public void changeSuppliers(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlSuppliers");
    }
    
    @Override
    public void changeProducts(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlProducts");
    }
    
    @Override
    public void changeStore(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlStore");
    }
    
    @Override
    public void changeSale(CardLayout card, JPanel panel)
    {
        card.show(panel, "pnlSale");
    }
    
    @Override
    public void paint(int num, ArrayList <JButton> menu)
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
