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
    
    /** Between this method we get the Position's code
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
    public static ArrayList <Position> getList() {
        Principal.cConexion.conect();
        ArrayList <Position> aryPositions = new ArrayList <Position> ();
        
        try {
            ResultSet cResult = Principal.cConexion.receive("SELECT CarCod, CarNom FROM Cargo");
            Position cPosition = null;
                    
            while(cResult.next()) {    
                cPosition = new Position(
                cResult.getString("CarCod"),
                cResult.getString("CarNom"));
                aryPositions.add(cPosition);
            }
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(Position.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryPositions;
    }
}