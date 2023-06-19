<%-- 
    Document   : buscar_asistente
    Created on : Jun 8, 2023, 7:12:51 PM
    Author     : Melody
--%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Asistente</title>
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
            </div>
        </nav>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>Búsqueda de Asistentes</h4>
                        </div>
                        <div class="card-body">
                            <form action="./buscar_asistente" method="post">
                                <input type="hidden" name="action" value="buscar">
                                <div class="mb-3">
                                    <label>Ingresa el Id de Asistente</label>
                                    <input type="number" name="id" class="form-control">
                                </div>
                                <button type="submit" class="btn btn-warning">Buscar</button>
                            </form>
                            <h3>Resultado de la búsqueda</h3>
                            <c:if test="${asistente!=null}">
                                <table class="table">                                                            
                                    <thead>
                                        <tr>
                                            <th scope="col">Nombre </th>
                                            <th scope="col">Apellido Paterno</th>
                                            <th scope="col">Apellido Materno</th>
                                            <th scope="col">Fecha de Nacimiento</th>
                                            <th scope="col">Region</th>
                                            <th scope="col">Correo</th>
                                            <th scope="col">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>${asistente.nombre}</td>
                                            <td>${asistente.apellido_paterno}</td>
                                            <td>${asistente.apellido_materno}</td>
                                            <td>${asistente.fechaNac}</td>
                                            <td>${asistente.region}</td>
                                            <td>${asistente.correo}</td>

                                            <td>
                                                <div class="d-flex gap-2">
                                                    <a href="editar_asitente.jsp?id=${asistente.id}" class="btn btn-primary">Editar</a>
                                                    <a href="asistentes?action=eliminar&id=${asistente.id}" class="btn btn-danger">Eliminar</a>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </c:if>
                            <c:if test="${empty asistente}">
                                <p>No se encontraron resultados.</p>    
                            </c:if>						
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
