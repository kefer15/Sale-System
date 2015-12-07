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

public class Products
{
    private final int MAX = 500;
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
    
    /**
     * 
     * @param strCode
     * @param strName
     * @param strBrand
     * @param strPresentation
     * @param strPrice
     * @param strStock
     * @param strCategory
     * @param strState 
     */
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
    
    /**
     * 
     * @param strCode 
     */
    public void setCode(String strCode) {
        this.strCode = strCode;
    }
    
    /**
     * 
     * @return 
     */
    public String getName() {
        return strName;
    }
    
    /**
     * 
     * @param strName 
     */
    public void setName(String strName) {
        this.strName = strName;
    }   
    
    /**
     * 
     * @return 
     */
    public String getBrand() {
        return strBrand;
    }
    
    /**
     * 
     * @param strBrand 
     */
    public void setBrand(String strBrand) {
        this.strBrand = strBrand;
    }
    
    /**
     * 
     * @return 
     */
    public String getPresentation() {
        return strPresentation;
    }
    
    /**
     * 
     * @param strPresentation 
     */
    public void setPresentation(String strPresentation) {
        this.strPresentation = strPresentation;
    }
    
    /**
     * 
     * @return 
     */
    public String getPrice() {
        return strPrice;
    }
    
    /**
     * 
     * @param strPrice 
     */
    public void setPrice(String strPrice) {
        this.strPrice = strPrice;
    }
    
    /**
     * 
     * @return 
     */
    public String getStock() {
        return strStock;
    }
    
    /**
     * 
     * @param strStock 
     */
    public void setStock(String strStock) {
        this.strStock = strStock;
    }
    
    /**
     * 
     * @return 
     */
    public String getCategory() {
        return strCategory;
    }
    
    /**
     * 
     * @param strCategory 
     */
    public void setCategory(String strCategory) {
        this.strCategory = strCategory;
    }
    
    /**
     * 
     * @return 
     */
    public String getState() {
        return strState;
    }
    
    /**
     * 
     * @param strState 
     */
    public void setState(String strState) {
        this.strState = strState;
    }
        
    public String insert() {
        Principal.CONECCTION.conect();
        String strError = "";
        
        try {
            StringBuilder strValue = new StringBuilder(MAX);
            strValue.append("INSERT INTO Producto VALUES( DEFAULT , '");
            strValue.append(strName);
            strValue.append("' , '");
            strValue.append(strBrand);
            strValue.append("' , '");
            strValue.append(strPresentation);
            strValue.append("' , ");
            strValue.append(strPrice);
            strValue.append(" , ");
            strValue.append(strStock);
            strValue.append(" , ");
            strValue.append(strCategory);
            strValue.append(" , ");
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
            strValue.append("UPDATE Producto SET ProdNom = '");
            strValue.append(strName);
            strValue.append("' , ProdMar = '");
            strValue.append(strBrand);
            strValue.append("' , ProdPres = '");
            strValue.append(strPresentation);
            strValue.append("' , ProdPrec = ");
            strValue.append(strPrice);
            strValue.append(" , ProdSto = ");
            strValue.append(strStock);
            strValue.append(" , CatCod = ");
            strValue.append(strCategory);
            strValue.append(" WHERE ProdCod = ");
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
     * @param aryCodes
     * @param aryStock
     * @return 
     */
    public String updateStock(List <String> aryCodes, List <String> aryStock) {
        Principal.CONECCTION.conect();
        String strError = "";  
        
        try {   
            List <String> aryStockOld = new ArrayList <String> ();
            aryStockOld = this.getStock((ArrayList<String>) aryCodes);
            int iSize = aryCodes.size();
            StringBuilder strValue = null;
            for(int i = 0;i < iSize;i++) {  
                strValue = new StringBuilder(MAX);
                strValue.append("UPDATE Producto SET ProdSto = ");
                strValue.append((Integer.parseInt(aryStockOld.get(i))-Integer.parseInt(aryStock.get(i))));
                strValue.append(" WHERE ProdCod = ");
                strValue.append(aryCodes.get(i));
                
                Principal.CONECCTION.send(String.valueOf(strValue));
            }
            
            Principal.CONECCTION.disconect();  
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
        Principal.CONECCTION.conect();
        String strError = "";
        
        try {
            StringBuilder strValue = new StringBuilder(500);
            strValue.append("UPDATE Producto SET EstCod = '2' WHERE ProdCod = ");
            strValue.append(strProductCode);
            
            Principal.CONECCTION.send(String.valueOf(strValue));
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
             strError = cException.getMessage();
        }
        
        return strError;
    }
    
    /**
     * 
     * @param iOption
     * @param strCodeReceived
     * @param strNameReceived
     * @return 
     */
    public List <Products> getList(int iOption, String strCodeReceived, String strNameReceived) {
        Principal.CONECCTION.conect();
        List <Products> aryProducts = new ArrayList <Products> ();
        
        try {
            boolean bAccess = false;
            StringBuilder strValue = new StringBuilder(MAX);
            
            switch(iOption) {              
                case 0: strValue.append("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatCod, EstCod FROM Producto WHERE ProdCod = ");
                        strValue.append(strCodeReceived);
                        break;
                        
                case 1: strValue.append("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, EstNom FROM Producto_Categoria ORDER BY ProdNom");
                        bAccess = true;
                        break;
                    
                case 2: strValue.append("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, EstNom FROM Producto_Categoria WHERE EstNom = 'Activo' AND ProdNom LIKE '");
                        strValue.append(strNameReceived);
                        strValue.append("%'");
                        bAccess = true;
                        break;
                    
                case 3: strValue.append("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatCod, EstCod FROM Producto WHERE EstCod = 1 ORDER BY ProdNom");
                        break;
                    
                case 4: strValue.append("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, EstNom FROM Producto_Categoria WHERE EstNom = 'Activo' AND ProdMar LIKE '");
                        strValue.append(strNameReceived);
                        strValue.append("%'");
                        bAccess = true;
                        break;
                    
                case 5: strValue.append("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, EstNom FROM Producto_Categoria WHERE EstNom = 'Activo' AND CatNom LIKE '");
                        strValue.append(strNameReceived);
                        strValue.append("%'");
                        bAccess = true;
                        break;
                    
                case 6: strValue.append("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, EstNom FROM Producto_Categoria ORDER BY ProdMar");
                        bAccess = true;
                        break;
                    
                case 7: strValue.append("SELECT ProdCod, ProdNom, ProdMar, ProdPres, ProdPrec, ProdSto, CatNom, EstNom FROM Producto_Categoria ORDER BY CatNom");
                        bAccess = true;
                        break;
                
                default:    JOptionPane.showMessageDialog(null, "Default Option");
                            break;                 
            }
            
            ResultSet cResult = Principal.CONECCTION.receive(String.valueOf(strValue));
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
            
            cResult.close();
            Principal.CONECCTION.disconect();
        } catch (SQLException eException) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, eException);
        }
        
        return aryProducts;
    }
    
    /**
     * 
     * @param strCodeReceived
     * @return 
     */
    public List <String> getProducts(String strCodeReceived) {
        Principal.CONECCTION.conect();
        List <String> aryProducts = new ArrayList <String> ();
        
        try {
            StringBuilder strValue = new StringBuilder(MAX);
            strValue.append("SELECT ProdNom, ProdMar, ProdPres FROM PRODUCTO_PROVEEDOR WHERE ProCod = ");
            strValue.append(strCodeReceived);
            
            ResultSet cResult = Principal.CONECCTION.receive(String.valueOf(strValue));
            while(cResult.next()) {    
                strValue = new StringBuilder(MAX);
                strValue.append(cResult.getString("ProdNom")).append(" ").append(cResult.getString("ProdMar")).append(" ").append(cResult.getString("ProdPres"));
                aryProducts.add(String.valueOf(strValue));
            }
            
            cResult.close();
            Principal.CONECCTION.disconect();
        } catch (SQLException eException) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, eException);
        }
        
        return aryProducts;
        
    }
    
    /**
     * 
     * @param aryCodes
     * @return 
     */
    public List <String> getStock(ArrayList <String> aryCodes) {
        Principal.CONECCTION.conect();
        List <String> aryStock = new ArrayList <String> ();
        
        try {
            ResultSet cResult = null;
            StringBuilder strValue = null;
            
            for (String aryCode : aryCodes) {
                strValue = new StringBuilder(MAX);
                strValue.append("SELECT ProdSto FROM Producto WHERE ProdCod = ");
                strValue.append(aryCode);
                cResult = Principal.CONECCTION.receive(String.valueOf(strValue));
                while(cResult.next()) {   
                    aryStock.add(cResult.getString("ProdSto"));
                }
            }            
            
            cResult.close();
            Principal.CONECCTION.disconect();
        } catch (SQLException eException) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, eException);
        }
        
        return aryStock;        
    }
}