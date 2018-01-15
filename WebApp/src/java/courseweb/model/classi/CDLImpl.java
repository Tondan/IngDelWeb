/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.*;

import java.util.List;

/**
 *
 * @author Toni & Tony
 */


public class CDLImpl implements CDL{
    
    private int id_cdl;
    
    private String nome_it;
    
    private String nome_en;
    
    private int anno;
    
    private int cfu;
    
    private List<Corso> corsi;
    
    private int magistrale;
    
    private String immagine;
    
    private String descrizione_it;
    
    private String descrizione_en;
    
    protected IgwDataLayer ownerdatalayer;
    
    protected boolean dirty;
    
 
    
    public CDLImpl(IgwDataLayer ownerdatalayer){
        this.ownerdatalayer=ownerdatalayer;
        this.id_cdl=0;
        this.nome_it=null;
        this.nome_en=null;
        this.anno=0;
        this.cfu=0;
        this.corsi=null;
        this.dirty=false;
    }
    
    @Override
    public void setIDCDL(int id){
        this.id_cdl=id;
        this.dirty=true;
    }
    
    @Override
    public int getIDCDL(){
        return this.id_cdl;
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
    public int getAnno(){
        return this.anno;
    }
    
    @Override
    public void setAnno(int anno){
        this.anno=anno;
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
    public List<Corso> getCorsiInCdl() throws DataLayerException{
        if(corsi==null)
            corsi=ownerdatalayer.getCorsiInCdl(this);
        return corsi;
    }
    
    @Override
    public void setCorsiInCdl(List<Corso> corsi){
        this.corsi=corsi;
        this.dirty=true;
    }
    
    @Override
    public void addCorsoInCdl(Corso corso){
        this.corsi.add(corso);
        this.dirty=true;
    }

    @Override
    public int getMagistrale() {
        return this.magistrale;
    }

    @Override
    public void setMagistrale(int magistrale) {
       this.magistrale = magistrale;
       this.dirty=true;
    }

    @Override
    public String getImmagine() {
        return this.immagine;
    }

    @Override
    public void setImmagine(String immagine) {
       this.immagine = immagine;
       this.dirty=true;
    }

    @Override
    public String getDescrizione_it() {
        return this.descrizione_it;
    }

    @Override
    public void setDescrizione_it(String descrizione_it) {
       this.descrizione_it = descrizione_it;
       this.dirty=true;
    }

    @Override
    public String getDescrizione_en() {
        return this.descrizione_en;
    }

    @Override
    public void setDescrizione_en(String descrizione_en) {
       this.descrizione_en = descrizione_en;
       this.dirty=true;
    }
}
