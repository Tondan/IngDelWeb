/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.model.interfacce.Log;
import courseweb.model.interfacce.Utente;
import java.sql.Timestamp;

/**
 *
 * @author Toni & Tony
 */
public class LogImpl implements Log{
    
    private int id;
    
    private Timestamp data;
    
    private String descrizione;
    
    private Utente utente;
    
    private int id_utente;
    
    protected IgwDataLayer ownerdatalayer;
    
    protected boolean dirty;
    
    public LogImpl(IgwDataLayer ownerdatalayer){
        this.ownerdatalayer=ownerdatalayer;
        this.id=0;
        this.data=null;
        this.descrizione=null;
        this.utente=null;
        this.dirty=false;
        this.id_utente=-1;
    }
    
    @Override
    public void setIDUtente(int id_utente){
        this.id_utente=id_utente;
    }
    
    @Override
    public int getIDLog(){
        return this.id;
    }
    
    @Override
    public void setIDLog(int id){
        this.id=id;
        this.dirty=true;
    }
    
    @Override
    public Timestamp getData(){
        return this.data;
    }
    
    @Override
    public String getDescrizione(){
        return this.descrizione;
    }
    
    @Override
    public Utente getUtente() throws DataLayerException{
        if(utente==null&&id_utente>=0)
            utente=ownerdatalayer.getUtente(id_utente);
        return utente;
    }
    
    @Override
    public void setUtente(Utente utente){
        this.utente=utente;
        this.dirty=true;
    }
    
    @Override
    public void setData(Timestamp data){
        this.data=data;
        this.dirty=true;
    }
    
    @Override
    public void setDescrizione(String descrizione){
        this.descrizione=descrizione;
        this.dirty=true;
    }

}
