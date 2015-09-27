package Controlador;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import Modelo.Users;
import java.util.ArrayList;

public class CHome implements IHome
{
    @Override
    public Users logIn(JTextField id, JPasswordField pass)
    {              
        if(id.getText().equals("") || pass.getPassword().length == 0)
        {
            JOptionPane.showMessageDialog(  null,
                                            "Ingrese su 'Id de Usuario' y su 'Contraseña'",
                                            "Campos Vacíos",
                                            JOptionPane.ERROR_MESSAGE);
            return null;
        }
        else
        {
            char[] var = pass.getPassword();
            String password = "";
            
            for(int i = 0;i < pass.getPassword().length;i++)
                password += var[i];
            
            ArrayList <Users> userLoged = (new Users()).getList(0, id.getText(), null, null);
           
            if(!userLoged.isEmpty())
                if(userLoged.get(0).getPassword().equals(password))
                    return userLoged.get(0);
                else {
                        JOptionPane.showMessageDialog(  null,
                                                        "Contraseña ingresada incorrecta, inténtelo de nuevo",
                                                        "Valores Incorrectos",
                                                        JOptionPane.ERROR_MESSAGE);
                            return null;
                }
            else
                JOptionPane.showMessageDialog(  null,
                                            "Id de Usuario '" + id.getText() + "' no existe, inténtelo de nuevo",
                                            "Valores Incorrectos",
                                            JOptionPane.ERROR_MESSAGE);
        }
        
        return null;
    }
    
    @Override
    public void activate(int code, JButton home, JButton users, JButton suppliers, JButton products, JButton store, JButton sale){
        home.setEnabled(false);
        switch(code){
            case 2:
                sale.setEnabled(true);
                break;
            default:
                users.setEnabled(true);
                suppliers.setEnabled(true);
                products.setEnabled(true);
                store.setEnabled(true);
        }
    }
}
