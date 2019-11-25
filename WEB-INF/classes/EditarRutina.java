import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import objetos.Rutina;
import javax.servlet.annotation.WebServlet;
import java.util.Vector;

@WebServlet("/editarRutina") 
public class EditarRutina extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response){

        try{

            String base = getServletContext().getInitParameter("base");
            String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");
                
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);
    
            Statement stat = con.createStatement();

            int id = Integer.parseInt(request.getParameter("test3"));
            int cuenta = Integer.parseInt(request.getParameter("cuenta"));
            String nombre = request.getParameter("name");
            int window = Integer.parseInt(request.getParameter("pestana"));

            String sql = "Select * from rutina where idRutina="+id+";";
            ResultSet res = stat.executeQuery(sql);

            Vector<Rutina> rutinas = new Vector<Rutina>();

            while(res.next()){
                Rutina aux = new Rutina();
                aux.setIdRutina(res.getInt("idRutina"));
                aux.setVideo(res.getString("video"));
                aux.setTexto(res.getString("texto"));
                aux.setImagen(res.getString("imagen"));
                rutinas.add(aux);
            }

            stat.close();
            con.close();

            request.setAttribute("rutinas", rutinas);
            request.setAttribute("response", nombre);
            request.setAttribute("response2", cuenta);
            request.setAttribute("response3", window);

            RequestDispatcher disp = getServletContext().getRequestDispatcher("/EdicionRutina.jsp");

            if(disp!=null){
                disp.forward(request, response);
            }
            
        }
        catch(Exception e){
            try{
                e.printStackTrace();
            }
            catch(Exception e2){
                try{
                e.printStackTrace();
            }
            catch(Exception e3){
                e3.printStackTrace();
            }   
            }    
        }
    }   
}