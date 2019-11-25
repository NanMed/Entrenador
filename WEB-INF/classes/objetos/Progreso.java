package objetos;

public class Progreso{
   
    private int idProgreso;
    private int idPaciente;
    private int velocidad; 
    private int levantamiento;
    private int equilibrio;  
    private int idRutina;
    private String dia;
    private int idRegistro;
   


    public Progreso(){}

    public Progreso(int idProgreso, int idPaciente, int idRutina, int velocidad, int levantamiento, int equilibrio, String dia, int idRegistro){
        this.idProgreso = idProgreso;
        this.idPaciente = idPaciente;
        this.velocidad = velocidad;
        this.levantamiento = levantamiento;
        this.equilibrio = equilibrio;
        this.idRutina = idRutina;
        this.dia = dia;
        this.idRegistro = idRegistro;
      
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
    public void setLevantamiento(int levantamiento){
        this.levantamiento = levantamiento; 
    }
    public int getLevantamiento(){
        return levantamiento;
    }
    public void setEquilibrio(int equilibrio){
        this.equilibrio = equilibrio; 
    }
    public int getEquilibrio(){
        return equilibrio;
    }
    public void setDia(String dia){
        this.dia = dia; 
    }
    public String getDia(){
        return dia;
    }
    public void setIdRegistro(int idRegistro){
        this.idRegistro = idRegistro; 
    }
    public int getIdRegistro(){
        return idRegistro;
    }
    
    
}