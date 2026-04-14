-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: grupos_musicales
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `componentes`
--

DROP TABLE IF EXISTS `componentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `componentes` (
  `componenteId` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `instrumento` varchar(25) NOT NULL,
  `grupoId` int unsigned NOT NULL,
  PRIMARY KEY (`componenteId`),
  KEY `FK_GRUPO_ID` (`grupoId`),
  CONSTRAINT `FK_GRUPO_ID` FOREIGN KEY (`grupoId`) REFERENCES `grupos` (`grupoId`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `componentes`
--

LOCK TABLES `componentes` WRITE;
/*!40000 ALTER TABLE `componentes` DISABLE KEYS */;
INSERT INTO `componentes` VALUES (1,'Manuel Martínez','Voz',10),(2,'Paco Ventura','Guitarra',10),(3,'Juanjo Cobacho','Bajo',10),(4,'Manuel Ibañez','Teclados',10),(5,'Nacho Santiago','Bateria',10),(6,'Javier Domínguez','Voz',9),(7,'Juan Carlos Marín','Guitarra',9),(8,'Fernando Mainer','Bajo',9),(9,'Javi Díez','Teclados',9),(10,'Txus di Fellatio','Bateria',9),(11,'Carlos Prieto','Violín',9),(12,'Carlos de Castro','Guitarra',8),(13,'Armando de Castro','Voz',8),(14,'Rafa Díaz','Bateria',8),(15,'Javier Rodríguez','Bajo',8),(16,'Ángel San Juan','Voz',7),(17,'Dan Díez','Guitarra',7),(18,'Roberto Gonzalo','Bajo',7),(19,'Juanan San Martín','Teclados',7),(20,'David Carrica','Bateria',7),(21,'Víctor García','Voz',6),(22,'Pablo García','Guitarra',6),(23,'Roberto García','Bajo',6),(24,'Rafael Yugueros','Bateria',6),(25,'Freddie Mercury','Voz',5),(26,'John Deacon','Bajo',5),(27,'Roger Taylor','Bateria',5),(28,'Brian May','Guitarra',5),(29,'Axl Rose','Voz',4),(30,'Duff McKagan','Bajo',4),(31,'Slash','Guitarra',4),(32,'Dizzy Reed','Teclados',4),(33,'Frank Ferrer','Bateria',4),(34,'Bruce Dickinson','Voz',3),(35,'Nicko McBrain','Bateria',3),(36,'Janick Gers','Guitarra',3),(37,'Steve Harris','Bajo',3),(38,'Dave Murray','Guitarra',3),(39,'Adrian Smith','Teclados',3),(40,'Angus Young','Guitarra',2),(41,'Chris Slade','Bateria',2),(42,'Stevie Young','Guitarra',2),(43,'Brian Johnson','Voz',2),(44,'James Hetfield','Voz',1),(45,'Kirk Hammett','Guitarra',1),(46,'Cliff Burton','Bajo',1),(47,'Lars Ulrich','Bateria',1);
/*!40000 ALTER TABLE `componentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos`
--

DROP TABLE IF EXISTS `grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupos` (
  `grupoId` int unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `creacion` int NOT NULL,
  `origen` varchar(45) NOT NULL,
  `genero` varchar(45) NOT NULL,
  PRIMARY KEY (`grupoId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos`
--

LOCK TABLES `grupos` WRITE;
/*!40000 ALTER TABLE `grupos` DISABLE KEYS */;
INSERT INTO `grupos` VALUES (1,'Metallica',1981,'Estados Unidos','Heavy Metal'),(2,'ACDC',1973,'Australia','Hard rock'),(3,'Iron Maiden',1975,'Reino Unido','Heavy Metal'),(4,'Guns N Roses',1985,'Estados Unidos','Hard rock'),(5,'Queen',1970,'Reino Unido','Rock'),(6,'WarCry',1996,'España','Heavy Metal'),(7,'Tierra Santa',1997,'España','Heavy Metal'),(8,'Baron Rojo',1980,'España','Hard rock'),(9,'Mago de Oz',1988,'España','Folk metal'),(10,'Medina Azahara',1979,'España','Hard rock');
/*!40000 ALTER TABLE `grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupos_componentes`
--

DROP TABLE IF EXISTS `grupos_componentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupos_componentes` (
  `Grupo_grupoId` int NOT NULL,
  `componentes_componenteId` int NOT NULL,
  UNIQUE KEY `UK_fa8hk3h42bh7v6p9yiwif5463` (`componentes_componenteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupos_componentes`
--

LOCK TABLES `grupos_componentes` WRITE;
/*!40000 ALTER TABLE `grupos_componentes` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupos_componentes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-14 21:49:15
