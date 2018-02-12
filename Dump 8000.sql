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
  `Magistrale` tinyint(4) NOT NULL DEFAULT '0',
  `Immagine` varchar(100) DEFAULT NULL,
  `Descrizione_it` longtext,
  `Descrizione_en` longtext,
  `Abbr_it` varchar(5) NOT NULL,
  `Abbr_en` varchar(5) NOT NULL,
  PRIMARY KEY (`IDCDL`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cdl`
--

LOCK TABLES `cdl` WRITE;
/*!40000 ALTER TABLE `cdl` DISABLE KEYS */;
INSERT INTO `cdl` VALUES (1,'inf','Computer Science',2017,180,0,'img\\cdl\\Cyber-security-Sicurezza-informatica-2-Imc-e1483610025215.jpg','La Laurea in Informatica (3 anni) si propone di fornire allo studente un’adeguata padronanza di metodi e contenuti scientifici generali finalizzati all’inserimento nel mondo del lavoro nel settore dell’ICT (Tecnologie dell\'Informazione e della Comunicazione). ','Shit','inf','c.s'),(2,'Bio','Bio',2017,180,0,'img\\cdl\\progettazione-di-massima-piana-di-biologia-46609916.jpg','Il Corso di laurea in Scienze biologiche si propone l\'obiettivo di fornire agli studenti una solida conoscenza di base dei principali settori delle scienze biologiche e una buona padronanza delle metodologie e tecnologie inerenti ai relativi campi di indagine scientifica, offrendo una preparazione adeguata alla conoscenza e comprensione dei progressi scientifici e tecnologici relativi alle scienze della vita.','Il Corso di laurea in Scienze biologiche si propone l\'obiettivo di fornire agli studenti una solida conoscenza di base dei principali settori delle scienze biologiche e una buona padronanza delle metodologie e tecnologie inerenti ai relativi campi di indagine scientifica, offrendo una preparazione adeguata alla conoscenza e comprensione dei progressi scientifici e tecnologici relativi alle scienze della vita.','bio','bio'),(3,'Pippo','Pippus',2017,120,1,'img\\art.jpg','ashfjkdsgfjksghfdskjfgssfdgdsgfgdsghdsg','jadsjasjkldadsjklsjkasdjkdsadsajkjkladsjkljld','pippo','pippo'),(4,'Vecchio','Old',2016,180,0,'img\\poetry.jpg','Roba molto vecchia',NULL,'vecch','old');
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
INSERT INTO `colleg_corsi` VALUES (1,6,'mutuato'),(19,21,'mutuato'),(22,24,'mutuato');
/*!40000 ALTER TABLE `colleg_corsi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corsi_cdl`
--

DROP TABLE IF EXISTS `corsi_cdl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corsi_cdl` (
  `Corso` int(11) NOT NULL,
  `CDL` int(11) NOT NULL,
  PRIMARY KEY (`Corso`,`CDL`),
  KEY `CDL` (`CDL`),
  CONSTRAINT `corsi_cdl_ibfk_1` FOREIGN KEY (`Corso`) REFERENCES `corso` (`IDCorso`),
  CONSTRAINT `corsi_cdl_ibfk_2` FOREIGN KEY (`CDL`) REFERENCES `cdl` (`IDCDL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corsi_cdl`
--

LOCK TABLES `corsi_cdl` WRITE;
/*!40000 ALTER TABLE `corsi_cdl` DISABLE KEYS */;
INSERT INTO `corsi_cdl` VALUES (1,1),(6,1),(19,1),(21,1),(22,1),(24,1),(3,2),(20,2),(23,2),(1,3),(19,3),(22,3),(2,4);
/*!40000 ALTER TABLE `corsi_cdl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corso`
--

DROP TABLE IF EXISTS `corso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `corso` (
  `IDCorso` int(11) NOT NULL AUTO_INCREMENT,
  `Nome_it` varchar(50) DEFAULT NULL,
  `Nome_en` varchar(50) DEFAULT NULL,
  `SSD` varchar(10) DEFAULT NULL,
  `Lingua` varchar(20) DEFAULT NULL,
  `Semestre` int(11) DEFAULT NULL,
  `CFU` int(11) DEFAULT NULL,
  `Anno` year(4) NOT NULL,
  `Tipologia` char(1) DEFAULT NULL,
  `OldID` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDCorso`),
  UNIQUE KEY `OldID` (`OldID`),
  CONSTRAINT `corso_ibfk_1` FOREIGN KEY (`OldID`) REFERENCES `corso` (`IDCorso`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corso`
--

LOCK TABLES `corso` WRITE;
/*!40000 ALTER TABLE `corso` DISABLE KEYS */;
INSERT INTO `corso` VALUES (1,'igw','igw','skl','ita',2,6,2017,'B',NULL),(2,'aaaaaaaa','aaaaaaaaaaaa','aaaaaaaa','aaaaaa',2,23,2016,'c',NULL),(3,'erbristeria','erboristeriainfsghi','adsd','it',2,30,2017,'A',NULL),(6,'Robaccia','Shit','jjsjso','en',2,8,2017,'A',NULL),(7,'Robaccia','','','',0,0,0000,'',NULL),(8,'Robaccia','','','',0,0,0000,NULL,NULL),(9,'Robaccia','','','',0,0,0000,NULL,NULL),(10,'Robaccia','','','',0,0,0000,'',NULL),(11,'Bobbe Malle','','','',0,0,0000,'',NULL),(12,'Bestiaccia','','','',0,0,0000,'',NULL),(13,'DRTFTTgfg','','','',0,0,0000,'',NULL),(14,'dsffewfw','','','',0,0,0000,'',NULL),(15,'dssdsswf','','','',0,0,0000,'',NULL),(16,'Drift','','','',0,0,0000,'',NULL),(17,'Drift','','','',0,0,0000,'',NULL),(18,'Drift','','','',0,0,0000,'',NULL),(19,'igw','igw','skl','ita',2,6,2018,'B',1),(20,'erbristeria','erboristeriainfsghi','adsd','it',2,30,2018,'A',3),(21,'Robaccia','Shit','jjsjso','en',2,8,2018,'A',6),(22,'igw','igw','skl','ita',2,6,2019,'B',19),(23,'erbristeria','erboristeriainfsghi','adsd','it',2,30,2019,'A',20),(24,'Robaccia','Shit','jjsjso','en',2,8,2019,'A',21);
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
  `Obiettivi` text NOT NULL,
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
INSERT INTO `descrizione_en` VALUES (1,'aaa','aaa','aaaa','aaa','aaa','aa','aaaaaa',NULL,NULL),(19,'aaa','aaa','aaaa','aaa','aaa','aa','aaaaaa',NULL,NULL),(22,'aaa','aaa','aaaa','aaa','aaa','aa','aaaaaa',NULL,NULL);
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
  `Obiettivi` text NOT NULL,
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
INSERT INTO `descrizione_it` VALUES (1,'aaa','aaa','aaaa','aaa','aaa','aa','aaaaaa',NULL,NULL),(6,'taiel','fggdg','ghfhth','hhtht','dhhthf','hy','rhhhrtygf','hgfdht','dhhdhdtr'),(19,'aaa','aaa','aaaa','aaa','aaa','aa','aaaaaa',NULL,NULL),(21,'taiel','fggdg','ghfhth','hhtht','dhhthf','hy','rhhhrtygf','hgfdht','dhhdhdtr'),(22,'aaa','aaa','aaaa','aaa','aaa','aa','aaaaaa',NULL,NULL),(24,'taiel','fggdg','ghfhth','hhtht','dhhthf','hy','rhhhrtygf','hgfdht','dhhdhdtr');
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
  `Email` varchar(50) DEFAULT NULL,
  `Ufficio` varchar(50) DEFAULT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  `Specializzazione` varchar(50) DEFAULT NULL,
  `Ricerche` text,
  `Pubblicazioni` text,
  `Curriculum` text,
  `Ricevimento` text,
  PRIMARY KEY (`IDDocente`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (1,'img/teacher_2_small.jpg','Giuseppe','Della Penna','dsjfkns@dfdsfks.ds','dsl','441225632','Web Enginereeng','arabo','arabo','curriculum/curriculum1.txt','Lun 8:00'),(2,'img/teacher_2_small.jpg','Bestia','DeSatana','bestiadesatana@fanculo.com','inferno','666666666999999','Dolore','asasddas','adad','C:\\Users\\Chris-PC\\Desktop\\curriculum.txt','Lun 6:66'),(3,NULL,'Chris','Toni',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(7,NULL,'Lollo','Brigido','','','','','<ul>\r\n<li>cdsvfdfd</li>\r\n<li><strong>fdgdfgdfgre</strong></li>\r\n<li><em>ghjgjtygj</em></li>\r\n<li><span style=\"text-decoration: underline;\">fgdgdgdfg</span></li>\r\n<li><span style=\"text-decoration: line-through;\"><span style=\"text-decoration: underline;\">fafdfsfewrfs</span></span></li>\r\n<li>hdfghd<sup>gdfsgdgds</sup></li>\r\n<li><sup>fafewfasfsa</sup><sub>fasdfsfeafasd</sub></li>\r\n<li><code>dfsgfdesgrsg</code></li>\r\n<li>\r\n<h1>fassfsfds</h1>\r\n</li>\r\n<li>\r\n<h4>gfdfgsgresag</h4>\r\n</li>\r\n<li>\r\n<h4 style=\"text-align: right;\">gdfsgsgresgdsgs</h4>\r\n</li>\r\n<li>\r\n<h4 style=\"text-align: right;\">fdasgsgsgdfses<code></code></h4>\r\n</li>\r\n</ul>','',NULL,''),(8,NULL,'Palla','Bella','','','','','&lt;ul&gt;\r\n&lt;li&gt;dsgfd&lt;/li&gt;\r\n&lt;li&gt;&amp;ugrave;gretgd&lt;/li&gt;\r\n&lt;li&gt;&lt;strong&gt;hedrhtrhfg&lt;/strong&gt;&lt;/li&gt;\r\n&lt;/ul&gt;','',NULL,''),(9,NULL,'Ancora','Vivo','','','','','<ul>\r\n<li>dfgfdgd</li>\r\n<li>gdregdg</li>\r\n<li><strong>gdgdgdgr</strong></li>\r\n</ul>','',NULL,''),(12,'imgDocenti\\baby_groot-2560x1440.jpg','groot','groot','','','','','','','curriculum\\curriculum.txt',''),(22,NULL,'Babbo','Boia','','','','','','',NULL,''),(23,'imgDocenti\\BobbeMalle.jpg','Bobbe','Malle','','','','','','',NULL,''),(24,'imgDocenti\\BobbeMalle1.jpg','Bobbe','Malle','','','','','','',NULL,''),(25,'imgDocenti\\BestiaSat.jpg','Bestia','Sat','','','','','','',NULL,''),(26,'imgDocenti\\BestiaSat1.jpg','Bestia','Sat','','','','','','',NULL,''),(27,'imgDocenti\\BobbeMalle2.jpg','Bobbe','Malle','','','','','','','curriculum\\BobbeMalle.pdf',''),(28,'imgDocenti\\BobbeMalle3.jpg','Bobbe','Malle','','','','','','','curriculum\\BobbeMalle1.pdf',''),(29,'imgDocenti\\BobbeMalle4.jpg','Bobbe','Malle','','','','','','','curriculum\\BobbeMalle2.pdf','');
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
INSERT INTO `docenti_corso` VALUES (1,1),(19,1),(22,1),(1,2),(18,2),(19,2),(22,2),(18,3);
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
INSERT INTO `dublino_en` VALUES (1,'aaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaa'),(19,'aaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaa'),(22,'aaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaa');
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
INSERT INTO `dublino_it` VALUES (1,'aaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaa'),(6,'fdh','rhdehr','hrhrth','fherhr','hrfhrthr'),(19,'aaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaa'),(21,'fdh','rhdehr','hrhrth','fherhr','hrfhrthr'),(22,'aaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaa'),(24,'fdh','rhdehr','hrhrth','fherhr','hrfhrthr');
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
INSERT INTO `group_services` VALUES (1,1),(2,2),(1,3),(1,4),(2,5),(1,6),(1,7),(1,8),(1,9);
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gruppo`
--

LOCK TABLES `gruppo` WRITE;
/*!40000 ALTER TABLE `gruppo` DISABLE KEYS */;
INSERT INTO `gruppo` VALUES (1,'Amministratori'),(2,'Docenti');
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
INSERT INTO `libri_corso` VALUES (1,1),(19,1),(22,1);
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
  `Volume` int(11) DEFAULT NULL,
  `Anno` year(4) NOT NULL,
  `Editore` varchar(50) DEFAULT NULL,
  `Link` text,
  PRIMARY KEY (`IDLibro`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'Bestiaccia','Ingegneria',1,2010,'Satana','ndfsknf');
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
  `Descrizione_it` varchar(50) DEFAULT NULL,
  `Descrizione_en` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IDMateriale`),
  KEY `Corso` (`Corso`),
  CONSTRAINT `materiale_ibfk_1` FOREIGN KEY (`Corso`) REFERENCES `corso` (`IDCorso`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiale`
--

LOCK TABLES `materiale` WRITE;
/*!40000 ALTER TABLE `materiale` DISABLE KEYS */;
INSERT INTO `materiale` VALUES (1,1,'Roba','img/art.jpg','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa','Roba roba roba tanta tanta '),(2,1,'Immagine','img/baby_groot-2560x1440.jpg','Bella Immagine','Nice Image'),(3,19,'Roba','img/art.jpg','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa','Roba roba roba tanta tanta '),(4,19,'Immagine','img/baby_groot-2560x1440.jpg','Bella Immagine','Nice Image'),(6,22,'Roba','img/art.jpg','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa','Roba roba roba tanta tanta '),(7,22,'Immagine','img/baby_groot-2560x1440.jpg','Bella Immagine','Nice Image');
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
  PRIMARY KEY (`IDServizio`),
  UNIQUE KEY `Script_UNIQUE` (`Script`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servizio`
--

LOCK TABLES `servizio` WRITE;
/*!40000 ALTER TABLE `servizio` DISABLE KEYS */;
INSERT INTO `servizio` VALUES (1,'Backoffice',NULL),(2,'BackofficeD',NULL),(3,'CreateCorso',NULL),(4,'CreateCDL',NULL),(5,'CreateCorsoD',NULL),(6,'ModificaCorso',NULL),(7,'RegisterDocente',NULL),(8,'Profile',NULL),(9,'Corsianno',NULL);
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
  `Username` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Docente` int(11) DEFAULT NULL,
  `Gruppo` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDUtente`),
  UNIQUE KEY `Username_UNIQUE` (`Username`),
  UNIQUE KEY `Docente_UNIQUE` (`Docente`),
  KEY `utente_ibfk_2` (`Docente`),
  KEY `Gruppo` (`Gruppo`),
  CONSTRAINT `utente_ibfk_1` FOREIGN KEY (`Gruppo`) REFERENCES `gruppo` (`IDGruppo`),
  CONSTRAINT `utente_ibfk_2` FOREIGN KEY (`Docente`) REFERENCES `docente` (`IDDocente`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'admin','password',NULL,1),(5,'lobr','wOHilaKvoL',7,2),(6,'pabe','5XmtrPpRSz',8,2),(7,'anvi','zhM0XtHJWS',9,2),(10,'grgr','MX3MUkFiu9',12,2),(20,'babo','OY41Pz3Ptp',22,2),(22,'boma','7CI6jMb2j8',24,2),(24,'besa','sE7KdnEhEb',26,2),(28,'gidp','password',1,2);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'igw'
--
/*!50106 SET @save_time_zone= @@TIME_ZONE */ ;
/*!50106 DROP EVENT IF EXISTS `new_corsi_year` */;
DELIMITER ;;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;;
/*!50003 SET character_set_client  = utf8 */ ;;
/*!50003 SET character_set_results = utf8 */ ;;
/*!50003 SET collation_connection  = utf8_general_ci */ ;;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ ;;
/*!50003 SET @saved_time_zone      = @@time_zone */ ;;
/*!50003 SET time_zone             = 'SYSTEM' */ ;;
/*!50106 CREATE*/ /*!50117 DEFINER=`root`@`localhost`*/ /*!50106 EVENT `new_corsi_year` ON SCHEDULE EVERY 1 YEAR STARTS '2018-08-01 03:00:00' ON COMPLETION PRESERVE ENABLE DO BEGIN
			CREATE TEMPORARY TABLE tmpCorso
				SELECT * FROM Corso WHERE Anno=YEAR(NOW())-1;
				UPDATE tmpCorso SET OldID=IDCorso;
				ALTER TABLE tmpCorso DROP IDCorso; # Drop autoincrement field
				UPDATE tmpCorso SET Anno=YEAR(NOW()) WHERE Anno=YEAR(NOW())-1;
				INSERT INTO Corso SELECT 0,tmpCorso.* FROM tmpCorso;
				DROP TEMPORARY TABLE tmpCorso;

			CREATE TEMPORARY TABLE tmpCorsi_CDL
				SELECT corsi_cdl.Corso,CDL FROM Corsi_CDL,Corso WHERE Corso.IDCorso=corsi_cdl.Corso AND Anno=YEAR(NOW())-1;
				UPDATE tmpCorsi_CDL SET Corso=(SELECT IDCorso FROM Corso WHERE OldID=tmpCorsi_CDL.Corso);
				INSERT INTO Corsi_CDL SELECT tmpCorsi_CDL.* FROM tmpCorsi_CDL;
				DROP TEMPORARY TABLE tmpCorsi_CDL;
				
			CREATE TEMPORARY TABLE tmpColleg_Corsi
				SELECT colleg_corsi.* FROM Corso,Colleg_Corsi WHERE IDCorso=This_Corso AND Anno=YEAR(NOW())-1;
				UPDATE tmpColleg_Corsi SET This_Corso=(SELECT IDCorso FROM Corso WHERE OldID=This_Corso), Other_Corso=(SELECT IDCorso FROM Corso WHERE OldID=Other_Corso);
				INSERT INTO Colleg_Corsi SELECT tmpColleg_Corsi.* FROM tmpColleg_Corsi;
				DROP TEMPORARY TABLE tmpColleg_Corsi;
				
			CREATE TEMPORARY TABLE tmpDocenti_Corso
				SELECT Corso,Docente FROM Docenti_Corso,Corso WHERE Corso=IDCorso AND Anno=YEAR(NOW())-1;
				UPDATE tmpDocenti_Corso SET Corso=(SELECT IDCorso FROM Corso WHERE OldID=Corso);
				INSERT INTO Docenti_Corso SELECT tmpDocenti_Corso.* FROM tmpDocenti_Corso;
				DROP TEMPORARY TABLE tmpDocenti_Corso;
				
			CREATE TEMPORARY TABLE tmpDescrizione_it
				SELECT Corso,Prerequisiti,Obiettivi,Mod_Esame,Mod_Insegnamento,Sillabo,Note,Homepage,Forum,Risorse_ext FROM Descrizione_it,Corso WHERE Corso=IDCorso AND Anno=YEAR(NOW())-1;
				UPDATE tmpDescrizione_it SET Corso=(SELECT IDCorso FROM Corso WHERE OldID=Corso);
				INSERT INTO Descrizione_it SELECT tmpDescrizione_it.* FROM tmpDescrizione_it;
				DROP TEMPORARY TABLE tmpDescrizione_it;
				
			CREATE TEMPORARY TABLE tmpDescrizione_en
				SELECT Corso,Prerequisiti,Obiettivi,Mod_Esame,Mod_Insegnamento,Sillabo,Note,Homepage,Forum,Risorse_ext FROM Descrizione_en,Corso WHERE Corso=IDCorso AND Anno=YEAR(NOW())-1;
				UPDATE tmpDescrizione_en SET Corso=(SELECT IDCorso FROM Corso WHERE OldID=Corso);
				INSERT INTO Descrizione_en SELECT tmpDescrizione_en.* FROM tmpDescrizione_en;
				DROP TEMPORARY TABLE tmpDescrizione_en;
				
			CREATE TEMPORARY TABLE tmpDublino_it
				SELECT Corso,Knowledge,Application,Evaluation,Communication,Lifelong FROM Dublino_it,Corso WHERE Corso=IDCorso AND Anno=YEAR(NOW())-1;
				UPDATE tmpDublino_it SET Corso=(SELECT IDCorso FROM Corso WHERE OldID=Corso);
				INSERT INTO Dublino_it SELECT tmpDublino_it.* FROM tmpDublino_it;
				DROP TEMPORARY TABLE tmpDublino_it;
				
			CREATE TEMPORARY TABLE tmpDublino_en
				SELECT Corso,Knowledge,Application,Evaluation,Communication,Lifelong FROM Dublino_en,Corso WHERE Corso=IDCorso AND Anno=YEAR(NOW())-1;
				UPDATE tmpDublino_en SET Corso=(SELECT IDCorso FROM Corso WHERE OldID=Corso);
				INSERT INTO Dublino_en SELECT tmpDublino_en.* FROM tmpDublino_en;
				DROP TEMPORARY TABLE tmpDublino_en;
				
			CREATE TEMPORARY TABLE tmpMateriale
				SELECT IDMateriale,Corso,Nome,Link,Descrizione_it,Descrizione_en FROM Materiale,Corso WHERE Corso=IDCorso AND Anno=YEAR(NOW())-1;
				UPDATE tmpMateriale SET Corso=(SELECT IDCorso FROM Corso WHERE OldID=Corso);
				ALTER TABLE tmpMateriale DROP IDMateriale;
				INSERT INTO Materiale SELECT 0,tmpMateriale.* FROM tmpMateriale;
				DROP TEMPORARY TABLE tmpMateriale;
				
			CREATE TEMPORARY TABLE tmpLibri_Corso
				SELECT Corso,Libro FROM Libri_Corso,Corso WHERE Corso=IDCorso AND Anno=YEAR(NOW())-1;
				UPDATE tmpLibri_Corso SET Corso=(SELECT IDCorso FROM Corso WHERE OldID=Corso);
				INSERT INTO Libri_Corso SELECT tmpLibri_Corso.* FROM tmpLibri_Corso;
				DROP TEMPORARY TABLE tmpLibri_Corso;
		END */ ;;
/*!50003 SET time_zone             = @saved_time_zone */ ;;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;;
/*!50003 SET character_set_client  = @saved_cs_client */ ;;
/*!50003 SET character_set_results = @saved_cs_results */ ;;
/*!50003 SET collation_connection  = @saved_col_connection */ ;;
DELIMITER ;
/*!50106 SET TIME_ZONE= @save_time_zone */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-12 13:00:19
