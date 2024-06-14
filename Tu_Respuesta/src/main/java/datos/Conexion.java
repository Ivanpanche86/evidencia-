package datos;
import java.sql.*;

    public class Conexion {
        private static final String JDBC_URL ="jdbc:mysql://localhost:3306/turespuesta?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";  
        private static final String JDBC_USER = "root";
        private static final String JDBC_PASS = "adebo2009";
                
         
        public static Connection getConnection() throws SQLException { //método estatico que debuelve la conexión de la base de datos
        return DriverManager.getConnection(JDBC_URL,JDBC_USER,JDBC_PASS);
        }
        
        public static void close(ResultSet rs){
        
            try{
            rs.close();
            }
            catch(SQLException ex){
            ex.printStackTrace(System.out);
            }
        }
        public static void close(PreparedStatement stmt){
            try{
            stmt.close();
            }
            catch(SQLException ex){
            ex.printStackTrace(System.out);
            }
        }
        public static void close(Connection conn){
            try{
            conn.close();
            }
            catch(SQLException ex){
            ex.printStackTrace(System.out);
            }
        }
}

