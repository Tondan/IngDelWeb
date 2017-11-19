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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "Corso.findAll", query = "SELECT c FROM Corso c")
    , @NamedQuery(name = "Corso.findByIDCorso", query = "SELECT c FROM Corso c WHERE c.iDCorso = :iDCorso")
    , @NamedQuery(name = "Corso.findByNomeit", query = "SELECT c FROM Corso c WHERE c.nomeit = :nomeit")
    , @NamedQuery(name = "Corso.findByNomeen", query = "SELECT c FROM Corso c WHERE c.nomeen = :nomeen")
    , @NamedQuery(name = "Corso.findBySsd", query = "SELECT c FROM Corso c WHERE c.ssd = :ssd")
    , @NamedQuery(name = "Corso.findByLingua", query = "SELECT c FROM Corso c WHERE c.lingua = :lingua")
    , @NamedQuery(name = "Corso.findBySemestre", query = "SELECT c FROM Corso c WHERE c.semestre = :semestre")
    , @NamedQuery(name = "Corso.findByCfu", query = "SELECT c FROM Corso c WHERE c.cfu = :cfu")
    , @NamedQuery(name = "Corso.findByAnno", query = "SELECT c FROM Corso c WHERE c.anno = :anno")
    , @NamedQuery(name = "Corso.findByTipologia", query = "SELECT c FROM Corso c WHERE c.tipologia = :tipologia")})
public class Corso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer iDCorso;
    @Basic(optional = false)
    @Column(name = "Nome_it")
    private String nomeit;
    @Basic(optional = false)
    @Column(name = "Nome_en")
    private String nomeen;
    @Basic(optional = false)
    private String ssd;
    @Basic(optional = false)
    private String lingua;
    @Basic(optional = false)
    private int semestre;
    @Basic(optional = false)
    private int cfu;
    @Basic(optional = false)
    @Temporal(TemporalType.DATE)
    private Date anno;
    private Character tipologia;
    @JoinTable(name = "docenti_corso", joinColumns = {
        @JoinColumn(name = "Corso", referencedColumnName = "IDCorso")}, inverseJoinColumns = {
        @JoinColumn(name = "Docente", referencedColumnName = "IDDocente")})
    @ManyToMany
    private Collection<Docente> docenteCollection;
    @JoinTable(name = "libri_corso", joinColumns = {
        @JoinColumn(name = "Corso", referencedColumnName = "IDCorso")}, inverseJoinColumns = {
        @JoinColumn(name = "Libro", referencedColumnName = "IDLibro")})
    @ManyToMany
    private Collection<Libro> libroCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "corso1")
    private DublinoEn dublinoEn;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "corso1")
    private DublinoIt dublinoIt;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "corso1")
    private DescrizioneEn descrizioneEn;
    @JoinColumn(name = "CDL", referencedColumnName = "IDCDL")
    @ManyToOne(optional = false)
    private Cdl cdl;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "corso1")
    private DescrizioneIt descrizioneIt;
    @OneToMany(mappedBy = "corso")
    private Collection<Materiale> materialeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corso")
    private Collection<CollegCorsi> collegCorsiCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "corso1")
    private Collection<CollegCorsi> collegCorsiCollection1;

    public Corso() {
    }

    public Corso(Integer iDCorso) {
        this.iDCorso = iDCorso;
    }

    public Corso(Integer iDCorso, String nomeit, String nomeen, String ssd, String lingua, int semestre, int cfu, Date anno) {
        this.iDCorso = iDCorso;
        this.nomeit = nomeit;
        this.nomeen = nomeen;
        this.ssd = ssd;
        this.lingua = lingua;
        this.semestre = semestre;
        this.cfu = cfu;
        this.anno = anno;
    }

    public Integer getIDCorso() {
        return iDCorso;
    }

    public void setIDCorso(Integer iDCorso) {
        this.iDCorso = iDCorso;
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

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getLingua() {
        return lingua;
    }

    public void setLingua(String lingua) {
        this.lingua = lingua;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getCfu() {
        return cfu;
    }

    public void setCfu(int cfu) {
        this.cfu = cfu;
    }

    public Date getAnno() {
        return anno;
    }

    public void setAnno(Date anno) {
        this.anno = anno;
    }

    public Character getTipologia() {
        return tipologia;
    }

    public void setTipologia(Character tipologia) {
        this.tipologia = tipologia;
    }

    @XmlTransient
    public Collection<Docente> getDocenteCollection() {
        return docenteCollection;
    }

    public void setDocenteCollection(Collection<Docente> docenteCollection) {
        this.docenteCollection = docenteCollection;
    }

    @XmlTransient
    public Collection<Libro> getLibroCollection() {
        return libroCollection;
    }

    public void setLibroCollection(Collection<Libro> libroCollection) {
        this.libroCollection = libroCollection;
    }

    public DublinoEn getDublinoEn() {
        return dublinoEn;
    }

    public void setDublinoEn(DublinoEn dublinoEn) {
        this.dublinoEn = dublinoEn;
    }

    public DublinoIt getDublinoIt() {
        return dublinoIt;
    }

    public void setDublinoIt(DublinoIt dublinoIt) {
        this.dublinoIt = dublinoIt;
    }

    public DescrizioneEn getDescrizioneEn() {
        return descrizioneEn;
    }

    public void setDescrizioneEn(DescrizioneEn descrizioneEn) {
        this.descrizioneEn = descrizioneEn;
    }

    public Cdl getCdl() {
        return cdl;
    }

    public void setCdl(Cdl cdl) {
        this.cdl = cdl;
    }

    public DescrizioneIt getDescrizioneIt() {
        return descrizioneIt;
    }

    public void setDescrizioneIt(DescrizioneIt descrizioneIt) {
        this.descrizioneIt = descrizioneIt;
    }

    @XmlTransient
    public Collection<Materiale> getMaterialeCollection() {
        return materialeCollection;
    }

    public void setMaterialeCollection(Collection<Materiale> materialeCollection) {
        this.materialeCollection = materialeCollection;
    }

    @XmlTransient
    public Collection<CollegCorsi> getCollegCorsiCollection() {
        return collegCorsiCollection;
    }

    public void setCollegCorsiCollection(Collection<CollegCorsi> collegCorsiCollection) {
        this.collegCorsiCollection = collegCorsiCollection;
    }

    @XmlTransient
    public Collection<CollegCorsi> getCollegCorsiCollection1() {
        return collegCorsiCollection1;
    }

    public void setCollegCorsiCollection1(Collection<CollegCorsi> collegCorsiCollection1) {
        this.collegCorsiCollection1 = collegCorsiCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCorso != null ? iDCorso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Corso)) {
            return false;
        }
        Corso other = (Corso) object;
        if ((this.iDCorso == null && other.iDCorso != null) || (this.iDCorso != null && !this.iDCorso.equals(other.iDCorso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "prova.Corso[ iDCorso=" + iDCorso + " ]";
    }
    
}
