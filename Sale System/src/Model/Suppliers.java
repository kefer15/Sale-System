package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

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
    
    /** Between this method we get the Supplier's code
     * @return  */
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
        Principal.cConexion.conect();
        String strError = "";
        
        try {
            Principal.cConexion.send("INSERT INTO Proveedor VALUES( DEFAULT , '" + strName + "' , '" +
                    strTr + "' , '" + strPhone + "' , '" + strAddress + "' , " + strState + " )");
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public String update() {
        Principal.cConexion.conect();
        String strError = "";  
        
        try {
            Principal.cConexion.send("UPDATE Proveedor SET ProNom = '" + strName + 
                    "' , ProRuc = '" + strTr + "' , ProTel = '" + strPhone +  
                    "' , ProDir = '" + strAddress + "' WHERE ProCod = " + strCode);
            
            Principal.cConexion.disconect();  
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
                
        return strError;
    }
    
    /**
     *
     * @param strSupplierCodeReceived
     * @return
     */
    public static String remove(String strSupplierCodeReceived) {
        Principal.cConexion.conect();
        String strError = "";
        
        try {
            Principal.cConexion.send("UPDATE Proveedor SET EstCod = '2' WHERE ProCod = " + strSupplierCodeReceived);
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
             strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public ArrayList <Suppliers> getList(int iOption, String strCode, String strName) {
        Principal.cConexion.conect();
        ArrayList <Suppliers> arySuppliers = new ArrayList <Suppliers> ();
        
        try {
            ResultSet cResult = null;
            
            switch(iOption){                    
                case 0: cResult = Principal.cConexion.receive("SELECT ProCod, ProNom, ProRuc, ProTel, ProDir, EstCod FROM Proveedor");
                        break;
                        
                case 1: cResult = Principal.cConexion.receive("SELECT ProCod, ProNom, ProRuc, ProTel, ProDir, EstCod FROM Proveedor WHERE ProCod = " + strCode);
                        break;
                    
                case 2: cResult = Principal.cConexion.receive("SELECT ProCod, ProNom, ProRuc, ProTel, ProDir, EstCod FROM Proveedor WHERE EstCod = 1 AND ProNom LIKE '" + strName + "%'");
                        break;
                
                default:    JOptionPane.showMessageDialog(null, "Default Option");
                            break;
            }
            Suppliers cSupplier = null;
            
            while(cResult.next())
            {                
                cSupplier = new Suppliers();
                
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
    
    /**
     *
     * @param bState
     * @param aryProducts
     * @param strSupplier
     * @return
     */
    public static String link(boolean []bState, ArrayList <String> aryProducts, String strSupplier) {
        Principal.cConexion.conect();
        String strError = "";
        
        try {
            int iSize = aryProducts.size();
            for(int i = 0;i < iSize;i++){
                if(bState[i]) {
                    Principal.cConexion.send("INSERT INTO ProProd VALUES( " + aryProducts.get(i) + " , " + strSupplier + " )");
                }
            }
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
             strError = cException.getMessage();
        }
        
        return strError;
    }
}