/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;
import courseweb.model.interfacce.*;
import courseweb.controller.data.DataLayerException;
import java.util.List;
/**
 *
 * @author Toni & Tony
 */
public class CorsoImpl implements Corso{
    
    private int id;
    
    private CDL cdl;
    
    private int id_cdl;
    
    private String nome_it;
    
    private String nome_en;
    
    private String ssd;
    
    private String lingua;
    
    private int semestre;
    
    private int cfu;
    
    private int anno;
    
    private char tipologia;
    
    private List<Corso> mutuati;
    
    private List<Corso> prerequisiti;
    
    private List<Corso> modulo;
    
    private List<Docente> docenti;
    
    private Descrizione_it descrizione_it;
    
    private Descrizione_en descrizione_en;
    
    private Dublino_it dublino_it;
    
    private Dublino_en dublino_en;
    
    private List<Libro> libri;
    
    private List<Materiale> materiale;
    
    protected IgwDataLayer ownerdatalayer;
    
    protected boolean dirty;
    
    
    public CorsoImpl(IgwDataLayer ownerdatalayer){
        this.ownerdatalayer=ownerdatalayer;
        this.id=0;
        this.cdl=null;
        this.nome_it=null;
        this.nome_en=null;
        this.ssd=null;
        this.lingua=null;
        this.semestre=0;
        this.cfu=0;
        this.anno=0;
        this.tipologia=0;
        this.mutuati=null;
        this.prerequisiti=null;
        this.modulo=null;
        this.docenti=null;
        this.descrizione_en=null;
        this.descrizione_it=null;
        this.dublino_it=null;
        this.dublino_en=null;
        this.libri=null;
        this.materiale=null;
        this.id_cdl=-1;
        this.dirty=false;
    }
    
    @Override
    public void setIDCDL(int id_cdl){
        this.id_cdl=id_cdl;
        this.dirty=true;
    }
    
    
    @Override
    public void setID(int id){
        this.id=id;
        this.dirty=true;
    }
    
    @Override
    public int getID(){
        return this.id;
    }
    
    @Override
    public CDL getCDL() throws DataLayerException{
        if(cdl==null&&id_cdl>0)
            cdl=ownerdatalayer.getCDL(id_cdl);
        return cdl;
    }
    
    @Override
    public void setCDL(CDL cdl){
        this.cdl=cdl;
        this.dirty=true;
    }
    
    @Override
    public String getNome_it(){
        return this.nome_it;
    }
    
    @Override
    public String getNome_en(){
        return this.nome_en;
    }
    
    @Override
    public void setNome_it(String nome){
        this.nome_it=nome;
        this.dirty=true;
    }
    
    @Override
    public void setNome_en(String nome){
        this.nome_en=nome;
        this.dirty=true;
    }
    
    @Override
    public String getSSD(){
        return this.ssd;
    }
    
    @Override
    public void setSSD(String ssd){
        this.ssd=ssd;
        this.dirty=true;
    }
    
    @Override
    public String getLingua(){
        return this.lingua;
    }
    
    @Override
    public void setLingua(String lingua){
        this.lingua=lingua;
        this.dirty=true;
    }
    
    @Override
    public int getSemestre(){
        return this.semestre;
    }
    
    @Override
    public void setSemestre(int semestre){
        this.semestre=semestre;
        this.dirty=true;
    }
    
    @Override
    public int getCfu(){
        return this.cfu;
    }
    
    @Override
    public void setCfu(int cfu){
        this.cfu=cfu;
        this.dirty=true;
    }
    
    @Override
    public int getAnno(){
        return this.anno;
    }
    
    @Override
    public void setAnno(int anno){
        this.anno=anno;
        this.dirty=true;
    }
    
    @Override
    public char getTipologia(){
        return this.tipologia;
    }
    
    @Override
    public void setTipologia(char tipologia){
        this.tipologia=tipologia;
        this.dirty=true;
    }
    
    @Override
    public List<Corso> getCorsiMutuati() throws DataLayerException{
        if(mutuati==null)
            mutuati=ownerdatalayer.getCorsiMutuati(this);
        return mutuati;
    }
    
    @Override
    public void setCorsiMutuati(List<Corso> mutuati){
        this.mutuati=mutuati;
        this.dirty=true;
    }
    
    @Override
    public List<Corso> getCorsiPrerequisiti() throws DataLayerException{
        if(prerequisiti==null)
            prerequisiti=ownerdatalayer.getCorsiPrerequisiti(this);
        return prerequisiti;
    }
    
    @Override
    public void setCorsiPrerequisiti(List<Corso> prerequisiti){
        this.prerequisiti=prerequisiti;
        this.dirty=true;
    }
    
    @Override
    public List<Corso> getCorsiModulo() throws DataLayerException{
        if(modulo==null)
            modulo=ownerdatalayer.getCorsiModulo(this);
        return modulo;
    }
    
    @Override
    public void setCorsiModulo(List<Corso> corsi){
        this.modulo=corsi;
        this.dirty=true;
    }
    
    @Override
    public void addCorsoModulo(Corso corso){
        this.modulo.add(corso);
        this.dirty=true;
    }
    
    @Override
    public void addCorsoMutuato(Corso corso){
        this.mutuati.add(corso);
        this.dirty=true;
    }
    
    @Override
    public void addCorsoPrerequisiti(Corso corso){
        this.prerequisiti.add(corso);
        this.dirty=true;
    }
    
    @Override
    public List<Docente> getDocenti() throws DataLayerException{
        if(docenti==null)
            docenti=ownerdatalayer.getDocentiCorso(this);
        return docenti;
    }
    
    @Override
    public void setDocenti(List<Docente> docenti){
        this.docenti=docenti;
        this.dirty=true;
    }
    
    @Override
    public void addDocente(Docente docente){
        this.docenti.add(docente);
        this.dirty=true;
    }
    
    @Override
    public Descrizione_it getDescrizione_it() throws DataLayerException{
        if(descrizione_it==null)
            descrizione_it=ownerdatalayer.getDescrizione_it(this);
        return descrizione_it;
    }
    
    @Override
    public Descrizione_en getDescrizione_en() throws DataLayerException{
        if(descrizione_en==null)
            descrizione_en=ownerdatalayer.getDescrizione_en(this);
        return descrizione_en;
    }
    
    @Override
    public void setDescrizione_it(Descrizione_it descrizione){
        this.descrizione_it=descrizione;
        this.dirty=true;
    }
    
    @Override
    public void setDescrizione_en(Descrizione_en descrizione){
        this.descrizione_en=descrizione;
        this.dirty=true;
    }
    
    @Override
    public Dublino_it getDublino_it() throws DataLayerException{
        if(dublino_it==null)
            dublino_it=ownerdatalayer.getDublino_it(this);
        return dublino_it;
    }
    
    @Override
    public void setDublino_it(Dublino_it dublino){
        this.dublino_it=dublino;
        this.dirty=true;
    }
    
    @Override
    public Dublino_en getDublino_en() throws DataLayerException{
        if(dublino_en==null)
            dublino_en=ownerdatalayer.getDublino_en(this);
        return dublino_en;
    }
    
    @Override
    public void setDublino_en(Dublino_en dublino){
        this.dublino_en=dublino;
        this.dirty=true;
    }
    
    @Override
    public List<Libro> getLibri() throws DataLayerException{
        if(libri==null)
            libri=ownerdatalayer.getLibriCorso(this);
        return libri;
    }
    
    @Override
    public void setLibri(List<Libro> libri){
        this.libri=libri;
        this.dirty=true;
    }
    
    @Override
    public void addLibro(Libro libro){
        this.libri.add(libro);
        this.dirty=true;
    }
    
    @Override
    public List<Materiale> getMateriale() throws DataLayerException{
        if(materiale==null)
            materiale=ownerdatalayer.getMaterialeCorso(this);
        return materiale;
    }
    
    @Override
    public void setMateriale(List<Materiale> materiale){
        this.materiale=materiale;
    }
    
    @Override
    public void addMateriale(Materiale materiale){
        this.materiale.add(materiale);
    }
}
