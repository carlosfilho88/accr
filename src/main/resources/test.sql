-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.19-0ubuntu0.14.04.1 - (Ubuntu)
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             9.2.0.4953
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for libsystem
DROP DATABASE IF EXISTS `libsystem`;
CREATE DATABASE IF NOT EXISTS `libsystem` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_swedish_ci */;
USE `libsystem`;


-- Dumping structure for table libsystem.item
DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `ano` int(11) DEFAULT NULL,
  `edicao` int(10) unsigned DEFAULT NULL,
  `autor` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table libsystem.item: ~1 rows (approximately)
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`id`, `descricao`, `quantidade`, `ano`, `edicao`, `autor`) VALUES
	(1, 'Teste', 100, 1987, 1, 'Fulano');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


-- Dumping structure for table libsystem.movimentacoes
DROP TABLE IF EXISTS `movimentacoes`;
CREATE TABLE IF NOT EXISTS `movimentacoes` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `tipo_movimentacao` char(1) NOT NULL,
  `created` datetime NOT NULL,
  `modified` datetime DEFAULT NULL,
  `user_id_modified` int(10) unsigned NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table libsystem.movimentacoes: ~1 rows (approximately)
/*!40000 ALTER TABLE `movimentacoes` DISABLE KEYS */;
INSERT INTO `movimentacoes` (`id`, `item_id`, `tipo_movimentacao`, `created`, `modified`, `user_id_modified`, `status`) VALUES
	(1, 1, 'E', '2015-07-15 00:48:21', NULL, 1, 1);
/*!40000 ALTER TABLE `movimentacoes` ENABLE KEYS */;


-- Dumping structure for table libsystem.perfil
DROP TABLE IF EXISTS `perfil`;
CREATE TABLE IF NOT EXISTS `perfil` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) COLLATE utf8_swedish_ci NOT NULL,
  `status` tinyint(2) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_swedish_ci;

-- Dumping data for table libsystem.perfil: ~2 rows (approximately)
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` (`id`, `nome`, `status`) VALUES
	(1, 'usuario', 1),
	(2, 'administrador', 1);
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;


-- Dumping structure for table libsystem.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `perfil_id` int(10) unsigned DEFAULT '1',
  `cpf` varchar(11) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `senha` varchar(12) DEFAULT '123456',
  `data_nascimento` date DEFAULT NULL,
  `created` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `status` tinyint(2) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Dumping data for table libsystem.usuario: ~2 rows (approximately)
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`id`, `perfil_id`, `cpf`, `nome`, `senha`, `data_nascimento`, `created`, `modified`, `status`) VALUES
	(1, 2, '03451889340', 'Carlos Filho', '123456', '1988-10-11', '2015-07-12 16:06:25', NULL, 1),
	(2, 1, '02647064393', 'Airon Lima', '123456', '1988-04-18', '2015-07-15 23:17:53', '2015-07-15 23:37:36', 1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
