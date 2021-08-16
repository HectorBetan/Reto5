package proyecto.construccion.modelo.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import proyecto.construccion.util.Conexion;
import proyecto.construccion.modelo.vo.Requerimiento2;
public class Requerimiento2DAO {
    Connection conexion;
    public Requerimiento2DAO(){
        try {
            conexion = Conexion.getConnection();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Requerimiento2> requerimiento2() throws SQLException {
        ArrayList <Requerimiento2> req2 = new ArrayList<>();
        String sql = "SELECT LOWER(SUBSTR(Nombre,1,1)) || UPPER(SUBSTR(Nombre,2)) as 'Nombre' FROM Lider";
        Statement stmt = conexion.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while(resultado.next()){
            Requerimiento2 reque2 = new Requerimiento2();
            reque2.setNombre(resultado.getString("Nombre"));
            req2.add(reque2);
        }
        return req2;
    }
}