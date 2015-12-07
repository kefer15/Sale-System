package Controlator;

import Interface.IUsers;

import Model.Gender;
import Model.Position;
import Model.Users;

import java.awt.CardLayout;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
  @version 2.3
  @author Miguel Fernandez
 */

public class CUsers implements IUsers {
    private List <Gender> aryGenders = new ArrayList <Gender> ();
    private List <Position> aryPositions = new ArrayList <Position> ();
    private List <String> aryGendersIndexes = new ArrayList <String> ();
    private List <String> aryPositionsIndexes = new ArrayList <String> ();
    private final String NEXTLINE = System.getProperty("line.separator");
    
    /*
        The constructor fills aryGenders with all Categorigies available, and
        fills aryPositions with all Positions avaliable.
        Initializes aryGendersIndexes and aryPositionsIndexes.
    */
    public CUsers() {
        aryGenders = (new Gender()).getList();
        aryPositions = (new Position()).getList();
        aryGendersIndexes = new ArrayList <> ();
        aryPositionsIndexes = new ArrayList <> ();
    }
    
    /*
        Fills all Genders into cbxGender and links the information of each register with 
        each index of aryGendersIndexes.
        Fills all Positions into cbxPosition and links the information of each register with 
        each index of aryPositionsIndexes.
    */
    private void fill(JComboBox cbxGender, JComboBox cbxPosition) {
        aryGenders.stream().map((cGender) -> {
            cbxGender.addItem(cGender.getDescription());
            return cGender;
        }).forEach((cGender) -> {
            aryGendersIndexes.add(cGender.getCode());
        });
        
        aryPositions.stream().map((cPosition) -> {
            cbxPosition.addItem(cPosition.getDescription());
            return cPosition;
        }).forEach((cPosition) -> {
            aryPositionsIndexes.add(cPosition.getCode());
        });
    }
    
    @Override
    
    /* 
        Between this method we can show the panel for checking a new user in 
    */
    public void changeUserAdd(CardLayout crdCard, JPanel pnlPanel, JComboBox cbxGender, JComboBox cbxPosition, JLabel lblTitle, JButton btnRegister) {
        crdCard.show(pnlPanel, "pnlUserAdd");        
        lblTitle.setText("REGISTRO DE NUEVO USUARIO");
        btnRegister.setText("Registrar");
        
        cbxGender.removeAllItems();
        cbxPosition.removeAllItems();
        
        fill(cbxGender, cbxPosition);
    }
    
    @Override
    public void changeUserSearch(CardLayout crdCard, JPanel pnlPanel) {
        crdCard.show(pnlPanel, "pnlUserSearch");
    }
    
    @Override
    public void changeUserShow(CardLayout crdCard, JPanel pnlPanel, JTable tblTable) {
        crdCard.show(pnlPanel, "pnlUserShow");
        
        List <Users> aryUsers = new ArrayList <Users> ();
        aryUsers = (new Users()).getList(2, null, null, null);
        
        DefaultTableModel cModel = (DefaultTableModel) tblTable.getModel();
        cModel.getDataVector().removeAllElements();
        
        aryUsers.stream().forEach((cUser) -> {
            cModel.addRow(new Object[]{cUser.getName(), cUser.getFatherLastName(), cUser.getMotherLastName(), cUser.getPositionCode(), cUser.getNi(), cUser.getCellphone(), cUser.geteMail()});
        });
    }
    
    @Override
    public void actUser(int iOption, String strCode, JTextField txtName, JTextField txtFatherLastName, JTextField txtMotherLastName, JTextField txtNi, 
            JComboBox cbxGender, JTextField txtAddress, JComboBox cbxPosition, JTextField txtCellphone, JTextField txtEmail,
            JTextField txtEmergencyNumber, JTextArea txaOthers){
        Users cUser = new Users();
        
        cUser.setCode(strCode);
        cUser.setName(txtName.getText());
        cUser.setFatherLastName(txtFatherLastName.getText());
        cUser.setMotherLastName(txtMotherLastName.getText());
        cUser.setNi(txtNi.getText());
        cUser.setGenderCode(aryGendersIndexes.get(cbxGender.getSelectedIndex()));
        cUser.setAddress(txtAddress.getText());
        cUser.setPositionCode(aryPositionsIndexes.get(cbxPosition.getSelectedIndex()));
        cUser.setCellphone(txtCellphone.getText());
        cUser.seteMail(txtEmail.getText());
        cUser.setEmergencyCell(txtEmergencyNumber.getText());
        cUser.setOther(txaOthers.getText());
        
        String strError = "";
        
        switch(iOption){
            case 0: String id = "";
                    String password = "";
                    id =    txtName.getText().toUpperCase().substring(0,2) + 
                            txtNi.getText().substring(0, 2) + 
                            txtFatherLastName.getText().toUpperCase().substring(0, 2) +
                            txtCellphone.getText().substring(0, 2) +
                            txtMotherLastName.getText().toUpperCase().substring(0, 2);
                    password =  txtName.getText().toUpperCase().substring(0,1) + 
                                txtNi.getText().toUpperCase().substring(2,6) + 
                                txtCellphone.getText().substring(3, 7) + 
                                txtFatherLastName.getText().toUpperCase().substring(0, 1);
                    cUser.setId(id);
                    cUser.setPassword(password);
                    cUser.setState("1");
                    
                    strError = cUser.insert();
                    if(strError.length() == 0) {
                        StringBuilder strValue = new StringBuilder(500);
                        strValue.append("Se ha generado su Id y su Contraseña para");
                        strValue.append(NEXTLINE);
                        strValue.append("poder ingresar al Sistema de Ventas: ");
                        strValue.append(NEXTLINE);
                        strValue.append(NEXTLINE);
                        strValue.append("  Id de Usuario: ");
                        strValue.append(id);
                        strValue.append(NEXTLINE);
                        strValue.append("  Contraseña: ");
                        strValue.append(password);
                        
                        JOptionPane.showMessageDialog(  null, 
                                                        String.valueOf(strValue), 
                                                        "Nuevo Usuario", 
                                                        JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(  null, 
                                                        strError, 
                                                        "Nuevo Usuario", 
                                                        JOptionPane.WARNING_MESSAGE);
                    }
                    break;
            case 1: strError = cUser.update();
                    if(strError.length() == 0) {
                        JOptionPane.showMessageDialog(  null, 
                                                        "Los datos han sido modificados correctamente.", 
                                                        "Modificar Usuario", 
                                                        JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(  null, 
                                                        strError, 
                                                        "Nuevo Usuario", 
                                                        JOptionPane.WARNING_MESSAGE);
                    }
                    break;
            
            default:    JOptionPane.showMessageDialog(null, "Default Option");
                        break;
        }             
    }
    
    @Override
    public List <String> searchUser(JTextField txtName, JTable tblTable) {
        String strName = txtName.getText();
        
        if("Ingrese Nombre de Usuario".equals(txtName.getText())) {
            strName = "";
        }
        
        List <Users> aryUsers = new ArrayList <Users> ();
        aryUsers = (new Users()).getList(3, null, null, strName);
        List <String> aryUsersIndexes = new ArrayList <String>();
        
        if(!aryUsers.isEmpty()) {            
            DefaultTableModel cModel = (DefaultTableModel) tblTable.getModel();
            cModel.getDataVector().removeAllElements();
            
            aryUsers.stream().map((cUser) -> {
                cModel.addRow(new Object[]{cUser.getName() + " " + cUser.getFatherLastName(), cUser.getPositionCode(), cUser.getCellphone()});
                return cUser;
            }).forEach((cUser) -> {
                aryUsersIndexes.add(cUser.getCode());
            });
        } else {
            JOptionPane.showMessageDialog(  null,
                                            "No hay usuarios registrados con el Nombre: " + txtName.getText(), 
                                            "Resultado Vacío", 
                                            JOptionPane.INFORMATION_MESSAGE);
        }
        
        return aryUsersIndexes;
    }
    
    @Override
    public String send(CardLayout crdCard, JPanel pnlPanel, String strCode, JLabel lblTitle, JTextField txtName, JTextField txtFatherLastName, JTextField txtMotherLastName, JTextField txtNi, 
            JComboBox cbxGender, JTextField txtAddress, JComboBox cbxPosition, JTextField txtCellphone, JTextField txtEmail,
            JTextField txtEmergencyNumber, JTextArea txaOthers, JButton btnModify) {
        crdCard.show(pnlPanel, "pnlUserAdd");
        lblTitle.setText("MODIFICACIÓN DE USUARIO");
        btnModify.setText("Actualizar");
        
        List <Users> aryUser = new ArrayList <Users> ();
        aryUser = (new Users()).getList(1, null, strCode, null);
        
        txtName.setText(aryUser.get(0).getName());
        txtFatherLastName.setText(aryUser.get(0).getFatherLastName());
        txtMotherLastName.setText(aryUser.get(0).getMotherLastName());
        txtNi.setText(aryUser.get(0).getNi());
        txtAddress.setText(aryUser.get(0).getAddress());
        txtCellphone.setText(aryUser.get(0).getCellphone());
        txtEmail.setText(aryUser.get(0).geteMail());
        txtEmergencyNumber.setText(aryUser.get(0).getEmergencyCell());
        txaOthers.setText(aryUser.get(0).getOther());
        
        cbxGender.removeAllItems();
        cbxPosition.removeAllItems();
        
        fill(cbxGender, cbxPosition);
                
        cbxGender.setSelectedIndex(aryGendersIndexes.indexOf(aryUser.get(0).getGenderCode()));
        cbxPosition.setSelectedIndex(aryPositionsIndexes.indexOf(aryUser.get(0).getPositionCode()));
        
        return aryUser.get(0).getCode();
    }
}
