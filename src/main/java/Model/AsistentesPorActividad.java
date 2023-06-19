/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class AsistentesPorActividad {

    private int actividad_id;
    private int cantidad_asistentes;

    public AsistentesPorActividad() {
    }

    public AsistentesPorActividad(int actividad_id, int cantidad_asistentes) {
        this.actividad_id = actividad_id;
        this.cantidad_asistentes = cantidad_asistentes;
    }

    public int getActividad_id() {
        return actividad_id;
    }

    public void setActividad_id(int actividad_id) {
        this.actividad_id = actividad_id;
    }

    public int getCantidad_asistentes() {
        return cantidad_asistentes;
    }

    public void setCantidad_asistentes(int cantidad_asistentes) {
        this.cantidad_asistentes = cantidad_asistentes;
    }
    
    
    
}
