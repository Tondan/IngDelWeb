/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Utente.findAll", query = "SELECT u FROM Utente u")
    , @NamedQuery(name = "Utente.findByIDUtente", query = "SELECT u FROM Utente u WHERE u.iDUtente = :iDUtente")
    , @NamedQuery(name = "Utente.findByUsername", query = "SELECT u FROM Utente u WHERE u.username = :username")
    , @NamedQuery(name = "Utente.findByPassword", query = "SELECT u FROM Utente u WHERE u.password = :password")
    , @NamedQuery(name = "Utente.findByEmail", query = "SELECT u FROM Utente u WHERE u.email = :email")})
public class Utente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer iDUtente;
    private String username;
    private String password;
    private String email;
    @JoinColumn(name = "Gruppo", referencedColumnName = "IDGruppo")
    @ManyToOne
    private Gruppo gruppo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "utente")
    private Collection<Log> logCollection;

    public Utente() {
    }

    public Utente(Integer iDUtente) {
        this.iDUtente = iDUtente;
    }

    public Integer getIDUtente() {
        return iDUtente;
    }

    public void setIDUtente(Integer iDUtente) {
        this.iDUtente = iDUtente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gruppo getGruppo() {
        return gruppo;
    }

    public void setGruppo(Gruppo gruppo) {
        this.gruppo = gruppo;
    }

    @XmlTransient
    public Collection<Log> getLogCollection() {
        return logCollection;
    }

    public void setLogCollection(Collection<Log> logCollection) {
        this.logCollection = logCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDUtente != null ? iDUtente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utente)) {
            return false;
        }
        Utente other = (Utente) object;
        if ((this.iDUtente == null && other.iDUtente != null) || (this.iDUtente != null && !this.iDUtente.equals(other.iDUtente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.Utente[ iDUtente=" + iDUtente + " ]";
    }
    
}
