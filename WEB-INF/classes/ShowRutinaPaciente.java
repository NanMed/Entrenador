import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import objetos.Cuenta;
import objetos.Rutina;
import objetos.Paciente;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/showRutinaPaciente")
public class ShowRutinaPaciente extends HttpServlet{

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
			
			String sql2 = "SELECT idRutina FROM paciente WHERE cuenta = "+cuenta+";";
			ResultSet res = stat.executeQuery(sql2);

			int idRutina = 0;
			while(res.next()){
				idRutina = res.getInt("idRutina");
			}

			String sql = "Select * FROM Rutina WHERE idRutina = "+ idRutina +";";
			res = stat.executeQuery(sql);

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

			RequestDispatcher disp = getServletContext().getRequestDispatcher("/ShowRutinaPaciente.jsp"); 

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