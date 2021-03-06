package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
  @version 2.3
  @author Miguel Fernandez
 */

public class Users {
    private final int MAX = 500;
    private String strCode;
    private String strId;
    private String strPassword;
    private String strName;
    private String strFatherLastName;
    private String strMotherLastName;
    private String strNi;
    private String strGenderCode;
    private String strAddress;
    private String strPositionCode;
    private String strCellphone;
    private String strEmail;
    private String strEmergencyCell;
    private String strOther;
    private String strState;
    
    public Users() {
        this("-1","NULL","NULL","NULL","NULL","NULL","NULL","-1","NULL","-1","NULL","NULL","NULL","NULL","-1");
    }
    
    /**
     * 
     * @param strCode
     * @param strId
     * @param strPassword
     * @param strName
     * @param strFatherLastName
     * @param strMotherLastName
     * @param strNi
     * @param strGenderCode
     * @param strAddress
     * @param strPositionCode
     * @param strCellphone
     * @param strEmail
     * @param strEmergencyCell
     * @param strOther
     * @param strState 
     */
    public Users(String strCode, String strId, String strPassword, String strName, String strFatherLastName, String strMotherLastName, String strNi, String strGenderCode, String strAddress, String strPositionCode, String strCellphone, String strEmail, String strEmergencyCell, String strOther, String strState) {
        this.strCode = strCode;
        this.strId = strId;
        this.strPassword = strPassword;
        this.strName = strName;
        this.strFatherLastName = strFatherLastName;
        this.strMotherLastName = strMotherLastName;
        this.strNi = strNi;
        this.strGenderCode = strGenderCode;
        this.strAddress = strAddress;
        this.strPositionCode = strPositionCode;
        this.strCellphone = strCellphone;
        this.strEmail = strEmail;
        this.strEmergencyCell = strEmergencyCell;
        this.strOther = strOther;
        this.strState = strState;
    }
    
    /** Between this method we get the User's code
     * @return  */
    public String getCode() {
        return strCode;
    }
    
    /**
     * 
     * @param strCode 
     */
    public void setCode(String strCode) {
        this.strCode = strCode;
    }
    
    /**
     * 
     * @return 
     */
    public String getId() {
        return strId;
    }
    
    /**
     * 
     * @param strId 
     */
    public void setId(String strId) {
        this.strId = strId;
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
    
    /**
     * 
     * @return 
     */
    public String getName() {
        return strName;
    }
    
    /**
     * 
     * @param strName 
     */
    public void setName(String strName) {
        this.strName = strName;
    }
    
    /**
     * 
     * @return 
     */
    public String getFatherLastName() {
        return strFatherLastName;
    }
    
    /**
     * 
     * @param strFatherLastName 
     */
    public void setFatherLastName(String strFatherLastName) {
        this.strFatherLastName = strFatherLastName;
    }
    
    /**
     * 
     * @return 
     */
    public String getMotherLastName() {
        return strMotherLastName;
    }
    
    /**
     * 
     * @param strMotherLastName 
     */
    public void setMotherLastName(String strMotherLastName) {
        this.strMotherLastName = strMotherLastName;
    }
    
    /**
     * 
     * @return 
     */
    public String getNi() {
        return strNi;
    }
    
    /**
     * 
     * @param strNi 
     */
    public void setNi(String strNi) {
        this.strNi = strNi;
    }
    
    /**
     * 
     * @return 
     */
    public String getGenderCode() {
        return strGenderCode;
    }
    
    /**
     * 
     * @param strGenderCode 
     */
    public void setGenderCode(String strGenderCode) {
        this.strGenderCode = strGenderCode;
    }
    
    /**
     * 
     * @return 
     */
    public String getAddress() {
        return strAddress;
    }
    
    /**
     * 
     * @param strAddress 
     */
    public void setAddress(String strAddress) {
        this.strAddress = strAddress;
    }
    
    /**
     * 
     * @return 
     */
    public String getPositionCode() {
        return strPositionCode;
    }
    
    /**
     * 
     * @param strPositionCode 
     */
    public void setPositionCode(String strPositionCode) {
        this.strPositionCode = strPositionCode;
    }
    
    /**
     * 
     * @return 
     */
    public String getCellphone() {
        return strCellphone;
    }
    
    /**
     * 
     * @param strCellphone 
     */
    public void setCellphone(String strCellphone) {
        this.strCellphone = strCellphone;
    }
    
    /**
     * 
     * @return 
     */
    public String geteMail() {
        return strEmail;
    }
    
    /**
     * 
     * @param strEmail 
     */
    public void seteMail(String strEmail) {
        this.strEmail = strEmail;
    }
    
    /**
     * 
     * @return 
     */
    public String getEmergencyCell() {
        return strEmergencyCell;
    }
    
    /**
     * 
     * @param strEmergencyCell 
     */
    public void setEmergencyCell(String strEmergencyCell) {
        this.strEmergencyCell = strEmergencyCell;
    }   
    
    /**
     * 
     * @return 
     */
    public String getOther() {
        return strOther;
    }
    
    /**
     * 
     * @param strOther 
     */
    public void setOther(String strOther) {
        this.strOther = strOther;
    }
    
    /**
     * 
     * @return 
     */
    public String getState() {
        return strState;
    }
    
    /**
     * 
     * @param strState 
     */
    public void setState(String strState) {
        this.strState = strState;
    }
    
    public String insert() {
        Principal.CONECCTION.conect();
        String strError = "";
        
        try {
            StringBuilder strValue = new StringBuilder(MAX);
            strValue.append("INSERT INTO Usuario VALUES( DEFAULT , '");
            strValue.append(strId);
            strValue.append("' , '");
            strValue.append(strPassword);
            strValue.append("' , '");
            strValue.append(strName);
            strValue.append("' , '");
            strValue.append(strFatherLastName);
            strValue.append("' , '");
            strValue.append(strMotherLastName);
            strValue.append("' , '");
            strValue.append(strNi);
            strValue.append("' , ");
            strValue.append(strGenderCode);
            strValue.append(" , '");
            strValue.append(strAddress);
            strValue.append("' , ");
            strValue.append(strPositionCode);
            strValue.append(" , '");
            strValue.append(strCellphone);
            strValue.append("' , '");
            strValue.append(strEmail);
            strValue.append("' , '");
            strValue.append(strEmergencyCell);
            strValue.append("' , '");
            strValue.append(strOther);
            strValue.append("' , ");
            strValue.append(strState);
            strValue.append(" )");
            
            Principal.CONECCTION.send(String.valueOf(strValue));
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public String update() {
        Principal.CONECCTION.conect();
        String strError = "";  
        
        try {          
            StringBuilder strValue = new StringBuilder(MAX);
            strValue.append("UPDATE Usuario SET UsuNom = '");
            strValue.append(strName);
            strValue.append("' , UsuApePat = '");
            strValue.append(strFatherLastName);
            strValue.append("' , UsuApeMat = '");
            strValue.append(strMotherLastName);
            strValue.append("' , UsuDni = '");
            strValue.append(strNi);
            strValue.append("' , GenCod = ");
            strValue.append(strGenderCode);
            strValue.append(" , UsuDir = '");
            strValue.append(strAddress);
            strValue.append("' , CarCod = ");
            strValue.append(strPositionCode);
            strValue.append(" , UsuCel = '");
            strValue.append(strCellphone);
            strValue.append("' , UsuCorEle = '");
            strValue.append(strEmail);
            strValue.append("' , UsuNumEme = '");
            strValue.append(strEmergencyCell);
            strValue.append("' , UsuOtr = '");
            strValue.append(strOther);
            strValue.append("' WHERE UsuCod = ");
            strValue.append(strCode);
            
            Principal.CONECCTION.send(String.valueOf(strValue));
            Principal.CONECCTION.disconect();  
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
                
        return strError;
    }
    
    /**
     *
     * @param strUserCode
     * @return
     */
    public static String remove(String strUserCode) {
        Principal.CONECCTION.conect();
        String strError = "";
        
        try {
            StringBuilder strValue = new StringBuilder(500);
            strValue.append("UPDATE Usuario SET EstCod = '2' WHERE UsuCod = ");
            strValue.append(strUserCode);
            
            Principal.CONECCTION.send(String.valueOf(strValue));
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
             strError = cException.getMessage();
        }
        
        return strError;
    }
    
    /**
     * 
     * @param iOption
     * @param strIdentification
     * @param strCodeReceived
     * @param strNameReceived
     * @return 
     */
    public List <Users> getList(int iOption, String strIdentification, String strCodeReceived, String strNameReceived) {
        Principal.CONECCTION.conect();
        List <Users> aryUsers = new ArrayList <Users> ();
        
        try {
            boolean bAccess = false;
            StringBuilder strValue = new StringBuilder(MAX);
            
            switch(iOption){              
                case 0: strValue.append("SELECT UsuCod, UsuIde, UsuCon, UsuNom, UsuApePat, UsuApeMat, UsuDni, UsuDir, UsuCel, UsuCorEle, UsuNumEme, UsuOtr, GenCod, CarCod, EstCod FROM Usuario WHERE EstCod = 1 AND UsuIde = '");
                        strValue.append(strIdentification);
                        strValue.append("' COLLATE utf8_bin");
                        break;
                    
                case 1: strValue.append("SELECT UsuCod, UsuIde, UsuCon, UsuNom, UsuApePat, UsuApeMat, UsuDni, UsuDir, UsuCel, UsuCorEle, UsuNumEme, UsuOtr, GenCod, CarCod, EstCod FROM Usuario WHERE UsuCod = ");
                        strValue.append(strCodeReceived);
                        break;
                        
                case 2: strValue.append("SELECT UsuCod, UsuIde, UsuCon, UsuNom, UsuApePat, UsuApeMat, UsuDni, UsuDir, UsuCel, UsuCorEle, UsuNumEme, UsuOtr, GenNom, CarNom, EstNom FROM Usuario_Cargo");
                        bAccess = true;
                        break;
                    
                case 3: strValue.append("SELECT UsuCod, UsuIde, UsuCon, UsuNom, UsuApePat, UsuApeMat, UsuDni, UsuDir, UsuCel, UsuCorEle, UsuNumEme, UsuOtr, GenNom, CarNom, EstNom FROM Usuario_Cargo WHERE EstNom = 'Activo' AND UsuNom LIKE '");
                        strValue.append(strNameReceived);
                        strValue.append("%'");
                        bAccess = true;
                        break;
                    
                default:    JOptionPane.showMessageDialog(null, "Default Option");
                            break;
            }
            
            ResultSet cResult = Principal.CONECCTION.receive(String.valueOf(strValue));
            Users cUser = null;
            
            while(cResult.next()) {                
                cUser = new Users();
                
                cUser.setCode(cResult.getString("UsuCod"));
                cUser.setId(cResult.getString("UsuIde"));
                cUser.setPassword(cResult.getString("UsuCon"));
                cUser.setName(cResult.getString("UsuNom"));
                cUser.setFatherLastName(cResult.getString("UsuApePat"));
                cUser.setMotherLastName(cResult.getString("UsuApeMat"));
                cUser.setNi(cResult.getString("UsuDni"));
                cUser.setAddress(cResult.getString("UsuDir"));
                cUser.setCellphone(cResult.getString("UsuCel"));
                cUser.seteMail(cResult.getString("UsuCorEle"));
                cUser.setEmergencyCell(cResult.getString("UsuNumEme"));
                cUser.setOther(cResult.getString("UsuOtr"));
                
                
                if(bAccess) {
                    cUser.setGenderCode(cResult.getString("GenNom"));
                    cUser.setPositionCode(cResult.getString("CarNom"));
                    cUser.setState(cResult.getString("EstNom"));
                } else {
                    cUser.setGenderCode(cResult.getString("GenCod"));
                    cUser.setPositionCode(cResult.getString("CarCod"));
                    cUser.setState(cResult.getString("EstCod"));
                }
                        
                aryUsers.add(cUser);
            }
            
            cResult.close();
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryUsers;
    }
}