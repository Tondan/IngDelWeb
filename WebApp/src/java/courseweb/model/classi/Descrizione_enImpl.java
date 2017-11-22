/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;
import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.*;

/**
 *
 * @author Toni & Tony
 */
public class Descrizione_enImpl implements Descrizione_en{
    
    private Corso corso;
    
    private String prerequisiti;
    
    private String obiettivi;
    
    private String mod_esame;
    
    private String mod_insegnamento;
    
    private String sillabo;
    
    private String note;
    
    private String homepage;
    
    private String forum;
    
    private String risorse_ext;
    
    
    
    public Descrizione_enImpl(){
    this.corso=null;
    this.prerequisiti=null;
    this.obiettivi=null;
    this.mod_esame=null;
    this.mod_insegnamento=null;
    this.sillabo=null;
    this.note=null;
    this.homepage=null;
    this.forum=null;
    this.risorse_ext=null;
}

    @Override
    public Corso getCorso() throws DataLayerException{
        return this.corso;
    }

    @Override
    public void setCorso(Corso corso) {
        this.corso=corso;
    }

    @Override
    public String getPrerequisiti() {
        return this.prerequisiti;
    }

    @Override
    public void setPrerequisiti(String prerequisiti) {
        this.prerequisiti=prerequisiti;
    }

    @Override
    public String getObiettivi() {
        return this.obiettivi;
    }

    @Override
    public void setObiettivi(String obiettivi) {
        this.obiettivi=obiettivi;
    }

    @Override
    public String getMod_Esame() {
        return this.mod_esame;
    }

    @Override
    public void setMod_Esame(String mod_esame) {
        this.mod_esame=mod_esame;
    }

    @Override
    public String getMod_Insegnamento() {
        return this.mod_insegnamento;
    }

    @Override
    public void setMod_Insegnamento(String mod_insegnamento) {
        this.mod_insegnamento=mod_insegnamento;
    }

    @Override
    public String getSillabo() {
        return this.sillabo;
    }

    @Override
    public void setSillabo(String sillabo) {
        this.sillabo=sillabo;
    }

    @Override
    public String getNote() {
        return this.note;
    }

    @Override
    public void setNote(String note) {
        this.note=note;
    }

    @Override
    public String getHomepage() {
        return this.homepage;
    }

    @Override
    public void setHomepage(String Homepage) {
        this.homepage=Homepage;
    }

    @Override
    public String getForum() {
        return this.forum;
    }

    @Override
    public void setForum(String forum) {
        this.forum=forum;
        
    }

    @Override
    public String getRisorse_Ext() {
        return this.risorse_ext;
    }

    @Override
    public void setRisorse_Ext(String risorse) {
        this.risorse_ext=risorse;
    }
}
