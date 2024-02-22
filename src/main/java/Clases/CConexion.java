package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class CConexion {

    Connection conectar = null;
    String usuario = "root";
    String contrasenia = "and231999";
    String bd = "bdusuarios";
    String ip = "localhost";
    String puerto = "3306";

    String cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd;

    public Connection estableceConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena, usuario, contrasenia);
           // JOptionPane.showMessageDialog(null, "Se conectó a la BD correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar a la BD: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return conectar;
    }

    // Método para cerrar la conexión
    public void cerrarConexion() {
        try {
            if (conectar != null && !conectar.isClosed()) {
                conectar.close();
               // JOptionPane.showMessageDialog(null, "Se cerró la conexión correctamente");
            }
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
}
