-- phpMyAdmin SQL Dump
-- version 4.4.15.8
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Creato il: Mag 24, 2017 alle 18:23
-- Versione del server: 5.6.31
-- Versione PHP: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `WebApp`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `Argomenti`
--

CREATE TABLE IF NOT EXISTS `Argomenti` (
  `idArgomenti` int(11) NOT NULL,
  `descrizione` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `Lezione_id` int(11) NOT NULL,
  `Corso_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Struttura della tabella `Corso`
--

CREATE TABLE IF NOT EXISTS `Corso` (
  `idCorso` int(11) NOT NULL,
  `nome` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `codice` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `tipo` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `ssd` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `lingua` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `semestre` int(11) DEFAULT NULL,
  `prerequisiti` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `obiettiviApprendimento` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `ModalitaEsame` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `modalitaInsegnamento` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `note` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `nome_en` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `tipo_en` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `lingua_en` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `prerequisiti_en` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `obiettiviApprendimento_en` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `modalitaEsame_en` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `modalitaInsegnamento_en` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `note_en` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `knowledge` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `application` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `evaluation` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `communication` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `lifelong_learning_skill` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `knowledge_en` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `application_en` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `evaluation_en` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `comunication_en` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Struttura della tabella `Corso_has_Docente`
--

CREATE TABLE IF NOT EXISTS `Corso_has_Docente` (
  `Corso_id` int(11) NOT NULL,
  `Docente_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Struttura della tabella `Docente`
--

CREATE TABLE IF NOT EXISTS `Docente` (
  `idDocente` int(11) NOT NULL,
  `nome` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `cognome` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `mail` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `telefono` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `ufficio` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Struttura della tabella `Gruppo`
--

CREATE TABLE IF NOT EXISTS `Gruppo` (
  `idGruppo` int(11) NOT NULL,
  `gruppo_nome` varchar(45) COLLATE utf8_bin NOT NULL,
  `descrizione` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `Servizio_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Struttura della tabella `Lezione`
--

CREATE TABLE IF NOT EXISTS `Lezione` (
  `idLezione` int(11) NOT NULL,
  `titolo` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `data` date DEFAULT NULL,
  `ore` int(11) DEFAULT NULL,
  `Corso_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Struttura della tabella `Libro`
--

CREATE TABLE IF NOT EXISTS `Libro` (
  `idLibro` int(11) NOT NULL,
  `autore` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `titolo` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `volume` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `anno` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `editore` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `Corso_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Struttura della tabella `Log`
--

CREATE TABLE IF NOT EXISTS `Log` (
  `idLog` int(11) NOT NULL,
  `data` date NOT NULL DEFAULT '0000-00-00',
  `azzione` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `Utente_id` int(11) NOT NULL,
  `Gruppo_id` int(11) NOT NULL,
  `gruppo_nome` varchar(45) COLLATE utf8_bin NOT NULL,
  `Servizio_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Struttura della tabella `Materiale`
--

CREATE TABLE IF NOT EXISTS `Materiale` (
  `idMateriale` int(11) NOT NULL,
  `nome` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `tipo` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `Argomenti_id` int(11) NOT NULL,
  `Lezione_id` int(11) NOT NULL,
  `Corso_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Struttura della tabella `Segui`
--

CREATE TABLE IF NOT EXISTS `Segui` (
  `idUtente` int(11) NOT NULL DEFAULT '0',
  `idCorso` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Struttura della tabella `Servizio`
--

CREATE TABLE IF NOT EXISTS `Servizio` (
  `idServizio` int(11) NOT NULL,
  `script` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `descrizione` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Struttura della tabella `Sillabo`
--

CREATE TABLE IF NOT EXISTS `Sillabo` (
  `idSillabo` int(11) NOT NULL,
  `descrizione` mediumtext COLLATE utf8_bin,
  `Corso_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Struttura della tabella `Utente`
--

CREATE TABLE IF NOT EXISTS `Utente` (
  `idUtente` int(11) NOT NULL,
  `password` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `nome` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `cognome` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `nome_gruppo` varchar(45) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `Argomenti`
--
ALTER TABLE `Argomenti`
  ADD PRIMARY KEY (`idArgomenti`,`Lezione_id`,`Corso_id`),
  ADD KEY `fk_Argomenti_Lezione1_idx` (`Lezione_id`,`Corso_id`);

--
-- Indici per le tabelle `Corso`
--
ALTER TABLE `Corso`
  ADD PRIMARY KEY (`idCorso`);

--
-- Indici per le tabelle `Corso_has_Docente`
--
ALTER TABLE `Corso_has_Docente`
  ADD PRIMARY KEY (`Corso_id`,`Docente_id`),
  ADD KEY `fk_Corso_has_Docente_Docente1_idx` (`Docente_id`),
  ADD KEY `fk_Corso_has_Docente_Corso1_idx` (`Corso_id`);

--
-- Indici per le tabelle `Docente`
--
ALTER TABLE `Docente`
  ADD PRIMARY KEY (`idDocente`);

--
-- Indici per le tabelle `Gruppo`
--
ALTER TABLE `Gruppo`
  ADD PRIMARY KEY (`idGruppo`,`gruppo_nome`,`Servizio_id`),
  ADD UNIQUE KEY `gruppo_nome` (`gruppo_nome`),
  ADD KEY `fk_Gruppo_Servizio_idx` (`Servizio_id`);

--
-- Indici per le tabelle `Lezione`
--
ALTER TABLE `Lezione`
  ADD PRIMARY KEY (`idLezione`,`Corso_id`),
  ADD KEY `fk_Lezione_Corso1_idx` (`Corso_id`);

--
-- Indici per le tabelle `Libro`
--
ALTER TABLE `Libro`
  ADD PRIMARY KEY (`idLibro`,`Corso_id`),
  ADD KEY `fk_Libro_Corso1_idx` (`Corso_id`);

--
-- Indici per le tabelle `Log`
--
ALTER TABLE `Log`
  ADD PRIMARY KEY (`idLog`,`data`,`Utente_id`,`Gruppo_id`,`Servizio_id`),
  ADD KEY `fk_Log_Utente1_idx` (`Utente_id`,`Gruppo_id`,`Servizio_id`),
  ADD KEY `fk_Log_Utente1` (`Utente_id`,`gruppo_nome`),
  ADD KEY `log_gruppo` (`Gruppo_id`,`gruppo_nome`,`Servizio_id`);

--
-- Indici per le tabelle `Materiale`
--
ALTER TABLE `Materiale`
  ADD PRIMARY KEY (`idMateriale`,`Argomenti_id`,`Lezione_id`,`Corso_id`),
  ADD KEY `fk_Materiale_Argomenti1_idx` (`Argomenti_id`,`Lezione_id`,`Corso_id`);

--
-- Indici per le tabelle `Segui`
--
ALTER TABLE `Segui`
  ADD PRIMARY KEY (`idUtente`,`idCorso`),
  ADD KEY `toCorso` (`idCorso`);

--
-- Indici per le tabelle `Servizio`
--
ALTER TABLE `Servizio`
  ADD PRIMARY KEY (`idServizio`);

--
-- Indici per le tabelle `Sillabo`
--
ALTER TABLE `Sillabo`
  ADD PRIMARY KEY (`idSillabo`,`Corso_id`),
  ADD KEY `fk_Sillabo_Corso1_idx` (`Corso_id`);

--
-- Indici per le tabelle `Utente`
--
ALTER TABLE `Utente`
  ADD PRIMARY KEY (`nome_gruppo`),
  ADD KEY `fk_Utente_Gruppo_id1` (`idUtente`,`nome_gruppo`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `Servizio`
--
ALTER TABLE `Servizio`
  MODIFY `idServizio` int(11) NOT NULL AUTO_INCREMENT;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `Argomenti`
--
ALTER TABLE `Argomenti`
  ADD CONSTRAINT `fk_Argomenti_Lezione1` FOREIGN KEY (`Lezione_id`, `Corso_id`) REFERENCES `Lezione` (`idLezione`, `Corso_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `Corso_has_Docente`
--
ALTER TABLE `Corso_has_Docente`
  ADD CONSTRAINT `fk_Corso_has_Docente_Corso1` FOREIGN KEY (`Corso_id`) REFERENCES `Corso` (`idCorso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Corso_has_Docente_Docente1` FOREIGN KEY (`Docente_id`) REFERENCES `Docente` (`idDocente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `Gruppo`
--
ALTER TABLE `Gruppo`
  ADD CONSTRAINT `fk_Gruppo_Servizio` FOREIGN KEY (`Servizio_id`) REFERENCES `Servizio` (`idServizio`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `Lezione`
--
ALTER TABLE `Lezione`
  ADD CONSTRAINT `fk_Lezione_Corso1` FOREIGN KEY (`Corso_id`) REFERENCES `Corso` (`idCorso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `Libro`
--
ALTER TABLE `Libro`
  ADD CONSTRAINT `fk_Libro_Corso1` FOREIGN KEY (`Corso_id`) REFERENCES `Corso` (`idCorso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `Log`
--
ALTER TABLE `Log`
  ADD CONSTRAINT `fk_Log_Utente1` FOREIGN KEY (`Utente_id`, `gruppo_nome`) REFERENCES `Utente` (`idUtente`, `nome_gruppo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `log_gruppo` FOREIGN KEY (`Gruppo_id`, `gruppo_nome`, `Servizio_id`) REFERENCES `Gruppo` (`idGruppo`, `gruppo_nome`, `Servizio_id`);

--
-- Limiti per la tabella `Materiale`
--
ALTER TABLE `Materiale`
  ADD CONSTRAINT `fk_Materiale_Argomenti1` FOREIGN KEY (`Argomenti_id`, `Lezione_id`, `Corso_id`) REFERENCES `Argomenti` (`idArgomenti`, `Lezione_id`, `Corso_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `Segui`
--
ALTER TABLE `Segui`
  ADD CONSTRAINT `toCorso` FOREIGN KEY (`idCorso`) REFERENCES `Corso` (`idCorso`),
  ADD CONSTRAINT `toUtente` FOREIGN KEY (`idUtente`) REFERENCES `Utente` (`idUtente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `Sillabo`
--
ALTER TABLE `Sillabo`
  ADD CONSTRAINT `fk_Sillabo_Corso1` FOREIGN KEY (`Corso_id`) REFERENCES `Corso` (`idCorso`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limiti per la tabella `Utente`
--
ALTER TABLE `Utente`
  ADD CONSTRAINT `utente_gruppo` FOREIGN KEY (`nome_gruppo`) REFERENCES `Gruppo` (`gruppo_nome`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
