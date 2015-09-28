package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Category {
    private String code;
    private String description;

    public Category() {
        this("-1","NULL");
    }
    
    public Category(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public ArrayList <Category> getList() {
        Main.conexion.conectar();
        ArrayList <Category> categories = new ArrayList <> ();
        
        try {
            ResultSet result = Main.conexion.receive("SELECT * FROM Categoria");
            
            while(result.next())
            {    
                Category category = new Category(
                        result.getString("CatCod"),
                        result.getString("CatNom"));
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return categories;
    }
}
