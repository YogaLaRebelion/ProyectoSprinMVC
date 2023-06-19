<%-- 
    Document   : editar_asistente
    Created on : Jun 7, 2023, 12:45:22 PM
    Author     : Melody
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
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
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-header text-center">
                            <h3>Editar Actividad</h3>
                        </div>
                        <div class="card-body">
                            <form action="./editar_actividad" method="post">
                                <div class="mb-3">

                                    <label>ID</label>
                                    <input type="text" name="id" class="form-control" value="${actividades.id}">
                                </div>
                                <div class="mb-3">
                                    <label>Nombre Actividad</label>
                                    <input type="text" name="nombre_act" class="form-control" value="${actividades.nombre_act}">
                                </div>
                                <div class="mb-3">
                                    <label>Lugar</label>
                                    <input type="text" name="lugar" class="form-control" value="${actividades.lugar}">
                                </div>
                                <div class="mb-3">
                                    <label>Fecha</label>
                                    <input type="date" name="fecha" class="form-control" value="${actividades.fecha}">
                                </div>
                                <div class="mb-3">
                                    <label>Hora</label>
                                    <input type="time" name="hora" class="form-control" value="${actividades.hora}">
                                </div>
                                <div class="mb-3">
                                    <label>Cantidad de Asistentes</label>
                                    <input type="txt" name="cantidad_asistentes" class="form-control" value="${actividades.cantidad_asistentes}">
                                </div>
                                <button type="submit" class="btn btn-success">Actualizar</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

