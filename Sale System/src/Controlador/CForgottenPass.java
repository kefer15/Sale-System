package Controlador;

import Modelo.Users;
import Vista.UIForgottenPass;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class CForgottenPass implements IForgottenPass{

    private UIForgottenPass forgottenPass;
    
    CForgottenPass(String user) {
        forgottenPass = new UIForgottenPass(this, user);
    }
    
    @Override
    public void comeBack(){
        forgottenPass.dispose();
        CMain main = new CMain(0);
    }
    
    @Override
    public boolean send(JTextField txtId, JTextField txtEmail){
        ArrayList <Users> user = (new Users()).getList(0, txtId.getText(), null, null);
        
        if(user.isEmpty()){
            JOptionPane.showMessageDialog(  null,
                                            "No existe usuario con el Id ingresado, inténtelo de nuevo.",
                                            "Usuario Incorrecto",
                                            JOptionPane.ERROR_MESSAGE);
        } else {
            if(!user.get(0).geteMail().equals(txtEmail.getText())){
                JOptionPane.showMessageDialog(  null,
                                                "El e-mail ingresado no corresponde al Usuario registrado, inténtelo de nuevo.",
                                                "E-Mail Incorrecto",
                                                JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    Properties mailServerProperties = System.getProperties();
                    mailServerProperties.put("mail.smtp.host", "smtp.gmail.com");
                    mailServerProperties.put("mail.smtp.socketFactory.port", "465");
                    mailServerProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                    mailServerProperties.put("mail.smtp.auth", "true");
                    mailServerProperties.put("mail.smtp.port", "465");

                    Session getMailSession = Session.getDefaultInstance(
                            mailServerProperties,
                            new javax.mail.Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication("sisventieaba@gmail.com", "svta1234svta");
                                }
                            });

                    MimeMessage generateMailMessage = new MimeMessage(getMailSession);
                    generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(user.get(0).geteMail()));

                    generateMailMessage.setSubject("SVTA: Recuperar Contraseña");

                    String bodyEmail =  "<font face=arial color=black> Usted ha solicitado información de su contraseña para iniciar sesión en SVTA.<br/><br/>" +
                                        "Nombre de usuario: " + user.get(0).getId() + "<br/>" +
                                        "Contraseña: " + user.get(0).getPassword() + "<br/><br/>" +
                                        "Equipo del Sistema de Ventas para una Tienda de Abarrotes (SVTA).<br/> </font>";
                    
                    generateMailMessage.setContent(bodyEmail, "text/html");

                    Transport.send(generateMailMessage);
                    return true;
                } catch (MessagingException ex) {
                    JOptionPane.showMessageDialog(  null,
                                                "Revise su conexión a Internet, hubo problemas al envia el mensaje. Inténtelo de nuevo.",
                                                "Mensaje No Enviado",
                                                JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
        return false;
    }
}
