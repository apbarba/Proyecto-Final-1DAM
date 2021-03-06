
INSERT INTO eventos (id,lugar,fecha,asunto,organizador) VALUES (NEXTVAL('hibernate_sequence'),'Sanlúcar de Barrameda','2022-08-28','Salida Procesional por el 75 Aniversario de la hermandad', 'Hermandad de  la Burriquita');
INSERT INTO eventos (id,lugar,fecha,asunto,organizador) VALUES (NEXTVAL('hibernate_sequence'),'Sanlúcar de Barrameda', '2022-09-17', 'Salida Procesional por el 75 Aniversario de la hermandad', 'Hermandad del Huerto');
INSERT INTO eventos (id,lugar,fecha,asunto,organizador) VALUES (NEXTVAL('hibernate_sequence'),'Cádiz', '2022-10-07', 'Abrir el cortejo en la salida Procesional del Rosario Coronada', 'Hermandad del Rosario Coronada');
INSERT INTO eventos (id,lugar,fecha,asunto,organizador) VALUES (NEXTVAL('hibernate_sequence'),'Rota', '2022-10-16', 'Concierto', 'Hermandad del Santo Entierro');
INSERT INTO eventos (id,lugar,fecha,asunto,organizador) VALUES (NEXTVAL('hibernate_sequence'),'Cádiz', '2022-12-25', 'Concierto de Navidad', 'BCT Rosario de Cádiz');


INSERT INTO categoria (id, nombre, descripcion) VALUES (1,'Ropa','Ropa con grabados de la banda');
INSERT INTO categoria (id, nombre, descripcion) VALUES (2, 'Accesorios', 'Accesorios dobre la banda');
INSERT INTO categoria (id, nombre, descripcion) VALUES (3, 'Instrumentos', 'Instrumentos de Rosario');

INSERT INTO productos (id, nombre, cantidad, precio, proveedor, texto, categorias_id, img) VALUES (NEXTVAL('hibernate_sequence'),'Botella Rosario',100, 15.50, 'Ibermusic', 'Botella de Rosario', 2, 'https://i0.wp.com/rosariodecadiz.com/wp-content/uploads/2021/04/PicsArt_05-03-08.22.07-scaled.jpg?resize=300%2C300&ssl=1');
INSERT INTO productos (id, nombre, cantidad, precio,  proveedor, texto, categorias_id, img) VALUES (NEXTVAL('hibernate_sequence'),'Pulsera',100, 1.50, 'Picholi', 'Pulsera', 2, 'https://pbs.twimg.com/media/E2QvPbfWQAMGjP-?format=jpg&name=small');
INSERT INTO productos (id, nombre, cantidad, precio,  proveedor, texto, categorias_id, img) VALUES (NEXTVAL('hibernate_sequence'),'Polo', 100, 50.00, 'Alcaiceria','Camiseta', 1, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQ4yx2ZidZVfbLSeq7AVprYkHtXkuWXSR3ZTXQFgNby41Dn6SE-HhLBSgJMqSERKNaxDk&usqp=CAU');
INSERT INTO productos (id, nombre, cantidad, precio,  proveedor, texto, categorias_id, img) VALUES (NEXTVAL('hibernate_sequence'),'Calcetines',100, 5.00,'Calcetines',1, 'https://pepepinreles.com/3733-home_default/banda-cornetas-y-tambores.jpg');
INSERT INTO productos (id, nombre, cantidad, precio,  proveedor, texto, categorias_id, img) VALUES (NEXTVAL('hibernate_sequence'),'Llavero',100, 25.00, 'SieteOctava', 'Llavero', 1, 'https://pbs.twimg.com/media/E17VaVzXEAElsvE?format=jpg&name=large');
INSERT INTO productos (id, nombre, cantidad, precio,  proveedor, texto, categorias_id, img) VALUES (NEXTVAL('hibernate_sequence'), 'Taza Rosario', 100, 30.70, 'Fender', 'Taza de Rosario', 2,'https://artejimenezdiaz.es/wp-content/uploads/2021/04/patrona.jpg');
INSERT INTO productos (id, nombre, cantidad, precio,  proveedor, texto, categorias_id, img) VALUES (NEXTVAL('hibernate_sequence'), 'Trompeta', 100, 145.75, 'MisterWear','Trompeta', 3, 'https://fasilamusic.com/14117-superlarge_default/trompeta-sml-si-tp500.jpg');
INSERT INTO productos (id, nombre, cantidad, precio,  proveedor, texto, categorias_id, img) VALUES (NEXTVAL('hibernate_sequence'), 'Corneta', 100, 100.50, 'MusicPasion', 'Corneta', 3, 'https://www.topcofrade.com/wp-content/uploads/2018/08/corneta-tizona-do-reb-pulida.jpg');
INSERT INTO productos (id, nombre, cantidad, precio,  proveedor, texto, categorias_id, img) VALUES (NEXTVAL('hibernate_sequence'), 'Tambor', 100, 150.90, 'IberMusic', 'Tambor', 3, 'https://www.topcofrade.com/wp-content/uploads/2017/11/tambor-ld-chicota-25x13-refld4709-1.jpg');
INSERT INTO productos (id, nombre, cantidad, precio,  proveedor, texto, categorias_id, img) VALUES (NEXTVAL('hibernate_sequence'), 'Tuba', 100, 450.90, 'Picholi', 'Tuba',3, 'https://thumbs.static-thomann.de/thumb/padthumb600x600/pics/bdb/239445/2092275_800.jpg');




