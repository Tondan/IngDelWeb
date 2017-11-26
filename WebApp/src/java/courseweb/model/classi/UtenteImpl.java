/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.Gruppo;
import courseweb.model.interfacce.IgwDataLayer;
import courseweb.model.interfacce.Utente;

/**
 *
 * @author Toni & Tony
 */
public class UtenteImpl implements Utente{
    
    private int id;
    
    private String username;
    
    private String password;
    
    private String email;
    
    private Gruppo gruppo;
    
    private int id_gruppo;
    
    protected IgwDataLayer ownerdatalayer;
    
    protected boolean dirty;
    
    public UtenteImpl(IgwDataLayer ownerdatalayer){
        this.ownerdatalayer=ownerdatalayer;
        this.id=0;
        this.username=null;
        this.password=null;
        this.email=null;
        this.gruppo=null;
        this.dirty=false;
        this.id_gruppo=-1;
    }
    
    public void setIDGruppo(int id_gruppo){
        this.id_gruppo=id_gruppo;
    }
    
    public int getID(){
        return this.id;
    }
    
    @Override
    public void setID(int id){
        this.id=id;
        this.dirty=true;
    }
    
    @Override
    public String getUsername(){
        return this.username;
    }
    
    @Override
    public String getPassword(){
        return this.password;
    }
    
    @Override
    public String getEmail(){
        return this.email;
    }
    
    @Override
    public Gruppo getGruppo() throws DataLayerException{
        if(gruppo==null&&id_gruppo>=0)
            gruppo=ownerdatalayer.getGruppo(id_gruppo);
        return this.gruppo;
    }

    @Override
    public void setGruppo(Gruppo gruppo){
        this.gruppo=gruppo;
        this.dirty=true;
    }
    
    @Override
    public void setUsername(String username){
        this.username=username;
        this.dirty=true;
    }
    
    @Override
    public void setPassword(String password){
        this.password=password;
        this.dirty=true;
    }
    
    @Override
    public void setEmail(String email){
        this.email=email;
        this.dirty=true;
    }

    @Override
    public void setIDGruppo(int id_gruppo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
