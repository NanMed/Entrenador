//Comprobacion para jalar el numero del combobox
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*; 
import objetos.Paciente;
import objetos.Cuenta;
import objetos.Rutina;
import objetos.Colaborador;
import java.util.Vector;
import javax.servlet.annotation.WebServlet;

@WebServlet("/registroPaciente") 
public class RegistroPaciente extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response){ 

		try{
            PrintWriter writer = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto1.txt", "UTF-8");
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
            writer.print("paola");
            writer.close();
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

            String sql3 = "SELECT * FROM rutina;";

            ResultSet res = stat.executeQuery(sql3);

            Vector<Rutina> rutinas = new Vector<Rutina>();

            while(res.next()){
                Rutina aux = new Rutina();
                aux.setIdRutina(res.getInt("idRutina"));
                aux.setVideo(res.getString("video"));
                aux.setTexto(res.getString("texto"));
                aux.setImagen(res.getString("imagen"));
                rutinas.add(aux);
            }

            String sql4 = "SELECT * FROM colaborador;";
            ResultSet res2 = stat.executeQuery(sql4);

            Vector<Colaborador> medicos = new Vector<Colaborador>();
            Vector<Colaborador> entrenadores = new Vector<Colaborador>();

            while(res2.next()){
                Colaborador aux2 = new Colaborador();
                
                aux2.setId(res2.getInt("ID"));
                aux2.setCuenta(res2.getInt("cuenta"));
                aux2.setNombre(res2.getString("nombre"));
                aux2.setApellido(res2.getString("apellido"));
                aux2.setEdad(res2.getString("edad"));
                aux2.setGenero(res2.getString("genero"));
                aux2.setContrasenia(res2.getString("contrasenia"));
                if (aux2.getCuenta() == 1) {
                    medicos.add(aux2);
                }
                else{
                    entrenadores.add(aux2);
                }

            }
            request.setAttribute("medicos", medicos);
            request.setAttribute("entrenadores", entrenadores);
            request.setAttribute("rutinas", rutinas);
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