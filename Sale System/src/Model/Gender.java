package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

public class Gender {
    private String strCode;
    private String strDescription;

    public Gender() {
        this("-1","NULL");
    }
    
    public Gender(String strCode, String strDescription) {
        this.strCode = strCode;
        this.strDescription = strDescription;
    }
    
    /** Between this method we get Gender's code
     * @return  */
    public String getCode() {
        return strCode;
    }

    public void setCode(String strCode) {
        this.strCode = strCode;
    }

    public String getDescription() {
        return strDescription;
    }

    public void setDescription(String strDescription) {
        this.strDescription = strDescription;
    }
    
    /**
     *
     * @return
     */
    public static ArrayList <Gender> getList() {
        Principal.cConexion.conect();
        ArrayList <Gender> aryGenders = new ArrayList <Gender> ();
        
        try {
            ResultSet cResult = Principal.cConexion.receive("SELECT GenCod, GenNom FROM Genero");
            Gender cGender = null;
            
            while(cResult.next()) {    
                cGender = new Gender(
                cResult.getString("GenCod"),
                cResult.getString("GenNom"));
                aryGenders.add(cGender);
            }
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(Gender.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryGenders;
    }    
}