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
    
    /**
     * 
     * @param strCode 
     */
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
        Principal.CONECCTION.conect();
        String strError = "";
        
        try {
            StringBuilder strValue = new StringBuilder();
            strValue.append("INSERT INTO Comprobante_Cab VALUES( DEFAULT , '");
            strValue.append(strClientName);
            strValue.append("' , ");
            strValue.append(strAmount);
            strValue.append(" , '");
            strValue.append(strDate);
            strValue.append("' , ");
            strValue.append(strUser);
            strValue.append(" )");
            
            Principal.CONECCTION.send(String.valueOf(strValue));
            Principal.CONECCTION.disconect();
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
        Principal.CONECCTION.conect();
        String strError = "";
        
        try {
            int iSize = aryProducts.size();
            StringBuilder strValue = null;
            for(int i = 0;i < iSize;i++) {
                strValue = new StringBuilder();
                strValue.append("INSERT INTO Comprobante_Det VALUES( ");
                strValue.append(strNumber);
                strValue.append(" , ");
                strValue.append(aryProducts.get(i));
                strValue.append(" , ");
                strValue.append(aryQuantities.get(i));
                strValue.append(" )");
                
                Principal.CONECCTION.send(String.valueOf(strValue));
            }
            
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public List <ProofOfPayment> getListProofs(String strCodeReceived) {
        Principal.CONECCTION.conect();
        List <ProofOfPayment> aryPayments = new ArrayList <ProofOfPayment> ();
        
        try {
            StringBuilder strValue = new StringBuilder();
            strValue.append("SELECT ComCod, CabNomCli, ComMon, ComFec, UsuCod FROM Comprobante_Cab WHERE ComCod LIKE '");
            strValue.append(strCodeReceived);
            strValue.append("%'");            
            
            ResultSet cResult = Principal.CONECCTION.receive(String.valueOf(strValue));
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
            cResult.close();
            Principal.CONECCTION.disconect();
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
        Principal.CONECCTION.conect();
        
        try {
            ResultSet cResult = Principal.CONECCTION.receive("SELECT MAX(ComCod) FROM Comprobante_Cab");
                        
            while(cResult.next()) {
                return cResult.getString("MAX(ComCod)");
            }
            
            cResult.close();
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return "Not Found";
    }    
    
    public List <ProofOfPayment> getList(String strDateStart, String strDateEnd) {
        Principal.CONECCTION.conect();
        List <ProofOfPayment> aryPayments = new ArrayList <ProofOfPayment> ();
        
        try {
            StringBuilder strValue = new StringBuilder();
            strValue.append("SELECT ComCod, ComMon, ComFec, UsuNom FROM Comprobante WHERE ComFec >= '");
            strValue.append(strDateStart);
            strValue.append("' AND ComFec <= '");
            strValue.append(strDateEnd);
            strValue.append("'");
            
            ResultSet cResult = Principal.CONECCTION.receive(String.valueOf(strValue));
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
            
            cResult.close();
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryPayments;
    }
    
    public List <ProofOfPayment> getUsersMount(String strDateStart, String strDateEnd) {
        Principal.CONECCTION.conect();
        List <ProofOfPayment> aryPayments = new ArrayList <ProofOfPayment> ();
        
        try {
            StringBuilder strValue = new StringBuilder();
            strValue.append("SELECT UsuNom, SUM(ComMon) FROM Comprobante WHERE ComFec >= '");
            strValue.append(strDateStart);
            strValue.append("' AND ComFec <= '");
            strValue.append(strDateEnd);
            strValue.append("' GROUP By UsuNom");
            
            ResultSet cResult = Principal.CONECCTION.receive(String.valueOf(strValue));
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
            
            cResult.close();
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryPayments;
    }
}