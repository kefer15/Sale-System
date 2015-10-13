package Controlator;

import Interface.IForgottenPass;
import Model.Users;
import View.UIForgottenPass;
import java.util.ArrayList;
import java.util.Properties;
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

    private final UIForgottenPass wdForgottenPass;
    
    CForgottenPass(String User) {
        wdForgottenPass = new UIForgottenPass(this, User);
    }
    
    @Override
    public boolean Send(JTextField txtIdentifier, JTextField txtEmail) {
        ArrayList <Users> aryUser = (new Users()).getList(0, txtIdentifier.getText(), null, null);
        
        if(aryUser.isEmpty()){
            JOptionPane.showMessageDialog(  null,
                                            "No existe usuario con el Id ingresado, inténtelo de nuevo.",
                                            "Usuario Incorrecto",
                                            JOptionPane.ERROR_MESSAGE);
        } else {
            if(!aryUser.get(0).geteMail().equals(txtEmail.getText())){
                JOptionPane.showMessageDialog(  null,
                                                "El e-mail ingresado no corresponde al Usuario registrado, inténtelo de nuevo.",
                                                "E-Mail Incorrecto",
                                                JOptionPane.ERROR_MESSAGE);
            } else {
                try {
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
                    return true;
                } catch (MessagingException cException) {
                    JOptionPane.showMessageDialog(  null,
                                                    "Revise su conexión a Internet, hubo problemas al envia el mensaje. Inténtelo de nuevo.",
                                                    "Mensaje No Enviado",
                                                    JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        
        return false;
    }
    
    @Override
    public void comeBack() {
        wdForgottenPass.dispose();
        CMain cMain = new CMain(0);
    }
}
