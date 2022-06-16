document.getElementById('nombre').addEventListener('blur', validarNombre);
document.getElementById('cantidad').addEventListener('blur', validarCantidad);
document.getElementById('precio').addEventListener('blur', validarPrecio);
document.getElementById('categoria').addEventListener('blur', validarCategoria);

function enviarFormulario(){

    let resultado = false;

    let precio = false;

    let categoria = false;

    categoria = validarCantidad();

    precio = validarPrecio();

    resultado = validarNombre() && validarCantidad();
                
    if (!resultado || !precio || !categoria) {
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

    if(resultado){

        campoNombre.value = campoNombre.value.toUpperCase();
    }

    cambiarApariencia(campoNombre, resultado);

    return resultado;
}

function validarCantidad(){

    let campoCantidad = formulario.cantidad;
    let resultado = campoCantidad.value !== '' && campoCantidad.value > 0;

    cambiarApariencia(campoCantidad, resultado);

    return resultado;
}

function validarPrecio(){

    let campoPrecio = formulario.precio;
    let resultado = campoPrecio.value !== '' && campoPrecio.value > 0.0;

   cambiarApariencia(campoPrecio, resultado);

   return resultado;
}

function validarCategoria(){

    let campoCategoria = formulario.categoria;
    let resultado = campoCategoria.value != '-1';

    if(resultado){
    
        alert('Seleccione una categoria para el producto');

    }

    cambiarApariencia(campoCategoria, resultado);

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