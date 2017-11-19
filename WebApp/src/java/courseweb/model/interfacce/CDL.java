/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courseweb.model.interfacce;
import courseweb.controller.data.DataLayerException;
import java.time.Year;
/**
 *
 @author Toni $ Tony
 */
public interface CDL {
    
    int getIDCDL();
    
    String getNome_it();
    
    void setNome_it(String nome_it);
    
    String getNome_en();
    
    void setNome_en(String nome_en);
    
    int getAnno();

    void setAnno(Year anno);
    
    
}
