import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import objetos.Rutina;
import objetos.Colaborador;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/altaP")
public class AltaP extends HttpServlet{

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
			
			String nombre = request.getParameter("nombre");
			int cuenta = Integer.parseInt(request.getParameter("cuenta"));
            int window = Integer.parseInt(request.getParameter("pestana"));
			
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

            String sql2 = "SELECT * FROM colaborador;";
			ResultSet res2 = stat.executeQuery(sql2);

			Vector<Colaborador> colaboradores = new Vector<Colaborador>();

            while(res2.next()){
                Colaborador aux2 = new Colaborador();
                aux2.setId(res2.getInt("ID"));
                aux2.setCuenta(res2.getInt("cuenta"));
                aux2.setNombre(res2.getString("nombre"));
                aux2.setApellido(res2.getString("apellido"));
                aux2.setEdad(res2.getString("edad"));
                aux2.setGenero(res2.getString("genero"));
                aux2.setContrasenia(res2.getString("contrasenia"));
                colaboradores.add(aux2);
            }

			stat.close();
            con.close();

            request.setAttribute("colaboradores", colaboradores);
            request.setAttribute("colaboradores2", colaboradores);
			request.setAttribute("rutinas", rutinas);
			request.setAttribute("response", nombre);
            request.setAttribute("response2", cuenta);
            request.setAttribute("response3", window);

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