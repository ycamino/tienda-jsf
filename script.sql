create database tutienda;

use tutienda;

create table usuario (
id int primary key auto_increment,
correo_electronico varchar(100) not null,
contrasena varchar(100) not null,
nombre varchar(100) not null,
unique key uk_usuario_correo_electronico(correo_electronico)
);

create table categoria (
id int primary key auto_increment,
nombre varchar(50) not null
);

create table producto (
id int primary key auto_increment,
nombre varchar(100) not null,
descripcion varchar(500) not null,
precio decimal(10, 2) not null,
id_categoria int not null,
foreign key fk_producto_categoria(id_categoria) references categoria(id)
);

create table venta (
id int primary key auto_increment,
fecha_venta datetime not null,
precio_total decimal(12, 2) not null,
id_usuario int not null,
foreign key fk_venta_usuario(id_usuario) references usuario(id)
);

create table detalle_venta (
id int primary key auto_increment,
id_producto int not null,
id_venta int not null,
precio_unitario decimal(10, 2) not null,
cantidad int not null,
foreign key fk_detalle_venta_producto(id_producto) references producto(id),
foreign key fk_detalle_venta_venta(id_venta) references venta(id)
);


insert into categoria (nombre) values
('Tecnología'), ('Deportes y Outdoors'), ('Hogar y Bazar')
;

insert into producto (nombre, descripcion, precio, id_categoria) values
('Huawei P20 Lite DS 5.8" Android 8.0 32GB 16MP + 2MP Negro', 'Características principales:
- Sistema operativo Android 8.0 Oreo

- Procesador Octa-Core 2.36 GHz

- Pantalla Full HD de 5.8" (1080 x 2280)

- Memoria interna de 32GB / Memoria RAM de 4GB

- Cámara Dual de 16MP + 2MP / Cámara frontal 16MP

- Batería con capacidad de 3000 mAh', 1099.00, 1),
('Lenovo Notebook Ideapad 120S 14'''' Intel Celeron N3350 32GB 2GB', '- Sistema operativo Windows 10 Home- Procesador Intel Celeron N3350- Pantalla HD de 14'' con fondo WLED (1366x768)- Memoria interna de 32GB / Memoria RAM de 2GB DDR4- Cámara web de 0.3MP con micrófono integrado- Tarjeta de video Intel HD 500 Graphics- Batería con 2 celdas', 599, 1),
('Samsung Smart TV 50'''' 4K UHD 50NU7090', '- Resolución 4K UHD de 3840 x 2160 píxeles

- Tecnología de imagen HDR

- Calidad de sonido: Dolby Digital Plus

- Navegador Smart Hub

- Conectividad WiFi

- 2 Puertos HDMI / 1 Puerto USB', 1499, 1),
('National Geographic Mochila Norman 30 Lt Azul', '– Material: 420D Ripstop Polyester.
– Incluye: Cubre Mochila repelente al agua.', 169, 2),
('Muvo Caminadora Endurance 10', '- Área de trote: 40 x 120 cm- Velocidad máxima de 12 km/h- Escaneo de Velocidad / Tiempo / Distancia / Pulso / Calorías- 12 Programas de entrenamiento- 4 Programas de velocidad / 3 Posiciones de inclinación- Peso máximo permitido de 105 Kg', 1049, 2),
('Bestway Colchon Inflable 1 Plz + Almohada + Inflador', 'Regular', 27.13, 2),
('Tramontina Juego de Ollas Bergamo 8 Piezas Rojo', '- Incluye: sartén (20 cm), olla (20 cm), cacerola (18 y 16 cm) y hervidor (12 cm)

- Material: Aluminio con Starflon T1

- Tapas de vidrio templado con salida de vapor

- Mangos y asas baquelita antitérmica

- Cocción uniforme

- Bases con resistencia eléctrica', 179, 3),
('Krea Ropero Porto 6 Puertas 2 Cajones', '- 6 Puertas / 2 Cajones- 100% Melamina- Fácil de armar- Producto peruano- Dimensiones: 180 x 150 x 46 cm', 279, 3),
('Forli Juego de Dormitorio Polaris 2 Plazas Perla', '- Box Tarima + Colchón de 2 plazas + Cabecera

- Tela del colchón de Jacquard

- Tipo de resortes Bonell

- Cantidad de resortes: 286

- Láminas de poliuretano

- Compartimiento oculto en el box

- Incluye: Almohadas / Edredón', 939, 3)
;



