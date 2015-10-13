package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public ArrayList <Gender> getList() {
        Main.cConexion.conect();
        ArrayList <Gender> aryGenders = new ArrayList <> ();
        
        try {
            ResultSet cResult = Main.cConexion.receive("SELECT * FROM Genero");
            
            while(cResult.next()) {    
                Gender cGender = new Gender(
                        cResult.getString("GenCod"),
                        cResult.getString("GenNom"));
                aryGenders.add(cGender);
            }
        } catch (SQLException cException) {
            Logger.getLogger(Gender.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryGenders;
    }    
}