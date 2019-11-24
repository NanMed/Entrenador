import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import objetos.Colaborador;
import javax.servlet.annotation.WebServlet;
import java.util.Vector;

@WebServlet("/Login")
public class Login extends HttpServlet{

	public void doPost(HttpServletRequest request, HttpServletResponse response){

		try{
            //PrintWriter writer = new PrintWriter("/Users/alanzavala/Desktop/DBCurso/prueba.txt", "UTF-8");
            String base = getServletContext().getInitParameter("base");
			String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");

            
            Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);


            String verifyRoll = request.getParameter("username");  

            int usuarioA = Integer.parseInt(request.getParameter("username"));
            
            String passwordA = request.getParameter("password");  

            //writer.println("venga papaaaa2");

            Statement stat = con.createStatement();

            String sql ="select * from colaborador;";

            //writer.println("venga papaaaa3");
            ResultSet res = stat.executeQuery(sql);

            
            //writer.println("venga papaaaa4");
            Vector<Colaborador> cuentas = new Vector<Colaborador>();
            int checkCuenta;
            String nombre="";
            boolean checkLog = false;
            //writer.println("venga papaaaa10");
            //writer.close();
            while(res.next()){
                
                if(res.getInt("cuenta")==usuarioA && res.getString("contrasenia").equals(passwordA)){
                    nombre=res.getString("nombre");

                    checkLog=true;
                    break;
                }

            }
            //writer.println("venga papaaaa5");
            

            stat.close();
            con.close();

            RequestDispatcher disp =  getServletContext().getRequestDispatcher("/showUsuarios.jsp");

            if(checkLog){
                request.setAttribute("response", nombre);
                request.setAttribute("response2", usuarioA);
                
            }
            if(checkLog){
                if(verifyRoll.charAt(0)== '1'){
                    
                    disp = getServletContext().getRequestDispatcher("/adminPass.jsp");
                }
                else if(verifyRoll.charAt(0)== '2'){
                    
                    disp = getServletContext().getRequestDispatcher("/entrenadorPass.jsp");
                } else if(verifyRoll.charAt(0)== '3'){
                    
                    disp = getServletContext().getRequestDispatcher("/pacientePass.jsp");
                }
            }
            else{
                disp = getServletContext().getRequestDispatcher("/index.jsp");
            }


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
