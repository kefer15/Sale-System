package salesystem.presentacion.products;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;

public interface IProducts {
    void searchCategory(JTextField category, JList catList);
    void searchCategory(JList catList);
    void selectCategory(int indexCategory, JTable proTable);
    void searchProduct(JTextField product, JTable proTable);
    void searchProduct(JTable proTable);
    void add();
    void update(String product_id);
    void remove(int index, JTable proTable);
}
