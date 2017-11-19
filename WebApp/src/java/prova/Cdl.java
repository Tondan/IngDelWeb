/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chris-PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cdl.findAll", query = "SELECT c FROM Cdl c")
    , @NamedQuery(name = "Cdl.findByIdcdl", query = "SELECT c FROM Cdl c WHERE c.idcdl = :idcdl")
    , @NamedQuery(name = "Cdl.findByNomeit", query = "SELECT c FROM Cdl c WHERE c.nomeit = :nomeit")
    , @NamedQuery(name = "Cdl.findByNomeen", query = "SELECT c FROM Cdl c WHERE c.nomeen = :nomeen")
    , @NamedQuery(name = "Cdl.findByAnno", query = "SELECT c FROM Cdl c WHERE c.anno = :anno")
    , @NamedQuery(name = "Cdl.findByCfu", query = "SELECT c FROM Cdl c WHERE c.cfu = :cfu")})
public class Cdl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idcdl;
    @Basic(optional = false)
    @Column(name = "Nome_it")
    private String nomeit;
    @Basic(optional = false)
    @Column(name = "Nome_en")
    private String nomeen;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date anno;
    @Basic(optional = false)
    private int cfu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cdl")
    private Collection<Corso> corsoCollection;

    public Cdl() {
    }

    public Cdl(Integer idcdl) {
        this.idcdl = idcdl;
    }

    public Cdl(Integer idcdl, String nomeit, String nomeen, Date anno, int cfu) {
        this.idcdl = idcdl;
        this.nomeit = nomeit;
        this.nomeen = nomeen;
        this.anno = anno;
        this.cfu = cfu;
    }

    public Integer getIdcdl() {
        return idcdl;
    }

    public void setIdcdl(Integer idcdl) {
        this.idcdl = idcdl;
    }

    public String getNomeit() {
        return nomeit;
    }

    public void setNomeit(String nomeit) {
        this.nomeit = nomeit;
    }

    public String getNomeen() {
        return nomeen;
    }

    public void setNomeen(String nomeen) {
        this.nomeen = nomeen;
    }

    public Date getAnno() {
        return anno;
    }

    public void setAnno(Date anno) {
        this.anno = anno;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    @XmlTransient
    public Collection<Corso> getCorsoCollection() {
        return corsoCollection;
    }

    public void setCorsoCollection(Collection<Corso> corsoCollection) {
        this.corsoCollection = corsoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcdl != null ? idcdl.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cdl)) {
            return false;
        }
        Cdl other = (Cdl) object;
        if ((this.idcdl == null && other.idcdl != null) || (this.idcdl != null && !this.idcdl.equals(other.idcdl))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.Cdl[ idcdl=" + idcdl + " ]";
    }
    
}
