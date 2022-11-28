/**
 * Author:  alvar
 * Created: 26-nov-2022
 */

CREATE DATABASE Clientes;

USE DATABASE Clientes;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE IF NOT EXISTS `Clientes` (
  `id_cliente` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id autoincremental',
  `nombre` varchar(50) NOT NULL COMMENT 'nombre cliente',
  `apellido_1` varchar(50) COMMENT 'primer apellido del cliente',
  `apellido_2` varchar(50) COMMENT 'segundo apellido del cliente',
  `clave_cliente` int(4) COMMENT 'clave de acceso',
  PRIMARY KEY (`id_cliente`),
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Tabla de Clientes' AUTO_INCREMENT=1;

