package Controlator;

import Interface.IUsers;

import Model.Gender;
import Model.Position;
import Model.Users;

import java.awt.CardLayout;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class CUsers implements IUsers {
    private final ArrayList <Gender> ARYGENDERS;
    private final ArrayList <Position> ARYPOSITIONS;
    private final ArrayList <String> ARYGENDERSINDEXES;
    private final ArrayList <String> ARYPOSITIONSINDEXES;
    
    /*
        The constructor fills aryGenders with all Categorigies available, and
        fills aryPositions with all Positions avaliable.
        Initializes aryGendersIndexes and aryPositionsIndexes.
    */
    public CUsers() {
        ARYGENDERS = (new Gender()).getList();
        ARYPOSITIONS = (new Position()).getList();
        ARYGENDERSINDEXES = new ArrayList <> ();
        ARYPOSITIONSINDEXES = new ArrayList <> ();
    }
    
    /*
        Fills all Genders into cbxGender and links the información of each register with 
        each index of aryGendersIndexes.
        Fills all Positions into cbxPosition and links the información of each register with 
        each index of aryPositionsIndexes.
    */
    private void fill(JComboBox cbxGender, JComboBox cbxPosition) {
        ARYGENDERS.stream().map((cGender) -> {
            cbxGender.addItem(cGender.getDescription());
            return cGender;
        }).forEach((cGender) -> {
            ARYGENDERSINDEXES.add(cGender.getCode());
        });
        
        ARYPOSITIONS.stream().map((cPosition) -> {
            cbxPosition.addItem(cPosition.getDescription());
            return cPosition;
        }).forEach((cPosition) -> {
            ARYPOSITIONSINDEXES.add(cPosition.getCode());
        });
    }
    
    @Override
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
        
        ArrayList <Users> aryUsers = (new Users()).getList(2, null, null, null);
        
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
        cUser.setGenderCode(ARYGENDERSINDEXES.get(cbxGender.getSelectedIndex()));
        cUser.setAddress(txtAddress.getText());
        cUser.setPositionCode(ARYPOSITIONSINDEXES.get(cbxPosition.getSelectedIndex()));
        cUser.setCellphone(txtCellphone.getText());
        cUser.seteMail(txtEmail.getText());
        cUser.setEmergencyCell(txtEmergencyNumber.getText());
        cUser.setOther(txaOthers.getText());
        
        String strError;
        
        switch(iOption){
            case 0: String id, password;
                    id = txtName.getText().toUpperCase() + txtNi.getText().substring(0,2) + txtMotherLastName.getText().toUpperCase().substring(0, 2);
                    password = txtFatherLastName.getText().toUpperCase().substring(0,2) + txtCellphone.getText().substring(4,7) + id.substring(0,3);
            /*try {
                        
                    } catch(StringIndexOutOfBoundsException cException) {
                        id = txtName.getText() + txtFatherLastName.getText();
                        password = txtCellphone.getText();
                    }*/
                    
                    cUser.setId(id);
                    cUser.setPassword(password);
                    cUser.setState("1");
                    
                    strError = cUser.insert();
                    if(strError.equals(""))
                        JOptionPane.showMessageDialog(  null, 
                                                        "Se ha generado su Id y su Contraseña para \npoder ingresar al Sistema de Ventas: "
                                                                + "\n\n  Id de Usuario: " + id + "\n  Contraseña: " + password, 
                                                        "Nuevo Usuario", 
                                                        JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(  null, 
                                                        strError, 
                                                        "Nuevo Usuario", 
                                                        JOptionPane.WARNING_MESSAGE);
                    break;
            case 1: strError = cUser.update();
                    if(strError.equals(""))
                        JOptionPane.showMessageDialog(  null, 
                                                        "Los datos han sido modificados correctamente.", 
                                                        "Modificar Usuario", 
                                                        JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(  null, 
                                                        strError, 
                                                        "Nuevo Usuario", 
                                                        JOptionPane.WARNING_MESSAGE);
                    break;
        }             
    }
    
    @Override
    public ArrayList <String> searchUser(JTextField txtName, JTable tblTable) {
        String strName = (txtName.getText().equals("Ingrese Nombre de Usuario"))?"":txtName.getText();
        ArrayList <Users> aryUsers = (new Users()).getList(3, null, null, strName);
        ArrayList <String> aryUsersIndexes = new ArrayList <>();
        
        if(!aryUsers.isEmpty()) {            
            DefaultTableModel cModel = (DefaultTableModel) tblTable.getModel();
            cModel.getDataVector().removeAllElements();
            
            aryUsers.stream().map((cUser) -> {
                cModel.addRow(new Object[]{cUser.getName() + " " + cUser.getFatherLastName(), cUser.getPositionCode(), cUser.getCellphone()});
                return cUser;
            }).forEach((cUser) -> {
                aryUsersIndexes.add(cUser.getCode());
            });
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No hay usuarios registrados con el Nombre: " + txtName.getText(), 
                                            "Resultado Vacío", 
                                            JOptionPane.INFORMATION_MESSAGE);
        
        return aryUsersIndexes;
    }
    
    @Override
    public String send(CardLayout crdCard, JPanel pnlPanel, String strCode, JLabel lblTitle, JTextField txtName, JTextField txtFatherLastName, JTextField txtMotherLastName, JTextField txtNi, 
            JComboBox cbxGender, JTextField txtAddress, JComboBox cbxPosition, JTextField txtCellphone, JTextField txtEmail,
            JTextField txtEmergencyNumber, JTextArea txaOthers, JButton btnModify) {
        crdCard.show(pnlPanel, "pnlUserAdd");
        lblTitle.setText("MODIFICACIÓN DE USUARIO");
        btnModify.setText("Actualizar");
        
        ArrayList <Users> user = (new Users()).getList(1, null, strCode, null);
        
        txtName.setText(user.get(0).getName());
        txtFatherLastName.setText(user.get(0).getFatherLastName());
        txtMotherLastName.setText(user.get(0).getMotherLastName());
        txtNi.setText(user.get(0).getNi());
        txtAddress.setText(user.get(0).getAddress());
        txtCellphone.setText(user.get(0).getCellphone());
        txtEmail.setText(user.get(0).geteMail());
        txtEmergencyNumber.setText(user.get(0).getEmergencyCell());
        txaOthers.setText(user.get(0).getOther());
        
        cbxGender.removeAllItems();
        cbxPosition.removeAllItems();
        
        fill(cbxGender, cbxPosition);
                
        cbxGender.setSelectedIndex(ARYGENDERSINDEXES.indexOf(user.get(0).getGenderCode()));
        cbxPosition.setSelectedIndex(ARYPOSITIONSINDEXES.indexOf(user.get(0).getPositionCode()));
        
        return user.get(0).getCode();
    }
}
