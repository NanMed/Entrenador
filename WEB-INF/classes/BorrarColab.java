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
@WebServlet("/borrarColab") 
public class BorrarColab extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{

            String base = getServletContext().getInitParameter("base");
            String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");
                
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);
    
            Statement stat = con.createStatement();

            String cuenta = request.getParameter("cuenta");
            int id = Integer.parseInt(request.getParameter("test3"));
            String nombre = request.getParameter("name");
            int window = Integer.parseInt(request.getParameter("pestana"));

            String squer = "SELECT cuenta FROM colaborador WHERE ID = "+id+";";
            ResultSet set = stat.executeQuery(squer);

            int cuenta_colab = 0;
            while(set.next()){
                cuenta_colab = set.getInt("cuenta");
            }

            String s = Integer.toString(cuenta_colab);
            System.out.println("cuenta_colab: " + s);

            if(s.charAt(0) == '1'){
                String query = " SELECT * FROM paciente WHERE idMedico = "+ id +";";
                set = stat.executeQuery(query);

            }else if(s.charAt(0) == '2'){
                String query = " SELECT * FROM paciente WHERE idEntrenador ="+id+";";
                set = stat.executeQuery(query);
            }

            if(!set.next()  ){
                String sql = "Delete from colaborador where ID="+id+";";
                stat.executeUpdate(sql);

                String sql2 = "Delete from cuenta where ID="+id+";";
                stat.executeUpdate(sql2);
            }

            
            String sql3 = "SELECT * FROM colaborador;";

            ResultSet res = stat.executeQuery(sql3);

            Vector<Colaborador> colaboradores = new Vector<Colaborador>();

            while(res.next()){
                Colaborador aux = new Colaborador();
                aux.setId(res.getInt("ID"));
                aux.setCuenta(res.getInt("cuenta"));
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