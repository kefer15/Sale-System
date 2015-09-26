package salesystem.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Invoice_Line_Items
{
    String order_item_id;
    String product_id;
    String invoice_number;
    String product_title;
    String product_quantity;
    String product_price;
    String derived_product_cost;
    String derived_vat_payable;
    String derived_total_cost;
    String other_line_item_details;
    String register_state;
    
    public Invoice_Line_Items()
    {
        this("-1", "-1", "-1", "NULL", "-1", "-1", "-1", "-1", "-1", "NULL", "-1");
    }
    
    public Invoice_Line_Items(  String order_item_id,
                                String product_id,
                                String invoice_number,
                                String product_title,
                                String product_quantity,
                                String product_price,
                                String derived_product_cost,
                                String derived_vat_payable,
                                String derived_total_cost,
                                String other_line_item_details,
                                String register_state)
    {
        this.order_item_id = order_item_id;
        this.product_id = product_id;
        this.invoice_number = invoice_number;
        this.product_title = product_title;
        this.product_quantity = product_quantity;
        this.product_price = product_price;
        this.derived_product_cost = derived_product_cost;
        this.derived_vat_payable = derived_vat_payable;
        this.derived_total_cost = derived_total_cost;
        this.other_line_item_details = other_line_item_details;
        this.register_state = register_state;
    }

    public String getOrder_item_id()
    {
        return order_item_id;
    }

    public void setOrder_item_id(String order_item_id)
    {
        this.order_item_id = order_item_id;
    }

    public String getProduct_id()
    {
        return product_id;
    }

    public void setProduct_id(String product_id)
    {
        this.product_id = product_id;
    }

    public String getInvoice_number()
    {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number)
    {
        this.invoice_number = invoice_number;
    }

    public String getProduct_title()
    {
        return product_title;
    }

    public void setProduct_title(String product_title)
    {
        this.product_title = product_title;
    }

    public String getProduct_quantity()
    {
        return product_quantity;
    }

    public void setProduct_quantity(String product_quantity)
    {
        this.product_quantity = product_quantity;
    }

    public String getProduct_price()
    {
        return product_price;
    }

    public void setProduct_price(String product_price)
    {
        this.product_price = product_price;
    }

    public String getDerived_product_cost()
    {
        return derived_product_cost;
    }

    public void setDerived_product_cost(String derived_product_cost)
    {
        this.derived_product_cost = derived_product_cost;
    }

    public String getDerived_vat_payable()
    {
        return derived_vat_payable;
    }

    public void setDerived_vat_payable(String derived_vat_payable)
    {
        this.derived_vat_payable = derived_vat_payable;
    }

    public String getDerived_total_cost()
    {
        return derived_total_cost;
    }

    public void setDerived_total_cost(String derived_total_cost)
    {
        this.derived_total_cost = derived_total_cost;
    }

    public String getOther_line_item_details()
    {
        return other_line_item_details;
    }

    public void setOther_line_item_details(String other_line_item_details)
    {
        this.other_line_item_details = other_line_item_details;
    }

    public String getRegister_state()
    {
        return register_state;
    }

    public void setRegister_state(String register_state)
    {
        this.register_state = register_state;
    }

    public String insert()
    {
        Main.conexion.conectar();
        String err = "";
        
        try
        {
            Main.conexion.send("INSERT INTO INVOICE_LINE_ITEMS VALUES(" + order_item_id + ", " + product_id + "," + invoice_number + 
                    ", '" + product_title + "'," + product_quantity + "," + product_price + "," + derived_product_cost + 
                    "," + derived_vat_payable + "," + derived_total_cost + ", '" +  other_line_item_details +  "' ,'" + register_state + "')");
            Main.conexion.desconectar();
        }
        catch(SQLException ex)
        {
            err = ex.getMessage();
        }
        
        return err;
    }
    
    public String update(String inv_line)
    {
        Main.conexion.conectar();
        
        String err = "";
        
        try
        {
            Main.conexion.send("UPDATE INVOICE_LINE_ITEMS SET product_id = " + product_id + ", invoice_number = " + invoice_number +  
                    ",product_title = '" +  product_title + "' ,product_quantity = " + product_quantity + 
                    ",product_price = " + product_price +  ",derived_product_cost = " + derived_product_cost +
                    ", derived_vat_payable = " + derived_vat_payable + ",derived_total_cost = " + derived_total_cost + 
                    ",other_line_item_details = '" + other_line_item_details + "',register_state = '" + register_state +
                    "' WHERE order_item_id = " + inv_line);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
            err = ex.getMessage();
        }
                
        return err;
    }
    
    public String remove(String inv_number)
    {
        String err = "";
        try
        {
            Main.conexion.conectar();
            this.setRegister_state("*");
            Main.conexion.send("UPDATE INVOICE_LINE_ITEMS SET register_state = '" + register_state + "' WHERE invoice_number = " + inv_number);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
             err = ex.getMessage();
        }
        
        return err;
    }
    
    public ArrayList <Invoice_Line_Items> getList(String order_item)
    {
        Main.conexion.conectar();
            
        ArrayList <Invoice_Line_Items> list_items = new ArrayList <> ();
        
        try
        {
            ResultSet result = Main.conexion.receive("SELECT * FROM INVOICE_LINE_ITEMS WHERE order_item_id = " + order_item);
            
            while(result.next())
            {                
                Invoice_Line_Items invoice_Line_Items = new Invoice_Line_Items(result.getString("order_item_id"),
                        result.getString("product_id"),
                        result.getString("invoice_number"),
                        result.getString("product_title"),
                        result.getString("product_quantity"),
                        result.getString("product_price"),
                        result.getString("derived_product_cost"),
                        result.getString("derived_vat_payable"),
                        result.getString("derived_total_cost"),
                        result.getString("other_line_item_details"),
                        result.getString("register_state"));
                list_items.add(invoice_Line_Items);
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        
        return list_items;
    }
        
    public void search(String order_item)
    {
        Main.conexion.conectar();
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT * FROM INVOICE_LINE_ITEMS WHERE order_item_id = " + order_item);
            resultado.next();
            this.setOrder_item_id(resultado.getString("order_item_id"));
            this.setProduct_id(resultado.getString("product_id"));
            this.setInvoice_number(resultado.getString("invoice_number"));
            this.setProduct_title(resultado.getString("product_title"));
            this.setProduct_quantity(resultado.getString("product_quantity"));
            this.setProduct_price(resultado.getString("product_price"));
            this.setDerived_product_cost(resultado.getString("derived_product_cost"));
            this.setDerived_vat_payable(resultado.getString("derived_vat_payable"));
            this.setDerived_total_cost(resultado.getString("derived_total_cost"));
            this.setOther_line_item_details(resultado.getString("other_line_item_details"));
            this.setRegister_state(resultado.getString("register_state"));
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }
}