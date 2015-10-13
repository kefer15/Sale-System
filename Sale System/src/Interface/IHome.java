package Interface;

import Model.Users;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public interface IHome {
    /* Compares the id and password with id and password that are saved in data base */
    Users logIn(JTextField txtId, JPasswordField txtPass);
    
    /* Activate some functions according the type of user  */
    void activate(int iCode, JButton btnHome, JButton btnUsers, JButton btnSuppliers, JButton btnProducts, JButton btnStore, JButton btnSsale);
}
