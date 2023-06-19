<%-- 
    Document   : vistaAdministrador
    Created on : Jun 9, 2023, 2:17:51 PM
    Author     : Melody
--%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Vista Administrador</title>
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
                    <!--   EN CONSTRUCCION   <li class="nav-item mt-1">
                        <a href="formulario_inscripcion" class="btn btn-light me-2">Formulario de Inscripción</a>
                    </li> comment -->  
                </ul >   
                   </div>     
   
                <form action="./cerrarSesion" method="post">
                <button type="submit" id="cerrar" class="btn btn-warning btn-rounded ml-auto">Cerrar Sesion<i></i></button>
                </form>
            </div>
        </nav>
                     <!-- este formulario de registro esta en construccion -->
        <div class="container">
            <div class="row mt-4">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>Hola Administrador --> Formulario de Registro de Usuario(en construccion)</h4>
                        </div>
                        <form class="row g-3 needs-validation" novalidate>
                            <div class="col-md-4">
                                <label for="registroNombre" class="form-label">Nombre</label>
                                <input type="text" class="form-control" id="registroNombre" required>
                                <div class="valid-feedback">
                                    Gracias!
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label for="registroApellido" class="form-label">Apellido Paterno</label>
                                <input type="text" class="form-control" id="registroApellido" required>
                                <div class="valid-feedback">
                                    Gracias!
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label for="registroPassword" class="form-label">Password</label>
                                <input type="text" class="form-control" id="registroPassword" required>
                                <div class="invalid-feedback">
                                    Please escribe un password valido.
                                </div>
                            </div>
                            <div class="col-md-4">
                                <label for="registroRol" class="form-label">Tipo de Permiso/Rol</label>
                                <select class="form-select" id="registroRol" required>
                                    <option selected disabled value="">Despliega Para Ver</option>
                                    <option>1 - Administrador</option>
                                    <option>2 - Directorio</option>
                                    <option>3 - Alumno</option>
                                </select>
                            </div>
                            <div class="col-12">
                                <div class="form-check">
                                    <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                                    <label class="form-check-label" for="invalidCheck">
                                        Estas seguro/a de registrar este usuario?
                                    </label>
                                    <div class="invalid-feedback">
                                        Debes estar seguro antes de Registrar.
                                    </div>
                                </div>
                            </div>
                            <div class="col-12">
                                <button class="btn btn-success mt-4" type="submit">Registrar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>Lista de Usuarios</h4>
                        </div>
                        <div class="card-body">					
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">Id </th>
                                        <th scope="col">Nombre</th>
                                        <th scope="col">Apellido Paterno</th>
                                        <th scope="col">Passwrod</th>
                                        <th scope="col">Nombre Rol</th>
                                        <th scope="col">Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${usuario}" var="usuario">
                                        <tr>
                                            <td>${usuario.id}</td>
                                            <td>${usuario.nombre}</td>
                                            <td>${usuario.apellido_paterno}</td>
                                            <td>${usuario.password}</td>
                                            <td>${usuario.rol_id}</td>
                                            <td>
                                                  <div class="d-flex gap-2">                                                  
                                                    <form action="./usuario/${usuario.id}/eliminar" method="post">
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
                    </div>
                </div>
            </div>

            <div class="row mt-4">
                <div class="col-md-12">
                    <div class="card">
                        <div class="card-header text-center">
                            <h4>Lista de Usuarios por Rol</h4>
                        </div>
                        <div class="card-body">					
                            <table class="table">
                                <tbody>
                                    <c:forEach items="${usuariosPorRol}" var="usuariosPorRol">                                                                          
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">Nombre rol</th>
                                                <th scope="col">Cantidad</th>
                                            </tr>
                                        </thead>
                                        <tr>
                                            <td>${usuariosPorRol.nombre_rol}</td>
                                            <td>${usuariosPorRol.cantidad}</td>
                                        </tr>
                                       </table>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

    </body>
</html>
