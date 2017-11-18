/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.interfacce;



import courseweb.controller.data.DataLayer;
import courseweb.controller.data.DataLayerException;
import java.io.InputStream;
import java.util.List;
/**
 *
 * @author Toni & Toni
 */
public interface IgwDataLayer extends DataLayer {
    
    CDL createCDL();
    
    Corso createCorso();
    
    Docente createDocente();
    
    Docenti_Corso createDocenti_Corso();
    
    Descrizione_it createDescrizione_it();
    
    Descrizione_en createDescrizione_en();
    
    Dublino_it createDublino_it();

    Dublino_en createDublino_en();

    Materiale createMateriale();
    
    Libro createLibro();
    
    Libri_Corso createLibri_corso();
    
    Colleg_Corsi createColleg_Corsi();
    
    Gruppo createGruppo();
    
    Utente createUtente();
    
    Servizio createServizio();
    
    Group_Services createGroup_Services();
    
    Log CreateLog();
    
    CDL getCDL(int IDCdl) throws DataLayerException;
    
    Corso getCorso(int IDCorso) throws DataLayerException;

    Docente getDocente(int IDDocente) throws DataLayerException;
    
    Docenti_Corso getDocenti_Corso(int Corso, int Docente) throws DataLayerException;
    
    Descrizione_it getDescrizione_it(int Corso) throws DataLayerException;
    
    Descrizione_en getDescrizione_en(int Corso) throws DataLayerException;
    
    Dublino_it getDublino_it(int Corso) throws DataLayerException;
    
    Dublino_en getDublino_en(int Corso) throws DataLayerException;
    
    Materiale getMateriale(int IDLibro) throws DataLayerException;
    
    Libro getLibro(int IDLibro) throws DataLayerException;
    
    Libri_Corso getLibri_Corso(int corso) throws DataLayerException;
    
    Colleg_Corsi getColleg_Corsi(int This_Corso, int Other_Corso) throws DataLayerException;
    
    Gruppo getGruppo(int IDGruppo) throws DataLayerException;
    
    Utente getUtente(int IDUtente) throws DataLayerException;
    
    Servizio getServizio(int IDServizio) throws DataLayerException;
    
    Group_Services getGroup_Services(int Gruppo, int Servizio) throws DataLayerException;
    
    Log getLog(int IDLog) throws DataLayerException;
    
    
    
    
    
}