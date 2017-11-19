/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.interfacce;

import courseweb.controller.data.DataLayerException;
import java.util.Date;

/**
 *
 * @author Tony
 */
public interface Log {
    
    int getIDLog();
    
    Date getData();
    
    String getDescrizione();
    
    Utente getUtente() throws DataLayerException;
    
    void setUtente(Utente utente);
    
    void setIDLog(int idlog);
    
    void setData(Date data);
    
    void setDescrizione(String Descrizione);
}
