document.getElementById('fecha').addEventListener('blur', validarFecha);
document.getElementById('lugar').addEventListener('blur', validarLugar);
document.getElementById('asunto').addEventListener('blur', validarAsunto);
document.getElementById('organizador').addEventListener('blur', validarOrganizador);

function validarFormulario(){

    let resultado = false;

    resultado = validarFecha() &&
                validarLugar() &&
                validarAsunto() &&
                validarOrganizador();

    formulario.enviar.className = resultado?'btn btn-succes mb-2' : 'btn btn-danger mb-2';

    return false;
}


function validarFecha(){

    let campoFecha = formulario.fecha;
    let resultado = campoFecha.value !=='';

    if(resultado){

        campoFecha.valueAsDate;
        let hoy = new Date().toISOString().slice(0, 10); //Se coge el año, mes y día

        resultado = campoFecha.value > hoy || (campoFecha.value > hoy && campoFecha.getMonth().value >= hoy.getMonth() && campoFecha.getDate().value >= hoy.getDate().value);
        //Cuando se coge la fecha, decimos que sea mayor que hoy o que el mes sea igual al de hoy pero que sea ma





    }

    cambiarApariencia(campoFecha, resultado);

    return resultado;

}

function validarLugar(){

    let campoLugar = formulario.lugar;
    
    let resultado = campoLugar.value !== '';

    if(resultado){

        campoLugar.value = campoLugar.value.toUpperCase();
    }

    cambiarApariencia(campoLugar, resultado);

    return resultado;
}

function validarAsunto(){

    let campoAsunto = formulario.asunto;
    let resultado = campoAsunto.value !=='' && campoAsunto.value.length > 10;

    if(resultado){

        campoAsunto.value = campoAsunto.value.toUpperCase();
    }

    cambiarApariencia(campoAsunto, resultado);

    return resultado;
}

function validarOrganizador(){

    let campoOrganizador = formulario.organizador;
    let resultado = campoOrganizador.value !=='';

    if(resultado){

        campoOrganizador.value = campoOrganizador.value.toUpperCase();
    }

    cambiarApariencia(campoOrganizador, resultado);

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



