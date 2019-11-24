package objetos;
public class Cuenta{
    private int ID;
    private String contrasenia;

    public Cuenta(){
        
    }

    public Cuenta (int ID, String contrasenia){
        this.ID = ID; 
        this.contrasenia = contrasenia;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

   
}