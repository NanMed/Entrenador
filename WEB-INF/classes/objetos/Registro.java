package objetos;

public class Registro{
    private int idRegistro;
    private String eje1Levantamiento;
    private int intento1E1L;
    private int intento2E1L;
    private String eje1Velocidad;
    private int intento1E1V;
    private int intento2E1V;
    private String eje1Equilibrio;
    private int intento1E1E;
    private int intento2E1E;
    private String eje2Equilibrio;
    private int intento1E2E;
    private int intento2E2E;
    private String eje3Equilibrio;
    private int intento1E3E;
    private int intento2E3E;
    private String ritmoCInicial;
    private String ritmoCIFinal;
    private String omni_gse;
    private String dia;
    private int idPaciente;
    private int idRutina;
   
    public Registro(){

    }

    public Registro(int idRegistro,  String eje1Levantamiento, int intento1E1L,int intento2E1L,String eje1Velocidad, int intento1E1V,int intento2E1V, String eje1Equilibrio, int intento1E1E,int intento2E1E,String eje2Equilibrio, int intento1E2E, int intento2E2E, String eje3Equilibrio, int intento1E3E, int intento2E3E ,String ritmoCInicial, String ritmoCIFinal, String omni_gse, String dia, int idPaciente, int idRutina){
        this.idRegistro = idRegistro;
        this.eje1Levantamiento=eje1Levantamiento;
        this.intento1E1L=intento1E1L;
        this.intento2E1L= intento2E1L;
        this.eje1Velocidad=eje1Velocidad;
        this.intento1E1V=intento1E1V;
        this.intento2E1V=intento2E1V;
        this.eje1Equilibrio=eje1Equilibrio;
        this.intento1E1E=intento1E1E;
        this.intento2E1V=intento2E1E;
        this.eje2Equilibrio=eje2Equilibrio;
        this.intento1E2E=intento1E2E;
        this.intento2E2E=intento2E2E;
        this.eje3Equilibrio=eje3Equilibrio;
        this.intento1E3E=intento1E3E;
        this.intento2E3E=intento2E3E;
        this.idRutina=idRutina; 
        this.ritmoCInicial = ritmoCInicial; 
        this.ritmoCIFinal= ritmoCIFinal; 
        this.omni_gse = omni_gse;
        this.dia = dia;
        this.idPaciente = idPaciente;

    }
    public Registro( String eje1Levantamiento, int intento1E1L,int intento2E1L,String eje1Velocidad, int intento1E1V, int intento2E1V, String eje1Equilibrio, int intento1E1E, int intento2E1E,String eje2Equilibrio, int intento1E2E, int intento2E2E, String eje3Equilibrio, int intento1E3E, int intento2E3E ,String ritmoCInicial, String ritmoCIFinal, String omni_gse, String dia){
        this.eje1Levantamiento=eje1Levantamiento;
        this.intento1E1L=intento1E1L;
        this.intento2E1L= intento2E1L;
        this.eje1Velocidad=eje1Velocidad;
        this.intento1E1V=intento1E1V;
        this.intento2E1V=intento2E1V;
        this.eje1Equilibrio=eje1Equilibrio;
        this.intento1E1E=intento1E1E;
        this.intento2E1V=intento2E1E;
        this.eje2Equilibrio=eje2Equilibrio;
        this.intento1E2E=intento1E2E;
        this.intento2E2E=intento2E2E;
        this.eje3Equilibrio=eje3Equilibrio;
        this.intento1E3E=intento1E3E;
        this.intento2E3E=intento2E3E;
        this.ritmoCInicial = ritmoCInicial; 
        this.ritmoCIFinal= ritmoCIFinal; 
        this.omni_gse = omni_gse;
        this.dia = dia;

    }

    public String getEje1Levantamiento() {
        return eje1Levantamiento;
    }

    public void setEje1Levantamiento(String eje1Levantamiento) {
        this.eje1Levantamiento = eje1Levantamiento;
    }

    public int getIntento1E1L() {
        return intento1E1L;
    }
    public void setIntento1E1L(int intento1E1L) {
        this.intento1E1L = intento1E1L;
    }

    public int getIntento2E1L() {
        return intento2E1L;
    }

    public void setIntento2E1L(int intento2E1L) {
        this.intento2E1L = intento2E1L;
    }

    public String getEje1Velocidad() {
        return eje1Velocidad;
    }

    public void setEje1Velocidad(String eje1Velocidad) {
        this.eje1Velocidad = eje1Velocidad;
    }

    public int getIntento1E1V() {
        return intento1E1V;
    }

    public void setIntento1E1V(int intento1E1V) {
        this.intento1E1V = intento1E1V;
    }

    public int getIntento2E1V() {
        return intento2E1V;
    }

    public void setIntento2E1V(int intento2E1V) {
        this.intento2E1V = intento2E1V;
    }

    public String getEje1Equilibrio() {
        return eje1Equilibrio;
    }

    public void setEje1Equilibrio(String eje1Equilibrio) {
        this.eje1Equilibrio = eje1Equilibrio;
    }

    public int getIntento1E1E() {
        return intento1E1E;
    }

    public void setIntento1E1E(int intento1E1E) {
        this.intento1E1E = intento1E1E;
    }

    public int getIntento2E1E() {
        return intento2E1E;
    }

    public void setIntento2E1E(int intento2E1E) {
        this.intento2E1E = intento2E1E;
    }

    public String getEje2Equilibrio() {
        return eje2Equilibrio;
    }

    public void setEje2Equilibrio(String eje2Equilibrio) {
        this.eje2Equilibrio = eje2Equilibrio;
    }

    public int getIntento1E2E() {
        return intento1E2E;
    }

    public void setIntento1E2E(int intento1E2E) {
        this.intento1E2E = intento1E2E;
    }

    public int getIntento2E2E() {
        return intento2E2E;
    }

    public void setIntento2E2E(int intento2E2E) {
        this.intento2E2E = intento2E2E;
    }

    public String getEje3Equilibrio() {
        return eje3Equilibrio;
    }

    public void setEje3Equilibrio(String eje3Equilibrio) {
        this.eje3Equilibrio = eje3Equilibrio;
    }

    public int getIntento1E3E() {
        return intento1E3E;
    }

    public void setIntento1E3E(int intento1E3E) {
        this.intento1E3E = intento1E3E;
    }

    public int getIntento2E3E() {
        return intento2E3E;
    }

    public void setIntento2E3E(int intento2E3E) {
        this.intento2E3E = intento2E3E;
    }

    public String getRitmoCIFinal() {
        return ritmoCIFinal;
    }

    public void setRitmoCIFinal(String ritmoCIFinal) {
        this.ritmoCIFinal = ritmoCIFinal;
    }

    public int getIdRutina() {
        return idRutina;
    }

    public void setIdRutina(int idRutina) {
        this.idRutina = idRutina;
    }

    public void setIdRegistro(int idRegistro){
        this.idRegistro= idRegistro; 
    }
    public int getIdRegistro(){
        return idRegistro; 
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
     
    public void setIdPaciente(int idPaciente){
        this.idPaciente = idPaciente; 
    }
    public int getIdPaciente(){
        return idPaciente;
    }
     
}