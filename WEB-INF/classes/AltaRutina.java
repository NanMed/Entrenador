import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import objetos.Cuenta;
import objetos.Paciente;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/AltaRutina")
public class AltaRutina extends HttpServlet{

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

            stat.close();
            con.close();

            request.setAttribute("response", nombre);
            request.setAttribute("response2", cuenta);
            request.setAttribute("response3", window);

            RequestDispatcher disp = getServletContext().getRequestDispatcher("/AltaRutina.jsp");

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