# Proyecto-Final-1DAM

Proyecto Final del curso, esta vez se tratará de la correción de Junio.

Mi proyecto trata sobre la gestión de una banda, en la que tendrá dos usuarios:

Usuarios           
--------
user(usuario) - 1234 (contraseña)


admin(usuario) - admin (contraseña)             


Para ver "La Banda" se deberá de iniciar en el navegador la siguiente ruta : localhost:9000

Cada usuario tendrá un rol diferente, ya que si entramos como admin, dispondremos de todas las funcionalidades que la página contendrá, mientras que si entramos como usuario, solamente se podrá observar los eventos de la banda y los productos, a lo que estos se podrán añadir en un carrito como la lista de los deseos.




LÓGICA DE NEGOCIO
__________________
El administrador no ppodrá implentar un nuevo evento si la fecha escogida ya tiene un evento asociado a esta.
El administrador no podrá eliminar una categoria si en esta se encuentra productos asociados, si no es así, se podrá eliminar.

