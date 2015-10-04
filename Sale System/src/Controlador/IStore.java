package Controlador;

import Modelo.Users;
import com.toedter.calendar.JCalendar;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface IStore {
    public void changeProductSearch(CardLayout card, JPanel panel);
    public void changeTicketSearch(CardLayout card, JPanel panel);
    public void changeReportSale(CardLayout card, JPanel panel);
    public void changeInventStore(CardLayout card, JPanel panel, JTable table);
    public void changeModify(CardLayout card, JPanel panel);
            
    public ArrayList <String> searchProduct(JTextField name, JTable table);
    public String sendProduct(String code, JTextField name, JTextField brand, JTextField presentation, JTextField stock, 
            JComboBox category, JTextField price);
    
    public void actProduct(String code, JTextField name, JTextField brand, JTextField presentation, JTextField stock, 
            JComboBox category, JTextField price);
    
    public void chargeProduct(JTable table, JComboBox combo);
    public ArrayList <String> searchTicket(JTextField number, JTable table);
    
    boolean productReport(Users user);
    boolean saleReport(Users user, JCalendar start, JCalendar end);
}
