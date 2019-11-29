import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import objetos.Registro;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/showHistorialPaciente")
public class ShowHistorialPaciente extends HttpServlet{
 
	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
			//PrintWriter writer = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/proyecto1.txt", "UTF-8");
			
			String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
			String password = getServletContext().getInitParameter("pass");
			//writer.print("omar");

			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
		
			System.out.println(url);
			Connection con = DriverManager.getConnection(url,usuario,password);

			Statement stat = con.createStatement();
			String sql;
			String nombre = request.getParameter("name");
			int cuenta = Integer.parseInt(request.getParameter("cuenta"));
            int window= Integer.parseInt(request.getParameter("pestana"));
			//writer.print("zavala");
			String sql2 = "SELECT * FROM registro where idPaciente="+cuenta+";";

			ResultSet res = stat.executeQuery(sql2);

			Vector<Registro> registro = new Vector<Registro>();
			
            while(res.next()){
                Registro aux = new Registro();
                aux.setIdRegistro(res.getInt("idRegistro"));
                aux.setEje1Levantamiento(res.getString("eje1Levantamiento"));
                aux.setIntento1E1L(res.getInt("intento1E1L"));
                aux.setIntento2E1L(res.getInt("intento2E1L"));
                aux.setEje1Velocidad(res.getString("eje1Velocidad"));
                aux.setIntento1E1V(res.getInt("intento1E1V"));
                aux.setIntento2E1V(res.getInt("intento2E1V"));
                aux.setEje1Equilibrio(res.getString("eje1Equilibrio"));
                aux.setIntento1E1E(res.getInt("intento1E1E"));
                aux.setIntento2E1E(res.getInt("intento2E1E"));
                aux.setEje2Equilibrio(res.getString("eje2Equilibrio"));
                aux.setIntento1E2E(res.getInt("intento1E2E"));
                aux.setIntento2E2E(res.getInt("intento2E2E"));
                aux.setEje3Equilibrio(res.getString("eje3Equilibrio"));
                aux.setIntento1E3E(res.getInt("intento1E3E"));
                aux.setIntento2E3E(res.getInt("intento2E3E"));

                aux.setRitmoCFinal(res.getString("ritmoCFinal"));
                aux.setRitmoCInicial(res.getString("ritmoCInicial"));
                aux.setOmni_gse(res.getString("omni_gse"));
                aux.setDia(res.getString("dia"));

                aux.setIdPaciente(res.getInt("idPaciente"));
                aux.setIdRutina(res.getInt("idRutina"));
                
               
                registro.add(aux);
            }


			stat.close();
            con.close();

			request.setAttribute("registro", registro);
			request.setAttribute("response", nombre);
            request.setAttribute("response2", cuenta);
            request.setAttribute("response3", window);
            //writer.print("paolamiamor10");
			//writer.close();


			RequestDispatcher disp = getServletContext().getRequestDispatcher("/showHistorialPaciente.jsp");

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