package Controlator;

import Interface.IForgottenPass;

import Model.Users;

import View.UIForgottenPass;

import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

public class CForgottenPass implements IForgottenPass{

    private final UIForgottenPass wdForgottenPass;
    
    CForgottenPass(String User) {
        wdForgottenPass = new UIForgottenPass(this, User);
    }
    
    @Override
    /** Between this method we can sent an e-mail to the user who forgets his password */
    public boolean send(JTextField txtIdentifier, JTextField txtEmail, JLabel lblSending) {
        ArrayList <Users> aryUser = new ArrayList <Users> ();
        aryUser = (new Users()).getList(0, txtIdentifier.getText(), null, null);
        
        if(aryUser.isEmpty()){
            lblSending.setText("");
            JOptionPane.showMessageDialog(  null,
                                            "No existe usuario con el Id ingresado, inténtelo de nuevo.",
                                            "Usuario Incorrecto",
                                            JOptionPane.ERROR_MESSAGE);
        } else {
            if(!aryUser.get(0).geteMail().equals(txtEmail.getText())){
                lblSending.setText("");
                JOptionPane.showMessageDialog(  null,
                                                "El correo electrónico ingresado no corresponde al Usuario registrado, inténtelo de nuevo.",
                                                "Correo Electrónico Incorrecto",
                                                JOptionPane.ERROR_MESSAGE);
            } else {
                lblSending.setText("Enviando ...");
                try {
                    Thread.sleep(4000);
                    Properties cMailServerProperties = System.getProperties();
                    cMailServerProperties.put("mail.smtp.host", "smtp.gmail.com");
                    cMailServerProperties.put("mail.smtp.socketFactory.port", "465");
                    cMailServerProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    cMailServerProperties.put("mail.smtp.auth", "true");
                    cMailServerProperties.put("mail.smtp.port", "465");

                    Session cMailSession = Session.getDefaultInstance(
                            cMailServerProperties,
                            new javax.mail.Authenticator() {
                                @Override
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication("sisventieaba@gmail.com", "svta1234svta");
                                }
                            });

                    MimeMessage cMailMessage = new MimeMessage(cMailSession);
                    cMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(aryUser.get(0).geteMail()));

                    cMailMessage.setSubject("SVTA: Recuperar Contraseña");

                    String strBodyEmail =  "<font face=arial color=black> Usted ha solicitado información de su contraseña para iniciar sesión en SVTA.<br/><br/>" +
                                        "Nombre de usuario: " + aryUser.get(0).getId() + "<br/>" +
                                        "Contraseña: " + aryUser.get(0).getPassword() + "<br/><br/>" +
                                        "Equipo del Sistema de Ventas para una Tienda de Abarrotes (SVTA).<br/> </font>";
                    
                    cMailMessage.setContent(strBodyEmail, "text/html");
                    
                    Transport.send(cMailMessage);
                    lblSending.setText("");
                    return true;
                } catch (MessagingException cException) {
                    lblSending.setText("");
                    JOptionPane.showMessageDialog(  null,
                                                    "Revise su conexión a Internet, hubo problemas al enviar el mensaje. Inténtelo de nuevo.",
                                                    "Mensaje No Enviado",
                                                    JOptionPane.WARNING_MESSAGE);
                } catch (InterruptedException cException) {
                    lblSending.setText("");
                    Logger.getLogger(CForgottenPass.class.getName()).log(Level.SEVERE, null, cException);
                }
            }
        }
        
        return false;
    }
    
    @Override
    public void comeBack() {
        wdForgottenPass.dispose();
        new CMain(0);
    }
}
