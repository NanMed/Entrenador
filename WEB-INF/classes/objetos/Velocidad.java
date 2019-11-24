package objetos;
public class Velocidad{
    private int idVelocidad;
    private int tiempo1;
    private String tiempo2;
    private int distancias;
    private String puntaje;
    
    

    public Velocidad(){
        
    }
    public Velocidad(int idVelocidad, int tiempo1, String tiempo2, int distancias, String puntaje){
            this.idVelocidad=idVelocidad;
            this.tiempo2=tiempo2;
            this.tiempo1=tiempo1;
            this.distancias=distancias;
            this.puntaje=puntaje;
         
    }

    public int getIdVelocidad(){
        return idVelocidad;
    }
    public void setIdVelocidad(int idVelocidad){
        this.idVelocidad=idVelocidad;
    }

    public int getTiempo1(){
        return tiempo1;
    }

    public void setTiempo1(int tiempo1){
        this.tiempo1 = tiempo1;
    }

    public String getTiempo2(){
        return tiempo2;
    }

    public void setTiempo2(String tiempo2){
        this.tiempo2= tiempo2;
    }

    public int getDistancias(){
        return distancias;
    }

    public void setDistancias(int distancias){
        this.distancias = distancias;
    }

    public String getPuntaje(){
        return puntaje;
    }

    public void setPuntaje(String puntaje){
        this.puntaje = puntaje;
    }

    
}