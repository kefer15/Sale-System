package Controlador;

import Modelo.Gender;
import Modelo.Position;
import Modelo.Users;
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
    private ArrayList <Gender> genders;
    private ArrayList <Position> positions;
    private ArrayList <String> gendersInd;
    private ArrayList <String> positionsInd;
    
    public CUsers(){
        genders = (new Gender()).getList();
        positions = (new Position()).getList();
        gendersInd = new ArrayList <> ();
        positionsInd = new ArrayList <> ();
    }
    
    private void fill(JComboBox gender, JComboBox position){
        for (Gender genderAux : genders) {
            gender.addItem(genderAux.getDescription());
            gendersInd.add(genderAux.getCode());
        }
        
        for (Position positionAux : positions) {
            position.addItem(positionAux.getDescription());
            positionsInd.add(positionAux.getCode());
        }
    }
    
    @Override
    public void changeUserAdd(CardLayout card, JPanel panel, JComboBox gender, JComboBox position, JLabel title, JButton register){
        card.show(panel, "pnlUserAdd");
        
        title.setText("REGISTRO DE NUEVO USUARIO");
        register.setText("Registrar");
        
        gender.removeAllItems();
        position.removeAllItems();
        
        fill(gender, position);
    }
    
    @Override
    public void changeUserSearch(CardLayout card, JPanel panel){
        card.show(panel, "pnlUserSearch");
    }
    
    @Override
    public void changeUserShow(CardLayout card, JPanel panel, JTable table){
        card.show(panel, "pnlUserShow");
        
        ArrayList <Users> users = (new Users()).getList(2, null, null, null);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.getDataVector().removeAllElements();
        
        for (Users user : users) {
            model.addRow(new Object[]{user.getCode(), user.getName(), user.getFatherLastName(), user.getMotherLastName(), user.getPositionCode(), user.getNi(), user.getCellphone(), user.geteMail(), user.getGenderCode()});
        }
    }
    
    @Override
    public void actUser(int option, String code, JTextField name, JTextField fatherLastName, JTextField motherLastName, JTextField ni, 
            JComboBox gender, JTextField address, JComboBox position, JTextField cellphone, JTextField eMail,
            JTextField emergencyNumber, JTextArea others){
        
        Users user = new Users();
        
        user.setCode(code);
        user.setName(name.getText());
        user.setFatherLastName(fatherLastName.getText());
        user.setMotherLastName(motherLastName.getText());
        user.setNi(ni.getText());
        user.setGenderCode(gendersInd.get(gender.getSelectedIndex()));
        user.setAddress(address.getText());
        user.setPositionCode(positionsInd.get(position.getSelectedIndex()));
        user.setCellphone(cellphone.getText());
        user.seteMail(eMail.getText());
        user.setEmergencyCell(emergencyNumber.getText());
        user.setOther(others.getText());
        
        String error = "";
        
        switch(option){
            case 0: String id = "", password = "";
                    try {
                        id = name.getText().substring(0,2) + fatherLastName.getText().substring(0,2) + ni.getText().substring(3,5) + eMail.getText().substring(0,2) + ni.getText().substring(3,5);
                        password = id.substring(0,2) + cellphone.getText().substring(5,6) + id.substring(7,9);
                    } catch(StringIndexOutOfBoundsException ex) {
                        id = name.getText() + fatherLastName.getText();
                        password = cellphone.getText();
                    }
                    
                    user.setId(id);
                    user.setPassword(password);
                    user.setState("1");
                    error = user.insert();
                    if(error.equals(""))
                        JOptionPane.showMessageDialog(  null, 
                                                        "Se ha generado su Id y su Contraseña para \npoder ingresar al Sistema de Ventas: "
                                                                + "\n\n  Id de Usuario: " + id + "\n  Contraseña: " + password, 
                                                        "Nuevo Usuario", 
                                                        JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(  null, 
                                                        error, 
                                                        "Nuevo Usuario", 
                                                        JOptionPane.WARNING_MESSAGE);
                    break;
            case 1: error = user.update();
                    if(error.equals(""))
                        JOptionPane.showMessageDialog(  null, 
                                                        "Los datos han sido modificados correctamente.", 
                                                        "Modificar Usuario", 
                                                        JOptionPane.INFORMATION_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(  null, 
                                                        error, 
                                                        "Nuevo Usuario", 
                                                        JOptionPane.WARNING_MESSAGE);
                    break;
        }             
    }
    
    @Override
    public ArrayList <String> searchUser(JTextField name, JTable table){
        ArrayList <String> usersInd = new ArrayList <>();
        ArrayList <Users> users = (new Users()).getList(3, null, null, name.getText());
        
        if(!users.isEmpty()) {            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.getDataVector().removeAllElements();
            for (Users user : users) {
                model.addRow(new Object[]{user.getName() + " " + user.getFatherLastName(), user.getPositionCode(), user.getCellphone()});
                usersInd.add(user.getCode());
            }
        } else
            JOptionPane.showMessageDialog(  null,
                                            "No hay usuarios para mostrar.", 
                                            "Resultado Vacío", 
                                            JOptionPane.INFORMATION_MESSAGE);
        
        return usersInd;
    }
    
    @Override
    public String sent(CardLayout card, JPanel panel, String code, JLabel title, JTextField name, JTextField fatherLastName, JTextField motherLastName, JTextField ni, 
            JComboBox gender, JTextField address, JComboBox position, JTextField cellphone, JTextField eMail,
            JTextField emergencyNumber, JTextArea others, JButton modify){
        card.show(panel, "pnlUserAdd");
        ArrayList <Users> user = (new Users()).getList(1, null, code, null);
        
        title.setText("MODIFICACIÓN DE USUARIO");
        modify.setText("Actualizar");
        name.setText(user.get(0).getName());
        fatherLastName.setText(user.get(0).getFatherLastName());
        motherLastName.setText(user.get(0).getMotherLastName());
        ni.setText(user.get(0).getNi());
        address.setText(user.get(0).getAddress());
        cellphone.setText(user.get(0).getCellphone());
        eMail.setText(user.get(0).geteMail());
        emergencyNumber.setText(user.get(0).getEmergencyCell());
        others.setText(user.get(0).getOther());
        
        gender.removeAllItems();
        position.removeAllItems();
        
        fill(gender, position);
                
        gender.setSelectedIndex(gendersInd.indexOf(user.get(0).getGenderCode()));
        position.setSelectedIndex(positionsInd.indexOf(user.get(0).getPositionCode()));
        
        return user.get(0).getCode();
    }
}
