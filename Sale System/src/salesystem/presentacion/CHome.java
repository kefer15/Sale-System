package salesystem.presentacion;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import salesystem.negocio.Main;

public class CHome
{
    public boolean reconectar(JTextField user, JTextField pass)
    {
        if(user.getText().equals("") || pass.getText().equals(""))
        {
            JOptionPane.showMessageDialog(  null,
                                            "Please provide a username and password",
                                            "Empty Fields",
                                            JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else
        {
            int selectedOption = JOptionPane.showConfirmDialog( null, 
                                                                "Confirm user and password change", 
                                                                "Confirm", 
                                                                JOptionPane.YES_NO_OPTION); 
            if(selectedOption == JOptionPane.YES_OPTION)
            {
                Main.conexion.setUser(user.getText());
                Main.conexion.setPassword(pass.getText());
                Main.conexion.desconectar();
                return true;
            }
            else
                return false;
        }
    }
}
