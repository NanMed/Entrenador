package objetos;
public class Historial_Rutinas{
    private int id; 
    private int idHistorial;
    private int idHistorico;
    private int idVelocidad;
    private int idLevantamiento;
    private int idEquilibrio;
    


    public Historial_Rutinas(){

    }

    public Historial_Rutinas(int id, int idHistorial, int idHistorico, int idVelocidad, int idLevantamiento,int idEquilibrio ){
      
      this.id=id;
      this.idHistorial=idHistorial;
      this.idHistorico=idHistorico;
      this.idVelocidad=idVelocidad;
      this.idLevantamiento=idLevantamiento;
      this.idEquilibrio=idEquilibrio;
      
    }


    public void setId(int id){
        this.id = id; 
    }
    public int getId(){
        return id; 
    }
    public void setIdHistorial(int idHistorial){
        this.idHistorial = idHistorial; 
    }
    public int getIdHistoial(){
        return idHistorial;
    }
    public void setIdHistorico(int idHistorico){
        this.idHistorico = idHistorico; 
    }
    public int getIdHistorico(){
        return idHistorico;
    }
    public int getIdVelocidad(){
        return idVelocidad;
    }
    public void setIdVelocidad(int idVelocidad){
        this.idVelocidad = idVelocidad; 
    }
    public int getIdLevantamiento(){
        return idLevantamiento;
    }
    public void setIdLevantamiento(int idLevantamiento){
        this.idLevantamiento = idLevantamiento; 
    }
    public int getIdEquilibrio(){
        return idEquilibrio;
    }

    public void setEquilibrio(int idEquilibrio){
        this.idEquilibrio = idEquilibrio; 
    }
    
}