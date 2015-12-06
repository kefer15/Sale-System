package Interface;

import Model.Users;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

public interface IHome {
    /** Compares the id and password with id and password that are saved in data base
     * @param txtId
     * @param txtPass
     * @return  */
    Users logIn(JTextField txtId, JPasswordField txtPass);
    
    /** Activate some functions according the type of user
     * @param iCode
     * @param btnHome
     * @param btnUsers
     * @param btnSuppliers
     * @param btnProducts
     * @param btnStore
     * @param btnSsale */
    void activate(int iCode, JButton btnHome, JButton btnUsers, JButton btnSuppliers, JButton btnProducts, JButton btnStore, JButton btnSsale);
}
