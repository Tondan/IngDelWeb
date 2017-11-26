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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Toni & Tony
 */
public class IgwDataLayerMysqlImpl extends DataLayerMysqlImpl implements IgwDataLayer {

    private PreparedStatement a; //roba roba roba
    
    @Override
    public void init() throws DataLayerException {
        try {
            super.init();
            
            a=connection.prepareStatement("query sql"); //placeholder per ricordare

        } catch (SQLException ex) {
            throw new DataLayerException("Error initializing newspaper data layer", ex);
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
            c.setNome_it(rs.getString("Nome_it"));
            c.setNome_en(rs.getString("Nome_en"));
            c.setAnno(rs.getInt("Anno"));  //il metodo getYear è stato deprecato https://docs.oracle.com/javase/7/docs/api/java/sql/Time.html probabile che dobbiamo suare caldendar
            c.setCfu(rs.getInt("Cfu"));
  
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
            co.setSSD(rs.getString("SSD"));  
            co.setLingua(rs.getString("Lingua"));
            co.setSemestre(rs.getInt("Semestre"));
            co.setCfu(rs.getInt("CFU"));
            co.setAnno(rs.getInt("Anno"));
            co.setTipologia((char)rs.getInt("Tipologia"));
            co.setIDCDL(rs.getInt("cdl"));
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
            d.setCognome(rs.getString("SSD"));  
            d.setEmail(rs.getString("Email"));
            d.setUfficio(rs.getString("Uffico"));
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
            de.setKnowledge(rs.getString("Prerequisiti"));
            de.setApplication(rs.getString("Obiettivi"));
            de.setEvaluation(rs.getString("Mod_Esame"));  
            de.setCommunication(rs.getString("Mod_Insegnamento"));
            de.setLifelong(rs.getString("Sillabo"));
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
            de.setKnowledge(rs.getString("Prerequisiti"));
            de.setApplication(rs.getString("Obiettivi"));
            de.setEvaluation(rs.getString("Mod_Esame"));  
            de.setCommunication(rs.getString("Mod_Insegnamento"));
            de.setLifelong(rs.getString("Sillabo"));
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
            de.setLink(rs.getString("Mod_Esame"));  
            de.setDescrizione_it(rs.getString("Mod_Insegnamento"));
            de.setDescrizione_en(rs.getString("Sillabo"));
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
            de.setVolume(rs.getString("Volume"));  
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
            de.setEmail(rs.getString("Email"));  
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Corso getCorso(int IDCorso) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Docente getDocente(int IDDocente) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Descrizione_it getDescrizione_it(int Corso) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Descrizione_en getDescrizione_en(int Corso) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dublino_it getDublino_it(int Corso) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Dublino_en getDublino_en(int Corso) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Materiale getMateriale(int IDLibro) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Libro getLibro(int IDLibro) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Gruppo getGruppo(int IDGruppo) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Utente getUtente(int IDUtente) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Servizio getServizio(int IDServizio) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Log getLog(int IDLog) throws DataLayerException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
