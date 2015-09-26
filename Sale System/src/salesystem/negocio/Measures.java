package salesystem.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Measures
{
    private String measure_id;
    private String measure_description;
    private String register_state;
    
    public Measures()
    {
        this("-1", "NULL", "*");
    }
    
    public Measures(String measure_id, String measure_description, String register_state)
    {
        this.measure_id = measure_id;
        this.measure_description = measure_description;
        this.register_state = register_state;
    }

    public String getMeasure_id()
    {
        return measure_id;
    }

    public void setMeasure_id(String measure_id)
    {
        this.measure_id = measure_id;
    }

    public String getMeasure_description()
    {
        return measure_description;
    }

    public void setMeasure_description(String measure_description)
    {
        this.measure_description = measure_description;
    }

    public String getRegister_state()
    {
        return register_state;
    }

    public void setRegister_state(String register_state)
    {
        this.register_state = register_state;
    }
    
    public String insertar()
    {
        Main.conexion.conectar();

        try
        {
            Main.conexion.send("INSERT INTO Measures VALUES(DEFAULT, '" + measure_description + "', '" + register_state + "')");
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
            Main.conexion.send("UPDATE Measures SET measure_description = '" + measure_description + "', register_state = '" + register_state + "' WHERE measure_id = " + codigo);
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
            Main.conexion.send("UPDATE Measures SET register_state = '*' WHERE measure_id = " + codigo);
            Main.conexion.desconectar();
        }
        catch (SQLException ex)
        {
            return ex.getMessage();
        }
        
        return "";
    }
    
    public ArrayList<Measures> getLista()
    {
        Main.conexion.conectar();
        ArrayList<Measures> unidades = new ArrayList<Measures> ();
        
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT * FROM Measures ORDER BY register_state DESC");
            
            while(resultado.next())
            {
                String codigo = resultado.getString("measure_id");
                String descripcion = resultado.getString("measure_description");
                String estado = resultado.getString("register_state");
                
                Measures unidad = new Measures(codigo, descripcion, estado);
                unidades.add(unidad);
            }
        }
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        
        return unidades;
    }
    
    public ArrayList<String> getActivos()
    {
        Main.conexion.conectar();
        ArrayList<String> unidades = new ArrayList<String> ();
        
        try
        {
            ResultSet resultado = Main.conexion.receive("SELECT measure_description FROM Measures WHERE register_state = 'A'");
            while(resultado.next())
                unidades.add(resultado.getString("measure_description"));
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
            ResultSet resultado = Main.conexion.receive("SELECT * FROM Measures WHERE measure_id = " + codigo);
            resultado.next();
            this.setMeasure_id(resultado.getString("measure_id"));
            this.setMeasure_description(resultado.getString("measure_description"));
            this.setRegister_state(resultado.getString("register_state"));
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
    }
    
    public ArrayList <Measures> getList(int option, String code) {
        Main.conexion.conectar();
        
        ArrayList <Measures> measures = new ArrayList <> ();
        
        try {
            ResultSet result = null;
            
            switch(option) {
                case 0: result = Main.conexion.receive("SELECT * FROM MEASURES WHERE register_state = 'A'");
                        break;
                    
                case 1: result = Main.conexion.receive("SELECT * FROM MEASURES WHERE measure_id = " + code);
                        break;
            }
            
            while(result.next())
            {                
                Measures measure = new Measures(result.getString("measure_id"),
                        result.getString("measure_description"),
                        result.getString("register_state"));
                measures.add(measure);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Measures.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return measures;
    }
}
