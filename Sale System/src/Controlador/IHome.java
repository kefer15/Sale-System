package Controlador;

import Modelo.Users;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public interface IHome {
    public Users logIn(JTextField id, JPasswordField pass);
    public void activate(int code, JButton home, JButton users, JButton suppliers, JButton products, JButton store, JButton sale);
}
