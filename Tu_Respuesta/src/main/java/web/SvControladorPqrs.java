package web;

import datos.PqrsJDBC;
import dominio.Pqrs;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvControladorPqrs", urlPatterns = {"/SvControladorPqrs"})
public class SvControladorPqrs extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarPqrs(request, response);
                    break;
                case "eliminar":
                    this.eliminarPqrs(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "diligenciar":
                    this.diligenciePqrs(request, response);
                    break;
                case "consultar":
                    this.consultaPqrs(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Pqrs> pqrs = new PqrsJDBC().listar();
        HttpSession sesion = request.getSession();
        sesion.setAttribute("pqrs", pqrs);
        response.sendRedirect("inicio.jsp");
    }

    private void editarPqrs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_pqrs = Integer.parseInt(request.getParameter("id_pqrs"));
        Pqrs pqrs = new PqrsJDBC().encontrar(new Pqrs(id_pqrs));
        request.setAttribute("pqrs", pqrs);
        String jspEditar = "/WEB-INF/paginas/Pqrss/diligenciePqrs.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    private void diligenciePqrs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_pqrs = Integer.parseInt(request.getParameter("id_pqrs"));
        int id_Usuario = Integer.parseInt(request.getParameter("id_Usuario"));
        int id_Categoria = Integer.parseInt(request.getParameter("id_Categoria"));
        String estado = request.getParameter("estado");
        String fechaRadicado = request.getParameter("fechaRadicado");
        String tipo_Pqrs = request.getParameter("tipo_Pqrs");
        String archivoMultimedia = request.getParameter("archivoMultimedia");

        Pqrs pqrs = new Pqrs(id_pqrs, id_Usuario, id_Categoria, estado, fechaRadicado, tipo_Pqrs, archivoMultimedia);

        this.accionDefault(request, response);
    }

    private void modificarPqrs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_pqrs = Integer.parseInt(request.getParameter("id_pqrs"));
        int id_Usuario = Integer.parseInt(request.getParameter("id_Usuario"));
        int id_Categoria = Integer.parseInt(request.getParameter("id_Categoria"));
        String estado = request.getParameter("estado");
        String fechaRadicado = request.getParameter("fechaRadicado");
        String tipo_Pqrs = request.getParameter("tipo_Pqrs");
        String archivoMultimedia = request.getParameter("archivoMultimedia");

        Pqrs pqrs = new Pqrs(id_pqrs, id_Usuario, id_Categoria, estado, fechaRadicado, tipo_Pqrs, archivoMultimedia);
        int registrosModificados = new PqrsJDBC().actualizar(pqrs);

        this.accionDefault(request, response);
    }

    private void eliminarPqrs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id_pqrs = Integer.parseInt(request.getParameter("id_pqrs"));

        Pqrs pqrs = new Pqrs(id_pqrs);
        int registrosModificados = new PqrsJDBC().eliminar(pqrs);

        this.accionDefault(request, response);
    }

    private void consultaPqrs(HttpServletRequest request, HttpServletResponse response) {
    }
}





/*
package web;

import datos.PqrsJDBC;
import dominio.Pqrs;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SvControladorPqrs", urlPatterns = {"/SvControladorPqrs"})
public class SvControladorPqrs extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarPqrs(request, response);
                    break;
                case "eliminar":
                    this.eliminarPqrs(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      List<Pqrs> pqrs = new PqrsJDBC().listar();
       HttpSession sesion = request.getSession();
       sesion.setAttribute("pqrs", pqrs);
       response.sendRedirect("inicio.jsp");
    }
 

    private void editarPqrs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recuperamos el id_Usuario
        int id_pqrs = Integer.parseInt(request.getParameter("id_pqrs"));
        Pqrs pqrs = new PqrsJDBC().encontrar(new Pqrs(id_pqrs));
        request.setAttribute("id_pqrs", pqrs);
        String jspEditar = "/WEB-INF/paginas/pqrs/editarPqrs.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarPqrs(request, response);
                    break;
                case "modificar":
                    this.modificarPqrs(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    private void insertarPqrs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recuperamos los valores del formulario agregarUsuario
        int id_pqrs = Integer.parseInt(request.getParameter("id_pqrs"));
        int id_Usuario = Integer.parseInt(request.getParameter("id_Usuario"));
        int id_Categoria= Integer.parseInt(request.getParameter("id_Categoria"));
        String estado = request.getParameter("estado");
        String fechaRadicado = request.getParameter("fechaRadicado");
        String tipo_Pqrs = request.getParameter("tipo_Pqrs");
        String archivoMultimedia = request.getParameter("archivoMultimedia");
        

        // Creamos el objeto de usuario (modelo)
        Pqrs pqrs = new Pqrs(id_pqrs,id_Usuario, id_Categoria, estado, fechaRadicado, tipo_Pqrs, archivoMultimedia);

        // Insertamos el nuevo objeto en la base de datos
        int registrosModificados = new PqrsJDBC().insertar(pqrs); 
       

        // Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void modificarPqrs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recuperamos los valores del formulario editarPqrs
        int id_pqrs = Integer.parseInt(request.getParameter("id_pqrs"));
        int id_Usuario = Integer.parseInt(request.getParameter("id_Usuario"));
        int id_Categoria= Integer.parseInt(request.getParameter("id_Categoria"));
        String estado = request.getParameter("estado");
        String fechaRadicado = request.getParameter("fechaRadicado");
        String tipo_Pqrs = request.getParameter("tipo_Pqrs");
        String archivoMultimedia = request.getParameter("archivoMultimedia");
        
        // Creamos el objeto de pqrs (modelo)
        Pqrs pqrs = new Pqrs(id_pqrs, id_Usuario, id_Categoria, estado, fechaRadicado, tipo_Pqrs, archivoMultimedia);

        // Modificamos el objeto en la base de datos
        int registrosModificados = new PqrsJDBC().actualizar(pqrs);   
        

        // Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void eliminarPqrs(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // recuperamos los valores del formulario eliminarUsuario
        int id_pqrs = Integer.parseInt(request.getParameter("id_pqrs"));

        // Creamos el objeto de pqrs (modelo)
        Pqrs pqrs = new Pqrs(id_pqrs);

        // Eliminamos el objeto en la base de datos
        int registrosModificados = new PqrsJDBC().eliminar(pqrs);  
      

        // Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
}
*/
