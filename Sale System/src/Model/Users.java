package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Main.cConexion.conect();
        String strError = "";
        
        try {
            Main.cConexion.send("INSERT INTO Usuario VALUES( DEFAULT , '" + strId + "' , '" + strPassword + "' , '" +
                    strName + "' , '" + strFatherLastName + "' , '" + strMotherLastName + "' , '" + strNi + "' , " + 
                    strGenderCode + " , '" + strAddress + "' , " + strPositionCode + " , '" + strCellphone + "' , '" +
                    strEmail + "' , '" + strEmergencyCell + "' , '" + strOther + "' , " + strState + " )");
            
            Main.cConexion.disconect();
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public String update() {
        Main.cConexion.conect();
        String strError = "";  
        
        try {            
            Main.cConexion.send("UPDATE Usuario SET UsuNom = '" + strName + 
                    "' , UsuApePat = '" + strFatherLastName + "' , UsuApeMat = '" + strMotherLastName +  
                    "' , UsuDni = '" + strNi + "' , GenCod = " + strGenderCode  + 
                    " , UsuDir = '" + strAddress + "' , CarCod = " + strPositionCode + 
                    " , UsuCel = '" +  strCellphone + "' , UsuCorEle = '" + strEmail + 
                    "' , UsuNumEme = '" + strEmergencyCell + "' , UsuOtr = '" + strOther + 
                    "' WHERE UsuCod = " + strCode);
            
            Main.cConexion.disconect();  
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
                
        return strError;
    }
    
    public String remove(String strUserCode) {
        Main.cConexion.conect();
        String strError = "";
        
        try {
            Main.cConexion.send("UPDATE Usuario SET EstCod = '2' WHERE UsuCod = " + strUserCode);
            Main.cConexion.disconect();
        } catch (SQLException cException) {
             strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public ArrayList <Users> getList(int iOption, String strIdentification, String strCode, String strName) {
        Main.cConexion.conect();
        ArrayList <Users> aryUsers = new ArrayList <> ();
        
        try {
            ResultSet cResult = null;
            boolean bAccess = false;
            
            switch(iOption){              
                case 0: cResult = Main.cConexion.receive("SELECT * FROM Usuario WHERE EstCod = 1 AND UsuIde = '" + strIdentification + "' COLLATE utf8_bin");
                        break;
                    
                case 1: cResult = Main.cConexion.receive("SELECT * FROM Usuario WHERE UsuCod = " + strCode);
                        break;
                        
                case 2: cResult = Main.cConexion.receive("SELECT * FROM Usuario_Cargo");
                        bAccess = true;
                        break;
                    
                case 3: cResult = Main.cConexion.receive("SELECT * FROM Usuario_Cargo WHERE EstNom = 'Activo' AND UsuNom LIKE '" + strName + "%'");
                        bAccess = true;
                        break;
            }
            
            while(cResult.next())
            {                
                Users cUser = new Users();
                
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
        } catch (SQLException cException) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryUsers;
    }
}