import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import objetos.Paciente;

import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/Session")
public class Session extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{

			String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
			String password = getServletContext().getInitParameter("pass");


			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
		
			System.out.println(url);
			Connection con = DriverManager.getConnection(url,usuario,password);
			String nombre=request.getParameter("name");
			int cuenta=Integer.parseInt(request.getParameter("cuenta"));
			int window=Integer.parseInt(request.getParameter("pestana"));
			//int test3=Integer.parseInt(request.getParameter("test3"));

			Statement stat = con.createStatement();
			
			String sql = "select * from paciente;";			
			ResultSet res = stat.executeQuery(sql);

			Vector<Paciente> pacientes = new Vector<Paciente>();

			while(res.next()){
				Paciente aux = new Paciente();
				aux.setId(res.getInt("ID"));
				aux.setCuenta(res.getInt("cuenta"));				
				pacientes.add(aux);
			}

			stat.close();
            con.close();

		
			request.setAttribute("response", nombre);
			request.setAttribute("response2", cuenta);
			request.setAttribute("response3", window);

			RequestDispatcher disp = getServletContext().getRequestDispatcher("/showColaboradores.jsp");

			if(window==1){
				disp = getServletContext().getRequestDispatcher("/adminPass.jsp");
			}
			else if(window==2){
				disp = getServletContext().getRequestDispatcher("/entrenadorPass.jsp");
			}
			else if(window==3){
				window=1;
				request.setAttribute("response3", window);
				disp = getServletContext().getRequestDispatcher("/altaColaborador.jsp");
			}
			else if(window==4){
				window=4;
				request.setAttribute("response3", window);
				disp = getServletContext().getRequestDispatcher("/pacientePass.jsp");

			}
			else if(window==5){
				window=2;
				request.setAttribute("response3", window);
				disp = getServletContext().getRequestDispatcher("/RegistroProducto.jsp");
			} else if(window == 6){
				window=1;
				request.setAttribute("response3", window);
				disp = getServletContext().getRequestDispatcher("/altaPaciente.jsp");
			}
			else if(window == 7){
				window=1;
				request.setAttribute("response3", window);
				//request.setAttribute("clientes", clientes);
            	//request.setAttribute("trabajadores", trabajadores);
				disp = getServletContext().getRequestDispatcher("/ProyectoVenta.jsp");
			}
			else if(window==8){
				window=2;
				request.setAttribute("response3", window);
				//request.setAttribute("clientes", clientes);
            	//request.setAttribute("trabajadores", trabajadores);
				disp = getServletContext().getRequestDispatcher("/ProyectoVenta.jsp");
			}
			else if(window==9){
				window=10;
				request.setAttribute("response3", window);
				disp = getServletContext().getRequestDispatcher("/peticion.jsp");
			}
			else if(window==10){
				disp = getServletContext().getRequestDispatcher("/clientPass.jsp");

			} else if (window == 11) {
				window=1;
				request.setAttribute("response3", window);
				disp = getServletContext().getRequestDispatcher("/altaRegistro.jsp");
			} else if (window == 12) {
				window = 1;
				//request.setAttribute("test3", test3);
				request.setAttribute("response3", window);
				disp = getServletContext().getRequestDispatcher("/editarColab.jsp");
			}

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