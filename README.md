# ProyectoSprinMVC
 # KriyaSpringMvc
Aplicación para manejo de actividades de Fundación Kriya y divulgacion de informacion.
El proyecto contempla ser una plataforma para que usuarios puedan acceder a distintas funciones segun su rol.

- Descripcion de roles:
Administrativo: Unico usuario que puede registrar nuevos usuarios y accesos.
Directorio: Usuarios con acceso a modificar informacion sobre la fundacion, especificamente actividades y asistentes. Eventualmente subir y modificar documentos.
Alumnos(En proceso de desarrollo):  Usuarios con acceso a formularios de inscripcion para actividades.

## Tecnologías utilizadas

- HTML, CSS y JS para el desarrollo del sitio web.
- Utilización de Bootstrap para estilos y responsividad.
- Spring MVC para el desarrollo del backend.
- Repositorios para el acceso a datos.

## Instrucciones de instalación

1. Clona el repositorio de GitHub: `git clone https://github.com/yogalarebelion/kriyaSpringMvc.git`
2. Importa el proyecto en tu entorno de desarrollo favorito.
3. Configura la conexión a la base de datos con el Script.
4. Ejecuta la aplicación.

## Uso

1. Accede a la aplicación.
2. Inicia sesión con tus credenciales según tu rol de usuario.
3. Para iniciar sesion en la aplicaciones y explorar las diferentes funcionalidades disponibles según tu rol prueba con:
a.- Rol de administrativo: id: 2 , password: 1234
b.- Rol de directorio:  id: 303, password:3456
c.- Rol de alumno: id: 320, password:8888

### Para evaluacion:

a) Sitio Web
(HTML, CSS, Bootstrap): /ProyectoSpringMVC/Web Pages/WEB-INF/jsp
(JS): para el modal del login en index y con ruta al archivo javascript
/ProyectoSpringMVC/Web Pages/WEB-INF/js/funciones.js. 

b) Algoritmia de cálculo y manipulación de archivos de texto:

Utilización general del lenguaje: 

- Se utilizan sentencias lógicas (if, else, switch) -->
/ProyectoSpringMVC/Source Packages/Repository/DirectorioRepository.java
linea 126 del metodo "eliminarActividades"

- Se emplean expresiones y operaciones para realizar cálculos y manipulaciones de los archivos de texto:
/ProyectoSpringMVC/Source Packages/Repository/UsuarioRepository.java.
En el método listarUsuariosPorRol(), se realiza una consulta SQL para obtener la cantidad de usuarios por rol.

- Se aplican comparaciones para evaluar condiciones y tomar decisiones: 
En el método login, se realiza una comparación switch para evaluar el valor de la variable resultado. Dependiendo del resultado, se agregan diferentes atributos al modelo y se redirige a diferentes vistas.
/ProyectoSpringMVC/Source Packages/Controller/UsuarioController.java.
linea 85.

- Sentencias repetitivas: Se utilizan bucles (for, while) para iterar sobre los elementos:
/ProyectoSpringMVC/Web Pages/WEB-INF/jsp/vistaAdministrador, linea 151.

- Estructuras de datos: Se emplean estructuras de datos apropiadas, como listas, arrays o colecciones:
/ProyectoSpringMVC/Source Packages/Repository/UsuarioRepository.java
linea 75 metodo "listarUsuario()".

- Principios de encapsulamiento y responsabilidad única: Se crean clases y métodos que se centran en tareas específicas y tienen una única responsabilidad:
/ProyectoSpringMVC/Source Packages/Model/.

- Uso de interfaces o relaciones de herencia para hacer polimorfismo: Se utilizan interfaces:
/ProyectoSpringMVC/Source Packages/Model/Validar.java.

- Utilización de unidades de prueba:
/ProyectoSpringMVC/Test Packages/Controller/DirectorioRepositoryTest.java.

c) Consultas a la base de datos de la aplicación:

- Utilización de JOIN y GROUP BY:
/ProyectoSpringMVC/Source Packages/Repository/UsuarioRepository.java
linea 125 del metodo "listarUsuariosPorRol()".

- Utilización de WHERE: 
/ProyectoSpringMVC/Source Packages/Repository/DirectorioRepository.java
linea 115 del metodo "eliminarActividades()".

- Utilizacion de ORDER BY:
/ProyectoSpringMVC/Source Packages/Repository/DirectorioRepository.java
linea 69 del metodo "listarActividades()".

d) Spring MVC

# Utilización de Controllers: 3 controladores utilizados.
/ProyectoSpringMVC/Source Packages/Controller

# Utilización de vistas JSP y Taglib:
- Se importan las bibliotecas JSTL en la declaración del archivo JSP:  
/ProyectoSpringMVC/Web Pages/WEB-INF/jsp/vistaDirectorio.jsp  
- Se utilizan las etiquetas JSTL en el código HTML para iterar sobre una lista de actividades: 
<c:forEach items="${actividades}" var="actividades">
    <!-- Código HTML para mostrar los detalles de cada actividad -->
</c:forEach>
- Se utilizan las expresiones EL para acceder a las propiedades de los objetos en las etiquetas JSP:
<td>${actividades.id}</td>
<td>${actividades.nombre_act}</td>
<td>${actividades.lugar}</td>

# Creación de Servicio Spring: 2 capas de servicio utilizadas.
/ProyectoSpringMVC/Source Packages/Services

# Creación de DAO acceso a datos: 
- Repositorios en lugar de DAOs para el acceso a datos.
/ProyectoSpringMVC/Source Packages/Repository

# Creación del proyecto y configuración: 
Se crea un proyecto en Spring y se configuran los archivos de configuración:

- Para especificar las dependencias necesarias para utilizar Spring MVC, como el propio framework de Spring y otras bibliotecas relacionadas:
/ProyectoSpringMVC/Project Files/pom.xml.
- Para recibir todas las solicitudes HTTP y dirigirlas al controlador apropiado, definicion de beans y otras configuraciones como la asignación de URL y el manejo de recursos estáticos:
/ProyectoSpringMVC/Web Pages/WEB-INF/dispatcher-servlet.xml

# Funcionamiento general del aplicativo: 
El aplicativo desarrollado con Spring MVC sigue el flujo de solicitud-respuesta típico de una aplicación web. Los controladores reciben las solicitudes HTTP, invocan los servicios y obtienen los datos necesarios de los repositorios. Luego, los datos se pasan a las vistas para generar la respuesta HTML que se envía al cliente.

e) API Rest
/ProyectoSpringMVC/Source Packages/com.adsi.rest/Rest.java
/ProyectoSpringMVC/Source Packages/com.adsi.rest/ApplicationConfig.java


