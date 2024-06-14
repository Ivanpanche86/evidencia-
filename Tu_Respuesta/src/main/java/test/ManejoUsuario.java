
package test;

import datos.UsuarioJDBC;
import java.sql.SQLException;                  //Comentamos el código para que no genere error con los métodos.
import java.util.List;                         //Descomentamos según necesidad para correr método.
import dominio.Usuario;

    public class ManejoUsuario {
 
        public static void main(String[] args) throws SQLException{     //Se usa en el SELECT. INSERT. UPDATE. DELETE.
        UsuarioJDBC UsuarioJdbc = new UsuarioJDBC();
        
         // Seleccionar todos los usuarios    SELECT
     
                 List<Usuario> usuarios = UsuarioJdbc.select();          //Se usa en el SELECT. INSERT. UPDATE. DELETE.
    
                 for(Usuario usuario: usuarios){                         //Se usa en el SELECT. INSERT. UPDATE. DELETE.
                 System.out.println("Usuario: " + usuario);     
             }
         // Eliminar un usuario por id  (DELETE)                
     
            UsuarioJdbc.delete(new Usuario(9)); //,null, null, null, null, null, null, null, null, null, null));  // (DELETE)
            UsuarioJdbc.delete(new Usuario(11));   //SE ORGANIZA SEGÚN NECESIDAD //Elimina la fila por id
                                        
          //Crear instancias de Usuario con todos los campos asignados (INSERT)  //Se usa en el INSERT.
            Usuario usuario1 = new Usuario(4, "9988776655", "TI", "Gladys", "Peña", "Propietario", "102389478", "6042782210", "Glady@gmail.com", "Torre 3", "Glady28");
            Usuario usuario3 = new Usuario(3, "111111111", "TI", "Manuel", "Torres", "Residente", "305234789", "6041234567", "manuel@hotmail.com", "Torre 3", "2345mAnuel");
         
          //Agregar los objetos usuario a la base de datos (INSERT)
              usuarioJdbc.insert(usuario1);                         //Se usa en el INSERT.
              usuarioJdbc.insert(usuario3);
    
          //Actualizar un registro de Usuario   (UPDATE) 
                Usuario usuario = new Usuario(0, "9810","CC", "Luz", "Arrieta", "Residente", "3104302278", "6042782210", "Luz@gmail.com","Torre 1","Luz28");
                usuarioJdbc.update(usuario);
             }
             private static List<Usuario> UsuarioJdbcselect() throws SQLException {  //UPDATE)
                  UsuarioJDBC usuarioJdbc = new UsuarioJDBC();
                  return usuarioJdbc.select();
                }     //Se usa en el SELECT. INSERT. UPDATE. DELETE.

               public static class UsuarioSubClass extends Usuario {

             public UsuarioSubClass(int id_Usuario, String numero_documento, String tipo_documento, String nombres, 
                    String apellidos, String tipo_usuario, String telefono1, String telefono2, 
                    String e_mail, String torre_apartamento,String contraseña) {
            super(id_Usuario, numero_documento, tipo_documento, nombres, apellidos, tipo_usuario, telefono1, telefono2, e_mail, torre_apartamento, contraseña);
        }         //Se usa en el SELECT. INSERT. UPDATE. DELETE.
    }       
 }          
    

    
