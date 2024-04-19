// Obtén los enlaces del menú
const menuLinks = document.querySelectorAll('.menu li a');

// Obtén las diapositivas del slider
const slides = document.querySelectorAll('.slider li');

// Añade un controlador de eventos a cada enlace del menú
menuLinks.forEach(link => {
    link.addEventListener('click', function(event) {
        // Evita el comportamiento predeterminado del enlace
        event.preventDefault();
        
        // Elimina la clase activa de todos los enlaces
        menuLinks.forEach(link => link.classList.remove('active'));
        
        // Añade la clase activa solo al enlace seleccionado
        this.classList.add('active');

        // Obtiene el id del enlace seleccionado
        const targetId = this.getAttribute('href').substring(1);
        
        // Oculta todas las diapositivas
        slides.forEach(slide => slide.style.opacity = 0);

        // Muestra la diapositiva correspondiente
        document.getElementById(targetId).style.opacity = 1;
    });
});
