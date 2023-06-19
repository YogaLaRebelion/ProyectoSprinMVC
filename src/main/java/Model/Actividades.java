/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Actividades{

    private int id;
    private String nombre_act;
    private String lugar;
    private String fecha;
    private String hora;
    private int cantidad_asistentes;

    // Constructor vacío
    public Actividades() {
    }

    // Constructor con todos los atributos
    public Actividades(int id, String nombre_act, String lugar, String fecha, String hora, int cantidad_asistentes) {
        this.id = id;
        this.nombre_act = nombre_act;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.cantidad_asistentes = cantidad_asistentes;
    }

    // Getters y setters de los atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_act() {
        return nombre_act;
    }

    public void setNombre_act(String nombre_act) {
        this.nombre_act = nombre_act;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }



    public int getCantidad_asistentes() {
        return cantidad_asistentes;
    }

    public void setCantidad_asistentes(int cantidad_asistentes) {
        this.cantidad_asistentes = cantidad_asistentes;
    }
}
