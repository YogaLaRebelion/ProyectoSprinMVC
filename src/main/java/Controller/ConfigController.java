/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


//CONTROLADOR PARA MAPEAR RUTAS SIN METODOS

@Controller
public class ConfigController {
 
    // Método para mostrar la vista "fundacion_kriya" cuando se accede a la ruta "/fundacion_kriya"
    @GetMapping("/fundacion_kriya")
    public String mostrarFundacionKriya() {
        return "fundacion_kriya"; 
    }

    // Método para mostrar la vista "contacto" cuando se accede a la ruta "/contacto". En construccion.
    @GetMapping("/contacto")
    public String mostrarContacto() {
        return "contacto"; 
    }

    // Método para mostrar la vista "donaciones" cuando se accede a la ruta "/donaciones"
    @GetMapping("/donaciones")
    public String mostrarDonaciones() {
        return "donaciones"; 
    }
    
    // Método para mostrar la vista "vistaAlumno" cuando se accede a la ruta "/vistaAlumno". En construccion.
    @GetMapping("/vistaAlumno")
    public String mostrarAlumno() {
        return "vistaAlumno";
    }
    
    //Metodo para mostrar la vista al apretar el boton cerrarsesion.
    @PostMapping("/cerrarSesion")
    public String cerrarSesion(){
        return "/index";
    }
    
}