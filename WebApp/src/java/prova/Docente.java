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
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d")
    , @NamedQuery(name = "Docente.findByIDDocente", query = "SELECT d FROM Docente d WHERE d.iDDocente = :iDDocente")
    , @NamedQuery(name = "Docente.findByNome", query = "SELECT d FROM Docente d WHERE d.nome = :nome")
    , @NamedQuery(name = "Docente.findByCognome", query = "SELECT d FROM Docente d WHERE d.cognome = :cognome")
    , @NamedQuery(name = "Docente.findByEmail", query = "SELECT d FROM Docente d WHERE d.email = :email")
    , @NamedQuery(name = "Docente.findByUfficio", query = "SELECT d FROM Docente d WHERE d.ufficio = :ufficio")
    , @NamedQuery(name = "Docente.findByTelefono", query = "SELECT d FROM Docente d WHERE d.telefono = :telefono")
    , @NamedQuery(name = "Docente.findBySpecializzazione", query = "SELECT d FROM Docente d WHERE d.specializzazione = :specializzazione")})
public class Docente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer iDDocente;
    @Lob
    private String immagine;
    @Basic(optional = false)
    private String nome;
    @Basic(optional = false)
    private String cognome;
    @Basic(optional = false)
    private String email;
    @Basic(optional = false)
    private String ufficio;
    @Basic(optional = false)
    private String telefono;
    @Basic(optional = false)
    private String specializzazione;
    @Lob
    private String ricerche;
    @Lob
    private String pubblicazioni;
    @Lob
    private String curriculum;
    @Basic(optional = false)
    @Lob
    private String ricevimento;
    @ManyToMany(mappedBy = "docenteCollection")
    private Collection<Corso> corsoCollection;

    public Docente() {
    }

    public Docente(Integer iDDocente) {
        this.iDDocente = iDDocente;
    }

    public Docente(Integer iDDocente, String nome, String cognome, String email, String ufficio, String telefono, String specializzazione, String ricevimento) {
        this.iDDocente = iDDocente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ufficio = ufficio;
        this.telefono = telefono;
        this.specializzazione = specializzazione;
        this.ricevimento = ricevimento;
    }

    public Integer getIDDocente() {
        return iDDocente;
    }

    public void setIDDocente(Integer iDDocente) {
        this.iDDocente = iDDocente;
    }

    public String getImmagine() {
        return immagine;
    }

    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUfficio() {
        return ufficio;
    }

    public void setUfficio(String ufficio) {
        this.ufficio = ufficio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public String getRicerche() {
        return ricerche;
    }

    public void setRicerche(String ricerche) {
        this.ricerche = ricerche;
    }

    public String getPubblicazioni() {
        return pubblicazioni;
    }

    public void setPubblicazioni(String pubblicazioni) {
        this.pubblicazioni = pubblicazioni;
    }

    public String getCurriculum() {
        return curriculum;
    }

    public void setCurriculum(String curriculum) {
        this.curriculum = curriculum;
    }

    public String getRicevimento() {
        return ricevimento;
    }

    public void setRicevimento(String ricevimento) {
        this.ricevimento = ricevimento;
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
        hash += (iDDocente != null ? iDDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.iDDocente == null && other.iDDocente != null) || (this.iDDocente != null && !this.iDDocente.equals(other.iDDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.Docente[ iDDocente=" + iDDocente + " ]";
    }
    
}
