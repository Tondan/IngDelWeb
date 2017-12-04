CREATE DATABASE  IF NOT EXISTS `igw` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `igw`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: igw
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
  PRIMARY KEY (`IDCDL`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cdl`
--

LOCK TABLES `cdl` WRITE;
/*!40000 ALTER TABLE `cdl` DISABLE KEYS */;
INSERT INTO `cdl` VALUES (1,'inf','inf',2010,180);
/*!40000 ALTER TABLE `cdl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colleg_corsi`
--

DROP TABLE IF EXISTS `colleg_corsi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colleg_corsi` (
  `This_Corso` int(11) NOT NULL,
  `Other_Corso` int(11) NOT NULL,
  `Tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`This_Corso`,`Other_Corso`),
  KEY `Other_Corso` (`Other_Corso`),
  CONSTRAINT `colleg_corsi_ibfk_1` FOREIGN KEY (`This_Corso`) REFERENCES `corso` (`IDCorso`),
  CONSTRAINT `colleg_corsi_ibfk_2` FOREIGN KEY (`Other_Corso`) REFERENCES `corso` (`IDCorso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colleg_corsi`
--

LOCK TABLES `colleg_corsi` WRITE;
/*!40000 ALTER TABLE `colleg_corsi` DISABLE KEYS */;
/*!40000 ALTER TABLE `colleg_corsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corso`
--

DROP TABLE IF EXISTS `corso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corso` (
  `IDCorso` int(11) NOT NULL AUTO_INCREMENT,
  `CDL` int(11) NOT NULL,
  `Nome_it` varchar(50) NOT NULL,
  `Nome_en` varchar(50) NOT NULL,
  `SSD` varchar(10) NOT NULL,
  `Lingua` varchar(20) NOT NULL,
  `Semestre` int(11) NOT NULL,
  `CFU` int(11) NOT NULL,
  `Anno` year(4) NOT NULL,
  `Tipologia` char(1) DEFAULT NULL,
  PRIMARY KEY (`IDCorso`),
  KEY `CDL` (`CDL`),
  CONSTRAINT `corso_ibfk_1` FOREIGN KEY (`CDL`) REFERENCES `cdl` (`IDCDL`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corso`
--

LOCK TABLES `corso` WRITE;
/*!40000 ALTER TABLE `corso` DISABLE KEYS */;
INSERT INTO `corso` VALUES (1,1,'igw','igw','skl','ita',2,6,2010,'B');
/*!40000 ALTER TABLE `corso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descrizione_en`
--

DROP TABLE IF EXISTS `descrizione_en`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descrizione_en` (
  `Corso` int(11) NOT NULL,
  `Prerequisiti` text NOT NULL,
  `Obiettivi` text,
  `Mod_Esame` text NOT NULL,
  `Mod_Insegnamento` text NOT NULL,
  `Sillabo` text NOT NULL,
  `Note` text,
  `Homepage` text,
  `Forum` text,
  `Risorse_ext` text,
  PRIMARY KEY (`Corso`),
  CONSTRAINT `descrizione_en_ibfk_1` FOREIGN KEY (`Corso`) REFERENCES `corso` (`IDCorso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descrizione_en`
--

LOCK TABLES `descrizione_en` WRITE;
/*!40000 ALTER TABLE `descrizione_en` DISABLE KEYS */;
/*!40000 ALTER TABLE `descrizione_en` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descrizione_it`
--

DROP TABLE IF EXISTS `descrizione_it`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descrizione_it` (
  `Corso` int(11) NOT NULL,
  `Prerequisiti` text NOT NULL,
  `Obiettivi` text,
  `Mod_Esame` text NOT NULL,
  `Mod_Insegnamento` text NOT NULL,
  `Sillabo` text NOT NULL,
  `Note` text,
  `Homepage` text,
  `Forum` text,
  `Risorse_ext` text,
  PRIMARY KEY (`Corso`),
  CONSTRAINT `descrizione_it_ibfk_1` FOREIGN KEY (`Corso`) REFERENCES `corso` (`IDCorso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descrizione_it`
--

LOCK TABLES `descrizione_it` WRITE;
/*!40000 ALTER TABLE `descrizione_it` DISABLE KEYS */;
/*!40000 ALTER TABLE `descrizione_it` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docente` (
  `IDDocente` int(11) NOT NULL AUTO_INCREMENT,
  `Immagine` text,
  `Nome` varchar(20) NOT NULL,
  `Cognome` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Ufficio` varchar(50) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Specializzazione` varchar(50) NOT NULL,
  `Ricerche` text,
  `Pubblicazioni` text,
  `Curriculum` text,
  `Ricevimento` text NOT NULL,
  PRIMARY KEY (`IDDocente`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (1,'img/teacher_2_small.jpg','Giuseppe','Della Penna','dsjfkns@dfdsfks.ds','dsl','441225632','Web Enginereeng',NULL,NULL,NULL,'Lun 8:00'),(2,'img/teacher_2_small.jpg','Bestia','DeSatana','bestiadesatana@fanculo.com','inferno','666666666999999','Dolore',NULL,NULL,NULL,'Lun 6:66');
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docenti_corso`
--

DROP TABLE IF EXISTS `docenti_corso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docenti_corso` (
  `Corso` int(11) NOT NULL,
  `Docente` int(11) NOT NULL,
  PRIMARY KEY (`Corso`,`Docente`),
  KEY `Docente` (`Docente`),
  CONSTRAINT `docenti_corso_ibfk_1` FOREIGN KEY (`Corso`) REFERENCES `corso` (`IDCorso`),
  CONSTRAINT `docenti_corso_ibfk_2` FOREIGN KEY (`Docente`) REFERENCES `docente` (`IDDocente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docenti_corso`
--

LOCK TABLES `docenti_corso` WRITE;
/*!40000 ALTER TABLE `docenti_corso` DISABLE KEYS */;
/*!40000 ALTER TABLE `docenti_corso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dublino_en`
--

DROP TABLE IF EXISTS `dublino_en`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dublino_en` (
  `Corso` int(11) NOT NULL,
  `Knowledge` text,
  `Application` text,
  `Evaluation` text,
  `Communication` text,
  `Lifelong` text,
  PRIMARY KEY (`Corso`),
  CONSTRAINT `dublino_en_ibfk_1` FOREIGN KEY (`Corso`) REFERENCES `corso` (`IDCorso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dublino_en`
--

LOCK TABLES `dublino_en` WRITE;
/*!40000 ALTER TABLE `dublino_en` DISABLE KEYS */;
/*!40000 ALTER TABLE `dublino_en` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dublino_it`
--

DROP TABLE IF EXISTS `dublino_it`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dublino_it` (
  `Corso` int(11) NOT NULL,
  `Knowledge` text,
  `Application` text,
  `Evaluation` text,
  `Communication` text,
  `Lifelong` text,
  PRIMARY KEY (`Corso`),
  CONSTRAINT `dublino_it_ibfk_1` FOREIGN KEY (`Corso`) REFERENCES `corso` (`IDCorso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dublino_it`
--

LOCK TABLES `dublino_it` WRITE;
/*!40000 ALTER TABLE `dublino_it` DISABLE KEYS */;
/*!40000 ALTER TABLE `dublino_it` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group_services`
--

DROP TABLE IF EXISTS `group_services`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `group_services` (
  `Gruppo` int(11) NOT NULL,
  `Servizio` int(11) NOT NULL,
  PRIMARY KEY (`Gruppo`,`Servizio`),
  KEY `Servizio` (`Servizio`),
  CONSTRAINT `group_services_ibfk_1` FOREIGN KEY (`Gruppo`) REFERENCES `gruppo` (`IDGruppo`),
  CONSTRAINT `group_services_ibfk_2` FOREIGN KEY (`Servizio`) REFERENCES `servizio` (`IDServizio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_services`
--

LOCK TABLES `group_services` WRITE;
/*!40000 ALTER TABLE `group_services` DISABLE KEYS */;
/*!40000 ALTER TABLE `group_services` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gruppo`
--

DROP TABLE IF EXISTS `gruppo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gruppo` (
  `IDGruppo` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`IDGruppo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruppo`
--

LOCK TABLES `gruppo` WRITE;
/*!40000 ALTER TABLE `gruppo` DISABLE KEYS */;
/*!40000 ALTER TABLE `gruppo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libri_corso`
--

DROP TABLE IF EXISTS `libri_corso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libri_corso` (
  `Corso` int(11) NOT NULL,
  `Libro` int(11) NOT NULL,
  PRIMARY KEY (`Corso`,`Libro`),
  KEY `Libro` (`Libro`),
  CONSTRAINT `libri_corso_ibfk_1` FOREIGN KEY (`Corso`) REFERENCES `corso` (`IDCorso`),
  CONSTRAINT `libri_corso_ibfk_2` FOREIGN KEY (`Libro`) REFERENCES `libro` (`IDLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libri_corso`
--

LOCK TABLES `libri_corso` WRITE;
/*!40000 ALTER TABLE `libri_corso` DISABLE KEYS */;
/*!40000 ALTER TABLE `libri_corso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro` (
  `IDLibro` int(11) NOT NULL AUTO_INCREMENT,
  `Autore` varchar(20) NOT NULL,
  `Titolo` varchar(50) NOT NULL,
  `Volume` varchar(20) DEFAULT NULL,
  `Anno` year(4) NOT NULL,
  `Editore` varchar(50) DEFAULT NULL,
  `Link` text,
  PRIMARY KEY (`IDLibro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `IDLog` int(11) NOT NULL AUTO_INCREMENT,
  `Utente` int(11) NOT NULL,
  `Data` date NOT NULL,
  `Descrizione` text,
  PRIMARY KEY (`IDLog`),
  KEY `Utente` (`Utente`),
  CONSTRAINT `log_ibfk_1` FOREIGN KEY (`Utente`) REFERENCES `utente` (`IDUtente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materiale`
--

DROP TABLE IF EXISTS `materiale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `materiale` (
  `IDMateriale` int(11) NOT NULL AUTO_INCREMENT,
  `Corso` int(11) DEFAULT NULL,
  `Nome` varchar(20) NOT NULL,
  `Link` text NOT NULL,
  `Descrizione_it` text,
  `Descizione_en` text,
  PRIMARY KEY (`IDMateriale`),
  KEY `Corso` (`Corso`),
  CONSTRAINT `materiale_ibfk_1` FOREIGN KEY (`Corso`) REFERENCES `corso` (`IDCorso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiale`
--

LOCK TABLES `materiale` WRITE;
/*!40000 ALTER TABLE `materiale` DISABLE KEYS */;
/*!40000 ALTER TABLE `materiale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servizio`
--

DROP TABLE IF EXISTS `servizio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `servizio` (
  `IDServizio` int(11) NOT NULL AUTO_INCREMENT,
  `Script` varchar(50) NOT NULL,
  `Descrizione` text,
  PRIMARY KEY (`IDServizio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servizio`
--

LOCK TABLES `servizio` WRITE;
/*!40000 ALTER TABLE `servizio` DISABLE KEYS */;
/*!40000 ALTER TABLE `servizio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utente` (
  `IDUtente` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(20) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Email` varchar(50) DEFAULT NULL,
  `Gruppo` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDUtente`),
  KEY `Gruppo` (`Gruppo`),
  CONSTRAINT `utente_ibfk_1` FOREIGN KEY (`Gruppo`) REFERENCES `gruppo` (`IDGruppo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-05  0:30:37