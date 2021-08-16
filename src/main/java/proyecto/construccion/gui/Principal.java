package proyecto.construccion.gui;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.*;
public class Principal extends JFrame {
    Container contenedor;
    JPanel panel1, panel2, panel3;
    JButton boton1, boton2, boton3;
    public Principal(){
        Font fuente = new Font( Font.SANS_SERIF,1, 15);
        contenedor = getContentPane();
        contenedor.setLayout(new GridLayout(0,1));
        panel1 = new JPanel(new FlowLayout());
        JLabel etiqueta1 = new JLabel("<html><body><center><h2 color='#164C8A'>Consulta 1</h2></body></html>");
        JLabel etiqueta2 = new JLabel("<html><body><center><p color='#0B2747'>Conocer el nombre, apellidos y salarios de los lideres <br>cuyo segundoapellido sea ‘Ortiz’.<br><br></p></body></html>");
        Manejador1 manejador1 = new Manejador1();
        boton1 = new JButton("Consultar");
        boton1.addActionListener(manejador1);
        boton1.setForeground(Color.BLUE);
        boton1.setSize(200, 80);
        boton1.setFont(fuente);
        panel1.add(etiqueta1);
        panel1.add(etiqueta2);
        panel1.add(boton1);
        panel2 = new JPanel(new FlowLayout());
        JLabel etiqueta10 = new JLabel("<html><body><center><h2 color='#164C8A'>Consulta 2</h2></body></html>");
        JLabel etiqueta20 = new JLabel("<html><body><center><p color='#0B2747'>Transformar y obtener el nombre de los lideres donde la<br>primera letra sea en minúscula y las demás en mayúscula.<br><br></p></body></html>");
        Manejador2 manejador2 = new Manejador2();
        boton2 = new JButton("Consultar");
        boton2.addActionListener(manejador2);
        boton2.setForeground(Color.BLUE);
        boton2.setSize(200, 80);
        boton2.setFont(fuente);
        panel2.add(etiqueta10);
        panel2.add(etiqueta20);
        panel2.add(boton2);
        panel3 = new JPanel(new FlowLayout());
        JLabel etiqueta100 = new JLabel("<html><body><center><h2 color='#164C8A'>Consulta 3</h2></body></html>");
        JLabel etiqueta200 = new JLabel("<html><body><center><p color='#0B2747'>Agrupar los lideres por su cargo y retornar solo los<br>grupos cuyo promedio de salarios supere 500000.<br><br></p></body></html>");
        Manejador3 manejador3 = new Manejador3();
        boton3 = new JButton("Consultar");
        boton3.addActionListener(manejador3);
        boton3.setForeground(Color.BLUE);
        boton3.setSize(200, 80);
        boton3.setFont(fuente);
        panel3.add(etiqueta100);
        panel3.add(etiqueta200);
        panel3.add(boton3);
        contenedor.add(panel1);
        contenedor.add(panel2);
        contenedor.add(panel3);
        setSize(380,510);
        setVisible(true);
        setResizable(false);
    }
    public class Manejador1 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource()==boton1){
                Consulta1GUI consulta1 = new Consulta1GUI();
                consulta1.Consultar();
                }
            } 
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }   
    }
    private class Manejador2 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource()==boton2){
                    Consulta2GUI consulta2 = new Consulta2GUI();
                    consulta2.Consultar();
                }
            } 
            catch (SQLException e1) {
                e1.printStackTrace();
            }  
        } 
    }
    private class Manejador3 implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource()==boton3){
                    Consulta3GUI consulta3 = new Consulta3GUI();
                    consulta3.Consultar();
                }
            } 
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }
}