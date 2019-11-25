package objetos;
public class Cuenta{
    private int username;
    private String password;

    public Cuenta(){
        
    }

    public Cuenta (int username, String password){
        this.username = username; 
        this.password = password;
    }

<<<<<<< HEAD
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

   
=======
    public void setUsername(int username){
        this.username = username;
    }

    public int getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return password;
    } 
>>>>>>> b026571f3565f7c64a230b6b942d7247a803dc21
}