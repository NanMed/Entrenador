//
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*; 
import objetos.Colaborador;
import objetos.Cuenta;
import javax.servlet.annotation.WebServlet;

@WebServlet("/RegistarRutina")
public class RegistrarRutina extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response){

        try{

            String base = getServletContext().getInitParameter("base");
            String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");

            String idValidation = request.getParameter("id");
            String userValidation = request.getParameter("username");
            String mensaje = request.getParameter("mensaje");

            String name = request.getParameter("nombre");
            int cuentas = Integer.parseInt(request.getParameter("cuenta"));
            
            int window = Integer.parseInt(request.getParameter("pestana"));

            String video = request.getParameter("video");
            String texto = request.getParameter("texto");
            String imagen = request.getParameter("imagen");

            mensaje="Alta exitosa";
                
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);

            Statement stat = con.createStatement();

            System.out.println("video " + video + " texto " + texto + " imgaen " + imagen);
            String sql = "INSERT INTO rutina (video, texto, imagen) VALUES ('"+video+"', '"+texto+"', '"+imagen+"');";
            stat.executeUpdate(sql);

            stat.close();
            con.close();

            request.setAttribute("response", name);
            request.setAttribute("response2", cuentas);
            request.setAttribute("response3", window);
            request.setAttribute("mensaje", mensaje);

            RequestDispatcher disp = getServletContext().getRequestDispatcher("/AltaRutina.jsp");

            if(disp!=null){
                disp.forward(request,response);
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
