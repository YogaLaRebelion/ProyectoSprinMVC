/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CrearLog {

    public static void errorLog(String errorMensaje) {
        doRutaMkdir(); //llama al metodo que verifica ruta donde se creará log, sino existe crear la ruta con los directorios respectivos
        crearArchivoLog(errorMensaje); // metodo que crea el archivo de log
    }

    public static void crearArchivoLog(String errorMensaje) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat dateFormatHora = new SimpleDateFormat("HH:mm:ss");
        Date dateNow = new Date();
        String nombreArchivo = dateFormat.format(dateNow) + ".txt";// Se asigna el nombre del archivo basado en la fecha actual.
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("/opt/tomcat/bin/ProyectoSpringMVC/Log/"+ nombreArchivo, true));// Crea un BufferedWriter para escribir en el archivo de log
            out.write("ERROR: " + dateFormatHora.format(dateNow) + " " + errorMensaje);// Escribe el mensaje de error en el archivo de log
            out.write("\n");
        } catch (IOException e) {
            System.out.println("[Error][CrearLog][crearArchivoLog][IOException]: " + e.getMessage());// Imprime mensaje de error en caso de IOException
            CrearLog.errorLog("[CrearLog][crearArchivoLog][IOException]: " + e.getMessage()); // Registra el mensaje de error en el archivo de log
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    System.out.println("[Error][CrearLog][crearArchivoLog][IOException]: " + e.getMessage());// Imprime mensaje de error en caso de IOException
                    CrearLog.errorLog("[CrearLog][crearArchivoLog][IOException]: " + e.getMessage());  // Registra el mensaje de error en el archivo de log
                }
            }
        }
    }

    public static void doRutaMkdir() {
        if (!(new File("/opt/tomcat/bin/ProyectoSpringMVC/Log/").exists())) { // Verifica si la ruta del archivo de log no existe
            (new File("/opt/tomcat/bin/ProyectoSpringMVC/Log/")).mkdirs(); // Crea la ruta y los directorios respectivos
        }
    }

}
