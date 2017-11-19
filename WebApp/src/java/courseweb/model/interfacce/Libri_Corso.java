/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.interfacce;

/**
 *
 * @author Tony & Tony
 */
public interface Libri_Corso {
    
    int getCorso();
    
    void setCorso(int corso);
    
    int getLibro();
    
    void setLibro(int libro);
    
    List<Libro> getLibroCollection(int corso);
    
}
