import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import objetos.Rutina;
import javax.servlet.annotation.WebServlet;
import java.util.Vector;

@WebServlet("/guardarCambiosRutina")
public class GuardarCambiosRutina extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        try{
            String base = getServletContext().getInitParameter("base");
            String usuario = getServletContext().getInitParameter("usuario");
            String password = getServletContext().getInitParameter("pass");


            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
        
            System.out.println(url);
            Connection con = DriverManager.getConnection(url,usuario,password);

            Statement stat = con.createStatement();
            
            String nombre=request.getParameter("nombre");
            int cuenta=Integer.parseInt(request.getParameter("cuenta"));
            int window= Integer.parseInt(request.getParameter("pestana"));

            int id = Integer.parseInt(request.getParameter("idRutina"));
            String video = request.getParameter("video");
            String texto = request.getParameter("texto");
            String imagen = request.getParameter("imagen");

            String sql = "UPDATE rutina SET video = \"" + video + "\", texto = \"" + texto + "\", imagen = \"" + imagen + "\" WHERE idRutina = \"" + id + "\";";
            stat.executeUpdate(sql);

            String sql2 = "SELECT * FROM rutina;";
            ResultSet res = stat.executeQuery(sql2);

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

            RequestDispatcher disp = getServletContext().getRequestDispatcher("/showRutinas.jsp");

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