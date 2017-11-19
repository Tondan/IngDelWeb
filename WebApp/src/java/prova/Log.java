/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chris-PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l")
    , @NamedQuery(name = "Log.findByIDLog", query = "SELECT l FROM Log l WHERE l.iDLog = :iDLog")
    , @NamedQuery(name = "Log.findByData", query = "SELECT l FROM Log l WHERE l.data = :data")})
public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer iDLog;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Lob
    private String descrizione;
    @JoinColumn(name = "Utente", referencedColumnName = "IDUtente")
    @ManyToOne(optional = false)
    private Utente utente;

    public Log() {
    }

    public Log(Integer iDLog) {
        this.iDLog = iDLog;
    }

    public Log(Integer iDLog, Date data) {
        this.iDLog = iDLog;
        this.data = data;
    }

    public Integer getIDLog() {
        return iDLog;
    }

    public void setIDLog(Integer iDLog) {
        this.iDLog = iDLog;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDLog != null ? iDLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.iDLog == null && other.iDLog != null) || (this.iDLog != null && !this.iDLog.equals(other.iDLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.Log[ iDLog=" + iDLog + " ]";
    }
    
}
