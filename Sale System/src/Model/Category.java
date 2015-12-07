package Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
  @version 2.3
  @author Miguel Fernandez
 */

public class Category {
    private String strCode;
    private String strDescription;

    public Category() {
        this("-1","NULL");
    }
    
    /**
     * 
     * @param strCode
     * @param strDescription 
     */
    public Category(String strCode, String strDescription) {
        this.strCode = strCode;
        this.strDescription = strDescription;
    }
    
    /** Between this method we get the Category's code
     * @return  */
    public String getCode() {
        return strCode;
    }
    
    /**
     * @param strCode 
     */
    public void setCode(String strCode) {
        this.strCode = strCode;
    }
    
    /**
     * 
     * @return 
     */
    public String getDescription() {
        return strDescription;
    }
    
    /**
     * 
     * @param strDescription 
     */
    public void setDescription(String strDescription) {
        this.strDescription = strDescription;
    }
    
    /**
     *
     * @return
     */
    public static List <Category> getList() {
        Principal.CONECCTION.conect();
        List <Category> aryCategories = new ArrayList <Category> ();
        
        try {
            ResultSet cResult = Principal.CONECCTION.receive("SELECT CatCod, CatNom FROM Categoria");
            Category category = null;
            
            while(cResult.next()) {    
                category = new Category(
                cResult.getString("CatCod"),
                cResult.getString("CatNom"));
                aryCategories.add(category);
            }
            
            cResult.close();
            Principal.CONECCTION.disconect();
        } catch (SQLException cException) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, cException);
        }
        
        return aryCategories;
    }
}