package datos;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dominio.Pqrs;

public class PqrsJDBC {
    
    private static final String SQL_SELECT = "SELECT id_pqrs, id_Usuario, id_Categoria, estado, fechaRadicado, tipo_Pqrs, archivoMultimedia FROM pqrs";
    private static final String SQL_INSERT = "INSERT INTO pqrs(id_Usuario, id_Categoria, estado, fechaRadicado, tipo_Pqrs, archivoMultimedia) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pqrs SET id_Usuario = ?, id_Categoria = ?, estado = ?, fechaRadicado = ?, tipo_Pqrs = ?, archivoMultimedia = ? WHERE id_pqrs = ?";
    private static final String SQL_DELETE = "DELETE FROM pqrs WHERE id_pqrs = ?";
    public static final String diligenciePqrs = "INSERT INTO pqrs(id_Usuario, id_Categoria, estado, fechaRadicado, tipo_Pqrs, archivoMultimedia) VALUES(?, ?, ?, ?, ?, ?)";
    
    public List<Pqrs> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pqrs pqrs = null;
        
        List<Pqrs> pqrss = new ArrayList<>(); 
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int idPqrs = rs.getInt("id_pqrs");
                int idUsuario = rs.getInt("id_Usuario");
                int idCategoria = rs.getInt("id_Categoria");
                String estado = rs.getString("estado");
                Timestamp fechaRadicado = rs.getTimestamp("fechaRadicado");
                String tipoPqrs = rs.getString("tipo_Pqrs");
                String archivoMultimedia = rs.getString("archivoMultimedia");
                
                pqrs = new Pqrs(idPqrs, idUsuario, idCategoria, estado, fechaRadicado.toString(), tipoPqrs, archivoMultimedia);
                pqrs.add(pqrs); 
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return pqrss;    
    }
    
    public int insert(Pqrs pqrs) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, pqrs.getid_Usuario());
            stmt.setInt(2, pqrs.getid_Categoria());
            stmt.setString(3, pqrs.getestado());
            stmt.setTimestamp(4, Timestamp.valueOf(pqrs.getfechaRadicado()));
            stmt.setString(5, pqrs.gettipo_Pqrs());
            stmt.setString(6, pqrs.getarchivoMultimedia());
            
            rows = stmt.executeUpdate();                            
            System.out.println("ejecutando query:" + SQL_INSERT);   //Imprime por consola
            rows = stmt.executeUpdate();                            
            System.out.println("Registros afectados:" + rows);      
        } catch (SQLException ex) {                                 
            ex.printStackTrace(System.out);                         
            
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int update(Pqrs pqrs) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        conn = Conexion.getConnection();                            
            System.out.println("ejecutando query: " + SQL_UPDATE);  
            stmt = conn.prepareStatement(SQL_UPDATE);               
            int index = 1;                                          
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, pqrs.getid_Usuario());
            stmt.setInt(2, pqrs.getid_Categoria());
            stmt.setString(3, pqrs.getestado());
            stmt.setTimestamp(4, Timestamp.valueOf(pqrs.getfechaRadicado()));
            stmt.setString(5, pqrs.gettipo_Pqrs());
            stmt.setString(6, pqrs.getarchivoMultimedia());
            stmt.setInt(7, pqrs.getid_pqrs());
            
            rows = stmt.executeUpdate();
            
            rows = stmt.executeUpdate();                           
            System.out.println("Registros actualizado:" + rows);   
            
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }
    
    public int delete(Pqrs pqrs) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
           
            conn = Conexion.getConnection();                        
            System.out.println("Ejecutando query:" + SQL_DELETE);   
            stmt = conn.prepareStatement(SQL_DELETE);               
            stmt.setInt(1, pqrs.getid_pqrs());                      
            rows = stmt.executeUpdate();                            
            System.out.println("Registros eliminados:" + rows);     
            
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        
        return rows;
    }

    public List<Pqrs> listar() {
        return null;
    }

    public Pqrs encontrar(Pqrs pqrs) {
        return null;
    }

    public int insertar(Pqrs pqrs) {
        return 0;
    }

    public int actualizar(Pqrs pqrs) {
        return 0;
    }

    public int eliminar(Pqrs pqrs) {
        return 0;
    }
}

