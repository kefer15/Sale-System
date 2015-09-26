package salesystem.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customers
{
    String customer_id;
    String first_name;
    String middle_name;
    String last_name;
    String gender;
    String email;
    String phone;
    String address;
    String other;
    String state;

    public Customers() {
        this("-1", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "NULL", "*");
    }

    
    public Customers(String customer_id, String first_name, String middle_name, String last_name, String gender, String email, String phone, String address, String other, String state) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.other = other;
        this.state = state;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String insertar()
    {
        Main.conexion.conectar();

        try
        {
            Main.conexion.send("INSERT INTO Customers VALUES(DEFAULT, '" + first_name + "', '" + middle_name + "', '" + 
                    last_name + "', '" + gender + "', '" + email + "', '" + phone + "', '" + address + "', '" +
                    other  + "', '" + state + "')");
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
            Main.conexion.send("UPDATE Customers SET customer_first_name = '" + first_name + "', "
                    + "customer_middle_initial = '" + middle_name + "', "
                    + "customer_last_name = '" + last_name + "', "
                    + "gender = '" + gender + "', "
                    + "email_address = '" + email + "', "
                    + "phone_number = '" + phone + "', "
                    + "addres_details = '" + address + "', "
                    + "other_details = '" + other + "' WHERE customer_id = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
            return ex.getMessage();
        }
                
        return "";
    }
    
    public String eliminar(String codigo)
    {
        Main.conexion.conectar();

        try
        {
            Main.conexion.send("UPDATE Customers SET register_state = '*' WHERE customer_id = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
            return ex.getMessage();
        }
                
        return "";
    }
    
    public void buscar(String codigo)
    {
        Main.conexion.conectar();
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT * FROM Customers WHERE customer_id = " + codigo);
            resultado.next();
            this.setFirst_name(resultado.getString("Customer_first_name"));
            this.setMiddle_name(resultado.getString("customer_middle_initial"));
            this.setLast_name(resultado.getString("customer_last_name"));
            this.setGender(resultado.getString("gender"));
            this.setEmail(resultado.getString("email_address"));
            this.setPhone(resultado.getString("phone_number"));
            this.setAddress(resultado.getString("addres_details"));
            this.setOther(resultado.getString("other_details"));
            this.setState(resultado.getString("register_state"));
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Customers> getLista()
    {
        Main.conexion.conectar();
        ArrayList<Customers> customerList = new ArrayList<Customers> ();
        
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT * FROM Customers ORDER BY register_state DESC");
            
            while(resultado.next())
            {
                String codigo = resultado.getString("customer_id");
                String first_name = resultado.getString("customer_first_name");
                String middle_name = resultado.getString("customer_middle_initial");
                String last_name = resultado.getString("customer_last_name");
                String gender = resultado.getString("gender");
                String e_mail = resultado.getString("email_address");
                String phone = resultado.getString("phone_number");
                String address = resultado.getString("addres_details");
                String other = resultado.getString("other_details");
                String estate = resultado.getString("register_state");
                
                Customers customer = new Customers(codigo, first_name, middle_name, 
                        last_name, gender, e_mail, phone, address, other, estate);
                
                customerList.add(customer);
            }
        }
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return customerList;
    }
    
}
