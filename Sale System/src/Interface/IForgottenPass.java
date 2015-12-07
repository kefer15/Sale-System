package Interface;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
  @version 2.3
  @author Miguel Fernández
 */

public interface IForgottenPass {
    
    /** Sends a message to get user's pass back to his Email
     * @param txtIdentifier
     * @param txtEmail
     * @param txtSending
     * @return  */
    boolean send(JTextField txtIdentifier, JTextField txtEmail, JLabel txtSending);
    
    /** 
        Returns to the main menu +
    */    
    void comeBack();
}
