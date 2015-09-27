package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gender {
    private String code;
    private String description;

    public Gender() {
        this("-1","NULL");
    }
    
    public Gender(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public ArrayList <Gender> getList() {
        Main.conexion.conectar();
        ArrayList <Gender> genders = new ArrayList <> ();
        
        try {
            ResultSet result = Main.conexion.receive("SELECT * FROM Genero");
            
            while(result.next())
            {    
                Gender gender = new Gender(
                        result.getString("GenCod"),
                        result.getString("GenNom"));
                genders.add(gender);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Gender.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return genders;
    }
    
}
