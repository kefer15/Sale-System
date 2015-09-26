package salesystem.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Accounts
{
    private String Account_id;
    private String Customer_id;
    private String Date_account_opened;
    private String Account_name;
    private String Other_account_details;
    private String Register_state;

    public Accounts() {
        this("-1",  "NULL",  "NULL",  "NULL",  "NULL",  "0");
    }

    public Accounts(String Account_id, String Customer_id, String Date_account_opened, String Account_name, String Other_account_details, String Register_state) 
    {
        this.Account_id = Account_id;
        this.Customer_id = Customer_id;
        this.Date_account_opened = Date_account_opened;
        this.Account_name = Account_name;
        this.Other_account_details = Other_account_details;
        this.Register_state = Register_state;
    }

    public void setAccount_id(String Account_id) 
    {
        this.Account_id = Account_id;
    }

    public String getAccount_id() 
    {
        return Account_id;
    }

    public void setCustomer_id(String Customer_id) 
    {
        this.Customer_id = Customer_id;
    }

    public String getCustomer_id() 
    {
        return Customer_id;
    }

    public void setDate_account_opened(String Date_account_opened) 
    {
        this.Date_account_opened = Date_account_opened;
    }

    public String getDate_account_opened() 
    {
        return Date_account_opened;
    }

    public void setAccount_name(String Account_name) 
    {
        this.Account_name = Account_name;
    }

    public String getAccount_name() 
    {
        return Account_name;
    }

    public void setOther_account_details(String Other_account_details) 
    {
        this.Other_account_details = Other_account_details;
    }

    public String getOther_account_details() 
    {
        return Other_account_details;
    }

    public void setRegister_state(String Register_state) 
    {
        this.Register_state = Register_state;
    }

    public String getRegister_state() 
    {
        return Register_state;
    }
    
    public String add()
    {
        Main.conexion.conectar();
        
        String err = "";
        
        try
        {
            Main.conexion.send("INSERT INTO ACCOUNTS VALUES(DEFAULT, '" + Customer_id + "', '" + Date_account_opened + "', '" + Account_name + "', '" + Other_account_details + "', '" + Register_state + "')");
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
        
        System.out.println(Account_id + "  " + Customer_id + "  " + Date_account_opened + "  " + Account_name + "  " + Other_account_details + "  " + Register_state);
        try
        {
            Main.conexion.send("UPDATE ACCOUNTS SET account_id = " + Account_id + ", customer_id = '" + Customer_id +  "', date_account_opened = '" + Date_account_opened +  "', account_name = '" + Account_name +  "', other_account_details = '" + Other_account_details +  "', Register_state = '" + Register_state + "' WHERE account_id = " + codigo);
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
            this.setRegister_state("*");
            Main.conexion.send("UPDATE ACCOUNTS SET Register_state = '" + Register_state + "' WHERE account_id = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
             err = ex.getMessage();
        }
        
        return err;
    }
    
    public ArrayList<Accounts> getList()
    {
        Main.conexion.conectar();
        ArrayList<Accounts> accounts = new ArrayList<Accounts> ();
        
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT * FROM ACCOUNTS ORDER BY Register_state DESC");
            
            while(resultado.next())
            {
                String codigo = resultado.getString("account_id");
                String customer = resultado.getString("customer_id");
                String date = resultado.getString("date_account_opened");
                String account_name = resultado.getString("account_name");
                String other_account_details = resultado.getString("other_account_details");
                String Register_state = resultado.getString("Register_state");
                
                Accounts account = new Accounts(codigo, customer, date, account_name, other_account_details, Register_state);
                accounts.add(account);
            }
            
        }
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
              
        return accounts;
    }
    
    public String active(String codigo)
    {
        String err = "";
        try
        {
            Main.conexion.conectar();
            this.setRegister_state("A");
            Main.conexion.send("UPDATE ACCOUNTS SET Register_state = " + Register_state + " WHERE account_id = " + codigo );
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
        ArrayList<ArrayList<String>> accounts = new ArrayList<ArrayList<String>>();
        
        try
        {        
            ResultSet resultado = Main.conexion.receive("SELECT account_id, customer_id, date_account_opened, account_name, other_account_details  FROM ACCOUNTS WHERE Register_state = A");
            while(resultado.next())
            {
                ArrayList<String> data = new ArrayList<String>();
                String codigo = resultado.getString("account_id");
                String customer = resultado.getString("customer_id");
                String date = resultado.getString("date_account_opened");
                String account_name = resultado.getString("account_name");
                String other = resultado.getString("other_account_details");
                
                data.add(codigo);
                data.add(customer);
                data.add(date);
                data.add(account_name);
                data.add(other);
                
                accounts.add(data);
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return accounts;
    }
    public void search(String codigo)
    {
        Main.conexion.conectar();
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT * FROM ACCOUNTS WHERE account_id = " + codigo);
            resultado.next();
            this.setAccount_id(resultado.getString("account_id"));
            this.setCustomer_id(resultado.getString("customer_id"));
            this.setDate_account_opened(resultado.getString("date_account_opened"));
            this.setAccount_name(resultado.getString("account_name"));
            this.setOther_account_details(resultado.getString("other_account_details"));
            this.setRegister_state(resultado.getString("Register_state"));
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
            ResultSet resultado = Main.conexion.receive("SELECT COUNT(*) FROM ACCOUNTS");
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
