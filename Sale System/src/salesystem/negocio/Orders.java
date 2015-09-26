package salesystem.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Orders
{
    String order_id;
    String customer_id;
    String date_order_placed;
    String total_amount;
    String order_details;
    String register_state;

    
    public Orders()
    {
          this("-1", "-1", "NULL", "-1", "NULL", "NULL");
    }
    
    public Orders(String order_id, String customer_id ,String date_order_placed, String total_amount, String order_details, String register_state) {
        this.order_id = order_id;
        this.customer_id = customer_id;
        this.date_order_placed = date_order_placed;
        this.total_amount = total_amount;
        this.order_details = order_details;
        this.register_state = register_state;

    }
    
    public void setOrder_id(String order_id)
    {
        this.order_id = order_id;
    }
    
    public String getOrder_id()
    {
        return order_id;
    }
    
    public void setCustomer_id(String customer_id)
    {
        this.customer_id = customer_id;
    }
    
    public String getCustomer_id()
    {
        return customer_id;
    }
    
    public void setDate_order_placed(String date_order_placed)
    {
        this.date_order_placed = date_order_placed;
    }
    
    public String getDate_order_placed()
    {
        return date_order_placed;
    }
    
    public void setTotal_amount(String total_amount)
    {
        this.total_amount = total_amount;
    }
    
    public String getTotal_amount()
    {
        return total_amount;
    }
    public String insertar()
    {
        Main.conexion.conectar();

        try
        {
            Main.conexion.send("INSERT INTO Customers VALUES('" + order_id + "', '" + customer_id + "', '" + 
                    date_order_placed + "', '" + total_amount + "', '" + order_details + "', '" + register_state + "')");
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
            Main.conexion.send("UPDATE Orders SET customer_id = '" + customer_id + "', "
                    + "date_order_placed = '" + date_order_placed + "', "
                    + "total_amount = '" + total_amount + "', "
                    + "order_details = '" + order_details + "' WHERE order_id = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
            return ex.getMessage();
        }
                
        return "";
    }
    
    public void setOrder_details(String order_details)
    {
        this.order_details = order_details;
    }
    
    public String getOrder_details()
    {
        return order_details;
    }
    
    public void setRegister_state(String register_state)
    {
        this.register_state = register_state;
    }
    
    public String getRegister_state()
    {
        return register_state;
    }
    
    public ArrayList<Orders> getLista()
    {
        Main.conexion.conectar();
        ArrayList<Orders> OrdersList = new ArrayList<Orders> ();
        
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT * FROM Orders ORDER BY order_id DESC");
            
            while(resultado.next())
            {
                String order_id = resultado.getString("order_id");
                String customer = resultado.getString("customer_id");
                String date = resultado.getString("date_order_placed");
                String total_amount = resultado.getString("total_amount");
                String details = resultado.getString("order_details");
                String register_State = resultado.getString("register_state");
                
                Orders Order = new Orders(order_id,customer,date,total_amount,details,register_State);
                
                OrdersList.add(Order);
            }
        }
        catch (SQLException ex)  { ex.printStackTrace(); }
        
        return OrdersList;
    }
}
