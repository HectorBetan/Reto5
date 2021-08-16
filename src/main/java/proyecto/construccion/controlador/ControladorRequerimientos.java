package proyecto.construccion.controlador;
import java.sql.SQLException;
import java.util.ArrayList;
import proyecto.construccion.modelo.vo.Requerimiento1;
import proyecto.construccion.modelo.vo.Requerimiento2;
import proyecto.construccion.modelo.vo.Requerimiento3;
import proyecto.construccion.modelo.dao.Requerimiento1DAO;
import proyecto.construccion.modelo.dao.Requerimiento2DAO;
import proyecto.construccion.modelo.dao.Requerimiento3DAO;
public class ControladorRequerimientos {
    Requerimiento1DAO req1Dao = new Requerimiento1DAO();
    Requerimiento2DAO req2Dao = new Requerimiento2DAO();
    Requerimiento3DAO req3Dao = new Requerimiento3DAO();
    public ArrayList<Requerimiento1> consultarRequerimiento1() throws SQLException {
        return req1Dao.requerimiento1();
    }
    public ArrayList<Requerimiento2> consultarRequerimiento2() throws SQLException {
        return req2Dao.requerimiento2();
    }
    public ArrayList<Requerimiento3> consultarRequerimiento3() throws SQLException {
        return req3Dao.requerimiento3();
    }
}