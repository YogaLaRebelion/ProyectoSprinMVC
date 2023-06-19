package Conexion;

import java.sql.*;

/*Esta clase se encarga de establecer la conexión a la base de datos, proporciona métodos para obtener
la conexión, cerrarla y obtener una instancia de sentencia para ejecutar consultas SQL.
*/
public class Conexion {
    private static Conexion instancia = null;
    private static String url = "jdbc:mysql://localhost:3306/kriya_bd"; // URL de la base de datos
    private static String user = "root"; // Usuario de la base de datos
    private static String pass = ""; // Contraseña de la base de datos
    private static Connection con = null;
    private Statement stmt = null;

    public Conexion() throws SQLException, ClassNotFoundException {
        System.out.println("Conectando...");
        Class.forName("com.mysql.cj.jdbc.Driver"); // Carga el controlador JDBC de MySQL
        con = DriverManager.getConnection(url, user, pass); // Establece la conexión con la base de datos
        stmt = con.createStatement();
        System.out.println(con);
        System.out.println("Conectado");
    }

    public static Conexion obtenerInstancia() throws SQLException, ClassNotFoundException {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
    
	public Connection getConexion()
	//Permite retornar la conexion
	{
		return con;
	}
        
 	public int CerrarConexion()
	{
		try
		{
			con.close(); 
			return 0;
		}
		catch(Exception exc)
		{
			System.out.println("Error al cerrar la conexion: "+" : "+exc);
			return -1;
		}
	}

	public void close(){
	      try
	      {
	          if (con != null)
	          {
	              stmt.close();
	              con.close();
	              con = null;
	          }
	      }
	      catch (SQLException sqe)
	      {
	          System.out.println("Unexpected exception : " +
	              sqe.toString() + ", sqlstate = " + sqe.getSQLState());
	          sqe.printStackTrace();
	      }
	  }    
        public Connection conexion(){
		return con;
	}
        
	public Statement sentencia(){
		return stmt;
	}        

}
