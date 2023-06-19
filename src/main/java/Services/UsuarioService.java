/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Model.Rol;
import Model.Usuario;
import Repository.UsuarioRepository;
import java.util.List;

/*es una capa de abstraccion adicional entre el controlado y el repositorio
tiene logica tb. en este caso se usa el repositorio para la validacion
del usuario y devolver ese resultado al controlador.
*/
public class UsuarioService {
    
   private final UsuarioRepository usuarioRepository;
    
    public UsuarioService() {
        this.usuarioRepository = new UsuarioRepository();
    }
    
    public int validarCredenciales(Usuario usuario) {
        return usuarioRepository.validar(usuario);
    }
    
    public int validar(Usuario usuario) {
        return usuarioRepository.validar(usuario);
    }
  
    
        //aqui para poder usar rol en mi lista 

    public Rol obtenerRolPorId(int rol_id) {
        return usuarioRepository.obtenerRolPorId(rol_id);
    }

    public List<Usuario> listarUsuario() {
        return usuarioRepository.listarUsuario();
    }
    
      public List<Usuario> listarUsuariosPorRol() {
        return usuarioRepository.listarUsuariosPorRol();
    }
      
         public void eliminarUsuario(int id) {
        usuarioRepository.eliminarUsuario(id);
    }
         

}