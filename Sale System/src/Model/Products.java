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

public class Products
{
    private String strCode;
    private String strName;
    private String strBrand;
    private String strPresentation;
    private String strPrice;
    private String strStock;
    private String strCategory;
    private String strState;
    
    public Products(){
        this("-1","NULL","NULL","NULL","0.0","-1","-1","-1");
    }
    
    public Products(String strCode, String strName, String strBrand, String strPresentation, String strPrice, String strStock, String strCategory, String strState) {
        this.strCode = strCode;
        this.strName = strName;
        this.strBrand = strBrand;
        this.strPresentation = strPresentation;
        this.strPrice = strPrice;
        this.strStock = strStock;
        this.strCategory = strCategory;
        this.strState = strState;
    }
    
    /** Between this method we get the Product's code
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

    public String getBrand() {
        return strBrand;
    }

    public void setBrand(String strBrand) {
        this.strBrand = strBrand;
    }
    
    public String getPresentation() {
        return strPresentation;
    }

    public void setPresentation(String strPresentation) {
        this.strPresentation = strPresentation;
    }

    public String getPrice() {
        return strPrice;
    }

    public void setPrice(String strPrice) {
        this.strPrice = strPrice;
    }

    public String getStock() {
        return strStock;
    }

    public void setStock(String strStock) {
        this.strStock = strStock;
    }

    public String getCategory() {
        return strCategory;
    }

    public void setCategory(String strCategory) {
        this.strCategory = strCategory;
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
            Principal.cConexion.send("INSERT INTO Producto VALUES( DEFAULT , '" + strName + "' , '" + strBrand + "' , '" + 
                    strPresentation + "' , " + strPrice + " , " + strStock + " , " + strCategory + " , " + strState + " )");
            
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
            Principal.cConexion.send("UPDATE Producto SET ProdNom = '" + strName + 
                    "' , ProdMar = '" + strBrand + "' , ProdPres = '" + strPresentation  + "' , ProdPrec = " + strPrice + 
                    " , ProdSto = " + strStock + " , CatCod = " + strCategory + " WHERE ProdCod = " + strCode);
            
            Principal.cConexion.disconect();  
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
                
        return strError;
    }
    
    public String updateStock(ArrayList <String> aryCodes, ArrayList <String> aryStock) {
        Principal.cConexion.conect();
        String strError = "";  
        
        try {   
            
            ArrayList <String> aryStockOld = new ArrayList <String> ();
            aryStockOld = this.getStock(aryCodes);
            int iSize = aryCodes.size();
            for(int i = 0;i < iSize;i++) {                
                Principal.cConexion.send("UPDATE Producto SET ProdSto = " + (Integer.parseInt(aryStockOld.get(i))-Integer.parseInt(aryStock.get(i))) + " WHERE ProdCod = " + aryCodes.get(i));
            }
            
            Principal.cConexion.disconect();  
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
                
        return strError;
    }
    
    /**
     *
     * @param strProductCode
     * @return
     */
    public static String remove(String strProductCode) {
        Principal.cConexion.conect();
        String strError = "";
        
        try {
            Principal.cConexion.send("UPDATE Producto SET EstCod = '2' WHERE ProdCod = " + strProductCode);
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
             strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public ArrayList <Products> getList(int iOption, String strCodeReceived, String strNameReceived) {
        Principal.cConexion.conect();
        ArrayList <Products> aryProducts = new ArrayList <Products> ();
        
        try {
            ResultSet cResult = null;
            boolean bAccess = false;
            
            switch(iOption) {              
                case 0: cResult = Principal.cConexion.receive("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatCod, EstCod FROM Producto WHERE ProdCod = " + strCodeReceived);
                        break;
                        
                case 1: cResult = Principal.cConexion.receive("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, EstNom FROM Producto_Categoria ORDER BY ProdNom");
                        bAccess = true;
                        break;
                    
                case 2: cResult = Principal.cConexion.receive("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, EstNom FROM Producto_Categoria WHERE EstNom = 'Activo' AND ProdNom LIKE '" + strNameReceived + "%'");
                        bAccess = true;
                        break;
                    
                case 3: cResult = Principal.cConexion.receive("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatCod, EstCod FROM Producto WHERE EstCod = 1 ORDER BY ProdNom");
                        break;
                    
                case 4: cResult = Principal.cConexion.receive("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, EstNom FROM Producto_Categoria WHERE EstNom = 'Activo' AND ProdMar LIKE '" + strNameReceived + "%'");
                        bAccess = true;
                        break;
                    
                case 5: cResult = Principal.cConexion.receive("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, EstNom FROM Producto_Categoria WHERE EstNom = 'Activo' AND CatNom LIKE '" + strNameReceived + "%'");
                        bAccess = true;
                        break;
                    
                case 6: cResult = Principal.cConexion.receive("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, EstNom FROM Producto_Categoria ORDER BY ProdMar");
                        bAccess = true;
                        break;
                    
                case 7: cResult = Principal.cConexion.receive("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, EstNom FROM Producto_Categoria ORDER BY CatNom");
                        bAccess = true;
                        break;
                
                default:    JOptionPane.showMessageDialog(null, "Default Option");
                            break;                 
            }
            Products cProduct = null;
            
            while(cResult.next()) {                
                cProduct = new Products();
                
                cProduct.setCode(cResult.getString("ProdCod"));
                cProduct.setName(cResult.getString("ProdNom"));
                cProduct.setBrand(cResult.getString("ProdMar"));
                cProduct.setPresentation(cResult.getString("ProdPres"));
                cProduct.setPrice(cResult.getString("ProdPrec"));
                cProduct.setStock(cResult.getString("ProdSto"));
                
                if(bAccess) {
                    cProduct.setCategory(cResult.getString("CatNom"));
                    cProduct.setState(cResult.getString("EstNom"));
                } else {
                    cProduct.setCategory(cResult.getString("CatCod"));
                    cProduct.setState(cResult.getString("EstCod"));
                }
                
                aryProducts.add(cProduct);
            }
            
            Principal.cConexion.disconect();
        } catch (SQLException eException) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, eException);
        }
        
        return aryProducts;
    }

    public ArrayList <String> getProducts(String strCodeReceived) {
        Principal.cConexion.conect();
        ArrayList <String> aryProducts = new ArrayList <String> ();
        
        try {
            ResultSet cResult = Principal.cConexion.receive("SELECT ProdNom, ProdMar, ProdPres FROM PRODUCTO_PROVEEDOR WHERE ProCod = " + strCodeReceived);
                        
            while(cResult.next()) {    
                aryProducts.add(cResult.getString("ProdNom") + " " + cResult.getString("ProdMar") + " " + cResult.getString("ProdPres"));
            }
            
            Principal.cConexion.disconect();
        } catch (SQLException eException) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, eException);
        }
        
        return aryProducts;
        
    }
    
    public ArrayList <String> getStock(ArrayList <String> aryCodes) {
        Principal.cConexion.conect();
        ArrayList <String> aryStock = new ArrayList <String> ();
        
        try {
            ResultSet cResult = null;
            for (String aryCode : aryCodes) {
                cResult = Principal.cConexion.receive("SELECT ProdSto FROM Producto WHERE ProdCod = " + aryCode);
                while(cResult.next()) {   
                    aryStock.add(cResult.getString("ProdSto"));
                }
            }            
  
        } catch (SQLException eException) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, eException);
        }
        
        return aryStock;        
    }
}