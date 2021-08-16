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
import proyecto.construccion.modelo.vo.Requerimiento1;
import proyecto.construccion.controlador.ControladorRequerimientos;
public class Consulta1GUI extends JPanel{
    String titles[];
    String data[][];   
    JButton boton;
    JFrame frame;
    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();
    public Consulta1GUI() throws SQLException {    
        generarDatos();
        JTable tabla = new JTable(data,titles);
        tabla.setRowSelectionAllowed(true);
        tabla.setColumnSelectionAllowed(true);
        tabla.setSelectionForeground(Color.BLUE);
        tabla.setSelectionBackground(Color.CYAN);
        JScrollPane panel = new JScrollPane(tabla);
        panel.setPreferredSize(new java.awt.Dimension(550, 110));
        add(panel);  
    }
    public void generarDatos() throws SQLException {
        titles = new String[4];
        titles[0] = "<html><body><h3 color='#2641AD'>Nombre</h3></body></html>";
        titles[1] = "<html><body><h3 color='#2641AD'>Primer Apellido</h3></body></html>";
        titles[2] = "<html><body><h3 color='#2641AD'>Segundo Apellido</h3></body></html>";
        titles[3] = "<html><body><h3 color='#2641AD'>Salario</h3></body></html>";
        ArrayList<Requerimiento1> resultado = controlador.consultarRequerimiento1();
        data = new String[resultado.size()][4];  
        int iY = 0;
        for (Requerimiento1 requer1:resultado){
            String nombre = requer1.getNombre();
            String apellido1 = requer1.getPrimer_Apellido();
            String apellido2 =requer1.getSegundo_Apellido();
            Double salario =requer1.getSalario();
            data[iY][0] = nombre;
            data[iY][1] = apellido1;
            data[iY][2] = apellido2;
            data[iY][3] = "" + salario;
            iY++;
        }
    }
    public void Consultar() throws SQLException {
        String texto = "<html><body><center><h2 color='#164C8A'>Consulta 1</h2><p color='#0B2747'>Conocer el nombre, apellidos y salarios de los lideres cuyo segundo apellido sea ‘Ortiz’.<br><br></p></body></html>";
        JLabel label = new JLabel(texto);
        frame = new JFrame("Consulta 1");
        boton = new JButton("Cerrar");
        boton.addActionListener(new ActionListener () {public void actionPerformed (ActionEvent e) {if (e.getSource()==boton){frame.dispose();}}});
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(label);
        frame.getContentPane().add(new Consulta1GUI());
        frame.getContentPane().add(boton);
        frame.setVisible(true);
        frame.setSize(600, 290);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}