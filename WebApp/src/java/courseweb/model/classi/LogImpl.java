/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.Utente;
import java.util.Date;

/**
 *
 * @author Toni & Tony
 */
public class LogImpl {
    
    private int id;
    
    private Date data;
    
    private String descrizione;
    
    private Utente utente;
    
    public LogImpl(){
        this.id=0;
        this.data=null;
        this.descrizione=null;
        this.utente=null;
    }
    
    public int getIDLog(){
        return this.id;
    }
    
    public Date getData(){
        return this.data;
    }
    
    public String getDescrizione(){
        return this.descrizione;
    }
    
    public Utente getUtente() throws DataLayerException{
        return this.utente;
    }
    
    public void setUtente(Utente utente){
        this.utente=utente;
    }
    
    public void setData(Date data){
        this.data=data;
    }
    
    public void setDescrizione(String descrizione){
        this.descrizione=descrizione;
    }
}
