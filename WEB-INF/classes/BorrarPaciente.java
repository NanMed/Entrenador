import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import objetos.Paciente;
import objetos.Cuenta;
import javax.servlet.annotation.WebServlet;
import java.util.Vector;

@WebServlet("/borrarPaciente") 
public class BorrarPaciente extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{

            String base = getServletContext().getInitParameter("base");
            String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");
                
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);
    
            Statement stat = con.createStatement();

            int cuentaId = Integer.parseInt(request.getParameter("test3"));
            int cuenta = Integer.parseInt(request.getParameter("cuenta"));
            String nombre = request.getParameter("name");
            int window = Integer.parseInt(request.getParameter("pestana"));

            String sql2 = "Delete from paciente where cuenta="+cuentaId+";";
            stat.executeUpdate(sql2);

            String sql = "Delete from cuenta where ID="+cuentaId+";";
            stat.executeUpdate(sql);
            
            String sql3 = "SELECT * FROM paciente;";

            ResultSet res = stat.executeQuery(sql3);

            Vector<Paciente> pacientes = new Vector<Paciente>();
            
            
            while(res.next()){
                Paciente aux = new Paciente();
                aux.setId(res.getInt("ID"));
                aux.setCuenta(res.getInt("cuenta"));
                aux.setNombre(res.getString("nombre"));
                aux.setApellido(res.getString("apellido"));  
                aux.setEdad(res.getString("edad"));
                aux.setTipoU(res.getString("tipo_u"));     
                aux.setGenero(res.getString("genero"));
                aux.setIdRutina(res.getInt("idRutina"));  
                aux.setContrasenia(res.getString("contrasenia")); 
                aux.setIdMedico(res.getInt("idMedico"));   
                aux.setIdEntrenador(res.getInt("idEntrenador"));       
                pacientes.add(aux);

            }

            stat.close();
            con.close();
            
            request.setAttribute("pacientes", pacientes);
            request.setAttribute("response", nombre);
            request.setAttribute("response2", cuenta);
            request.setAttribute("response3", window);

            RequestDispatcher disp = getServletContext().getRequestDispatcher("/showPacientes.jsp");

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