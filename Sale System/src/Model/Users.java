package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

public class Users {
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

    public void setCode(String strCode) {
        this.strCode = strCode;
    }

    public String getId() {
        return strId;
    }

    public void setId(String strId) {
        this.strId = strId;
    }

    public String getPassword() {
        return strPassword;
    }

    public void setPassword(String strPassword) {
        this.strPassword = strPassword;
    }

    public String getName() {
        return strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public String getFatherLastName() {
        return strFatherLastName;
    }

    public void setFatherLastName(String strFatherLastName) {
        this.strFatherLastName = strFatherLastName;
    }

    public String getMotherLastName() {
        return strMotherLastName;
    }

    public void setMotherLastName(String strMotherLastName) {
        this.strMotherLastName = strMotherLastName;
    }

    public String getNi() {
        return strNi;
    }

    public void setNi(String strNi) {
        this.strNi = strNi;
    }

    public String getGenderCode() {
        return strGenderCode;
    }

    public void setGenderCode(String strGenderCode) {
        this.strGenderCode = strGenderCode;
    }

    public String getAddress() {
        return strAddress;
    }

    public void setAddress(String strAddress) {
        this.strAddress = strAddress;
    }

    public String getPositionCode() {
        return strPositionCode;
    }

    public void setPositionCode(String strPositionCode) {
        this.strPositionCode = strPositionCode;
    }

    public String getCellphone() {
        return strCellphone;
    }

    public void setCellphone(String strCellphone) {
        this.strCellphone = strCellphone;
    }

    public String geteMail() {
        return strEmail;
    }

    public void seteMail(String strEmail) {
        this.strEmail = strEmail;
    }

    public String getEmergencyCell() {
        return strEmergencyCell;
    }

    public void setEmergencyCell(String strEmergencyCell) {
        this.strEmergencyCell = strEmergencyCell;
    }

    public String getOther() {
        return strOther;
    }

    public void setOther(String strOther) {
        this.strOther = strOther;
    }

    public String getState() {
        return strState;
    }

    public void setState(String strState) {
        this.strState = strState;
    }
    
    public String insert() {
        Principal.cConexion.conect();
        String strError = "";
        
        try {
            Principal.cConexion.send("INSERT INTO Usuario VALUES( DEFAULT , '" + strId + "' , '" + strPassword + "' , '" +
                    strName + "' , '" + strFatherLastName + "' , '" + strMotherLastName + "' , '" + strNi + "' , " + 
                    strGenderCode + " , '" + strAddress + "' , " + strPositionCode + " , '" + strCellphone + "' , '" +
                    strEmail + "' , '" + strEmergencyCell + "' , '" + strOther + "' , " + strState + " )");
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public String update() {
        Principal.cConexion.conect();
        String strError = "";  
        
        try {            
            Principal.cConexion.send("UPDATE Usuario SET UsuNom = '" + strName + 
                    "' , UsuApePat = '" + strFatherLastName + "' , UsuApeMat = '" + strMotherLastName +  
                    "' , UsuDni = '" + strNi + "' , GenCod = " + strGenderCode  + 
                    " , UsuDir = '" + strAddress + "' , CarCod = " + strPositionCode + 
                    " , UsuCel = '" +  strCellphone + "' , UsuCorEle = '" + strEmail + 
                    "' , UsuNumEme = '" + strEmergencyCell + "' , UsuOtr = '" + strOther + 
                    "' WHERE UsuCod = " + strCode);
            
            Principal.cConexion.disconect();  
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
        Principal.cConexion.conect();
        String strError = "";
        
        try {
            Principal.cConexion.send("UPDATE Usuario SET EstCod = '2' WHERE UsuCod = " + strUserCode);
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
             strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public ArrayList <Users> getList(int iOption, String strIdentification, String strCodeReceived, String strNameReceived) {
        Principal.cConexion.conect();
        ArrayList <Users> aryUsers = new ArrayList <Users> ();
        
        try {
            ResultSet cResult = null;
            boolean bAccess = false;
            
            switch(iOption){              
                case 0: cResult = Principal.cConexion.receive("SELECT UsuCod, UsuIde, UsuCon, UsuNom, UsuApePat, UsuApeMat, UsuDni, UsuDir, UsuCel, UsuCorEle, UsuNumEme, UsuOtr, GenCod, CarCod, EstCod FROM Usuario WHERE EstCod = 1 AND UsuIde = '" + strIdentification + "' COLLATE utf8_bin");
                        break;
                    
                case 1: cResult = Principal.cConexion.receive("SELECT UsuCod, UsuIde, UsuCon, UsuNom, UsuApePat, UsuApeMat, UsuDni, UsuDir, UsuCel, UsuCorEle, UsuNumEme, UsuOtr, GenCod, CarCod, EstCod FROM Usuario WHERE UsuCod = " + strCodeReceived);
                        break;
                        
                case 2: cResult = Principal.cConexion.receive("SELECT UsuCod, UsuIde, UsuCon, UsuNom, UsuApePat, UsuApeMat, UsuDni, UsuDir, UsuCel, UsuCorEle, UsuNumEme, UsuOtr, GenNom, CarNom, EstNom FROM Usuario_Cargo");
                        bAccess = true;
                        break;
                    
                case 3: cResult = Principal.cConexion.receive("SELECT UsuCod, UsuIde, UsuCon, UsuNom, UsuApePat, UsuApeMat, UsuDni, UsuDir, UsuCel, UsuCorEle, UsuNumEme, UsuOtr, GenNom, CarNom, EstNom FROM Usuario_Cargo WHERE EstNom = 'Activo' AND UsuNom LIKE '" + strNameReceived + "%'");
                        bAccess = true;
                        break;
                    
                default:    JOptionPane.showMessageDialog(null, "Default Option");
                            break;
            }
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
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryUsers;
    }
}