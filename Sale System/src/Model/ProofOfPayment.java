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

public class ProofOfPayment {
    /** This is the code of a proof of payment */
    private String strCode;
    private String strClientName;
    private String strDate;
    private String strAmount;
    private String strUser;
    
    public ProofOfPayment(){
        this("-1","NULL","0000-00-00","0.0","-1");
    }
    
    public ProofOfPayment(String strCode, String strClientName, String strDate, String strAmount, String strUser) {
        this.strCode = strCode;
        this.strClientName = strClientName;
        this.strDate = strDate;
        this.strAmount = strAmount;
        this.strUser = strUser;
    }
    
    /** Between this method the Proof of Payment's code
     * @return  */
    public String getCode() {
        return strCode;
    }

    public void setCode(String strCode) {
        this.strCode = strCode;
    }

    public String getClientName() {
        return strClientName;
    }

    public void setClientName(String strClientName) {
        this.strClientName = strClientName;
    }

    public String getDate() {
        return strDate;
    }

    public void setDate(String strDate) {
        this.strDate = strDate;
    }

    public String getAmount() {
        return strAmount;
    }

    public void setAmount(String strAmount) {
        this.strAmount = strAmount;
    }

    public String getUser() {
        return strUser;
    }

    public void setUser(String strUser) {
        this.strUser = strUser;
    }
    
    public String insertCab() {
        Principal.cConexion.conect();
        String strError = "";
        
        try {
            Principal.cConexion.send("INSERT INTO Comprobante_Cab VALUES( DEFAULT , '" + strClientName + "' , " + strAmount + " , '" + 
                    strDate + "' , " + strUser + " )");
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
        
        return strError;
    }
    
    /**
     *
     * @param aryProducts
     * @param aryQuantities
     * @param strNumber
     * @return
     */
    public static String insertDet(ArrayList <String> aryProducts, ArrayList <Integer> aryQuantities, String strNumber) {
        Principal.cConexion.conect();
        String strError = "";
        
        try {
            int iSize = aryProducts.size();
            for(int i = 0;i < iSize;i++) {
                Principal.cConexion.send("INSERT INTO Comprobante_Det VALUES( " + strNumber + " , " + aryProducts.get(i) + " , " + aryQuantities.get(i) + " )");
            }
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public ArrayList <ProofOfPayment> getListProofs(String strCodeReceived) {
        Principal.cConexion.conect();
        ArrayList <ProofOfPayment> aryPayments = new ArrayList <ProofOfPayment> ();
        
        try {
            ResultSet cResult = Principal.cConexion.receive("SELECT ComCod, CabNomCli, ComMon, ComFec, UsuCod FROM Comprobante_Cab WHERE ComCod LIKE '" + strCodeReceived + "%'");
            ProofOfPayment cPayment = null;
            while(cResult.next()) {                
                cPayment = new ProofOfPayment();
                cPayment.setCode(cResult.getString("ComCod"));
                cPayment.setClientName(cResult.getString("CabNomCli"));
                cPayment.setAmount(cResult.getString("ComMon"));
                cPayment.setDate(cResult.getString("ComFec"));
                cPayment.setUser(cResult.getString("UsuCod"));
                
                aryPayments.add(cPayment);
            }
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryPayments;
    }
    
    /**
     *
     * @return
     */
    public static String getNextCode() {
        Principal.cConexion.conect();
        
        try {
            ResultSet cResult = Principal.cConexion.receive("SELECT MAX(ComCod) FROM Comprobante_Cab");
                        
            while(cResult.next()) {
                return cResult.getString("MAX(ComCod)");
            }
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return null;
    }    
    
    public ArrayList <ProofOfPayment> getList(String strDateStart, String strDateEnd) {
        Principal.cConexion.conect();
        ArrayList <ProofOfPayment> aryPayments = new ArrayList <ProofOfPayment> ();
        
        try {
            ResultSet cResult = Principal.cConexion.receive("SELECT ComCod, ComMon, ComFec, UsuNom FROM Comprobante WHERE ComFec >= '" + strDateStart + "' AND ComFec <= '" + strDateEnd + "'");
            ProofOfPayment cPayment = null;
            
            while(cResult.next()) {                
                cPayment = new ProofOfPayment();
                cPayment.setCode(cResult.getString("ComCod"));
                cPayment.setClientName("");
                cPayment.setAmount(cResult.getString("ComMon"));
                cPayment.setDate(cResult.getString("ComFec"));
                cPayment.setUser(cResult.getString("UsuNom"));
                
                aryPayments.add(cPayment);
            }
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryPayments;
    }
    
    public ArrayList <ProofOfPayment> getUsersMount(String strDateStart, String strDateEnd) {
        Principal.cConexion.conect();
        ArrayList <ProofOfPayment> aryPayments = new ArrayList <ProofOfPayment> ();
        
        try {
            ResultSet cResult = Principal.cConexion.receive("SELECT UsuNom, SUM(ComMon) FROM Comprobante WHERE ComFec >= '" + strDateStart + "' AND ComFec <= '" + strDateEnd + "' GROUP By UsuNom");
            ProofOfPayment cPayment = null;
            
            while(cResult.next()) {                
                cPayment = new ProofOfPayment();
                cPayment.setCode("");
                cPayment.setClientName("");
                cPayment.setAmount(cResult.getString("SUM(ComMon)"));
                cPayment.setDate("");
                cPayment.setUser(cResult.getString("UsuNom"));
                
                aryPayments.add(cPayment);
            }
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryPayments;
    }
}