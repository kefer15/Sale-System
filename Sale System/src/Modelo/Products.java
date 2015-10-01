package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Products
{
    private String code;
    private String name;
    private String brand;
    private String presentation;
    private String price;
    private String stock;
    private String category;
    private String state;
    
    public Products(){
        this("-1","NULL","NULL","NULL","0.0","-1","-1","-1");
    }
    
    public Products(String code, String name, String brand, String presentation, String price, String stock, String category, String state) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.presentation = presentation;
        this.price = price;
        this.stock = stock;
        this.category = category;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String insert() {
        Main.conexion.conectar();
        String err = "";
        
        try {
            Main.conexion.send("INSERT INTO Producto VALUES( DEFAULT , '" + name + "' , '" + brand + "' , '" + 
                    presentation + "' , " + price + " , " + stock + " , " + category + " , " + state + " )");
            
            Main.conexion.desconectar();
        } catch (SQLException ex) {
            err = ex.getMessage();
        }
        
        return err;
    }
    
    public String update() {
        Main.conexion.conectar();
        String err = "";  
        
        try {            
            Main.conexion.send("UPDATE Producto SET ProdNom = '" + name + 
                    "' , ProdMar = '" + brand + "' , ProdPres = '" + presentation  + "' , ProdPrec = " + price + 
                    " , ProdSto = " + stock + " , CatCod = " + category + " WHERE ProdCod = " + code);
            
            Main.conexion.desconectar();  
        } catch (SQLException ex) {
            err = ex.getMessage();
        }
                
        return err;
    }
    
    public String remove(String product_code) {
        Main.conexion.conectar();
        String err = "";
        
        try {
            Main.conexion.send("UPDATE Producto SET EstCod = '2' WHERE ProdCod = " + product_code);
            Main.conexion.desconectar();
        } catch (SQLException ex) {
             err = ex.getMessage();
        }
        
        return err;
    }
    
    public ArrayList <Products> getList(int option, String code, String name) {
        Main.conexion.conectar();
        ArrayList <Products> products = new ArrayList <> ();
        
        try {
            ResultSet result = null;
            boolean access = false;
            
            switch(option){              
                case 0: result = Main.conexion.receive("SELECT * FROM Producto WHERE ProdCod = " + code);
                        break;
                        
                case 1: result = Main.conexion.receive("SELECT * FROM Producto_Categoria");
                        access = true;
                        break;
                    
                case 2: result = Main.conexion.receive("SELECT * FROM Producto_Categoria WHERE EstNom = 'Activo' AND ProdNom LIKE '" + name + "%'");
                        access = true;
                        break;
                    
                case 3: result = Main.conexion.receive("SELECT * FROM Producto WHERE EstCod = 1 ORDER BY ProdNom");
                        break;
                    
                case 4: result = Main.conexion.receive("SELECT * FROM Producto_Categoria WHERE EstNom = 'Activo' AND ProdMar LIKE '" + name + "%'");
                        access = true;
                        break;
                    
                case 5: result = Main.conexion.receive("SELECT * FROM Producto_Categoria WHERE EstNom = 'Activo' AND CatNom LIKE '" + name + "%'");
                        access = true;
                        break;
            }
            
            while(result.next())
            {                
                Products product = new Products();
                
                product.setCode(result.getString("ProdCod"));
                product.setName(result.getString("ProdNom"));
                product.setBrand(result.getString("ProdMar"));
                product.setPresentation(result.getString("ProdPres"));
                product.setPrice(result.getString("ProdPrec"));
                product.setStock(result.getString("ProdSto"));
                
                if(access) {
                    product.setCategory(result.getString("CatNom"));
                    product.setState(result.getString("EstNom"));
                } else {
                    product.setCategory(result.getString("CatCod"));
                    product.setState(result.getString("EstCod"));
                }
                
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return products;
    }
}
