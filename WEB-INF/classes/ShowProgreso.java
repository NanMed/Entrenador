import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import objetos.Progreso;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/ShowProgreso")
public class ShowProgreso extends HttpServlet{
 
	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			PrintWriter writer = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto1.txt", "UTF-8");
			
			String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
			String password = getServletContext().getInitParameter("pass");
			writer.print("omar");

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
		
			System.out.println(url);
			Connection con = DriverManager.getConnection(url,usuario,password);

			Statement stat = con.createStatement();
			String sql;
			String nombre = request.getParameter("name");
			int cuenta = Integer.parseInt(request.getParameter("cuenta"));
            
            int window= Integer.parseInt(request.getParameter("pestana"));
            int userId= Integer.parseInt(request.getParameter("test4"));
			
			
			String sql2 = "SELECT * FROM progreso where idPaciente="+userId+";";

			ResultSet res = stat.executeQuery(sql2);

			Vector<Progreso> progreso = new Vector<Progreso>();
			
            while(res.next()){
            	writer.print("entreee");
                Progreso aux = new Progreso();
                aux.setIdProgreso(res.getInt("idProgreso"));
                writer.print(" ID: "+aux.getIdProgreso()+" ");
                aux.setVelocidad(res.getInt("velocidad"));
                aux.setLevantamiento(res.getInt("levantamiento"));
                aux.setEquilibrio(res.getInt("equilibrio"));
                aux.setDia(res.getString("dia"));
                aux.setIdRutina(res.getInt("idRutina"));
                aux.setIdPaciente(res.getInt("idPaciente"));
                aux.setIdRegistro(res.getInt("idRegistro"));
                progreso.add(aux);
            }


			stat.close();
            con.close();

			request.setAttribute("progresos", progreso);
			request.setAttribute("response", nombre);
            request.setAttribute("response2", cuenta);
            request.setAttribute("response3", window);

            writer.print("size: "+progreso.size()+ " !");
            writer.print("paolamiamor10");
            writer.print(nombre);
			writer.close();


			RequestDispatcher disp = getServletContext().getRequestDispatcher("/ShowProgreso.jsp");

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