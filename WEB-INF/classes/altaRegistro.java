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
            
            int id = Integer.parseInt(request.getParameter("id"));
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

            String sql = "INSERT INTO registro (idRegistro, eje1Levantamiento, intento1E1L, intento2E1L, eje1Velocidad, intento1E1V, intento2E1V, eje1Equilibrio, intento1E1E, intento2E1E, eje2Equilibrio, intento1E2E, intento2E2E, eje3Equilibrio, intento1E3E, intento2E3E, ritmoCFinal, ritmoCInicial, omni_gse, dia, idPaciente, idRutina) values("+id+", '"+eje1Levantamiento+"', " + intento1E1L + ", " + intento2E1L + ", '"  + eje1Velocidad + "', "  + intento1E1V + ", "  + intento2E1V+ ", '"  + eje1Equilibrio + "', "  + intento1E1E + " , "  + intento2E1E + ", '"  + eje2Equilibrio + "', "  + intento1E2E + " , "  + intento2E2E + ", '"  + eje3Equilibrio + "', "  + intento1E3E + " , "  + intento2E3E + ", '"  + ritmoCFinal + "', '"  + ritmoCInicial + "' , '"  + omni_gse + "',  '"  + dia + "' , "+idPaciente+", "+idRutina+");";
            stat.executeUpdate(sql);

            request.setAttribute("response", name);
            request.setAttribute("response2", cuentas);
            request.setAttribute("response3", window);

            //Condiciones
            int velocidadTemp = (int)(intento1E1V+intento2E1V)/2 ;
            int levantamientoTemp = (int)(intento1E1L+intento1E1L)/2 ;
            int prueba1ETemp = (int)(intento1E1E+intento2E1E)/2;
            int prueba2ETemp = (int)(intento1E2E+intento2E2E)/2;
            int prueba3ETemp = (int)(intento1E3E+intento2E3E)/2;
            int velocidad = 0;
            int levantamiento = 0;
            int resultE1 = 0;
            int resultE2 = 0;
            int resultE3 = 0;


            if(velocidadTemp < 3){
                velocidad = 4;
            }else if (velocidadTemp >= 3 &&velocidadTemp <=4) {
                velocidad = 3;
            }else if (velocidadTemp < 4 && velocidadTemp <= 6) {
                velocidad = 2;
            }else if (velocidadTemp>6) {
                velocidad = 1; 
            }else{
                velocidad = 0;
            }

            if(levantamientoTemp < 11){
                levantamiento = 4;
            }else if (levantamientoTemp>=11&& levantamientoTemp<13) {
                levantamiento=3;
                
            }else if (levantamientoTemp>=13 && levantamientoTemp<16) {
                levantamiento=2;
                
            }else if (levantamientoTemp>=16 && levantamientoTemp<=59) {
                levantamiento=1;
            }else{
                levantamiento=0;
            }

            if(prueba1ETemp==10){
                resultE1=1;
            }else{
                resultE1=0;
            }

            if(prueba2ETemp==10){
                resultE2=1;

            } else{
                resultE2=0;
            }

            if(prueba3ETemp==10){
                resultE3=2;

            }else if (prueba3ETemp>=3&& prueba3ETemp<=9) {
                resultE3=1;
                
            }else{
                resultE3=0;
            }
             
            int equilibrioFinal = resultE1+resultE2+resultE3;

            String sql2 = "INSERT INTO progreso (velocidad, levantamiento, equilibrio, dia, idRutina, idPaciente, idRegistro) values( " + velocidad + ", " + levantamiento+ ", " +equilibrioFinal +", '"+dia+"', "+idRutina+", "+idPaciente+", "+id+");";

            stat.executeUpdate(sql2);

            RequestDispatcher disp = getServletContext().getRequestDispatcher("/altaRegistro.jsp");

            System.out.println("Sí se guard el nuevo registro");
            stat.close();
            con.close();

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
                } catch(Exception e3){
                e3.printStackTrace();
                }   
            }   
        }

    }

    

}
