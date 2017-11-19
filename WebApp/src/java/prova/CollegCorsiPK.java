/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Chris-PC
 */
@Embeddable
public class CollegCorsiPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "This_Corso")
    private int thisCorso;
    @Basic(optional = false)
    @Column(name = "Other_Corso")
    private int otherCorso;

    public CollegCorsiPK() {
    }

    public CollegCorsiPK(int thisCorso, int otherCorso) {
        this.thisCorso = thisCorso;
        this.otherCorso = otherCorso;
    }

    public int getThisCorso() {
        return thisCorso;
    }

    public void setThisCorso(int thisCorso) {
        this.thisCorso = thisCorso;
    }

    public int getOtherCorso() {
        return otherCorso;
    }

    public void setOtherCorso(int otherCorso) {
        this.otherCorso = otherCorso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) thisCorso;
        hash += (int) otherCorso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CollegCorsiPK)) {
            return false;
        }
        CollegCorsiPK other = (CollegCorsiPK) object;
        if (this.thisCorso != other.thisCorso) {
            return false;
        }
        if (this.otherCorso != other.otherCorso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.CollegCorsiPK[ thisCorso=" + thisCorso + ", otherCorso=" + otherCorso + " ]";
    }
    
}
