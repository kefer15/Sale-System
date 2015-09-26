package salesystem.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Transaction_Types
{
    private String Transaction_type_code;
    private String Transaction_type_description;
    private String Transaction_types_register_state;

    public Transaction_Types()
    {
        this("-1", "NULL", "0");
    }

    public Transaction_Types(String Transaction_type_code, String Transaction_type_description, String Transaction_types_register_state) 
    {
        this.Transaction_type_code = Transaction_type_code;
        this.Transaction_type_description = Transaction_type_description;
        this.Transaction_types_register_state = Transaction_types_register_state;
    }
    
    public void setTransaction_type_code(String Transaction_type_code) 
    {
        this.Transaction_type_code = Transaction_type_code;
    }
    
    public String getTransaction_type_code() 
    {
        return Transaction_type_code;
    }

    public String getTransaction_type_description() 
    {
        return Transaction_type_description;
    }

    public void setTransaction_type_description(String Transaction_type_description) 
    {
        this.Transaction_type_description = Transaction_type_description;
    }
    
    public String getTransaction_types_register_state() 
    {
        return Transaction_types_register_state;
    }
    
    public void setTransaction_types_register_state(String Transaction_types_register_state) 
    {
        this.Transaction_types_register_state = Transaction_types_register_state;
    }
    
    public String add()
    {
        Main.conexion.conectar();
        
        String err = "";

        try
        {
            Main.conexion.send("INSERT INTO TRANSACTION_TYPES VALUES(DEFAULT, '" + Transaction_type_description + "', '" + Transaction_types_register_state + "')");
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
            err = ex.getMessage();
        }
        
        return err;
    }
    
    public String update(String codigo)
    {
        Main.conexion.conectar();
        
        String err = "";
        
        try
        {
            Main.conexion.send("UPDATE TRANSACTION_TYPES SET transaction_type_code = " + Transaction_type_code + ", transaction_type_description = '" + Transaction_type_description +  "', register_state = '" + Transaction_types_register_state + "' WHERE transaction_type_code = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
            err = ex.getMessage();
        }
                
        return err;
    }
    
    public String remove(String codigo)
    {
        String err = "";
        try
        {
            Main.conexion.conectar();
            this.setTransaction_types_register_state("*");
            Main.conexion.send("UPDATE TRANSACTION_TYPES SET register_state = '" + Transaction_types_register_state + "' WHERE transaction_type_code = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
             err = ex.getMessage();
        }
        
        return err;
    }
    
    public ArrayList<Transaction_Types> getList()
    {
        Main.conexion.conectar();
        ArrayList<Transaction_Types> transactionTypes = new ArrayList<Transaction_Types> ();
        
        try
        {
            
            ResultSet resultado = Main.conexion.receive("SELECT * FROM TRANSACTION_TYPES ORDER BY register_state DESC");
            
            while(resultado.next())
            {
                String codigo = resultado.getString("transaction_type_code");
                String descripcion = resultado.getString("transaction_type_description");
                String estado = resultado.getString("register_state");
                
                Transaction_Types transactionType = new Transaction_Types(codigo, descripcion, estado);
                transactionTypes.add(transactionType);
            }
            
        }
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
              
        return transactionTypes;
    }
    
    public String active(String codigo)
    {
        String err = "";
        try
        {
            Main.conexion.conectar();
            this.setTransaction_types_register_state("A");
            Main.conexion.send("UPDATE TRANSACTION_TYPES SET register_state = " + Transaction_types_register_state + " WHERE transaction_type_code = " + codigo );
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
             err = ex.getMessage();
        }
        return err;
    }
    public ArrayList<ArrayList<String>> getActives()
    {
        Main.conexion.conectar();
        ArrayList<ArrayList<String>> transactionTypes = new ArrayList<ArrayList<String>>();
        
        try
        {        
            ResultSet resultado = Main.conexion.receive("SELECT transaction_type_code, transaction_type_description FROM TRANSACTION_TYPES WHERE register_state = A");
            while(resultado.next())
            {
                ArrayList<String> data = new ArrayList<String>();
                String codigo = resultado.getString("transaction_type_code");
                String descripcion = resultado.getString("transaction_type_description");
                data.add(codigo);
                data.add(descripcion);
                transactionTypes.add(data);
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return transactionTypes;
    }
    
    public void search(String codigo)
    {
        Main.conexion.conectar();
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT * FROM TRANSACTION_TYPES WHERE transaction_type_code = " + codigo);
            resultado.next();
            this.setTransaction_type_code(resultado.getString("transaction_type_code"));
            this.setTransaction_type_description(resultado.getString("transaction_type_description"));
            this.setTransaction_types_register_state(resultado.getString("register_state"));
            
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }      
    }
    
    public String count()
    {
        String c = "0";
        Main.conexion.conectar();
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT COUNT(*) FROM TRANSACTION_TYPES");
            resultado.next();
            c = resultado.getString("COUNT(*)");
         }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return c;
    }
}
