package proyecto.construccion.modelo.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import proyecto.construccion.util.Conexion;
import proyecto.construccion.modelo.vo.Requerimiento3;
public class Requerimiento3DAO {
    Connection conexion;
    public Requerimiento3DAO(){
        try {
            conexion = Conexion.getConnection();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Requerimiento3> requerimiento3() throws SQLException {
        ArrayList <Requerimiento3> req3 = new ArrayList<>();
        String sql = "SELECT Cargo, avg(Salario) as 'Promedio' FROM Lider l GROUP by Cargo HAVING avg(Salario)>500000 ORDER by Cargo";
        Statement stmt = conexion.createStatement();
        ResultSet resultado = stmt.executeQuery(sql);
        while(resultado.next()){
            Requerimiento3 reque3 = new Requerimiento3();
            reque3.setCargo(resultado.getString("Cargo"));
            reque3.setPromedio(resultado.getString("Promedio"));
            req3.add(reque3);
        }
        return req3;
    }
}