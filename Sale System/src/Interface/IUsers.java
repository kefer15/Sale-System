package Interface;

import java.awt.CardLayout;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
  @version 2.3
  @author Miguel Fernández
 */

public interface IUsers {
    
    /** Changes to submenu 'Nuevo Usuario'
     * @param crdCard
     * @param pnlPanel
     * @param cbxGender
     * @param cbxPosition
     * @param lblTitle
     * @param btnRegister */
    void changeUserAdd(CardLayout crdCard, JPanel pnlPanel, JComboBox cbxGender, JComboBox cbxPosition, JLabel lblTitle, JButton btnRegister);
    
    /** Changes to submenu 'Buscar Usuario'
     * @param crdCard
     * @param pnlPanel */
    void changeUserSearch(CardLayout crdCard, JPanel pnlPanel);
    
    /** Changes to submenu 'Usuarios Registrados'
     * @param crdCard
     * @param pnlPanel
     * @param tblTable */
    void changeUserShow(CardLayout crdCard, JPanel pnlPanel, JTable tblTable);
    
    /** Modifies and adds features of a specic product
     * @param iOption
     * @param strCode
     * @param txtName
     * @param txtFatherLastName
     * @param txtMotherLastName
     * @param txtNi
     * @param cbxGender
     * @param txtAddress
     * @param cbxPosition
     * @param txtCellphone
     * @param txtEmail
     * @param txtEmergencyNumber
     * @param txaOthers */
    void actUser(int iOption, String strCode, JTextField txtName, JTextField txtFatherLastName, JTextField txtMotherLastName, JTextField txtNi, 
            JComboBox cbxGender, JTextField txtAddress, JComboBox cbxPosition, JTextField txtCellphone, JTextField txtEmail,
            JTextField txtEmergencyNumber, JTextArea txaOthers);
    
    /** Returns all coincidences from a search of a user
     * @param txtName
     * @param tblTable
     * @return  */
    List <String> searchUser(JTextField txtName, JTable tblTable);
    
    /** Fills all courts the window needs from a specif user
     * @param crdCard
     * @param pnlPanel
     * @param strCode
     * @param lblTitle
     * @param txtName
     * @param txtFatherLastName
     * @param txtMotherLastName
     * @param txtNi
     * @param cbxGender
     * @param txtAddress
     * @param cbxPosition
     * @param txtCellphone
     * @param txtEmail
     * @param txtEmergencyNumber
     * @param txaOthers
     * @param btnModify
     * @return  */
    String send(CardLayout crdCard, JPanel pnlPanel, String strCode, JLabel lblTitle, JTextField txtName, JTextField txtFatherLastName, JTextField txtMotherLastName, JTextField txtNi, 
            JComboBox cbxGender, JTextField txtAddress, JComboBox cbxPosition, JTextField txtCellphone, JTextField txtEmail,
            JTextField txtEmergencyNumber, JTextArea txaOthers, JButton btnModify);
}
