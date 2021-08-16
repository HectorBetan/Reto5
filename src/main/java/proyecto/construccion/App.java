package proyecto.construccion;
import javax.swing.JFrame;
import proyecto.construccion.gui.Principal;
public class App{
    public static void main( String[] args ){
        Principal principal = new Principal();
        principal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        principal.setLocationRelativeTo(null);
        principal.setTitle("Consultas Proyectos Construcción");
    }
}