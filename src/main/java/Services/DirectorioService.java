package Services;

import Model.Actividades;
import Model.Asistentes;
import java.util.List;
import Repository.DirectorioRepository;
import org.springframework.stereotype.Service;

/*La capa de servicio interactúa con el repositorio DirectorioRepository para realizar 
las operaciones CRUD en la base de datos. Cada método en la capa de servicio invoca los 
métodos correspondientes del repositorio para realizar las operaciones requeridas.
*/
@Service
public class DirectorioService {
    
    private final DirectorioRepository directorioRepository;

    public DirectorioService(){
        this.directorioRepository  = new DirectorioRepository();
    }
    
        // Método para agregar una nueva actividad

   public void agregarActividades(Actividades actividades) {
        directorioRepository.agregarActividades(actividades);       
    }
        // Método para listar todas las actividades

    public List<Actividades> listarActividades() {       
        return directorioRepository.listarActividades();
    }
        // Método para eliminar una actividad por su ID

    public void eliminarActividades(int id) {
        directorioRepository.eliminarActividades(id);
    }
        // Método para actualizar una actividad existente

    public void actualizarActividades(Actividades actividades) {
        directorioRepository.actualizarActividades(actividades);
    }
    // Método para obtener una actividad por su ID

    public Actividades obtenerActividades(int id) {
        return directorioRepository.obtenerActividades(id);
}
    
  //DE ASISTENTES FUNCIONA IGUAL

    public void agregarAsistente(Asistentes asistente) {
        directorioRepository.agregarAsistente(asistente);
    }

    public List<Asistentes> listarAsistentes() {
        return directorioRepository.listarAsistentes();
    }

    public void eliminarAsistente(int id) {
        directorioRepository.eliminarAsistente(id);
    }

    public void actualizarAsistente(Asistentes asistente) {
        directorioRepository.actualizarAsistente(asistente);
    }

    public Asistentes obtenerAsistente(int id) {
        return directorioRepository.obtenerAsistente(id);
    }
}