/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.interfacce;
import courseweb.controller.data.DataLayerException;

/**
 *
 * @author Toni & Tony
 */
public interface Utente {
    
    void setIDGruppo(int id_gruppo);
    
    void setID(int id);
    
    int getID();
    
    String getUsername();
    
    String getPassword();
    
    String getEmail();
    
    Gruppo getGruppo() throws DataLayerException;
    
    void setGruppo(Gruppo gruppo);
    
    void setUsername(String username);
    
    void setPassword(String password);
    
    void setEmail(String email);
    
    
}
