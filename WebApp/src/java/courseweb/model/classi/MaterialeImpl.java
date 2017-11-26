/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.Corso;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.model.interfacce.Materiale;
import java.util.List;

/**
 *
 * @author Toni & Tony
 */
public class MaterialeImpl implements Materiale{
    
    private int id;
    
    private String nome;
    
    private String link;
    
    private String descrizione_it;
    
    private String descrizione_en;
    
    private List<Corso> corsi;
    
    protected IgwDataLayer ownerdatalayer;
    
    protected boolean dirty;
    
    public MaterialeImpl(IgwDataLayer ownerdatalayer){
        this.ownerdatalayer=ownerdatalayer;
        this.id=0;
        this.nome=null;
        this.descrizione_en=null;
        this.descrizione_it=null;
        this.link=null;
        this.corsi=null;
        this.dirty=false;
    }
    
    public int getID(){
        return this.id;
    }
    
    public void setID(int id){
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
    
    public String getLink(){
        return this.link;
    }
    
    public void setLink(String link){
        this.link=link;
        this.dirty=true;
    }
    
    public String getDescrizione_it(){
        return this.descrizione_it;
    }
    
    public void setDescrizione_it(String descrizione){
        this.descrizione_it=descrizione;
        this.dirty=true;
    }
    
    public String getDescrizione_en(){
        return this.descrizione_en;
    }
    
    public void setDescrizione_en(String descrizione){
        this.descrizione_en=descrizione;
        this.dirty=true;
    }
    
    public List<Corso> getCorsi() throws DataLayerException{
        if(corsi==null)
            corsi=ownerdatalayer.getCorsiDelMateriale(this);
        return corsi;
    }
    
    public void setCorsi(List<Corso> corsi){
        this.corsi=corsi;
        this.dirty=true;
    }
    
    public void addCorsi(Corso corso){
        this.corsi.add(corso);
        this.dirty=true;
    }

    void setIDCorso(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}
