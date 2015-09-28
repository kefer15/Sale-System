package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Suppliers {
    private String code;
    private String name;
    private String tr;
    private String phone;
    private String address;
    private String state;
    
    public Suppliers(){
        this("-1","NULL","NULL","NULL","NULL","-1");
    }   
    
    public Suppliers(String code, String name, String tr, String phone, String address, String state) {
        this.code = code;
        this.name = name;
        this.tr = tr;
        this.phone = phone;
        this.address = address;
        this.state = state;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTr() {
        return tr;
    }

    public void setTr(String tr) {
        this.tr = tr;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    public String insert() {
        Main.conexion.conectar();
        String err = "";
        
        try {
            Main.conexion.send("INSERT INTO Proveedor VALUES( DEFAULT , '" + name + "' , '" +
                    tr + "' , '" + phone + "' , '" + address + "' , " + state + " )");
            
            Main.conexion.desconectar();
        } catch (SQLException ex) {
            err = ex.getMessage();
        }
        
        return err;
    }
    
    public String update() {
        Main.conexion.conectar();
        String err = "";  
        
        try {         
            System.out.println("UPDATE Proveedor SET ProNom = '" + name + 
                    "' , ProRuc = '" + tr + "' , ProTel = '" + phone +  
                    "' , ProDir = '" + address + "' WHERE ProCod = " + code);
            Main.conexion.send("UPDATE Proveedor SET ProNom = '" + name + 
                    "' , ProRuc = '" + tr + "' , ProTel = '" + phone +  
                    "' , ProDir = '" + address + "' WHERE ProCod = " + code);
            
            Main.conexion.desconectar();  
        } catch (SQLException ex) {
            err = ex.getMessage();
        }
                
        return err;
    }
    
    public String remove(String supplier_code) {
        Main.conexion.conectar();
        String err = "";
        
        try {
            Main.conexion.send("UPDATE Proveedor SET EstCod = '2' WHERE ProCod = " + supplier_code);
            Main.conexion.desconectar();
        } catch (SQLException ex) {
             err = ex.getMessage();
        }
        
        return err;
    }
    
    public ArrayList <Suppliers> getList(int option, String code, String name) {
        Main.conexion.conectar();
        ArrayList <Suppliers> suppliers = new ArrayList <> ();
        
        try {
            ResultSet result = null;
            
            switch(option){                    
                case 0: result = Main.conexion.receive("SELECT * FROM Proveedor");
                        break;
                        
                case 1: result = Main.conexion.receive("SELECT * FROM Proveedor WHERE ProCod = " + code);
                        break;
                    
                case 2: result = Main.conexion.receive("SELECT * FROM Proveedor WHERE EstCod = 1 AND ProNom LIKE '" + name + "%'");
                        break;
            }
            
            while(result.next())
            {                
                Suppliers supplier = new Suppliers();
                
                supplier.setCode(result.getString("ProCod"));
                supplier.setName(result.getString("ProNom"));
                supplier.setTr(result.getString("ProRuc"));
                supplier.setPhone(result.getString("ProTel"));
                supplier.setAddress(result.getString("ProDir"));
                supplier.setState(result.getString("EstCod"));
                
                suppliers.add(supplier);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Suppliers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return suppliers;
    }    
    
    public String link(boolean []state, ArrayList <String> products, String supplier) {
        Main.conexion.conectar();
        String err = "";
        
        try {
            for(int i = 0;i < products.size();i++)
                if(state[i])
                    Main.conexion.send("INSERT INTO ProProd VALUES( " + supplier + " , " + products.get(i) + " )");
           
            Main.conexion.desconectar();
        } catch (SQLException ex) {
             err = ex.getMessage();
        }
        
        return err;
    }
}
