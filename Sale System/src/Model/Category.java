package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @version 2.3
 * @author Miguel Fernández
 */

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
    
    /** Between this method we get the Category's code
     * @return  */
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
    
    /**
     *
     * @return
     */
    public static ArrayList <Category> getList() {
        Principal.cConexion.conect();
        ArrayList <Category> aryCategories = new ArrayList <Category> ();
        
        try {
            ResultSet cResult = Principal.cConexion.receive("SELECT CatCod, CatNom FROM Categoria");
            Category category = null;
            
            while(cResult.next()) {    
                category = new Category(
                cResult.getString("CatCod"),
                cResult.getString("CatNom"));
                aryCategories.add(category);
            }
            
            Principal.cConexion.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryCategories;
    }
}