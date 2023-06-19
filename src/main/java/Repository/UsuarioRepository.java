/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Conexion.Conexion;
import Config.CrearLog;
import Model.Rol;
import Model.Usuario;
import Model.Validar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*Esta capa se encarga de manejar la interacción con la base de datos y
proporcionar métodos para realizar operaciones relacionadas con los usuarios.*/
public class UsuarioRepository implements Validar {

    private Connection con;

    /* Este método implementa la interfaz Validar y se utiliza para validar las credenciales
    de un usuario en la base de datos. Realiza una consulta SQL para obtener el rol del usuario
    en función del ID y la contraseña proporcionados. Dependiendo del rol obtenido, se asigna
    un valor específico a la variable resultado y se devuelve. Los valores de retorno posibles 
    son -1 (credenciales no válidas), 1 (administrador), 2 (usuario de directorio) o 3 (alumno).
     */
    @Override
    public int validar(Usuario usuario) {
        int resultado = -1;

        String sql = "SELECT nombre_rol FROM rol WHERE id IN (SELECT rol_id FROM usuario WHERE id = ? AND password = ?)";

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, usuario.getId());
            ps.setString(2, usuario.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String rol = rs.getString("nombre_rol");
                // Aquí puedes hacer algo con el rol, como asignar permisos o redireccionar a páginas específicas
                if (rol.equals("administrativo")) {
                    // El usuario es un administrador
                    resultado = 1;
                } else if (rol.equals("directorio")) {
                    // El usuario es un usuario normal
                    resultado = 2;
                } else if (rol.equals("alumno")) {
                    // El usuario es un usuario normal
                    resultado = 3;
                }
            }
            ps.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al validar las credenciales del usuario: " + e.getMessage());
                        CrearLog.errorLog("Error select Log - getValidar: " + e.getMessage());

        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }

        return resultado;
    }

    /*Este método devuelve una lista de objetos Usuario que representan a todos los usuarios almacenados 
    en la base de datos. Realiza una consulta SQL para obtener los datos de usuario y su correspondiente 
    rol a través de una unión de tablas (INNER JOIN). Crea instancias de la clase Usuario y asigna los 
    valores obtenidos de la consulta a los atributos correspondientes. Luego, agrega cada objeto Usuario a
    la lista y finalmente la devuelve.
     */
    public List<Usuario> listarUsuario() {
        List<Usuario> listaUsuario = new ArrayList<Usuario>();

        String sql = "SELECT usuario.*, rol.nombre_rol "
                + "FROM usuario "
                + "INNER JOIN rol ON usuario.rol_id = rol.id "
                + "GROUP BY rol.nombre_rol";

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido_paterno(rs.getString("apellido_paterno"));
                usuario.setPassword(rs.getString("password"));

                int rol_id = rs.getInt("rol_id");
                Rol rol = obtenerRolPorId(rol_id);
                usuario.setRol_id(rol);

                //se agrega a la lista
                listaUsuario.add(usuario);

                //Actividades actividades = new Actividades(id, nombre_act, lugar, fecha, hora, cantidad_asistentes);
            }

            System.out.println("Lista Usuarios: " + listaUsuario);

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.out.println("Error al obtener los usuarios: " + e.getMessage());
            CrearLog.errorLog("Error select Log - getListarUsuario: " + e.getMessage());

        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }

        return listaUsuario;
    }

    public List<Usuario> listarUsuariosPorRol() {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        // Consulta SQL para obtener la cantidad de usuarios por rol
        String sql = "SELECT rol.nombre_rol as nombre_rol, COUNT(*) as cantidad"
                + " FROM usuario"
                + " JOIN rol ON usuario.rol_id = rol.id"
                + " GROUP BY rol.nombre_rol";
        System.out.println("lista suuarios" + sql);
        try {
            // Establecer conexión con la base de datos
            Conexion db = new Conexion();
            con = db.conexion();
            // Preparar la sentencia SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            // Ejecutar la consulta
            ResultSet rs = stmt.executeQuery();
            // Recorrer el conjunto de resultados
            while (rs.next()) {
                Usuario usuariosPorRol = new Usuario();
                // Asignar los valores obtenidos a las propiedades del objeto Usuario
                usuariosPorRol.setNombre_rol(rs.getString("nombre_rol"));
                usuariosPorRol.setCantidad(rs.getInt("cantidad"));
                // Agregar el objeto Usuario a la lista
                listaUsuarios.add(usuariosPorRol);
            }
            // Cerrar el ResultSet, el PreparedStatement y la conexión
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            // Manejo de errores de SQL
            System.out.println("Error al obtener los usuarios por rol: " + e.getMessage());
            CrearLog.errorLog("Error select Log - listarUsuariosPorRol: " + e.getMessage());
            // Manejo de errores de ClassNotFoundException
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }
        // Imprimir la lista de usuarios por rol.
        System.out.println("Lista Usuarios: " + listaUsuarios);
        // Retornar la lista de usuarios por rol

        return listaUsuarios;
    }

    /*Este método recibe un ID de rol como parámetro y devuelve un objeto Rol correspondiente a ese ID.
    Realiza una consulta SQL para obtener los datos del rol mediante el ID proporcionado.
    Crea una instancia de la clase Rol y asigna los valores obtenidos de la consulta a sus atributos 
    correspondientes. Finalmente, devuelve el objeto Rol.
     */
    public Rol obtenerRolPorId(int rol_id) {
        Rol rol = null;
        String sql = "SELECT * FROM rol WHERE id = ?";

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, rol_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                rol = new Rol();
                rol.setId(rs.getInt("id"));
                rol.setNombre_rol(rs.getString("nombre_rol"));
                // Configurar otros atributos de Rol si es necesario
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el rol: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }

        return rol;
    }

    public void eliminarUsuario(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?";

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            // Ejecutar la consulta y obtener el número de filas afectadas
            int filasAfectadas = stmt.executeUpdate();
            // Verificar si se eliminó alguna fila

            if (filasAfectadas > 0) {
                System.out.println("El usuario con id: " + id + " se eliminó correctamente.");
            } else {
                System.out.println("No se encontró ningun usuario con id: " + id + ".");
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el usuario: " + e.getMessage());
            CrearLog.errorLog("Error select Log - getEliminarUsuario: " + e.getMessage());

        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }
    }

}
