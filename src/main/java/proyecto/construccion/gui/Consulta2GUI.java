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
import proyecto.construccion.modelo.vo.Requerimiento2;
import proyecto.construccion.controlador.ControladorRequerimientos;
public class Consulta2GUI extends JPanel{
    String titles[];
    String data[][];
    JButton boton; 
    JFrame frame;  
    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();
    public Consulta2GUI() throws SQLException {    
        generarDatos();
        JTable tabla = new JTable(data,titles);
        tabla.setRowSelectionAllowed(true);
        tabla.setColumnSelectionAllowed(true);
        tabla.setSelectionForeground(Color.BLUE);
        tabla.setSelectionBackground(Color.CYAN);
        JScrollPane panel = new JScrollPane(tabla);
        panel.setPreferredSize(new java.awt.Dimension(180, 300));
        add(panel);  
    }
    public void generarDatos() throws SQLException {
        titles = new String[1];
        titles[0] = "<html><body><h3 color='#2641AD'>Nombre</h3></body></html>";
        ArrayList<Requerimiento2> resultado = controlador.consultarRequerimiento2();
        data = new String[resultado.size()][1];  
        int iY = 0;
        for (Requerimiento2 requer2:resultado){
            String nombre = requer2.getNombre();
            data[iY][0] = nombre;
            iY++;
        }
    }
    public void Consultar() throws SQLException {
        String texto = "<html><body><center><h2 color='#164C8A'>Consulta 2</h2<p color='#0B2747'>Transformar y obtener  el nombre <br>de los lideres donde la primera <br>letra sea en minúscula <br>y las demás en mayúscula.<br><br></p></body></html>";
        JLabel label = new JLabel(texto);
        frame = new JFrame("Consulta 2");
        boton = new JButton("Cerrar");
        boton.addActionListener(new ActionListener () {public void actionPerformed (ActionEvent e) {if (e.getSource()==boton){frame.dispose();}}});
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(label);
        frame.getContentPane().add(new Consulta2GUI());
        frame.getContentPane().add(boton);
        frame.setSize(260, 525);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}