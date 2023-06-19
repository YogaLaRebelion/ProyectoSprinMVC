<%-- 
    Document   : agregar_asistente
    Created on : Jun 7, 2023, 12:45:01 PM
    Author     : Melody
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Agregar Asistente</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" 
              crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Sistema de Control</a>
                <button class="navbar-toggler" type="button"
                        data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                        aria-controls="navbarSupportedContent" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                         <li class="nav-item"><a class="nav-link active"	aria-current="page" href="index">Inicio</a></li>
                        <li class="nav-item"><a class="nav-link" href="agregar_actividad">Agregar Actividad</a></li>                                   
                        <li class="nav-item"><a class="nav-link" href="agregar_asistente">Agregar Asistente</a></li>
                        <li class="nav-item"><a class="nav-link" href="buscar_asistente">Buscar Asistente</a></li>
                        <li class="nav-item"><a class="nav-link" href="vistaDirectorio">Ver Actividades y Asistentes</a></li>

                    </ul>
                </div>
            </div>
        </nav>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-header text-center">
                            <h3>Agregar Asistente</h3>
                        </div>
                        <div class="card-body">
                            <form action="./agregar_asistente" method="post">
                                <input type="hidden" name="action" value="agregar">
                                <div class="mb-3">
                                    <label>Nombre</label>
                                    <input type="text" name="nombre" class="form-control">
                                </div>
                                <div class="mb-3">
                                    <label>Apellido Paterno</label>
                                    <input type="text" name="apellido_paterno" class="form-control">
                                </div>
                                <div class="mb-3">
                                    <label>Apellido Materno</label>
                                    <input type="text" name="apellido_materno" class="form-control">
                                </div>
                                <div class="mb-3">
                                    <label>Fecha Nacimiento</label>
                                    <input type="date" name="fechaNac" class="form-control">
                                </div>
                                <div class="mb-3">
                                    <label>Region</label>
                                    <input type="text" name="region" class="form-control">
                                </div>
                                 <div class="mb-3">
                                    <label>Correo</label>
                                    <input type="email" name="correo" class="form-control">
                                </div>
                                 <button class="btn btn-warning" type="submit">Agregar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
          <footer class="navbar navbar-expand-lg navbar-dark bg-dark"">
        <div class="container">
            <p style="color: whitesmoke;" >© 2023 Fundacion Kriya. Todos los derechos reservados.</p>
        </div>
    </footer>
    </body>
</html>
