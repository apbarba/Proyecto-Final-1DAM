let nombre = document.getElementById('nombre').addEventListener('blur', validarNombre);
let descripcion = document.getElementById('descripcion').addEventListener('blur', validarDescripcion);

function enviarFormulario(){

    let resultado = false;

    resultado = validarNombre() && validarDescripcion();

    formulario.enviar.className = resultado?'btn btn-succes mb-2' : 'btn btn-danger mb-2'

    return false;
}

function validarNombre(){

    let campoNombre = formulario.nombre;

    let resultado = campoNombre.value !== '';

    if(resultado){

        campoNombre.value = camcampoNombrepo.value.toUpperCase();
    }

    cambiarApariencia(campoNombre, resultado);

    return resultado;
}

function validarDescripcion(){

    let campo = formulario.descripcion;

    let resultado = descripcion.value !== '' && descripcion.value.length > 10;

    if(resultado){

        campo.value = campo.value.toUpperCase();
    }

    cambiarApariencia(campo, resultado);

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
