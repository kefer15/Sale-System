package salesystem.presentacion.products;

import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface IProducts_Add_Update {
    void inicializateMeasures(JComboBox cbxMeasure);
    void searchCategory(JTextField category, JList catList);
    void searchCategory(JList catList);
    void searchParent(JTextField parent, JList catList);
    void searchParent(JList catList);
    void fill(String product_id, JList lisParent, JTextField txtParent, JList lisCategory, 
            JTextField txtCategory, JTextField txtName, JTextField txtPrice, JTextField txtColor, 
            JTextField txtSize, JComboBox cbxMeasure, JTextArea txtDescription, JTextArea txtOther);
    void done(String product_id, int indexParent, int indexCategory, JTextField txtName, 
            JTextField txtPrice, JTextField txtColor, JTextField txtSize, int indexMeasure, 
            JTextArea txtDescription, JTextArea txtOther);
    void cancel();   
}
