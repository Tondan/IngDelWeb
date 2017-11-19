/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Chris-PC
 */
@Entity
@Table(name = "colleg_corsi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CollegCorsi.findAll", query = "SELECT c FROM CollegCorsi c")
    , @NamedQuery(name = "CollegCorsi.findByThisCorso", query = "SELECT c FROM CollegCorsi c WHERE c.collegCorsiPK.thisCorso = :thisCorso")
    , @NamedQuery(name = "CollegCorsi.findByOtherCorso", query = "SELECT c FROM CollegCorsi c WHERE c.collegCorsiPK.otherCorso = :otherCorso")
    , @NamedQuery(name = "CollegCorsi.findByTipo", query = "SELECT c FROM CollegCorsi c WHERE c.tipo = :tipo")})
public class CollegCorsi implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CollegCorsiPK collegCorsiPK;
    @Basic(optional = false)
    private String tipo;
    @JoinColumn(name = "This_Corso", referencedColumnName = "IDCorso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Corso corso;
    @JoinColumn(name = "Other_Corso", referencedColumnName = "IDCorso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Corso corso1;

    public CollegCorsi() {
    }

    public CollegCorsi(CollegCorsiPK collegCorsiPK) {
        this.collegCorsiPK = collegCorsiPK;
    }

    public CollegCorsi(CollegCorsiPK collegCorsiPK, String tipo) {
        this.collegCorsiPK = collegCorsiPK;
        this.tipo = tipo;
    }

    public CollegCorsi(int thisCorso, int otherCorso) {
        this.collegCorsiPK = new CollegCorsiPK(thisCorso, otherCorso);
    }

    public CollegCorsiPK getCollegCorsiPK() {
        return collegCorsiPK;
    }

    public void setCollegCorsiPK(CollegCorsiPK collegCorsiPK) {
        this.collegCorsiPK = collegCorsiPK;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Corso getCorso() {
        return corso;
    }

    public void setCorso(Corso corso) {
        this.corso = corso;
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
        hash += (collegCorsiPK != null ? collegCorsiPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollegCorsi)) {
            return false;
        }
        CollegCorsi other = (CollegCorsi) object;
        if ((this.collegCorsiPK == null && other.collegCorsiPK != null) || (this.collegCorsiPK != null && !this.collegCorsiPK.equals(other.collegCorsiPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.CollegCorsi[ collegCorsiPK=" + collegCorsiPK + " ]";
    }
    
}
