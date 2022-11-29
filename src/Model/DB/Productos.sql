/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  alvar
 * Created: 28 nov 2022
 */


CREATE DATABASE Productos;

USE DATABASE Productos;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE IF NOT EXISTS `productos` (
  `id_producto` int(9) NOT NULL AUTO_INCREMENT COMMENT 'id autoincremental',
  `nombre` varchar(30) NOT NULL COMMENT 'nombre producto',
  `precio` int(5) COMMENT 'precio producto',
  PRIMARY KEY (`id_producto`),
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Tabla de Productos' AUTO_INCREMENT=1;