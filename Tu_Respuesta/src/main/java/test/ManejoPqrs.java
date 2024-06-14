
package test;

import datos.PqrsJDBC;
import java.sql.SQLException;
import java.util.List;
import dominio.Pqrs;

public class ManejoPqrs {
    
    public static void main(String[] args) throws SQLException {    //Se usa en el SELECT. INSERT. DELETE. UPDATE.     
        PqrsJDBC pqrsJdbc = new PqrsJDBC();

      //Seleccionar y mostrar todos los registros de Pqrs SELECT  //Se usa para el SELECT. INSERT. DELETE. UPDATE.
       List<Pqrs> pqrss = pqrsJdbc.select();
       
         for (Pqrs pqrs : pqrss) {                   //Se usa en el SELECT. INSERT. DELETE. UPDATE.
             System.out.println("pqrss: " + pqrs);  
        }

      // Eliminar un registro de la tabla Pqrs DELETE.
            pqrsJdbc.delete(new Pqrs(34)); //,null, null, null, null, null, null, null, null, null, null));
            pqrsJdbc.delete(new Pqrs(35)); // Elimina la fila con id_pqrs = 1       //Se usa en el DELETE.

      //Crear instancias de Pqrs con todos los campos asignados  INSERT
       Pqrs pqrs1 = new Pqrs(32, 00113355, 2, "Cerrado", "2024-11-27 10:10:20", "Queja", "archivo3.jpg");
       Pqrs pqrs2 = new Pqrs(33, 23456789, 3, "En proceso", "2024-05-01 10:00:00", "Solicitud", "archivo7.png");

      //Agregar los objetos Pqrs a la base de datos  INSERT
         pqrsJdbc.insert(pqrs1);
         pqrsJdbc.insert(pqrs2);

      //Actualizar un registro de Pqrs  UPDATE
        Pqrs pqrs = new Pqrs(30, 33337777, 4,"En proceso","2024-01-05 11:11:11", "Queja", "Actualiza queja");  //UPDATE)
        pqrsJdbc.update(pqrs);        
     }      //Se usa en el DELETE. SELECT. UPDATE.
    
      private static List<Pqrs> PqrsJdbcselect() throws SQLException {   //Se usa en el UPDATE.
          PqrsJDBC pqrsJdbc = new PqrsJDBC();
           return pqrsJdbc.select();
     
        }      //Se usa en el SELECT. UPDATE.
     }          //Se usa en el UPDATE. DELETE.
