package proyecto.construccion.modelo.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import proyecto.construccion.util.Conexion;
import proyecto.construccion.modelo.vo.Requerimiento1;
public class Requerimiento1DAO {
    Connection conexion;
    public Requerimiento1DAO(){
        try {
            conexion = Conexion.getConnection();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Requerimiento1> requerimiento1() throws SQLException {
        ArrayList <Requerimiento1> req1 = new ArrayList<>();
        String sql = "SELECT Nombre, Primer_Apellido, Segundo_Apellido, Salario FROM Lider WHERE Segundo_Apellido == 'Ortiz'";
        Statement stmt = conexion.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while(resultado.next()){
            Requerimiento1 reque1 = new Requerimiento1();
            reque1.setNombre(resultado.getString("Nombre"));
            reque1.setPrimer_Apellido(resultado.getString("Primer_Apellido"));
            reque1.setSegundo_Apellido(resultado.getString("Segundo_Apellido"));
            reque1.setSalario(resultado.getDouble("Salario"));
            req1.add(reque1);
        }
        return req1;
    }
}