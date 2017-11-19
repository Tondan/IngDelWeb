/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chris-PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servizio.findAll", query = "SELECT s FROM Servizio s")
    , @NamedQuery(name = "Servizio.findByIDServizio", query = "SELECT s FROM Servizio s WHERE s.iDServizio = :iDServizio")
    , @NamedQuery(name = "Servizio.findByScript", query = "SELECT s FROM Servizio s WHERE s.script = :script")})
public class Servizio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer iDServizio;
    @Basic(optional = false)
    private String script;
    @Lob
    private String descrizione;
    @ManyToMany(mappedBy = "servizioCollection")
    private Collection<Gruppo> gruppoCollection;

    public Servizio() {
    }

    public Servizio(Integer iDServizio) {
        this.iDServizio = iDServizio;
    }

    public Servizio(Integer iDServizio, String script) {
        this.iDServizio = iDServizio;
        this.script = script;
    }

    public Integer getIDServizio() {
        return iDServizio;
    }

    public void setIDServizio(Integer iDServizio) {
        this.iDServizio = iDServizio;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    @XmlTransient
    public Collection<Gruppo> getGruppoCollection() {
        return gruppoCollection;
    }

    public void setGruppoCollection(Collection<Gruppo> gruppoCollection) {
        this.gruppoCollection = gruppoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDServizio != null ? iDServizio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servizio)) {
            return false;
        }
        Servizio other = (Servizio) object;
        if ((this.iDServizio == null && other.iDServizio != null) || (this.iDServizio != null && !this.iDServizio.equals(other.iDServizio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.Servizio[ iDServizio=" + iDServizio + " ]";
    }
    
}
