//Comprobacion para jalar el numero del combobox
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*; 
import objetos.Paciente;
import objetos.Cuenta;
import objetos.Rutina;
import javax.servlet.annotation.WebServlet;

@WebServlet("/registroPaciente") 
public class RegistroPaciente extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response){ 

		try{

			String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");


            //int id = Integer.parseInt(request.getParameter("id"));
            int cuenta = Integer.parseInt(request.getParameter("cuentaPaciente"));
            String contrasenia = request.getParameter("contrasenia");
            String nombre = request.getParameter("nombres");
            String apellido = request.getParameter("apellido");
            String tipoU = request.getParameter("tipo_u");
            String edad = request.getParameter("edad");
            String genero = request.getParameter("genero");
            int idRutina = Integer.parseInt(request.getParameter("id_rutina"));
            int idMedico = Integer.parseInt(request.getParameter("id_medico"));
            int idEntrenador = Integer.parseInt(request.getParameter("id_entrenador"));

			Paciente newPaciente = new Paciente(34, cuenta, contrasenia, nombre, apellido, edad, tipoU, genero, idRutina, idMedico, idEntrenador);

			Cuenta newCuenta = new Cuenta(cuenta, contrasenia);
            
            Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);

			Statement stat = con.createStatement();

			String name = request.getParameter("nombre");
			int cuentas = Integer.parseInt(request.getParameter("cuenta"));
            
            int window = Integer.parseInt(request.getParameter("pestana"));

			String sql = "INSERT INTO cuenta VALUES ("+ cuenta+" ,'" +contrasenia+ "');";
            String sql2 = "INSERT INTO paciente (cuenta, nombre, apellido, edad, tipo_u, genero, idRutina, contrasenia, idMedico, idEntrenador) values(" + cuenta + ", '" + nombre + "', '"  + apellido + "', '"  + edad +   "', '"+ tipoU +"' , '" + genero + "', "+idRutina+", '"+ contrasenia+"', "+idMedico+", "+ idEntrenador+");";
			stat.executeUpdate(sql);
			stat.executeUpdate(sql2);

            String mensaje = "Alta exitosa";

            //Todo lo de los id se tiene que hacer antes de hacer el insert para obtener los valores y hacer las comboraciones del combobox
            request.setAttribute("response", name);
            request.setAttribute("response2", cuentas);
            request.setAttribute("response3", window);
            request.setAttribute("mensaje", mensaje);
			
			stat.close();
			con.close();

			

			RequestDispatcher disp = getServletContext().getRequestDispatcher("/altaPaciente.jsp");

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