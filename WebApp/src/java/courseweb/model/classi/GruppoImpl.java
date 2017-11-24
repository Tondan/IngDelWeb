/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.Gruppo;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.model.interfacce.Servizio;
import courseweb.model.interfacce.Utente;
import java.util.List;

/**
 *
 * @author Toni & Tony
 */
public class GruppoImpl implements Gruppo{
    
    private int id;
    
    private String nome;
    
    private List<Utente> utenti;
    
    private List<Servizio> servizi;
    
    protected IgwDataLayer ownerdatalayer;
    
    protected boolean dirty;
    
    public GruppoImpl(IgwDataLayer ownerdatalayer){
        this.ownerdatalayer=ownerdatalayer;
        this.id=0;
        this.nome=null;
        this.utenti=null;
        this.servizi=null;
        this.dirty=false;
    }
    
    public int getIDGruppo(){
        return this.id;
    }
    
    public void setIDGruppo(int id){
        this.id=id;
        this.dirty=true;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome=nome;
        this.dirty=true;
    }
    
    public List<Utente> getUtenti() throws DataLayerException{
        if(utenti==null)
            utenti=ownerdatalayer.getUtentiInGruppo(this);
        return utenti;
    }
    
    public void setUtenti(List<Utente> utenti){
        this.utenti=utenti;
        this.dirty=true;
    }
    
    public void addUtente(Utente utente){
        this.utenti.add(utente);
        this.dirty=true;
    }
    
    public List<Servizio> getServizi() throws DataLayerException{
        if(servizi==null)
            servizi=ownerdatalayer.getServiziPerGruppo(this);
        return servizi;
    }
    
    public void setServizi(List<Servizio> servizi){
        this.servizi=servizi;
        this.dirty=true;
    }
    
    public void addServizio(Servizio servizio){
        this.servizi.add(servizio);
        this.dirty=true;
    }
    
}
