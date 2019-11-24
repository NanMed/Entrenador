package objetos;
public class Equilibrio{
    private int idEquilibrio;
    private String piesjuntos;
    private String tandem;
    private int puntaje;
    private String semitandem;
    
    public Equilibrio(){

    }
    public Equilibrio(int idEquilibrio, String piesjuntos, String tandem, int puntaje, String semitandem){
        this.idEquilibrio=idEquilibrio;
        this.piesjuntos=piesjuntos;
        this.tandem=tandem;
        this.puntaje=puntaje;
        this.semitandem=semitandem;
         
    }

    public int getIdEquilibrio(){
        return idEquilibrio;
    }
    public void setIdEquilibrio(int idEquilibrio){
        this.idEquilibrio=idEquilibrio;
    }

    public String getPiesjuntos(){
        return piesjuntos;
    }

    public void setPiesjuntos(String piesjuntos){
        this.piesjuntos = piesjuntos;
    }

    public String getTandem(){
        return tandem;
    }

    public void setTandem(String tandem){
        this.tandem = tandem;
    }

    public int getPuntaje(){
        return puntaje;
    }

    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }

    public String getSemitandem(){
        return semitandem;
    }

    public void setSemitandem(String semitandem){
        this.semitandem = semitandem;
    }

    
}