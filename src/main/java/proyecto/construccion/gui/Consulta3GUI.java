package proyecto.construccion.gui;
import javax.swing.JPanel;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import proyecto.construccion.modelo.vo.Requerimiento3;
import proyecto.construccion.controlador.ControladorRequerimientos;
public class Consulta3GUI extends JPanel{
    String titles[];
    String data[][]; 
    JButton boton;  
    JFrame frame;  
    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();
    public Consulta3GUI() throws SQLException {    
        generarDatos();
        JTable tabla = new JTable(data,titles);
        tabla.setRowSelectionAllowed(true);
        tabla.setColumnSelectionAllowed(true);
        tabla.setSelectionForeground(Color.BLUE);
        tabla.setSelectionBackground(Color.CYAN);
        JScrollPane panel = new JScrollPane(tabla);
        panel.setPreferredSize(new java.awt.Dimension(300, 78));
        add(panel);  
    }
    public void generarDatos() throws SQLException {
        titles = new String[2];
        titles[0] = "<html><body><h3 color='#2641AD'>Cargo</h3></body></html>";
        titles[1] = "<html><body><h3 color='#2641AD'>Promedio</h3></body></html>";
        ArrayList<Requerimiento3> resultado = controlador.consultarRequerimiento3();
        data = new String[resultado.size()][2];  
        int iY = 0;
        for (Requerimiento3 requer3:resultado){
            String nombre = requer3.getCargo();
            String promedio = requer3.getPromedio();
            data[iY][0] = nombre;
            data[iY][1] = promedio;
            iY++;
        }
    }
    public void Consultar() throws SQLException {
        String texto = "<html><body><center><h2 color='#164C8A'>Consulta 3</h2><p color='#0B2747'>Agrupar los lideres por su cargo y retornar<br>solo los grupos cuyo promedio de salarios supere 500000.<br><br></p></body></html>";
        JLabel label = new JLabel(texto);
        frame = new JFrame("Consulta 3");
        boton = new JButton("Cerrar");
        boton.addActionListener(new ActionListener () {public void actionPerformed (ActionEvent e) {if (e.getSource()==boton){frame.dispose();}}});
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(label);
        frame.getContentPane().add(new Consulta3GUI());
        frame.getContentPane().add(boton);
        frame.setSize(400, 275);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}