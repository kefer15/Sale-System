package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
  @version 2.3
  @author Miguel Fernández
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
    
    /**
     * 
     * @param strCode 
     */
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
    public static List <Position> getList() {
        Principal.CONECCTION.conect();
        List <Position> aryPositions = new ArrayList <Position> ();
        
        try {
            ResultSet cResult = Principal.CONECCTION.receive("SELECT CarCod, CarNom FROM Cargo");
            Position cPosition = null;
                    
            while(cResult.next()) {    
                cPosition = new Position(
                cResult.getString("CarCod"),
                cResult.getString("CarNom"));
                aryPositions.add(cPosition);
            }
            
            cResult.close();
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(Position.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryPositions;
    }
}