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
    
    private int id_corso;
    
    private String prerequisiti;
    
    private String obiettivi;
    
    private String mod_esame;
    
    private String mod_insegnamento;
    
    private String sillabo;
    
    private String note;
    
    private String homepage;
    
    private String forum;
    
    private String risorse_ext;
    
    protected IgwDataLayer ownerdatalayer;
    
    protected boolean dirty;
    
    
    public Descrizione_enImpl(IgwDataLayer ownerdatalayer){
    this.ownerdatalayer=ownerdatalayer;
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
    this.id_corso=-1;
    this.dirty=false;
}
    
    @Override
    public void setIDCorso(int id_corso){
        this.id_corso=id_corso;
    }

    @Override
    public Corso getCorso() throws DataLayerException{
        if(corso==null)
            corso=ownerdatalayer.getCorso(id_corso);
        return corso;
    }

    @Override
    public void setCorso(Corso corso) {
        this.corso=corso;
        this.dirty=true;
    }

    @Override
    public String getPrerequisiti() {
        return this.prerequisiti;
    }

    @Override
    public void setPrerequisiti(String prerequisiti) {
        this.prerequisiti=prerequisiti;
        this.dirty=true;
    }

    @Override
    public String getObiettivi() {
        return this.obiettivi;
    }

    @Override
    public void setObiettivi(String obiettivi) {
        this.obiettivi=obiettivi;
        this.dirty=true;
    }

    @Override
    public String getMod_Esame() {
        return this.mod_esame;
    }

    @Override
    public void setMod_Esame(String mod_esame) {
        this.mod_esame=mod_esame;
        this.dirty=true;
    }

    @Override
    public String getMod_Insegnamento() {
        return this.mod_insegnamento;
    }

    @Override
    public void setMod_Insegnamento(String mod_insegnamento) {
        this.mod_insegnamento=mod_insegnamento;
        this.dirty=true;
    }

    @Override
    public String getSillabo() {
        return this.sillabo;
    }

    @Override
    public void setSillabo(String sillabo) {
        this.sillabo=sillabo;
        this.dirty=true;
    }

    @Override
    public String getNote() {
        return this.note;
    }

    @Override
    public void setNote(String note) {
        this.note=note;
        this.dirty=true;
    }

    @Override
    public String getHomepage() {
        return this.homepage;
    }

    @Override
    public void setHomepage(String Homepage) {
        this.homepage=Homepage;
        this.dirty=true;
    }

    @Override
    public String getForum() {
        return this.forum;
    }

    @Override
    public void setForum(String forum) {
        this.forum=forum;
        this.dirty=true;
    }

    @Override
    public String getRisorse_Ext() {
        return this.risorse_ext;
    }

    @Override
    public void setRisorse_Ext(String risorse) {
        this.risorse_ext=risorse;
        this.dirty=true;
    }

    @Override
    public void setIDCorso(int id_corso) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
