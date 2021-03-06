document.getElementById('nombre').addEventListener('blur', validarNombre);
document.getElementById('descripcion').addEventListener('blur', validarDescripcion);

function enviarFormulario(){

    let resultado = false;

    let descripcion = false;

    descripcion = validarDescripcion();

    resultado = validarNombre();

    if (!resultado || !descripcion) {
        formulario.enviar.className = 'btn btn-danger mb-2';
        return false;
    } else {
        formulario.enviar.className = 'btn btn-success mb-2';
        return true;
    }
}

function validarNombre(){

    let campoNombre = formulario.nombre;

    let resultado = campoNombre.value !== '';

    if (resultado) {
        campoNombre.value = campoNombre.value.toUpperCase();
    }

    cambiarApariencia(campoNombre, resultado);

    return resultado;
}

function validarDescripcion(){

    let campoDescripcion = formulario.descripcion;

    let resultado = descripcion.value !== '' && descripcion.value.length > 10;

    if(resultado){

        campoDescripcion.value = campoDescripcion.value.toUpperCase();
    }

    cambiarApariencia(campoDescripcion, resultado);

    return resultado;
}

function cambiarApariencia(campo, estado){	
	if(estado){
		campo.classList.remove("border-danger");
		campo.classList.add("border-success");
		campo.parentNode.nextElementSibling.style.visibility = 'hidden';
	}

	else{
		campo.classList.remove("border-success");
		campo.classList.add("border-danger");
		campo.parentNode.nextElementSibling.style.visibility = 'visible';
	}
		
}
