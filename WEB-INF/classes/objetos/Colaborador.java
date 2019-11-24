package objetos;
public class Colaborador {
    private int id;
    private int cuenta;
    private String nombre;
    private String apellido;
    private String edad;
    private String genero;
    private String contrasenia;
     
    public Colaborador(){
        
    }
    
    public Colaborador(int id,int cuenta, String nombre, String apellido, String edad, String genero, String contrasenia){
        this.id=id;
        this.cuenta=cuenta;
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
        this.genero = genero;
        this.contrasenia = contrasenia;        
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad/*"yyyy-MM-dd"*/;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
}
