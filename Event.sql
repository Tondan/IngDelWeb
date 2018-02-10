DELIMITER |

CREATE EVENT new_corsi_year
	ON SCHEDULE 
		EVERY 1 YEAR
			STARTS '2018-08-01 03:00:00' ON COMPLETION PRESERVE ENABLE
	DO
		BEGIN
			CREATE TEMPORARY TABLE tmp 
				SELECT * FROM Corso WHERE Anno=YEAR(NOW())-1;
			ALTER TABLE tmp DROP IDCorso; # Drop autoincrement field
            INSERT INTO Corso SELECT 0,tmp FROM tmp;
            DROP TEMPORARY TABLE tmp;
		END |
        
DELIMITER ;