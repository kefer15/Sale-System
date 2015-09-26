package salesystem.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Financial_Transactions
{
    private String transaction_id;
    private String account_id;
    private String invoice_number;
    private String transaction_type_code;
    private String transaction_date;
    private String transaction_amount;
    private String other_transaction_details;
    private String register_state;
    
    public Financial_Transactions()
    {
        this("-1","NULL","NULL","NULL","NULL","NULL","NULL","A");
    }
    
    public Financial_Transactions(String transaction_id, String account_id, String invoice_number, String transaction_type_code, String transaction_date, String transaction_amount, String other_transaction_details, String register_state)
    {
        this.transaction_id = transaction_id;
        this.account_id = account_id;
        this.invoice_number = invoice_number;
        this.transaction_type_code = transaction_type_code;
        this.transaction_date = transaction_date;
        this.transaction_amount = transaction_amount;
        this.other_transaction_details = other_transaction_details;
        this.register_state = register_state;        
    }
    public void setTransaction_id(String transaction_id)
    {
        this.transaction_id = transaction_id;
    }
    public String getTransaction_id()
    {
        return transaction_id;
    }
    
    public void setAccount_id(String account_id)
    {
        this.account_id = account_id;
    }
     public String getAccount_id()
    {
        return account_id;
    }
     public void setInvoice_number(String invoice_number)
    {
        this.invoice_number = invoice_number;
    }
    
    public String getInvoice_number()
    {
        return invoice_number;
    }
    
    public void setTransaction_type_code(String transaction_type_code)
    {
        this.transaction_type_code = transaction_type_code;
    }
    
    public String getTransaction_type_code()
    {
        return transaction_type_code;
    }
    
    public void setTransaction_date(String transaction_date)
    {
        this.transaction_date = transaction_date;
    }
        
    public String getTransaction_date()
    {
        return transaction_date;
    }
    
    public void setTransaction_amount(String transaction_amount)
    { 
        this.transaction_amount = transaction_amount;
    }
    
    public String getTransaction_amount()
    {
        return transaction_amount;
    }
    
    public void setOther_transaction_details(String other_transaction_details)
    {
        this.other_transaction_details = other_transaction_details;
    }
    
    public String getOther_transaction_details()
    {
        return other_transaction_details;
    }      
    
    public void setRegister_state(String  register_state)
    {
        this.register_state = register_state;
    }
    
    public String getRegister_state()
    {
        return register_state;
    }
      
    public String insertar()
    {
        Main.conexion.conectar();
        
        String err = "";
        
        try
        {
            Main.conexion.send("INSERT INTO FINANCIAL_TRANSACTIONS VALUES( null, " + account_id + ","+ invoice_number +","+ transaction_type_code + ",'"+ transaction_date +"',"+ transaction_amount +",'"+ other_transaction_details +"','" + register_state + "')");
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
            err = ex.getMessage();
        }
        
        return err;
    }
    
    public String actualizar(String codigo)
    {
        Main.conexion.conectar();
        
        String err = "";
        
        try
        {
            Main.conexion.send("UPDATE FINANCIAL_TRANSACTIONS SET transaction_id = " + transaction_id + ", account_id = " + account_id +  ", invoice_number = " + invoice_number +  ", transaction_type_code = " + transaction_type_code + ", transaction_date = '" + transaction_date  + "', transaction_amount = " + transaction_amount + ", other_transaction_details = '" + other_transaction_details + "', register_state = '" + register_state + "' WHERE transaction_id = " + codigo);
            Main.conexion.desconectar();  
        }
        catch (SQLException ex)
        {
            err = ex.getMessage();
        }
                
        return err;
    }
    
    public String eliminar(String codigo)
    {
        String err = "";
        try
        {
            Main.conexion.conectar();
            this.setRegister_state("*");
            Main.conexion.send("UPDATE FINANCIAL_TRANSACTIONS SET register_state = " + "'*'" + " WHERE  transaction_id = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
             err = ex.getMessage();
        }
        
        return err;
    }
    
    public ArrayList<Financial_Transactions> getLista()
    {
        Main.conexion.conectar();
        ArrayList<Financial_Transactions> financial_transactions = new ArrayList<Financial_Transactions> ();
        
        try
        {
            
            ResultSet resultado = Main.conexion.receive("SELECT * FROM FINANCIAL_TRANSACTIONS ORDER BY register_state DESC");
            
            while(resultado.next())
            {
                String codigo = resultado.getString("transaction_id");
                String cuenta = resultado.getString("account_id");
                String factura = resultado.getString("invoice_number");
                String tipo = resultado.getString("transaction_type_code");
                String fecha = resultado.getString("transaction_date");
                String cantidad = resultado.getString("transaction_amount");
                String detalles = resultado.getString("other_transaction_details");
                String estado = resultado.getString("register_state");
                
               
                Financial_Transactions financial_transaction = new Financial_Transactions(codigo, cuenta, factura, tipo, fecha, cantidad, detalles, estado);
                financial_transactions.add(financial_transaction);
            }
            
        }
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
              
        return financial_transactions;
    }
    
    
    public String activar(String codigo)
    {
        String err = "";
        try
        {
            Main.conexion.conectar();
            this.setRegister_state("A");
            Main.conexion.send("UPDATE FINANCIAL_TRANSACTIONS SET register_state = " + "'A'" + " WHERE  transaction_id =" + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
             err = ex.getMessage();
        }
        return err;
    }
    
    /*public String desactivar(String codigo)
    {
        String err = "";
        try
        {
            Main.conexion.conectar();
            this.setUniEstReg("2");
            Main.conexion.send("UPDATE GZZ_UNIDAD SET UniEstReg = " + 2 + " WHERE UniCod = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
             err = ex.getMessage();
        }
        return err;
    }
    */
    public ArrayList<ArrayList<String>> getActivos()
    {
        Main.conexion.conectar();
        ArrayList<ArrayList<String>> financial_transactions = new ArrayList<ArrayList<String>>();
        
        try
        {    
            ResultSet resultado = Main.conexion.receive("SELECT transaction_id, account_id,invoice_number,transaction_type_code,transaction_date,transaction_amount,other_transaction_details FROM FINANCIAL_TRANSACTIONS WHERE register_state = A");
            while(resultado.next())
            {
                ArrayList<String> data = new ArrayList<String>();
                String codigo = resultado.getString("transaction_id");
                String cuenta = resultado.getString("account_id");
                String factura = resultado.getString("invoice_number");
                String tipo = resultado.getString("transaction_type_code");
                String fecha = resultado.getString("transaction_date");
                String cantidad = resultado.getString("transaction_amount");
                String detalles = resultado.getString("other_transaction_details");
                String estado = resultado.getString("register_state");
                
                data.add(codigo);
                data.add(cuenta);
                data.add(factura);
                data.add(tipo);
                data.add(fecha);
                data.add(cantidad);
                data.add(detalles);
                data.add(estado);
                financial_transactions.add(data);
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return financial_transactions;
    }
    
    public void buscar(String codigo)
    {
        Main.conexion.conectar();
        try
        {
            
            ResultSet resultado = Main.conexion.receive("SELECT * FROM FINANCIAL_TRANSACTIONS WHERE  transaction_id =" + codigo);
            resultado.next();
            this.setTransaction_id(resultado.getString("transaction_id"));
            this.setAccount_id(resultado.getString("account_id"));
            this.setInvoice_number(resultado.getString("invoice_number"));
            this.setTransaction_type_code(resultado.getString("transaction_type_code"));
            this.setTransaction_date(resultado.getString("transaction_date"));
            this.setTransaction_amount(resultado.getString("transaction_amount"));
            this.setOther_transaction_details(resultado.getString("other_transaction_details"));
            this.setRegister_state(resultado.getString("register_state"));
            
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }              
    }
}
