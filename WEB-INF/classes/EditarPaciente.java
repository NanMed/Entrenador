import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import objetos.Paciente;
import javax.servlet.annotation.WebServlet;
import java.util.Vector;

@WebServlet("/editarPaciente") 
public class EditarPaciente extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response){

        try{

            String base = getServletContext().getInitParameter("base");
            String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");
                
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);
    
            Statement stat = con.createStatement();

            int id = Integer.parseInt(request.getParameter("test3"));
            int cuenta = Integer.parseInt(request.getParameter("cuenta"));
            String nombre = request.getParameter("name");
            int window = Integer.parseInt(request.getParameter("pestana"));

            String sql = "Select * from paciente where ID="+id+";";
            ResultSet res = stat.executeQuery(sql);

            Vector<Paciente> pacientes = new Vector<Paciente>();

            while(res.next()){
                Paciente aux = new Paciente();
                aux.setId(res.getInt("ID"));
                aux.setCuenta(res.getInt("cuenta"));
                aux.setNombre(res.getString("nombre"));
                aux.setApellido(res.getString("apellido"));
                aux.setEdad(res.getString("edad"));
                aux.setTipoU(res.getString("tipo_u"));
                aux.setGenero(res.getString("genero"));
                aux.setIdRutina(res.getInt("idRutina"));
                aux.setContrasenia(res.getString("contrasenia"));
                aux.setIdMedico(res.getInt("idMedico"));
                aux.setIdEntrenador(res.getInt("idEntrenador"));
                pacientes.add(aux);
            }

            stat.close();
            con.close();

            request.setAttribute("pacientes", pacientes);
            request.setAttribute("response", nombre);
            request.setAttribute("response2", cuenta);
            request.setAttribute("response3", window);

            RequestDispatcher disp = getServletContext().getRequestDispatcher("/edicionPaciente.jsp");

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