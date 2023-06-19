<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Fundacion Kriya</title>
        <!-- Bibliotecas JavaScript -->
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" ></script>
        <script src="resources/js/funciones.js"></script>
        <!-- Bibliotecas de Bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" 
              rel="stylesheet" 
              integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" 
              crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
        <!-- Hoja de estilos personalizada -->
        <link rel="stylesheet" href="/ProyectoSpringMVC/resources/css/style.css">
        <style>
            body {
                display: flex;
                flex-direction: column;
                min-height: 100vh;
            }

            .content {
                flex: 1;
            }
        </style>
    </head>
    <body>
        <!-- Barra de navegación -->
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="nav-link navbar-brand text-white" href="fundacion_kriya">
                <img class="rounded-circle img-responsive" src="<c:url value="/resources/img/logo.jpg"/> "alt="Logo" width="40" height="40"> Fundacion Kriya</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse"  id="navbarNav">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link text-white" href="contacto">Contacto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-white" href="donaciones">Donaciones</a></li>
                    <li>
                        <div class="contenedor-icono mt-2" >
                            <svg xmlns="http://www.w3.org/2000/svg" width="26" height="26" fill="white" class="bi bi-balloon-heart" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="m8 2.42-.717-.737c-1.13-1.161-3.243-.777-4.01.72-.35.685-.451 1.707.236 3.062C4.16 6.753 5.52 8.32 8 10.042c2.479-1.723 3.839-3.29 4.491-4.577.687-1.355.587-2.377.236-3.061-.767-1.498-2.88-1.882-4.01-.721L8 2.42Zm-.49 8.5c-10.78-7.44-3-13.155.359-10.063.045.041.089.084.132.129.043-.045.087-.088.132-.129 3.36-3.092 11.137 2.624.357 10.063l.235.468a.25.25 0 1 1-.448.224l-.008-.017c.008.11.02.202.037.29.054.27.161.488.419 1.003.288.578.235 1.15.076 1.629-.157.469-.422.867-.588 1.115l-.004.007a.25.25 0 1 1-.416-.278c.168-.252.4-.6.533-1.003.133-.396.163-.824-.049-1.246l-.013-.028c-.24-.48-.38-.758-.448-1.102a3.177 3.177 0 0 1-.052-.45l-.04.08a.25.25 0 1 1-.447-.224l.235-.468ZM6.013 2.06c-.649-.18-1.483.083-1.85.798-.131.258-.245.689-.08 1.335.063.244.414.198.487-.043.21-.697.627-1.447 1.359-1.692.217-.073.304-.337.084-.398Z"/>
                            </svg>                        
                        </div>
                    </li>
                    <!--   EN CONSTRUCCION   <li class="nav-item mt-1">
                        <a href="formulario_inscripcion" class="btn btn-light me-2">Formulario de Inscripción</a>
                    </li> comment -->  
                </ul >   
                <li class="d-flex">
                    <a  id="btnIniciarSesion" class="btn btn-warning me-2" data-toggle="modal" data-target="#modalLogin" >Iniciar Sesion</a>
                </li>
            </div> 
        </div>
    </nav>
    <div class="container">
        <div class="container mt-4">
            <div class="row align-items-center">
                <div class="col align-items-center">
                    <h1 class="display-4">Bienvenido a Fundacion Kriya</h1>
                    <p class="lead">Aquí te puedes inscribir a nuestras actividades.</p>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-12 mt-4">
                <div class="pendon-container">
                    <img src="<c:url value="/resources/img/pendon.jpg"/>" alt="pendon" class="img-fluid pendon-image">
                </div>
            </div>
            <div class="col-lg-8 col-md-12 mt-4">
                <div id="carouselExampleCaptions" class="carousel slide">
                    <div class="carousel-indicators">
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                    </div>
                    <!--  <div class="container text-center mt-4"> -->   
                    <div class="carousel-inner">
                        <div class="carousel-item">
                            <img src="<c:url value="/resources/img/yogaPortal.jpg"/>" class="img-fluid carousel-image" alt="img2">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Portal Belloto</h5>
                                <p>Hatha Yoga Gratis.</p>
                            </div>
                        </div>
                        <div class="carousel-item active">
                            <img src="<c:url value="/resources/img/yoga_cris.jpg"/>" class="img-fluid carousel-image" alt="img1">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Parque La Reserva</h5>
                                <p>Clases aptas para todo nivel de experiencia!</p>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <img src="<c:url value="/resources/img/yogaMirador.jpg"/>" class="img-fluid carousel-image" alt="img3">
                            <div class="carousel-caption d-none d-md-block">
                                <h5>Mirador Parque La Reserva</h5>
                                <p>Compartir como parte de la experiencia Kriya!</p>
                            </div>
                        </div>
                    </div>
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </div>
    </div>
    <!-- Footer -->
    <footer class=" footer mt-auto py-3 navbar-expand-lg navbar-dark bg-dark mt-2">
        <div class="container">
            <p class="text-center" style="color: whitesmoke;" >© 2023 Fundacion Kriya. Todos los derechos reservados.</p>
        </div>
    </footer>

    <!--Modal: Login -->
    <div class="modal fade" id="modalLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog cascading-modal modal-avatar modal-sm" role="document">
            <div class="modal-content">
                <div class="modal-header text-center">
                    <img alt="avatar"  class="rounded-circle img-responsive mx-auto d-block" src="<c:url value="/resources/img/logo.jpg"/>" width="150px"/>
                </div>
                <div class="modal-body text-center mb-1">
                    <form action="./index" method="post">
                        <div class="md-form ml-0 mr-0">
                            <input type="text" id="txtId" class="form-control form-control-sm validate ml-0" name="txtId">
                            <label data-error="wrong" data-success="right" for="id" class="ml-0">Ingresa tu ID</label>
                            <input type="password" id="password" name="password" class="form-control form-control-sm validate ml-0 mt-1">
                            <label data-error="wrong" data-success="right" for="password" class="ml-0">Ingresa tu Password</label>
                        </div>
                        <div class="text-center mt-4">
                            <button type="submit" id="login" class="btn btn-warning btn-rounded ml-auto mt-1">Inicia Sesion<i></i></button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>