/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova;

import java.io.Serializable;
import javax.persistence.Basic;
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
@Table(name = "dublino_it")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DublinoIt.findAll", query = "SELECT d FROM DublinoIt d")
    , @NamedQuery(name = "DublinoIt.findByCorso", query = "SELECT d FROM DublinoIt d WHERE d.corso = :corso")})
public class DublinoIt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    private Integer corso;
    @Lob
    private String knowledge;
    @Lob
    private String application;
    @Lob
    private String evaluation;
    @Lob
    private String communication;
    @Lob
    private String lifelong;
    @JoinColumn(name = "Corso", referencedColumnName = "IDCorso", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Corso corso1;

    public DublinoIt() {
    }

    public DublinoIt(Integer corso) {
        this.corso = corso;
    }

    public Integer getCorso() {
        return corso;
    }

    public void setCorso(Integer corso) {
        this.corso = corso;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public String getLifelong() {
        return lifelong;
    }

    public void setLifelong(String lifelong) {
        this.lifelong = lifelong;
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
        if (!(object instanceof DublinoIt)) {
            return false;
        }
        DublinoIt other = (DublinoIt) object;
        if ((this.corso == null && other.corso != null) || (this.corso != null && !this.corso.equals(other.corso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.DublinoIt[ corso=" + corso + " ]";
    }
    
}
