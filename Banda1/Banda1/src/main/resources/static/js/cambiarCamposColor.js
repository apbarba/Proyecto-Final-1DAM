


document.getElementById("color").addEventListener("keyup", cambio);

function cambio(){
	
	let campo = document.getElementById("color");
	
	if(campo.value == ''){
		
		campo.style.backgroundColor = '#C7FFB4';
		
	}else{
		campo.style.backgroundColor = '#FFA8A8';
	}
}