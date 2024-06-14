package dominio;

import java.util.ArrayList;
import java.util.List;


public class Usuario {          
  //Se declaran variables
    private int id_Usuario;
    public String numero_documento;
    public String tipo_documento;
    public String nombres;
    public String apellidos;
    public String tipo_usuario;
    public String telefono1;
    public String telefono2;
    public String e_mail;
    public String torre_apartamento;
    public String contraseña;
    
   // Lista estática para almacenar objetos Pqrs
    
    private static List<Usuario> usuarioList = new ArrayList<>();
    
    // Implementación del método add

    public static void add(Usuario usuario) {
        usuarioList.add(usuario);
        System.out.println("Agregado Usuario: " + usuario);
    } 
           
    public Usuario(){     //Constructor vacío
    }
    
    public Usuario(int id_Usuario){     //Constructor con parámetros
        this.id_Usuario = id_Usuario;
    }
    
    // Constructor, getters y setters
    
    public Usuario(int id_Usuario, String numero_documento,String tipo_documento,String nombres,String apellidos,String tipo_usuario,
            String telefono1,String telefono2,String e_mail,String torre_apartamento,String contraseña)
    {
        this.id_Usuario = id_Usuario;            
        this.numero_documento = numero_documento;
        this.tipo_documento = tipo_documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo_usuario = tipo_usuario;
        this.telefono1 = telefono1;  
        this.telefono2 = telefono2;
        this.e_mail = e_mail;
        this.torre_apartamento = torre_apartamento;
        this.contraseña = contraseña;
    }
    
    // Getters y setters
    
    public int getid_Usuario(){  //Se define método get
    return id_Usuario;
    }
    public void setid_Usuario(int id_Usuario ){ //Se define método set
    this.id_Usuario = id_Usuario;
    }
    
    
    public String getnumero_documento(){
    return numero_documento;
    }
    public void setnumero_documento(String numero_documento){
    this.numero_documento = numero_documento;
    }
    
    
    public String gettipo_documento(){
    return tipo_documento;
    }
    public void settipo_documento(String tipo_documento){
    this.tipo_documento = tipo_documento;
    }
    
    
    public String getnombres(){
    return nombres;
    }
    public void setnombres(String nombres){
    this.nombres = nombres;
    }
    
    
    public String getapellidos(){
    return apellidos;
    }
    public void setapellidos(String apellidos){
    this.apellidos = apellidos;
    }
    
    
    public String gettipo_usuario(){
    return tipo_usuario;
    }
    public void settipo_usuario(String tipo_usuario){
    this.tipo_usuario = tipo_usuario;
    }
    
    
    public String gettelefono1(){
        return telefono1;
    }
    public void settelefono1(String telefono1){
    this.telefono1 = telefono1;
    }
    
    
    public String gettelefono2(){
        return telefono1;
    }
    public void settelefono2(String telefono2){
    this.telefono2 = telefono2;
    }
    
    
    public String gete_mail(){
        return e_mail;
    }
    
    public void sete_mail(String e_mail){
    this.e_mail = e_mail;
    }
    
    
    public String gettorre_apartamento(){
        return torre_apartamento;
    }
    public void settorre_apartamento(String torre_apartamento){
    this.torre_apartamento = torre_apartamento;
    }
    
    
    public String getcontraseña(){
        return contraseña;
    }
    public void setcontraseña(String contraseña){
    this.contraseña = contraseña;
    }
    
    @Override               /*La anotación @Override simplemente se utiliza, para forzar al compilador a comprobar en tiempo
                              de compilación que estás sobrescribiendo correctamente un método,y de este modo evitar errores en
                              tiempo de ejecución, los cuales serían mucho más difíciles de detectar.*/
    public String toString(){
    return "Usuario {" + "id_Usuario = " + id_Usuario + ", numero_documento = " + numero_documento +
           ", tipo_documento = " + tipo_documento + ", nombres = " + nombres + ", apellidos = " + apellidos + 
           ", tipo_usuario = " + tipo_usuario + ", telefono1 = " + telefono1 + ", telefono2 = " + telefono2 + ", " + 
           ", e_mail = " + e_mail + ", torre_apartamento = " + torre_apartamento + ", contraseña = " + contraseña + "}";
    }
}  
