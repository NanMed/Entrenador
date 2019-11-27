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

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);

            Statement stat = con.createStatement();

            int cuenta = Integer.parseInt(request.getParameter("cuentaPaciente"));
            String contrasenia = request.getParameter("contrasenia");
            String nombre = request.getParameter("nombres");
            String apellido = request.getParameter("apellido");
            String tipoU = request.getParameter("tipo_u");
            String edad = request.getParameter("edad");
            String genero = request.getParameter("genero");
            int idRutina = 0;
            int idMedico = 0;
            int idEntrenador = 0;

            String mensaje = "";

            String selectionR = request.getParameter("selectionFilterR"); 
            String selectionM = request.getParameter("selectionFilterM"); 
            String selectionE = request.getParameter("selectionFilterE");  
            System.out.println(selectionE);          

            if(!selectionR.equals("n/a")){
                idRutina = Integer.parseInt(selectionR);
            } else {
                mensaje = "Verifica el id de la rutina"; 
            }

            if(!selectionM.equals("n/a") && selectionM.charAt(0) == '1'){
                idMedico = Integer.parseInt(selectionM);
            } else {
                mensaje = "Verifica el id del medico"; 
            }

            if(!selectionE.equals("n/a") && selectionE.charAt(0) == '2'){
                idEntrenador = Integer.parseInt(selectionE);
            } else {
                mensaje = "Verifica el id del entrenador"; 
            }

			String name = request.getParameter("nombre");
			int cuentas = Integer.parseInt(request.getParameter("cuenta"));
            int window = Integer.parseInt(request.getParameter("pestana"));

            System.out.println(idRutina + "id Rutina");
            System.out.println(idMedico + "id medico");
            System.out.println(idEntrenador + "id entrenador");

			String sql = "INSERT INTO cuenta VALUES ("+ cuenta+" ,'" +contrasenia+ "');";
            String sql2 = "INSERT INTO paciente (cuenta, nombre, apellido, edad, tipo_u, genero, idRutina, contrasenia, idMedico, idEntrenador) values(" + cuenta + ", '" + nombre + "', '"  + apellido + "', '"  + edad +   "', '"+ tipoU +"' , '" + genero + "', "+idRutina+", '"+ contrasenia+"', "+idMedico+", "+ idEntrenador+");";
			stat.executeUpdate(sql);
			stat.executeUpdate(sql2);

            mensaje = "Alta exitosa!";

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