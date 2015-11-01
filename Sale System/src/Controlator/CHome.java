package Controlator;

import Interface.IHome;

import Model.Users;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CHome implements IHome
{
    @Override
    public Users logIn(JTextField txtId, JPasswordField txtPass) {              
        if(txtId.getText().equals("") || txtPass.getPassword().length == 0)
        {
            JOptionPane.showMessageDialog(  null,
                                            "Ingrese su 'Id de Usuario' y su 'Contraseña'",
                                            "Campos Vacíos",
                                            JOptionPane.ERROR_MESSAGE);
            return null;
        }
        else
        {
            char[] aVar = txtPass.getPassword();
            String password = "";
            
            for(int i = 0;i < txtPass.getPassword().length;i++)
                password += aVar[i];
            
            ArrayList <Users> aryUserLoged = (new Users()).getList(0, txtId.getText(), null, null);
           
            if(!aryUserLoged.isEmpty())
                if(aryUserLoged.get(0).getPassword().equals(password))
                    return aryUserLoged.get(0);
                else {
                        JOptionPane.showMessageDialog(  null,
                                                        "Contraseña ingresada incorrecta, inténtelo de nuevo",
                                                        "Valores Incorrectos",
                                                        JOptionPane.ERROR_MESSAGE);
                            return null;
                }
            else
                JOptionPane.showMessageDialog(  null,
                                                "Id de Usuario '" + txtId.getText() + "' no existe, inténtelo de nuevo",
                                                "Valores Incorrectos",
                                                JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
    
    @Override
    public void activate(int iCode, JButton btnHome, JButton btnUsers, JButton btnSuppliers, JButton btnProducts, JButton btnStore, JButton btnSsale){
        btnHome.setEnabled(false);
        
        switch(iCode){
            case 2:
                btnSsale.setEnabled(true);
                break;
            default:
                btnUsers.setEnabled(true);
                btnSuppliers.setEnabled(true);
                btnProducts.setEnabled(true);
                btnStore.setEnabled(true);
        }
    }
}