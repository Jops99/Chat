/*
Created: 08/10/2017
Modified: 08/10/2017
Model: MySQL 5.0
Database: MySQL 5.0
*/


-- Create tables section -------------------------------------------------

-- Table Usuario

CREATE TABLE `Usuario`
(
  `idUsuario` Serial NOT NULL,
  `nomUsuario` Char(30) NOT NULL,
  `tipoUsuario` Bool NOT NULL
)
;

ALTER TABLE `Usuario` ADD  PRIMARY KEY (`idUsuario`)
;

-- Table Mensagem

CREATE TABLE `Mensagem`
(
  `idMsg` Serial NOT NULL,
  `destinoSala` Long NOT NULL,
  `remetente` Long NOT NULL,
  `destinatario` Long NOT NULL,
  `horaEnvio` Timestamp NOT NULL,
  `conteudoMsg` Char(1000) NOT NULL
)
;

CREATE INDEX `IX_Relationship1` ON `Mensagem` (`remetente`)
;

CREATE INDEX `IX_Relationship2` ON `Mensagem` (`destinoSala`)
;

CREATE INDEX `IX_Relationship3` ON `Mensagem` (`destinatario`)
;

ALTER TABLE `Mensagem` ADD  PRIMARY KEY (`idMsg`)
;

-- Table Sala

CREATE TABLE `Sala`
(
  `idSala` Serial NOT NULL,
  `desSala` Char(30) NOT NULL
)
;

ALTER TABLE `Sala` ADD  PRIMARY KEY (`idSala`)
;

-- Create relationships section ------------------------------------------------- 

ALTER TABLE `Mensagem` ADD CONSTRAINT `Relationship1` FOREIGN KEY (`remetente`) REFERENCES `Usuario` (`idUsuario`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `Mensagem` ADD CONSTRAINT `Relationship2` FOREIGN KEY (`destinoSala`) REFERENCES `Sala` (`idSala`) ON DELETE RESTRICT ON UPDATE RESTRICT
;

ALTER TABLE `Mensagem` ADD CONSTRAINT `Relationship3` FOREIGN KEY (`destinatario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE RESTRICT ON UPDATE RESTRICT
;