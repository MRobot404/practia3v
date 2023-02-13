--Creaci�n de usuario Seguni
alter session set "_ORACLE_SCRIPT"=true;
create user seguni identified by seguni;
GRANT ALL PRIVILEGES TO seguni;


--Creacion de las tablas----
CREATE TABLE USUARIO(
ID_USUARIO INT NOT NULL,
USUARIO VARCHAR(255),
CONTRASENA VARCHAR(255),
CONSTRAINT pk_usuario primary key(ID_USUARIO)
);

CREATE TABLE CLIENTES(
DPI_CLIENTE INT NOT NULL,
NOMBRE_CL  VARCHAR(255),
APELLIDO_1 VARCHAR(255),
APELLIDO_2 VARCHAR(255),
CLASE_VIA VARCHAR(255),
NOMBRE_VIA VARCHAR(255),
NUMERO_VIA VARCHAR(255),
COD_POSTAL VARCHAR(255),
CIUDAD VARCHAR(255),
TELEFONO VARCHAR(10),
OBSERVACIONES VARCHAR(255),
CONSTRAINT pk_clientes primary key(DPI_CLIENTE)
);

CREATE TABLE SEGUROS(
NUMERO_POLIZA INT NOT NULL,
RAMO VARCHAR(255),
FECHA_INICIO DATE,
FECHA_VENCIMIENTO DATE,
CONDICIONES_PARTICULARES VARCHAR(255),
OBSERVACIONES VARCHAR(255),
DPI_CLIENTE INT,
CONSTRAINT pk_seguros primary key(NUMERO_POLIZA),
CONSTRAINT fk_seguros_clientes foreign key (DPI_CLIENTE) references CLIENTES(DPI_CLIENTE)
);

CREATE TABLE SINIESTROS(
ID_SINIESTRO INT NOT NULL,
FECHA_SINIESTRO DATE,
CAUSAS VARCHAR(255),
ACEPTADO VARCHAR(2),
INDEMNIZACION INT,
NUMERO_POLIZA INT,
DPI_PERITO INT,
CONSTRAINT pk_siniestros primary key(ID_SINIESTRO),
CONSTRAINT fk_siniestros_peritos foreign key(DPI_PERITO) references PERITOS(DPI_PERITO)
);

ALTER  TABLE SINIESTROS
ADD CONSTRAINT chk_siniestros_accepted
CHECK (ACEPTADO in ('si','no'));



CREATE TABLE PERITOS(
DPI_PERITO INT NOT NULL,
NOMBRE_PERITO VARCHAR(255),
APELLIDO_PERITO1 VARCHAR(255),
APELLIDO_PERITO2 VARCHAR(255),
TELEFONO_CONTACTO VARCHAR(255),
TELEFONO_OFICINA VARCHAR(255),
CLASE_VIA VARCHAR(255),
NOMBRE_VIA VARCHAR(255),
NUMERO_VIA VARCHAR(255),
COD_POSTAL VARCHAR(255),
CIUDAD VARCHAR(255),
CONSTRAINT pk_peritos primary key(DPI_PERITO)
);


CREATE TABLE COMPANIAS_SEGUROS(
ID INT NOT NULL,
NUMERO_POLIZA INT,
NOMBRE_COMPANIA VARCHAR(255),   
CONSTRAINT pk_companias_seguros primary key(ID),
CONSTRAINT fk_seguros_companiaseguros foreign key(NUMERO_POLIZA) references SEGUROS(NUMERO_POLIZA),
CONSTRAINT fk_companias_companiaseguros foreign key(NOMBRE_COMPANIA)references COMPANIAS(NOMBRE_COMPANIA)
);

CREATE TABLE COMPANIAS(
NOMBRE_COMPANIA VARCHAR(255),
CLASE_VIA VARCHAR(255),
NOMBRE_VIA VARCHAR(255),
NUMERO_VIA VARCHAR(255),
COD_POSTAL VARCHAR(255),
TELEFONO_CONTRATACION VARCHAR(12),
TELEFONO_SINIESTROS VARCHAR(12),
NOTAS VARCHAR(255),
CONSTRAINT pk_companias primary key (NOMBRE_COMPANIA)
);

--Selecci�n de datos--
SELECT * FROM USUARIO;
SELECT * FROM CLIENTES;
SELECT * FROM SEGUROS;
SELECT * FROM PERITOS;
SELECT * FROM COMPANIAS;
SELECT * FROM COMPANIAS_SEGUROS;
SELECT* FROM SINIESTROS;


--Insercion de datos----
insert into USUARIO (id_usuario, usuario, contrasena) values (1, 'pwhitrod0', '6BjdVPphZ7qn');
insert into USUARIO (id_usuario, usuario, contrasena) values (2, 'acutriss1', 'zvx7mn4G');
insert into USUARIO (id_usuario, usuario, contrasena) values (3, 'rlesper2', 'LU2ONIHeM');
insert into USUARIO (id_usuario, usuario, contrasena) values (4, 'zsedgefield3', 'uufl23WXCs');
insert into USUARIO (id_usuario, usuario, contrasena) values (5, 'cnelle4', 'TjukZRmS');
insert into USUARIO (id_usuario, usuario, contrasena) values (6, 'jcosgrave5', 'RZaFKf');
insert into USUARIO (id_usuario, usuario, contrasena) values (7, 'gpatel6', 'p1qBeLzjIhD');
insert into USUARIO (id_usuario, usuario, contrasena) values (8, 'vvoisey7', 'R1au7dJ');
insert into USUARIO (id_usuario, usuario, contrasena) values (9, 'kkinforth8', 'dUl4VA7J3');
insert into USUARIO (id_usuario, usuario, contrasena) values (10, 'caslin9', '9Sscw6iKUX');

insert into CLIENTES (dpi_cliente, nombre_cl, apellido_1, apellido_2, clase_via, nombre_via, numero_via, cod_postal, ciudad, telefono) values (959991787, 'Gannon', 'Beall', 'Ellard', 'Negeri Sembilan', 'Tennyson', '5', '70536', 'Seremban', '6202804516');
insert into CLIENTES (dpi_cliente, nombre_cl, apellido_1, apellido_2, clase_via, nombre_via, numero_via, cod_postal, ciudad, telefono) values (3529394415, 'Spike', 'Dany', 'Marchington', 'Porto', 'Arizona', '6', '4785-132', 'Cast�lo', '3752764039');
insert into CLIENTES (dpi_cliente, nombre_cl, apellido_1, apellido_2, clase_via, nombre_via, numero_via, cod_postal, ciudad, telefono) values (4673007711, 'Chrysler', 'Godbold', 'Pelos', 'Kronoberg', 'Center', '99', '351 88', 'V�xj�', '2474172593');
insert into CLIENTES (dpi_cliente, nombre_cl, apellido_1, apellido_2, clase_via, nombre_via, numero_via, cod_postal, ciudad, telefono) values (9934031221, 'Kingsley', 'Bishopp', 'Swinfen', 'Illinois', 'Warner', '86', '60567', 'Naperville', '6306093577');
insert into CLIENTES (dpi_cliente, nombre_cl, apellido_1, apellido_2, clase_via, nombre_via, numero_via, cod_postal, ciudad, telefono) values (8379174608, 'Muire', 'Randalston', 'Swatradge', 'Mexico', 'Evergreen', '27', '54783', 'Santo Tomas', '1479979157');
insert into CLIENTES (dpi_cliente, nombre_cl, apellido_1, apellido_2, clase_via, nombre_via, numero_via, cod_postal, ciudad, telefono) values (103928061, 'Phaidra', 'Westwater', 'Shaul', 'Champagne-Ardenne', 'Ridge Oak', '32387', '51039 CEDEX', 'Ch�lons-en-Champagne', '7666367090');
insert into CLIENTES (dpi_cliente, nombre_cl, apellido_1, apellido_2, clase_via, nombre_via, numero_via, cod_postal, ciudad, telefono) values (6686629157, 'Averell', 'Latey', 'Ballard', 'Sk�ne', 'Springview', '6100', '264 31', 'Klippan', '9678081662');
insert into CLIENTES (dpi_cliente, nombre_cl, apellido_1, apellido_2, clase_via, nombre_via, numero_via, cod_postal, ciudad, telefono) values (5617135828, 'Arvin', 'Alflatt', 'Doorey', 'Pays de la Loire', 'Ruskin', '5116', '44324 CEDEX 3', 'Nantes', '1002410517');
insert into CLIENTES (dpi_cliente, nombre_cl, apellido_1, apellido_2, clase_via, nombre_via, numero_via, cod_postal, ciudad, telefono) values (2758422762, 'Wynny', 'Lomath', 'Boyle', 'Lisboa', 'Havey', '7', '2655-082', 'Fonte Boa da Brincosa', '3831305954');
insert into CLIENTES (dpi_cliente, nombre_cl, apellido_1, apellido_2, clase_via, nombre_via, numero_via, cod_postal, ciudad, telefono) values (6962426483, 'Flori', 'Kropach', 'Metcalfe', 'Halland', 'Claremont', '5513', '434 33', 'Kungsbacka', '6361097256');


insert into SEGUROS (numero_poliza, fecha_inicio, fecha_vencimiento, dpi_cliente) values (7888673066, '24/11/2022', '19/10/2021', 959991787);
insert into SEGUROS (numero_poliza, fecha_inicio, fecha_vencimiento, dpi_cliente) values (6825595995, '14/11/2022', '30/05/2022', 3529394415);
insert into SEGUROS (numero_poliza, fecha_inicio, fecha_vencimiento, dpi_cliente) values (4374089466, '29/12/2019', '05/07/2022', 4673007711);
insert into SEGUROS (numero_poliza, fecha_inicio, fecha_vencimiento, dpi_cliente) values (8567807046, '27/10/2022', '16/02/2021', 9934031221);
insert into SEGUROS (numero_poliza, fecha_inicio, fecha_vencimiento, dpi_cliente) values (3593235892, '02/06/2020', '17/09/2021', 8379174608);
insert into SEGUROS (numero_poliza, fecha_inicio, fecha_vencimiento, dpi_cliente) values (3945618291, '05/11/2022', '06/04/2022', 103928061);
insert into SEGUROS (numero_poliza, fecha_inicio, fecha_vencimiento, dpi_cliente) values (4036523915, '22/09/2021', '18/09/2020', 6686629157);
insert into SEGUROS (numero_poliza, fecha_inicio, fecha_vencimiento, dpi_cliente) values (1410992362, '27/04/2022', '22/01/2022', 5617135828);
insert into SEGUROS (numero_poliza, fecha_inicio, fecha_vencimiento, dpi_cliente) values (6641928648, '28/12/2019', '12/12/2020', 2758422762);
insert into SEGUROS (numero_poliza, fecha_inicio, fecha_vencimiento, dpi_cliente) values (3494643261, '05/08/2021', '06/02/2023', 6962426483);

insert into PERITOS (dpi_perito, nombre_perito, apellido_perito1, apellido_perito2, telefono_contacto, telefono_oficina, clase_via, nombre_via, numero_via, cod_postal, ciudad) values (9073562873, 'Emmye', 'Foulsham', 'Ca', '1016145643', '9263007675', 'Lorraine', 'Helena', '04', '57304 CEDEX', 'Hagondange');
insert into PERITOS (dpi_perito, nombre_perito, apellido_perito1, apellido_perito2, telefono_contacto, telefono_oficina, clase_via, nombre_via, numero_via, cod_postal, ciudad) values (7764279789, 'Minny', 'Beran', 'Maeer', '8012818208', '6823165946', 'Kronoberg', 'Sherman', '42', '351 06', 'V�xj�');
insert into PERITOS (dpi_perito, nombre_perito, apellido_perito1, apellido_perito2, telefono_contacto, telefono_oficina, clase_via, nombre_via, numero_via, cod_postal, ciudad) values (9796169800, 'Gae', 'Camillo', 'Awdry', '9059069016', '9795627342', '�le-de-France', 'Sundown', '509', '95234', 'Soisy-sous-Montmorency');
insert into PERITOS (dpi_perito, nombre_perito, apellido_perito1, apellido_perito2, telefono_contacto, telefono_oficina, clase_via, nombre_via, numero_via, cod_postal, ciudad) values (6293375670, 'Sula', 'Davidovic', 'Gage','6176829526', '6143112864', 'Massachusetts', 'International', '635', '02162', 'Newton');
insert into PERITOS (dpi_perito, nombre_perito, apellido_perito1, apellido_perito2, telefono_contacto, telefono_oficina, clase_via, nombre_via, numero_via, cod_postal, ciudad) values (6983230122, 'Melinde', 'Yarnell', 'Le Provest', '6378118809', '4064756543', 'Porto', 'Eastlawn', '90848', '4485-824', 'Vilar do Pinheiro');
insert into PERITOS (dpi_perito, nombre_perito, apellido_perito1, apellido_perito2, telefono_contacto, telefono_oficina, clase_via, nombre_via, numero_via, cod_postal, ciudad) values (415871194, 'Lonnie', 'Hackelton', 'Baszniak', '3147776632', '2512244106', 'Missouri', 'Texas', '79418', '63121', 'Saint Louis');
insert into PERITOS (dpi_perito, nombre_perito, apellido_perito1, apellido_perito2, telefono_contacto, telefono_oficina, clase_via, nombre_via, numero_via, cod_postal, ciudad) values (8922876562, 'Engracia', 'Waudby', 'Placidi', '3423438854', '6557474507', '�sterg�tland', 'Summit', '84', '589 00', 'Link�ping');
insert into PERITOS (dpi_perito, nombre_perito, apellido_perito1, apellido_perito2, telefono_contacto, telefono_oficina, clase_via, nombre_via, numero_via, cod_postal, ciudad) values (1263040481, 'Consalve', 'Champneys', 'Geer', '2212450521', '2621636607', 'Set�bal', 'Northwestern', '356', '2830-152', 'Santo Andr�');
insert into PERITOS (dpi_perito, nombre_perito, apellido_perito1, apellido_perito2, telefono_contacto, telefono_oficina, clase_via, nombre_via, numero_via, cod_postal, ciudad) values (2266323237, 'Rex', 'Da Costa', 'Cavalier', '2374678532', '4019401306', 'Manitoba', 'Boyd', '6', 'R6M', 'Morden');
insert into PERITOS (dpi_perito, nombre_perito, apellido_perito1, apellido_perito2, telefono_contacto, telefono_oficina, clase_via, nombre_via, numero_via, cod_postal, ciudad) values (9777746314, 'Aldous', 'Lode', 'Worsley', '3819653445', '3228281266', 'Braga', 'Manitowish', '1600', '4830-184', 'Quint�');
insert into PERITOS (dpi_perito, nombre_perito, apellido_perito1, apellido_perito2, telefono_contacto, telefono_oficina, clase_via, nombre_via, numero_via, cod_postal, ciudad) values (1009636554, 'Randi', 'Pearsey', 'Armfirld', '6803065184', '3538157521', 'Provence-Alpes-C�te d''Azur', 'Calypso', '5', '13219 CEDEX 02', 'Marseille');

insert into COMPANIAS (nombre_compania, nombre_via, numero_via, cod_postal, telefono_contratacion, telefono_siniestros) values ('Adams, Schulist and Gutkowski', 'Forest Dale', '977', '68400-000', '1456186951', '6733190366');
insert into COMPANIAS (nombre_compania, nombre_via, numero_via, cod_postal, telefono_contratacion, telefono_siniestros) values ('McDermott Inc', 'Park Meadow', '6', '116 45', '4347078088', '2429581865');
insert into COMPANIAS (nombre_compania, nombre_via, numero_via, cod_postal, telefono_contratacion, telefono_siniestros) values ('Feil, Hickle and Kuvalis', 'Pine View', '09146', '59304 CEDEX', '5729733475', '4679659922');
insert into COMPANIAS (nombre_compania, nombre_via, numero_via, cod_postal, telefono_contratacion, telefono_siniestros) values ('Weber, Rodriguez and Lehner', 'Eastlawn', '9', '04015', '2555629334', '7117877182');
insert into COMPANIAS (nombre_compania, nombre_via, numero_via, cod_postal, telefono_contratacion, telefono_siniestros) values ('Lakin, Marks and Homenick', 'Jenna', '4163', 'H71', '9593262907', '1257574034');
insert into COMPANIAS (nombre_compania, nombre_via, numero_via, cod_postal, telefono_contratacion, telefono_siniestros) values ('Schamberger-Swaniawski', 'High Crossing', '248', '353567', '8089246483', '5609134582');
insert into COMPANIAS (nombre_compania, nombre_via, numero_via, cod_postal, telefono_contratacion, telefono_siniestros) values ('Dibbert-Frami', 'Prentice', '46301', '814018', '3563672374', '9602926730');
insert into COMPANIAS (nombre_compania, nombre_via, numero_via, cod_postal, telefono_contratacion, telefono_siniestros) values ('Hammes, Abshire and Nader', 'Loftsgordon', '71591', '44604 CEDEX', '1659324594', '7193918773');
insert into COMPANIAS (nombre_compania, nombre_via, numero_via, cod_postal, telefono_contratacion, telefono_siniestros) values ('Lehner, Hermann and Hessel', 'Mariners Cove', '95', '6503', '2092332952', '2508469794');

insert into COMPANIAS (clase_via) values ('Languedoc-Roussillon');
insert into COMPANIAS (clase_via) values ('Minnesota');
insert into COMPANIAS (clase_via) values ('Portalegre');
insert into COMPANIAS (clase_via) values ('Rh�ne-Alpes');
insert into COMPANIAS (clase_via) values ('Sk�ne');
insert into COMPANIAS (clase_via) values ('Stockholm');
insert into COMPANIAS (clase_via) values ('Aveiro');
insert into COMPANIAS (clase_via) values ('Qu�bec');
insert into COMPANIAS (clase_via) values ('V�rmland');
insert into COMPANIAS (clase_via) values ('Bourgogne');


insert into SINIESTROS (id_siniestro, fecha_siniestro, causas, aceptado, indemnizacion, numero_poliza, dpi_perito) values (1, '02/02/2022', 'p�rdidas financieras', 'no', 5509, 7888673066, 9073562873);
insert into SINIESTROS (id_siniestro, fecha_siniestro, causas, aceptado, indemnizacion, numero_poliza, dpi_perito) values (2, '06/03/2022', 'robos', 'no', 3515, 6825595995, 7764279789);
insert into SINIESTROS (id_siniestro, fecha_siniestro, causas, aceptado, indemnizacion, numero_poliza, dpi_perito) values (3, '24/08/2022', 'p�rdidas financieras', 'si', 2031, 3494643261, 9796169800);
insert into SINIESTROS (id_siniestro, fecha_siniestro, causas, aceptado, indemnizacion, numero_poliza, dpi_perito) values (4, '12/12/2022', 'desmembramiento', 'no', 7884, 4374089466, 6293375670);
insert into SINIESTROS (id_siniestro, fecha_siniestro, causas, aceptado, indemnizacion, numero_poliza, dpi_perito) values (5, '30/10/2022', 'incendios', 'no', 9631, 1279, 6983230122);
insert into SINIESTROS (id_siniestro, fecha_siniestro, causas, aceptado, indemnizacion, numero_poliza, dpi_perito) values (6, '10/08/2022', 'accidentes de autom�vil', 'si', 4592, 103928061, 415871194);
insert into SINIESTROS (id_siniestro, fecha_siniestro, causas, aceptado, indemnizacion, numero_poliza, dpi_perito) values (7, '11/01/2022', 'desmembramiento', 'no', 8853, 3494643261, 8922876562);
insert into SINIESTROS (id_siniestro, fecha_siniestro, causas, aceptado, indemnizacion, numero_poliza, dpi_perito) values (8, '09/07/2022', 'desmembramiento', 'no', 1172, 5617135828, 1263040481);
insert into SINIESTROS (id_siniestro, fecha_siniestro, causas, aceptado, indemnizacion, numero_poliza, dpi_perito) values (9, '08/08/2022', 'accidentes de autom�vil', 'si', 5957, 6641928648, 2266323237);
insert into SINIESTROS (id_siniestro, fecha_siniestro, causas, aceptado, indemnizacion, numero_poliza, dpi_perito) values (10, '02/01/2022', 'robos', 'si', 1823, 6641928648, 1009636554);

insert into COMPANIAS_SEGUROS(id,numero_poliza,nombre_compania) values(1,7888673066,'Adams, Schulist and Gutkowski');
insert into COMPANIAS_SEGUROS(id,numero_poliza,nombre_compania) values(2,6825595995,'McDermott Inc');
insert into COMPANIAS_SEGUROS(id,numero_poliza,nombre_compania) values (3,4374089466,'Feil, Hickle and Kuvalis');
insert into COMPANIAS_SEGUROS(id,numero_poliza,nombre_compania) values (4,8567807046,'Weber, Rodriguez and Lehner');
insert into COMPANIAS_SEGUROS(id,numero_poliza,nombre_compania) values (5,3593235892,'Lakin, Marks and Homenick');
insert into COMPANIAS_SEGUROS(id,numero_poliza,nombre_compania) values (6,3945618291,'Schamberger-Swaniawski');
insert into COMPANIAS_SEGUROS(id,numero_poliza,nombre_compania) values (7,4036523915,'Dibbert-Frami');
insert into COMPANIAS_SEGUROS(id,numero_poliza,nombre_compania) values (8,1410992362,'Hammes, Abshire and Nader');
insert into COMPANIAS_SEGUROS(id,numero_poliza,nombre_compania) values (9,6641928648,'Lehner, Hermann and Hessel');
--Creacion de secuencias--
CREATE SEQUENCE test_seq
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
CREATE SEQUENCE test_seq1
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
 CREATE SEQUENCE test_seq2
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
 CREATE SEQUENCE test_seq3
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;