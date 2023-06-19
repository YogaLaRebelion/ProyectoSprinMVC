<%-- 
    Document   : contacto
    Created on : Jun 9, 2023, 7:07:05 PM
    Author     : Melody
--%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario de Contacto</title>
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
        <h1>Formulario de Contacto!</h1>
        <form action="./contacto" method="post">
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Nombre</label>
            <input type="email" class="form-control" id="exampleFormControlInput1" placeholder="xxxx@example.com">
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Correo</label>
            <input type="email" class="form-control" id="exampleFormControlInput1">
        </div>
        <div class="mb-3">
            <label for="exampleFormControlInput1" class="form-label">Telefono</label>
            <input type="txt" class="form-control" id="exampleFormControlInput1">
        </div>
        <div class="mb-3">
            <label for="exampleFormControlTextarea1" class="form-label">Mensaje</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>
            </form>
              <footer class="navbar navbar-expand-lg navbar-dark bg-dark"">
        <div class="container">
            <p style="color: whitesmoke;" >© 2023 Fundacion Kriya. Todos los derechos reservados.</p>
        </div>
    </footer>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    </body>
</html>
