/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.model.interfacce.Servizio;
import courseweb.model.interfacce.Utente;
import java.util.List;

/**
 *
 * @author Toni & Tony
 */
public class GruppoImpl {
    
    private int id;
    
    private String nome;
    
    private List<Utente> utenti;
    
    private List<Servizio> servizi;
    protected IgwDataLayer ownerdatalayer;
    
    public GruppoImpl(IgwDataLayer ownerdatalayer){
        this.ownerdatalayer=ownerdatalayer;
        this.id=0;
        this.nome=null;
        this.utenti=null;
        this.servizi=null;
    }
    
    public int getIDGruppo(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public List<Utente> getUtenti() throws DataLayerException{
        return this.utenti;
    }
    
    public void setUtenti(List<Utente> utenti){
        this.utenti=utenti;
    }
    
    public void addUtente(Utente utente){
        this.utenti.add(utente);
    }
    
    public List<Servizio> getServizi() throws DataLayerException{
        return this.servizi;
    }
    
    public void setServizi(List<Servizio> servizi){
        this.servizi=servizi;
    }
    
    public void addServizio(Servizio servizio){
        this.servizi.add(servizio);
    }
    
}
