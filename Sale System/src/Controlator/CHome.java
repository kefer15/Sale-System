package Controlator;

import Interface.IHome;

import Model.Users;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
  @version 2.3
  @author Miguel Fernandez
 */

public class CHome implements IHome
{
    @Override
    
    /* 
        Between this method we can validate and give access to users 
    */
    public Users logIn(JTextField txtId, JPasswordField txtPass) {              
        Users cUser = null;
        if(txtId.getText().length() == 0 || 0 == txtPass.getPassword().length)
        {
            JOptionPane.showMessageDialog(  null,
                                            "Ingrese su 'Id de Usuario' y su 'Contraseña'",
                                            "Campos Vacíos",
                                            JOptionPane.ERROR_MESSAGE);
        } else {
            String password = String.valueOf(txtPass.getPassword());
            List <Users> aryUserLoged = new ArrayList <Users> ();
            aryUserLoged = (new Users()).getList(0, txtId.getText(), null, null);
           
            if(!aryUserLoged.isEmpty()) {
                if(aryUserLoged.get(0).getPassword().equals(password)) {
                    cUser = aryUserLoged.get(0);
                } else {
                        JOptionPane.showMessageDialog(  null,
                                                        "Contraseña ingresada incorrecta, inténtelo de nuevo",
                                                        "Valores Incorrectos",
                                                        JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(  null,
                                                "Id de Usuario '" + txtId.getText() + "' no existe, inténtelo de nuevo",
                                                "Valores Incorrectos",
                                                JOptionPane.ERROR_MESSAGE);
            }
        }
        
        return cUser;
    }
    
    @Override
    public void activate(int iCode, JButton btnHome, JButton btnUsers, JButton btnSuppliers, JButton btnProducts, JButton btnStore, JButton btnSsale){
        btnHome.setEnabled(false);
        if(2 == iCode) {
            btnSsale.setEnabled(true);
        } else {
            btnUsers.setEnabled(true);
            btnSuppliers.setEnabled(true);
            btnProducts.setEnabled(true);
            btnStore.setEnabled(true);
        }
    }
}