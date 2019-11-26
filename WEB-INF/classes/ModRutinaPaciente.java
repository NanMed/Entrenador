import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import objetos.Cuenta;
import objetos.Rutina;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/modRutinaPAciente")
public class ModRutinaPaciente extends HttpServlet{
 
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
            
            String selection = request.getParameter("selectionFilter");   
            String message = "";    
            int idR = 0;     

            if(!selection.equals("n/a")){
                message = "Id no valido";
            } else{
                idR = Integer.parseInt(selection);
            }

            
            String sql = "SELECT * FROM rutina;";
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

            RequestDispatcher disp = getServletContext().getRequestDispatcher("/altaPaciente.jsp");

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