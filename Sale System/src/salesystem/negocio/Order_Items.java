package salesystem.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class Order_Items
{
    String order_item_id;
    String order_id;
    String product_id;
    String product_quantity;
    String order_item_cost;
    String other_order_item_details;
    String register_state;
    
     public Order_Items(){
        this("-1","-1","-1","-1","-1","NULL","NULL");
    }
    
    public Order_Items(String order_item_id, String order_id, String product_id,String product_quantity, 
            String order_item_cost, String other_order_item_details, String register_state){
        this.order_item_id = order_item_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.product_quantity = product_quantity;
        this.order_item_cost = order_item_cost;
        this.other_order_item_details = other_order_item_details;
        this.register_state = register_state;
    }
    
    public String getOrder_item_id() {
        return order_item_id;
    }
    
    public void setOrder_item_id(String order_item_id) {
        this.order_item_id = order_item_id;
    }
    
    public String getOrder_id() {
        return order_id;
    }
    
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }
    
    public String getProduct_id() {
        return product_id;
    }
    
    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }
    
    public String getProduct_quantity() {
        return product_quantity;
    }
    
    public void setProduct_quantity(String product_quantity) {
        this.product_quantity = product_quantity;
    }
    
    public String getOrder_item_cost() {
        return order_item_cost;
    }
    
    public void setOrder_item_cost(String order_item_cost) {
        this.order_item_cost = order_item_cost;
    }
    
    public String getOther_order_item_details() {
        return other_order_item_details;
    }
    
    public void setOther_order_item_details(String other_order_item_details) {
        this.other_order_item_details = other_order_item_details;
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
            Main.conexion.send("INSERT INTO ORDER_ITEMS VALUES(DEFAULT, " + order_id + "," + product_id + "," + product_quantity +
                    "," + order_item_cost + ", '" + other_order_item_details +  "' , '" + register_state + "')");
            Main.conexion.desconectar();
        } catch (SQLException ex) { err = ex.getMessage(); }
        
        return err;
    } 
    
    public String update(String order_id)
    {
        Main.conexion.conectar();
        
        String err = "";
        
        try {
            Main.conexion.send("UPDATE ORDER_ITEMS SET order_item_id = " + order_item_id +  
                    ",product_id = " +  product_id + ",product_quantity = " + product_quantity + 
                    ",order_item_cost = " + order_item_cost +  ",other_order_item_details = '" + other_order_item_details +
                    "',register_state = '" + register_state + "' WHERE order_id = " + order_id);
            Main.conexion.desconectar();
        }
        catch (SQLException ex) { err = ex.getMessage(); }
                
        return err;
    }
    
    public String remove(String order_id)
    {
        String err = "";
        try {
            Main.conexion.conectar();
            this.setRegister_state("*");
            Main.conexion.send("UPDATE ORDER_ITEMS SET register_state = '" + register_state + "' WHERE order_id = " + order_id);
            Main.conexion.desconectar();
        }
        catch (SQLException ex) { err = ex.getMessage(); }
        
        return err;
    }
    
    public ArrayList <Order_Items> getList(String order_id)
    {
        Main.conexion.conectar();
            
        ArrayList <Order_Items> list_items = new ArrayList <> ();
        
        try {
            ResultSet result = Main.conexion.receive("SELECT * FROM ORDER_ITEMS WHERE order_id = " + order_id);
            
            while(result.next())
            {                
               Order_Items order_Items = new Order_Items(result.getString("order_item_id"),
                        result.getString("order_id"),
                        result.getString("product_id"),
                        result.getString("product_quantity"),
                        result.getString("order_item_cost"),
                        result.getString("other_order_item_details"),
                        result.getString("register_state"));
                list_items.add(order_Items);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        
        return list_items;
    }
    
    public void search(String order_id)
    {
        Main.conexion.conectar();
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT * FROM ORDER_ITEMS WHERE order_id = " + order_id);
            resultado.next();
            this.setOrder_item_id(resultado.getString("order_item_id"));
            this.setProduct_id(resultado.getString("product_id"));
            this.setProduct_quantity(resultado.getString("product_quantity"));
            this.setOrder_item_cost(resultado.getString("order_item_cost"));
            this.setOther_order_item_details(resultado.getString("other_order_item_details"));
            this.setRegister_state(resultado.getString("register_state"));
        }
        catch (SQLException ex) { ex.printStackTrace(); }
    }
    
    public ArrayList <Invoice_Line_Items> getInvoices(String order_id)
    {
        Main.conexion.conectar();
        ArrayList <Invoice_Line_Items> list_items = new ArrayList <> ();
        
        try {
            ResultSet result = Main.conexion.receive("SELECT order_item_id, Products.product_id, product_name, product_quantity, product_price, ORDER_ITEMS.register_state " +
            "FROM ORDER_ITEMS " +
            "INNER JOIN Products ON Products.product_id = ORDER_ITEMS.product_id " +
            "WHERE order_id = " + order_id + " AND ORDER_ITEMS.register_state = 'A'");
            while(result.next())
            {
                Invoice_Line_Items inv_Items = new Invoice_Line_Items(
                        result.getString("order_item_id"),
                        result.getString("product_id"),
                        "",
                        result.getString("product_name"),
                        result.getString("product_quantity"),
                        result.getString("product_price"),
                        "",
                        "",
                        "",
                        "",
                        result.getString("register_state"));
                list_items.add(inv_Items);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        
        return list_items;
    }
}
