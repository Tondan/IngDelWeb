/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;
import courseweb.model.interfacce.*;
import courseweb.controller.data.DataLayerException;
import java.time.Year;
import java.util.List;
/**
 *
 * @author Toni & Tony
 */
public class CorsoImpl implements Corso{
    
    private int id;
    
    private CDL cdl;
    
    private String nome_it;
    
    private String nome_en;
    
    private String ssd;
    
    private String lingua;
    
    private int semestre;
    
    private int cfu;
    
    private Year anno;
    
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
        this.anno=null;
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
    }
    
    @Override
    public void setID(int id){
        this.id=id;
    }
    
    @Override
    public int getID(){
        return this.id;
    }
    
    @Override
    public CDL getCDL() throws DataLayerException{
        return this.cdl;
    }
    
    @Override
    public void setCDL(CDL cdl){
        this.cdl=cdl;
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
    }
    
    @Override
    public void setNome_en(String nome){
        this.nome_en=nome;
    }
    
    @Override
    public String getSSD(){
        return this.ssd;
    }
    
    @Override
    public void setSSD(String ssd){
        this.ssd=ssd;
    }
    
    @Override
    public String getLingua(){
        return this.lingua;
    }
    
    @Override
    public void setLingua(String lingua){
        this.lingua=lingua;
    }
    
    @Override
    public int getSemestre(){
        return this.semestre;
    }
    
    @Override
    public void setSemestre(int semestre){
        this.semestre=semestre;
    }
    
    @Override
    public int getCfu(){
        return this.semestre;
    }
    
    @Override
    public void setCfu(int cfu){
        this.cfu=cfu;
    }
    
    @Override
    public Year getAnno(){
        return this.anno;
    }
    
    @Override
    public void setAnno(Year anno){
        this.anno=anno;
    }
    
    @Override
    public char getTipologia(){
        return this.tipologia;
    }
    
    @Override
    public void setTipologia(char tipologia){
        this.tipologia=tipologia;
    }
    
    @Override
    public List<Corso> getCorsiMutuati() throws DataLayerException{
        return this.mutuati;
    }
    
    @Override
    public void setCorsiMutuati(List<Corso> mutuati){
        this.mutuati=mutuati;
    }
    
    @Override
    public List<Corso> getCorsiPrerequisiti() throws DataLayerException{
        return this.prerequisiti;
    }
    
    @Override
    public void setCorsiPrerequisiti(List<Corso> prerequisiti){
        this.prerequisiti=prerequisiti;
    }
    
    @Override
    public List<Corso> getCorsiModulo() throws DataLayerException{
        return this.modulo;
    }
    
    @Override
    public void setCorsiModulo(List<Corso> corsi){
        this.modulo=corsi;
    }
    
    @Override
    public void addCorsoModulo(Corso corso){
        this.modulo.add(corso);
    }
    
    @Override
    public void addCorsoMutuato(Corso corso){
        this.mutuati.add(corso);
    }
    
    @Override
    public void addCorsoPrerequisiti(Corso corso){
        this.prerequisiti.add(corso);
    }
    
    @Override
    public List<Docente> getDocenti() throws DataLayerException{
        return this.docenti;
    }
    
    @Override
    public void setDocenti(List<Docente> docenti){
        this.docenti=docenti;
    }
    
    @Override
    public void addDocente(Docente docente){
        this.docenti.add(docente);
    }
    
    @Override
    public Descrizione_it getDescrizione_it() throws DataLayerException{
        return this.descrizione_it;
    }
    
    @Override
    public Descrizione_en getDescrizione_en() throws DataLayerException{
        return this.descrizione_en;
    }
    
    @Override
    public void setDescrizione_it(Descrizione_it descrizione){
        this.descrizione_it=descrizione;
    }
    
    @Override
    public void setDescrizione_en(Descrizione_en descrizione){
        this.descrizione_en=descrizione;
    }
    
    @Override
    public Dublino_it getDublino_it() throws DataLayerException{
        return this.dublino_it;
    }
    
    @Override
    public void setDublino_it(Dublino_it dublino){
        this.dublino_it=dublino;
    }
    
    @Override
    public Dublino_en getDublino_en() throws DataLayerException{
        return this.dublino_en;
    }
    
    @Override
    public void setDublino_en(Dublino_en dublino){
        this.dublino_en=dublino;
    }
    
    @Override
    public List<Libro> getLibri() throws DataLayerException{
        return this.libri;
    }
    
    @Override
    public void setLibri(List<Libro> libri){
        this.libri=libri;
    }
    
    @Override
    public void addLibro(Libro libro){
        this.libri.add(libro);
    }
    
    @Override
    public List<Materiale> getMateriale() throws DataLayerException{
        return this.materiale;
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
