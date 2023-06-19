/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Usuario {

    private int id;
    private String nombre;
    private String apellido_paterno;
    private String password;
    private Rol rol_id;
    private String nombre_rol;
    private int cantidad; 

    // Constructor vacío
    public Usuario() {
    }

    public Usuario(String nombre_rol, int cantidad) {
        this.nombre_rol = nombre_rol;
        this.cantidad = cantidad;
    }

    
    // Constructor con todos los atributos
    public Usuario(int id, String nombre, String apellido_paterno, String password, Rol rol_id, int cantidad, String nombre_rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.password = password;
        this.rol_id = rol_id;
        this.cantidad = cantidad;

    }

    // Getters y setters de los atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol_id() {
        return rol_id;
    }

    public void setRol_id(Rol rol_id) {
        this.rol_id = rol_id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

}
