package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Users {
    private String code;
    private String id;
    private String password;
    private String name;
    private String fatherLastName;
    private String motherLastName;
    private String ni;
    private String genderCode;
    private String address;
    private String positionCode;
    private String cellphone;
    private String eMail;
    private String emergencyCell;
    private String other;
    private String state;
    
    public Users() {
        this("-1","NULL","NULL","NULL","NULL","NULL","NULL","-1","NULL","-1","NULL","NULL","NULL","NULL","-1");
    }
    
    public Users(String code, String id, String password, String name, String fatherLastName, String motherLastName, String ni, String genderCode, String address, String positionCode, String cellphone, String eMail, String emergencyCell, String other, String state) {
        this.code = code;
        this.id = id;
        this.password = password;
        this.name = name;
        this.fatherLastName = fatherLastName;
        this.motherLastName = motherLastName;
        this.ni = ni;
        this.genderCode = genderCode;
        this.address = address;
        this.positionCode = positionCode;
        this.cellphone = cellphone;
        this.eMail = eMail;
        this.emergencyCell = emergencyCell;
        this.other = other;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherLastName() {
        return fatherLastName;
    }

    public void setFatherLastName(String fatherLastName) {
        this.fatherLastName = fatherLastName;
    }

    public String getMotherLastName() {
        return motherLastName;
    }

    public void setMotherLastName(String motherLastName) {
        this.motherLastName = motherLastName;
    }

    public String getNi() {
        return ni;
    }

    public void setNi(String ni) {
        this.ni = ni;
    }

    public String getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getEmergencyCell() {
        return emergencyCell;
    }

    public void setEmergencyCell(String emergencyCell) {
        this.emergencyCell = emergencyCell;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String insert() {
        Main.conexion.conectar();
        String err = "";
        
        try {
            Main.conexion.send("INSERT INTO Usuario VALUES( DEFAULT , '" + id + "' , '" + password + "' , '" +
                    name + "' , '" + fatherLastName + "' , '" + motherLastName + "' , '" + ni + "' , " + 
                    genderCode + " , '" + address + "' , " + positionCode + " , '" + cellphone + "' , '" +
                    eMail + "' , '" + emergencyCell + "' , '" + other + "' , " + state + " )");
            
            Main.conexion.desconectar();
        } catch (SQLException ex) {
            err = ex.getMessage();
        }
        
        return err;
    }
    
    public String update() {
        Main.conexion.conectar();
        String err = "";  
        
        try {            
            Main.conexion.send("UPDATE Usuario SET UsuNom = '" + name + 
                    "' , UsuApePat = '" + fatherLastName + "' , UsuApeMat = '" + motherLastName +  
                    "' , UsuDni = '" + ni + "' , GenCod = " + genderCode  + 
                    " , UsuDir = '" + address + "' , CarCod = " + positionCode + 
                    " , UsuCel = '" +  cellphone + "' , UsuCorEle = '" + eMail + 
                    "' , UsuNumEme = '" + emergencyCell + "' , UsuOtr = '" + other + 
                    "' WHERE UsuCod = " + code);
            
            Main.conexion.desconectar();  
        } catch (SQLException ex) {
            err = ex.getMessage();
        }
                
        return err;
    }
    
    public String remove(String user_code) {
        Main.conexion.conectar();
        String err = "";
        
        try {
            Main.conexion.send("UPDATE Usuario SET EstCod = '2' WHERE UsuCod = " + user_code);
            Main.conexion.desconectar();
        } catch (SQLException ex) {
             err = ex.getMessage();
        }
        
        return err;
    }
    
    public ArrayList <Users> getList(int option, String identification, String code, String name) {
        Main.conexion.conectar();
        ArrayList <Users> users = new ArrayList <> ();
        
        try {
            ResultSet result = null;
            boolean access = false;
            
            switch(option){              
                case 0: result = Main.conexion.receive("SELECT * FROM Usuario WHERE EstCod = 1 AND UsuIde = '" + identification + "' COLLATE utf8_bin");
                        break;
                    
                case 1: result = Main.conexion.receive("SELECT * FROM Usuario WHERE UsuCod = " + code);
                        break;
                        
                case 2: result = Main.conexion.receive("SELECT * FROM Usuario_Cargo");
                        access = true;
                        break;
                    
                case 3: result = Main.conexion.receive("SELECT * FROM Usuario_Cargo WHERE EstNom = 'Activo' AND UsuNom LIKE '" + name + "%'");
                        access = true;
                        break;
            }
            
            while(result.next())
            {                
                Users user = new Users();
                
                user.setCode(result.getString("UsuCod"));
                user.setId(result.getString("UsuIde"));
                user.setPassword(result.getString("UsuCon"));
                user.setName(result.getString("UsuNom"));
                user.setFatherLastName(result.getString("UsuApePat"));
                user.setMotherLastName(result.getString("UsuApeMat"));
                user.setNi(result.getString("UsuDni"));
                user.setAddress(result.getString("UsuDir"));
                user.setCellphone(result.getString("UsuCel"));
                user.seteMail(result.getString("UsuCorEle"));
                user.setEmergencyCell(result.getString("UsuNumEme"));
                user.setOther(result.getString("UsuOtr"));
                
                
                if(access) {
                    user.setGenderCode(result.getString("GenNom"));
                    user.setPositionCode(result.getString("CarNom"));
                    user.setState(result.getString("EstNom"));
                } else {
                    user.setGenderCode(result.getString("GenCod"));
                    user.setPositionCode(result.getString("CarCod"));
                    user.setState(result.getString("EstCod"));
                }
                
                users.add(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users;
    }
}
