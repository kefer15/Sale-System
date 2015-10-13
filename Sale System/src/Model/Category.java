package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Category {
    private String strCode;
    private String strDescription;

    public Category() {
        this("-1","NULL");
    }
    
    public Category(String strCode, String strDescription) {
        this.strCode = strCode;
        this.strDescription = strDescription;
    }

    public String getCode() {
        return strCode;
    }

    public void setCode(String strCode) {
        this.strCode = strCode;
    }

    public String getDescription() {
        return strDescription;
    }

    public void setDescription(String strDescription) {
        this.strDescription = strDescription;
    }
    
    public ArrayList <Category> getList() {
        Main.cConexion.conect();
        ArrayList <Category> aryCategories = new ArrayList <> ();
        
        try {
            ResultSet cResult = Main.cConexion.receive("SELECT * FROM Categoria");
            
            while(cResult.next())
            {    
                Category category = new Category(
                        cResult.getString("CatCod"),
                        cResult.getString("CatNom"));
                aryCategories.add(category);
            }
        } catch (SQLException cException) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryCategories;
    }
}