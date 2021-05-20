create database autobusos;

CREATE TABLE `usuaris` (
  `id_usuari` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `cognoms` varchar(45) DEFAULT NULL,
  `funcio` varchar(45) DEFAULT NULL,
  `fecha_entrada` datetime DEFAULT NULL,
  `telefon` varchar DEFAULT NULL,
  `correuElectronic` varchar(45) DEFAULT NULL,
  `permisos` varchar(45) DEFAULT NULL,
  `contrasenya` varchar(45) NOT NULL,
  PRIMARY KEY (`id_usuari`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tokens` (
  `id_usuari` int NOT NULL,
  `usuari` varchar(45) DEFAULT NULL,
  `token` varchar(45) DEFAULT NULL,
  `hora_inici` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_usuari`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `rutas` (
  `id_ruta` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `caracter` varchar(45) DEFAULT NULL,
  `recollida` varchar(45) DEFAULT NULL,
  `destinacio` varchar(45) DEFAULT NULL,
  `informacion` varchar(45) DEFAULT NULL,
  `guia_asignat` varchar(45) DEFAULT NULL,
  `client` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_ruta`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `resenyas` (
  `id_resenya` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `id_usuari` int DEFAULT NULL,
  `fecha` varchar(45) DEFAULT NULL,
  `informacion` varchar(45) DEFAULT NULL,
  `links` varchar(45) DEFAULT NULL,
  `hastags` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_resenya`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `paradas` (
  `id_parada` int NOT NULL AUTO_INCREMENT,
  `ubicacio` varchar(45) DEFAULT NULL,
  `informacion` varchar(45) DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_parada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `paradalinia` (
  `id_linia` int NOT NULL,
  `id_parada` int NOT NULL,
  `ordre` int DEFAULT NULL,
  PRIMARY KEY (`id_linia`,`id_parada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `linias` (
  `id_linia` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(45) DEFAULT NULL,
  `informacion` varchar(45) DEFAULT NULL,
  `bus_asignat` varchar(45) DEFAULT NULL,
  `hora_inici` varchar(45) DEFAULT NULL,
  `hora_finalitzacio` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_linia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `comentaris` (
  `id_comentari` int NOT NULL AUTO_INCREMENT,
  `id_resenya` int DEFAULT NULL,
  `id_usuari` int DEFAULT NULL,
  `comentari` varchar(2000) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  PRIMARY KEY (`id_comentari`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `asignacions` (
  `id_asignacio` int NOT NULL,
  `id_usuari` varchar(45) DEFAULT NULL,
  `id_linia` varchar(45) DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `dias_asignats` varchar(45) DEFAULT NULL,
  `tipus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_asignacio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;