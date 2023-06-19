<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Sistema de Administracion Directorio</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" 
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
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
                <form action="./cerrarSesion" method="post">
                <button type="submit" id="cerrar" class="btn btn-warning btn-rounded ml-auto">Cerrar Sesion<i></i></button>
                </form>
            </div>
        </nav>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>Actividades</h4>
                        </div>
                        <div class="card-body">					
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">ID </th>
                                        <th scope="col">Nombre </th>
                                        <th scope="col">Lugar</th>
                                        <th scope="col">Fecha</th>
                                        <th scope="col">Hora</th>
                                        <th scope="col">Cantidad Asistentes</th>
                                        <th scope="col">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${actividades}" var="actividades">
                                        <tr>
                                            <td>${actividades.id}</td>
                                            <td>${actividades.nombre_act}</td>
                                            <td>${actividades.lugar}</td>
                                            <td>${actividades.fecha}</td>
                                            <td>${actividades.hora}</td>
                                            <td>${actividades.cantidad_asistentes}</td>
                                            <td>
                                                <div class="d-flex gap-2">
                                                    <form action="./editar_actividad" method="GET">
                                                        <input type="hidden" name="id" value="${actividades.id}"/>
                                                        <button class="btn btn-dark" type="submit">Editar</button>
                                                    </form>
                                                    <form action="./actividades/${actividades.id}/eliminar" method="post">
                                                        <button class="btn btn-warning" type="submit" 
                                                    >Eliminar</button>
                                                    </form>
                                                </div>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="card-header text-center">
                            <h4>Asistentes</h4>
                        </div>
                        <div class="card-body">					
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Nombre </th>
                                        <th scope="col">Apellido Paterno</th>
                                        <th scope="col">Apellido Materno</th>
                                        <th scope="col">Fecha Nacimiento</th>
                                        <th scope="col">Region</th>
                                        <th scope="col">Correo</th>                                      
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${asistentes}" var="asistentes">
                                        <tr>
                                            <td>${asistentes.nombre}</td>
                                            <td>${asistentes.apellido_paterno}</td>
                                            <td>${asistentes.apellido_materno}</td>
                                            <td>${asistentes.fechaNac}</td>
                                            <td>${asistentes.region}</td>
                                            <td>${asistentes.correo}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
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
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    </body>
</html>

