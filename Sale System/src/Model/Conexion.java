package Model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
  @version 2.3
  @author Miguel Fernández
 */

public class Conexion {
    private Connection cCon;
    private String strDatabase;
    private String cUser;
    private String strPassword;

    public Conexion(String strDatabase, String strUser, String strPassword)     {
        this.strDatabase = strDatabase;
        this.cUser = strUser;
        this.strPassword = strPassword;
    }
    
    /** Between this method we get DataBase's name
     * @return  */
    public String getDatabase() {
        return strDatabase;
    }
    
    /**
     * 
     * @param strDatabase 
     */
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
            StringBuilder strValue = new StringBuilder();
            strValue.append("jdbc:mysql://localhost:3306/");
            strValue.append(strDatabase);
            
            Class.forName("com.mysql.jdbc.Driver");
            cCon = (Connection) DriverManager.getConnection(String.valueOf(strValue), cUser, strPassword);
        } catch (ClassNotFoundException | SQLException cException) {
            StringBuilder strValue = new StringBuilder();
            strValue.append("Access denied for User: ");
            strValue.append(cUser);
            strValue.append(", Password: ");
            strValue.append(strPassword);
            strValue.append(". Configure DB connection.");
            
            JOptionPane.showMessageDialog(null, String.valueOf(strValue), "Connection Error", JOptionPane.ERROR_MESSAGE);
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
            StringBuilder strValue = new StringBuilder();
            strValue.append("Access denied for User: ");
            strValue.append(cUser);
            strValue.append(", Password: ");
            strValue.append(strPassword);
            strValue.append(". Configure DB connection.");
            
            JOptionPane.showMessageDialog(null, String.valueOf(strValue), "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}