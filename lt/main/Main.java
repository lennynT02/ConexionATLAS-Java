

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Conexion a Base de Datos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Datos().panel);
        frame.pack();
        frame.setVisible(true);

        
    }
}