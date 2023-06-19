/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Actividades;
import Model.Asistentes;
import Services.DirectorioService;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*Controlador se encarga de recibir las solicitudes (requests) del cliente, procesar la
lógica necesaria y devolver las respuestas (responses) correspondientes. En resumen,
su función principal es actuar como intermediario entre el cliente y el resto de componentes
de la aplicación, como el modelo y los servicios.
 */
@Controller
public class DirectorioController {
//instancias del servicio y constructor.

    private final DirectorioService directorioService;

    public DirectorioController() {
        this.directorioService = new DirectorioService();
    }

    /*mapear la ruta de la vistadirectorio y que se vea en esa vista las listas del crud.
    toma un objeto modelo como parametro para agregar los atributos que se pasaran
a la vista. Obtiene la lista de Actividades y Asistentes del directorioService y los agrega como atributos al modelo.
    Retorna la cadena "vistaDirectorio", que es el nombre de la plantilla de vista que se renderizará.*/
    @GetMapping("/vistaDirectorio")
    public String mostrarDirectorio(Model model) {
        List<Actividades> actividades = directorioService.listarActividades();
        List<Asistentes> asistentes = directorioService.listarAsistentes();
        model.addAttribute("actividades", actividades);
        model.addAttribute("asistentes", asistentes);
        return "vistaDirectorio";
    }

    /*mapeo de ruta agregar actividad para recibir los datos enviados desde el jsp.
toma un objeto modelo como parametro para agregar los atributos que se pasaran
a la vista .Crea una nueva instancia de Actividades y la agrega como atributo al modelo.
Retorna la cadena "agregar_actividad", que es el nombre de la plantilla de vista que se renderizará.
     */
    @GetMapping("/agregar_actividad")
    public String mostrarFormularioActividades(Model model) {
        Actividades actividades = new Actividades();
        model.addAttribute("actividades", actividades);
        return "agregar_actividad";
    }

    /*Este método está mapeado a la ruta de URL "/agregar_actividad" con el método POST de HTTP.
Toma un objeto Actividades como parámetro, el cual se llena con los datos del formulario de la solicitud.
Llama al método agregarActividades de directorioService y le pasa el objeto Actividades para su procesamiento adicional.
Retorna la cadena "redirect:/vistaDirectorio", lo cual redirige al usuario a la URL "/vistaDirectorio" después de la operación POST.
     */
    @PostMapping("/agregar_actividad")
    public String agregarActividad(@ModelAttribute("actividades") Actividades actividades) {
        directorioService.agregarActividades(actividades);
        return "redirect:/vistaDirectorio";
    }

    /*Este método está mapeado a la ruta de URL "/actividades/{id}/eliminar" con el método POST de HTTP.
Toma el parámetro de ruta id como un parámetro, que representa el ID de la actividad a eliminar.
Llama al método eliminarActividades de directorioService y le pasa el id para eliminar la actividad correspondiente.
Retorna la cadena "redirect:/vistaDirectorio", lo cual redirige al usuario a la URL "/vistaDirectorio" después de la operación POST.
     */
    @PostMapping("/actividades/{id}/eliminar")
    public String eliminarActividades(@PathVariable int id) {
        directorioService.eliminarActividades(id);
        return "redirect:/vistaDirectorio";
    }

    /*Este método está mapeado a la ruta de URL "/editar_actividad".
Toma el parámetro de consulta id como un parámetro, que representa el ID de la actividad a editar.
Obtiene el objeto Actividades correspondiente al id desde directorioService.
Agrega el objeto Actividades como atributo al modelo.
Retorna la cadena "editar_actividad".
     */
    @GetMapping("/editar_actividad")
    public String mostrarFormularioEdicionActividades(@RequestParam("id") int id, Model model) {
        Actividades actividades = directorioService.obtenerActividades(id);
        model.addAttribute("actividades", actividades);
        return "editar_actividad";
    }

    /*Este método está mapeado a la ruta de URL "/editar_actividad" con el método POST de HTTP.
Toma un objeto Actividades como parámetro, el cual se llena con los datos del formulario de la solicitud.
Llama al método actualizarActividades de directorioService y le pasa el objeto Actividades actualizado para su procesamiento adicional.
Retorna la cadena "redirect:/vistaDirectorio", lo cual redirige al usuario a la URL "/vistaDirectorio" después de la operación POST.
     */
    @PostMapping("/editar_actividad")
    public String actualizarActividades(@ModelAttribute("actividades") Actividades actividades) {
        directorioService.actualizarActividades(actividades);
        return "redirect:/vistaDirectorio";
    }

    /*Este método está mapeado a la ruta de URL "/buscar_actividad".
Retorna la cadena "buscar_actividad".
     */
    @GetMapping("/buscar_actividad")
    public String mostrarFormularioBusquedaActividad() {
        return "buscar_actividad";
    }

    /*Este método está mapeado a la ruta de URL "/buscar_actividad" con el método POST de HTTP.
Toma el parámetro de consulta id como un parámetro, que representa el ID de la actividad a buscar.
Llama al método obtenerActividades de directorioService y le pasa el id para obtener la actividad correspondiente.
Si se encuentra la actividad, la agrega como atributo al modelo y retorna la cadena "buscar_actividad".
Si no se encuentra la actividad, agrega un mensaje de error como atributo al modelo y retorna la cadena "buscar_actividad".
     */
    @PostMapping("/buscar_actividad")
    public String buscarActividades(@RequestParam("id") int id, Model model
    ) {
        Actividades actividades = directorioService.obtenerActividades(id);
        if (actividades != null) {
            model.addAttribute("actividades", actividades);
            return "buscar_actividad";
        } else {
            model.addAttribute("mensaje", "No se encontró ninguna actividad con ese ID.");
            return "buscar_actividad";
        }
    }

//METODOS DE ASISTENTES FUNCIONAN DE LA MISMA MANERA QUE ACTIVIDADES
    @GetMapping("/agregar_asistente")
    public String mostrarFormularioAsistentes(Model model
    ) {
        Asistentes asistente = new Asistentes();
        model.addAttribute("asistente", asistente);
        return "agregar_asistente";
    }

    @PostMapping("/agregar_asistente")
    public String agregarAsistente(@ModelAttribute("asistente") Asistentes asistente
    ) {
        directorioService.agregarAsistente(asistente);
        return "redirect:/vistaDirectorio";

    }

    @PostMapping("/asistentes/{id}/eliminar")
    public String eliminarAsistente(@PathVariable int id
    ) {
        directorioService.eliminarAsistente(id);
        return "redirect:/vistaDirectorio";
    }

    @GetMapping("/editar_asistente")
    public String mostrarFormularioEdicionAsistentes(@RequestParam("id") int id, Model model
    ) {
        Asistentes asistente = directorioService.obtenerAsistente(id);
        model.addAttribute("asistente", asistente);
        return "editar_asistente";
    }

    @PostMapping("/editar_asistente")
    public String actualizarAsistente(@ModelAttribute("asistente") Asistentes asistente
    ) {
        directorioService.actualizarAsistente(asistente);
        return "redirect:/asistentes/vistaDirectorio";
    }

    @GetMapping("/buscar_asistente")
    public String mostrarBusquedaAsistente() {
        return "buscar_asistente";
    }

    @PostMapping("/buscar_asistente")
    public String obtenerAsistente(@RequestParam("id") int id, Model model
    ) {
        Asistentes asistente = directorioService.obtenerAsistente(id);
        if (asistente != null) {
            model.addAttribute("asistente", asistente);
            return "buscar_asistente";
        } else {
            model.addAttribute("mensaje", "No se encontró ningún asistente con ese ID.");
            return "buscar_asistente";
        }
    }

}
