import java.sql.*;
import java.text.SimpleDateFormat;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import objetos.Paciente;
import objetos.Colaborador;
import objetos.Rutina;
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


            String sql2 = "SELECT * FROM rutina;";
            res = stat.executeQuery(sql2);

            Vector<Rutina> rutinas = new Vector<Rutina>();

            while(res.next()){
                Rutina aux = new Rutina();
                aux.setIdRutina(res.getInt("idRutina"));
                aux.setVideo(res.getString("video"));
                aux.setTexto(res.getString("texto"));
                aux.setImagen(res.getString("imagen"));
                rutinas.add(aux);
            }

            sql = "SELECT * FROM colaborador WHERE cuenta LIKE '1%';";
            res = stat.executeQuery(sql);
            Vector<Colaborador> medicos = new Vector<Colaborador>();

            while(res.next()){
                Colaborador aux = new Colaborador();
                aux.setId(res.getInt("ID"));
                aux.setCuenta(res.getInt("cuenta"));
                aux.setNombre(res.getString("nombre"));
                aux.setApellido(res.getString("apellido"));
                aux.setApellido(res.getString("edad"));
                aux.setApellido(res.getString("genero"));
                aux.setContrasenia(res.getString("contrasenia"));
                medicos.add(aux);
            }

            sql = "SELECT * FROM colaborador WHERE cuenta LIKE '2%';";
            res = stat.executeQuery(sql);
            Vector<Colaborador> entrenadores = new Vector<Colaborador>();

            while(res.next()){
                Colaborador aux = new Colaborador();
                aux.setId(res.getInt("ID"));
                aux.setCuenta(res.getInt("cuenta"));
                aux.setNombre(res.getString("nombre"));
                aux.setApellido(res.getString("apellido"));
                aux.setApellido(res.getString("edad"));
                aux.setApellido(res.getString("genero"));
                aux.setContrasenia(res.getString("contrasenia"));
                entrenadores.add(aux);
            }

            stat.close();
            con.close();

            request.setAttribute("medicos", medicos);
            request.setAttribute("entrenadores", entrenadores);
            request.setAttribute("rutinas", rutinas);
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