package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Position {
    private String strCode;
    private String strDescription;

    public Position() {
        this("-1","NULL");
    }
    
    public Position(String strCode, String strDescription) {
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
    
    public ArrayList <Position> getList() {
        Main.cConexion.conect();
        ArrayList <Position> aryPositions = new ArrayList <> ();
        
        try {
            ResultSet cResult = Main.cConexion.receive("SELECT * FROM Cargo");
            
            while(cResult.next()) {    
                Position cPosition = new Position(
                        cResult.getString("CarCod"),
                        cResult.getString("CarNom"));
                aryPositions.add(cPosition);
            }
        } catch (SQLException cException) {
            Logger.getLogger(Position.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryPositions;
    }
}