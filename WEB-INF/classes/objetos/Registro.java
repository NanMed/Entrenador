package objetos;

public class Registro{
    private int idRegistro;
    private String nombrePrueba;
    private String ritmoCInicial;
    private String ritmoCIFinal;
    private String componentes;
    private String intento1;
    private String intento2;
    private String pierna;
    private String brazo;
    private String omni_gse;
    private String dia;
    private int idProgreso;
    private int idPaciente;
   
    public Registro(){

    }

    public Registro(int idRegistro, String nombrePrueba, String ritmoCInicial, String ritmoCIFinal, String componentes, String intento1, String intento2, String pierna, String brazo, String omni_gse, String dia, int idProgreso, int idPaciente){
        this.idRegistro = idRegistro;
        this.nombrePrueba = nombrePrueba; 
        this.ritmoCInicial = ritmoCInicial; 
        this.ritmoCIFinal= ritmoCIFinal; 
        this.componentes = componentes;
        this.intento1 = intento1;
        this.intento2 = intento2;
        this.pierna = pierna;
        this.brazo = brazo;
        this.omni_gse = omni_gse;
        this.dia = dia;
        this.idProgreso = idProgreso;
        this.idPaciente = idPaciente;

    }

    public void setIdRegistro(int idRegistro){
        this.idRegistro= idRegistro; 
    }
    public int getIdRegistro(){
        return idRegistro; 
    }

    public void setNombrePrueba(String nombrePrueba){
        this.nombrePrueba = nombrePrueba; 
    }
    public String getNombrePrueba(){
        return nombrePrueba;
    }

    public void setRitmoCInicial(String ritmoCInicial){
        this.ritmoCInicial = ritmoCInicial; 
    }
    public String getRitmoCInicial(){
        return ritmoCInicial;
    }
    public void setRitmoCFinal(String ritmoCIFinal){
        this.ritmoCIFinal = ritmoCIFinal; 
    }
    public String getRitmoCFinal(){
        return ritmoCIFinal;
    }
    public void setComponentes(String componentes){
        this.componentes = componentes; 
    }
    public String getComponentes(){
        return componentes;
    }

    public void setIntento1(String intento1){
        this.intento1 = intento1; 
    }
    public String getIntento1(){
        return intento1;
    }

    public void setIntento2(String intento2){
        this.intento2 = intento2; 
    }
    public String getIntento2(){
        return intento2;
    }

    public void setPierna(String pierna){
        this.pierna = pierna; 
    }
    public String getPierna(){
        return pierna;
    }
    public void setBrazo(String brazo){
        this.brazo = brazo; 
    }
    public String getBrazo(){
        return brazo;
    }
    public void setOmni_gse(String omni_gse){
        this.omni_gse = omni_gse; 
    }
    public String getOmni_gse(){
        return omni_gse;
    }
    public void setDia(String dia){
        this.dia = dia; 
    }
    public String getDia(){
        return dia;
    }
    public void setIdProgreso(int idProgreso){
        this.idProgreso = idProgreso; 
    }
    public int getIdProgreso(){
        return idProgreso;
    } 
    public void setIdPaciente(int idPaciente){
        this.idPaciente = idPaciente; 
    }
    public int getIdPaciente(){
        return idPaciente;
    }
     
}