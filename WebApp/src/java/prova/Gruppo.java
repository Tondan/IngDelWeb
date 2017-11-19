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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Chris-PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gruppo.findAll", query = "SELECT g FROM Gruppo g")
    , @NamedQuery(name = "Gruppo.findByIDGruppo", query = "SELECT g FROM Gruppo g WHERE g.iDGruppo = :iDGruppo")
    , @NamedQuery(name = "Gruppo.findByNome", query = "SELECT g FROM Gruppo g WHERE g.nome = :nome")})
public class Gruppo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer iDGruppo;
    private String nome;
    @JoinTable(name = "group_services", joinColumns = {
        @JoinColumn(name = "Gruppo", referencedColumnName = "IDGruppo")}, inverseJoinColumns = {
        @JoinColumn(name = "Servizio", referencedColumnName = "IDServizio")})
    @ManyToMany
    private Collection<Servizio> servizioCollection;
    @OneToMany(mappedBy = "gruppo")
    private Collection<Utente> utenteCollection;

    public Gruppo() {
    }

    public Gruppo(Integer iDGruppo) {
        this.iDGruppo = iDGruppo;
    }

    public Integer getIDGruppo() {
        return iDGruppo;
    }

    public void setIDGruppo(Integer iDGruppo) {
        this.iDGruppo = iDGruppo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Servizio> getServizioCollection() {
        return servizioCollection;
    }

    public void setServizioCollection(Collection<Servizio> servizioCollection) {
        this.servizioCollection = servizioCollection;
    }

    @XmlTransient
    public Collection<Utente> getUtenteCollection() {
        return utenteCollection;
    }

    public void setUtenteCollection(Collection<Utente> utenteCollection) {
        this.utenteCollection = utenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDGruppo != null ? iDGruppo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gruppo)) {
            return false;
        }
        Gruppo other = (Gruppo) object;
        if ((this.iDGruppo == null && other.iDGruppo != null) || (this.iDGruppo != null && !this.iDGruppo.equals(other.iDGruppo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.Gruppo[ iDGruppo=" + iDGruppo + " ]";
    }
    
}
