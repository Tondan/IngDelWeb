CREATE TABLE CDL(
	IDCDL INT PRIMARY KEY AUTO_INCREMENT,
    Nome_it VARCHAR(50) NOT NULL,
    Nome_en VARCHAR(50) NOT NULL,
    Anno YEAR NOT NULL,
    CFU INT NOT NULL
);

ALTER TABLE CDL AUTO_INCREMENT=1;

CREATE TABLE Corso(
	IDCorso INT PRIMARY KEY AUTO_INCREMENT,
    CDL INT NOT NULL,
    FOREIGN KEY (CDL)
		REFERENCES CDL(IDCDL),
    Nome_it VARCHAR(50) NOT NULL,
    Nome_en	VARCHAR(50) NOT NULL,
    SSD VARCHAR(10) NOT NULL,
    Lingua VARCHAR(20) NOT NULL,
    Semestre INT NOT NULL,
    CFU INT NOT NULL,
    Anno YEAR NOT NULL,
    Tipologia CHAR(1) 
);

ALTER TABLE Corso AUTO_INCREMENT=1;

CREATE TABLE Docente(
	IDDocente INT PRIMARY KEY AUTO_INCREMENT,
    Immagine TEXT,
    Nome VARCHAR(20) NOT NULL,
    Cognome VARCHAR(20) NOT NULL,
    Email VARCHAR(50) NOT NULL,
    Ufficio VARCHAR(50) NOT NULL,
    Telefono VARCHAR(20) NOT NULL,
    Specializzazione VARCHAR(50) NOT NULL,
    Ricerche TEXT,
	Pubblicazioni TEXT,
    Curriculum TEXT,
    Ricevimento TEXT NOT NULL
);

ALTER TABLE Docente AUTO_INCREMENT=1;

CREATE TABLE Docenti_Corso(
	Corso INT,
    FOREIGN KEY (Corso)
		REFERENCES Corso(IDCorso),
	Docente INT,
	FOREIGN KEY (Docente)
		REFERENCES Docente(IDDocente),
	PRIMARY KEY(Corso,Docente)
);

CREATE TABLE Descrizione_it(
	 Corso INT PRIMARY KEY,
     FOREIGN KEY (Corso)
		REFERENCES Corso(IDCorso),
	 Prerequisiti TEXT NOT NULL,
     Obiettivi TEXT,
     Mod_Esame TEXT NOT NULL,
     Mod_Insegnamento TEXT NOT NULL,
     Sillabo TEXT NOT NULL,
     Note TEXT,
     Homepage TEXT,
     Forum TEXT,
     Risorse_ext TEXT 
);


CREATE TABLE Descrizione_en(
	 Corso INT PRIMARY KEY,
     FOREIGN KEY (Corso)
		REFERENCES Corso(IDCorso),
	 Prerequisiti TEXT NOT NULL,
     Obiettivi TEXT,
     Mod_Esame TEXT NOT NULL,
     Mod_Insegnamento TEXT NOT NULL,
     Sillabo TEXT NOT NULL,
     Note TEXT,
     Homepage TEXT,
     Forum TEXT,
     Risorse_ext TEXT 
);

CREATE TABLE Dublino_it(
	Corso INT PRIMARY KEY,
		FOREIGN KEY (Corso)
			REFERENCES Corso(IDCorso),
	Knowledge TEXT,
	Application TEXT,
    Evaluation TEXT,
    Communication TEXT,
    Lifelong TEXT
);

CREATE TABLE Dublino_en(
	Corso INT PRIMARY KEY,
		FOREIGN KEY (Corso)
			REFERENCES Corso(IDCorso),
	Knowledge TEXT,
	Application TEXT,
    Evaluation TEXT,
    Communication TEXT,
    Lifelong TEXT
);

CREATE TABLE Materiale(
	IDMateriale INT PRIMARY KEY AUTO_INCREMENT,
	Corso INT,
	FOREIGN KEY (Corso)
		REFERENCES Corso(IDCorso),
	Nome VARCHAR(20) NOT NULL,
    Link TEXT NOT NULL,
    Descrizione_it TEXT,
    Descizione_en TEXT
);

ALTER TABLE Materiale AUTO_INCREMENT=1;

CREATE TABLE Libro(
	IDLibro INT PRIMARY KEY AUTO_INCREMENT,
	Autore VARCHAR(20) NOT NULL,
    Titolo VARCHAR(50) NOT NULL,
    Volume VARCHAR(20),
    Anno YEAR NOT NULL,
    Editore VARCHAR(50),
    Link TEXT
);

ALTER TABLE Libro AUTO_INCREMENT=1;

CREATE TABLE Libri_Corso(
	Corso INT,
	FOREIGN KEY (Corso)
		REFERENCES Corso(IDCorso),
	Libro INT,
    FOREIGN KEY (Libro)
		REFERENCES Libro(IDLibro),
	PRIMARY KEY (Corso,Libro)
);

CREATE TABLE Colleg_Corsi(
	This_Corso INT,
    FOREIGN KEY (This_Corso)
		REFERENCES Corso(IDCorso),
	Other_Corso INT,
    FOREIGN KEY (Other_Corso)
		REFERENCES Corso(IDCorso),
	PRIMARY KEY (This_Corso,Other_Corso),
	Tipo VARCHAR(20) NOT NULL
);

CREATE TABLE Gruppo(
	IDGruppo INT PRIMARY KEY AUTO_INCREMENT,
    Nome VARCHAR(20)
);

CREATE TABLE Utente(
	IDUtente INT PRIMARY KEY AUTO_INCREMENT,	
    Username VARCHAR(20),
    Password VARCHAR(20),
	Email VARCHAR(50),
    Gruppo INT,
    FOREIGN KEY (Gruppo)
		REFERENCES Gruppo(IDGruppo)
);

ALTER TABLE Utente AUTO_INCREMENT=1;

CREATE TABLE Servizio(
	IDServizio INT PRIMARY KEY AUTO_INCREMENT,
    Script VARCHAR(50) NOT NULL,
    Descrizione TEXT
);

ALTER TABLE Servizio AUTO_INCREMENT=1;

CREATE TABLE Group_Services(
	Gruppo INT,
    FOREIGN KEY (Gruppo)
		REFERENCES Gruppo(IDGruppo),
	Servizio INT,
    FOREIGN KEY (Servizio)
		REFERENCES Servizio(IDServizio),
	PRIMARY KEY(Gruppo,Servizio)
);

CREATE TABLE Log(
	IDLog INT PRIMARY KEY AUTO_INCREMENT,
    Utente INT NOT NULL,
    FOREIGN KEY (Utente)
		REFERENCES Utente(IDUtente),
    Data DATE NOT NULL,
    Descrizione TEXT
);

ALTER TABLE Log AUTO_INCREMENT=1;