USE sai;

INSERT INTO roles (nombreRol, descripcion) 
VALUES 
	("Administrador","Permite utilizar todas la funcionalidades de la aplicación"),
	("Sin Rol", "Sin rol asignado"),
    ("Lectura/Escritura","Podrá crear, modificar, eliminar y listar cualquier datos que no corresponda a un usuario"),
    ("Solo lectura","Solo podrá consultar listados de datos");
    
INSERT INTO usuarios (legajo, nombre, apellido, contrasena, idRol) 
VALUES
(1, 'admin', 'admin', "1", 1),
(2, 'Solo Lectura',   ' ',    '2',    4),
(3, 'Lectura Escritura',   ' ',   '3',   3),
(10003, 'Valentina', 'Lopez',      'vale456789',      1),
(10004, 'Diego',     'Fernandez',  'diego2023abc',    4),
(10005, 'Camila',    'Diaz',       'camila123abc',    2),
(10006, 'Federico',  'Perez',      'fede789654',      1),
(10007, 'Sofia',     'Torres',     'sofia987321',     3),
(10008, 'Agustin',   'Romero',     'agus1234567',     4),
(10009, 'Martina',   'Ruiz',       'martina2022',     2),
(10010, 'Nicolas',   'Herrera',    'nicolas1234',     1);

INSERT INTO centrosDeCostos (idCentro, nombreCentro, direccion) 
VALUES
(1000000001, 'Contabilidad y Finanzas', 'ADMINISTRATIVA'),
(1000000002, 'Ventas Regionales Sur', 'COMERCIAL'),
(1000000003, 'Gestión del Talento', 'RRHH'),
(1000000004, 'Logística y Distribución', 'OPERACIONES'),
(1000000005, 'Publicidad Digital', 'MARKETING');

INSERT INTO proovedores (idProveedor, nombreProveedor, nombreContacto, email, actividadPrincipal) 
VALUES
(10000001, 'TecnoRed SA', 'María González', 'maria.gonzalez@tecnored.com.ar', 'Venta de hardware de red'),
(10000002, 'CloudPoint SRL', 'Esteban Duarte', 'edu@cloudpoint.com', 'Servicios de almacenamiento en la nube'),
(10000003, 'SoftNova', 'Carla Méndez', 'carla@softnova.com', 'Desarrollo de software empresarial'),
(10000004, 'Soluciones IT', 'Roberto Salas', 'r.salas@solucionesit.com.ar', 'Consultoría tecnológica'),
(10000005, 'InnovaBits', NULL, NULL, 'Venta de licencias y soluciones SaaS');

INSERT INTO presupuestos (idPresupuesto, periodo, estado) 
VALUES
(1, 2023, 'CONFIRMADO'),
(2, 2024, 'EN REVISIÓN'),
(3, 2024, 'CONFIRMADO'),
(4, 2025, 'EN REVISIÓN');

INSERT INTO items (idItem, nombreItem, tipoItem) 
VALUES
(100000001, 'Notebook Lenovo ThinkPad T14', 'BIEN'),
(100000002, 'Monitor Dell UltraSharp 27"', 'BIEN'),
(100000003, 'Router Cisco Catalyst 9200', 'BIEN'),
(100000004, 'Servidor HP ProLiant DL380', 'BIEN'),
(100000005, 'Licencia Microsoft 365 Empresarial', 'SERVICIO'),
(100000006, 'Mantenimiento mensual de servidores', 'SERVICIO'),
(100000007, 'Capacitación en ciberseguridad', 'SERVICIO'),
(100000008, 'Desarrollo de aplicación a medida', 'SERVICIO'),
(100000009, 'Consultoría para migración a la nube', 'SERVICIO'),
(100000010, 'Impresora multifunción Brother MFC', 'BIEN');



