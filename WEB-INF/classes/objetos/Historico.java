package objetos;
public class Historico{
    private int idHistorico; 
    private int tiempo;
    private String clasificacion;
    private int caidas;
    private String prueba2;
    private String prueba1;
    private String sumaSppb;
    private String distancia;
    private int idPaciente;


    public Historico(){

    }

    public Historico(int idHistorico, int tiempo, String clasificacion, int caidas, String prueba1, String prueba2, String sumaSppb, String distancia, int idPaciente){
      this.idHistorico=idHistorico;
      this.tiempo=tiempo;
      this.clasificacion=clasificacion;
      this.caidas=caidas;
      this.prueba1=prueba1;
      this.prueba2=prueba2;
      this.sumaSppb=sumaSppb;
      this.distancia=distancia;
      this.idPaciente=idPaciente;
    }


    public void setIdHistorico(int idHistorico){
        this.idHistorico = idHistorico; 
    }
    public int getIdHistorico(){
        return idHistorico; 
    }
    public void setTiempo(int tiempo){
        this.tiempo = tiempo; 
    }
    public int getTiempo(){
        return tiempo;
    }

    public void setClasificacion(String clasificacion){
        this.clasificacion = clasificacion; 
    }
    public String getClasificacion(){
        return clasificacion;
    }

    public void setCaidas(int caidas){
        this.caidas = caidas; 
    }
    public int getCaidas(){
        return caidas;
    }

    public void setPrueba1(String prueba1){
        this.prueba1 = prueba1; 
    }
    public String getPrueba1(){
        return prueba1;
    }

    public void setPrueba2(String prueba2){
        this.prueba2 = prueba2; 
    }
    public String getPrueba2(){
        return prueba2;
    }
    public void setSumaSppb(String sumaSppb){
        this.sumaSppb = sumaSppb; 
    }
    public String getSumaSppb(){
        return sumaSppb;
    }
    public void setDistancia(String distancia){
        this.distancia = distancia; 
    }
    public String getDistancia(){
        return distancia;
    }
    public void setIdPaciente(int idPaciente){
        this.idPaciente = idPaciente; 
    }
    public int getIdPaciente(){
        return idPaciente;
    }
}