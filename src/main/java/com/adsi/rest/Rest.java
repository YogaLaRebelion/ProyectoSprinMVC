package com.adsi.rest;

import Model.Asistentes;
import Repository.DirectorioRepository;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.google.gson.Gson;
import javax.ws.rs.PathParam;

@Path("/rest")
public class Rest {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/get/{id}") // Parámetro en la ruta
    public String get(@PathParam("id") int id) {
    System.out.println("entra a get");
    // Crear un objeto Java que deseas convertir a JSON
    DirectorioRepository directorioRepository = new DirectorioRepository();
    Asistentes asistente = (Asistentes) directorioRepository.obtenerAsistente(id);
    // Convertir el objeto Java a JSON utilizando Gson
    Gson gson = new Gson();
    String json = gson.toJson(asistente);

    // Devolver el JSON resultante
    return json;
        //http://localhost:8080/kriya_bd/api/rest/get/id (<-- asi se ejecuta, el rut que esta en la base de datos)
    }
}