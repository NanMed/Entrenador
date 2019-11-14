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

-- ---- TABLA DE PACIENTES ----

CREATE TABLE IF NOT EXISTS `paciente`(
	`ID` int(11) NOT NULL AUTO_INCREMENT,
	`cuenta` int(21) NOT NULL,
	`nombre` varchar(20) DEFAULT NULL,
	`apellido` varchar(20) DEFAULT NULL,
	`edad` date DEFAULT NULL,
	`tipo_u` varchar(20) DEFAULT NULL,
	`genero` varchar(20) DEFAULT NULL,
	`idRutina` int(11) NOT NULL,
	`contrasenia` int(11) NOT NULL,

	PRIMARY KEY (`ID`),
	KEY `cuenta` (`cuenta`),
	KEY `idRutina` (`idRutina`),
	CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`cuenta`) REFERENCES `cuenta` (`ID`),
	CONSTRAINT `paciente_ibfk_2` FOREIGN KEY (`idRutina`) REFERENCES `rutina` (`idRutina`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

DELETE FROM `paciente`;

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

-- ---- TABLA DE HISTORIAL ----
CREATE TABLE IF NOT EXISTS `historial`(
	`idHistorial` int(11) NOT NULL AUTO_INCREMENT,
	`tiempo` int (20) NOT NULL,
	`clasificacion` varchar(20) DEFAULT NULL,
	`caidas` int(20) DEFAULT NULL,
	`prueba2` varchar(20) DEFAULT NULL,
	`prueba1` varchar(20) DEFAULT NULL,
    `sumaSppb` varchar(20) DEFAULT NULL,
    `distancia` varchar(20) DEFAULT NULL,
    `idPaciente` int(11) NOT NULL,


	PRIMARY KEY (`idHistorial`),
	KEY `idPaciente` (`idPaciente`),
	
	CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`ID`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


-- ---- TABLA DE RUTINAS EN HISTORIAL ----

CREATE TABLE IF NOT EXISTS `equilibrio`(
	`idEquilibrio` int (20) NOT NULL AUTO_INCREMENT,
    `piesjuntos` varchar(20) DEFAULT NULL,
	`tandem`varchar(20) DEFAULT NULL,
	`puntaje` int(20) DEFAULT NULL,
	`semitandem` varchar(20) DEFAULT NULL,
	
	PRIMARY KEY (`idEquilibrio`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `velocidad`(
	`idVelocidad` int (20) NOT NULL AUTO_INCREMENT,
	`tiempo1` int(20) DEFAULT NULL,
	`tiempo2` varchar(20) DEFAULT NULL,
	`distancias` int(20) DEFAULT NULL,
	`puntaje` varchar(20) DEFAULT NULL,
	
	
	PRIMARY KEY (`idVelocidad`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `levantamiento`(
	`idLevantamiento` int (20) NOT NULL AUTO_INCREMENT,
	`tiempo1` int(20) DEFAULT NULL,
	`puntaje` varchar(20) DEFAULT NULL,
	
	
	PRIMARY KEY (`idLevantamiento`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


-- ---- TABLA DE HISTORICO ----

CREATE TABLE IF NOT EXISTS `historico`(
	`idHistorico` int(11) NOT NULL AUTO_INCREMENT, 
	`tiempo` int (20) NOT NULL,
	`clasificacion` varchar(20) DEFAULT NULL,
	`caidas` int(20) DEFAULT NULL,
	`prueba2` varchar(20) DEFAULT NULL,
	`prueba1` varchar(20) DEFAULT NULL,
    `sumaSppb` varchar(20) DEFAULT NULL,
    `distancia` varchar(20) DEFAULT NULL,
    `idPaciente` int(11) NOT NULL,

	PRIMARY KEY (`idHistorico`),
	KEY `idPaciente` (`idPaciente`),
	CONSTRAINT `historico_ibfk_2` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`ID`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ---- TABLA DE PROGRESO ----

CREATE TABLE IF NOT EXISTS `progreso`(
	`idProgreso` int(11) NOT NULL AUTO_INCREMENT,
	`velocidad` int(10),
	`resistencia` int(10),
	`fuerza` int(10),	
	
	PRIMARY KEY (`idProgreso`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ---- TABLA DE HISTORIAL RUTINAS ----

CREATE TABLE IF NOT EXISTS `historial_rutinas`(
	`id` int(11) NOT NULL,
	`idHistorial` int(11) DEFAULT NULL,
	`idHistorico` int(11) DEFAULT NUll,
	`idVelocidad` int(11) NOT NULL,
	`idLevantamiento` int(11) NOT NULL, 
    `idEquilibrio` int(11) NOT NULL,

	PRIMARY KEY (`id`),
	KEY `idHistorial` (`idHistorial`),
	KEY `idHistorico` (`idHistorico`),
	KEY `idVelocidad` (`idVelocidad`),
	KEY `idLevantamiento` (`idLevantamiento`),
	KEY `idEquilibrio` (`idEquilibrio`),
	CONSTRAINT `hist_proyecto_ibfk_1` FOREIGN KEY (`idHistorial`) REFERENCES `historial` (`idHistorial`),
	CONSTRAINT `hist_proyecto_ibfk_2` FOREIGN KEY (`idHistorico`) REFERENCES `historico` (`idHistorico`),
	CONSTRAINT `hist_proyecto_ibfk_3` FOREIGN KEY (`idVelocidad`) REFERENCES `velocidad` (`idVelocidad`),
	CONSTRAINT `hist_proyecto_ibfk_4` FOREIGN KEY (`idLevantamiento`) REFERENCES `levantamiento` (`idLevantamiento`),
	CONSTRAINT `hist_proyecto_ibfk_5` FOREIGN KEY (`idEquilibrio`) REFERENCES `equilibrio` (`idEquilibrio`)

) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ---- TABLA DE REGISTRO ----

CREATE TABLE IF NOT EXISTS `registro`(
	`idRegistro` int (11) NOT NULL AUTO_INCREMENT, 
	`nombrePrueba` varchar(20) DEFAULT NULL,
	`ritmoCInicial` varchar(20) DEFAULT NULL,
	`ritmoCFinal` varchar(20) DEFAULT NULL,
	`componentes` varchar(20) DEFAULT NULL,
	`intento1` varchar(10) DEFAULT NULL,
	`intento2` varchar(10) DEFAULT NULL,
	`pierna` varchar(10) DEFAULT NULL,
	`brazo` varchar(10) DEFAULT NULL,
	`omni_gse` varchar(10) DEFAULT NULL,
	`dia` datetime NOT NUll,
	`idProgreso` int(20) NOT NULL,
	`idPaciente` int(11) NOT NULL,

	
	PRIMARY KEY (`idRegistro`),
	KEY `idPaciente` (`idPaciente`),
	KEY `idProgreso` (`idProgreso`),
	
	CONSTRAINT `registro_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`ID`),
	CONSTRAINT `registro_ibfk_2` FOREIGN KEY (`idProgreso`) REFERENCES `progreso` (`idProgreso`)
	
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

CREATE USER 'escolares'@'localhost' IDENTIFIED BY 'mipass';
GRANT SELECT,UPDATE,INSERT ON escuela.* TO 'escolares'@'localhost';
