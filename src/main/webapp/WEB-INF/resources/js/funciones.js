/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

/* global bootstrap */

//FUNCIONES

$(document).ready(function() {
    //asocio el evento de click al boton
    $('#btnIniciarSesion').click(function() {
        //muestro el modal
        $('#modalLogin').modal('show');
    });
});

//CARRUSEL INDEX
const carousel = new bootstrap.Carousel('#myCarousel');


// FUNCION PARA CUANDO HAY CAMPOS INVALIDOS VISTA ADMINISTRADOR! EN CONSTRUCCION

(() => {
  'use strict';

  // llama a validaciones de bootstrap
  const forms = document.querySelectorAll('.needs-validation');
  const myCarouselElement = document.querySelector('#myCarousel');

const carousel = new bootstrap.Carousel(myCarouselElement, {
  interval: 2000,
  touch: false
});

  // recorre
  Array.from(forms).forEach(form => {
    form.addEventListener('submit', event => {
      if (!form.checkValidity()) {
        event.preventDefault();
        event.stopPropagation();
      }

      form.classList.add('was-validated');
    }, false);
  });
})();