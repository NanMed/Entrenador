package objetos;
public class Levantamiento{
    private int idLevantamiento;
    private int tiempo1;
    private String puntaje;
  
    public Levantamiento(){
        
    }
    public Levantamiento(int idLevantamiento, int tiempo1, String puntaje){
            this.idLevantamiento=idLevantamiento;
            this.tiempo1 = tiempo1; 
            this.puntaje = puntaje; 
           
    }

    public int getIdLevantamiento(){
        return idLevantamiento;
    }
    public void setIdLevantamiento(int idLevantamiento){
        this.idLevantamiento=idLevantamiento;
    }

    public int getTiempo1(){
        return tiempo1;
    }

    public void setTiempo1(int tiempo1){
        this.tiempo1 = tiempo1;
    }

    public String getPuntaje(){
        return puntaje;
    }

    public void setPuntaje(String puntaje){
        this.puntaje = puntaje;
    }

}