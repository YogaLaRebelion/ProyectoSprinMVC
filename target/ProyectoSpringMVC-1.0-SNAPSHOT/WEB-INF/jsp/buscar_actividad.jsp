<%-- 
    Document   : buscar_actividad
    Created on : Jun 8, 2023, 7:12:38 PM
    Author     : Melody
--%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Insert title here</title>
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
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>Actividades</h4>
                        </div>
                        <div class="card-body">
                            <h3>Búsqueda de Actividades</h3>
                            <form action="./buscar_actividad" method="post">
                                <input type="hidden" name="action" value="buscar">
                                <div class="mb-3">
                                    <label>Id Actividad</label>
                                    <input type="text" name="id" class="form-control">
                                </div>
                                <button type="submit" class="btn btn-success">Buscar</button>
                            </form>
                            <h3>Resultado de la búsqueda</h3>

                            <c:if test="${actividad!=null}">
                                <table class="table">                                                            
                                    <thead>
                                        <tr>
                                            <th scope="col">Nombre Actividad </th>
                                            <th scope="col">Lugar</th>
                                            <th scope="col">Fecha</th>
                                            <th scope="col">Hora</th>
                                            <th scope="col">Cantidad Asistentes</th>
                                                                                 <th scope="col">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td>${actividad.nombre_act}</td>
                                            <td>${activida.lugar}</td>
                                            <td>${actividad.fecha}</td>
                                            <td>${actividad.hora}</td>
                                            <td>${actividad.cantidad_asistentes}</td>
                                            <td>
                                                <div class="d-flex gap-2">
                                                    <a href="editar_actividad.jsp?id=${actividad.id}" class="btn btn-primary">Editar</a>
                                                    <a href="actividades?action=eliminar&id=${actividad.id}" class="btn btn-danger">Eliminar</a>
                                                </div>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </c:if>
                            <c:if test="${empty actividad}">
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
    </body>
</html>
