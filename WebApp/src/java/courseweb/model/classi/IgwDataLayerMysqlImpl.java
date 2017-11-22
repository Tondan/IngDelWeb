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
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Toni & Tony
 */
public class IgwDataLayerMysqlImpl extends DataLayerMysqlImpl implements IgwDataLayer {

    public IgwDataLayerMysqlImpl(DataSource datasource) throws SQLException, NamingException {
        super(datasource);
    }

    @Override
    public CDL createCDL() {
        return new CDLImpl(this);
    }

    @Override
    public Corso createCorso() {
        return new CorsoImpl(this);
    }

    @Override
    public Docente createDocente() {
        return new DocenteImpl(this);
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
