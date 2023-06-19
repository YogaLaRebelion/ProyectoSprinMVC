<%-- 
    Document   : formulario_inscripcion
    Created on : Jun 15, 2023, 8:56:38 PM
    Author     : Melody
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Fundacion Kriya</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
        <script src="resources/js/funciones.js"></script>

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" 
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

        <style>
            .navbar {
                background-color: #007bff;
            }

            .navbar-brand,
            .navbar-brand:hover,
            .navbar-brand:focus,
            .navbar-nav .nav-link {
                color: #fff;
            }

            .footer {
                background-color: #f8f9fa;
                padding: 20px;
                text-align: center;
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
    <nav class="navbar navbar-expand-lg navbar-light bg-dark">
        <div class="container-fluid">
            <a class="nav-link navbar-brand" href="fundacion_kriya">
                <img class="rounded-circle img-responsive" src="<c:url value="/resources/img/logo.jpg"/> "alt="Logo" width="40" height="40"
                     >Fundacion Kriya</a>
                       <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
            <div class="collapse navbar-collapse"  id="navbarNav">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" href="contacto">Contacto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="donaciones">Donaciones</a>
                    </li>
                    <li class="nav-item mt-1">
                        <a href="inscripcion" class="btn btn-light me-2">Formulario de Inscripción</a>
                    </li>
                </ul >   
                <li class="d-flex">
                    <a  id="btnIniciarSesion" class="btn btn-warning me-2" data-toggle="modal" data-target="#modalLogin" >Iniciar Sesion</a>
                </li>
            </div>        
    </nav>
        <div class="container">
            <div class="row">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                        <div class="card-header text-center">
                            <h3>Inscribete</h3>
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
                                 <button class="btn btn-warning" type="submit">Inscribete</button>
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
