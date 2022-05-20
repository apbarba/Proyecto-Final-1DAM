document.addEventListener("DOMContentLoaded", function(){
	
	document.getElementById("productos").addEventListener()

});

function validarForumulario(formularioEventos){
	
	forumularioEvento.preventDefault();
	
	var fecha = document.getElementById('fecha').value;
	
	if(fecha.length == 0){
		
		alert('Debes de introducir una fecha');
		
		return;
	}
	
	var lugar = document.getElementById('lugar').value;
	
	if(lugar.length == null){
		
		alert('Debes de introducir un lugar');
		
		return;
	}
	
	var asunto = document.getElementById('asunto').value;
	
	if(asunto.length == null){
		
		alert('Debes de introducir el asunto').value;
		
		return;
	}
	
	var organizador = document.getElementById('organizador').value;
	
	if(organizador.length == null){
		
		alert('Debes de introducir al organizador').value;
		
		return;
	}
	
	this.submit();
}