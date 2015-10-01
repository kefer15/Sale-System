package Controlador;

import Modelo.Products;
import Modelo.Users;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface ISale {
    ArrayList <Products> search(JComboBox comboBox, JTextField text, JTable table);
    double addProduct(JTable table, int index, ArrayList <Products> products, double total);
    boolean verifyQuantity(String code, String quantity);
    void safeSale(Users user, JTextField client, JLabel mount, JLabel date, JTable products);
}
