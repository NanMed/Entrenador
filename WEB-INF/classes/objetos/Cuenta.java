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

    public int getUsername() {
        return ID;
    }

    public void setUsername(int ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return contrasenia;
    }

    public void setPassword(String contrasenia) {
        this.contrasenia = contrasenia;
    }

   
}