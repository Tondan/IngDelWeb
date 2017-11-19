/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chris-PC
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Materiale.findAll", query = "SELECT m FROM Materiale m")
    , @NamedQuery(name = "Materiale.findByIDMateriale", query = "SELECT m FROM Materiale m WHERE m.iDMateriale = :iDMateriale")
    , @NamedQuery(name = "Materiale.findByNome", query = "SELECT m FROM Materiale m WHERE m.nome = :nome")})
public class Materiale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer iDMateriale;
    @Basic(optional = false)
    private String nome;
    @Basic(optional = false)
    @Lob
    private String link;
    @Lob
    @Column(name = "Descrizione_it")
    private String descrizioneit;
    @Lob
    @Column(name = "Descizione_en")
    private String descizioneen;
    @JoinColumn(name = "Corso", referencedColumnName = "IDCorso")
    @ManyToOne
    private Corso corso;

    public Materiale() {
    }

    public Materiale(Integer iDMateriale) {
        this.iDMateriale = iDMateriale;
    }

    public Materiale(Integer iDMateriale, String nome, String link) {
        this.iDMateriale = iDMateriale;
        this.nome = nome;
        this.link = link;
    }

    public Integer getIDMateriale() {
        return iDMateriale;
    }

    public void setIDMateriale(Integer iDMateriale) {
        this.iDMateriale = iDMateriale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescrizioneit() {
        return descrizioneit;
    }

    public void setDescrizioneit(String descrizioneit) {
        this.descrizioneit = descrizioneit;
    }

    public String getDescizioneen() {
        return descizioneen;
    }

    public void setDescizioneen(String descizioneen) {
        this.descizioneen = descizioneen;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDMateriale != null ? iDMateriale.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materiale)) {
            return false;
        }
        Materiale other = (Materiale) object;
        if ((this.iDMateriale == null && other.iDMateriale != null) || (this.iDMateriale != null && !this.iDMateriale.equals(other.iDMateriale))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.Materiale[ iDMateriale=" + iDMateriale + " ]";
    }
    
}
