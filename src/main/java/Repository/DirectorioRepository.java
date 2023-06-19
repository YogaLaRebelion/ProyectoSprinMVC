/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import Model.Actividades;
import java.sql.SQLException;
import Conexion.Conexion;
import Config.CrearLog;
import Model.Asistentes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*Repositorio con metodos para crud de asistentes y actividades
 */
public class DirectorioRepository {

//se establece la coneccion
    private Connection con;

    //metodo para agregar actividades a la base de datos:
    public void agregarActividades(Actividades actividades) {
        //declaramos sentencia para insertar en BD
        String sql = "INSERT INTO actividades (nombre_act, lugar, fecha, hora, cantidad_asistentes) VALUES (?, ?, ?, ?, ?)";

        System.out.println("agregarActividades query" + sql);

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            //se crea un objeto PreparedStatement utilizando la conexión establecida con la base de datos.
            PreparedStatement stmt = con.prepareStatement(sql);
            // Establecer los valores de los parámetros en la sentencia SQL

            stmt.setString(1, actividades.getNombre_act());
            stmt.setString(2, actividades.getLugar());
            stmt.setString(3, actividades.getFecha());
            stmt.setString(4, actividades.getHora());
            stmt.setInt(5, actividades.getCantidad_asistentes());
            // Ejecutar la sentencia SQL de insertar datos

            int filasInsertadas = stmt.executeUpdate();
            // verificar si se insertó al menos una fila
            if (filasInsertadas > 0) {
                System.out.println("Actividad agregada exitosamente a la base de datos.");
            }

            /* Cerrar el PreparedStatement y la conexión para garantizar la liberación de 
            recursos y ayudar a mantener la estabilidad y el rendimiento del sistema.*/
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al agregar la actividad: " + e.getMessage());
            CrearLog.errorLog("Error select Log - getAgregarActividades: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }
    }

    public List<Actividades> listarActividades() {
        //crea lista par almacenar actividades
        List<Actividades> listaActividades = new ArrayList<Actividades>();
        //se define la consulta sql para obtener las actividades y las ordenamos por nombre ascendente
        String sql = "SELECT * FROM actividades ORDER BY nombre_act ASC";
        try {
            // Establecer la conexión a la base de datos
            Conexion db = new Conexion();
            con = db.conexion();
            // Preparar la sentencia SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            // Ejecutar la consulta y obtener los resultados
            ResultSet rs = stmt.executeQuery();
            //recorrer los resultados
            while (rs.next()) {
                // Crear un objeto Actividades para almacenar los datos de cada actividad

                Actividades actividades = new Actividades();
                // Obtener los valores de las columnas y establecerlos en el objeto Actividades
                actividades.setId(rs.getInt("id"));
                actividades.setNombre_act(rs.getString("nombre_act"));
                actividades.setFecha(rs.getString("fecha"));
                actividades.setHora(rs.getString("hora"));
                actividades.setLugar(rs.getString("lugar"));
                actividades.setCantidad_asistentes(rs.getInt("cantidad_asistentes"));
                //se agrega a la lista
                listaActividades.add(actividades);

                // Actividades actividades = new Actividades(id, nombre_act, lugar, fecha, hora, cantidad_asistentes);
            }

            // Cerrar los recursos utilizados (ResultSet, PreparedStatement, conexión)
            rs.close();
            stmt.close();
            con.close();
//errores de sql
        } catch (SQLException e) {
            System.out.println("Error al obtener los asistentes: " + e.getMessage());
            CrearLog.errorLog("Error select Log - getListarActividades: " + e.getMessage());

        } catch (ClassNotFoundException ex) {
            // Manejar cualquier error de clase no encontrada (driver de la base de datos)
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }
        //devuelve la lista de actividades obtenida
        return listaActividades;
    }

//;metodo para eliminar actividades usando el Id. Funciona de la misma forma con conexion y pstm
    public void eliminarActividades(int id) {
        String sql = "DELETE FROM actividades WHERE id = ?";

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            // Ejecutar la consulta y obtener el número de filas afectadas
            int filasAfectadas = stmt.executeUpdate();
            // Verificar si se eliminó alguna fila

            if (filasAfectadas > 0) {
                System.out.println("La actividad con id: " + id + " se eliminó correctamente.");
            } else {
                System.out.println("No se encontró ninguna actividad con id: " + id + ".");
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar la actividad: " + e.getMessage());
            CrearLog.errorLog("Error select Log - getEliminarActividades: " + e.getMessage());

        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }
    }

    public void actualizarActividades(Actividades actividades) {
        // Consulta SQL para actualizar una actividad por su ID

        String sql = "UPDATE actividades SET nombre_act = ?, lugar = ?, fecha = ?, hora = ?, cantidad_asistentes = ? WHERE id= ?";

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            // Establecer los valores de los parámetros en la sentencia SQL
            stmt.setString(1, actividades.getNombre_act());
            stmt.setString(2, actividades.getLugar());
            stmt.setString(3, actividades.getFecha());
            stmt.setString(4, actividades.getHora());
            stmt.setInt(5, actividades.getCantidad_asistentes());
            stmt.setInt(6, actividades.getId());

            // Ejecutar la consulta y obtener el número de filas actualizadas
            int filasActualizadas = stmt.executeUpdate();
            // Verificar si se actualizó alguna fila
            if (filasActualizadas > 0) {
                System.out.println("La actividad: " + actividades.getNombre_act() + " se actualizó correctamente.");
            } else {
                System.out.println("No se encontró ninguna actividad con el ID especificado.");
            }
            // Cerrar el PreparedStatement y la conexión
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al modificar la actividad: " + e.getMessage());
            CrearLog.errorLog("Error select Log - getActualizarActividades: " + e.getMessage());

        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }
    }

    public Actividades obtenerActividades(int id) {
        // Crear un objeto nulo de Actividades para almacenar los datos de la actividad obtenida.

        Actividades actividades = null;
        // Definir la consulta SQL para obtener una actividad por su ID

        String sql = "SELECT id, nombre_act, lugar, fecha, hora, cantidad_asistentes FROM actividades WHERE id = ?";

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            // Verificar si se encontró una actividad con el ID especificado

            if (rs.next()) {
                // Crear un objeto Actividades y establecer los valores de las columnas
                actividades = new Actividades();
                //recibo los valores encontrados
                String nombre_act = rs.getString("nombre_act");
                String lugar = rs.getString("lugar");
                String fecha = rs.getString("fecha");
                String hora = rs.getString("hora");
                int cantidad_asistentes = rs.getInt("cantidad_asistentes");
//aca los almaceno en un objteo actividades
                actividades = new Actividades(id, nombre_act, lugar, fecha, hora, cantidad_asistentes);
            }
            // Cerrar los recursos utilizados (ResultSet, PreparedStatement, conexión)
            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al obtener la actividad: " + e.getMessage());
            CrearLog.errorLog("Error select Log - getObtenerActividades: " + e.getMessage());

        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }
        // Devolver la actividad obtenida (puede ser null si no se encontró ninguna actividad)
        return actividades;
    }

    //METODO RELACIONADOS A TABLA ASISTENTES
    //funciona del mismo modo que arriba en actividades
    public void agregarAsistente(Asistentes asistente) {
        String sql = "INSERT INTO asistentes (nombre, apellido_paterno, apellido_materno, fechaNac, region, correo) VALUES (?, ?, ?, ?, ?, ?)";
        System.out.println("agregarAsistente query: " + sql);

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, asistente.getNombre());
            stmt.setString(2, asistente.getApellido_paterno());
            stmt.setString(3, asistente.getApellido_materno());
            stmt.setString(4, asistente.getFechaNac());
            stmt.setString(5, asistente.getRegion());
            stmt.setString(6, asistente.getCorreo());

            int filasInsertadas = stmt.executeUpdate();

            // verificar si se insertó al menos una fila
            if (filasInsertadas > 0) {
                System.out.println("Asistente agregado exitosamente a la base de datos.");
            }
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al agregar el asistente: " + e.getMessage());
                        CrearLog.errorLog("Error select Log - getAgregarAsistente: " + e.getMessage());

        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }
    }
//metodo para listar funciona de la misma forma que listaractividades

    public List<Asistentes> listarAsistentes() {
        List<Asistentes> listaAsistentes = new ArrayList<Asistentes>();
        String sql = "SELECT * FROM asistentes ORDER BY nombre ASC";

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Asistentes asistente = new Asistentes();
                asistente.setId(rs.getInt("id"));
                asistente.setNombre(rs.getString("nombre"));
                asistente.setApellido_paterno(rs.getString("apellido_paterno"));
                asistente.setApellido_materno(rs.getString("apellido_materno"));
                asistente.setFechaNac(rs.getString("fechaNac"));
                asistente.setRegion(rs.getString("region"));
                asistente.setCorreo(rs.getString("correo"));
                listaAsistentes.add(asistente);
            }

            System.out.println("Lista de Asistentes: " + listaAsistentes);

            rs.close();
            stmt.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Error al obtener los asistentes: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }

        return listaAsistentes;
    }
//para eliminar asistente con su id

    public void eliminarAsistente(int id) {
        String sql = "DELETE FROM asistentes WHERE id = ?";

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            int filasAfectadas = stmt.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("El asistente con ID " + id + " se eliminó correctamente.");
            } else {
                System.out.println("No se encontró ningún asistente con ID " + id + ".");
            }
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar el asistente: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }
    }
//para actualizar asistentes

    public void actualizarAsistente(Asistentes asistente) {
        String sql = "UPDATE asistentes SET nombre = ?, apellido_paterno = ?, apellido_materno = ?, fechaNac = ?, region = ?, correo = ? WHERE id = ?";

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, asistente.getNombre());
            stmt.setString(2, asistente.getApellido_paterno());
            stmt.setString(3, asistente.getApellido_materno());
            stmt.setString(4, asistente.getFechaNac());
            stmt.setString(5, asistente.getRegion());
            stmt.setString(6, asistente.getCorreo());
            stmt.setInt(7,asistente.getId());
            int filasActualizadas = stmt.executeUpdate();

            if (filasActualizadas > 0) {
                System.out.println("El asistente con ID " + asistente.getId() + " se actualizó correctamente.");
            } else {
                System.out.println("No se encontró ningún asistente con el ID especificado.");
            }

            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al modificar el asistente: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }
    }
    
//metodo para obtener asistentes con su id
    public Asistentes obtenerAsistente(int id) {
        String sql = "SELECT * FROM asistentes WHERE id = ?";
        Asistentes asistente = null;

        try {
            Conexion db = new Conexion();
            con = db.conexion();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido_paterno = rs.getString("apellido_paterno");
                String apellido_materno = rs.getString("apellido_materno");
                String fechaNac = rs.getString("fechaNac");
                String region = rs.getString("region");
                String correo = rs.getString("correo");

                asistente = new Asistentes(id, nombre, apellido_paterno, apellido_materno, fechaNac, region, correo);
            }
            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener el asistente: " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al obtener la conexión: " + ex.getMessage());
        }

        return asistente;
    }

}
