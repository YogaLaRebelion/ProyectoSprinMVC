/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
public class Rol {

    private int id;
    private String nombre_rol;
  
    public Rol() {
    }

    public Rol(int id, String nombre_rol) {
        this.id = id;
        this.nombre_rol = nombre_rol;
    }

      @Override
    public String toString() {
        return nombre_rol;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

}
