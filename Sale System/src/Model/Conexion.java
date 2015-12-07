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
  @author Miguel Fernandez
 */

public class Conexion {
    private final int MAX = 500;
    private Connection cCon;
    private String strDatabase;
    private String cUser;
    private String strPassword;
    
    /**
     * 
     * @param strDatabase
     * @param strUser
     * @param strPassword 
     */
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
    
    /**
     * 
     * @return 
     */
    public String getUser() {
        return cUser;
    }
    
    /**
     * 
     * @param strUser 
     */
    public void setUser(String strUser) {
        this.cUser = strUser;
    }
    
    /**
     * 
     * @return 
     */
    public String getPassword() {
        return strPassword;
    }
    
    /**
     * 
     * @param strPassword 
     */
    public void setPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public void conect() {
        try {
            StringBuilder strValue = new StringBuilder(MAX);
            strValue.append("jdbc:mysql://localhost:3306/");
            strValue.append(strDatabase);
            
            Class.forName("com.mysql.jdbc.Driver");
            cCon = (Connection) DriverManager.getConnection(String.valueOf(strValue), cUser, strPassword);
        } catch (ClassNotFoundException | SQLException cException) {
            StringBuilder strValue = new StringBuilder(MAX);
            strValue.append("Access denied for User: ");
            strValue.append(cUser);
            strValue.append(", Password: ");
            strValue.append(strPassword);
            strValue.append(". Configure DB connection.");
            
            JOptionPane.showMessageDialog(null, String.valueOf(strValue), "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * 
     * @param strConsult
     * @return
     * @throws SQLException 
     */
    public ResultSet receive(String strConsult) throws SQLException {
        Statement cStat = (Statement) cCon.createStatement();
        return cStat.executeQuery(strConsult);
    }
    
    /**
     * 
     * @param strConsult
     * @throws SQLException 
     */
    public void send(String strConsult) throws SQLException {
        PreparedStatement cPreparedStmt = cCon.prepareStatement(strConsult);
        cPreparedStmt.execute();
    }
    
    public void disconect() {
        try {
            cCon.close();
        }
        catch (SQLException | NullPointerException cException) {
            StringBuilder strValue = new StringBuilder(MAX);
            strValue.append("Access denied for User: ");
            strValue.append(cUser);
            strValue.append(", Password: ");
            strValue.append(strPassword);
            strValue.append(". Configure DB connection.");
            
            JOptionPane.showMessageDialog(null, String.valueOf(strValue), "Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}