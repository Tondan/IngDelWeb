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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chris-PC
 */
@Entity
@Table(name = "descrizione_en")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescrizioneEn.findAll", query = "SELECT d FROM DescrizioneEn d")
    , @NamedQuery(name = "DescrizioneEn.findByCorso", query = "SELECT d FROM DescrizioneEn d WHERE d.corso = :corso")})
public class DescrizioneEn implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer corso;
    @Basic(optional = false)
    @Lob
    private String prerequisiti;
    @Lob
    private String obiettivi;
    @Basic(optional = false)
    @Lob
    @Column(name = "Mod_Esame")
    private String modEsame;
    @Basic(optional = false)
    @Lob
    @Column(name = "Mod_Insegnamento")
    private String modInsegnamento;
    @Basic(optional = false)
    @Lob
    private String sillabo;
    @Lob
    private String note;
    @Lob
    private String homepage;
    @Lob
    private String forum;
    @Lob
    @Column(name = "Risorse_ext")
    private String risorseext;
    @JoinColumn(name = "Corso", referencedColumnName = "IDCorso", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Corso corso1;

    public DescrizioneEn() {
    }

    public DescrizioneEn(Integer corso) {
        this.corso = corso;
    }

    public DescrizioneEn(Integer corso, String prerequisiti, String modEsame, String modInsegnamento, String sillabo) {
        this.corso = corso;
        this.prerequisiti = prerequisiti;
        this.modEsame = modEsame;
        this.modInsegnamento = modInsegnamento;
        this.sillabo = sillabo;
    }

    public Integer getCorso() {
        return corso;
    }

    public void setCorso(Integer corso) {
        this.corso = corso;
    }

    public String getPrerequisiti() {
        return prerequisiti;
    }

    public void setPrerequisiti(String prerequisiti) {
        this.prerequisiti = prerequisiti;
    }

    public String getObiettivi() {
        return obiettivi;
    }

    public void setObiettivi(String obiettivi) {
        this.obiettivi = obiettivi;
    }

    public String getModEsame() {
        return modEsame;
    }

    public void setModEsame(String modEsame) {
        this.modEsame = modEsame;
    }

    public String getModInsegnamento() {
        return modInsegnamento;
    }

    public void setModInsegnamento(String modInsegnamento) {
        this.modInsegnamento = modInsegnamento;
    }

    public String getSillabo() {
        return sillabo;
    }

    public void setSillabo(String sillabo) {
        this.sillabo = sillabo;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public String getRisorseext() {
        return risorseext;
    }

    public void setRisorseext(String risorseext) {
        this.risorseext = risorseext;
    }

    public Corso getCorso1() {
        return corso1;
    }

    public void setCorso1(Corso corso1) {
        this.corso1 = corso1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (corso != null ? corso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DescrizioneEn)) {
            return false;
        }
        DescrizioneEn other = (DescrizioneEn) object;
        if ((this.corso == null && other.corso != null) || (this.corso != null && !this.corso.equals(other.corso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.DescrizioneEn[ corso=" + corso + " ]";
    }
    
}
