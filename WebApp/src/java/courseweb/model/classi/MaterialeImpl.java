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
    
    private int id_corso;
    
    private Corso corso;
    
    private String nome;
    
    private String link;
    
    private String descrizione_it;
    
    private String descrizione_en;
    
    protected IgwDataLayer ownerdatalayer;
    
    protected boolean dirty;
    
    public MaterialeImpl(IgwDataLayer ownerdatalayer){
        this.ownerdatalayer=ownerdatalayer;
        this.id=0;
        this.corso=null;
        this.nome=null;
        this.descrizione_en=null;
        this.descrizione_it=null;
        this.link=null;
        this.dirty=false;
        this.id_corso=-1;
    }
    
    public int getID(){
        return this.id;
    }
    
    public void setID(int id){
        this.id=id;
        this.dirty=true;
    }
    
    @Override
    public Corso getCorso() throws DataLayerException{
        if(corso==null&&id_corso>0)
            corso=ownerdatalayer.getCorso(id_corso);
        return corso;
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

    void setIDCorso(int id_corso) {
        this.id_corso=id_corso;
    }

        
}
