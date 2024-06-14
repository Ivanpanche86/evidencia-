
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datos.Conexion;

@WebServlet("http://localhost:8081/Tu_Respuesta/ServletControlador")          //("/ServletControlador")
public class SvControladorUsuarios extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Leer parámetros del formulario
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String tipoDocumento = request.getParameter("tipo_documento");
        String numeroDocumento = request.getParameter("numero_documento");
        String telefono1 = request.getParameter("telefono1");
        String telefono2 = request.getParameter("telefono2");
        String email = request.getParameter("e_mail");
        String tipoUsuario = request.getParameter("tipo_usuario");
        String torreApartamento = request.getParameter("torre_apartamento");
        String contraseña = request.getParameter("contraseña");
        Object confirmarContraseña = null;
        
        // Validación de contraseñas
        if (!contraseña.equals(confirmarContraseña)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Las contraseñas no coinciden.</h1>");
            return;
        }

        // Conectar a la base de datos
        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "INSERT INTO usuario (nombres, apellidos, tipo_documento, numero_documento, telefono1, telefono2, email, tipo_usuario, torre_apartamento, contraseña) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, nombres);
            stmt.setString(2, apellidos);
            stmt.setString(3, tipoDocumento);
            stmt.setString(4, numeroDocumento);
            stmt.setString(5, telefono1);
            stmt.setString(6, telefono2);
            stmt.setString(7, email);
            stmt.setString(8, tipoUsuario);
            stmt.setString(9, torreApartamento);
            stmt.setString(10, contraseña);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<h1>Registro exitoso!</h1>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Método GET no permitido</h1>");
    }
}
