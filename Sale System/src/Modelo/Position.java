package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Position {
    private String code;
    private String description;

    public Position() {
        this("-1","NULL");
    }
    
    public Position(String code, String description) {
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
    
    public ArrayList <Position> getList() {
        Main.conexion.conectar();
        ArrayList <Position> positions = new ArrayList <> ();
        
        try {
            ResultSet result = Main.conexion.receive("SELECT * FROM Cargo");
            
            while(result.next())
            {    
                Position position = new Position(
                        result.getString("CarCod"),
                        result.getString("CarNom"));
                positions.add(position);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Position.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return positions;
    }
}
