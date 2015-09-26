package salesystem.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Unidad_Ej
{
    private String UniCod;
    private String UniDes;
    private String UniEstReg;
    
    public Unidad_Ej()
    {
        this("-1", "NULL", "0");
    }
    
    public Unidad_Ej(String UniCod, String UniDes, String UniEstReg)
    {
        this.UniCod = UniCod;
        this.UniDes = UniDes;
        this.UniEstReg = UniEstReg;
    }

    public String getUniCod()
    {
        return UniCod;
    }

    public void setUniCod(String UniCod)
    {
        this.UniCod = UniCod;
    }

    public String getUniDes()
    {
        return UniDes;
    }

    public void setUniDes(String UniDes)
    {
        this.UniDes = UniDes;
    }

    public String getUniEstReg()
    {
        return UniEstReg;
    }

    public void setUniEstReg(String UniEstReg)
    {
        this.UniEstReg = UniEstReg;
    }
    
    public String insertar()
    {
        Main.conexion.conectar();
        
        String err = "";
        
        try
        {
            Main.conexion.send("INSERT INTO GZZ_UNIDAD VALUES(" + UniCod + ", '" + UniDes + "', " + UniEstReg + ")");
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
            Main.conexion.send("UPDATE GZZ_UNIDAD SET UniCod = " + UniCod + ", UniDes = '" + UniDes +  "', UniEstReg = " + UniEstReg + " WHERE UniCod = " + codigo);
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
            this.setUniEstReg("3");
            Main.conexion.send("UPDATE GZZ_UNIDAD SET UniEstReg = " + 3 + " WHERE UniCod = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
             err = ex.getMessage();
        }
        
        return err;
    }
    
    public ArrayList<Unidad_Ej> getLista()
    {
        Main.conexion.conectar();
        ArrayList<Unidad_Ej> unidades = new ArrayList<Unidad_Ej> ();
        
        try
        {
            
            ResultSet resultado = Main.conexion.receive("SELECT * FROM GZZ_UNIDAD ORDER BY UniEstReg ASC");
            
            while(resultado.next())
            {
                String codigo = resultado.getString("UniCod");
                String descripcion = resultado.getString("UniDes");
                String estado = resultado.getString("UniEstReg");
                
                Unidad_Ej unidad = new Unidad_Ej(codigo, descripcion, estado);
                unidades.add(unidad);
            }
            
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(Unidad_Ej.class.getName()).log(Level.SEVERE, null, ex);
        }
              
        return unidades;
    }
    
    
    public String activar(String codigo)
    {
        String err = "";
        try
        {
            Main.conexion.conectar();
            this.setUniEstReg("1");
            Main.conexion.send("UPDATE GZZ_UNIDAD SET UniEstReg = " + 1 + " WHERE UniCod = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
             err = ex.getMessage();
        }
        return err;
    }
    
    public String desactivar(String codigo)
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
    
    public ArrayList<ArrayList<String>> getActivos()
    {
        Main.conexion.conectar();
        ArrayList<ArrayList<String>> unidades = new ArrayList<ArrayList<String>>();
        
        try
        {        
            ResultSet resultado = Main.conexion.receive("SELECT UniCod, UniDes FROM GZZ_UNIDAD WHERE UniEstReg = 1");
            while(resultado.next())
            {
                ArrayList<String> data = new ArrayList<String>();
                String codigo = resultado.getString("UniCod");
                String nombre = resultado.getString("UniDes");
                data.add(codigo);
                data.add(nombre);
                unidades.add(data);
            }
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return unidades;
    }
    
    public void buscar(String codigo)
    {
        Main.conexion.conectar();
        try
        {
            
            ResultSet resultado = Main.conexion.receive("SELECT * FROM GZZ_UNIDAD WHERE UniCod = " + codigo);
            resultado.next();
            this.setUniCod(resultado.getString("UniCod"));
            this.setUniDes(resultado.getString("UniDes"));
            this.setUniEstReg(resultado.getString("UniEstReg"));
            
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }              
    }
}