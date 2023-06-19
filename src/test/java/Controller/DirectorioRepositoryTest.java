/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Controller;

import Model.Actividades;
import Model.Asistentes;
import Repository.DirectorioRepository;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class DirectorioRepositoryTest {

    public DirectorioRepositoryTest() {
    }

    // Prueba unitaria para listar actividades
    @Test
    public void testListarActividades() {
        DirectorioRepository repository = new DirectorioRepository();
        // Obtener la lista de asistentes del repositorio
        List<Actividades> actividades = repository.listarActividades();

        // Verificar si la lista obtenida contiene los asistentes esperados
        assertNotNull(actividades);

    }
    // Prueba unitaria para listar asistentes

    @Test
    public void testListarAsistentes() {
        DirectorioRepository repository = new DirectorioRepository();
        // Obtener la lista de asistentes del repositorio
        List<Asistentes> asistentes = repository.listarAsistentes();

        // Verificar si la lista obtenida contiene los asistentes esperados
        assertNotNull(asistentes);

    }
    // Prueba unitaria para obtener un asistente por su ID

    @Test
    public void testObtenerAsistente() throws java.text.ParseException {
        DirectorioRepository repository = new DirectorioRepository();

        // Obtener el asistente utilizando el método obtenerAsistente
        Asistentes asistenteObtenido = repository.obtenerAsistente(1);

        // Verificar si el asistente obtenido es el mismo que el asistente de prueba
        assertEquals(1, asistenteObtenido.getId());
    }

}
