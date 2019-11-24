package objetos;
public class Paciente{
    private int ID; 
    private int cuenta;
    private String contrasenia; 
    private String nombre;
    private String apellido;
    private String edad;
    private String tipo_u;
    private String genero;
    private int idRutina;
    private int idMedico;
    private int idEntrenador;

    public Paciente(){

    }

    public Paciente(int ID, int cuenta, String contrasenia, String nombre, String apellido, String edad, String tipo_u, String genero, int idRutina,int idMedico,int idEntrenador){
        this.ID = ID; 
        this.cuenta = cuenta;
        this.contrasenia = contrasenia;
        this.nombre = nombre; 
        this.apellido = apellido;
        this.edad = edad;
        this.tipo_u = tipo_u; 
        this.genero = genero;
        this.idRutina = idRutina;
        this.idEntrenador=idEntrenador;
        this.idMedico=idMedico;
    }

    public Paciente(int cuenta, String contrasenia, String nombre, String apellido, String edad, String tipo_u, String genero, int idRutina,int idEntrenador,int idMedico){ 
        this.cuenta = cuenta;
        this.contrasenia = contrasenia;
        this.nombre = nombre; 
        this.apellido = apellido;
        this.edad = edad;
        this.tipo_u = tipo_u; 
        this.genero = genero;
        this.idRutina = idRutina;
         this.idEntrenador=idEntrenador;
        this.idMedico=idMedico;
    }

    

    public void setCuenta(int cuenta){
        this.cuenta = cuenta;
    }
    public int getCuenta(){
        return cuenta;
    }

    public String getContrasenia(){
        return contrasenia;
    }

    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    public void setNombre(String nombre){
        this.nombre = nombre; 
    }
    public String getNombre(){
        return nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido; 
    }

    public String getApellido(){
        return apellido;
    }
    public void setEdad(String edad){
        this.edad = edad; 
    }

    public String getEdad(){
        return edad;
    }
    

    public void setGenero(String genero){
        this.genero = genero; 
    }

    public String getGenero(){
        return genero;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTipo_u() {
        return tipo_u;
    }

    public void setTipo_u(String tipo_u) {
        this.tipo_u = tipo_u;
    }

    public int getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(int idRutina) {
        this.idRutina = idRutina;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    
    
}