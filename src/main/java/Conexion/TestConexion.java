package Conexion;

import java.sql.Connection;
import java.sql.SQLException;

/*En este código, se prueba la conexión a la base de datos. Se instancia la clase Conexion
y se obtiene la conexión llamando al método getConexion(). Luego, se verifica si la conexión
es exitosa y se muestra un mensaje correspondiente. Si la conexión es exitosa, se cierra la
conexión mediante el método CerrarConexion(). En caso de errores, se capturan las excepciones 
de SQL y ClassNotFoundException y se muestra un mensaje de error correspondiente.
*/
public class TestConexion {
    public static void main(String[] args) {
        try {
            Conexion db = Conexion.obtenerInstancia();
            Connection con = db.getConexion();

            if (con != null) {
                System.out.println("Conexión exitosa a la base de datos.");
                db.CerrarConexion(); // Cierra la conexión después de usarla
            } else {
                System.out.println("No se pudo establecer la conexión.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver: " + e.getMessage());
        }
    }
}