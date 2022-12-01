/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  alvar
 * Created: 28 nov 2022
 */


CREATE DATABASE Ventas;

USE DATABASE Ventas;

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE TABLE IF NOT EXISTS `Ventas` (
  `id_compra` int(9) NOT NULL AUTO_INCREMENT COMMENT 'id autoincremental',
  `fecha` date NOT NULL COMMENT 'fecha de la compra',
  `comprador` int(9) NOT NULL COMMENT 'telefono del comprador',
  `precio` int(11) NOT NULL COMMENT 'precio total de compra',  
  PRIMARY KEY (`id_compra`),
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='Tabla de Productos' AUTO_INCREMENT=1;