CREATE DATABASE IF NOT EXISTS `escuela`;
use `escuela`; 

-- ---- TABLA DE RUTINA ----

CREATE TABLE IF NOT EXISTS `rutina`(
	`idRutina` int(21) NOT NULL AUTO_INCREMENT,
	`video` varchar(20) DEFAULT NULL,
	`texto` varchar(20) DEFAULT NULL,
	`imagen` varchar(20) DEFAULT NULL,

	PRIMARY KEY (`idRutina`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ---- TABLA DE CUENTA ----

CREATE TABLE IF NOT EXISTS `cuenta`(
	`ID` int(21) NOT NULL AUTO_INCREMENT,
	`contrasenia` varchar(20) DEFAULT NULL,

	PRIMARY KEY (`ID`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `cuenta`;

INSERT INTO `cuenta` (`ID`,`contrasenia`) VALUES 
(1,'admin'),
(2,'adminE');

-- ---- TABLA DE COLABORADOR ----

CREATE TABLE IF NOT EXISTS `colaborador`(
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`cuenta` int(21) NOT NULL,
	`nombre` varchar(20) DEFAULT NULL,
	`apellido` varchar(20) DEFAULT NULL,
	`edad` date DEFAULT NULL,
	`genero` varchar(20) DEFAULT NULL,
	`contrasenia` varchar(20) NOT NULL,

	PRIMARY KEY (`ID`),
	KEY `cuenta` (`cuenta`),
	CONSTRAINT `colaborador_ibfk_1` FOREIGN KEY (`cuenta`) REFERENCES `cuenta` (`ID`)	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

insert into colaborador (ID, cuenta, nombre, apellido, edad, genero, contrasenia) values (1, 1, 'Nancy', 'Medina', '1999-02-18', 'F', 'admin');

-- ---- TABLA DE PACIENTES ----

CREATE TABLE IF NOT EXISTS `paciente`(
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`cuenta` int(21) NOT NULL,
	`nombre` varchar(20) DEFAULT NULL,
	`apellido` varchar(20) DEFAULT NULL,
	`edad` date DEFAULT NULL,
	`tipo_u` varchar(20) DEFAULT NULL,
	`genero` varchar(20) DEFAULT NULL,
	`idRutina` int(21) NOT NULL,
	`contrasenia` int(11) NOT NULL,
	`idMedico` int(11) NOT NULL,
	`idEntrenador` int(11) NOT NULL,

	PRIMARY KEY (`ID`),
	KEY `cuenta` (`cuenta`),
	KEY `idRutina` (`idRutina`),
	KEY `idMedico` (`idMedico`),
	KEY `idEntrenador` (`idEntrenador`),
	CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`cuenta`) REFERENCES `cuenta` (`ID`),
	CONSTRAINT `paciente_ibfk_2` FOREIGN KEY (`idRutina`) REFERENCES `rutina` (`idRutina`),
	CONSTRAINT `paciente_ibfk_3` FOREIGN KEY (`idMedico`) REFERENCES `colaborador` (`ID`),
	CONSTRAINT `paciente_ibfk_4` FOREIGN KEY (`idEntrenador`) REFERENCES `colaborador` (`ID`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `paciente`;

-- ---- TABLA DE PROGRESO ----

CREATE TABLE IF NOT EXISTS `progreso`(
	`idProgreso` int(11) NOT NULL AUTO_INCREMENT,
	`velocidad` int(10),
	`resistencia` int(10),
	`fuerza` int(10),	
	`idRutina` int(21) NOT NULL,
	`idPaciente` int(11) NOT NULL,
	PRIMARY KEY (`idProgreso`),
	KEY `idRutina` (`idRutina`),
	KEY `idPaciente` (`idPaciente`),
	CONSTRAINT `progreso_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`ID`),
	CONSTRAINT `progreso_ibfk_2` FOREIGN KEY (`idRutina`) REFERENCES `rutina` (`idRutina`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ---- TABLA DE RUTINAS PACIENTE ----

CREATE TABLE IF NOT EXISTS `rutinas_paciente`(
	`id` int(11) NOT NULL,
	`idRutina` int(21) NOT NULL,
	`idPaciente` int(11) NOT NULL,

	PRIMARY KEY (`id`),
	KEY `idRutina` (`idRutina`),
	KEY `idPaciente` (`idPaciente`),
	CONSTRAINT `rut_pac_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`ID`),
	CONSTRAINT `rut_pac_ibfk_2` FOREIGN KEY (`idRutina`) REFERENCES `rutina` (`idRutina`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ---- TABLA DE REGISTRO ----

CREATE TABLE IF NOT EXISTS `registro`(
	`idRegistro` int (11) NOT NULL AUTO_INCREMENT, 
	`eje1Levantamiento` varchar(20) DEFAULT NULL,
	`intento1E1L` int(20) DEFAULT NULL,
	`intento2E1L` int(20) DEFAULT NULL,
	`eje1Velocidad` varchar(20) DEFAULT NULL,
	`intento1E1V` int(20) DEFAULT NULL,
	`intento2E1V` int(20) DEFAULT NULL,
	`eje1Equilibrio` varchar(20) DEFAULT NULL,
	`intento1E1E` int(20) DEFAULT NULL,
	`intento2E1E` int(20) DEFAULT NULL,
	`eje2Equilibrio` varchar(20) DEFAULT NULL,
	`intento1E2E` int(20) DEFAULT NULL,
	`intento2E2E` int(20) DEFAULT NULL,
	`eje3Equilibrio` varchar(20) DEFAULT NULL,
	`intento1E3E` int(20) DEFAULT NULL,
	`intento2E3E` int(20) DEFAULT NULL,
	`ritmoCFinal` varchar(20) DEFAULT NULL,
	`ritmoCInicial` varchar(20) DEFAULT NULL,
	`omni_gse` varchar(10) DEFAULT NULL,
	`dia` datetime NOT NUll,
	`idProgreso` int(11) NOT NULL,
	`idPaciente` int(11) NOT NULL,
	`idRutina` int(21) NOT NULL,

	
	PRIMARY KEY (`idRegistro`),
	KEY `idPaciente` (`idPaciente`),
	KEY `idProgreso` (`idProgreso`),
	KEY `idRutina` (`idRutina`),
	CONSTRAINT `registro_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`ID`),
	CONSTRAINT `registro_ibfk_2` FOREIGN KEY (`idProgreso`) REFERENCES `progreso` (`idProgreso`),
	CONSTRAINT `progreso_ibfk_3` FOREIGN KEY (`idRutina`) REFERENCES `rutina` (`idRutina`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE USER 'escolares'@'localhost' IDENTIFIED BY 'mipass';
GRANT SELECT,UPDATE,INSERT ON escuela.* TO 'escolares'@'localhost';
