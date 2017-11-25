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
import java.util.Calendar;

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
            throw new DataLayerException("Unable to create author object form ResultSet", ex);
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
            throw new DataLayerException("Unable to create author object form ResultSet", ex);
        }
    }
    
    @Override
    public Docente createDocente() {
        return new DocenteImpl(this);
    }
    
        public Docente createDocente(ResultSet rs) throws DataLayerException {
        try {
            CorsoImpl d = new CorsoImpl(this);
            
            d.setIDDocente(rs.getInt("ID")); 
            d.setNome_it(rs.getString("Nome_it"));
            d.setNome_en(rs.getString("Nome_en"));
            d.setSSD(rs.getString("SSD"));  
            d.setLingua(rs.getString("Lingua"));
            d.setSemestre(rs.getInt("Semestre"));
            d.setCfu(rs.getInt("CFU"));
            d.setAnno(rs.getInt("Anno"));
            d.setTipologia((char)rs.getInt("Tipologia"));
            d.setIDCDL(rs.getInt("cdl"));
            return d;
        } catch (SQLException ex) {
            throw new DataLayerException("Unable to create author object form ResultSet", ex);
        }
    }
    
    @Override
    public Descrizione_it createDescrizione_it() {
        return new Descrizione_itImpl(this);
    }

    @Override
    public Descrizione_en createDescrizione_en() {
        return new Descrizione_enImpl(this);
    }

    @Override
    public Dublino_it createDublino_it() {
        return new Dublino_itImpl(this);
    }

    @Override
    public Dublino_en createDublino_en() {
        return new Dublino_enImpl(this);
    }

    @Override
    public Materiale createMateriale() {
        return (Materiale) new MaterialeImpl(this);
    }

    @Override
    public Libro createLibro() {
        return new LibroImpl(this);
    }

    @Override
    public Gruppo createGruppo() {
        return (Gruppo) new GruppoImpl(this);
    }

    @Override
    public Utente createUtente() {
        return (Utente) new UtenteImpl(this);
    }

    @Override
    public Servizio createServizio() {
        return new ServizioImpl(this);
    }

    @Override
    public Log CreateLog() {
        return (Log) new LogImpl(this);
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
