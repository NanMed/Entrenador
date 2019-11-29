import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import objetos.Cuenta;
import objetos.Rutina;
import objetos.Paciente;
import java.util.Vector;

import javax.servlet.annotation.WebServlet;

@WebServlet("/borrarRutina")
public class BorrarRutina extends HttpServlet{

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
            
            int id = Integer.parseInt(request.getParameter("test3"));
            String nombre=request.getParameter("nombre");
            int cuenta=Integer.parseInt(request.getParameter("cuenta"));
            int window= Integer.parseInt(request.getParameter("pestana"));
            
            String sql2 = "SELECT * FROM rutina;";
            ResultSet res = stat.executeQuery(sql2);
            Vector<Rutina> rutinas = new Vector<Rutina>();

            while(res.next()){
                Rutina aux = new Rutina();
                aux.setIdRutina(res.getInt("idRutina"));
                aux.setVideo(res.getString("video"));
                aux.setTexto(res.getString("texto"));
                aux.setImagen(res.getString("imagen"));
                rutinas.add(aux);
            }

            System.out.println("cuenta: " + cuenta);

            String query = " SELECT * FROM paciente WHERE idRutina ="+id+";";
            ResultSet set = stat.executeQuery(query);

            if(!set.next()  ){
                String det = "DELETE * FROM rutina WHERE idRutina = "+id+";";
                stat.executeUpdate(det);
            }

            sql2 = "SELECT * FROM paciente WHERE idEntrenador = "+cuenta+";";
            ResultSet res2 = stat.executeQuery(sql2);
            Vector<Paciente> pacientes = new Vector<Paciente>();

            while(res2.next()){
                Paciente aux = new Paciente();
                aux.setId(res2.getInt("ID"));
                aux.setCuenta(res2.getInt("cuenta"));
                aux.setContrasenia(res2.getString("contrasenia"));
                aux.setNombre(res2.getString("nombre"));
                aux.setApellido(res2.getString("apellido"));
                aux.setEdad(res2.getString("edad"));
                aux.setTipoU(res2.getString("tipo_u"));
                aux.setGenero(res2.getString("genero"));
                aux.setIdRutina(res2.getInt("idRutina"));
                aux.setIdMedico(res2.getInt("idMedico"));
                aux.setIdEntrenador(res2.getInt("idEntrenador"));
                pacientes.add(aux);
            }

            stat.close();
            con.close();
            
            request.setAttribute("pacientes", pacientes);
            request.setAttribute("rutinas", rutinas);
            request.setAttribute("response", nombre);
            request.setAttribute("response2", cuenta);
            request.setAttribute("response3", window);

            RequestDispatcher disp = getServletContext().getRequestDispatcher("/showRutinas.jsp"); 

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