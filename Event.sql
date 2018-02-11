DELIMITER |

CREATE EVENT new_corsi_year
	ON SCHEDULE 
		EVERY 1 YEAR
			STARTS '2018-08-01 03:00:00' ON COMPLETION PRESERVE ENABLE
	DO
		BEGIN
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
		END |
        
DELIMITER ;