/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.interfacce;

import courseweb.controller.data.DataLayerException;
import java.util.List;

/**
 *
 * @author Tony & Tony
 */
public interface Materiale {
    
    int getID();
    
    Corso getCorso(int id_corso) throws DataLayerException;
    
    int getIDCorso();
    
    void setIDCorso(int corso);
    
    String getNome();
    
    void setNome(String nome);
    
    String getLink();
    
    void setLink(String link);
    
    String getDescrizione_it();
    
    void setDescrizione_it(String descrizione_it);
    
    String getDescrizione_en();
    
    void setDescrizione_en(String descrizione_en);
    
    List<Materiale> getCorsiCollection(int id_materiale) throws DataLayerException;
    
}
