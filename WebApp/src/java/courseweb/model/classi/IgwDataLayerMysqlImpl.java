/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;
import courseweb.controller.data.DataLayerMysqlImpl;
import courseweb.model.interfacce.CDL;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.Descrizione_en;
import courseweb.model.interfacce.Descrizione_it;
import courseweb.model.interfacce.Docente;
import courseweb.model.interfacce.Dublino_en;
import courseweb.model.interfacce.Dublino_it;
import courseweb.model.interfacce.Gruppo;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.model.interfacce.Libro;
import courseweb.model.interfacce.Log;
import courseweb.model.interfacce.Materiale;
import courseweb.model.interfacce.Servizio;
import courseweb.model.interfacce.Utente;
import static java.lang.Character.toUpperCase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Toni & Tony
 */
public class IgwDataLayerMysqlImpl extends DataLayerMysqlImpl implements IgwDataLayer {

    private PreparedStatement sCorsiMutuatiByCorso,sCorsiPrerequisitiByCorso,sCorsiModuloByCorso,sDocentiByCorso,sLibriByCorso,sMaterialeByCorso,sCorsiByCDL,sUtentiByGruppo,sServiziByGruppo,sCorsiByDocente,sCorsiByLibro,sGruppiByServizio,sCorsi,sDocenti,sCDL,sCdlByMagistrale,sCdlByTriennale;
    private PreparedStatement sCDLByID,sCorsoByID,sDocenteByID,sDescrizione_itByCorso,sDescrizione_enByCorso,sDublino_itByCorso,sDublino_enByCorso,sMaterialeByID,sLibroByID,sGruppoByID,sUtenteByID,sServizioByID,sLogByID,sCorsiByAnno,sCDLByCorso,Login;
    private PreparedStatement iDocente, iUtente;
    private PreparedStatement uDocente, uUtente;
    private PreparedStatement dDocente;
    
    @Override
    public void init() throws DataLayerException {
        try {
            super.init();
            
            sCDLByID=connection.prepareStatement("SELECT * FROM CDL WHERE IDCDL=?");
            sCorsoByID=connection.prepareStatement("SELECT * FROM Corso WHERE IDCorso=?");
            sDocenteByID=connection.prepareStatement("SELECT * FROM Docente WHERE IDDocente=?");
            sDescrizione_itByCorso=connection.prepareStatement("SELECT * FROM Descrizione_it WHERE Corso=?");
            sDescrizione_enByCorso=connection.prepareStatement("SELECT * FROM Descrizione_en WHERE Corso=?");
            sDublino_itByCorso=connection.prepareStatement("SELECT * FROM Dublino_it WHERE Corso=?");
            sDublino_enByCorso=connection.prepareStatement("SELECT * FROM Dublino_en WHERE Corso=?");
            sMaterialeByID=connection.prepareStatement("SELECT * FROM Materiale WHERE IDMateriale=?");
            sLibroByID=connection.prepareStatement("SELECT * FROM Libro WHERE IDLibro=?");
            sGruppoByID=connection.prepareStatement("SELECT * FROM Gruppo WHERE IDGruppo=?");
            sUtenteByID=connection.prepareStatement("SELECT * FROM Utente WHERE IDUtente=?");
            sServizioByID=connection.prepareStatement("SELECT * FROM Servizio WHERE IDServizio=?");
            sLogByID=connection.prepareStatement("SELECT * FROM Log WHERE IDLog=?");
            sCorsiByAnno=connection.prepareStatement("SELECT * FROM Corso WHERE Anno=?");
            sCDLByCorso=connection.prepareStatement("SELECT * FROM CDL,Corsi_CDL WHERE CDL.IDCDL=Corsi_CDL.CDL AND Corso=?");
           
            sCdlByMagistrale = connection.prepareStatement("SELECT * FROM CDL WHERE Magistrale=1 AND Anno=?");
            sCdlByTriennale = connection.prepareStatement("SELECT * FROM CDL WHERE Magistrale=0 AND Anno=?");
            
            Login=connection.prepareStatement("SELECT * FROM Utente WHERE BINARY Utente.Username=? AND BINARY Utente.Password=?;");
            
            
            
            sDocenti=connection.prepareStatement("SELECT IDDocente FROM Docente");
            sCorsi=connection.prepareStatement("SELECT IDCorso FROM Corso");
            sCDL = connection.prepareStatement("SELECT IDCDL FROM CDL WHERE Anno=?");
            sCorsiMutuatiByCorso=connection.prepareStatement("SELECT Other_Corso FROM Colleg_Corsi WHERE This_Corso=? AND Tipo='Mutuato'");
            sCorsiPrerequisitiByCorso=connection.prepareStatement("SELECT Other_Corso FROM Colleg_Corsi WHERE This_Corso=? AND Tipo='Propedeudico'");
            sCorsiModuloByCorso=connection.prepareStatement("SELECT Other_Corso FROM Colleg_Corsi WHERE This_Corso=? AND Tipo='Modulo'");
            sDocentiByCorso=connection.prepareStatement("SELECT Docente FROM Docenti_Corso WHERE Corso=?");
            sLibriByCorso=connection.prepareStatement("SELECT Libro FROM Libri_Corso WHERE Corso=?");
            sMaterialeByCorso=connection.prepareStatement("SELECT IDMateriale FROM Materiale WHERE Corso=?");
            sCorsiByCDL=connection.prepareStatement("SELECT Corso FROM Corsi_CDL WHERE CDL=?");
            sUtentiByGruppo=connection.prepareStatement("SELECT IDUtente FROM Utente WHERE Gruppo=?");
            sServiziByGruppo=connection.prepareStatement("SELECT Servizio FROM Group_Services WHERE Gruppo=?");
            sCorsiByDocente=connection.prepareStatement("SELECT Corso FROM Docenti_Corso,Corso WHERE Docenti_Corso.Corso=Corso.IDCorso AND Docente=? AND Anno=?");
            sCorsiByLibro=connection.prepareStatement("SELECT Corso FROM Libri_Corso WHERE Libro=?");
            sGruppiByServizio=connection.prepareStatement("SELECT Gruppo FROM Group_Services WHERE Servizio=?");
            
            
            
            //insert
            iDocente = connection.prepareStatement("INSERT INTO Docente (Nome,Cognome) VALUES(?,?)", Statement.RETURN_GENERATED_KEYS);
            uDocente =  connection.prepareStatement("UPDATE Docente Set Nome=?,Cognome=? WHERE IDDocente=? ");
            dDocente = connection.prepareStatement("DELETE FROM Docente WHERE IDDocente=?");
            
            iUtente = connection.prepareStatement("INSERT INTO Utente (Username,Password,Docente,Gruppo) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            uUtente =  connection.prepareStatement("UPDATE Utente Set Username=?,Password=?,Gruppo=? WHERE IDUtente=?");
            
        } catch (SQLException ex) {
            throw new DataLayerException("Error initializing igw data layer", ex);
        }
    }
    
    
    public IgwDataLayerMysqlImpl(DataSource datasource) throws SQLException, NamingException {
        super(datasource);
    }

    @Override
    public CDL createCDL() {
        return new CDLImpl(this);
    }

    public CDL createCDL(ResultSet rs) throws DataLayerException {
        try {
            CDLImpl c = new CDLImpl(this);
            c.setIDCDL(rs.getInt("IDCDL")); //dobbiamo mettere tutti i metodi setid puttana
            c.setNome_it(rs.getString("Nome_it").toUpperCase());
            c.setNome_en(rs.getString("Nome_en").toUpperCase());
            c.setAnno(rs.getInt("Anno"));  //il metodo getYear è stato deprecato https://docs.oracle.com/javase/7/docs/api/java/sql/Time.html probabile che dobbiamo suare caldendar
            c.setCfu(rs.getInt("Cfu"));
            c.setMagistrale(rs.getInt("Magistrale"));
            c.setImmagine(rs.getString("Immagine"));
            c.setDescrizione_it(rs.getString("Descrizione_it"));
            c.setDescrizione_en(rs.getString("Descrizione_en"));
            c.setAbbr_it(rs.getString("Abbr_it").toUpperCase());
            c.setAbbr_en(rs.getString("Abbr_en").toUpperCase());
            return c;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create CDL object form ResultSet", ex);
        }
    }
    
    @Override
    public Corso createCorso() {
        return new CorsoImpl(this);
    }
    
    

    public Corso createCorso(ResultSet rs) throws DataLayerException {
        try {
            CorsoImpl co = new CorsoImpl(this);
            
            co.setID(rs.getInt("IDCorso")); 
            co.setNome_it(rs.getString("Nome_it"));
            co.setNome_en(rs.getString("Nome_en"));
            co.setSSD(rs.getString("SSD").toUpperCase());  
            co.setLingua(rs.getString("Lingua"));
            co.setSemestre(rs.getInt("Semestre"));
            co.setCfu(rs.getInt("CFU"));
            co.setAnno(rs.getInt("Anno"));
            co.setTipologia(toUpperCase(rs.getString("Tipologia").charAt(0)));
            return co;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create Corso object form ResultSet", ex);
        }
    }
    
    @Override
    public Docente createDocente() {
        return new DocenteImpl(this);
    }
    
        public Docente createDocente(ResultSet rs) throws DataLayerException {
        try {
            DocenteImpl d = new DocenteImpl(this);
            
            d.setIDDocente(rs.getInt("IDDocente")); 
            d.setImmagine(rs.getString("Immagine"));
            d.setNome(rs.getString("Nome"));
            d.setCognome(rs.getString("Cognome"));  
            d.setEmail(rs.getString("Email"));
            d.setUfficio(rs.getString("Ufficio"));
            d.setTelefono(rs.getString("Telefono"));
            d.setSpecializzazione(rs.getString("Specializzazione"));
            d.setRicerche(rs.getString("Ricerche"));
            d.setPubblicazioni(rs.getString("Pubblicazioni"));
            d.setCurriculum(rs.getString("Curriculum"));
            d.setRicevimento(rs.getString("Ricevimento"));
            return d;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create Docente object form ResultSet", ex);
        }
    }
    
    @Override
    public Descrizione_it createDescrizione_it() {
        return new Descrizione_itImpl(this);
    }
    
            public Descrizione_it createDescrizione_it(ResultSet rs) throws DataLayerException {
        try {
            Descrizione_itImpl de = new Descrizione_itImpl(this);
            
            de.setIDCorso(rs.getInt("Corso")); 
            de.setPrerequisiti(rs.getString("Prerequisiti"));
            de.setObiettivi(rs.getString("Obiettivi"));
            de.setMod_Esame(rs.getString("Mod_Esame"));  
            de.setMod_Insegnamento(rs.getString("Mod_Insegnamento"));
            de.setSillabo(rs.getString("Sillabo"));
            de.setNote(rs.getString("Note"));
            de.setHomepage(rs.getString("Homepage"));
            de.setForum(rs.getString("Forum"));
            de.setRisorse_Ext(rs.getString("Risorse_ext"));
            return de;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create Descrizione_it object form ResultSet", ex);
        }
   }
    
   
    

    @Override
    public Descrizione_en createDescrizione_en() {
        return new Descrizione_enImpl(this);
    }
    
    public Descrizione_en createDescrizione_en(ResultSet rs) throws DataLayerException {
        try {
            Descrizione_enImpl de = new Descrizione_enImpl(this);
            
            de.setIDCorso(rs.getInt("Corso")); 
            de.setPrerequisiti(rs.getString("Prerequisiti"));
            de.setObiettivi(rs.getString("Obiettivi"));
            de.setMod_Esame(rs.getString("Mod_Esame"));  
            de.setMod_Insegnamento(rs.getString("Mod_Insegnamento"));
            de.setSillabo(rs.getString("Sillabo"));
            de.setNote(rs.getString("Note"));
            de.setHomepage(rs.getString("Homepage"));
            de.setForum(rs.getString("Forum"));
            de.setRisorse_Ext(rs.getString("Risorse_ext"));
            return de;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create Descrizione_en object form ResultSet", ex);
        }
   }
    
    

    @Override
    public Dublino_it createDublino_it() {
        return new Dublino_itImpl(this);
    }
    
    
    
    public Dublino_it createDublino_it(ResultSet rs) throws DataLayerException {
        try {
            Dublino_itImpl de = new Dublino_itImpl(this);
            
            de.setIDCorso(rs.getInt("Corso")); 
            de.setKnowledge(rs.getString("Knowledge"));
            de.setApplication(rs.getString("Application"));
            de.setEvaluation(rs.getString("Evaluation"));  
            de.setCommunication(rs.getString("Communication"));
            de.setLifelong(rs.getString("LifeLong"));
            return de;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create Dublino_it object form ResultSet", ex);
        }
   }

    @Override
    public Dublino_en createDublino_en() {
        return new Dublino_enImpl(this);
    }
    
        public Dublino_enImpl createDublino_en(ResultSet rs) throws DataLayerException {
        try {
            Dublino_enImpl de = new Dublino_enImpl(this);
            
            de.setIDCorso(rs.getInt("Corso")); 
            de.setKnowledge(rs.getString("Knowledge"));
            de.setApplication(rs.getString("Application"));
            de.setEvaluation(rs.getString("Evaluation"));  
            de.setCommunication(rs.getString("Communication"));
            de.setLifelong(rs.getString("LifeLong"));
            return de;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create Dublino_en object form ResultSet", ex);
        }
   }
    

    @Override
    public Materiale createMateriale() {
        return (Materiale) new MaterialeImpl(this);
    }

    
            public Materiale createMateriale(ResultSet rs) throws DataLayerException {
        try {
            MaterialeImpl de = new MaterialeImpl(this);
            
            de.setIDCorso(rs.getInt("Corso")); 
            de.setID(rs.getInt("IDMateriale"));
            de.setNome(rs.getString("Nome"));
            de.setLink(rs.getString("Link"));  
            de.setDescrizione_it(rs.getString("Descrizione_it"));
            de.setDescrizione_en(rs.getString("Descrizione_en"));
            return de;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create Materiale object form ResultSet", ex);
        }
   }
    
    @Override
    public Libro createLibro() {
        return new LibroImpl(this);
    }

    
            public Libro createLibro(ResultSet rs) throws DataLayerException {
        try {
            LibroImpl de = new LibroImpl(this);
            
            de.setIDLibro(rs.getInt("IDLibro")); 
            de.setAutore(rs.getString("Autore"));
            de.setTitolo(rs.getString("Titolo"));
            de.setVolume(rs.getInt("Volume"));  
            de.setAnno(rs.getInt("Anno"));
            de.setEditore(rs.getString("Editore"));
            de.setLink(rs.getString("Link"));
            return de;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create Libro object form ResultSet", ex);
        }
   }
    
    @Override
    public Gruppo createGruppo() {
        return (Gruppo) new GruppoImpl(this);
    }
    
    
    public Gruppo createGruppo(ResultSet rs) throws DataLayerException {
        try {
            GruppoImpl de = new GruppoImpl(this);
            
            de.setIDGruppo(rs.getInt("IDGruppo")); 
            de.setNome(rs.getString("Nome"));
            de.setIDUtenti(rs.getInt("Utente"));
            de.setIDServizi(rs.getInt("Servizio"));
            return de;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create Gruppo object form ResultSet", ex);
        }
   }
    

    @Override
    public Utente createUtente() {
        return (Utente) new UtenteImpl(this);
    }
    
    
    public Utente createUtente(ResultSet rs) throws DataLayerException {
        try {
            Utente de = new UtenteImpl(this);
            
            de.setID(rs.getInt("IDUtente")); 
            de.setUsername(rs.getString("Username"));
            de.setPassword(rs.getString("Password"));
            de.setDocente(rs.getInt("Docente"));  
            de.setIDGruppo(rs.getInt("Gruppo"));
            return de;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create Utente object form ResultSet", ex);
        }
   }

    @Override
    public Servizio createServizio() {
        return new ServizioImpl(this);
    }
    
    
    
    public Servizio createServizio(ResultSet rs) throws DataLayerException {
        try {
            Servizio de = new ServizioImpl(this);
            
            de.setIDServizio(rs.getInt("IDServizio")); 
            de.setScript(rs.getString("Script"));
            de.setDescrizione(rs.getString("Descrizione"));  
            de.setIDGruppo(rs.getInt("Gruppo"));
            return de;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create Servizio object form ResultSet", ex);
        }
   }
    
    
    
    @Override
    public Log CreateLog() {
        return (Log) new LogImpl(this);
    }

    
    
    
    
    public Log createLog(ResultSet rs) throws DataLayerException {
        try {
            Log de = new LogImpl(this);
            
            de.setIDLog(rs.getInt("IDUtente")); 
            de.setData(rs.getTimestamp("Data"));
            de.setDescrizione(rs.getString("Descrizione"));
            de.setIDUtente(rs.getInt("Utente"));  
            return de;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create Log object form ResultSet", ex);
        }
   }
 
    
    @Override
    public CDL getCDL(int IDCdl) throws DataLayerException {
        try {
            sCDLByID.setInt(1,IDCdl);
            try (ResultSet rs=sCDLByID.executeQuery()) {
                if(rs.next())
                    return createCDL(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load CDL by ID",ex);
        }
        return null;
    }

    @Override
    public Corso getCorso(int IDCorso) throws DataLayerException {
        try {
            sCorsoByID.setInt(1,IDCorso);
            try (ResultSet rs=sCorsoByID.executeQuery()) {
                if(rs.next())
                    return createCorso(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load Corso by ID",ex);
        }
        return null;
    }

    @Override
    public Docente getDocente(int IDDocente) throws DataLayerException {
        try {
            sDocenteByID.setInt(1,IDDocente);
            try (ResultSet rs=sDocenteByID.executeQuery()) {
                if(rs.next())
                    return createDocente(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load Docente by ID",ex);
        }
        return null;
    }

    @Override
    public Descrizione_it getDescrizione_it(Corso corso) throws DataLayerException {
        try {
            sDescrizione_itByCorso.setInt(1,corso.getID());
            try (ResultSet rs=sDescrizione_itByCorso.executeQuery()) {
                if(rs.next())
                    return createDescrizione_it(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load Descrizione_it by Corso",ex);
        }
        return null;
    }

    @Override
    public Descrizione_en getDescrizione_en(Corso corso) throws DataLayerException {
        try {
            sDescrizione_enByCorso.setInt(1,corso.getID());
            try (ResultSet rs=sDescrizione_enByCorso.executeQuery()) {
                if(rs.next())
                    return createDescrizione_en(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load Descrizione_en by Corso",ex);
        }
        return null;
    }

    @Override
    public Dublino_it getDublino_it(Corso corso) throws DataLayerException {
        try {
            sDublino_itByCorso.setInt(1,corso.getID());
            try (ResultSet rs=sDublino_itByCorso.executeQuery()) {
                if(rs.next())
                    return createDublino_it(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load Dublino_it by Corso",ex);
        }
        return null;
    }

    @Override
    public Dublino_en getDublino_en(Corso corso) throws DataLayerException {
        try {
            sDublino_enByCorso.setInt(1,corso.getID());
            try (ResultSet rs=sDublino_enByCorso.executeQuery()) {
                if(rs.next())
                    return createDublino_en(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load Dublino_en by Corso",ex);
        }
        return null;
    }

    @Override
    public Materiale getMateriale(int IDMateriale) throws DataLayerException {
        try {
            sMaterialeByID.setInt(1,IDMateriale);
            try (ResultSet rs=sMaterialeByID.executeQuery()) {
                if(rs.next())
                    return createMateriale(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load Materiale by ID",ex);
        }
        return null;
    }

    @Override
    public Libro getLibro(int IDLibro) throws DataLayerException {
        try {
            sLibroByID.setInt(1,IDLibro);
            try (ResultSet rs=sLibroByID.executeQuery()) {
                if(rs.next())
                    return createLibro(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load Libro by ID",ex);
        }
        return null;
    }

    @Override
    public Gruppo getGruppo(int IDGruppo) throws DataLayerException {
        try {
            sGruppoByID.setInt(1,IDGruppo);
            try (ResultSet rs=sGruppoByID.executeQuery()) {
                if(rs.next())
                    return createGruppo(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load Gruppo by ID",ex);
        }
        return null;
    }

    @Override
    public Utente getUtente(int IDUtente) throws DataLayerException {
        try {
            sUtenteByID.setInt(1,IDUtente);
            try (ResultSet rs=sUtenteByID.executeQuery()) {
                if(rs.next())
                    return createUtente(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load Utente by ID",ex);
        }
        return null;
    }

    
     
    
    @Override
    public Servizio getServizio(int IDServizio) throws DataLayerException {
        try {
            sServizioByID.setInt(1,IDServizio);
            try (ResultSet rs=sServizioByID.executeQuery()) {
                if(rs.next())
                    return createServizio(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load Servizio by ID",ex);
        }
        return null;
    }

    @Override
    public Log getLog(int IDLog) throws DataLayerException {
        try {
            sLogByID.setInt(1,IDLog);
            try (ResultSet rs=sLogByID.executeQuery()) {
                if(rs.next())
                    return createLog(rs);
            }
        }
        catch (SQLException ex){
            throw new DataLayerException("Unable to load Log by ID",ex);
        }
        return null;
    }

    @Override
    public List<Corso> getCorsiMutuati(Corso corso) throws DataLayerException {
        List<Corso> result = new ArrayList();
        try {
            sCorsiMutuatiByCorso.setInt(1,corso.getID());
            try (ResultSet rs=sCorsiMutuatiByCorso.executeQuery()) {
                while (rs.next()){
                    result.add(getCorso(rs.getInt("Other_Corso")));
                }
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load CorsiMutuati by Corso", ex);
        }
        return result;
    }

    @Override
    public List<Corso> getCorsiPrerequisiti(Corso corso) throws DataLayerException {
        List<Corso> result = new ArrayList();
        try {
            sCorsiPrerequisitiByCorso.setInt(1,corso.getID());
            try (ResultSet rs=sCorsiPrerequisitiByCorso.executeQuery()) {
                while (rs.next()){
                    result.add(getCorso(rs.getInt("Other_Corso")));
                }
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load CorsiPrerequisiti by Corso", ex);
        }
        return result;
    }

    @Override
    public List<Corso> getCorsiModulo(Corso corso) throws DataLayerException {
        List<Corso> result = new ArrayList();
        try {
            sCorsiModuloByCorso.setInt(1,corso.getID());
            try (ResultSet rs=sCorsiModuloByCorso.executeQuery()) {
                while (rs.next()){
                    result.add(getCorso(rs.getInt("Other_Corso")));
                }
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load CorsiModulo by Corso", ex);
        }
        return result;
    }

    @Override
    public List<Docente> getDocentiCorso(Corso corso) throws DataLayerException {
        List<Docente> result = new ArrayList();
        try {
            sDocentiByCorso.setInt(1,corso.getID());
            try (ResultSet rs=sDocentiByCorso.executeQuery()) {
                while (rs.next()){
                    result.add(getDocente(rs.getInt("Docente")));
                }
            }
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to load DocentiCorso by Corso", ex);
        }
        return result;
    }

    @Override
    public List<Libro> getLibriCorso(Corso corso) throws DataLayerException {
        List<Libro> result=new ArrayList();
        try{
            sLibriByCorso.setInt(1, corso.getID());
            try (ResultSet rs=sLibriByCorso.executeQuery()){
                while(rs.next())
                    result.add(getLibro(rs.getInt("Libro")));
            }
        } catch (SQLException ex){
            throw new DataLayerException("Unable to load LibriCorso by Corso",ex);
        }
        return result;
    }

    @Override
    public List<Materiale> getMaterialeCorso(int corso) throws DataLayerException {
        List<Materiale> result = new ArrayList();
        try{
            sMaterialeByCorso.setInt(1, corso);
            try (ResultSet rs=sMaterialeByCorso.executeQuery()){
                while(rs.next())
                    result.add(getMateriale(rs.getInt("IDMateriale")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load MaterialeCorso by Corso",ex);
        }
        return result;
    }

    @Override
    public List<Corso> getCorsiInCdl(CDL cdl) throws DataLayerException {
        List<Corso> result = new ArrayList();
        try{
            sCorsiByCDL.setInt(1, cdl.getIDCDL());
            try (ResultSet rs=sCorsiByCDL.executeQuery()){
                while(rs.next())
                    result.add(getCorso(rs.getInt("Corso")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load CorsiInCdl by CDL",ex);
        }
        return result;
    }
    @Override
    public List<Utente> getUtentiInGruppo(Gruppo gruppo) throws DataLayerException {
        List<Utente> result = new ArrayList();
        try{
            sUtentiByGruppo.setInt(1, gruppo.getIDGruppo());
            try (ResultSet rs=sUtentiByGruppo.executeQuery()){
                while(rs.next())
                    result.add(getUtente(rs.getInt("IDUtente")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load UtentiInGruppo by Gruppo",ex);
        }
        return result;
    }

    @Override
    public List<Servizio> getServiziPerGruppo(Gruppo gruppo) throws DataLayerException {
        List<Servizio> result = new ArrayList();
        try{
            sServiziByGruppo.setInt(1, gruppo.getIDGruppo());
            try (ResultSet rs=sServiziByGruppo.executeQuery()){
                while(rs.next())
                    result.add(getServizio(rs.getInt("Servizio")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load ServiziPerGruppo by Gruppo",ex);
        }
        return result;
    }

    @Override
    public List<Corso> getCorsiDelDocente(Docente docente) throws DataLayerException {
        List<Corso> result = new ArrayList();
        LocalDate date=LocalDate.now();
        int month=date.getMonthValue();
        int year=date.getYear();
        if(month<=6)
            year=year-1;
        try{
            sCorsiByDocente.setInt(1, docente.getIDDocente());
            sCorsiByDocente.setInt(2, year);
            try (ResultSet rs=sCorsiByDocente.executeQuery()){
                while(rs.next())
                    result.add(getCorso(rs.getInt("Corso")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load CorsiDelDocente by Docente",ex);
        }
        return result;
    }

    @Override
    public List<Corso> getCorsiDelLibro(Libro libro) throws DataLayerException {
        List<Corso> result = new ArrayList();
        try{
            sCorsiByLibro.setInt(1, libro.getIDLibro());
            try (ResultSet rs=sCorsiByLibro.executeQuery()){
                while(rs.next())
                    result.add(getCorso(rs.getInt("Corso")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load CorsiDelLibro by Docente",ex);
        }
        return result;
    }
    
    @Override
    public List<Gruppo> getGruppiDelServizio(Servizio servizio) throws DataLayerException {
        List<Gruppo> result = new ArrayList();
        try{
            sGruppiByServizio.setInt(1, servizio.getIDServizio());
            try (ResultSet rs=sGruppiByServizio.executeQuery()){
                while(rs.next())
                    result.add(getGruppo(rs.getInt("Gruppo")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load GruppiDelServizio by Servizio",ex);
        }
        return result;
    }

    @Override
    public List<Corso> getCorso() throws DataLayerException {
        List<Corso> result = new ArrayList();
        try{
            try (ResultSet rs=sCorsi.executeQuery()){
                while(rs.next())
                    result.add(getCorso(rs.getInt("IDCorso")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load sCorso",ex);
        }
        return result;
    }
    
    @Override
    public List<Corso> getCorsiByAnno() throws DataLayerException {
        List<Corso> result = new ArrayList();
        LocalDate date=LocalDate.now();
        int month=date.getMonthValue();
        int year=date.getYear();
        if(month<=6)
            year=year-1;
        try{
            sCorsiByAnno.setInt(1, year);
            try (ResultSet rs=sCorsiByAnno.executeQuery()){
                while(rs.next())
                    result.add(getCorso(rs.getInt("IDCorso")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load sCorsoByAnno",ex);
        }
        return result;
    }

    @Override
    public List<Docente> getDocente() throws DataLayerException {
        List<Docente> result = new ArrayList();
        try{
            try (ResultSet rs=sDocenti.executeQuery()){
                while(rs.next())
                    result.add(getDocente(rs.getInt("IDDocente")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load sDocenti",ex);
        }
        return result;
    }
    
    @Override
    public List<CDL> getCDL() throws DataLayerException {
        List<CDL> result = new ArrayList();
        LocalDate date=LocalDate.now();
        int month=date.getMonthValue();
        int year=date.getYear();
        if(month<=6)
            year=year-1;    
        try{
            sCDL.setInt(1,year);
            try (ResultSet rs=sCDL.executeQuery()){
                while(rs.next())
                    result.add(getCDL(rs.getInt("IDCDL")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load sCDL",ex);
        }
        return result;
    }
    
    @Override
    public List<CDL> getCDLMag() throws DataLayerException {
        List<CDL> result = new ArrayList();
        LocalDate date=LocalDate.now();
        int month=date.getMonthValue();
        int year=date.getYear();
        if(month<=6)
            year=year-1;
        try{
            sCdlByMagistrale.setInt(1, year);
            try (ResultSet rs=sCdlByMagistrale.executeQuery()){
                while(rs.next())
                    result.add(getCDL(rs.getInt("IDCDL")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load sCDLByMagistrale",ex);
        }
        return result;
    }

    @Override
    public List<CDL> getCDLNoMag() throws DataLayerException {
        List<CDL> result = new ArrayList();
        LocalDate date=LocalDate.now();
        int month=date.getMonthValue();
        int year=date.getYear();
        if(month<=6)
            year=year-1;
        try{
            sCdlByTriennale.setInt(1, year);
            try (ResultSet rs=sCdlByTriennale.executeQuery()){
                while(rs.next())
                    result.add(getCDL(rs.getInt("IDCDL")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load sCDLByMagistrale",ex);
        }
        return result;
    }

    
    
    @Override
    public List<CDL> getCDLInCorso(Corso corso) throws DataLayerException {
        List<CDL> result = new ArrayList();
        try{
            sCDLByCorso.setInt(1, corso.getID());
            try (ResultSet rs=sCDLByCorso.executeQuery()){
                while(rs.next())
                    result.add(getCDL(rs.getInt("IDCDL")));
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load CDLInCorso by Corso",ex);
        }
        return result;
    }
    
    
    
    
    @Override //LOGIN QUERY
    public Utente getUtenti(String username, String password) throws DataLayerException {
    try{
            Login.setString(1,username);
            Login.setString(2,password);
            try (ResultSet rs=Login.executeQuery()){
                if(rs.next())
                    return createUtente(rs);
            }
        }catch (SQLException ex){
            throw new DataLayerException("Unable to load Login",ex);
        }
        return null;
    }

    
    
    @Override
    public void storeDocente(Docente docente) throws DataLayerException{
        int key = docente.getIDDocente();
         try {
            if (key > 0) { //update
                //non facciamo nulla se l'oggetto non ha subito modifiche
                //do not store the object if it was not modified
                if (!docente.isDirty()) {
                    return;
                }
                
                uDocente.setString(1, docente.getNome());
                uDocente.setString(2, docente.getCognome());
                
                uDocente.executeUpdate();
                
            } else { //insert
                iDocente.setString(1, docente.getNome());
                iDocente.setString(2, docente.getCognome());
                
                
                if (iDocente.executeUpdate() == 1) {
                    //per leggere la chiave generata dal database
                    //per il record appena inserito, usiamo il metodo
                    //getGeneratedKeys sullo statement.
                    //to read the generated record key from the database
                    //we use the getGeneratedKeys method on the same statement
                    try (ResultSet keys = iDocente.getGeneratedKeys()) {
                        //il valore restituito è un ResultSet con un record
                        //per ciascuna chiave generata (uno solo nel nostro caso)
                        //the returned value is a ResultSet with a distinct record for
                        //each generated key (only one in our case)
                        if (keys.next()) {
                            //i campi del record sono le componenti della chiave
                            //(nel nostro caso, un solo intero)
                            //the record fields are the key componenets
                            //(a single integer in our case)
                            key = keys.getInt(1);
                        }
                    }
                }
            }
            //restituiamo l'oggetto appena inserito RICARICATO
            //dal database tramite le API del modello. In tal
            //modo terremo conto di ogni modifica apportata
            //durante la fase di inserimento
            //we return the just-inserted object RELOADED from the
            //database through our API. In this way, the resulting
            //object will ambed any data correction performed by
            //the DBMS
            if (key > 0) {
                docente.copyFrom(getDocente(key));
            }
            docente.setDirty(false);
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to store docente", ex);
        }
    }
        
        
    
    
    @Override
    public void storeUtente(Utente utente) throws DataLayerException {
        int key = utente.getID();
         try {
            if (key > 0) { //update
                //non facciamo nulla se l'oggetto non ha subito modifiche
                //do not store the object if it was not modified
                if (!utente.isDirty()) {
                    return;
                }
                
                uUtente.setString(1, utente.getUsername());
                uUtente.setString(2, utente.getPassword());
                
                
                
                
                
                uUtente.executeUpdate();
                
            } else { //insert
                
                iUtente.setString(1, utente.getUsername());
                iUtente.setString(2, utente.getPassword());

                iUtente.setInt(4, 2);
                iUtente.setInt(3, utente.getDocente());

                
                
                
                
                
                if (iUtente.executeUpdate() == 1) {
                    //per leggere la chiave generata dal database
                    //per il record appena inserito, usiamo il metodo
                    //getGeneratedKeys sullo statement.
                    //to read the generated record key from the database
                    //we use the getGeneratedKeys method on the same statement
                    try (ResultSet keys = iUtente.getGeneratedKeys()) {
                        //il valore restituito è un ResultSet con un record
                        //per ciascuna chiave generata (uno solo nel nostro caso)
                        //the returned value is a ResultSet with a distinct record for
                        //each generated key (only one in our case)
                        if (keys.next()) {
                            //i campi del record sono le componenti della chiave
                            //(nel nostro caso, un solo intero)
                            //the record fields are the key componenets
                            //(a single integer in our case)
                            key = keys.getInt(1);
                        }
                    }
                }
            }
            //restituiamo l'oggetto appena inserito RICARICATO
            //dal database tramite le API del modello. In tal
            //modo terremo conto di ogni modifica apportata
            //durante la fase di inserimento
            //we return the just-inserted object RELOADED from the
            //database through our API. In this way, the resulting
            //object will ambed any data correction performed by
            //the DBMS
            if (key > 0) {
                utente.copyFrom(getUtente(key));
            }
            utente.setDirty(false);
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to store utente", ex);
        }
    }

    
    
    @Override
    public void storeCorso(Corso corso) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void destroy() {
        //anche chiudere i PreparedStamenent è una buona pratica...
        //also closing PreparedStamenents is a good practice...
        try {
            sCorsoByID.close();
        } catch (SQLException ex) {
            //
        }
        super.destroy();
    }



    

    
}


  