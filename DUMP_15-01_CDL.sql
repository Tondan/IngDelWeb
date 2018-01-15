-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: igw
-- ------------------------------------------------------
-- Server version	5.7.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cdl`
--

DROP TABLE IF EXISTS `cdl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cdl` (
  `IDCDL` int(11) NOT NULL AUTO_INCREMENT,
  `Nome_it` varchar(50) NOT NULL,
  `Nome_en` varchar(50) NOT NULL,
  `Anno` year(4) NOT NULL,
  `CFU` int(11) NOT NULL,
  `Magistrale` tinyint(4) NOT NULL DEFAULT '0',
  `Immagine` varchar(100) DEFAULT NULL,
  `Descrizione_it` longtext,
  `Descrizione_en` longtext,
  PRIMARY KEY (`IDCDL`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cdl`
--

LOCK TABLES `cdl` WRITE;
/*!40000 ALTER TABLE `cdl` DISABLE KEYS */;
INSERT INTO `cdl` VALUES (1,'inf','inf',2017,180,0,'img\\cdl\\Cyber-security-Sicurezza-informatica-2-Imc-e1483610025215.jpg','La Laurea in Informatica (3 anni) si propone di fornire allo studente un’adeguata padronanza di metodi e contenuti scientifici generali finalizzati all’inserimento nel mondo del lavoro nel settore dell’ICT (Tecnologie dell\'Informazione e della Comunicazione). ',NULL),(2,'Bio','Bio',2017,180,0,'img\\cdl\\progettazione-di-massima-piana-di-biologia-46609916.jpg','Il Corso di laurea in Scienze biologiche si propone l\'obiettivo di fornire agli studenti una solida conoscenza di base dei principali settori delle scienze biologiche e una buona padronanza delle metodologie e tecnologie inerenti ai relativi campi di indagine scientifica, offrendo una preparazione adeguata alla conoscenza e comprensione dei progressi scientifici e tecnologici relativi alle scienze della vita.','Il Corso di laurea in Scienze biologiche si propone l\'obiettivo di fornire agli studenti una solida conoscenza di base dei principali settori delle scienze biologiche e una buona padronanza delle metodologie e tecnologie inerenti ai relativi campi di indagine scientifica, offrendo una preparazione adeguata alla conoscenza e comprensione dei progressi scientifici e tecnologici relativi alle scienze della vita.'),(3,'Pippo','Pippus',2017,120,1,'\\img\\art.jpg','ashfjkdsgfjksghfdskjfgssfdgdsgfgdsghdsg','jadsjasjkldadsjklsjkasdjkdsadsajkjkladsjkljld');
/*!40000 ALTER TABLE `cdl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-15 12:17:58
