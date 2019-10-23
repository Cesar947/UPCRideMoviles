create database upcridetest;
use upcridetest;
SET GLOBAL time_zone = '-3:00';


INSERT INTO usuario(nombres, apellidos, codigo_upc, correo_upc, contraseña,dni, distrito, licencia_conducir, facebook_id, rol, sede, telefono,ubicacion_latitud, ubicacion_longitud )
VALUES ('Bryan Antony', 'Miramira Morales', 'U201710061', 'U201710061@upc.edu.pe', 'xdxdxd5000','12345678', 'Los Olivos', 'X01928374', 'www.facebook.com', 'C', 'UPC San Miguel',
'98720339', -11.9909776, -77.0713316);

INSERT INTO usuario(nombres, apellidos, codigo_upc, correo_upc, contraseña,dni, distrito, rol, sede, telefono,ubicacion_latitud, ubicacion_longitud )
VALUES ('Juan Alberto', 'Pérez Rojas', 'U201710947', 'U201710947@upc.edu.pe', 'xdxdxd4000','123415', 'Callao', 'P', 'UPC San Miguel',
'98736482',-12.0277097, -77.0999577);

INSERT INTO usuario(nombres, apellidos, codigo_upc, correo_upc, contraseña,dni, distrito, rol, sede, telefono,ubicacion_latitud, ubicacion_longitud )
VALUES ('Juan José', 'Sánchez Bellido', 'U201610987', 'U201610987@upc.edu.pe', 'xdxdxd4400','5123123', 'Callao', 'P', 'UPC San Miguel',
'99796232',-12.3347097, -77.0933577);

INSERT INTO usuario(nombres, apellidos, codigo_upc, correo_upc, contraseña,dni, distrito, licencia_conducir, facebook_id, rol, sede, telefono,ubicacion_latitud, ubicacion_longitud )
VALUES ('Ruben', 'Doblas', 'U201900962', 'U201900962@upc.edu.pe', '12345','512321', 'San Miguel', 'LC1001837', 'www.facebook.com', 'C', 'UPC San Miguel',
'98720339', -11.9909776, -77.0713316);

INSERT INTO usuario(nombres, apellidos, codigo_upc, correo_upc, contraseña,dni, distrito, rol, sede, telefono,ubicacion_latitud, ubicacion_longitud )
VALUES ('Kevin', 'Vergara Gonzáles', 'U201811327', 'U201811327@upc.edu.pe', 'asdfgh','12345678', 'Los Olivos', 'P', 'UPC San Miguel',
'993465271',-12.0145055, -77.0874391);

INSERT INTO auto(limite_personas, marca, modelo, placa, poliza_soat, conductor_id)
VALUES(4, 'Toyota', 'Corolla', 'AX8-BBC', '11779120', 1);
INSERT INTO auto(limite_personas, marca, modelo, placa, poliza_soat, conductor_id)
VALUES(4, 'Chevrolet', 'Camaro', 'AX8-BBC', '11231120', 5);

INSERT INTO viaje(descripcion, dia, entrada_salida, estado, fecha, hora_partida, hora_llegada, punto_partida, punto_destino, partida_latitud, partida_longitud, destino_latitud,
 destino_longitud, visualizacion_habilitada, conductor_id, numero_pasajeros, limite_pasajeros, precio_base) 
 VALUES('Iré desde Izaguirre hasta la UPC San Miguel. Los espero', 'Lunes', 0, 'Publicado', '2019-06-24', '09:00:00', '11:00:00', 'Av. Izaguirre', 'UPC San Miguel', 
 -11.9909776, -77.0713316, -12.0768117,-77.0958753, 1, 1, 0, 4, 10);
 
INSERT INTO viaje(descripcion, dia, entrada_salida, estado, fecha, hora_partida, hora_llegada, punto_partida, punto_destino, partida_latitud, partida_longitud, destino_latitud,
 destino_longitud, visualizacion_habilitada, conductor_id, numero_pasajeros, limite_pasajeros, precio_base) 
 VALUES('Iré desde Izaguirre hasta la UPC San Miguel. Los espero', 'Miércoles', 0, 'Publicado', '2019-06-28', '13:00:00', '15:00:00', 'Av. Izaguirre', 'UPC San Miguel', 
 -11.9909776, -77.0713316, -12.0768117,-77.0958753, 1, 1, 0, 4, 10);
 
INSERT INTO viaje(descripcion, dia, entrada_salida, estado, fecha, hora_partida, hora_llegada, punto_partida, punto_destino, partida_latitud, partida_longitud, destino_latitud,
 destino_longitud, visualizacion_habilitada, conductor_id, numero_pasajeros, limite_pasajeros, precio_base) 
 VALUES('Muy buenas criaturitas del señor', 'Lunes', 0, 'Publicado', '2019-10-24', '09:00:00', '11:00:00', 'Av. Izaguirre', 'UPC San Miguel', 
 -11.9909776, -77.0713316, -12.0768117,-77.0958753, 1, 4, 0, 4, 10);


INSERT INTO viaje(descripcion, dia, entrada_salida, estado, fecha, hora_partida, hora_llegada, punto_partida, punto_destino, partida_latitud, partida_longitud, destino_latitud,
 destino_longitud, visualizacion_habilitada, conductor_id, numero_pasajeros, limite_pasajeros, precio_base) 
 VALUES('Muy buenas a todos', 'Viernes', 0, 'Publicado', '2019-10-24', '11:00:00', '13:00:00', 'Av. Izaguirre', 'UPC San Miguel', 
 -11.9909776, -77.0713316, -12.0768117,-77.0958753, 1, 4, 0, 4, 10);

INSERT INTO solicitud(pasajero_id, viaje_id, mensaje, confirmacion_conductor, punto_encuentro, encuentro_latitud, encuentro_longitud, fecha )
values(2, 1, 'Quiero solicitar el viaje y quisiera que el punto de encuentro sea en el Aeropuerto Jorge Chávez', 'Pendiente',
'Aeropuerto Jorge Chavez', -12.0240474, -77.1142247, '2019-06-22');

INSERT INTO solicitud(pasajero_id, viaje_id, mensaje, confirmacion_conductor, punto_encuentro, encuentro_latitud, encuentro_longitud, fecha )
values(3, 1, 'Quiero solicitar el viaje y quisiera que el punto de encuentro sea en el Aeropuerto Jorge Chávez', 'Pendiente',
'Aeropuerto Jorge Chavez', -12.0240474, -77.1142247, '2019-06-22');

INSERT INTO solicitud(pasajero_id, viaje_id, mensaje, confirmacion_conductor, punto_encuentro, encuentro_latitud, encuentro_longitud, fecha )
values(5, 1, 'Quiero solicitar el viaje y quisiera que el punto de encuentro sea en la Av. Tomás Valle', 'Aceptada',
'Av. Tomás Valle', -12.0122594 ,-77.0762476, '2019-06-22');


SELECT * FROM Solicitud;


select * from itinerario;
select * from usuario;
select * from viaje;
SELECT * FROM Auto;

delete from Viaje where viaje_id = 3;

UPDATE Solicitud SET confirmacion_conductor = 'Pendiente' where solicitud_id = 4;
select * from Solicitud;
SELECT * FROM Usuario u JOIN Solicitud s ON u.usuario_id = s.pasajero_id JOIN Viaje v ON v.viaje_id = s.viaje_id;



SELECT COUNT(s.pasajero_id)
FROM Viaje v JOIN Solicitud s
ON v.viaje_id = s.viaje_id
where v.viaje_id = 1
group by v.viaje_id