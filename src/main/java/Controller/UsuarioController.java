/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Usuario;
import Services.UsuarioService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*recibe las solicitudes del cliente, interactua con los datos
enviados del jsp y coordina una respuesta. usa al servicio para las
opraciones y prepara los datos para mandarlos de vuelta al cliente.
Aca se reciben los parametros del form de inicio de sesion y se llama
al servicio para validar las credenciales y decidir a donde redireccionar
segun el resultado dado
 */
@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    
    /*
     Mapeo de la ruta "/vistaAdministrador" para mostrar la vista del
     * administrador. Obtiene la lista de usuarios y la lista de usuarios por
     * rol desde el servicio y las agrega como atributos al modelo. Retorna la
     * cadena "vistaAdministrador".
     */
    @GetMapping("/vistaAdministrador")
    public String mostrarAdministrador(Model model) {
        System.out.println("ENTRA A mostrarAdministrador");
        List<Usuario> usuario = usuarioService.listarUsuario();
        model.addAttribute("usuario", usuario);
        List<Usuario> usuariosPorRol = usuarioService.listarUsuariosPorRol();
        model.addAttribute("usuariosPorRol", usuariosPorRol);

        return "vistaAdministrador";
    }
    
/* Mapeo de la ruta "/index" para mostrar la página de inicio de sesión
    */
    @GetMapping("/index")
    public String getLogin() {
        return "index";
    }
    
/*
     * Este método está mapeado a la ruta "/index" con el método POST de HTTP.
     * Recibe los parámetros del formulario de inicio de sesión: "txtId" (ID de
     * usuario) y "password" (contraseña). Se crea un objeto Usuario con los
     * valores recibidos. Se llama al método validar del usuarioService pasando
     * el objeto Usuario para validar las credenciales.
     * 
     * Dependiendo del resultado de la validación, se agregan los atributos
     * correspondientes al modelo y se redirige a diferentes vistas. Si el
     * resultado es 1, se trata de un administrador y se redirige a
     * "/vistaAdministrador". Si el resultado es 2, se trata de un directorio y
     * se redirige a "/vistaDirectorio". Si el resultado es 3, se trata de un
     * alumno y se redirige a "/vistaAlumno". Si el resultado no es válido, se
     * agrega un mensaje de error como atributo al modelo y se retorna a la
     * vista "index".
     */
    
    @PostMapping("/index")
    public String login(@RequestParam("txtId") String idString, @RequestParam("password") String password, Model model) {
        int id = Integer.parseInt(idString);

        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setPassword(password);

        int resultado = usuarioService.validar(usuario);

        switch (resultado) {
            case 1: // El usuario es un administrador
                model.addAttribute("nombre_rol", "administrativo");
                model.addAttribute("id", id);
                return "redirect:/vistaAdministrador";
            case 2: // El usuario es un directorio
                model.addAttribute("nombre_rol", "directorio");
                model.addAttribute("id", id);
                return "redirect:/vistaDirectorio";
            case 3: // El usuario es un alumno
                model.addAttribute("nombre_rol", "alumno");
                model.addAttribute("id", id);
                return "redirect:/vistaAlumno";
            default: // El usuario no es válido
                model.addAttribute("error", "Datos inválidos");
                return "index";
        }
    }
    
    
     
    /*
     Este método está mapeado a la ruta "/usuario/{id}/eliminar" con el método POST de HTTP.
     Recibe el ID del usuario a eliminar como una variable de ruta.
     Se llama al método eliminarUsuario del usuarioService pasando el ID del usuario a eliminar.
     Luego, se redirige a la vista "/vistaAdministrador".
     */
      @PostMapping("/usuario/{id}/eliminar")
    public String eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
        return "redirect:/vistaAdministrador";
    }

}
