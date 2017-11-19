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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Libro.findAll", query = "SELECT l FROM Libro l")
    , @NamedQuery(name = "Libro.findByIDLibro", query = "SELECT l FROM Libro l WHERE l.iDLibro = :iDLibro")
    , @NamedQuery(name = "Libro.findByAutore", query = "SELECT l FROM Libro l WHERE l.autore = :autore")
    , @NamedQuery(name = "Libro.findByTitolo", query = "SELECT l FROM Libro l WHERE l.titolo = :titolo")
    , @NamedQuery(name = "Libro.findByVolume", query = "SELECT l FROM Libro l WHERE l.volume = :volume")
    , @NamedQuery(name = "Libro.findByAnno", query = "SELECT l FROM Libro l WHERE l.anno = :anno")
    , @NamedQuery(name = "Libro.findByEditore", query = "SELECT l FROM Libro l WHERE l.editore = :editore")})
public class Libro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer iDLibro;
    @Basic(optional = false)
    private String autore;
    @Basic(optional = false)
    private String titolo;
    private Integer volume;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date anno;
    private String editore;
    @Lob
    private String link;
    @ManyToMany(mappedBy = "libroCollection")
    private Collection<Corso> corsoCollection;

    public Libro() {
    }

    public Libro(Integer iDLibro) {
        this.iDLibro = iDLibro;
    }

    public Libro(Integer iDLibro, String autore, String titolo, Date anno) {
        this.iDLibro = iDLibro;
        this.autore = autore;
        this.titolo = titolo;
        this.anno = anno;
    }

    public Integer getIDLibro() {
        return iDLibro;
    }

    public void setIDLibro(Integer iDLibro) {
        this.iDLibro = iDLibro;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public Date getAnno() {
        return anno;
    }

    public void setAnno(Date anno) {
        this.anno = anno;
    }

    public String getEditore() {
        return editore;
    }

    public void setEditore(String editore) {
        this.editore = editore;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
        hash += (iDLibro != null ? iDLibro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Libro)) {
            return false;
        }
        Libro other = (Libro) object;
        if ((this.iDLibro == null && other.iDLibro != null) || (this.iDLibro != null && !this.iDLibro.equals(other.iDLibro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.Libro[ iDLibro=" + iDLibro + " ]";
    }
    
}
