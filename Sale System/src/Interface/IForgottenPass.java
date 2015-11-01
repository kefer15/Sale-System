package Interface;

import javax.swing.JLabel;
import javax.swing.JTextField;

public interface IForgottenPass {
    /* Sends a message to get user's password back to his Email */
    boolean Send(JTextField txtIdentifier, JTextField txtEmail, JLabel txtSending);
    
    /* Returns to the main menu */    
    void comeBack();
}
