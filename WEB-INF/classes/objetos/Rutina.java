package objetos;
public class Rutina{
    private int idRutina;
    private String video;
    private String texto;
    private String imagen;
   
    public Rutina(){
        
    }
    public Rutina(int idRutina, String video, String texto, String imagen) {
        this.idRutina=idRutina;
        this.video = video; 
        this.texto = texto; 
        this.imagen = imagen; 
            
    }

    public int getIdRutina(){
        return idRutina;
    }
    public void setIdRutina(int idRutina){
        this.idRutina=idRutina;
    }

    public String getVideo(){
        return video;
    }

    public void setVideo(String video){
        this.video = video;
    }

    public String getTexto(){
        return texto;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public String getImagen(){
        return imagen;
    }

    public void setImagen(String imagen){
        this.imagen= imagen;
    }

}