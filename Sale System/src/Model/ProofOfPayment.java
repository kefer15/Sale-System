package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProofOfPayment {
    String strCode;
    String strClientName;
    String strDate;
    String strAmount;
    String strUser;
    
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
        Main.cConexion.conect();
        String strError = "";
        
        try {
            Main.cConexion.send("INSERT INTO Comprobante_Cab VALUES( DEFAULT , '" + strClientName + "' , " + strAmount + " , '" + 
                    strDate + "' , " + strUser + " )");
            
            Main.cConexion.disconect();
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public String insertDet(ArrayList <String> aryProducts, ArrayList <Integer> aryQuantities, String strNumber) {
        Main.cConexion.conect();
        String strError = "";
        
        try {
            for(int i = 0;i < aryProducts.size();i++)
                Main.cConexion.send("INSERT INTO Comprobante_Det VALUES( " + strNumber + " , " + aryProducts.get(i) + " , " + aryQuantities.get(i) + " )");
            
            Main.cConexion.disconect();
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public ArrayList <ProofOfPayment> getList(String strCode) {
        Main.cConexion.conect();
        ArrayList <ProofOfPayment> aryPayments = new ArrayList <> ();
        
        try {
            ResultSet cResult = Main.cConexion.receive("SELECT * FROM Comprobante_Cab WHERE ComCod LIKE '" + strCode + "%'");
            
            while(cResult.next()) {                
                ProofOfPayment cPayment = new ProofOfPayment();
                cPayment.setCode(cResult.getString("ComCod"));
                cPayment.setClientName(cResult.getString("CabNomCli"));
                cPayment.setAmount(cResult.getString("ComMon"));
                cPayment.setDate(cResult.getString("ComFec"));
                cPayment.setUser(cResult.getString("UsuCod"));
                
                aryPayments.add(cPayment);
            }
        } catch (SQLException cException) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryPayments;
    }
    
    public String getNextCode() {
        Main.cConexion.conect();
        
        try {
            ResultSet cResult = Main.cConexion.receive("SELECT MAX(ComCod) FROM Comprobante_Cab");
                        
            while(cResult.next())
                return cResult.getString("MAX(ComCod)");
        } catch (SQLException cException) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return null;
    }    
    
    public ArrayList <ProofOfPayment> getList(String strDateStart, String strDateEnd) {
        Main.cConexion.conect();
        ArrayList <ProofOfPayment> aryPayments = new ArrayList <> ();
        
        try {
            ResultSet cResult = Main.cConexion.receive("SELECT * FROM Comprobante WHERE ComFec >= '" + strDateStart + "' AND ComFec <= '" + strDateEnd + "'");
            
            while(cResult.next()) {                
                ProofOfPayment cPayment = new ProofOfPayment();
                cPayment.setCode(cResult.getString("ComCod"));
                cPayment.setClientName("");
                cPayment.setAmount(cResult.getString("ComMon"));
                cPayment.setDate(cResult.getString("ComFec"));
                cPayment.setUser(cResult.getString("UsuNom"));
                
                aryPayments.add(cPayment);
            }
        } catch (SQLException cException) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryPayments;
    }
    
    public ArrayList <ProofOfPayment> getUsersMount(String strDateStart, String strDateEnd) {
        Main.cConexion.conect();
        ArrayList <ProofOfPayment> aryPayments = new ArrayList <> ();
        
        try {
            ResultSet cResult = Main.cConexion.receive("SELECT UsuNom, SUM(ComMon) FROM Comprobante WHERE ComFec >= '" + strDateStart + "' AND ComFec <= '" + strDateEnd + "' GROUP By UsuNom");
            
            while(cResult.next()) {                
                ProofOfPayment cPayment = new ProofOfPayment();
                cPayment.setCode("");
                cPayment.setClientName("");
                cPayment.setAmount(cResult.getString("SUM(ComMon)"));
                cPayment.setDate("");
                cPayment.setUser(cResult.getString("UsuNom"));
                
                aryPayments.add(cPayment);
            }
        } catch (SQLException cException) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryPayments;
    }
}