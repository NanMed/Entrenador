//
import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import objetos.Cuenta;
import objetos.Colaborador;
import javax.servlet.annotation.WebServlet;
import java.util.Vector;
@WebServlet("/editarColab") 
public class EditarColab extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{

            String base = getServletContext().getInitParameter("base");
            String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");
                
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);
    
            Statement stat = con.createStatement();

            //int id = Integer.parseInt(request.getParameter("test3"));
            int cuenta = Integer.parseInt(request.getParameter("cuenta"));
            String nombre = request.getParameter("name");
            int window = Integer.parseInt(request.getParameter("pestana"));

            int idE = Integer.parseInt(request.getParameter("id"));
            String nombreE = request.getParameter("nombres");
            String apellido = request.getParameter("apellido");
            String edad = request.getParameter("edad");
            String genero = request.getParameter("genero");

            String sql = "Update colaborador set nombre = '"+nombreE+"', apellido = '"+apellido+"', edad = '"+edad+"', genero = '"+genero+"' where id = "+idE+";";

            
            ResultSet res = stat.executeQuery(sql);

            Vector<Colaborador> colaboradores = new Vector<Colaborador>();

            while(res.next()){
                Colaborador aux = new Colaborador();
                aux.setNombre(res.getString("nombre"));
                aux.setApellido(res.getString("apellido"));
                aux.setEdad(res.getString("edad"));
                aux.setGenero(res.getString("genero"));
                colaboradores.add(aux);
            }

            stat.close();
            con.close();

            request.setAttribute("colaboradores", colaboradores);
            request.setAttribute("response", nombre);
            request.setAttribute("response2", cuenta);
            request.setAttribute("response3", window);

            RequestDispatcher disp = getServletContext().getRequestDispatcher("/showColaboradores.jsp");

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