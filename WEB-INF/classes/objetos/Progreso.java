package objetos;

public class Progreso{
   
    private int idProgreso;
    private int idPaciente;
    private int velocidad; 
    private int resistencia;
    private int fuerza;  
    private int idRutina;


    public Progreso(){}

    public Progreso(int idProgreso, int idPaciente, int idRutina, int velocidad, int resistencia, int fuerza){
        this.idProgreso = idProgreso;
        this.idPaciente = idPaciente;
        this.velocidad = velocidad;
        this.resistencia = resistencia;
        this.fuerza = fuerza;
        this.idRutina=idRutina;
      
    }
   
    public void setIdProgreso(int idProgreso){
        this.idProgreso = idProgreso; 
    }
    public int getIdProgreso(){
        return idProgreso; 
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(int idRutina) {
        this.idRutina = idRutina;
    }
    

    public void setVelocidad(int velocidad){
        this.velocidad = velocidad; 
    }
    public int getVelocidad(){
        return velocidad;
    }
    public void setResistencia(int resistencia){
        this.resistencia = resistencia; 
    }
    public int getResistencia(){
        return resistencia;
    }
   public void setFuerza(int fuerza){
        this.fuerza = fuerza; 
    }
    
}