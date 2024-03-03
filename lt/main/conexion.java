import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {
    
    String mensaje;    

    public conexion() {
    }

    public void conexionlocaL(String servidor,String usuario, String contraseña) {
        try (Connection connection = DriverManager.getConnection(servidor, usuario, contraseña)) {
            if (connection != null) {
                mensaje = "Conexion Correcta";
            }

        } catch (Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String rastroDePila = sw.toString();

            mensaje = "Error. La conexion esta deshabilitada " + rastroDePila;
        }
    }

    public String getMensaje() {
        return mensaje;
    }
}