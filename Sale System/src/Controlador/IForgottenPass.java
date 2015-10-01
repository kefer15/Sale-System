package Controlador;

import javax.swing.JTextField;

public interface IForgottenPass {
    boolean send(JTextField txtId, JTextField txtEmail);
    void comeBack();
}
