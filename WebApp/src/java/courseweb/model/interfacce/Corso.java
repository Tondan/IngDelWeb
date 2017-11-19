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
 * @author Toni & Tony
 */

public interface Corso {
    
    int getID();
    
    CDL getCDL(int id_cdl) throws DataLayerException;
    
    int getIDCDL();
    
    void setIDCDL(int id_cdl);
    
    String getNome_it();
    
    String getNome_en();
    
    void setNome_it(String nome_it);
    
    void setNome_en(String nome_en);
    
    String getSSD();
    
    void setSSD(String ssd);
    
    String getLingua();
    
    void setLingua(String lingua);
    
    int getSemestre();
    
    void setSemestre(String semestre);
    
    int getCfu();
    
    void setCfu(int cfu);
    
    Year getAnno();
    
    void setAnno(Year anno);
    
    char getTipologia();
    
    void setTipologia(char tipologia);

}
