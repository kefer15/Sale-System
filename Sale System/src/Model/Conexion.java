package Model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion
{
    private Connection cCon;
    private String strDatabase;
    private String cUser;
    private String strPassword;

    public Conexion(String strDatabase, String strUser, String strPassword)     {
        this.strDatabase = strDatabase;
        this.cUser = strUser;
        this.strPassword = strPassword;
    }

    public String getDatabase() {
        return strDatabase;
    }

    public void setDatabase(String strDatabase) {
        this.strDatabase = strDatabase;
    }

    public String getUser() {
        return cUser;
    }

    public void setUser(String strUser) {
        this.cUser = strUser;
    }

    public String getPassword() {
        return strPassword;
    }

    public void setPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public void conect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cCon = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/" + strDatabase, cUser, strPassword);
        } catch (ClassNotFoundException | SQLException cException) {
            JOptionPane.showMessageDialog(null, "Access denied for User: " + cUser + ", Password: " + strPassword + ". Configure DB connection.", "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public ResultSet receive(String strConsult) throws SQLException {
        Statement cStat = (Statement) cCon.createStatement();
        return cStat.executeQuery(strConsult);
    }
    
    public void send(String strConsult) throws SQLException {
        PreparedStatement cPreparedStmt = cCon.prepareStatement(strConsult);
        cPreparedStmt.execute();
    }
    
    public void disconect() {
        try {
            cCon.close();
        }
        catch (SQLException | NullPointerException cException) {
            JOptionPane.showMessageDialog(null, "Access denied for User: " + cUser + ", Password: " + strPassword + ". Configure DB connection.", "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}