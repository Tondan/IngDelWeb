/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.interfacce;

/**
 *
 * @author Tony
 */
public interface Servizio {
    
    int getIDServizio();
    
    String getScript();
    
    String Descrizione();
    
    void setIDServizio(int idservizio);
    
    void setScript(String script);
    
    void setDescrizione(String descrizione);
    
    
    
}
