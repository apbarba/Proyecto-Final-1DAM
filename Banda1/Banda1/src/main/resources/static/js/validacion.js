let nombre = document.getElementById('nombre');
let descripcion = document.getElementById('descripcion');
let error = document.getElementById('error');
error.style.color = "red";

function enviarFormulario(){

    let mensajeError = [];

	if(nombre.value === null || nombre.value === ''){

        mensajeError.push('Por favor ingrese el nombre de la categoria');
    }
	if(descripcion.value === null || descripcion.value === ''){

        mensajeError.push('Por favor ingrese una pequeña descripción');
    }

	error.innerHTML = mensajeError.join(', ');


}