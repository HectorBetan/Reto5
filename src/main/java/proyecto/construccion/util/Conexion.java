package proyecto.construccion.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexion {
    private static final String DATABASE_LOCATION = "ProyectosConstruccion.db";
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:sqlite:"+DATABASE_LOCATION;
        return DriverManager.getConnection(url);
    }
}