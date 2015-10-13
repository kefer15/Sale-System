package Interface;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public interface IUsers {
    /* Changes to submenu 'Nuevo Usuario' */
    void changeUserAdd(CardLayout crdCard, JPanel pnlPanel, JComboBox cbxGender, JComboBox cbxPosition, JLabel lblTitle, JButton btnRegister);
    
    /* Changes to submenu 'Buscar Usuario' */
    void changeUserSearch(CardLayout crdCard, JPanel pnlPanel);
    
    /* Changes to submenu 'Usuarios Registrados' */
    void changeUserShow(CardLayout crdCard, JPanel pnlPanel, JTable tblTable);
    
    /* Modifies and adds features of a specic product */
    void actUser(int iOption, String strCode, JTextField txtName, JTextField txtFatherLastName, JTextField txtMotherLastName, JTextField txtNi, 
            JComboBox cbxGender, JTextField txtAddress, JComboBox cbxPosition, JTextField txtCellphone, JTextField txtEmail,
            JTextField txtEmergencyNumber, JTextArea txaOthers);
    
    /* Returns all coincidences from a search of a user */
    ArrayList <String> searchUser(JTextField txtName, JTable tblTable);
    
    /* Fills all courts the window needs from a specif user */
    String send(CardLayout crdCard, JPanel pnlPanel, String strCode, JLabel lblTitle, JTextField txtName, JTextField txtFatherLastName, JTextField txtMotherLastName, JTextField txtNi, 
            JComboBox cbxGender, JTextField txtAddress, JComboBox cbxPosition, JTextField txtCellphone, JTextField txtEmail,
            JTextField txtEmergencyNumber, JTextArea txaOthers, JButton btnModify);
}
