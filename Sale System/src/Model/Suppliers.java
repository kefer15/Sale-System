package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

/**
  @version 2.3
  @author Miguel Fernandez
 */

public class Suppliers {
    private final int MAX = 500;
    private String strCode;
    private String strName;
    private String strTr;
    private String strPhone;
    private String strAddress;
    private String strState;
    
    public Suppliers(){
        this("-1","NULL","NULL","NULL","NULL","-1");
    }   
    
    /**
     * 
     * @param strCode
     * @param strName
     * @param strTr
     * @param strPhone
     * @param strAddress
     * @param strState 
     */
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
    
    /**
     * 
     * @param strCode 
     */
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
        Principal.CONECCTION.conect();
        String strError = "";
        
        try {
            StringBuilder strValue = new StringBuilder(MAX);
            strValue.append("INSERT INTO Proveedor VALUES( DEFAULT , '");
            strValue.append(strName);
            strValue.append("' , '");
            strValue.append(strTr);
            strValue.append("' , '");
            strValue.append(strPhone);
            strValue.append("' , '");
            strValue.append(strAddress);
            strValue.append("' , ");
            strValue.append(strState);
            strValue.append(" )");
            
            Principal.CONECCTION.send(String.valueOf(strValue));
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public String update() {
        Principal.CONECCTION.conect();
        String strError = "";  
        
        try {
            StringBuilder strValue = new StringBuilder(MAX);
            strValue.append("UPDATE Proveedor SET ProNom = '");
            strValue.append(strName);
            strValue.append("' , ProRuc = '");
            strValue.append(strTr);
            strValue.append("' , ProTel = '");
            strValue.append(strPhone);
            strValue.append("' , ProDir = '");
            strValue.append(strAddress);
            strValue.append("' WHERE ProCod = ");
            strValue.append(strCode);
            
            Principal.CONECCTION.send(String.valueOf(strValue));
            Principal.CONECCTION.disconect();  
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
        Principal.CONECCTION.conect();
        String strError = "";
        
        try {
            StringBuilder strValue = new StringBuilder(500);
            strValue.append("UPDATE Proveedor SET EstCod = '2' WHERE ProCod = ");
            strValue.append(strSupplierCodeReceived);
            
            Principal.CONECCTION.send(String.valueOf(strValue));
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
             strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public List <Suppliers> getList(int iOption, String strCodeReceived, String strNameReceived) {
        Principal.CONECCTION.conect();
        List <Suppliers> arySuppliers = new ArrayList <Suppliers> ();
        
        try {
            
            StringBuilder strValue = new StringBuilder(MAX);
            switch(iOption){                    
                case 0: strValue.append("SELECT ProCod, ProNom, ProRuc, ProTel, ProDir, EstCod FROM Proveedor");
                        break;
                        
                case 1: strValue.append("SELECT ProCod, ProNom, ProRuc, ProTel, ProDir, EstCod FROM Proveedor WHERE ProCod = ");
                        strValue.append(strCodeReceived);
                        break;
                    
                case 2: strValue.append("SELECT ProCod, ProNom, ProRuc, ProTel, ProDir, EstCod FROM Proveedor WHERE EstCod = 1 AND ProNom LIKE '");
                        strValue.append(strNameReceived);
                        strValue.append("%'");
                        break;
                
                default:    JOptionPane.showMessageDialog(null, "Default Option");
                            break;
            }
            ResultSet cResult = Principal.CONECCTION.receive(String.valueOf(strValue));
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
            
            cResult.close();
            Principal.CONECCTION.disconect();
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
        Principal.CONECCTION.conect();
        String strError = "";
        
        try {
            int iSize = aryProducts.size();
            StringBuilder strValue = null;
            for(int i = 0;i < iSize;i++){
                if(bState[i]) {
                    strValue = new StringBuilder(500);
                    strValue.append("INSERT INTO ProProd VALUES( ");
                    strValue.append(aryProducts.get(i));
                    strValue.append(" , ");
                    strValue.append(strSupplier);
                    strValue.append(" )");
                    
                    Principal.CONECCTION.send(String.valueOf(strValue));
                }
            }
            
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
             strError = cException.getMessage();
        }
        
        return strError;
    }
}