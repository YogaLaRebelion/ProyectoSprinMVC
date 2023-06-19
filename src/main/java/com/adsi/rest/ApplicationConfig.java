package com.adsi.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        // Conjunto de recursos REST disponibles en la aplicación
        Set<Class<?>> resources = new java.util.HashSet();
        // Agregar las clases de recursos REST a la lista de recursos
        addRestResourceClasses(resources);
        // Retornar el conjunto de recursos
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        // Agregar la clase Rest como recurso REST disponible en la aplicación
        resources.add(com.adsi.rest.Rest.class);
    }
}
