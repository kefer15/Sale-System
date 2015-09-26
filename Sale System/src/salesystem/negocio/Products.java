package salesystem.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Products
{
    String product_id;
    String parent_product_id;
    String product_type_code;
    String product_name;
    String product_price;
    String product_color;
    String product_size;
    String measure_id;
    String product_description;
    String other_product_details;
    String register_state;
    
    public Products() {
        this("-1",  "-1",  "-1",  "NULL",  "0.0", "NULL" , "0.0" , "-1" , "NULL" , "NULL", "A");
    }

    public Products(String product_id, String parent_product_id, String product_type_code, String product_name, String product_price, String product_color, String product_size, String measure_id, String product_description, String other_product_details, String register_state) {
        this.product_id = product_id;
        this.parent_product_id = parent_product_id;
        this.product_type_code = product_type_code;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_color = product_color;
        this.product_size = product_size;
        this.measure_id = measure_id;
        this.product_description = product_description;
        this.other_product_details = other_product_details;
        this.register_state = register_state;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getParent_product_id() {
        return parent_product_id;
    }

    public void setParent_product_id(String parent_product_id) {
        this.parent_product_id = parent_product_id;
    }

    public String getProduct_type_code() {
        return product_type_code;
    }

    public void setProduct_type_code(String product_type_code) {
        this.product_type_code = product_type_code;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_color() {
        return product_color;
    }

    public void setProduct_color(String product_color) {
        this.product_color = product_color;
    }

    public String getProduct_size() {
        return product_size;
    }

    public void setProduct_size(String product_size) {
        this.product_size = product_size;
    }

    public String getMeasure_id() {
        return measure_id;
    }

    public void setMeasure_id(String measure_id) {
        this.measure_id = measure_id;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getOther_product_details() {
        return other_product_details;
    }

    public void setOther_product_details(String other_product_details) {
        this.other_product_details = other_product_details;
    }

    public String getRegister_state() {
        return register_state;
    }

    public void setRegister_state(String register_state) {
        this.register_state = register_state;
    }
       
    public String insert() {
        Main.conexion.conectar();
        String err = "";
        
        try {
            Main.conexion.send("INSERT INTO PRODUCTS VALUES( DEFAULT , " + parent_product_id + " , " + product_type_code + " , '" +
                    product_name + "' , " + product_price + " , '" + product_color + "' , " + product_size + " , " + 
                    measure_id + " , '" + product_description + "' , '" + other_product_details + "' , '" + register_state + "' )");
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
            Main.conexion.send("UPDATE PRODUCTS SET parent_product_id = " + parent_product_id + 
                    " , product_type_code = " + product_type_code +  
                    " , product_name = '" + product_name +  "' , product_price = " + product_price +
                    " , product_color = '" + product_color  + "' , product_size = " + product_size + 
                    " , measure_id = " + measure_id + " , product_description = '" +  product_description +
                    "' , other_product_details = '" + other_product_details + 
                    "' WHERE product_id = " + product_id);
            
            Main.conexion.desconectar();  
        } catch (SQLException ex) {
            err = ex.getMessage();
        }
                
        return err;
    }
    
    public String remove(String product_id) {
        Main.conexion.conectar();
        String err = "";
        
        try {
            Main.conexion.send("UPDATE PRODUCTS SET register_state = '*' WHERE product_id = " + product_id);
            Main.conexion.desconectar();
        } catch (SQLException ex) {
             err = ex.getMessage();
        }
        
        return err;
    }
    
    public ArrayList <Products> getList(int option, String category, String name, String code) {
        Main.conexion.conectar();
        ArrayList <Products> products = new ArrayList <> ();
        
        try {
            ResultSet result = null;
            
            switch(option){
                case 0: result = Main.conexion.receive("SELECT * FROM PRODUCTS WHERE product_type_code = " + category);
                        break;
                
                case 1: result = Main.conexion.receive("SELECT * FROM PRODUCTS WHERE product_name LIKE '" + name + "%'");
                        break;
                    
                case 2: result = Main.conexion.receive("SELECT * FROM PRODUCTS WHERE register_state = 'A'");
                        break;
                    
                case 3: result = Main.conexion.receive("SELECT * FROM PRODUCTS WHERE product_id = " + code);
                        break;
            }
            
            while(result.next())
            {                
                Products product = new Products(result.getString("product_id"),
                        result.getString("parent_product_id"),
                        result.getString("product_type_code"),
                        result.getString("product_name"),
                        result.getString("product_price"),
                        result.getString("product_color"),
                        result.getString("product_size"),
                        result.getString("measure_id"),
                        result.getString("product_description"),
                        result.getString("other_product_details"),
                        result.getString("register_state"));
                products.add(product);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Products.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return products;
    }
    
    public String getVAT(String id)
    {
        try
        {
            ResultSet result = Main.conexion.receive("SELECT vat_rating FROM Products INNER JOIN Product_Categories ON Product_Categories.product_type_code = Products.product_type_code " +
                    " WHERE product_id = " + id);
            result.next();
            return result.getString("vat_rating");
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return "0.00";
    }
}
