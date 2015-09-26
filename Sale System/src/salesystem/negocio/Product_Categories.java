package salesystem.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Product_Categories
{
    String product_type_code;
    String product_type_description;
    String vat_rating;
    String register_state;
    
    public Product_Categories()
    {
        this("-1", "NULL", "0", "*");
    }
    
    public Product_Categories(String product_type_code, String product_type_description, String vat_rating, String register_state)
    {
        this.product_type_code = product_type_code;
        this.product_type_description = product_type_description;
        this.vat_rating = vat_rating;
        this.register_state = register_state;
    }

    public String getProduct_type_code()
    {
        return product_type_code;
    }

    public void setProduct_type_code(String product_type_code)
    {
        this.product_type_code = product_type_code;
    }

    public String getProduct_type_description()
    {
        return product_type_description;
    }

    public void setProduct_type_description(String product_type_description)
    {
        this.product_type_description = product_type_description;
    }

    public String getVat_rating()
    {
        return vat_rating;
    }

    public void setVat_rating(String vat_rating)
    {
        this.vat_rating = vat_rating;
    }

    public String getRegister_state()
    {
        return register_state;
    }

    public void setRegister_state(String register_state)
    {
        this.register_state = register_state;
    }

    public String insertar()
    {
        Main.conexion.conectar();

        try
        {
            Main.conexion.send("INSERT INTO Product_Categories VALUES(DEFAULT, '" + product_type_description + "', " + vat_rating + ", '" + register_state + "')");
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
            return ex.getMessage();
        }
        
        return "";
    }
    
    public String modificar(String codigo)
    {
        Main.conexion.conectar();

        try
        {
            Main.conexion.send("UPDATE Product_Categories SET product_type_description = '" + product_type_description + "', vat_rating = " + vat_rating + ", register_state = '" + register_state + "' WHERE product_type_code = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
            return ex.getMessage();
        }
                
        return "";
    }
    
    public String eliminar(String codigo)
    {
        Main.conexion.conectar();

        try
        {
            Main.conexion.send("UPDATE Product_Categories SET register_state = '*' WHERE product_type_code = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
            return ex.getMessage();
        }
                
        return "";
    }
    
    public ArrayList<Product_Categories> getLista()
    {
        Main.conexion.conectar();
        ArrayList<Product_Categories> categorias = new ArrayList<Product_Categories> ();
        
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT * FROM Product_Categories ORDER BY register_state DESC");
            
            while(resultado.next())
            {
                String codigo = resultado.getString("product_type_code");
                String descripcion = resultado.getString("product_type_description");
                String vat = resultado.getString("vat_rating");
                String estado = resultado.getString("register_state");
                
                Product_Categories categoria = new Product_Categories(codigo, descripcion, vat, estado);
                categorias.add(categoria);
            }
        }
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        
        return categorias;
    }
    
    public ArrayList<String> getActivos()
    {
        Main.conexion.conectar();
        ArrayList<String> categorias = new ArrayList<String> ();
        
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT product_type_description FROM Product_Categories WHERE register_state = 'A'");
            while(resultado.next())
                categorias.add(resultado.getString("product_type_description"));
        }
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        
        return categorias;
    }
    
    public void buscar(String codigo)
    {
        Main.conexion.conectar();
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT * FROM Product_Categories WHERE product_type_code = " + codigo);
            resultado.next();
            this.setProduct_type_code(resultado.getString("product_type_code"));
            this.setProduct_type_description(resultado.getString("product_type_description"));
            this.setVat_rating(resultado.getString("vat_rating"));
            this.setRegister_state(resultado.getString("register_state"));
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public ArrayList <Product_Categories> getList(int option, String name, String code) {
        Main.conexion.conectar();
        ArrayList <Product_Categories> categories = new ArrayList <> ();
        
        try {
            ResultSet result = null;
            
            switch(option) {
                case 0: result = Main.conexion.receive("SELECT * FROM PRODUCT_CATEGORIES WHERE product_type_description LIKE '" + name + "%' AND register_state = 'A'");
                        break;
                
                case 1: result = Main.conexion.receive("SELECT * FROM PRODUCT_CATEGORIES WHERE register_state = 'A'");
                        break;
                    
                case 2: result = Main.conexion.receive("SELECT * FROM PRODUCT_CATEGORIES WHERE product_type_code = " + code);
                        break;
            }
            
            while(result.next())
            {                
                Product_Categories category = new Product_Categories(result.getString("product_type_code"),
                        result.getString("product_type_description"),
                        result.getString("vat_rating"),
                        result.getString("register_state"));
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Product_Categories.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return categories;
    }
}