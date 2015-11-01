package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Suppliers {
    private String strCode;
    private String strName;
    private String strTr;
    private String strPhone;
    private String strAddress;
    private String strState;
    
    public Suppliers(){
        this("-1","NULL","NULL","NULL","NULL","-1");
    }   
    
    public Suppliers(String strCode, String strName, String strTr, String strPhone, String strAddress, String strState) {
        this.strCode = strCode;
        this.strName = strName;
        this.strTr = strTr;
        this.strPhone = strPhone;
        this.strAddress = strAddress;
        this.strState = strState;
    }

    public String getCode() {
        return strCode;
    }

    public void setCode(String strCode) {
        this.strCode = strCode;
    }

    public String getName() {
        return strName;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public String getTr() {
        return strTr;
    }

    public void setTr(String strTr) {
        this.strTr = strTr;
    }

    public String getPhone() {
        return strPhone;
    }

    public void setPhone(String strPhone) {
        this.strPhone = strPhone;
    }

    public String getAddress() {
        return strAddress;
    }

    public void setAddress(String strAddress) {
        this.strAddress = strAddress;
    }

    public String getState() {
        return strState;
    }

    public void setState(String strState) {
        this.strState = strState;
    }
    
    public String insert() {
        Main.cConexion.conect();
        String strError = "";
        
        try {
            Main.cConexion.send("INSERT INTO Proveedor VALUES( DEFAULT , '" + strName + "' , '" +
                    strTr + "' , '" + strPhone + "' , '" + strAddress + "' , " + strState + " )");
            
            Main.cConexion.disconect();
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public String update() {
        Main.cConexion.conect();
        String strError = "";  
        
        try {
            Main.cConexion.send("UPDATE Proveedor SET ProNom = '" + strName + 
                    "' , ProRuc = '" + strTr + "' , ProTel = '" + strPhone +  
                    "' , ProDir = '" + strAddress + "' WHERE ProCod = " + strCode);
            
            Main.cConexion.disconect();  
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
                
        return strError;
    }
    
    public String remove(String strSupplierCode) {
        Main.cConexion.conect();
        String strError = "";
        
        try {
            Main.cConexion.send("UPDATE Proveedor SET EstCod = '2' WHERE ProCod = " + strSupplierCode);
            Main.cConexion.disconect();
        } catch (SQLException cException) {
             strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public ArrayList <Suppliers> getList(int iOption, String strCode, String strName) {
        Main.cConexion.conect();
        ArrayList <Suppliers> arySuppliers = new ArrayList <> ();
        
        try {
            ResultSet cResult = null;
            
            switch(iOption){                    
                case 0: cResult = Main.cConexion.receive("SELECT * FROM Proveedor");
                        break;
                        
                case 1: cResult = Main.cConexion.receive("SELECT * FROM Proveedor WHERE ProCod = " + strCode);
                        break;
                    
                case 2: cResult = Main.cConexion.receive("SELECT * FROM Proveedor WHERE EstCod = 1 AND ProNom LIKE '" + strName + "%'");
                        break;
            }
            
            while(cResult.next())
            {                
                Suppliers cSupplier = new Suppliers();
                
                cSupplier.setCode(cResult.getString("ProCod"));
                cSupplier.setName(cResult.getString("ProNom"));
                cSupplier.setTr(cResult.getString("ProRuc"));
                cSupplier.setPhone(cResult.getString("ProTel"));
                cSupplier.setAddress(cResult.getString("ProDir"));
                cSupplier.setState(cResult.getString("EstCod"));
                
                arySuppliers.add(cSupplier);
            }
        } catch (SQLException cException) {
            Logger.getLogger(Suppliers.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return arySuppliers;
    }    
    
    public String link(boolean []bState, ArrayList <String> aryProducts, String strSupplier) {
        Main.cConexion.conect();
        String strError = "";
        
        try {
            for(int i = 0;i < aryProducts.size();i++)
                if(bState[i])
                    Main.cConexion.send("INSERT INTO ProProd VALUES( " + aryProducts.get(i) + " , " + strSupplier + " )");
            Main.cConexion.disconect();
        } catch (SQLException cException) {
             strError = cException.getMessage();
        }
        
        return strError;
    }
}