<%-- 
    Document   : vistaAlumno
    Created on : Jun 9, 2023, 2:18:06 PM
    Author     : Melody
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">

    </head>
    <body>
        
        <!-- formulario en construccion -->
        <h1>Bienvenido! (formulario en construccion)</h1>
        <form action="/vistaAlumno" method="post">
            <select class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
                <option selected>A cual actividad te quieres inscribir?</option>
                <option value="1">Yoga y Restauracion / 3 de noviembre</option>
                <option value="2">Yoga Portal Belloto / martes 11 am</option>
                <option value="3">Meditaciones Online / jueves 20 hrs</option>
            </select>
            <button type="submit" class="btn btn-success">Aceptar</button>
        </form>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

    </body>
</html>
