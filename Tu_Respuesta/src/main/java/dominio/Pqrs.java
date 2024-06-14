package dominio;

import java.util.ArrayList;
import java.util.List;


public class Pqrs { 
  //Se declaran variables
    private int id_pqrs;
    private int id_Usuario;
    private int id_Categoria;
    private String estado;
    private String fechaRadicado;
    private String tipo_Pqrs;
    private String archivoMultimedia; 
  
   // Lista estática para almacenar objetos Pqrs
    
    private static List<Pqrs> pqrsList = new ArrayList<>();
    
    // Implementación del método add

    public static void add(Pqrs pqrs) {
        pqrsList.add(pqrs);
        System.out.println("Agregado PQRS: " + pqrs);
    } 
    

    public Pqrs(){     //Constructor vacío
    }
    
    public Pqrs(int id_pqrs){     //Constructor con parámetros
        this.id_pqrs = id_pqrs;
    }
    
    // Constructor, getters y setters
    public Pqrs(int id_pqrs, int id_Usuario, int id_Categoria, String estado, String fechaRadicado, String tipo_Pqrs, String archivoMultimedia)
    {
        this.id_pqrs = id_pqrs;            
        this.id_Usuario = id_Usuario;
        this.id_Categoria = id_Categoria;
        this.estado = estado;
        this.fechaRadicado = fechaRadicado;
        this.tipo_Pqrs = tipo_Pqrs;
        this.archivoMultimedia = archivoMultimedia;   
    }
    
    // Getters y setters
    
    public int getid_pqrs(){  //Se define método get
    return id_pqrs;
    }
    public void setid_pqrs(int id_pqrs ){ //Se define método set
    this.id_pqrs = id_pqrs;
    }
    
    public int getid_Usuario(){
    return id_Usuario;
    }
    public void setid_Usuario(int id_Usuario){
    this.id_Usuario = id_Usuario;
    }
    
    public int getid_Categoria(){
    return id_Categoria;
    }
    public void setid_Categoria(int id_Categoria){
    this.id_Categoria = id_Categoria;
    }
    
    public String getestado(){
    return estado;
    }
    public void setestado(String estado){
    this.estado = estado;
    }
    
    public String getfechaRadicado(){
    return fechaRadicado;
    }
    public void setfechaRadicado(String fechaRadicado){
    this.fechaRadicado = fechaRadicado;
    }
    
    public String gettipo_Pqrs(){
    return tipo_Pqrs;
    }
    public void settipo_Pqrs(String tipoPqrs){
    this.tipo_Pqrs = tipo_Pqrs;
    }
    
    public String getarchivoMultimedia(){
        return archivoMultimedia;
    }
    public void setarchivoMultimedia(String archivoMultimedia){
    this.archivoMultimedia = archivoMultimedia;
    }
    
    @Override               /*La anotación @Override simplemente se utiliza, para forzar al compilador a comprobar en tiempo
                              de compilación que estás sobrescribiendo correctamente un método,y de este modo evitar errores en
                              tiempo de ejecución, los cuales serían mucho más difíciles de detectar.*/
    public String toString(){
    return "Pqrs {" + "id_pqrs = " + id_pqrs + ", id_Usuario = " + id_Usuario +
           ", id_Categoria = " + id_Categoria + ", estado = " + estado + ", fechaRadicado = " + fechaRadicado + 
           ", tipo_Pqrs = " + tipo_Pqrs + ", archivoMultimedia = " + archivoMultimedia + "}";
    }
}

