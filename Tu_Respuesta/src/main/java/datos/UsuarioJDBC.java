
package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dominio.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioJDBC {

    private static final Logger LOGGER = Logger.getLogger(UsuarioJDBC.class.getName());

    private static final String SQL_SELECT = "SELECT id_Usuario, numero_documento, tipo_documento, nombres, apellidos, tipo_usuario, telefono1, telefono2, e_mail, torre_apartamento, contraseña FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(numero_documento, tipo_documento, nombres, apellidos, tipo_usuario, telefono1, telefono2, e_mail, torre_apartamento, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET numero_documento = ?, tipo_documento = ?, nombres = ?, apellidos = ?, tipo_usuario = ?, telefono1 = ?, telefono2 = ?, e_mail = ?, torre_apartamento = ?, contraseña = ? WHERE id_Usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_Usuario = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT id_Usuario, numero_documento, tipo_documento, nombres, apellidos, tipo_usuario, telefono1, telefono2, e_mail, torre_apartamento, contraseña FROM usuario WHERE id_Usuario = ?";

    public List<Usuario> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_Usuario = rs.getInt("id_Usuario");
                String numero_documento = rs.getString("numero_documento");
                String tipo_documento = rs.getString("tipo_documento");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String tipo_usuario = rs.getString("tipo_usuario");
                String telefono1 = rs.getString("telefono1");
                String telefono2 = rs.getString("telefono2");
                String e_mail = rs.getString("e_mail");
                String torre_apartamento = rs.getString("torre_apartamento");
                String contraseña = rs.getString("contraseña");

                Usuario usuario = new Usuario(id_Usuario, numero_documento, tipo_documento, nombres, apellidos, tipo_usuario, telefono1, telefono2, e_mail, torre_apartamento, contraseña);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al listar usuarios", ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usuarios;
    }

    public int insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnumero_documento());
            stmt.setString(2, usuario.gettipo_documento());
            stmt.setString(3, usuario.getnombres());
            stmt.setString(4, usuario.getapellidos());
            stmt.setString(5, usuario.gettipo_usuario());
            stmt.setString(6, usuario.gettelefono1());
            stmt.setString(7, usuario.gettelefono2());
            stmt.setString(8, usuario.gete_mail());
            stmt.setString(9, usuario.gettorre_apartamento());
            stmt.setString(10, usuario.getcontraseña());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar usuario", ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnumero_documento());
            stmt.setString(2, usuario.gettipo_documento());
            stmt.setString(3, usuario.getnombres());
            stmt.setString(4, usuario.getapellidos());
            stmt.setString(5, usuario.gettipo_usuario());
            stmt.setString(6, usuario.gettelefono1());
            stmt.setString(7, usuario.gettelefono2());
            stmt.setString(8, usuario.gete_mail());
            stmt.setString(9, usuario.gettorre_apartamento());
            stmt.setString(10, usuario.getcontraseña());
            stmt.setInt(11, usuario.getid_Usuario());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al actualizar usuario", ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getid_Usuario());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar usuario", ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public Usuario encontrar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usr = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, usuario.getid_Usuario());
            rs = stmt.executeQuery();
            if (rs.next()) {
                int id_Usuario = rs.getInt("id_Usuario");
                String numero_documento = rs.getString("numero_documento");
                String tipo_documento = rs.getString("tipo_documento");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String tipo_usuario = rs.getString("tipo_usuario");
                String telefono1 = rs.getString("telefono1");
                String telefono2 = rs.getString("telefono2");
                String e_mail = rs.getString("e_mail");
                String torre_apartamento = rs.getString("torre_apartamento");
                String contraseña = rs.getString("contraseña");

                usr = new Usuario(id_Usuario, numero_documento, tipo_documento, nombres, apellidos, tipo_usuario, telefono1, telefono2, e_mail, torre_apartamento, contraseña);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al encontrar usuario", ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return usr;
    }

    public List<Usuario> select() {
        return null;
    }

    public void delete(Usuario usuario) {
    }
}


/*package datos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dominio.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;


public class UsuarioJDBC {
    
    private static final Logger LOGGER = Logger.getLogger(UsuarioJDBC.class.getName());
    
    private static final String SQL_SELECT = "SELECT id_Usuario, numero_documento, tipo_documento, nombres, apellidos, tipo_usuario, telefono1, telefono2, e_mail, torre_apartamento, contraseña FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario(numero_documento, tipo_documento, nombres, apellidos, tipo_usuario, telefono1, telefono2, e_mail, torre_apartamento, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET numero_documento = ?, tipo_documento = ?, nombres = ?, apellidos = ?, tipo_usuario = ?, telefono1 = ?, telefono2 = ?, e_mail = ?, torre_apartamento = ?, contraseña = ? WHERE id_Usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_Usuario = ?";
    private static final String SQL_SELECT_BY_ID = "SELECT id_Usuario, numero_documento, tipo_documento, nombres, apellidos, tipo_usuario, telefono1, telefono2, e_mail, torre_apartamento, contraseña FROM usuario WHERE id_Usuario = ?";    

        public List<Usuario> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_Usuario = rs.getInt("id_usuario");
                String numero_documento = rs.getString("numero_documento");
                String tipo_documento = rs.getString("tipo_documento");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String tipo_usuario = rs.getString("tipo_usuario");
                String telefono1 = rs.getString("telefono1");
                String telefono2 = rs.getString("telefono2");
                String e_mail = rs.getString("e_mail");
                String torre_apartamento = rs.getString("torre_apartamento");
                String contraseña = rs.getString("contraseña");

                usuario = new Usuario(id_Usuario, numero_documento, tipo_documento, nombres, apellidos, tipo_usuario, telefono1, telefono2, e_mail, torre_apartamento, contraseña);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al listar usuarios", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar ResultSet", ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar PreparedStatement", ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar Connection", ex);
                }
            }
        }
        return usuarios;
    }

    public int insertar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getnumero_documento());
            stmt.setString(2, usuario.gettipo_documento());
            stmt.setString(3, usuario.getnombres());
            stmt.setString(4, usuario.getapellidos());
            stmt.setString(5, usuario.gettipo_usuario());
            stmt.setString(6, usuario.gettelefono1());
            stmt.setString(7, usuario.gettelefono2());
            stmt.setString(8, usuario.gete_mail());
            stmt.setString(9, usuario.gettorre_apartamento());
            stmt.setString(10, usuario.getcontraseña());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al insertar usuario", ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar PreparedStatement", ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar Connection", ex);
                }
            }
        
        }
        return rows; // Asegurarse de que haya una declaración de devolución presente
    }

    public int actualizar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getnumero_documento());
            stmt.setString(2, usuario.gettipo_documento());
            stmt.setString(3, usuario.getnombres());
            stmt.setString(4, usuario.getapellidos());
            stmt.setString(5, usuario.gettipo_usuario());
            stmt.setString(6, usuario.gettelefono1());
            stmt.setString(7, usuario.gettelefono2());
            stmt.setString(8, usuario.gete_mail());
            stmt.setString(9, usuario.gettorre_apartamento());
            stmt.setString(10, usuario.getcontraseña());
            stmt.setInt(11, usuario.getid_Usuario());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al actualizar usuario", ex);
        } finally {
        if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar PreparedStatement", ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar Connection", ex);
                }
            }
        
        }
        return rows; // Asegurarse de que haya una declaración de devolución presente.
    }

    public int eliminar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getid_Usuario());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al eliminar usuario", ex);
        } finally {
        if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar PreparedStatement", ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar Connection", ex);
                }
            }
        }
        return rows; // Asegurarse de que haya una declaración de devolución presente.
    }

    public Usuario encontrar(Usuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario usr = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, usuario.getid_Usuario());
            rs = stmt.executeQuery();
            if (rs.next()) {
                int id_Usuario = rs.getInt("id_usuario");
                String numero_documento = rs.getString("numero_documento");
                String tipo_documento = rs.getString("tipo_documento");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String tipo_usuario = rs.getString("tipo_usuario");
                String telefono1 = rs.getString("telefono1");
                String telefono2 = rs.getString("telefono2");
                String e_mail = rs.getString("e_mail");
                String torre_apartamento = rs.getString("torre_apartamento");
                String contraseña = rs.getString("contraseña");

                usr = new Usuario(id_Usuario, numero_documento, tipo_documento, nombres, apellidos, tipo_usuario, telefono1, telefono2, e_mail, torre_apartamento, contraseña);
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error al encontrar usuario", ex);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar ResultSet", ex);
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar PreparedStatement", ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    LOGGER.log(Level.SEVERE, "Error al cerrar Connection", ex);
                }
            }
                }
        return usr; // Asegurarse de que haya una declaración de devolución presente.
    }

    public List<Usuario> select() {
        return null;
    }

    public void delete(Usuario usuario) {
    }

    private static class LOGGER {

        private static void log(Level SEVERE, String error_al_listar_usuarios, SQLException ex) {
        }


        }
    }

*/
