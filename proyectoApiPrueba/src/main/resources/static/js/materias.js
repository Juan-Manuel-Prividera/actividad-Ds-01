$(document).ready(function() {
    ponerTitulo();
    cargarMaterias();
    $('materias').DataTable();
});


async function cargarMaterias() {
    let anioMateria = localStorage.getItem('anioActual');
    try {
        const response = await fetch(`materias?anioMateria=${anioMateria}`, {
            method: 'GET',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('No se pudo obtener la lista de materias');
        }

        const materias = await response.json();
        cargarMateriasHtml(materias);

    } catch (error) {
        console.log("ERROR AL EJECUTAR CARGAR MATERIAS");
    }
}


function guardarAnio(anio){

    switch(anio){
        case 1: titulo = "Materias primer año"; break;
        case 2: titulo = "Materias segundo año"; break;
        case 3: titulo = "Materias tercer año"; break;
        case 4: titulo = "Materias cuarto año"; break;
        case 5: titulo = "Materias quinto año"; break;
    }
    localStorage.setItem('anioActual',anio);

    document.querySelector('#titulo').outerHTML = titulo;


}

function ponerTitulo(){
    let anio = parseInt(localStorage.getItem('anioActual'));
    let titulo;
    switch(anio){
            case 1: titulo = "Materias primer año"; break;
            case 2: titulo = "Materias segundo año"; break;
            case 3: titulo = "Materias tercer año"; break;
            case 4: titulo = "Materias cuarto año"; break;
            case 5: titulo = "Materias quinto año"; break;
            default: titulo = "";
        }

    document.querySelector('#titulo').textContent = titulo;

}

function cargarMateriasHtml(materias){
    try{
    let listadoHtml = '';
    for(let materia of materias){

        let notaFinal = (materia.notaFinal == -1) ? '-' : materia.notaFinal;
        let promocion = (materia.promocion) ? 'Si' : 'No';
        let notaCursada = (materia.notaCursada == -1) ? '-' : materia.notaCursada;
        let anioCursada = (materia.anioCursada == '') ? '-' : materia.anioCursada;

        let botonHtml = '<a href="#" onclick = irACargarNotas('+materia.id+','+materia.anioMateria+') class="btn btn-info btn-circle btn-sm"> Cargar notas </button></a>';
        let materiaHtml = '<tr> <td>' + materia.nombre +'</td><td>'+notaCursada+'</td><td>'+notaFinal+'</td><td>'+promocion+'</td><td>'+anioCursada+'</td><td>' + botonHtml + '</td></tr>';

        listadoHtml += materiaHtml;
    }

    document.querySelector('#materias tbody').outerHTML = listadoHtml;

    }catch(error){
        console.log("Error al cargar materias en html");
    }
}


function irACargarNotas(id,anio){
    window.location.href = 'cargar-notas.html';
    localStorage.setItem('idMateria',id);
    localStorage.setItem('anioMateria',anio);
}

