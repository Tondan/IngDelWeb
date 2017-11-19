/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.interfacce;

import java.time.Year;

/**
 *
 * @author Tony
 */
public interface Libro {
    
    int getIDLibro();
    
    String getAutore();
    
    String getTitolo();
    
    String getVolume();
    
    Year getAnno();
    
    String getEditore();
    
    String getLink();
    
    
    void setAutore(String autore);
    
    void setTitolo(String titolo);
    
    void setVolume(String volume);
    
    void setAnno(Year anno);
    
    void setEditore(String editore);
    
    void setLink(String link);
    
    
    
}
