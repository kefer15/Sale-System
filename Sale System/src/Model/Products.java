package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Main.cConexion.conect();
        String strError = "";
        
        try {
            Main.cConexion.send("INSERT INTO Producto VALUES( DEFAULT , '" + strName + "' , '" + strBrand + "' , '" + 
                    strPresentation + "' , " + strPrice + " , " + strStock + " , " + strCategory + " , " + strState + " )");
            
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
            Main.cConexion.send("UPDATE Producto SET ProdNom = '" + strName + 
                    "' , ProdMar = '" + strBrand + "' , ProdPres = '" + strPresentation  + "' , ProdPrec = " + strPrice + 
                    " , ProdSto = " + strStock + " , CatCod = " + strCategory + " WHERE ProdCod = " + strCode);
            
            Main.cConexion.disconect();  
        } catch (SQLException cException) {
            strError = cException.getMessage();
        }
                
        return strError;
    }
    
    public String remove(String strProductCode) {
        Main.cConexion.conect();
        String strError = "";
        
        try {
            Main.cConexion.send("UPDATE Producto SET EstCod = '2' WHERE ProdCod = " + strProductCode);
            Main.cConexion.disconect();
        } catch (SQLException cException) {
             strError = cException.getMessage();
        }
        
        return strError;
    }
    
    public ArrayList <Products> getList(int iOption, String strCode, String strName) {
        Main.cConexion.conect();
        ArrayList <Products> aryProducts = new ArrayList <> ();
        
        try {
            ResultSet cResult = null;
            boolean bAccess = false;
            
            switch(iOption) {              
                case 0: cResult = Main.cConexion.receive("SELECT * FROM Producto WHERE ProdCod = " + strCode);
                        break;
                        
                case 1: cResult = Main.cConexion.receive("SELECT * FROM Producto_Categoria ORDER BY ProdNom");
                        bAccess = true;
                        break;
                    
                case 2: cResult = Main.cConexion.receive("SELECT * FROM Producto_Categoria WHERE EstNom = 'Activo' AND ProdNom LIKE '" + strName + "%'");
                        bAccess = true;
                        break;
                    
                case 3: cResult = Main.cConexion.receive("SELECT * FROM Producto WHERE EstCod = 1 ORDER BY ProdNom");
                        break;
                    
                case 4: cResult = Main.cConexion.receive("SELECT * FROM Producto_Categoria WHERE EstNom = 'Activo' AND ProdMar LIKE '" + strName + "%'");
                        bAccess = true;
                        break;
                    
                case 5: cResult = Main.cConexion.receive("SELECT * FROM Producto_Categoria WHERE EstNom = 'Activo' AND CatNom LIKE '" + strName + "%'");
                        bAccess = true;
                        break;
                    
                case 6: cResult = Main.cConexion.receive("SELECT * FROM Producto_Categoria ORDER BY ProdMar");
                        bAccess = true;
                        break;
                    
                case 7: cResult = Main.cConexion.receive("SELECT * FROM Producto_Categoria ORDER BY CatNom");
                        bAccess = true;
                        break;
            }
            
            while(cResult.next()) {                
                Products cProduct = new Products();
                
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
        } catch (SQLException eException) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, eException);
        }
        
        return aryProducts;
    }

    public ArrayList <String> getProducts(String strCode) {
        Main.cConexion.conect();
        ArrayList <String> aryProducts = new ArrayList <> ();
        
        try {
            ResultSet cResult = Main.cConexion.receive("SELECT * FROM PRODUCTO_PROVEEDOR WHERE ProCod = " + strCode);
                        
            while(cResult.next())   
                aryProducts.add(cResult.getString("ProdNom") + " " + cResult.getString("ProdMar") + " " + cResult.getString("ProdPres"));
  
        } catch (SQLException eException) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, eException);
        }
        
        return aryProducts;
        
    }
}