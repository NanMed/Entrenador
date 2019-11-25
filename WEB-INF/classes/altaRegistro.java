import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*; 
import objetos.Registro;
import javax.servlet.annotation.WebServlet;
 
@WebServlet("/altaRegistro")
public class AltaRegistro extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response){ 

        try{

            String base = getServletContext().getInitParameter("base");
            String usuario = getServletContext().getInitParameter("usuario");
            String pass = getServletContext().getInitParameter("pass");
            
            String eje1Levantamiento = request.getParameter("eje1Levantamiento");
            int intento1E1L = Integer.parseInt(request.getParameter("intento1E1L"));
            int intento2E1L = Integer.parseInt(request.getParameter("intento2E1L"));
            String eje1Velocidad = request.getParameter("eje1Velocidad");
            int intento1E1V =Integer.parseInt(request.getParameter("intento1E1V"));
            int intento2E1V = Integer.parseInt(request.getParameter("intento2E1V"));
            String eje1Equilibrio= request.getParameter("eje1Equilibrio");
            int intento1E1E= Integer.parseInt(request.getParameter("intento1E1E"));
            int intento2E1E= Integer.parseInt(request.getParameter("intento2E1E"));
            String eje2Equilibrio= request.getParameter("eje2Equilibrio");
            int intento1E2E= Integer.parseInt(request.getParameter("intento1E2E"));
            int intento2E2E= Integer.parseInt(request.getParameter("intento2E2E"));
            String eje3Equilibrio= request.getParameter("eje3Equilibrio");
            int intento1E3E= Integer.parseInt(request.getParameter("intento1E3E"));
            int intento2E3E= Integer.parseInt(request.getParameter("intento2E3E"));
            String ritmoCInicial= request.getParameter("ritmoCInicial");
            String ritmoCFinal= request.getParameter("ritmoCFinal");
            String omni_gse= request.getParameter("omni_gse");
            String dia= request.getParameter("dia");
            int idPaciente= Integer.parseInt(request.getParameter("pacienteId"));
            int idRutina= Integer.parseInt(request.getParameter("rutinaId"));

            //Registro newRegistro = new Registro(eje1Levantamiento,intento1E1L,intento2E1L,eje1Velocidad,intento1E1V,intento2E1V,eje1Equilibrio,intento1E1E,intento2E1E,eje2Equilibrio,intento1E2E,intento2E2E,eje3Equilibrio,intento1E3E,intento2E3E,ritmoCInicial,ritmoCFinal,omni_gse,dia);

            
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/"+base+"?useSSL=false&allowPublicKeyRetrieval=true";
            Connection con = DriverManager.getConnection(url,usuario,pass);

            Statement stat = con.createStatement();

            String name=request.getParameter("nombre");
            int cuentas=Integer.parseInt(request.getParameter("cuenta"));
            
            int window= Integer.parseInt(request.getParameter("pestana"));

            String sql = "INSERT INTO registro (eje1Levantamiento, intento1E1L, intento2E1L, eje1Velocidad, intento1E1V, intento2E1V, eje1Equilibrio, intento1E1E, intento2E1E, eje2Equilibrio, intento1E2E, intento2E2E, eje3Equilibrio, intento1E3E, intento2E3E, ritmoCFinal, ritmoCInicial, omni_gse, dia, idPaciente, idRutina) values('"+eje1Levantamiento+"', " + intento1E1L + ", " + intento2E1L + ", '"  + eje1Velocidad + "', "  + intento1E1V + ", "  + intento2E1V+ ", '"  + eje1Equilibrio + "', "  + intento1E1E + " , "  + intento2E1E + ", '"  + eje2Equilibrio + "', "  + intento1E2E + " , "  + intento2E2E + ", '"  + eje3Equilibrio + "', "  + intento1E3E + " , "  + intento2E3E + ", '"  + ritmoCFinal + "', '"  + ritmoCInicial + "' , '"  + omni_gse + "',  '"  + dia + "' , "+idPaciente+", "+idRutina+");";
            stat.executeUpdate(sql);

          
            System.out.println("Sí se guard el nuevo registro");
            stat.close();
            con.close();

            request.setAttribute("response", name);
            request.setAttribute("response2", cuentas);
            request.setAttribute("response3", window);

            RequestDispatcher disp = getServletContext().getRequestDispatcher("/altaRegistro.jsp");

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
