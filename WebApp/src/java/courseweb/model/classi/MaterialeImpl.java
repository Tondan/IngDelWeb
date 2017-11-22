/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.IgwDataLayer;
import java.util.List;

/**
 *
 * @author Toni & Tony
 */
public class MaterialeImpl {
    
    private int id;
    
    private String nome;
    
    private String link;
    
    private String descrizione_it;
    
    private String descrizione_en;
    
    private List<Corso> corsi;
    
    protected IgwDataLayer ownerdatalayer;
    
    public MaterialeImpl(IgwDataLayer ownerdatalayer){
        this.ownerdatalayer=ownerdatalayer;
        this.id=0;
        this.nome=null;
        this.descrizione_en=null;
        this.descrizione_it=null;
        this.link=null;
        this.corsi=null;
    }
    
    public int getID(){
        return this.id;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public String getLink(){
        return this.link;
    }
    
    public void setLink(String link){
        this.link=link;
    }
    
    public String getDescrizione_it(){
        return this.descrizione_it;
    }
    
    public void setDescrizione_it(String descrizione){
        this.descrizione_it=descrizione;
    }
    
    public String getDescrizione_en(){
        return this.descrizione_en;
    }
    
    public void setDescrizione_en(String descrizione){
        this.descrizione_en=descrizione;
    }
    
    public List<Corso> getCorsi() throws DataLayerException{
        return this.corsi;
    }
    
    public void setCorsi(List<Corso> corsi){
        this.corsi=corsi;
    }
    
    public void addCorsi(Corso corso){
        this.corsi.add(corso);
    }
        
}
