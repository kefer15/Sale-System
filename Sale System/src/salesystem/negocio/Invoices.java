package salesystem.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Invoices
{
    String invoice_number;
    String order_id;
    String invoice_date;
    String invoice_details;
    String register_state;
    
    public Invoices()
    {
        this("-1", "-1", "NULL", "NULL", "*");
    }
    
    public Invoices(String invoice_number, String order_id, String invoice_date, String invoice_details, String register_state)
    {
        this.invoice_number = invoice_number;
        this.order_id = order_id;
        this.invoice_date = invoice_date;
        this.invoice_details = invoice_details;
        this.register_state = register_state;
    }

    public String getInvoice_number()
    {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number)
    {
        this.invoice_number = invoice_number;
    }

    public String getOrder_id()
    {
        return order_id;
    }

    public void setOrder_id(String order_id)
    {
        this.order_id = order_id;
    }

    public String getInvoice_date()
    {
        return invoice_date;
    }

    public void setInvoice_date(String invoice_date)
    {
        this.invoice_date = invoice_date;
    }

    public String getInvoice_details()
    {
        return invoice_details;
    }

    public void setInvoice_details(String invoice_details)
    {
        this.invoice_details = invoice_details;
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
            Main.conexion.send("INSERT INTO INVOICES(DEFAULT, " + order_id + ", '" + invoice_date + 
                    "', '" + invoice_details + "', '" + register_state + "')");
            Main.conexion.desconectar();
        }
        catch(SQLException ex)
        {
            err = ex.getMessage();
        }
        
        return err;
    }
    
    public String update(String inv_number)
    {
        Main.conexion.conectar();
        
        String err = "";
        
        try {
            Main.conexion.send( "UPDATE INVOICES order_id = " + order_id +
                                ", invoice_date = '" + invoice_date +  
                                "', invoice_details = '" +  invoice_details +
                                "', register_state = '" + register_state +
                                "' WHERE invoice_number = " + inv_number);
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
            Main.conexion.send("UPDATE INVOICES SET register_state = '" + register_state + "' WHERE invoice_number = " + inv_number);
            Main.conexion.desconectar();
        }
        catch(SQLException ex)
        {
            err = ex.getMessage();
        }
        
        return err;
    }
    
    public ArrayList <Invoices> getList()
    {
        Main.conexion.conectar();
        ArrayList <Invoices> list_items = new ArrayList <> ();
        
        try
        {
            ResultSet result = Main.conexion.receive("SELECT * FROM INVOICES ORDER BY register_state DESC");
            
            while(result.next())
            {                
                Invoices invoice = new Invoices(result.getString("invoice_number"),
                        result.getString("order_id"),
                        result.getString("invoice_date"),
                        result.getString("invoice_details"),
                        result.getString("register_state"));
                list_items.add(invoice);
            }
        } catch (SQLException ex) { ex.printStackTrace(); }
        
        return list_items;
    }
    
    public void search(String inv_number)
    {
        Main.conexion.conectar();
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT * FROM INVOICES WHERE invoice_number = " + inv_number);
            resultado.next();
            this.setInvoice_number(resultado.getString("invoice_number"));
            this.setOrder_id(resultado.getString("order_id"));
            this.setInvoice_date(resultado.getString("invoice_date"));
            this.setInvoice_details(resultado.getString("invoice_details"));
            this.setRegister_state(resultado.getString("register_state"));
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public String getNextNumber()
    {
        Main.conexion.conectar();
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT COUNT(*) FROM INVOICES");
            resultado.next();
            String current = resultado.getString("count(*)");
            return String.valueOf(Integer.parseInt(current) + 1);
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return "-1";
    }
}
