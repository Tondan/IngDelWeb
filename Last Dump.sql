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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cdl`
--

LOCK TABLES `cdl` WRITE;
/*!40000 ALTER TABLE `cdl` DISABLE KEYS */;
INSERT INTO `cdl` VALUES (1,'inf','Computer Science',2017,180,0,'img\\cdl\\Cyber-security-Sicurezza-informatica-2-Imc-e1483610025215.jpg','La Laurea in Informatica (3 anni) si propone di fornire allo studente un’adeguata padronanza di metodi e contenuti scientifici generali finalizzati all’inserimento nel mondo del lavoro nel settore dell’ICT (Tecnologie dell\'Informazione e della Comunicazione). ','Shit','inf','c.s'),(2,'Bio','Bio',2017,180,0,'img\\cdl\\progettazione-di-massima-piana-di-biologia-46609916.jpg','Il Corso di laurea in Scienze biologiche si propone l\'obiettivo di fornire agli studenti una solida conoscenza di base dei principali settori delle scienze biologiche e una buona padronanza delle metodologie e tecnologie inerenti ai relativi campi di indagine scientifica, offrendo una preparazione adeguata alla conoscenza e comprensione dei progressi scientifici e tecnologici relativi alle scienze della vita.','Il Corso di laurea in Scienze biologiche si propone l\'obiettivo di fornire agli studenti una solida conoscenza di base dei principali settori delle scienze biologiche e una buona padronanza delle metodologie e tecnologie inerenti ai relativi campi di indagine scientifica, offrendo una preparazione adeguata alla conoscenza e comprensione dei progressi scientifici e tecnologici relativi alle scienze della vita.','bio','bio'),(3,'Pippo','Pippus',2017,120,1,'img\\art.jpg','ashfjkdsgfjksghfdskjfgssfdgdsgfgdsghdsg','jadsjasjkldadsjklsjkasdjkdsadsajkjkladsjkljld','pippo','pippo'),(4,'VECCHIACCIO','OLDER',2016,1805,1,'imgCDL\\VECCHIACCIO.jpg','<p>LA BAMBAAAAA</p>','<p>&ograve;LA BOMBAAA</p>','VEC','OLDN'),(5,'ROBA NUOVAA','NEW STUFFd',2018,180,1,'imgCDL\\Roba Nuova.jpg','<ul>\r\n<li>dadadswdas</li>\r\n</ul>','<p><strong>dfaesdewdf</strong></p>','R. N.','N. S.'),(6,'Tanta Roba','',2018,0,1,'imgCDL\\Tanta Roba.jpg','','','T.R.',''),(7,'Robaccia','',2018,0,1,'imgCDL\\Robaccia.jpg','','','Rob',''),(8,'Roba Nuova','',2018,0,0,'imgCDL\\Roba Nuova.jpg','','','R.N.',''),(9,'GTA','GTA',2018,0,1,'imgCDL\\GTA.jpg','','','GTA','GTA'),(10,'  ','Bah',2018,180,1,'imgCDL\\Tanta Roba.jpg','  DIta','DEN','  ','Bah'),(11,'','sfsdf',2018,0,0,NULL,'','','hdhdf','dhhd'),(12,'DFG','hgfdh',2018,7,1,'','','','dh','DGF');
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
INSERT INTO `colleg_corsi` VALUES (1,6,'mutuato'),(19,21,'mutuato'),(22,24,'mutuato'),(28,1,'modulo'),(28,6,'propedeudico'),(28,35,'mutuato'),(41,1,'mutuato'),(43,1,'propedeudico'),(48,32,'mutuato'),(49,1,'modulo'),(49,6,'mutuato'),(50,1,'propedeudico'),(50,6,'modulo'),(50,32,'mutuato'),(57,3,'propedeudico'),(57,32,'mutuato');
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
INSERT INTO `corsi_cdl` VALUES (1,1),(6,1),(19,1),(21,1),(22,1),(24,1),(39,1),(41,1),(42,1),(43,1),(44,1),(48,1),(49,1),(50,1),(51,1),(52,1),(53,1),(54,1),(55,1),(56,1),(63,1),(3,2),(20,2),(23,2),(38,2),(57,2),(58,2),(59,2),(60,2),(1,3),(19,3),(22,3),(40,3),(2,4),(29,9),(30,9),(31,9),(34,9),(35,9),(36,9),(45,9),(46,9),(47,9);
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
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corso`
--

LOCK TABLES `corso` WRITE;
/*!40000 ALTER TABLE `corso` DISABLE KEYS */;
INSERT INTO `corso` VALUES (1,'igw','igw','SKL','ita',2,6,2017,'B',NULL),(2,'aaaaaaaa','aaaaaaaaaaaa','aaaaaaaa','aaaaaa',2,23,2016,'c',NULL),(3,'erbristeria','erboristeriainfsghi','ADSD','it',2,30,2017,'A',NULL),(6,'Robaccia','Shit','jjsjso','en',2,8,2017,'A',NULL),(7,'Robaccia','','','',0,0,0000,'',NULL),(8,'Robaccia','','','',0,0,0000,NULL,NULL),(9,'Robaccia','','','',0,0,0000,NULL,NULL),(10,'Robaccia','','','',0,0,0000,'',NULL),(11,'Bobbe Malle','','','',0,0,0000,'',NULL),(12,'Bestiaccia','','','',0,0,0000,'',NULL),(13,'DRTFTTgfg','','','',0,0,0000,'',NULL),(14,'dsffewfw','','','',0,0,0000,'',NULL),(15,'dssdsswf','','','',0,0,0000,'',NULL),(16,'Drift','','','',0,0,0000,'',NULL),(17,'Drift','','','',0,0,0000,'',NULL),(18,'Drift','','','',0,0,0000,'',NULL),(19,'igw','igw','skl','ita',2,6,2018,'B',1),(20,'erbristeria','erboristeriainfsghi','adsd','it',2,30,2018,'A',3),(21,'Robaccia','Shit','jjsjso','en',2,8,2018,'A',6),(22,'igw','igw','skl','ita',2,6,2019,'B',19),(23,'erbristeria','erboristeriainfsghi','adsd','it',2,30,2019,'A',20),(24,'Robaccia','Shit','jjsjso','en',2,8,2019,'A',21),(25,'Drift','Drift','Ahdh','Ita',1,6,0000,'A',NULL),(26,'Roba Nuova','New Stuff','Ahdh','dgd',1,6,2018,'B',NULL),(27,'Roba Nuova','New Stuff','Ahdh','dgd',1,6,2018,'B',NULL),(28,'Roba Nuovaa','New Stufff','AHDHF','dgdfdd',2,60,2018,'A',NULL),(29,'Cacca','','','',0,0,2018,'',NULL),(30,'Cacca','','','',2,0,2018,'',NULL),(31,'Cacca','','','',2,0,2018,'',NULL),(32,'Cacca','','','',0,0,2017,'',NULL),(33,'Cacca','Shit','Bah','Ingl',2,180,2017,'A',NULL),(34,'Cacca','','','',1,0,2018,'',NULL),(35,'Cacca','Shit','BAH','Ingl',2,180,2017,'A',NULL),(36,'Cacca','','','',0,0,2018,'',NULL),(38,'cccc','','','',0,0,2018,'',NULL),(39,'aaaaaaaa','aaaaaaa','','',0,0,2018,'',NULL),(40,'nodo','','','',0,0,2018,'',NULL),(41,'cccc','','','',0,0,2018,'',NULL),(42,'aaaasssss','','','',0,0,2018,'',NULL),(43,'Roba Nuova','','','',0,0,2018,'',NULL),(44,'noco','','','',0,0,2018,'',NULL),(45,'nuova','','','',0,0,2018,'',NULL),(46,'adddd','','','',0,0,2018,'',NULL),(47,'vmhnjhj','','','',0,0,2018,'',NULL),(48,'dddffdf','','','',0,0,2018,'',NULL),(49,'cccaccaaaa','','','',0,0,2018,'',NULL),(50,'xxxxxxx','','','',0,0,2018,'',NULL),(51,'sdfdccccc','','','',0,0,2018,'',NULL),(52,'bdgfsstgdrsthtdhf','','','',0,0,2018,'',NULL),(53,'ffdfv','','','',0,0,2018,'',NULL),(54,'vfdccccdddg','','','',0,0,2018,'',NULL),(55,'rgfedegfsdtgrew','','','',0,0,2018,'',NULL),(56,'dfsgdsfgds','','','',0,0,2018,'',NULL),(57,'dfdgsdsgsdgdsg','rtghds','sfh','rtshr',1,5020,2018,'A',NULL),(58,'fasdfdsgfsdg','','','',0,0,2018,'',NULL),(59,'dsfdfsgsdg','','','',0,0,2018,'',NULL),(60,'ccc','','','',0,0,2018,'',NULL),(63,'cccccc','gdfgdgdgdgdg','DGFGGSDF','ggg',1,14,2017,'B',NULL);
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
INSERT INTO `descrizione_en` VALUES (1,'<p>aaa</p>','<p>aaa</p>','','','<p>aaa</p>','<p>aa</p>','aaaaaa',' ',' '),(19,'aaa','aaa','aaaa','aaa','aaa','aa','aaaaaa',' ',' '),(22,'aaa','aaa','aaaa','aaa','aaa','aa','aaaaaa',' ',' '),(28,'<p>hrdhdrfehreh</p>','<p>rehrehehghfd</p>','','','<p>rtjrtgjrtjgh</p>','<p>jtyrjgfjt</p>','jrtyjt','jtgrjtr','jrtjjtgkjyk'),(56,'<p>dgfssgdsgsgs</p>','<p>dsgdregsg</p>','<p>sgeswrgsdgs</p>','<p>gdsgresgdsgs</p>','<p>ghrfhjydjuyhjtfjtf</p>','<p>jtgfjhdgssghdrh</p>',NULL,NULL,NULL),(57,'<p>hdrfdrthdhddhrs</p>','<p>hdrtdehdehd</p>','<p>hdhdedhdejh</p>','<p>tyhdhtyj</p>','<p>ejrtfjudtjutfdj</p>','<p>trjrtfjdettj</p>','tdrfjrtjr','jdj','tfjftgjtfjf'),(58,'','','','','','','','',''),(59,'','','','','','','','',''),(60,'','','','','','','','',''),(63,'<p>sdgfghdshs</p>','<p>dfsghdfsgdfsh</p>','<p>dsgfds</p>','<p>dfhdsgsdh</p>','<p>dsgdfh</p>','<p>dfgregdsg</p>','gfdgss','gdfsg','dsgsgs');
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
INSERT INTO `descrizione_it` VALUES (1,'<p>aaa</p>','<p>aaa</p>','<p>aaaa</p>','<p>aaa</p>','<p>aaa</p>','<p>aa</p>','aaaaaa',' ',' '),(6,'taiel','fggdg','ghfhth','hhtht','dhhthf','hy','rhhhrtygf','hgfdht','dhhdhdtr'),(19,'aaa','aaa','aaaa','aaa','aaa','aa','aaaaaa',' ',' '),(21,'taiel','fggdg','ghfhth','hhtht','dhhthf','hy','rhhhrtygf','hgfdht','dhhdhdtr'),(22,'aaa','aaa','aaaa','aaa','aaa','aa','aaaaaa',' ',' '),(24,'taiel','fggdg','ghfhth','hhtht','dhhthf','hy','rhhhrtygf','hgfdht','dhhdhdtr'),(28,'<p>dgssgsgsgs</p>','<p>gswgesgsrghsghr</p>','<p>ghrsghreghe</p>','<p>rehgtrthr</p>','<p>hrtehreheh</p>','<p>ehrehrehrehe</p>','rrth','rehreh','rehrehrdehrerhe'),(53,'<p>dgfdregredgs</p>','<p>gsresgdssgse</p>','<p>gesgfesgresgdsgresgsde</p>','<p>rgesgfsdegesgsgrtg</p>','<p>rthkuijyukjyfhyhjty</p>','<p>jutyjtyfhjujtrjhty</p>','jtyhjtyr','htyrh','trhtyhjty'),(54,'<p>dfgdregdfg</p>','<p>dgfdefgdfv</p>','<p>gdegdfg</p>','<p>dfgregdf</p>','<p>gdgre</p>','<p>dgregdfgdgde</p>','dgfre','dggde','gdgregd'),(55,'','','','','','','','',''),(56,'','','','','','','','',''),(57,'<p>dgregdg</p>','<p>degdgdgd</p>','<p>gdrgdgdg</p>','<p>dgdrgdg</p>','<p>regdsghwryghre</p>','<p>hrehgrtdehreh</p>','hrthdrh','rdehrde','hrdehge'),(58,'','','','','','','','',''),(59,'','','','','','','','',''),(60,'','','','','','','','',''),(63,'<p>fdgdsgdfsg</p>','<p>dsghdsghgh</p>','<p>dsghdfsh</p>','<p>dsfghsdfhgs</p>','<p>hsdhrewt</p>','<p>ghdshdsgh</p>','rshds','hsgh','swghsdghsdhs');
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
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (1,'img/teacher_2_small.jpg','Giuseppe','Della Penna','dsjfkns@dfdsfks.ds','dslxxx','441225632','Web Enginereeng','<p>arabo</p>','<p>arabo</p>','curriculum/curriculum1.txt','Lun 8:00'),(2,'img/teacher_2_small.jpg','Bestia','DeSatana','bestiadesatana@fanculo.com','inferno','666666666999999','Dolore','asasddas','adad','C:\\Users\\Chris-PC\\Desktop\\curriculum.txt','Lun 6:66'),(3,'','Chris','Toni','','','','','','','',''),(7,'','Lollo','Brigido','','','','','<ul>\r\n<li>cdsvfdfd</li>\r\n<li><strong>fdgdfgdfgre</strong></li>\r\n<li><em>ghjgjtygj</em></li>\r\n<li><span style=\"text-decoration: underline;\">fgdgdgdfg</span></li>\r\n<li><span style=\"text-decoration: line-through;\"><span style=\"text-decoration: underline;\">fafdfsfewrfs</span></span></li>\r\n<li>hdfghd<sup>gdfsgdgds</sup></li>\r\n<li><sup>fafewfasfsa</sup><sub>fasdfsfeafasd</sub></li>\r\n<li><code>dfsgfdesgrsg</code></li>\r\n<li>\r\n<h1>fassfsfds</h1>\r\n</li>\r\n<li>\r\n<h4>gfdfgsgresag</h4>\r\n</li>\r\n<li>\r\n<h4 style=\"text-align: right;\">gdfsgsgresgdsgs</h4>\r\n</li>\r\n<li>\r\n<h4 style=\"text-align: right;\">fdasgsgsgdfses<code></code></h4>\r\n</li>\r\n</ul>','','',''),(8,'','Palla','Bella','','','','','&lt;ul&gt;\r\n&lt;li&gt;dsgfd&lt;/li&gt;\r\n&lt;li&gt;&amp;ugrave;gretgd&lt;/li&gt;\r\n&lt;li&gt;&lt;strong&gt;hedrhtrhfg&lt;/strong&gt;&lt;/li&gt;\r\n&lt;/ul&gt;','','',''),(9,NULL,'Ancora','Vivo','','','','','<ul>\r\n<li>dfgfdgd</li>\r\n<li>gdregdg</li>\r\n<li><strong>gdgdgdgr</strong></li>\r\n</ul>','',NULL,''),(12,'imgDocenti\\baby_groot-2560x1440.jpg','groot','groot','','','','','','','curriculum\\curriculum.txt',''),(22,NULL,'Babbo','Boia','','','','','','',NULL,''),(23,'imgDocenti\\BobbeMalle.jpg','Bobbe','Malle','','','','','','',NULL,''),(24,'imgDocenti\\BobbeMalle1.jpg','Bobbe','Malle','','','','','','',NULL,''),(25,'imgDocenti\\BestiaSat.jpg','Bestia','Sat','','','','','','',NULL,''),(26,'imgDocenti\\BestiaSat1.jpg','Bestia','Sat','','','','','','',NULL,''),(27,'imgDocenti\\BobbeMalle2.jpg','Bobbe','Malle','','','','','','','curriculum\\BobbeMalle.pdf',''),(28,'imgDocenti\\BobbeMalle3.jpg','Bobbe','Malle','','','','','','','curriculum\\BobbeMalle1.pdf',''),(29,'imgDocenti\\BobbeMalle4.jpg','Bobbe','Malle','','','','','','','curriculum\\BobbeMalle2.pdf',''),(30,'imgDocenti\\BobbeMalle.jpg','Bobbe','Malle','groot@fuck.it','Cella','55111222655','Pintologia','<p>tgfhfhrfh</p>\r\n<ul>\r\n<li>yjjy</li>\r\n</ul>','<ul>\r\n<li>tjtyjtjgtjyjtt</li>\r\n<li>tyjt</li>\r\n</ul>','curriculum\\BobbeMalle.txt','Lun 8:00'),(31,'imgDocenti\\BobbeMalle1.jpg','Bobbe','Malle','groot@fuck.it','Cella','55111222655','Pintologia','<p>tgfhfhrfh</p>\r\n<ul>\r\n<li>yjjy</li>\r\n</ul>','<ul>\r\n<li>tjtyjtjgtjyjtt</li>\r\n<li>tyjt</li>\r\n</ul>','curriculum\\BobbeMalle1.txt','Lun 8:00'),(32,'imgDocenti\\BobbeMalle2.jpg','Bobbe','Malle','groot@fuck.it','Cella','55111222655','Pintologia','<p>tgfhfhrfh</p>\r\n<ul>\r\n<li>yjjy</li>\r\n</ul>','<ul>\r\n<li>tjtyjtjgtjyjtt</li>\r\n<li>tyjt</li>\r\n</ul>','curriculum\\BobbeMalle2.txt','Lun 8:00'),(33,'imgDocenti\\GeeMallefddd.jpg','Gee','Mallefddd','groot@fuck.it','Cella','55111222655','Pintologia','<p>tgfhfhrfh</p>\r\n<ul>\r\n<li>yjjy</li>\r\n</ul>','<ul>\r\n<li>tjtyjtjgtjyjtt</li>\r\n<li>tyjt</li>\r\n</ul>','curriculum\\GeeMallefddd.txt','Lun 8:00'),(34,'imgDocenti\\BobbeMalle3.jpg','Bobbe','Malle','groot@fuck.it','Cella','55111222655','Pintologia','<ol>\r\n<li>dfgfdfefwffs</li>\r\n</ol>','<ul>\r\n<li>fwfsdefewfswfswff</li>\r\n<li>fweeswfeswfwesef</li>\r\n</ul>','curriculum\\BobbeMalle3.txt','Lun 8:00'),(35,NULL,'Gea','fsdfs','','','','','','',NULL,''),(36,NULL,'Hhjd','gsges','','','','','','',NULL,''),(37,'imgDocenti\\BabboSatana.jpg','Babbo','Satana','','','','','','','curriculum\\BabboSatana.txt',''),(38,'imgDocenti\\BabboSatana.jpg','Babbo','Satana','','','','','','','curriculum\\BabboSatana.txt',''),(39,'imgDocenti\\BabboSatana1.jpg','Babbo','Satana','','','','','','','curriculum\\BabboSatana1.txt',''),(40,'imgDocenti\\GrootGroot.jpg','Groot','Groot','','','','','','','curriculum\\GrootGroot.txt',''),(41,'imgDocenti\\ChrisMatto.jpg','Chris','Matto','mattus@lla.com','Coppitus 8','55111222655','Satanismo','<p>Ciao, sono Mario e sono <strong>STRONZO</strong></p>','<ul>\r\n<li>dsddf</li>\r\n</ul>\r\n<p>fffff</p>','curriculum\\ChrisMatto.txt','Lun 8:00'),(42,'imgDocenti\\ChrisMatto.jpg','Chris','Matto','','','','','','','curriculum\\ChrisMatto.txt',''),(43,NULL,'cccc','cccc','','','','','','',NULL,''),(44,'imgDocenti\\provaprova.jpg','prova','prova','','','','','','','curriculum\\provaprova.txt',''),(45,NULL,'ffff','ffff','','','','','','',NULL,''),(46,'imgDocenti\\CazzCazz.jpg','Cazz','Cazz','','','','','','','curriculum\\CazzCazz.txt','');
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
INSERT INTO `docenti_corso` VALUES (1,1),(19,1),(22,1),(26,1),(27,1),(35,1),(63,1),(1,2),(3,2),(18,2),(19,2),(22,2),(26,2),(27,2),(18,3),(25,3),(30,9),(31,9),(25,22),(29,22),(57,29),(57,30);
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
INSERT INTO `dublino_en` VALUES (1,'<p>aaaaaaaaaa</p>','<p>aaaaaaaaaa</p>','<p>aaaaaaaaaa</p>','<p>aaaaaaaaaa</p>','<p>aaaaaaaaaa</p>'),(19,'aaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaa'),(22,'aaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaa'),(28,'<p>fkjghfjrkjrfgj</p>','<p>fkjghfjrkjrfgj</p>','<p>fkjghfjrkjrfgj</p>','<p>fkjghfjrkjrfgj</p>','<p>jukjgfjfjfd</p>'),(59,'<p>rgaessdrgdsg</p>','<p>sdgswthrshdrfh</p>','<p>fdhjfdhdh</p>','<p>drfhdrf</p>','<p>hdrfyhdrehde</p>'),(60,'','','','',''),(63,'<p>shsdfh</p>','<p>shsdfh</p>','<p>shsdfh</p>','<p>shsdfh</p>','<p>hsdr</p>');
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
INSERT INTO `dublino_it` VALUES (1,'<p>aaaaaaaaaa</p>','<p>aaaaaaaaaaaaa</p>','<p>aaaaaaaaaaa</p>','<p>aaaaaaaaaaaaa</p>','<p>aaaaaaaaaa</p>'),(6,'fdh','rhdehr','hrhrth','fherhr','hrfhrthr'),(19,'aaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaa'),(21,'fdh','rhdehr','hrhrth','fherhr','hrfhrthr'),(22,'aaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaaa','aaaaaaaaaaaaa','aaaaaaaaaa'),(24,'fdh','rhdehr','hrhrth','fherhr','hrfhrthr'),(28,'<p>rjfjghfky</p>','<p>rkjfghkjrfjgf</p>','<p>kjrjgfkjrtyj</p>','<p>ghfkjrtfjghfjrty</p>','<p>kjrtfjrj</p>'),(57,'afdasff','afdasff','afdasff','afdasff','afdasff'),(59,'<p>gdfsgdesgsg</p>','<p>sgresgdsgsd</p>','<p>gesrgsdfgesw</p>','<p>gdsgresw</p>','<p>gesgdsgersw</p>'),(60,'','','','',''),(63,'<p>dfsgdsg</p>','<p>dfgdfhdg</p>','<p>rehdgfhgfh</p>','<p>rthfshrehrf</p>','<p>hsdfhtgf</p>');
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
INSERT INTO `group_services` VALUES (1,1),(2,2),(1,3),(1,4),(2,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,11),(1,12),(1,13),(1,14),(1,15),(1,16),(2,17);
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
INSERT INTO `libri_corso` VALUES (1,1),(19,1),(1,3),(1,5);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'Bestiaccia','Ingegneria',1,2010,'Satana','ndfsknf'),(2,'Cazzafà','L\'arte del cazzafà',3,2100,'Cazzetto','mmmmm'),(3,'Cazzafà','L\'arte del cazzafàà',3,2100,'Cazzetto','mmmmm'),(4,'','dfasafeaf',0,0000,'',''),(5,'','vvvdv',0,0000,'','');
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
  `Data` datetime NOT NULL,
  `Descrizione` text NOT NULL,
  PRIMARY KEY (`IDLog`),
  KEY `Utente` (`Utente`),
  CONSTRAINT `log_ibfk_1` FOREIGN KEY (`Utente`) REFERENCES `utente` (`IDUtente`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,1,'2018-02-20 23:02:24','Ha modificato il cdlROBA NUOVAA'),(2,1,'2018-02-20 23:27:20','Ha modificato il cdlDFG'),(3,1,'2018-02-20 23:28:02','Ha modificato il cdlDFG'),(4,1,'2018-02-21 00:39:55','Ha registrato il docentecazzarolafigl'),(5,1,'2018-02-21 00:40:29','Ha modificato il corso diigw'),(6,1,'2018-02-21 01:32:19','Ha aggiunto il librozdfzsfxzfcorso1'),(7,1,'2018-02-21 03:40:38','Ha creato il corso cazzz nel cdl [courseweb.model.classi.CDLImpl@61fe6e6f]con docentenull'),(8,1,'2018-02-21 03:42:07','Ha modificato il corso dicazzz'),(9,28,'2018-02-21 03:43:28','Ha modificato il corso dinull'),(10,28,'2018-02-21 03:52:27','Ha modificato il corso diccccc'),(11,1,'2018-02-21 05:03:46','Ha registrato il docenteCazzCazz'),(12,1,'2018-02-21 05:04:13','Ha modificato il docente  Cazz Cazz'),(13,28,'2018-02-21 05:25:45','Ha modificato il corso diccccc'),(14,28,'2018-02-21 05:28:25','Ha modificato il corso diaaaaaaaa'),(15,28,'2018-02-21 05:31:06','Ha modificato il corso dicccccc'),(16,28,'2018-02-21 05:31:26','Ha modificato il corso dicccccc'),(17,28,'2018-02-21 05:47:14','Ha modificato il docente  Giuseppe Della Penna'),(18,28,'2018-02-21 05:57:32','Ha aggiunto il librovvvdvcorso1');
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materiale`
--

LOCK TABLES `materiale` WRITE;
/*!40000 ALTER TABLE `materiale` DISABLE KEYS */;
INSERT INTO `materiale` VALUES (2,1,'Immagined','img/baby_groot-2560x1440.jpg','<p>Bella Immagine</p>','<p>Nice Image</p>'),(3,19,'Roba','img/art.jpg','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa','Roba roba roba tanta tanta '),(4,19,'Immagine','img/baby_groot-2560x1440.jpg','Bella Immagine','Nice Image'),(6,22,'Roba','img/art.jpg','aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa','Roba roba roba tanta tanta '),(7,22,'Immagine','img/baby_groot-2560x1440.jpg','Bella Immagine','Nice Image');
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servizio`
--

LOCK TABLES `servizio` WRITE;
/*!40000 ALTER TABLE `servizio` DISABLE KEYS */;
INSERT INTO `servizio` VALUES (1,'Backoffice',NULL),(2,'BackofficeD',NULL),(3,'CreateCorso',NULL),(4,'CreateCDL',NULL),(5,'CreateCorsoD',NULL),(6,'ModificaCorso',NULL),(7,'RegisterDocente',NULL),(8,'Profile',NULL),(9,'Corsianno',NULL),(10,'ModificaDocente',NULL),(11,'ModificaCDL',NULL),(12,'Log',NULL),(13,'LibroUp',NULL),(14,'LibroNew',NULL),(15,'MaterialeNew',NULL),(16,'MaterialeUp',NULL),(17,'MaterialeNewD',NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'admin','password',NULL,1),(5,'lobr','password',7,2),(6,'pabe','5XmtrPpRSz',8,2),(7,'anvi','zhM0XtHJWS',9,2),(10,'grgr','MX3MUkFiu9',12,2),(20,'babo','OY41Pz3Ptp',22,2),(22,'boma','7CI6jMb2j8',24,2),(24,'besa','sE7KdnEhEb',26,2),(28,'gidp','password',1,2),(32,'gema','LrTshPpKY0',33,2),(33,'boma1','XL6F0u9jl3',34,2),(34,'gefs','5PXBlCV9fv',35,2),(35,'hhgs','XjeiYNAAVx',36,2),(36,'basa','cFUM7IsUEA',37,2),(37,'basa1','oAxruyIpUF',38,2),(40,'chma','c2DdrVs1a7',41,2),(41,'chma1','IZHFDz7ISK',42,2),(42,'cccc','nOJqVUku6J',43,2),(43,'prpr','UKXb8q8v5z',44,2),(44,'ffff','RJENKmPy30',45,2),(46,'caccapapà','password',NULL,1),(47,'caca','rT1lefbf3Z',46,2);
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

-- Dump completed on 2018-02-21  6:15:05
