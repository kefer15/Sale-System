package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
  @version 2.3
  @author Miguel Fernandez
 */

public class Gender {
    private String strCode;
    private String strDescription;

    public Gender() {
        this("-1","NULL");
    }
    
    /**
     * 
     * @param strCode
     * @param strDescription 
     */
    public Gender(String strCode, String strDescription) {
        this.strCode = strCode;
        this.strDescription = strDescription;
    }
    
    /** Between this method we get Gender's code
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
    public String getDescription() {
        return strDescription;
    }
    
    /**
     * 
     * @param strDescription 
     */
    public void setDescription(String strDescription) {
        this.strDescription = strDescription;
    }
    
    /**
     *
     * @return
     */
    public static List <Gender> getList() {
        Principal.CONECCTION.conect();
        List <Gender> aryGenders = new ArrayList <Gender> ();
        
        try {
            ResultSet cResult = Principal.CONECCTION.receive("SELECT GenCod, GenNom FROM Genero");
            Gender cGender = null;
            
            while(cResult.next()) {    
                cGender = new Gender(
                cResult.getString("GenCod"),
                cResult.getString("GenNom"));
                aryGenders.add(cGender);
            }
            
            cResult.close();
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(Gender.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryGenders;
    }    
}