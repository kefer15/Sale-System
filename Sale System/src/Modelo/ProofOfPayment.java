package Modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProofOfPayment {
    String code;
    String clientName;
    String date;
    String amount;
    String user;
    
    public ProofOfPayment(){
        this("-1","NULL","0000-00-00","0.0","-1");
    }
    
    public ProofOfPayment(String code, String clientName, String date, String amount, String user) {
        this.code = code;
        this.clientName = clientName;
        this.date = date;
        this.amount = amount;
        this.user = user;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public String insertCab() {
        Main.conexion.conectar();
        String err = "";
        
        try {
            System.out.println("INSERT INTO Comprobante_Cab VALUES( DEFAULT , '" + clientName + "' , " + amount + " , '" + 
                    date + "' , " + user + " )");
            Main.conexion.send("INSERT INTO Comprobante_Cab VALUES( DEFAULT , '" + clientName + "' , " + amount + " , '" + 
                    date + "' , " + user + " )");
            
            Main.conexion.desconectar();
        } catch (SQLException ex) {
            err = ex.getMessage();
        }
        
        return err;
    }
    
    public String insertDet(ArrayList <String> products, ArrayList <Integer> quantities, String number) {
        Main.conexion.conectar();
        String err = "";
        
        try {
            for(int i = 0;i < products.size();i++)
                Main.conexion.send("INSERT INTO Comprobante_Det VALUES( " + number + " , " + products.get(i) + " , " + quantities.get(i) + " )");
            
            Main.conexion.desconectar();
        } catch (SQLException ex) {
            err = ex.getMessage();
        }
        
        return err;
    }
    
    public ArrayList <ProofOfPayment> getList(String code) {
        Main.conexion.conectar();
        ArrayList <ProofOfPayment> payments = new ArrayList <> ();
        
        try {
            ResultSet result = Main.conexion.receive("SELECT * FROM Comprobante_Cab WHERE ComCod LIKE '" + code + "%'");
            
            while(result.next())
            {                
                ProofOfPayment payment = new ProofOfPayment();
                payment.setCode(result.getString("ComCod"));
                payment.setClientName(result.getString("CabNomCli"));
                payment.setAmount(result.getString("ComMon"));
                payment.setDate(result.getString("ComFec"));
                payment.setUser(result.getString("UsuCod"));
                
                payments.add(payment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return payments;
    }
    
    public String getNextCode() {
        Main.conexion.conectar();
        
        try {
            ResultSet result = Main.conexion.receive("SELECT MAX(ComCod) FROM Comprobante_Cab");
                        
            while(result.next())
                return result.getString("MAX(ComCod)");
        } catch (SQLException ex) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }    
    
    public ArrayList <ProofOfPayment> getList(String dateStart, String dateEnd) {
        Main.conexion.conectar();
        ArrayList <ProofOfPayment> payments = new ArrayList <> ();
        
        try {
            ResultSet result = Main.conexion.receive("SELECT * FROM Comprobante WHERE ComFec >= '" + dateStart + "' AND ComFec <= '" + dateEnd + "'");
            
            while(result.next())
            {                
                ProofOfPayment payment = new ProofOfPayment();
                payment.setCode(result.getString("ComCod"));
                payment.setClientName("");
                payment.setAmount(result.getString("ComMon"));
                payment.setDate(result.getString("ComFec"));
                payment.setUser(result.getString("UsuNom"));
                
                payments.add(payment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return payments;
    }
    
    public ArrayList <ProofOfPayment> getUsersMount(String dateStart, String dateEnd) {
        Main.conexion.conectar();
        ArrayList <ProofOfPayment> payments = new ArrayList <> ();
        
        try {
            ResultSet result = Main.conexion.receive("SELECT UsuNom, SUM(ComMon) FROM Comprobante WHERE ComFec >= '" + dateStart + "' AND ComFec <= '" + dateEnd + "' GROUP By UsuNom");
            
            while(result.next())
            {                
                ProofOfPayment payment = new ProofOfPayment();
                payment.setCode("");
                payment.setClientName("");
                payment.setAmount(result.getString("SUM(ComMon)"));
                payment.setDate("");
                payment.setUser(result.getString("UsuNom"));
                
                payments.add(payment);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProofOfPayment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return payments;
    }
}
