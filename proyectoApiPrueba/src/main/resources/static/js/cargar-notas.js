$(document).ready(function() {
    // Vacio
});

async function modificarNotas(){

    var notaFinal = document.getElementById('notaFinal').value;
    var notaCursada = document.getElementById('notaCursada').value;
    var promocion = document.getElementById('promocion').value;
    var anioCursada = document.getElementById('anioCursada').value;

    var materia = {
        id:localStorage.getItem('idMateria'),
        notaFinal: notaFinal,
        notaCursada: notaCursada,
        promocion: promocion,
        anioCursada: anioCursada
    };

    const request = await fetch('cargar-notas', {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(materia)
    });

    console.log(request);
}

function volverTabla(event){
    event.preventDefault();
    console.log("ejecuta volverTabla");
    let anioMateria = localStorage.getItem('anioActual');
    window.location.href = 'materias.html'
}
