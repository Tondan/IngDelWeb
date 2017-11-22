/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.classi;

import courseweb.controller.data.DataLayerException;
import courseweb.model.interfacce.Gruppo;

/**
 *
 * @author Toni & Tony
 */
public class UtenteImpl {
    
    private int id;
    
    private String username;
    
    private String password;
    
    private String email;
    
    private Gruppo gruppo;
    
    public UtenteImpl(){
        this.id=0;
        this.username=null;
        this.password=null;
        this.email=null;
        this.gruppo=null;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public Gruppo getGruppo() throws DataLayerException{
        return this.gruppo;
    }

    public void setGruppo(Gruppo gruppo){
        this.gruppo=gruppo;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public void setPassword(String password){
        this.password=password;
    }
    
    public void seTEmail(String email){
        this.email=email;
    }
    
}
